import java.io.Serializable;

public class Director extends Staff implements Serializable{


    public Director(String firstName, String lastName, String gender, String nationality, int age) {
        super (firstName, lastName, gender, nationality, age);
    }

    @Override
    public String toString() {
        return "Director{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", movies=" + movies +
                '}';
    }
}
