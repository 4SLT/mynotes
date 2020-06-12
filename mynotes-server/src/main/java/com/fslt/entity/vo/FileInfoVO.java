package com.fslt.entity.vo;

import com.fslt.entity.pojo.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: FileInfoVO
 * @date: 2020/6/11 11:09
 * @author: 林宗雄
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoVO extends File {

    /**
     * 文件夹名
     */
    private String folderName;

    /**
     * markdown格式内容
     */
    private String contentMd;

    /**
     * html格式内容
     */
    private String contentHtml;

}
