package com.fslt.controller;

import com.fslt.entity.pojo.Folder;
import com.fslt.result.Result;
import com.fslt.service.NotesFolderService;
import com.fslt.vo.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: NotesFolderController
 * @date: 2020/6/10 14:17
 * @author: 林宗雄
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/notes")
public class NotesFolderController {

    @Resource
    private NotesFolderService notesFolderService;

    @RequestMapping("/getFolderList")
    public Object getFolderList() {
        List<Folder> result = notesFolderService.getFolderList();
        return Result.getSuccessResult(result);
    }


}
