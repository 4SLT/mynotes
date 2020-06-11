package com.fslt.service.impl;

import com.fslt.dao.NotesContentDao;
import com.fslt.entity.pojo.Content;
import com.fslt.service.NotesContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: NotesContentServiceImpl
 * @date: 2020/6/11 14:25
 * @author: 林宗雄
 * @version: 1.0
 */
@Service
public class NotesContentServiceImpl implements NotesContentService {

    @Resource
    private NotesContentDao notesContentDao;

    @Override
    public List<Content> getContentList() {
        return notesContentDao.getContentList();
    }

    @Override
    public Content getContentById(Long id) {
        return notesContentDao.getContentById(id);
    }

}
