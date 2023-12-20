import java.io.Serializable;
import java.util.Scanner;

public class Admin implements Serializable {
    static Scanner input = new Scanner (System.in);
    public static int number_of_admins = 0;
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public static int getNumber_of_admins() {
        return number_of_admins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        number_of_admins++;
        this.id = number_of_admins;
    }

    public void adminDetails()
    { while(true) {
        System.out.println ("Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}');
        System.out.println ();
        System.out.println ("\t\tselect back to return");
        System.out.println ("\t[1] Back");
        int num =input.nextInt();
        if(num==1)
            break;
        else
        {
            System.out.println ("\t\tinvalid operation");
            System.out.println ("\t\tplease enter [1] to back");
        }
    }
    }

}
