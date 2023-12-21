import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Premium extends Subscription implements Serializable {

    public static final int PREMIUM_PRICE = 50;
    public static final int MAX_WATCH = 30;
    public static ArrayList<Subscription> arrPremium = new ArrayList<> ();


    public Premium(int userId, String plan) {
        super (userId, plan);
        LocalDateTime currentDateTime = LocalDateTime.now ();
        super.setStartDate (currentDateTime);
        super.getMonth (currentDateTime, PREMIUM_PRICE);
    }

    public Premium() {
    }

    public static void addSubscription(Premium sc) {
        arrPremium.add (sc);
    }//end of method

    public static void deleteSubscription(int userId) {
        for (int i = 0; i < arrPremium.size (); i++) {
            if (arrPremium.get (i).getUserId () == userId) {
                arrPremium.remove (i);
                break;
            }
        }
    }

    public boolean maxWatch(ArrayList arr) {
        if (arr.size () < Premium.MAX_WATCH) {
            return true;
        }
        return false;
    }

    public boolean subDays(int userId) {
        for (Subscription subscription : arrPremium) {
            if (subscription.getUserId() == userId) {
                int difference = Subscription.getDifferenceDays
                        (subscription.getStartDate());
                if (difference <= 30)
                    return true;
                else
                    break;
            }
        }
        return false;
    }
}
