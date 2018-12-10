package com.mybatis.model;

public class Score {

    private Integer id;
    private String subject;
    private int score;
    private Integer studentId;
    private Student student;

    public Score() {
    }

    public Score(Integer id, String subject, int score, Integer studentId, Student student) {
        this.id = id;
        this.subject = subject;
        this.score = score;
        this.studentId = studentId;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", studentId=" + studentId +
                ", student=" + student +
                '}';
    }
}
