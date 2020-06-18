package com.fslt.service;

import com.fslt.entity.pojo.File;
import com.fslt.entity.vo.FileInfoVO;
import com.fslt.entity.vo.FileVO;
import com.fslt.entity.vo.NewFileVO;

import java.util.List;

/**
 * @description: NotesFileService
 * @date: 2020/6/10 16:06
 * @author: 林宗雄
 * @version: 1.0
 */
public interface NotesFileService {

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
    FileInfoVO getNoteInfoById(Long id);

    /**
     * 根据file_id获取文件内容（包括内容content）
     *
     * @param id
     * @return
     */
    FileInfoVO getFileContentByFileId(Long id);

    /**
     * 根据id修改笔记标题
     *
     * @param vo
     * @return
     */
    Integer updateTitleById(FileInfoVO vo);

    /**
     * 根据id修改笔记标题内容
     *
     * @param vo
     * @return
     */
    Integer saveNote(FileInfoVO vo);

    /**
     * 添加新文件（不包括文件内容）
     *
     * @param vo
     * @return
     */
    Integer addNewFile(NewFileVO vo);

    /**
     * 添加新文件（包括文件内容）
     *
     * @param vo
     * @return
     */
    Integer addNote(NewFileVO vo);

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

}
