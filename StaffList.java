import java.util.ArrayList;

public class StaffList {


    public void add(ArrayList stafflist ,Staff m) {
        stafflist.add (m);
    }

    public void delete(ArrayList stafflist ,int index) {
        stafflist.remove (stafflist.get (index - 1));
    }
}
