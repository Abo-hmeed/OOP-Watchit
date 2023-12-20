import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminList implements Serializable {
    static Scanner input = new Scanner (System.in);
    static ArrayList<Admin> arrAdmin = new ArrayList<> ();


    public boolean adminExist(String username, String password) {
        for (Admin ad : arrAdmin) {
            if (ad.getUsername ().equals (username) && ad.getPassword ().equals (password))
                return true;

        }
        return false;
    }

    public void adminGeneralMenu() {
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("\t\t[1] Movies");
        System.out.println ("\t\t[2] Cast");
        System.out.println ("\t\t[3] Directors");
        System.out.println ("\t\t[4] Admin");
        System.out.println ("\t\t[5] Log out");

    }

    public void adminMenu() {

        System.out.println ("\t\there are the admin funcionalities");
        System.out.println ("\tselect one of the operations below");
        System.out.println ();
        System.out.println ("[1] New admin\t[2] See the most month had revnue");
        System.out.println ("[3] Most subscribed plan\t[4] See all admins");
        System.out.println ("[5] Update admin\t[6] Delete admin");
        System.out.println ("[7] See admin details\t[8] Back");

    }

    public void displayAllAdmins() {
        while (true) {
            System.out.println ("\t\tAll admins of the system");
            for (int i = 0; i < arrAdmin.size (); i++) {
                System.out.println ("[" + (i + 1) + "]" + arrAdmin.get (i).getUsername ());
            }
            System.out.println ("select back to return again");
            System.out.println ("[1] Back");
            int choice = input.nextInt ();
            if (choice == 1)
                break;
            else {
                System.out.println ("\t\t invalid operation");
                System.out.println ("\tplease select only the operation below");
                continue;
            }
        }
    }

    public void diplayAdmins()
    {
        System.out.println ("\t\tAll admins of the system");
        for (int i = 0; i < arrAdmin.size (); i++) {
            System.out.println ("[" + (i + 1) + "]" + arrAdmin.get (i).getUsername ());
        }
    }

    public void updateAdminMenu(int index)
    {  while(true) {
        //username password firstName lastName email
        System.out.println ("\tWhich one of informations do you want to update it");
        System.out.println ();
        System.out.println ("[1] Username\t[2] Password");
        System.out.println ("[3] First name\t[4] Last name");
        System.out.println ("[5] Email\t[6]back");
        int choice = input.nextInt ();
        if (choice==6)
            break;
        else if(choice<1 && choice>6)
        {
            System.out.println ("\t\tinvalid operation");
            System.out.println ("\tselect one of the operations below");
            System.out.println ();
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
        System.out.println ("please fullfill the required details");
        System.out.println ();
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
