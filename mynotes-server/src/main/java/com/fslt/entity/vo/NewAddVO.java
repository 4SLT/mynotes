package com.fslt.entity.vo;

import lombok.Data;

/**
 * @description: 新增文件夹或者文件实体类
 * @date: 2020/6/16 15:07
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
public class NewAddVO {

    /**
     * 所属文件夹id
     */
    private Long folderId;

    /**
     * 名字
     */
    private String name;

    /**
     * 新建类型（文件or文件夹）
     * AddTypeEnum
     */
    private String addType;

}
