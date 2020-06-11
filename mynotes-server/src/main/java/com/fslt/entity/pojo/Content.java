package com.fslt.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Content
 * @date: 2020/6/11 14:12
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content extends BaseInfo {

    /**
     * 笔记内容
     */
    private String content;

}
