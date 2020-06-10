package com.fslt.service;

import com.fslt.entity.pojo.File;

import java.util.List;

/**
 * @description: NotesFileService
 * @date: 2020/6/10 16:06
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesFileService {

    /**
     * 获取最新文件列表
     *
     * @return
     */
    List<File> getLatestFileList();

}
