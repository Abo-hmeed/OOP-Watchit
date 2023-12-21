import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminList implements Serializable {
    static Scanner input = new Scanner (System.in);
    static ArrayList<Admin> arrAdmin = new ArrayList<> ();

//Checks whether an admin is registered
    public boolean adminExist(String username, String password) {
        for (Admin a : arrAdmin) {
            if (a.getUsername ().equals (username) && a.getPassword ().equals (password))
                return true;

        }
        return false;
    }

    //Menu that appears to admins at start
    public void adminGeneralMenu() {
        System.out.println ("\n\n\n\n");
        System.out.println ("\t\t[1] Movies");
        System.out.println ("\t\t[2] Cast");
        System.out.println ("\t\t[3] Directors");
        System.out.println ("\t\t[4] Admin");
        System.out.println ("\t\t[5] Log out");

    }

    //Admin settings menu
    public void adminMenu() {

        System.out.println ("\t\there are the admin functionalities");
        System.out.println ("\tselect one of the operations below\n");
        System.out.println ("[1] New admin\t[2] See the most month had revenue");
        System.out.println ("[3] Most subscribed plan\t[4] See all admins");
        System.out.println ("[5] Update admin\t[6] Delete admin");
        System.out.println ("[7] See admin details\t[8] Back");

    }

    //Only displays admins
    public void displayAllAdmins() {
        while (true) {
            System.out.println ("\t\tAll admins of the system");
            System.out.println ("select back to return again");
            System.out.println ("[1] Back");
            int choice = input.nextInt ();
            if (choice == 1)
                break;
            else {
                System.out.println ("\t\t invalid operation");
                System.out.println ("\tplease select only the operation below");
            }
        }
    }

    //Displays admins to do something
    public void displayAdmins()
    {
        System.out.println ("\t\tAll admins of the system");
        AdminList.arrAdmin.stream()
                .forEach(a -> System.out.println("[" + a.getId() + "]" + a.getUsername()));

    }

    public void updateAdminMenu(int index)
    {  while(true) {
        //username password firstName lastName email
        System.out.println ("\tWhat information do you want to update it\n");
        System.out.println ("[1] Username\t[2] Password");
        System.out.println ("[3] First name\t[4] Last name");
        System.out.println ("[5] Email\t[6]back");
        int choice = input.nextInt ();
        if (choice==6)
            break;
        else if(choice<1 || choice>6)
        {
            System.out.println ("\t\tinvalid operation");
            System.out.println ("\tselect one of the operations below\n");
        }
        else
        {
            updateAdmin (choice,index);
        }
    }

    }
    public void updateAdmin(int choice , int index)
    {
        if(choice==1)
        {
            System.out.println ("Write the new username");
            String s =input.next ();
            arrAdmin.get (index-1).setUsername (s);
        }
        else if(choice==2)
        {
            System.out.println ("Write the new password");
            String s =input.next ();
            arrAdmin.get (index-1).setPassword (s);
        }
        else if(choice==3)
        {
            System.out.println ("Write the new first name");
            String s =input.next ();
            arrAdmin.get (index-1).setFirstName (s);
        }
        else if(choice==4)
        {
            System.out.println ("Write the new last name");
            String s =input.next ();
            arrAdmin.get (index-1).setLastName (s);
        }
        else if(choice==5)
        {
            System.out.println ("Write the new email");
            String s =input.next ();
            arrAdmin.get (index-1).setFirstName (s);
        }
        System.out.println ("\t\t updated successfully");

    }


    public void newAdmin() {
        System.out.println ("please fulfill the required details\n");
        System.out.println ("Enter username");
        String username = input.next ();
        System.out.println ("Enter password");
        String password = input.next ();
        System.out.println ("Enter first name");
        String fName = input.next ();
        System.out.println ("Enter last name");
        String lname = input.next ();
        System.out.println ("Enter your email");
        String email = input.next ();
        Admin a = new Admin (username, password, fName, lname, email);
        addAdmin (a);

    }

    public void addAdmin(Admin a) {
        arrAdmin.add (a);
    }

    public void deleteAdmin(int index) {
        arrAdmin.remove (arrAdmin.get (index-1));
    }

    @Override
    public String toString() {
        return "AdminList{" +
                "arrAdmin=" + arrAdmin +
                '}';
    }
}
