package db.dao;

import db.dao.oracle.OracleGroupDAO;
import db.dao.oracle.OracleUserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Denis on 09.12.2016.
 */
public final class OracleDAOFactory extends DAOFactory {
    //public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/study";
    //private static final String USER = "denis";
    //private static final String USER = "hotel_breakfast";
    //private static final String PASS = "qwerty";

    public static Connection createConnection() throws SQLException{
        DAOSingleton dao = DAOSingleton.getInstance();
        return DriverManager.getConnection(dao.DB_URL, dao.USER, dao.PASS);
    }

    @Override
    public UserDAO getUserDAO() {
        return new OracleUserDAO();
    }

    @Override
    public GroupDAO getGroupDAO() {
        return new OracleGroupDAO();
    }
}
