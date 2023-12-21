import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static java.lang.Math.max;

public abstract class Subscription implements Serializable {

    public static int[] month = new int[13];
    protected int userId;
    protected int price;
    protected String plan;
    protected String startDate;


    public int getUserId() {
        return userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Subscription() {
    }

    public Subscription(int userId, String plan) {
        this.userId = userId;
        this.plan = plan;
    }

    public void setStartDate(LocalDateTime currentDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        this.startDate = currentDateTime.format (formatter);
    }

    public void getMonth(LocalDateTime currentDateTime, int Price) {
        int monthValue = currentDateTime.getMonthValue ();
        month[monthValue] += Price;
    }

    public static void reduceMoney(String oldDateSub, int Price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse (oldDateSub, formatter);
        int monthValue = localDate.getMonthValue ();
        month[monthValue] -= Price;
    }


    public static int getDifferenceDays(String startDate1) {
        LocalDate oldDate = LocalDate.parse (startDate1);
        LocalDate currentDate = LocalDate.now ();

        return (int) ChronoUnit.DAYS.between (oldDate, currentDate);
    }

    public static void subscribeAgain(int userIndex) {
        LocalDateTime currentDateTime = LocalDateTime.now ();
        int monthValue = currentDateTime.getMonthValue ();
        int userId = UserList.arr.get (userIndex).getID ();
        String Plan = UserList.arr.get (userIndex).getSubscription ();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        String newDate = currentDateTime.format (formatter);
        if (Plan.equals ("Basic")) {
            for (int i = 0; i < Basic.arrBasic.size (); i++) {
                if (Basic.arrBasic.get (i).getUserId () == userId) {
                    Basic.arrBasic.get (i).setStartDate (newDate);
                    month[monthValue] += Basic.BASIC_PRICE;
                }
            }
        } else if (Plan.equals ("Standard")) {
            for (int i = 0; i < Standard.arrStandard.size (); i++) {
                if (Standard.arrStandard.get (i).getUserId () == userId) {
                    Standard.arrStandard.get (i).setStartDate (newDate);
                    month[monthValue] += Standard.STANDARD_PRICE;
                }
            }
        } else {
            for (int i = 0; i < Premium.arrPremium.size (); i++) {
                if (Premium.arrPremium.get (i).getUserId () == userId) {
                    Premium.arrPremium.get (i).setStartDate (newDate);
                    month[monthValue] += Premium.PREMIUM_PRICE;

                }
            }
        }
        while (!UserList.arr.get(userIndex).historyMovies.isEmpty()) {
            UserList.arr.get (userIndex).historyMovies.remove
                    (UserList.arr.get (userIndex).historyMovies.size () - 1);
        }
    }

    public static void mostSubscribedPlan() {

        if (Basic.arrBasic.isEmpty() && Standard.arrStandard.isEmpty()
                && Premium.arrPremium.isEmpty()) {
            System.out.println ("\t\t there are no subscriptions till now");
        } else {
            System.out.println ("\t\tThese all are subscriptions");
            System.out.println ();
            System.out.print ("Basic = " + Basic.arrBasic.size () + "\t");
            System.out.print ("Standard = " + Standard.arrStandard.size () + "\t");
            System.out.print ("Premium = " + Premium.arrPremium.size () + "\n");
            if (Basic.arrBasic.size () == Standard.arrStandard.size () &&
                    Basic.arrBasic.size () == Premium.arrPremium.size ()) {
                System.out.println ("All plans are equal in number of subscriptions");
            } else if (Basic.arrBasic.size () >= Standard.arrStandard.size () &&
                    Basic.arrBasic.size () >= Premium.arrPremium.size ()) {
                System.out.println ("Basic is the most subscribed plan");
            } else if (Standard.arrStandard.size () >= Basic.arrBasic.size () &&
                    Standard.arrStandard.size () >= Premium.arrPremium.size ()) {
                System.out.println ("Standard is the most subscribed plan");
            } else if (Premium.arrPremium.size () >= Basic.arrBasic.size () &&
                    Premium.arrPremium.size () >= Standard.arrStandard.size ()) {
                System.out.println ("Premium is the most subscribed plan");
            }
        }
    }

    public static void monthGreatestRevenue() {
        int maxi = -1;
        int monthNum = 0;
        for (int i = 0; i < 13; i++) {

            if (maxi <= month[i]) {
                maxi = month[i];
                monthNum = i;
            }
        }
        if (maxi != 0) {
            System.out.print ("Month " + monthNum + " had the most revenue ");
            System.out.print ("to the application");
            System.out.println ("revenue = " + month[monthNum]);
        } else {
            System.out.println ("\t\tthere is no revenue till now");
        }
    }

    public static void updateSubscription(int userId, String oldSub, String newSub) {
        int index = 0;
        if (oldSub.equals ("Basic")) {
            for (int i = 0; i < Basic.arrBasic.size (); i++)//searching for index
            {
                if (Basic.arrBasic.get (i).getUserId () == userId)
                    index = i;
            }
            if (newSub.equals ("Standard")) {
                Standard st = new Standard (userId, newSub);
                Standard.addSubscription (st);
            } else {
                Premium pr = new Premium (userId, newSub);
                Premium.addSubscription (pr);
            }
            reduceMoney (Basic.arrBasic.get (index).getStartDate (), Basic.BASIC_PRICE);
            Basic.arrBasic.remove (index);


        } else if (oldSub.equals ("Standard")) {
            for (int i = 0; i < Standard.arrStandard.size (); i++)//searching for index
            {
                if (Standard.arrStandard.get (i).getUserId () == userId)
                    index = i;
            }
            if (newSub.equals ("Basic")) {
                Basic b = new Basic (userId, newSub);
                Basic.addSubscription (b);
            } else {
                Premium pr = new Premium (userId, newSub);
                Premium.addSubscription (pr);
            }
            reduceMoney (Standard.arrStandard.get (index).getStartDate (), Standard.STANDARD_PRICE);
            Standard.arrStandard.remove (index);
        } else if (oldSub.equals ("Premium")) {
            for (int i = 0; i < Premium.arrPremium.size (); i++)//searching for index
            {
                if (Premium.arrPremium.get (i).getUserId () == userId)
                    index = i;
            }
            if (newSub.equals ("Standard")) {
                Standard st = new Standard (userId, newSub);
                Standard.addSubscription (st);

            } else {
                Basic b = new Basic (userId, newSub);
                Basic.addSubscription (b);
            }
            reduceMoney (Premium.arrPremium.get (index).getStartDate (), Premium.PREMIUM_PRICE);
            Premium.arrPremium.remove (index);
        }
    }


    public boolean maxWatch(ArrayList arr) {
        return false;
    }

    public abstract boolean subDays(int userId);
}
