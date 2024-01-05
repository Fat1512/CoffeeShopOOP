package QuanLyBan;

import Interface.Checkable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QLBan implements Checkable<Ban> {
    public List<Ban> dsBan = new ArrayList<>();
    public boolean themBan(Ban ban) {
        if (ban == null || ban.isTinhTrang())
        {
            return false;
        } else {
            dsBan.add(ban);
            return true;
        }
    }
    public boolean themBan(Ban...bans) {
        if(bans.length == 0) {
            return false;
        } else {
            dsBan.addAll(Arrays.asList(bans));
            return true;
        }
    }
    public boolean xoaBan(String maBan) {
        return dsBan.removeIf(s->s.getMaBan().equals(maBan) && !s.isTinhTrang());
    }
    public List<Ban> timKiem(int minCapacity, int maxCapacity) {
        return dsBan.stream()
                .filter(s-> s.getSucChua()>= minCapacity && s.getSucChua()<=maxCapacity)
                .collect(Collectors.toList());
    }
    public List<Ban> timKiem(int capacity) {
        return this.timKiem(capacity,capacity);
    }
    public Ban timKiem(String maBan) {
        return dsBan.stream()
                .filter(s->s.getMaBan().equals(maBan))
                .findFirst()
                .orElseGet(()-> null);
    }
    public List<Ban> layDsBanTrong() {
        return dsBan.stream()
                .filter(s-> !s.isTinhTrang())
                .collect(Collectors.toList());
    }
    public void xuatDS(List<Ban> dsBan) {
        System.out.println(Ban.layHeaderDS());
        dsBan.forEach(System.out::println);
    }
    public void xuatDS() {
        if(this.dsBan.isEmpty()) {
            System.out.println("Hien tai quan khong co ban");
        } else {
            this.xuatDS(this.dsBan);
        }
    }

    @Override
    public boolean kiemTraTrong(String message) {
        if(this.dsBan.isEmpty()) {
            System.out.println(message);
            return true;
        }
        return false;
    }
}
