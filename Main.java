import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main implements Serializable {
    static Scanner input = new Scanner (System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AdminList a1 = new AdminList();

        MovieList m1 = new MovieList();
        CastList c1 = new CastList ();
        UserList u1 = new UserList ();
        DirectorList d1 = new DirectorList ();
        System.out.println (a1.toString ());
        try{
            IOClass.InputData();
        }
        catch(IOException e){
            AdminList.arrAdmin.add(new Admin ("admin", "admin", "", "", "email"));
            UserList.arr.add(new User ("admin", "admin", "", "", "email"));
        }



        while (true) {
            boolean adminExist = false;
            int userIndex = -1;

            System.out.println ("\t\t welcome to  Watchit");
            System.out.println ("\t\t have a good day");
            System.out.println ("\t[1] Log in");
            System.out.println ("\t[2] Sign up");
            System.out.println ("\t[3] exit");
            int choice = input.nextInt ();
            if (choice == 3) //exit
                break;
            else if (choice == 1) //log in
            {
                while (true) {

                    System.out.flush ();
                    System.out.println ("Enter your username");
                    String username = input.next ();
                    System.out.println ("Enter your password");
                    String password = input.next ();
                    adminExist = a1.adminExist (username, password);
                    userIndex = u1.userExist (username, password);

                    if (userIndex != -1 || adminExist) {
                        break;
                    } else {
                        System.out.println ("\t\tinvalid username or password");
                        System.out.println ("\t\tplease try again");
                        continue;
                    }
                }
            } else if (choice == 2) //sign up user
            {
                userIndex = u1.queryUser ();
            }

            while (adminExist) {
                a1.adminGeneralMenu ();
                choice = input.nextInt ();
                if (choice == 5)
                    break;
                else if (choice == 1) {
                    while (true) {
                        MovieList.displayAllMovies ();
                        MovieList.movieMenu ();
                        choice = input.nextInt ();
                        if (choice == 1) {
                            m1.queryNewMovie();
                            continue;
                        } else if (choice == 2) {
                            System.out.println ("please select one movies to update");
                            int index = input.nextInt ();
                            m1.updateMoviesMenu (index);
                            continue;
                        } else if (choice == 3) {
                            System.out.println ("please select one movie to remove");
                            int index = input.nextInt ();
                            m1.deleteMovie (index);
                            continue;
                        } else if (choice == 4) {
                            System.out.println ("enter the movie you want to see its details");
                            int index = input.nextInt ();
                            m1.showMovieDetails (index);
                        } else if (choice == 5) {
                            break;

                        }
                    }

                } else if (choice == 2) {

                    while (true) {
                        CastList.displayAllActors ();
                        c1.castMenu ();
                        choice = input.nextInt ();
                        if (choice == 1) {
                            c1.queryNewCast();
                            continue;
                        } else if (choice == 2) {
                            System.out.println ("please select one cast to update");
                            int index = input.nextInt ();
                            c1.updateCastsMenu (index);
                            continue;
                        } else if (choice == 3) {
                            System.out.println ("please select one actor to remove");
                            int index = input.nextInt ();
                            c1.delete (CastList.allActors ,index);
                            continue;
                        } else if (choice == 4) {
                            System.out.println ("enter the cast you want to see its details");
                            int index = input.nextInt ();
                            c1.showActorDetails (index);
                        } else if (choice == 5) {
                            break;

                        }
                    }

                } else if (choice == 3) {

                    while (true) {
                        d1.displayAllDirectors ();
                        d1.directorMenu ();
                        choice = input.nextInt ();
                        if (choice == 1) {
                            d1.queryNewDirector();
                            continue;
                        } else if (choice == 2) {
                            System.out.println ("please select one director to update");
                            int index = input.nextInt ();
                            d1.updateDirectorsMenu (index);
                            continue;
                        } else if (choice == 3) {
                            System.out.println ("please select one director to remove");
                            int index = input.nextInt ();
                            d1.delete (DirectorList.directorsList,index);
                            continue;
                        } else if (choice == 4) {
                            System.out.println ("enter the director you want to see its details");
                            int index = input.nextInt ();
                            d1.showDirectorDetails (index);
                        } else if (choice == 5) {
                            break;

                        }
                    }
                } else if (choice == 4) {
                    while (true) {
                        a1.adminMenu ();
                        choice = input.nextInt ();
                        if (choice == 1)
                            a1.newAdmin ();
                        else if (choice == 2) {
                            Subscription.monthMostRevnue ();
                        } else if (choice == 3) {
                            Subscription.mostSuscribedPlan ();
                        } else if (choice == 4) {
                            a1.displayAllAdmins ();
                        } else if (choice == 5) {
                            a1.diplayAdmins ();
                            System.out.println ("\t\tselect an admin to update");
                            int num = input.nextInt ();
                            a1.updateAdminMenu (num);
                        } else if (choice == 6) {
                            a1.diplayAdmins ();
                            System.out.println ("\t\tselect an admin to delete");
                            int num = input.nextInt ();
                            a1.deleteAdmin (num);
                        } else if (choice == 7) {
                            a1.diplayAdmins ();
                            System.out.println ("\t\tselect an admin to see his/her details");
                            int num = input.nextInt ();
                            a1.arrAdmin.get (num - 1).adminDetails ();
                        } else if (choice == 8) {
                            break;
                        } else {
                            System.out.println ("\t\tinvalid operation");
                            System.out.println ("\tplease select only one of the operations below");
                            continue;
                        }
                    }
                }


            }
            while (userIndex != -1) {

                u1.userMenu ();

                choice = input.nextInt ();

                if (choice == 1)  // watch movie
                {
                    MovieList.displayAllMovies ();
                    System.out.println ("Enter the number movie you want to watch:");
                    int movieChoice = input.nextInt ();
                    UserList.arr.get (userIndex).watchMovie (userIndex, movieChoice - 1);
                } else if (choice == 2) {  // watch movie later

                    MovieList.displayAllMovies ();
                    System.out.println ("Enter the number movie you want to watch later:");
                    int movieChoice = input.nextInt ();
                    UserList.arr.get (userIndex).watchMovieLater (movieChoice - 1);

                } else if (choice == 3) {       // show History

                    UserList.arr.get (userIndex).showWatchHistory ();

                } else if (choice == 4) {       // show watch later

                    UserList.arr.get (userIndex).showWatchLater ();

                } else if (choice == 5) {       // see movie details

                    MovieList.displayAllMovies ();
                    System.out.println ("Enter the movie you want to see it's details:");
                    int movieChoice = input.nextInt ();
                    MovieList.allMovies.get (movieChoice - 1).displayMovieDetails ();

                } else if (choice == 6) {       // search
                    u1.recursiveSearch ();

                } else if (choice == 7) {       // most viewed movies
                   m1.displayTopWatchedMovies ();

                } else if (choice == 8) {       // delete user
                    u1.deleteUser (userIndex);
                    break;

                } else if (choice == 9) {       // update user
                    u1.updateUserMenu (userIndex);

                } else if (choice == 10) {       // add rate
                    u1.addRate (userIndex);

                } else if (choice == 11) {       // Resubscribe
                    Subscription.subscribeAgain (userIndex);

                } else if (choice == 12) {       // Recent movies
                    m1.displayRecentMovies ();

                } else if (choice == 13) {       // Top rated movies
                    m1.displayTopRatedMovies ();

                }
                else if (choice == 14) {       // Show profile
                    System.out.println (UserList.arr.get (userIndex).toString ());
                    System.out.println ();

                }else if (choice == 15) { //break;
                    break;

                }

            }


        }
        IOClass.OutputData(a1);
    }
}
