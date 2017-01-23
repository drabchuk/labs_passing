package db.dao;

import db.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    int insertUser(User user) throws SQLException;
    User selectUserByEmail(String email) throws SQLException;
    List<User> selectUsers() throws SQLException;
    List<User> selectStudents() throws SQLException;
    boolean updateUserRole(User user) throws SQLException;
    boolean deleteUser(User user) throws SQLException;

}
