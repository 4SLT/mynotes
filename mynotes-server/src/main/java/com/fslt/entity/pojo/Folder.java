package com.fslt.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Folder
 * @date: 2020/6/10 13:56
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Folder extends BaseInfo {

    /**
     * 文件夹名
     */
    private String folderName;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 用户code
     */
    private String userCode;

    /**
     * 用户id
     */
    private Long userId;

}
