package QuanLyNhanSu.BoPhan;

import Interface.Checkable;

import java.util.ArrayList;
import java.util.List;

public class QLBoPhan implements Checkable<BoPhan> {
    private List<BoPhan> dsBoPhan;
    {
        dsBoPhan = new ArrayList<>();
    }
    public boolean themBoPhan(BoPhan boPhan) {
        dsBoPhan.add(boPhan);
        return true;
    }
    public boolean themBoPhan(BoPhan...boPhan) {
        dsBoPhan.addAll(List.of(boPhan));
        return true;
    }

    public BoPhan timKiem(String maBP) {
        return dsBoPhan.stream().filter(bp -> bp.getMaBP().equalsIgnoreCase(maBP)).findFirst().orElse(null);
    }

    public void xuatDS() {
        System.out.println(layHeaderDS());
        for (BoPhan boPhan : dsBoPhan) {
            System.out.println(boPhan);
            System.out.println("-".repeat(30));
        }
    }

    @Override
    public boolean kiemTraTrong(String message) {
        if(this.dsBoPhan.isEmpty()) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    public static String layHeaderDS() {
        return "-".repeat(30) +
                "%n| %-12s | %-11s |%n".formatted("Ma bo phan", "Ten bo phan")
                + "-".repeat(30);
    }

}