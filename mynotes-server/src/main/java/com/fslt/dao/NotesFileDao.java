package com.fslt.dao;

import com.fslt.entity.pojo.File;

import java.util.List;

/**
 * @description: NotesFileDao
 * @date: 2020/6/10 15:12
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesFileDao {

    /**
     * 获取最新文件列表
     *
     * @return
     */
    List<File> getLatestFileList();

}
