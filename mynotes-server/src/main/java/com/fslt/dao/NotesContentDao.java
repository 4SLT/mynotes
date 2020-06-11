package com.fslt.dao;

import com.fslt.entity.pojo.Content;

import java.util.List;

/**
 * @description: NotesContentDao
 * @date: 2020/6/11 14:19
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesContentDao {

    /**
     * 获取笔记内容列表
     *
     * @return
     */
    List<Content> getContentList();

}
