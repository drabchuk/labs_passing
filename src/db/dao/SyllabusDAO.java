package db.dao;

import db.entities.Lab;
import db.entities.SyllabusElement;

import java.sql.SQLException;
import java.util.List;

public interface SyllabusDAO {

    List<SyllabusElement> getSyllabus() throws SQLException;
    void deleteLab(SyllabusElement lab) throws SQLException;

}
