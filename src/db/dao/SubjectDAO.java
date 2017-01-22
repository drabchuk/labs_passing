package db.dao;

import db.entities.Subject;

import java.sql.SQLException;

/**
 * Created by Denis on 22.01.2017.
 */
public interface SubjectDAO {

    Subject getSubject(String name) throws SQLException;

}
