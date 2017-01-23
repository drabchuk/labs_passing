package beans;

import db.dao.DAOSingleton;
import db.dao.SyllabusDAO;
import db.entities.SyllabusElement;

import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ResultBean {
    private int result;

    public ResultBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        String strId = params.get("score");
        this.result = Integer.valueOf(strId);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
