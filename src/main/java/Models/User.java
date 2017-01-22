package Models;

import org.springframework.data.annotation.Id;

/**
 * Created by leo on 19/01/2017.
 */
public class User {
    @Id
    private Long id;

    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User {" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                "\'}";
    }
}
