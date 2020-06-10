package com.fslt.controller;

import com.fslt.result.Result;
import com.fslt.vo.File;
import com.fslt.vo.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Hello
 * @date: 2020/6/3 14:06
 * @author: 林宗雄
 * @version: 1.0
 */
@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/getPeople")
    public Object getPeople(String searchInput) {
        System.out.println(searchInput);
        People people = new People("林宗雄", 22);
        return Result.getSuccessResult(people);
    }

    @RequestMapping("/searchTest")
    public Object searchTest(String searchInput) {
        System.out.println(searchInput);
        int index = 0;
        List<File> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            File file = new File("文件" + searchInput + index++);
            list.add(file);
        }
        return Result.getSuccessResult(list);
    }

}
