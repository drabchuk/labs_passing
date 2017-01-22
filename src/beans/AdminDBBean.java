package beans;

import db.dao.DAOSingleton;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Denis on 28.12.2016.
 */
@ManagedBean(name = "adminDB")
@SessionScoped
public class AdminDBBean {

    private boolean isAdminDB = false;
    private String password;
    private String URL;
    private String USER;
    private String PASS;

    public AdminDBBean() {
        URL = DAOSingleton.getInstance().DB_URL;
        USER = DAOSingleton.getInstance().USER;
        PASS = DAOSingleton.getInstance().PASS;
    }

    public boolean isAdminDB() {
        return isAdminDB;
    }

    public String validate() {
        if (password.equals("admindbpass")) {
            this.isAdminDB = true;
            return "manage";
        } else {
            return "error";
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public String getURL() {
        return URL;
    }

    public void saveURL() {
        DAOSingleton.getInstance().DB_URL = URL;
    }

    public void saveUSER() {
        DAOSingleton.getInstance().USER = USER;
    }

    public void savePASS() {
        DAOSingleton.getInstance().PASS = PASS;
    }

}
