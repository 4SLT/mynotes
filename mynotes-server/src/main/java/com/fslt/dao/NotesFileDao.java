package com.fslt.dao;

import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.FileInfoVO;
import com.fslt.entity.vo.FileVO;
import com.fslt.entity.vo.NewFileVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: NotesFileDao
 * @date: 2020/6/10 15:12
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesFileDao {

    /**
     * 获取最新文件列表
     *
     * @return
     */
    List<File> getLatestFileList();

    /**
     * 根据note_id获取note基本信息
     *
     * @param id
     * @return
     */
    FileInfoVO getNoteInfoById(@Param("id") Long id);

    /**
     * 根据file_id获取文件内容（包括内容content）
     *
     * @param id
     * @return
     */
    FileInfoVO getFileContentByFileId(@Param("id") Long id);

    /**
     * 根据id修改笔记标题
     *
     * @param vo
     * @return
     */
    Integer updateTitleById(FileInfoVO vo);

    /**
     * 添加新文件（不包括文件内容）
     *
     * @param vo
     * @return
     */
    Integer addNewFile(NewFileVO vo);

    /**
     * 根据id删除笔记
     *
     * @param id
     * @return
     */
    Integer deleteNote(Long id);

    /**
     * 根据id修改starFlag
     *
     * @param vo
     * @return
     */
    Integer updateStarFlagById(FileVO vo);

    /**
     * 根据id修改作者
     *
     * @param vo
     * @return
     */
    Integer updateAuthorById(FileInfoVO vo);
}
