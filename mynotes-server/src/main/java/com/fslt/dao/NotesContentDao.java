package com.fslt.dao;

import com.fslt.entity.pojo.Content;
import com.fslt.entity.vo.FileInfoVO;
import com.fslt.entity.vo.NewFileVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: NotesContentDao
 * @date: 2020/6/11 14:19
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesContentDao {

    /**
     * 获取笔记内容列表
     *
     * @return
     */
    List<Content> getContentList();


    /**
     * 根据id获取笔记内容
     *
     * @param id
     * @return
     */
    Content getContentById(@Param("id") Long id);

    /**
     * 根据content_id更新笔记内容
     *
     * @param vo
     * @return
     */
    Integer updateContentById(FileInfoVO vo);

    /**
     * 新增文件内容
     *
     * @param vo
     * @return
     */
    Integer addNewFileContent(NewFileVO vo);

}
