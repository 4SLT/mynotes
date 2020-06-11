package com.fslt.service.impl;

import com.fslt.dao.NotesFileDao;
import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.FileInfoVO;
import com.fslt.service.NotesFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: NotesFileServiceImpl
 * @date: 2020/6/10 16:08
 * @author: 林宗雄
 * @version: 1.0
 */
@Service
public class NotesFileServiceImpl implements NotesFileService {

    @Resource
    private NotesFileDao notesFileDao;

    @Override
    public List<File> getLatestFileList() {
        return notesFileDao.getLatestFileList();
    }

    @Override
    public FileInfoVO getNoteInfoById(Long id) {
        return notesFileDao.getNoteInfoById(id);
    }

    @Override
    public FileInfoVO getFileContentByFileId(Long id) {
        return notesFileDao.getFileContentByFileId(id);
    }

}
