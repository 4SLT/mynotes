package com.fslt.controller;

import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.FileInfoVO;
import com.fslt.result.Result;
import com.fslt.service.NotesFileService;
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

    @RequestMapping("/getFileList")
    public Object getFolderList() {
        List<File> result = notesFileService.getLatestFileList();
        return Result.getSuccessResult(result);
    }

    @RequestMapping("/getNoteInfoById")
    public Object getNoteInfoById(Long id) {
        FileInfoVO infoVO = notesFileService.getNoteInfoById(id);
        return Result.getSuccessResult(infoVO);
    }

}
