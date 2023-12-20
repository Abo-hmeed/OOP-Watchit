import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private static int number_of_movies = 0;
    private int id;
    private int imdbScore;
    private int budget;
    private int revenue;
    private String title;
    private String releaseDate;
    private String runningTime;
    private String director ;
    private String country;
    private ArrayList<String> arrGenre = new ArrayList<>();
    private ArrayList<String> arrLanguage = new ArrayList<String>();
    private ArrayList<Staff> arrCast = new ArrayList<Staff>();
    private int views = 0;
    private float rateWatchit = 0.0f;


    //poster

    public float getRateWatchit() {
        return rateWatchit;
    }

    public void setRateWatchit(float rateWatchit) {
        this.rateWatchit = rateWatchit;
    }

    public int getViews(){ return views;}
    public void increaseViews(){ views++;}
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(int imdbScore) {
        this.imdbScore = imdbScore;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public ArrayList<String> getArrGenre() {
        return arrGenre;
    }

    public void setArrGenre(ArrayList<String> arrGenre) {
        this.arrGenre = arrGenre;
    }

    public ArrayList<String> getArrLanguage() {
        return arrLanguage;
    }

    public void setArrLanguage(ArrayList<String> arrLanguage) {
        this.arrLanguage = arrLanguage;
    }

    public ArrayList<Staff> getArrCast() {
        return arrCast;
    }

    public void setArrCast(ArrayList<Staff> arrCast) {
        this.arrCast = arrCast;
    }

    public static int getNumber_of_movies() {
        return number_of_movies;
    }

    public Movie() {}


    public Movie( int imdbScore, int budget, int revenue, String title,
                  String releaseDate, String runningTime, String country) {
        this.imdbScore = imdbScore;
        this.budget = budget;
        this.revenue = revenue;
        this.title = title;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.country = country;
        number_of_movies++;
        this.id = number_of_movies;
    }

    public void displayMovieDetails() {
        System.out.println ("Title : " + this.title);
        System.out.println ("ID : " + this.id);
        System.out.println ("Release  date : " + this.releaseDate);
        System.out.println ("Running time : " + this.runningTime);
        System.out.println ("Imdb score : " + this.imdbScore);
        System.out.println ("Rate on Watchit : " + this.getRateWatchit ());
        System.out.println ("Country : " + this.country);
        System.out.println ("budget : " + this.budget);
        System.out.println ("revenue : " + this.revenue);
        if(this.director==null){
            System.out.println("Director: will be update soon");
        }
        else{
            System.out.println("Director: " + this.director);
        }
        if (arrCast.isEmpty()) {
            System.out.println ("Cast : " + "will be updated soon");
        } else {
            int number = 1;
            System.out.println ("The cast :");
            for (Staff i : arrCast) {
                System.out.println ("\t" + "[" + number + "]" + i.getFirstName () + " " + i.getLastName ());
                number++;
            }
        }
        if (arrGenre.isEmpty()) {
            System.out.println ("Genres : ");
            System.out.println ("\tGenres will be updated soon ");
        } else {
            int number = 1;
            System.out.println ("Genres : ");
            for (String i : arrGenre) {
                System.out.print ("[" + number + "]" + i + "  ");
                number++;
            }

        }
        System.out.println();
        if (arrLanguage.isEmpty()) {
            System.out.println ("Languages : ");
            System.out.println ("\tLanguages will be updated soon ");
        } else {
            int number = 1;
            System.out.println ("Languages : ");
            for (String i : arrLanguage) {
                System.out.print ("[" + number + "]" + i + "  ");
                number++;
            }
        }
        System.out.println ();
    }

}
