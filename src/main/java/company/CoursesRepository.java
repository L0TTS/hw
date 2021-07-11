package company;

import company.model.Course;
import company.model.Student;

import java.util.Optional;

public interface CoursesRepository {
    Optional<Course> findById(Integer id);
    Optional<Course> findAll();
    void save(Course course);
    void update(Course course);
}
