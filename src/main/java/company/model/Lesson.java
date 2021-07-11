package company.model;

public class Lesson {
    private Integer id;
    private String name;
    private String time;
    private Integer course;

    public Lesson(String name, String time, Integer course) {
        this.name = name;
        this.time = time;
        this.course = course;
    }

    public Lesson(Integer id, String name, String time, Integer course) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.course = course;
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

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", course=" + course +
                '}';
    }
}
