package com.fslt.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: NewFileVO
 * @date: 2020/6/15 17:37
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewFileVO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 唯一标识
     */
    private String uniqueCode;

    /**
     * 标题
     */
    private String title;

    /**
     * 所属文件夹id
     */
    private Long folderId;

    /**
     * 内容id
     */
    private Long contentId;

}
