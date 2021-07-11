package company.model;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private String surname;
    private Integer group;

    private List<Course> courseList;

    public Student(String name, String surname, Integer group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public Student(Integer id, String name, String surname, Integer group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group +
                ", courseList=" + courseList +
                '}';
    }
}
