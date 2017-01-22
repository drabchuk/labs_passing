package db.dao;

import db.entities.Group;
import db.entities.Syllabus;

import java.sql.SQLException;

/**
 * Created by Denis on 22.01.2017.
 */
public interface SyllabusDAO {

    Syllabus getSyllabusByGroup(Group group) throws SQLException;

}
