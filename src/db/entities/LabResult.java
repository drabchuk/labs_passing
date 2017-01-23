package db.entities;

/**
 * Created by Denis on 23.01.2017.
 */
public class LabResult {

    private Lab lab;
    private int result;

    public LabResult(Lab lab, int result) {
        this.lab = lab;
        this.result = result;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
