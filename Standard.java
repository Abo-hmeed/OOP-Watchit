import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Standard extends Subscription implements Serializable {

    public static final int STANDARD_PRICE = 35;
    public static final int MAX_WATCH = 10;
    public static ArrayList<Subscription> arrStandard = new ArrayList<> ();


    public Standard(int userId, String plan) {
        super (userId, plan);
        LocalDateTime currentDateTime = LocalDateTime.now ();
        super.setStartDate (currentDateTime);
        super.getMonth (currentDateTime, this.price);

    }

    public Standard() {
    }

    public static void addSubscription(Standard sc) {
        arrStandard.add (sc);
    }//end of method

    public static void deleteSubscription(int userId) {
        for (int i = 0; i < arrStandard.size (); i++) {
            if (arrStandard.get (i).getUserId () == userId) {
                arrStandard.remove (i);
                break;
            }

        }
    }//end of method

    public boolean maxWatch(ArrayList arr) {
        if (arr.size () < Standard.MAX_WATCH) {
            return true;
        }
        return false;
    }

    public boolean subDays(int userId) {
        for (Subscription subscription : arrStandard) {
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
