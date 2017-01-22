package db.dao;

import db.entities.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Denis on 22.01.2017.
 */
public interface GroupDAO {

    List<Group> getAllGroups() throws SQLException;

}
