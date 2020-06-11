package com.fslt.controller;

import com.fslt.entity.pojo.Content;
import com.fslt.result.Result;
import com.fslt.service.NotesContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: NotesContentController
 * @date: 2020/6/11 14:26
 * @author: 林宗雄
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/notesContent")
public class NotesContentController {

    @Resource
    private NotesContentService notesContentService;

    @RequestMapping("/getContentList")
    public Object getContentList(){
        List<Content> list = notesContentService.getContentList();
        return Result.getSuccessResult(list);
    }

}
