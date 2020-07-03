package com.fslt.canal.service.impl;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.fslt.canal.service.CanalService;
import com.fslt.utils.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * @description: CanalServiceImpl
 * @date: 2020/7/3 9:35
 * @author: 林宗雄
 * @version: 1.0
 */
@Service
public class CanalServiceImpl implements CanalService {

    @Autowired
    private ElasticSearchUtil elasticSearchUtil;

    @Async
    @PostConstruct
    @Override
    public void testPull() {
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(new InetSocketAddress("47.100.138.188", 11111), "example", "canal", "canal");
        int batchSize = 1000;
        int emptyCount = 0;
        try {
            canalConnector.connect();
            canalConnector.subscribe(".*\\..*");
            canalConnector.rollback();
            int totalEmptyCount = 1200;
            while (emptyCount < totalEmptyCount) {
                //获取指定数量的数据
                Message message = canalConnector.getWithoutAck(batchSize);
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    emptyCount++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    emptyCount = 0;
                    printEntry(message.getEntries());
                }
                //提交确认
                canalConnector.ack(batchId);
            }
            System.out.println("empty too many times, exit");
        } finally {
            canalConnector.disconnect();
        }
    }

    private void printEntry(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN
                    || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }

            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }

            CanalEntry.EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(), eventType));

            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    System.out.println("-------> before");
                    printColumn(rowData.getBeforeColumnsList());
                    System.out.println("-------> after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private static void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }


}
