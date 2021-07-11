package company;

import company.model.Course;
import company.model.Student;
import company.model.Teacher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Optional;

public class CoursesRepositoryJdbcTemplateImpl implements CoursesRepository {

    private static final String SQL_SELECT_BY_ID_ALL = "select * from course where course.id = ?";

    private static final String SQL_SELECT_ALL = "select * from course ";

    private static final String SQL_UPDATE_COURSE_BY_ID = "update course set name = ?, time = ?,id_teacher = ?;";

    private static final String SQL_ADD_COURSE = "insert into course(name, time, id_teacher) values (?, ?, ?, ?);";


    private final JdbcTemplate jdbcTemplate;

    public CoursesRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Course> courseRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        String time = row.getString("time");
        Integer teacher = row.getInt("teacher");

        Course course = new Course(id, name, time, teacher);
        course.setStudentList(new ArrayList<>());
        return course;
    };

    private final ResultSetExtractor<Course> accountResultSetExtractor = resultSet -> null;


    @Override
    public Optional<Course> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID_ALL, courseRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Course> findAll() {
        try {
            return Optional.of((Course) jdbcTemplate.query(SQL_SELECT_ALL, courseRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Course course) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(SQL_ADD_COURSE, new String[]{"id"});

                    statement.setString(1, course.getName());
                    statement.setString(2, course.getTime());
                    statement.setInt(4, course.getTeacher());
                    return statement;
                }, keyHolder);

        course.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Course course) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COURSE_BY_ID);

                    statement.setString(1, course.getName());
                    statement.setString(2, course.getTime());
                    statement.setInt(3, course.getTeacher());
                    return statement;
                });
    }
}
