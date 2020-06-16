package com.fslt.entity.vo;

import lombok.Data;

/**
 * @description: NewFolderVO
 * @date: 2020/6/16 15:49
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
public class NewFolderVO {

    /**
     * 文件夹名
     */
    private String folderName;

    /**
     * 父节点id
     */
    private Long parentId;

}
