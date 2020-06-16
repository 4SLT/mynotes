package com.fslt.enums;

import lombok.Data;

/**
 * @description: AddTypeEnum
 * @date: 2020/6/16 15:16
 * @author: 林宗雄
 * @version: 1.0
 */
public enum AddTypeEnum {

    FOLDER(1, "folder"),
    FILE(2, "file"),
    ;

    private Integer index;
    private String typeName;

    AddTypeEnum(Integer index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
