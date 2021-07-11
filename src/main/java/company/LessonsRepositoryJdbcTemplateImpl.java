package company;

import company.model.*;
import company.model.Lesson;
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

public class LessonsRepositoryJdbcTemplateImpl implements LessonsRepository {

    private static final String SQL_SELECT_BY_ID_ALL = "select * from lesson where lesson.id = ?";

    private static final String SQL_SELECT_ALL = "select * from lesson ";

    private static final String SQL_UPDATE_LESSON_BY_ID = "update lesson set name = ?, time = ?, id = ? where id = ?;";

    private static final String SQL_ADD_LESSON = "insert into lesson(name, time, course) values (?, ?, ?);";


    private final JdbcTemplate jdbcTemplate;

    public LessonsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Lesson> lessonRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        String time = row.getString("time");
        int course = row.getInt("course");
        return new Lesson(id, name, time, course);
    };

    private final ResultSetExtractor<Lesson> accountResultSetExtractor = resultSet -> null;

    @Override
    public Optional<Lesson> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID_ALL, lessonRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Lesson> findAll() {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID_ALL, lessonRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Lesson lesson) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(SQL_ADD_LESSON, new String[]{"id"});

                    statement.setString(1, lesson.getName());
                    statement.setString(2, lesson.getTime());
                    statement.setInt(3, lesson.getCourse());
                    return statement;
                }, keyHolder);
        lesson.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Lesson lesson) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LESSON_BY_ID);

                    statement.setString(1, lesson.getName());
                    statement.setString(2, lesson.getTime());
                    statement.setInt(3, lesson.getCourse());
                    statement.setInt(4, lesson.getId());
                    return statement;
                });
    }
}
