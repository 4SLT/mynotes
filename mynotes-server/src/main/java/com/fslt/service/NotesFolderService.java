package com.fslt.service;

import com.fslt.entity.pojo.Folder;
import com.fslt.entity.vo.NewFolderVO;

import java.util.List;

/**
 * @description: NotesFolderService
 * @date: 2020/6/10 14:14
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesFolderService {

    /**
     * 查询文件夹列表
     *
     * @return
     */
    List<Folder> getFolderList();

    /**
     * 新增文件夹
     *
     * @param vo
     * @return
     */
    Integer addNewFolder(NewFolderVO vo);

}
