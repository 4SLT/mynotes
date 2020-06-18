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
     * 内容id
     */
    private Long contentId;

    /**
     * 作者
     */
    private String author;

    /**
     * 用户code
     */
    private String userCode;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 星标/收藏标识（0否；1是）
     */
    private Boolean starFlag;

}
