import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class UserList implements Serializable {
    static Scanner input = new Scanner (System.in);
    public static ArrayList<User> arr = new ArrayList<User> ();

    public int addUser(User u, String planInput) {

        if (planInput.contains ("1")) {
            Basic basicPlan = new Basic (u.getID (), "Basic");
            Basic.addSubscription (basicPlan);
            u.subscription = "Basic";
        } else if (planInput.contains ("2")) {
            Standard standardPlan = new Standard (u.getID (), "Standard");
            Standard.addSubscription (standardPlan);
            u.subscription = "Standard";
        } else if (planInput.contains ("3")) {
            Premium premiumPlan = new Premium (u.getID (), "Premium");
            Premium.addSubscription (premiumPlan);
            u.subscription = "Premium";
        }
        arr.add (u);
        return arr.indexOf (u);

    }


    public void deleteUser(int index) {

        if (UserList.arr.get (index).subscription.equals ("Basic")) {
            Basic.deleteSubscription (UserList.arr.get (index).getID ());
        } else if (UserList.arr.get (index).subscription.equals ("Standard")) {
            Standard.deleteSubscription (UserList.arr.get (index).getID ());
        } else if (UserList.arr.get (index).subscription.equals ("Premium")) {
            Premium.deleteSubscription (UserList.arr.get (index).getID ());
        }
        UserWatchRecordList.removeRecords (UserList.arr.get (index).ID);
        arr.remove (index);
    }

    public int userExist(String username, String password) {
        for (User user : arr) {
            if (user.getUserName ().equals (username) && user.getPassword ().equals (password))
                return arr.indexOf (user);

        }
        return -1;
    }

    public int queryUser() {
        System.out.println ("Enter your username :");
        String username = input.next ();
        System.out.println ("Enter your first name :");
        String fName = input.next ();
        System.out.println ("Enter your last name :");
        String lName = input.next ();
        System.out.println ("Enter your password : ");
        String pass = input.next ();
        System.out.println ("Enter your Email: ");
        String email = input.next ();
        System.out.println ("choose one of the following monthly plans:");
        System.out.println ("[1] Basic(5 movies/month)\n[2] Standard(10 movies/month)\t\t[3] Premium(30 movies/month)");
        String planInput = input.next ();
        User u = new User (username, fName, lName, pass, email);
        int newIndex = addUser (u, planInput);
        return newIndex;
    }


    public void userMenu() {
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("\t\t[1] Watch Movie");
        System.out.println ("\t\t[2] Watch Movie later");
        System.out.println ("\t\t[3] Show History");
        System.out.println ("\t\t[4] Show watch later");
        System.out.println ("\t\t[5] See movie details");
        System.out.println ("\t\t[6] Search ");
        System.out.println ("\t\t[7] Most viewed movies");
        System.out.println ("\t\t[8] Delete account");
        System.out.println ("\t\t[9] Update profile");
        System.out.println ("\t\t[10] Add rate");
        System.out.println ("\t\t[11] Resubscribe");
        System.out.println ("\t\t[12] Recent movies");
        System.out.println ("\t\t[13] Top rated movies");
        System.out.println ("\t\t[14] Show profile");
        System.out.println ("\t\t[15] Log out ");
        System.out.println ();
    }

    public void recursiveSearch() {
        System.out.println ("enter the keyword you want to search for:");
        String keyword = input.next ().toLowerCase ();
        System.out.println ("The Results:");
        int found = 0;
        for (Movie movie : MovieList.arr) {
            if (movie.getTitle ().toLowerCase ().contains (keyword)) {
                System.out.println ("-" + movie.getTitle () + " ( movie )");
                found++;
            }
        }
        for (Cast cast : CastList.allActors) {
            if (cast.firstName.toLowerCase ().contains (keyword) || cast.firstName.toLowerCase ().contains (keyword)) {
                System.out.println ("-" + cast.getFirstName () + " " + cast.getLastName () + " ( Actor )");
                found++;
            }
        }
        for (Director director : DirectorList.directorsList) {
            if (director.firstName.toLowerCase ().contains (keyword) || director.firstName.toLowerCase ().contains (keyword)) {
                System.out.println ("-" + director.getFirstName () + " " + director.getLastName () + " ( Actor )");
                found++;
            }
        }
        if (found == 0) {
            System.out.println ("\t\tNo results with the specific keyword");
        }
    }

    public void displayAllUsers() {
        for (User user : arr) {
            System.out.println ((arr.indexOf (user) + 1) + ")" + user.firstName + " " + user.lastName);
        }

    }

    public void updateUserMenu(int index) {
        while (true) {
            System.out.println ("\t\twelcome to the profile update menu");
            System.out.println ("\tplease select one of operations to update the details");
            System.out.println ();
            System.out.println ("[1] Username\t[2] First name");
            System.out.println ();
            System.out.println ("[3] Last Name\t[4] password");
            System.out.println ();
            System.out.println ("[5] email\t[6] Subscription");
            System.out.println ();
            System.out.println ("[7] Back");
            int choice = input.nextInt ();
            if (choice == 7)
                break;
            else if (choice < 1 && choice > 7) {
                System.out.println ("\t\tinvalid operation");
                System.out.println ("\tplease select one of the operations below");
            } else {
                this.updateUser (index, choice);

            }
        }
    }

    public void addRate(int userIndex) {

        if (arr.get (userIndex).historyMovies.size () == 0) {
            System.out.println ("\tyou have not watched movies yet");
            System.out.println ("please watch at least one move so you can rate");
        } else {
            UserList.arr.get (userIndex).showWatchHistory ();
            System.out.println ("Enter the movie you want to add rate for it");
            int movieChoice = input.nextInt ();
            System.out.println ("Enter rate between 1 and 5");
            float rate = input.nextFloat ();
            if (rate < 1 || rate > 5) {
                System.out.println ("\t\tinvalid rate");
            } else {
                int userId = UserList.arr.get (userIndex).getID ();
                String title = MovieList.arr.get (movieChoice - 1).getTitle ();
                float returnRate = UserWatchRecordList.updateRating (userId, title, rate);
                MovieList.arr.get (movieChoice - 1).setRateWatchit (returnRate);
                System.out.println ("\t\tRate added successfully");
            }
        }
    }

    public void updateUser(int index, int choice) {

        if (choice == 1) {
            System.out.println ("\tEnter your new username");
            String s = input.next ();
            arr.get (index).setUserName (s);
        } else if (choice == 2) {
            System.out.println ("\tEnter your new first name");
            String s = input.next ();
            arr.get (index).setFirstName (s);
        } else if (choice == 3) {
            System.out.println ("\tEnter your new last name");
            String s = input.next ();
            arr.get (index).setLastName (s);
        } else if (choice == 4) {
            System.out.println ("\tEnter your new password");
            String s = input.next ();
            arr.get (index).setPassword (s);
        } else if (choice == 5) {
            System.out.println ("\tEnter your new email");
            String s = input.next ();
            arr.get (index).setPassword (s);
        } else if (choice == 6) {
            this.updateSubscription (index);
        }
        System.out.println ("\t\tupdated successfully");

    }

    public void updateSubscription(int index) {
        while (true) {
            System.out.println ("if you sure to change your plan press [1]");
            System.out.println ("if not press [2]");
            int num = input.nextInt ();
            if (num == 2) {
                break;
            } else if (num == 1) {
                String oldsub = UserList.arr.get (index).getSubscription ();
                int id = UserList.arr.get (index).getID ();
                if (oldsub.equals ("Basic")) {
                    System.out.println ("Select your new plan ");
                    System.out.println ("[1] Standard\t[2] Premium");
                    int num2 = input.nextInt ();
                    if (num2 == 1) {
                        Subscription.updateSubscription (id, "Basic", "Standard");
                        UserList.arr.get (index).setSubscription ("Standard");
                    } else if (num2 == 2) {
                        Subscription.updateSubscription (id, "Basic", "Premium");
                        UserList.arr.get (index).setSubscription ("Premium");
                    } else {
                        System.out.println ("\tinvalid operation");
                        System.out.println ("\tplease try again");
                        continue;
                    }
                } else if (oldsub.equals ("Standard")) {
                    System.out.println ("Select your new plan ");
                    System.out.println ("[1] Basic\t[2] Premium");
                    int num2 = input.nextInt ();
                    if (num2 == 1) {
                        Subscription.updateSubscription (id, "Standard", "Basic");
                        UserList.arr.get (index).setSubscription ("Basic");
                    } else if (num2 == 2) {
                        Subscription.updateSubscription (id, "Standard", "Premium");
                        UserList.arr.get (index).setSubscription ("Premium");
                    } else {
                        System.out.println ("\tinvalid operation");
                        System.out.println ("\tplease try again");
                        continue;
                    }
                } else if (oldsub.equals ("Premium")) {
                    System.out.println ("Select your new plan ");
                    System.out.println ("[1] Basic\t[2] Standard");
                    int num2 = input.nextInt ();
                    if (num2 == 1) {
                        Subscription.updateSubscription (id, "Premium", "Basic");
                        UserList.arr.get (index).setSubscription ("Basic");
                    } else if (num2 == 2)
                        Subscription.updateSubscription (id, "Premium", "Standard");
                    UserList.arr.get (index).setSubscription ("Standard");
                } else {
                    System.out.println ("\tinvalid operation");
                    System.out.println ("\tplease try again");
                    continue;
                }
                System.out.println ("\t\tupdated successfully");
                while (UserList.arr.get (index).historyMovies.size () != 0) {
                    UserList.arr.get (index).historyMovies.remove
                            (UserList.arr.get (index).historyMovies.size () - 1);
                }
            } else {
                System.out.println ("\t\tinvalid operation");
                System.out.println ("\tplease select one of the below operations");
            }
        }
    }
}
