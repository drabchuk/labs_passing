package db.entities;

public class SyllabusElement {

    private int id;
    private String title;
    private int maxMark;

    public SyllabusElement(int id, String title, int maxMark) {
        this.id = id;
        this.title = title;
        this.maxMark = maxMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(int maxMark) {
        this.maxMark = maxMark;
    }
}
