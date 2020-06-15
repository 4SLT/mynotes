package com.fslt.service.impl;

import com.fslt.dao.NotesFileDao;
import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.FileInfoVO;
import com.fslt.entity.vo.NewFileVO;
import com.fslt.service.NotesContentService;
import com.fslt.service.NotesFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private NotesContentService notesContentService;


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

    @Override
    public Integer updateTitleById(FileInfoVO vo) {
        return notesFileDao.updateTitleById(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveNote(FileInfoVO vo) {
        Integer result1 = this.updateTitleById(vo);
        Integer result2 = notesContentService.updateContentById(vo);
        return result1 * result2;
    }

    @Override
    public Integer addNewFile(NewFileVO vo) {
        return notesFileDao.addNewFile(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addNote(NewFileVO vo) {
        notesContentService.addNewFileContent(vo);
        Integer result = this.addNewFile(vo);
        return result;
    }

}
