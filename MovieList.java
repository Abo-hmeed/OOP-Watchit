import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieList implements Serializable {
    static Scanner input = new Scanner (System.in);
    public static ArrayList<Movie> allMovies = new ArrayList<> ();

    public void queryNewMovie() {
        System.out.println ("Fulfill the movie details");
        System.out.println ();
        System.out.println ("enter imdbScore");
        int imdbScore = input.nextInt ();
        System.out.println ("enter movie budget");
        int budget = input.nextInt ();
        System.out.println ("enter revenue");
        int revenue = input.nextInt ();
        System.out.println ("enter movie title");
        String title = input.next ();
        System.out.println ("enter release");
        String date = input.next ();
        System.out.println ("enter duration");
        String duration = input.next ();
        System.out.println ("enter the country");
        String country = input.next ();
        Movie m = new Movie (imdbScore, budget, revenue, title, date, duration, country);
        addMovie (m);
    }

    public void deleteMovie(int index){
        allMovies.remove(allMovies.get(index - 1));
    }
    public static void addMovie(Movie m) {
        allMovies.add (m);
    }

    public ArrayList<Movie> getArr() {
        return allMovies;
    }

    public void setArr(ArrayList<Movie> arr) {
        this.allMovies = arr;
    }

    public static void movieMenu() {
        System.out.println ("\t\tplease select on of the operations below");
        System.out.println ();
        System.out.println ("[1] Add movie");
        System.out.println ("[2] update movie");
        System.out.println ("[3] remove movie");
        System.out.println ("[4] show move details");
        System.out.println ("[5] back");
    }

    public static void displayAllMovies() {
        System.out.println ("\t\t\t\t welcome to movies");
        if (allMovies.isEmpty ()) {
            System.out.println ("\t\t\t\tthere is no movie right now");
        } else {
            for (int i = 0; i < allMovies.size (); i++) {
                System.out.println ("[" + (i + 1) + "] " + allMovies.get (i).getTitle ());
            }
        }
    }


    public void showMovieDetails(int index) {
        allMovies.get (index - 1).displayMovieDetails ();
    }

    public void movieDetailsMenu(int index) {
        System.out.println ("\t\tselect one of the operations below");
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] update\t\t[2] exit");
        int num = input.nextInt ();
        if (num == 1) {
            this.updateMoviesMenu (index);
        }

    }


    public void displayAllGenres(ArrayList<String> arrGenre) {
        for (int i = 0; i < arrGenre.size (); i++) {
            System.out.println ("[" + (i + 1) + "]" + arrGenre.get (i));
        }
    }

    public void queryGenres(int index) {
        Movie m1 = allMovies.get (index - 1);
        ArrayList<String> arrGenre = new ArrayList<> (m1.getArrGenre ());
        if (arrGenre.isEmpty ()) {
            System.out.println ("\t\tthere is no assigned genres right now");
            System.out.println ("\tplease select one of the operations below");
            System.out.println ();
            System.out.println ("[1] Add genre\t[2] Back");
            int choice = input.nextInt ();
            if (choice == 1) {
                addGenre (index, arrGenre);

            } else if (choice == 2) {
                return;
            }

        } else //size !=0
        {
            System.out.println ("\tplease select one of the operations below");
            System.out.println ();
            System.out.println ("[1] Add genre\t[2] Remove genre\t[3] Back");
            int choice = input.nextInt ();
            if (choice == 1)//add genre
            {
                addGenre (index, arrGenre);
            } else if (choice == 2)//remove genre
            {
                displayAllGenres (arrGenre);
                int num = input.nextInt ();
                arrGenre.remove (num - 1);
                allMovies.get (index - 1).setArrGenre (arrGenre);
                System.out.println ("\t\tRemoved successfully");


            }
        }

    }


    public void addGenre(int index, ArrayList<String> arrGenre) {
        System.out.println ("\t\tselect one to add");
        System.out.println ();
        System.out.println ("[1]Drama\t[2]Horror\t[3]Action");
        System.out.println ();
        System.out.println ("[4]Comedy\t[5]Historical\t[6]Romance");
        System.out.println ();
        System.out.println ("[7]Adventure\t[8]Fantasy\t[9]Thriller");
        int num = input.nextInt ();
        if (num == 1) {
            arrGenre.add ("Drama");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 2) {
            arrGenre.add ("Horror");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 3) {
            arrGenre.add ("Action");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 4) {
            arrGenre.add ("Comedy");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 5) {
            arrGenre.add ("Historical");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 6) {
            arrGenre.add ("Romance");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 7) {
            arrGenre.add ("Adventure");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 8) {
            arrGenre.add ("Fantasy");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        } else if (num == 9) {
            arrGenre.add ("Thriller");
            allMovies.get (index - 1).setArrGenre (arrGenre);
        }

    }

    public void displayAllLanguages(ArrayList<String> arrLanguage) {
        System.out.println ("these are all the assigned languages");
        System.out.println ();
        for (int i = 0; i < arrLanguage.size (); i++) {
            System.out.println ("[" + (i + 1) + "]" + arrLanguage.get (i));
        }
    }

    public void queryLanguages(int index) {
        Movie m1 = allMovies.get (index - 1);
        ArrayList<String> arrLanguages = new ArrayList<> (m1.getArrLanguage ());

        if (arrLanguages.size () == 0) {
            System.out.println ("\t\tThere is no assigned language right now");
            System.out.println ("\tplease select one of the operations below");
            System.out.println ();
            System.out.println ("[1] Add language\t[2] Back");
            int num = input.nextInt ();
            if (num == 1) {
                addLanguage (index, arrLanguages);
            } else if (num == 2) {
                return;
            } else {
                System.out.println ("\t\tinvalid operation");
                System.out.println ("please select only one of the operation showed to you");

            }


        } else //size!=0
        {
            displayAllLanguages (arrLanguages);
            System.out.println ();
            System.out.println ("\tplease select one of the operations below");
            System.out.println ();
            System.out.println ("[1] Add language\t[2] Remove language\t[3] Back");
            int num = input.nextInt ();
            if (num == 1) {
                addLanguage (index, arrLanguages);
            } else if (num == 2) {
                System.out.println ("Enter number of the language to delete it");
                int choice = input.nextInt ();
                arrLanguages.remove (choice - 1);
                allMovies.get (index - 1).setArrLanguage (arrLanguages);
            } else if (num == 3) {
                return;
            } else {
                System.out.println ("\t\tinvalid operation");
                System.out.println ("please select only one of the operation showed to you");
            }

        }

    }

    public void addLanguage(int index, ArrayList<String> arrLanguages) {
        System.out.println ("please write the language that your would to add it");
        String s = input.next ();
        arrLanguages.add (s);
        allMovies.get (index - 1).setArrLanguage (arrLanguages);
    }


    public void updateMoviesMenu(int index) {
        System.out.println ("\t\twelcome to movie update menu");
        System.out.println ("\tplease select one of operations to update the details");
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] Title\t\t[2] Release Date");
        System.out.println ();
        System.out.println ("[3] Running time\t\t[4] List of cast");
        System.out.println ();
        System.out.println ("[5] Genres\t\t[6] Director ");
        System.out.println ();
        System.out.println ("[7] Languages\t\t[8] imdb_score");
        System.out.println ();
        System.out.println ("[9] Country\t\t[10] Budget");
        System.out.println ();
        System.out.println ("[11] Revenue");
        System.out.println ("\t[12] Back ");
        int choice = input.nextInt ();
        if (choice == 12)
            return;
        else
            this.updateMovie (index, choice);
    }

    public void updateMovie(int index, int number) {
        if (number == 1) //title
        {
            System.out.println ("Enter the title");
            System.out.println ();
            String s = input.next ();
            allMovies.get (index - 1).setTitle (s);
        } else if (number == 2)//ReleaseDate
        {
            System.out.println ("Enter the release date");
            System.out.println ();
            String s = input.next ();
            allMovies.get (index - 1).setReleaseDate (s);
        } else if (number == 3)//RunningTime
        {
            System.out.println ("Enter the running time");
            System.out.println ();
            String s = input.next ();
            allMovies.get (index - 1).setRunningTime (s);
        } else if (number == 4)//cast
        {
            queryCast (index);
        } else if (number == 5)//Genres
        {
            queryGenres (index);
        } else if (number == 6)//director
        {
            setDirector (index);
        } else if (number == 7)//languages
        {
            queryLanguages (index);
        } else if (number == 8)//imdbScore
        {
            System.out.println ("Enter the imdb score");
            System.out.println ();
            int score = input.nextInt ();
            allMovies.get (index - 1).setImdbScore (score);

        } else if (number == 9)//Country
        {
            System.out.println ("Enter the country");
            System.out.println ();
            String s = input.next ();
            allMovies.get (index - 1).setCountry (s);
        } else if (number == 10)//budget
        {
            System.out.println ("Enter the budget");
            System.out.println ();
            int budget = input.nextInt ();
            allMovies.get (index - 1).setBudget (budget);

        } else if (number == 11)//revnue
        {
            System.out.println ("Enter the revnue");
            System.out.println ();
            int revnue = input.nextInt ();
            allMovies.get (index - 1).setRevenue (revnue);

        } else {
            System.out.println ("\t\tinvalid operation");
            System.out.println ("\tplease enter one of the operations below");
            System.out.println ();
            updateMoviesMenu (index);

        }

    }

    public void queryCast(int index) {
        Movie m1 = allMovies.get (index - 1);
        ArrayList<Staff> c1 = new ArrayList<> (m1.getArrCast ());
        int i;
        if (c1.isEmpty ()) {
            System.out.println ("\t\tthere is no cast right now");

        } else {
            for (Staff c : c1) {
                System.out.println ((c1.indexOf (c) + 1) + ") " + c.firstName + " " + c.lastName);
            }
        }

        System.out.println ("[1]Add Actor\t\t[2] Remove Actor\t\t[3] Back");
        i = input.nextInt ();
        if (i == 3) {
            return;
        } else if (i == 1) {
            int actorIndex;
            CastList.displayAllActors ();
            System.out.println ("Enter a number to add an actor");
            actorIndex = input.nextInt ();
            c1.add (CastList.allActors.get (actorIndex - 1));
            m1.setArrCast (c1);
            allMovies.set (index - 1, m1);
            ArrayList<Movie> actorMovies = new ArrayList<>
                    ( CastList.allActors.get (actorIndex - 1).getMovies ());
            actorMovies.add (m1);
            CastList.allActors.get (actorIndex - 1).setMovies (actorMovies);
        } else if (i == 2) {
            int actorIndex;
            System.out.println ("Enter the number of actor:");
            actorIndex = input.nextInt ();
            c1.remove (c1.get (actorIndex - 1));
            m1.setArrCast (c1);
            allMovies.set (index - 1, m1);
        } else {
            System.out.println ("This is an invalid choice");
        }

    }

    public void setDirector(int index) {
        Movie m1 = allMovies.get (index - 1);
        String d1 = m1.getDirector ();
        ArrayList<Director> allDirectors = DirectorList.directorsList;
        if (d1 == null) {
            System.out.println ("No Director Assigned");
            System.out.println ();
            System.out.println ("[1]Assign Director\t\t[2] Back");
            int choice = input.nextInt ();
            if (choice == 1) {
                System.out.println ("Choose a Director");
                System.out.println ();
                for (int i = 0; i < allDirectors.size (); i++) {
                    System.out.println ("[" + (i + 1) + "]" + allDirectors.get (i).getFirstName () + " " + allDirectors.get (i).getLastName ());
                }
                int choose = input.nextInt ();
                m1.setDirector (allDirectors.get (choose - 1).getFirstName () + " " + allDirectors.get (choose - 1).getLastName ());
                allDirectors.get (choose - 1).addMovie (m1);
            } else if (choice == 2)
                return;
            else
                System.out.println ("Invalid Option");
        } else {
            System.out.println ("Assigned Director: " + d1 + "\n");
            System.out.println ("[1]Change Director\t\t[2]Remove Director\t\t[3] Back");
            int choice = input.nextInt ();
            if (choice == 1) {
                int indexOfOldDirector;
                System.out.println ("Choose a Director");
                System.out.println ();
                for (int i = 0; i < allDirectors.size (); i++) {
                    System.out.println ("[" + (i + 1) + "]" + allDirectors.get (i).getFirstName () + " " + allDirectors.get (i).getLastName ());

                    if ((allDirectors.get (i).getFirstName () + " " + allDirectors.get (i).getLastName ()).equals (d1)) {
                        allDirectors.get (i).removeMovie (m1);
                    }
                }
                int choose = input.nextInt ();
                m1.setDirector (allDirectors.get (choose - 1).getFirstName () + " " + allDirectors.get (choose - 1).getLastName ());
                allDirectors.get (choose - 1).addMovie (m1);
            } else if (choice == 2) {
                m1.setDirector (null);

            } else if (choice == 3)
                return;
            else
                System.out.println ("Invalid Option");

        }
    }

    public boolean isRate() {

        for (int i = 0; i < MovieList.allMovies.size (); i++) {

            if(MovieList.allMovies.get (i).getRateWatchit ()>=1)
                return true;
        }
        return false;

    }

    public void displayTopRatedMovies() {
        if (MovieList.allMovies.size () == 0) {
            System.out.println ("\t\tthere is no movies right now");
            System.out.println ();
        } else {
            if (isRate () == false) {
                System.out.println ("there is no rated movies right now");
            } else {
                System.out.println ("\tHere is the top rated movies : ");
                System.out.println ();
                if (MovieList.allMovies.size () <= 3) {
                    int i = 1;
                    for (Movie m : MovieList.allMovies) {
                        if (m.getRateWatchit () > 0.0f) {
                            System.out.println ("[" + i + "]" + m.getTitle ());
                            i++;
                        }
                    }
                } else {
                    int counter = 0;
                    int index = 0;
                    for (int i = 0; i < MovieList.allMovies.size (); i++) {

                        for (int j = 0; j < MovieList.allMovies.size (); j++) {

                            if (i == j) {
                                continue;
                            } else {
                                if (MovieList.allMovies.get (i).getRateWatchit () >=
                                        MovieList.allMovies.get (j).getRateWatchit ()) {
                                    index = i;
                                    counter++;

                                }

                            }
                        }

                        if (counter == 3) //3 movies are displayed
                            break;
                        else {
                            System.out.println ("[" + counter + "]" + MovieList.allMovies.get (index).getTitle ());
                        }
                    }

                }
            }

        }

    }

    public void displayRecentMovies() {
        if (MovieList.allMovies.size () == 0) {
            System.out.println ("\t\tthere is no movies right now");
            System.out.println ();
        } else {
            System.out.println ("\tHere is the recent movies : ");
            System.out.println ();
            if (MovieList.allMovies.size () <= 3) {
                int i = 1;
                for (Movie m : MovieList.allMovies) {
                    System.out.println ("[" + i + "]" + m.getTitle ());
                    i++;
                }
            } else {
                for (int i = MovieList.allMovies.size () - 3; i < MovieList.allMovies.size (); i++) {
                    System.out.println ("[" + (i + 1) + "]" +
                            MovieList.allMovies.get (i).getTitle ());
                }

            }
        }
    }

    public boolean isWatched() {
        for (Movie m : MovieList.allMovies) {
            if (m.getViews () > 0) {
                return true;
            }
        }
        return false;
    }

    public void displayTopWatchedMovies() {
        if (MovieList.allMovies.size () == 0) {
            System.out.println ("\t\tthere is no movies right now");
            System.out.println ();
        } else {
            if (isWatched () == false) {
                System.out.println ("\t\tthere is no watched movies right now");
                System.out.println ("\tbe the first who watch movie");
            } else {
                System.out.println ("\tHere is the top watched movies : ");
                System.out.println ();
                if (MovieList.allMovies.size () <= 3) {
                    int i = 1;
                    for (Movie m : MovieList.allMovies) {
                        if (m.getViews () > 0) {
                            System.out.println ("[" + i + "]" + m.getTitle ());
                            i++;
                        }
                    }
                } else {
                    int counter = 0;
                    int index = 0;
                    for (int i = 0; i < MovieList.allMovies.size (); i++) {

                        for (int j = 0; j < MovieList.allMovies.size (); j++) {

                            if (i == j) {
                                continue;
                            } else {
                                if (MovieList.allMovies.get (i).getViews () >=
                                        MovieList.allMovies.get (j).getViews ()) {
                                    counter++;
                                    index = i;

                                }

                            }
                        }
                        if (counter == 3) //3 movies are displayed
                            break;
                        else {
                            System.out.println ("[" + counter + "]" + MovieList.allMovies.get (index).getTitle ());

                        }

                    }
                }

            }
        }

    }
}
