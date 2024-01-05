package QuanLyTaiChinh;

import Interface.Checkable;

import java.util.ArrayList;
import java.util.List;

public class QLDatBan implements Checkable<DonDat> {
    private List<DonDat> dsBanDat = new ArrayList<>();
    public DonDat thanhToan(String maDon) {
       var banDat = dsBanDat.stream()
                .filter(s->s.getMaDon().equals(maDon))
                .findFirst()
                .orElseGet(()->null);
       if(banDat!=null && !banDat.getThongTinBan().isEmpty() && !banDat.getThongTinSanPham().isEmpty()) {
           banDat.getThongTinBan().forEach((k,v) ->v.setTinhTrang(false));
           dsBanDat.remove(banDat);
       }
       return banDat;
    }
    public DonDat timDonDat(String maDon) {
       return dsBanDat.stream()
                .filter(s->s.getMaDon().equals(maDon))
                .findFirst()
                .orElseGet(()->null);
    }
    public boolean themDonDat(DonDat donDat) {
        if(donDat != null) {
            dsBanDat.add(donDat);
            return true;
        }
        return false;
    }
    public boolean xoaDonDat(String maDon) {
        DonDat donDat;
        try {
            donDat = this.dsBanDat.stream()
                    .filter(s-> s.getMaDon().equals(maDon))
                    .findFirst()
                    .orElseGet(()->null);
        } catch (NullPointerException e) {
            System.out.println("Khong ton tai ma ban");
            return false;
        }
        return donDat.xoaTatCa();
    }
    public void inDSDonDat() {
        if(dsBanDat.isEmpty()) {
            System.out.println("Hien tai khong co ban dat");
            return;
        }
        dsBanDat.forEach(DonDat::inThongTinBanDat);
    }

    @Override
    public boolean kiemTraTrong(String message) {
        if(this.dsBanDat.isEmpty()) {
            System.out.println(message);
            return true;
        }
        return false;
    }
}
