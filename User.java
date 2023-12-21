import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
    Basic b = new Basic ();
    Standard st = new Standard ();
    Premium pr = new Premium ();
    public final int ID;
    public static int instance = 0;
    public String userName;
    private String password;
    public String firstName;
    public String lastName;
    public String email;
    public String subscription;
    public int moviesWatched;
    public ArrayList<Movie> laterMovies = new ArrayList<Movie> ();
    public ArrayList<Movie> historyMovies = new ArrayList<Movie> ();


    static Scanner input = new Scanner (System.in);

    public User() {
        instance++;
        ID = instance;
    }

    public User(String userName, String firstName, String lastName, String password, String email) {
        this ();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;

    }

    public ArrayList<Movie> getLaterMovies() {
        return laterMovies;
    }

    public void setLaterMovies(ArrayList<Movie> laterMovies) {
        this.laterMovies = laterMovies;
    }

    public ArrayList<Movie> getHistoryMovies() {
        return historyMovies;
    }

    public void setHistoryMovies(ArrayList<Movie> historyMovies) {
        this.historyMovies = historyMovies;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public void showWatchHistory() {
        for (Movie m : historyMovies) {
            System.out.println ((historyMovies.indexOf (m) + 1) + ")" + m.getTitle ());
        }
    }

    public void showWatchLater() {
        for (Movie m : laterMovies) {
            System.out.println ((historyMovies.indexOf (m) + 1) + ")" + m.getTitle ());
        }
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

    public void watchMovie(int userIndex, int movieIndex) {
        int userId1 = UserList.arr.get (userIndex).getID ();
        if (UserList.arr.get (userIndex).getSubscription ().equals ("Basic")) {
            if (b.subDays (userId1) == false) {
                System.out.print ("you have passed 30 days");
                System.out.print ("you need to subscribe again");
                System.out.println ();
            } else if (b.maxWatch (UserList.arr.get (userIndex).getHistoryMovies ()) == false) {
                System.out.println ("sorry, " + UserList.arr.get (userIndex).getUserName ());
                System.out.println ("you have reached your maximum watching movies");
            } else {
                MovieList.allMovies.get (movieIndex).increaseViews ();
                historyMovies.add (MovieList.allMovies.get (movieIndex));
                System.out.println ("\tWatched successfully");
                UserWatchRecord uwr = new UserWatchRecord (userId1,
                        MovieList.allMovies.get (movieIndex).getTitle ());
                UserWatchRecordList.addRecord (uwr);
            }
        } else if (UserList.arr.get (userIndex).getSubscription ().equals ("Standard")) {
            if (st.subDays (userId1) == false) {
                System.out.print ("you have passed 30 days");
                System.out.print ("you need to subscribe again");
                System.out.println ();
            } else if (st.maxWatch (UserList.arr.get (userIndex).getHistoryMovies ()) == false) {
                System.out.println ("sorry, " + UserList.arr.get (userIndex).getUserName ());
                System.out.println ("you have reached your maximum watching movies");
            } else {
                MovieList.allMovies.get (movieIndex).increaseViews ();
                historyMovies.add (MovieList.allMovies.get (movieIndex));
                System.out.println ("\tWatched successfully");
                UserWatchRecord uwr = new UserWatchRecord (userId1,
                        MovieList.allMovies.get (movieIndex).getTitle ());
                UserWatchRecordList.addRecord (uwr);
            }
        } else if (UserList.arr.get (userIndex).getSubscription ().equals ("Premium")) {
            if (pr.subDays (userId1) == false) {
                System.out.print ("you have passed 30 days");
                System.out.print ("you need to subscribe again");
                System.out.println ();
            } else if (pr.maxWatch (UserList.arr.get (userIndex).getHistoryMovies ()) == false) {
                System.out.println ("sorry, " + UserList.arr.get (userIndex).getUserName ());
                System.out.println ("you have reached your maximum watching movies");

            } else {
                MovieList.allMovies.get (movieIndex).increaseViews ();
                historyMovies.add (MovieList.allMovies.get (movieIndex));
                System.out.println ("\tWatched successfully");
                UserWatchRecord uwr = new UserWatchRecord (userId1,
                        MovieList.allMovies.get (movieIndex).getTitle ());
                UserWatchRecordList.addRecord (uwr);
            }
        }

    }

    public void watchMovieLater(int movieIndex) {
        laterMovies.add (MovieList.allMovies.get (movieIndex));
        System.out.println ("movie is added to later movies successfully!");
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subscription='" + subscription + '\'' +
                '}';
    }
}
