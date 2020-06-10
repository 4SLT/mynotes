package com.fslt.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: File
 * @date: 2020/6/10 15:15
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File extends BaseInfo {

    /**
     * 所属文件夹id
     */
    private Long folderId;

    /**
     * 唯一标识
     */
    private String uniqueCode;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 用户code
     */
    private String userCode;

    /**
     * 用户id
     */
    private Long userId;
}
