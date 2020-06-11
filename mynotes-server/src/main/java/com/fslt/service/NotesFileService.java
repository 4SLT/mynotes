package com.fslt.service;

import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.FileInfoVO;

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

    /**
     * 根据note_id获取note基本信息
     *
     * @param id
     * @return
     */
    FileInfoVO getNoteInfoById(Long id);

    /**
     * 根据file_id获取文件内容（包括内容content）
     *
     * @param id
     * @return
     */
    FileInfoVO getFileContentByFileId(Long id);
}
