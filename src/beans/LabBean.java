package beans;

import db.dao.DAOSingleton;
import db.dao.LabDAO;
import db.entities.Lab;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

@ManagedBean(name = "lab_bean")
@ViewScoped
public class LabBean {

    private LabDAO labDAO;
    private Lab lab;
    private int labId;

    public LabBean() {
        labDAO = DAOSingleton.getInstance().getLabDAO();
        //select id from param
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        String strId = params.get("id");
        this.labId = Integer.valueOf(strId);
        try {
            lab = labDAO.selectLabById(getLabId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLabId() {
        return labId;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public String setLabId(int labId) {
        this.labId = labId;
        return "complete";
    }

    public void dbLabDAO() {
        if (this.labId != 0) {

        }
    }

    public String check() {
        lab.check();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        UserBean userBean = (UserBean)
                facesContext.getApplication()
                        .createValueBinding("#{user}").getValue(facesContext);

        try {
            labDAO.passLab(userBean.getUser(), lab);
        } catch (SQLException e) {
            e.printStackTrace();
            return "already_passed";
        }
        return "result";
    }

}
