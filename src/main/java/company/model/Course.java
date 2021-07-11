package company.model;

import java.util.List;

public class Course {
    private Integer id;
    private String name;
    private String time;
    private Integer teacher;

    private List<Student> studentList;

    public Course(Integer id, String name, String time, Integer teacher) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.teacher = teacher;
    }

    public Course(String name, String time, Integer teacher) {
        this.name = name;
        this.time = time;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}
