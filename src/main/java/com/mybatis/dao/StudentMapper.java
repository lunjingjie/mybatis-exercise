package com.mybatis.dao;

import com.mybatis.model.Score;
import com.mybatis.model.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 插入student
     * @param student
     */
    void insertStud(Student student);

    /**
     * 根据stundent_id查询student信息
     * @param id
     * @return
     */
    Student selectStudById(Integer id);

    /**
     * 获取指定学生的成绩list
     * @return
     */
    List<Score> getStudentSubList(Integer id);

    /**
     * 插入成绩
     * @param score
     */
    void insertScore(Score score);
}
