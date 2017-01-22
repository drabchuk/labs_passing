package db.entities;

/**
 * Created by Денис on 21.01.2017.
 */
public class Student extends User{

    private Group group;

    public Student(String email, String firstName,
                   String secondName, Group group) {
        super.setEmail(email);
        super.setFirstName(firstName);
        super.setSecondName(secondName);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
