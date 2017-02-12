package db.dao;

import db.entities.*;

import java.sql.SQLException;
import java.util.List;

public interface LabDAO {

    Lab selectLabById(int id) throws SQLException;
    void passLab(User user, Lab lab) throws SQLException;
    List<StudentResult> getStudentResults() throws SQLException;
    StudentResult getDinary() throws SQLException;
    void addNewQuestion(int labId, Question question) throws SQLException;

}
