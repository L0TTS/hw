package company;

import company.model.Lesson;
import company.model.Teacher;

import java.util.Optional;

public interface LessonsRepository {
    Optional<Lesson> findById(Integer id);
    Optional<Lesson> findAll();
    void save(Lesson lesson);
    void update(Lesson lesson);

}
