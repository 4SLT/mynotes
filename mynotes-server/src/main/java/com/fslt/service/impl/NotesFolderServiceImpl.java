package com.fslt.service.impl;

import com.fslt.dao.NotesFolderDao;
import com.fslt.entity.pojo.Folder;
import com.fslt.service.NotesFolderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: NotesFolderServiceImpl
 * @date: 2020/6/10 14:15
 * @author: 林宗雄
 * @version: 1.0
 */
@Service
public class NotesFolderServiceImpl implements NotesFolderService {

    @Resource
    private NotesFolderDao notesFolderDao;

    @Override
    public List<Folder> getFolderList() {
        return notesFolderDao.getFolderList();
    }

}
