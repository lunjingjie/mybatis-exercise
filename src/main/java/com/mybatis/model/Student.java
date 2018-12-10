package com.mybatis.model;

import java.util.List;

public class Student {
    private Integer studentId;
    private String studentName;
    private String gender;

    public Student() {}

    public Student(Integer studentId, String studentName, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
