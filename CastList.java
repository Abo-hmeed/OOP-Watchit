import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CastList extends StaffList implements Serializable {
    static Scanner input = new Scanner (System.in);
    public static ArrayList<Staff> allActors = new ArrayList<> ();

    public void queryNewCast() {
        System.out.println ("Enter actor's first name :");
        String fName = input.next ();
        System.out.println ("Enter actor's last name :");
        String lName = input.next ();
        System.out.println ("Enter actor's age : ");
        int age = input.nextInt ();
        System.out.println ("Enter actor's gender : ");
        String gender = input.next ();
        System.out.println ("Enter actor's nationality : ");
        String nat = input.next ();
        Staff c = new Staff (fName, lName, gender, nat, age)import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CastList extends StaffList implements Serializable {
    static Scanner input = new Scanner (System.in);
    public static ArrayList<Staff> allActors = new ArrayList<> ();

    public void queryNewCast() {
        System.out.println ("Enter actor's first name :");
        String fName = input.next ();
        System.out.println ("Enter actor's last name :");
        String lName = input.next ();
        System.out.println ("Enter actor's age : ");
        int age = input.nextInt ();
        System.out.println ("Enter actor's gender : ");
        String gender = input.next ();
        System.out.println ("Enter actor's nationality : ");
        String nat = input.next ();
        Staff c = new Staff (fName, lName, gender, nat, age);
        add (allActors,c);
    }


    public static void displayAllActors() {
        for (Staff c : allActors) {
            System.out.println ((allActors.indexOf (c) + 1) + ") " + c.firstName + " " + c.lastName);
        }
    }



    public void castMenu() {
        System.out.println ("\t\tplease select on of the operations below");
        System.out.println ();
        System.out.println ("[1] Add Cast");
        System.out.println ("[2] Update Cast");
        System.out.println ("[3] Remove Cast");
        System.out.println ("[4] Show Details");
        System.out.println ("[5] back");
    }

    public void updateCastsMenu(int index) {
        System.out.println ("\t\twelcome to casts update menu");
        System.out.println ("\tplease select one of operations to update the details");
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] First name\t\t[2] Last Name");
        System.out.println ();
        System.out.println ("[3] Age\t\t[4] Gender ");
        System.out.println ();
        System.out.println ("[5] Nationality\n[6] Back ");
        int choice = input.nextInt ();
        if (choice == 6)
            return;
        else
            this.updateActor (index, choice);
    }

    public void updateActor(int index, int choice) {

        if (choice == 1) {
            String s = input.next ();
            allActors.get (index - 1).setFirstName (s);
        } else if (choice == 2) {
            String s = input.next ();
            allActors.get (index - 1).setLastName (s);
        } else if (choice == 3) {
            String s = input.next ();
            allActors.get (index - 1).setAge (Integer.parseInt (s));
        } else if (choice == 4) {
            String s = input.next ();
            allActors.get (index - 1).setGender (s);
        } else if (choice == 5) {
            String s = input.next ();
            allActors.get (index - 1).setNationality (s);
        }
    }

    public void showActorDetails(int index) {
        displayCastDetails (allActors.get (index - 1));

    }

    public void displayCastDetails(Staff actor) {
        System.out.println ("First Name : " + actor.firstName);
        System.out.println ("Last Name : " + actor.lastName);
        System.out.println ("Age :" + actor.age);
        System.out.println ("Gender : " + actor.gender);
        System.out.println ("Nationality : " + actor.nationality);
        System.out.println ("Movies : ");
        ArrayList<Movie> actorMovies = actor.getMovies ();
        if (actorMovies.isEmpty ()) {
            System.out.println ("No Movies Assigned");
        } else {
            for (int i = 0; i < actor.getMovies ().size (); i++) {
                System.out.println ("[" + (i + 1) + "]" + actorMovies.get (i).getTitle ());
            }
            System.out.println ();
        }
    }

}
;
        add (allActors,c);
    }


    public static void displayAllActors() {
        for (Staff c : allActors) {
            System.out.println ((allActors.indexOf (c) + 1) + ") " + c.firstName + " " + c.lastName);
        }
    }



    public void castMenu() {
        System.out.println ("\t\tplease select on of the operations below");
        System.out.println ();
        System.out.println ("[1] Add Cast");
        System.out.println ("[2] Update Cast");
        System.out.println ("[3] Remove Cast");
        System.out.println ("[4] Show Details");
        System.out.println ("[5] back");
    }

    public void updateCastsMenu(int index) {
        System.out.println ("\t\twelcome to casts update menu");
        System.out.println ("\tplease select one of operations to update the details");
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] First name\t\t[2] Last Name");
        System.out.println ();
        System.out.println ("[3] Age\t\t[4] Gender ");
        System.out.println ();
        System.out.println ("[5] Nationality\n[6] Back ");
        int choice = input.nextInt ();
        if (choice == 6)
            return;
        else
            this.updateActor (index, choice);
    }

    public void updateActor(int index, int choice) {

        if (choice == 1) {
            String s = input.next ();
            allActors.get (index - 1).setFirstName (s);
        } else if (choice == 2) {
            String s = input.next ();
            allActors.get (index - 1).setLastName (s);
        } else if (choice == 3) {
            String s = input.next ();
            allActors.get (index - 1).setAge (Integer.parseInt (s));
        } else if (choice == 4) {
            String s = input.next ();
            allActors.get (index - 1).setGender (s);
        } else if (choice == 5) {
            String s = input.next ();
            allActors.get (index - 1).setNationality (s);
        }
    }

    public void showActorDetails(int index) {
        displayCastDetails (allActors.get (index - 1));

    }

    public void displayCastDetails(Staff actor) {
        System.out.println ("First Name : " + actor.firstName);
        System.out.println ("Last Name : " + actor.lastName);
        System.out.println ("Age :" + actor.age);
        System.out.println ("Gender : " + actor.gender);
        System.out.println ("Nationality : " + actor.nationality);
        System.out.println ("Movies : ");
        ArrayList<Movie> actorMovies = actor.getMovies ();
        if (actorMovies.isEmpty ()) {
            System.out.println ("No Movies Assigned");
        } else {
            for (int i = 0; i < actor.getMovies ().size (); i++) {
                System.out.println ("[" + (i + 1) + "]" + actorMovies.get (i).getTitle ());
            }
            System.out.println ();
        }
    }

}
