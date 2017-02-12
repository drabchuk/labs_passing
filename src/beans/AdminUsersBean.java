package beans;

import db.dao.DAOSingleton;
import db.dao.UserDAO;
import db.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "adminUsers")
@RequestScoped
public class AdminUsersBean {

    List<User> users;
    UserDAO userDAO;
    String userString;

    public AdminUsersBean() {
        userDAO = DAOSingleton.getInstance().getUserDAO();
        try {
            this.users = userDAO.selectUsers();
            userString = "";
            for (User u: users) {
                userString += u.getEmail() + ", ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean setRole(User user) {
        try {
            return userDAO.updateUserRole(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(User user) {
        try {
            return userDAO.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getUserString() {
        return userString;
    }

    public void setUserString(String userString) {
        this.userString = userString;
    }
}
