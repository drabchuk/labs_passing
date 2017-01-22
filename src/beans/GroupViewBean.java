package beans;

import db.entities.Group;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Denis on 25.12.2016.
 */
@ManagedBean(name = "group_view")
@SessionScoped
public class GroupViewBean {

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String viewGroup(Group group) {
        setGroup(group);
        return "view";
    }

    public String test() {
        return "view";
    }

}
