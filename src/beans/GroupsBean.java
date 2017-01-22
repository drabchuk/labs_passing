package beans;

import db.dao.DAOSingleton;
import db.dao.GroupDAO;
import db.entities.Group;
import model.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Denis on 24.12.2016.
 */
@ManagedBean(name = "groups")
@RequestScoped
public class GroupsBean {

    private List<Group> groupList;
    private GroupDAO groupDAO;

    public GroupsBean() {
        groupDAO = DAOSingleton.getInstance().getGroupDAO();
        try {
            groupList = groupDAO.getAllGroups();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public String viewGroup(Group group) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        GroupViewBean groupViewBean = (GroupViewBean)
                facesContext.getApplication()
                        .createValueBinding("#{group_view}").getValue(facesContext);
        groupViewBean.setGroup(group);
        return "view";
    }
}
