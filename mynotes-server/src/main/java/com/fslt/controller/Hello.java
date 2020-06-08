package com.fslt.controller;

import com.fslt.result.Result;
import com.fslt.vo.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Hello
 * @date: 2020/6/3 14:06
 * @author: 林宗雄
 * @version: 1.0
 */
@RestController
public class Hello {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/getPeople")
    public Object getPeople(Integer num) {
        System.out.println(num);
        People people = new People("林宗雄", 22);
        return Result.getSuccessResult(people);
    }

}
