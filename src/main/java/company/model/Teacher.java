package company.model;

import java.util.List;

public class Teacher {
    private Integer id;
    private String name;
    private String surname;
    private Integer experience;

    private List<Course> courseList;

    public Teacher(String name, String surname, Integer experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public Teacher(Integer id, String name, String surname, Integer experience) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", experience=" + experience +
                ", courseList=" + courseList +
                '}';
    }
}
