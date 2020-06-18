package com.fslt.controller;

import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.*;
import com.fslt.enums.AddTypeEnum;
import com.fslt.result.Result;
import com.fslt.service.NotesFileService;
import com.fslt.service.NotesFolderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: NotesFileController
 * @date: 2020/6/10 15:14
 * @author: 林宗雄
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/notesFile")
public class NotesFileController {

    @Resource
    private NotesFileService notesFileService;
    @Resource
    private NotesFolderService notesFolderService;

    @RequestMapping("/getFileList")
    public Object getFileList() {
        List<File> result = notesFileService.getLatestFileList();
        return Result.getSuccessResult(result);
    }

    @RequestMapping("/getNoteInfoById")
    public Object getNoteInfoById(Long id) {
        FileInfoVO infoVO = notesFileService.getNoteInfoById(id);
        return Result.getSuccessResult(infoVO);
    }

    @RequestMapping("/getFileContentByFileId")
    public Object getFileContentByFileId(Long id) {
        FileInfoVO infoVO = notesFileService.getFileContentByFileId(id);
        return Result.getSuccessResult(infoVO);
    }

    @RequestMapping("/saveNote")
    public Object saveNote(FileInfoVO vo) {
        Integer result = notesFileService.saveNote(vo);
        return Result.getSuccessResult(result, "保存成功");
    }

    @RequestMapping("/addNote")
    public Object addNote(NewFileVO vo) {
        Integer result = notesFileService.addNote(vo);
        return Result.getSuccessResult(result);
    }

    @RequestMapping("/addNew")
    public Object addNew(NewAddVO vo) {
        Integer result = new Integer(0);
        if (vo.getAddType().equals(AddTypeEnum.FOLDER.getTypeName())) {
            NewFolderVO newFolderVO = new NewFolderVO();
            newFolderVO.setFolderName(vo.getName());
            newFolderVO.setParentId(vo.getFolderId());
            result = notesFolderService.addNewFolder(newFolderVO);
        } else if (vo.getAddType().equals(AddTypeEnum.FILE.getTypeName())) {
            NewFileVO newFileVO = new NewFileVO();
            newFileVO.setFolderId(vo.getFolderId());
            newFileVO.setTitle(vo.getName());
            result = notesFileService.addNote(newFileVO);
        }
        return Result.getSuccessResult(result);
    }

    @RequestMapping("/deleteNoteById")
    public Object deleteNoteById(Long id) {
        Integer result = notesFileService.deleteNote(id);
        return Result.getSuccessResult(result);
    }

    @RequestMapping("/updateStarFlag")
    public Object updateStarFlagById(FileVO vo) {
        Integer result = notesFileService.updateStarFlagById(vo);
        return Result.getSuccessResult(result);
    }

}
