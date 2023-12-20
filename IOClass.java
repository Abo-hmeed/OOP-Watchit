import java.io.*;
import java.util.ArrayList;

public class IOClass {

    public static void OutputData(AdminList a) throws IOException {
        File file = new File("adminList.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(a.arrAdmin);
        oos.close();

        file = new File("movieList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(MovieList.allMovies);
        oos.close();

        file = new File("castList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(CastList.allActors);
        oos.close();

        file = new File("userList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(UserList.arr);
        oos.close();

        file = new File("directorList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(DirectorList.directorsList);
        oos.close();
    }

    public static void InputData() throws IOException, ClassNotFoundException {
        File file = new File("adminList.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        AdminList.arrAdmin = (ArrayList<Admin>) ois.readObject();
        ois.close();

        file = new File("movieList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        MovieList.allMovies = (ArrayList<Movie>) ois.readObject();
        ois.close();

        file = new File("castList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        CastList.allActors = (ArrayList<Staff>) ois.readObject();
        ois.close();

        file = new File("userList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        UserList.arr = (ArrayList<User>) ois.readObject();
        ois.close();

        file = new File("directorList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        DirectorList.directorsList = (ArrayList<Director>) ois.readObject();
        ois.close();
    }

}
