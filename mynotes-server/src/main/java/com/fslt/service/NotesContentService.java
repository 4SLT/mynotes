package com.fslt.service;

import com.fslt.entity.pojo.Content;

import java.util.List;

/**
 * @description: NotesContentService
 * @date: 2020/6/11 14:24
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesContentService {

    /**
     * 获取笔记内容列表
     *
     * @return
     */
    List<Content> getContentList();

}
