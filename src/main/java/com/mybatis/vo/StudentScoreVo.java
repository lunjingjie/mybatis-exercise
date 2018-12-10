package com.mybatis.vo;

import com.mybatis.model.Score;

import java.util.List;

public class StudentScoreVo {

    private String studentName;
    private List<Score> subjectList;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Score> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Score> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "StudentScoreVo{" +
                "studentName='" + studentName + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
