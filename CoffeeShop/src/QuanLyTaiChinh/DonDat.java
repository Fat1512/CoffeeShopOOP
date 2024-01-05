package QuanLyTaiChinh;

import QuanLyBan.Ban;
import QuanLySanPham.SanPham;

import java.util.HashMap;
import java.util.Map;

public class DonDat {
    private String maDon;
    private Map<SanPham, Integer> thongTinSanPham = new HashMap<>();
    private Map<String, Ban> thongTinBan = new HashMap<>();
    private static int dem = 0;
    public DonDat() {
        this.maDon = "D%03d".formatted(++dem);
    }

    public boolean themBan(Ban ban) {
        if(ban !=null) {
            if(ban.isTinhTrang()) return false;
            Ban duplicate = thongTinBan.putIfAbsent(ban.getMaBan(),ban);
            ban.setTinhTrang(true);
            return true;
        }
        return false;
    }
    public boolean xoaBan(String maBan) {
        if(thongTinBan.containsKey(maBan)) {
            thongTinBan.get(maBan).setTinhTrang(false);
            thongTinBan.remove(maBan);
            return true;
        }
        return false;
    }

    public boolean themSanPham(SanPham sanPham, int soLuong) {
        try {
            if(soLuong < 0){
                throw new Error("So luong nhap phai lon hon 0");
            }
            else if(!sanPham.kiemTraSoLuong(soLuong)) {
                throw new Error("So luong san pham khong du!!!");
            } else if (!sanPham.isTinhTrang()) {
                throw new Error("San pham khong con dc ban");
            }
            sanPham.ban(soLuong);
            Integer duplicated = thongTinSanPham.putIfAbsent(sanPham,soLuong);
            if(duplicated!=null) {
                thongTinSanPham.merge(sanPham,soLuong,Integer::sum);
            }
            return true;
        }catch (Error e) {
            System.out.println(e.getMessage());
            return false;
        } catch (NullPointerException e) {
            System.out.println("San pham khong ton tai");
            return false;
        }
    }
    public boolean xoaSanPham(SanPham sanPham, int soLuong) {
        try {
            if(soLuong <0 ) {
                throw new Error("So luong san pham phai lon hon 0");
            } else if(thongTinSanPham.get(sanPham) <soLuong) {
                throw new Error(("So luong san pham cua ban it hon so can xoa"));
            }
            int remain = thongTinSanPham.get(sanPham)-soLuong;
            if(remain ==0 )
            {
                thongTinSanPham.remove(sanPham);
            } else {
                thongTinSanPham.replace(sanPham, remain);
            }
            sanPham.hoanTra(soLuong);
            return true;
        }catch (Error e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean xoaTatCa() {
        var iterator1 = thongTinBan.keySet().iterator();
        while (iterator1.hasNext()) {
            this.xoaBan(iterator1.next());
        }
        var iterator2 = thongTinSanPham.entrySet().iterator();
        while (iterator2.hasNext()) {
            var y = iterator2.next();
            this.xoaSanPham(y.getKey(),y.getValue());
        }
        return true;
    }

    public double tinhTongGiaTri() {
        if(thongTinSanPham == null) return -1;
        double total =0;
        for (var x : thongTinSanPham.keySet()){
            total += x.getGiaBan() * thongTinSanPham.get(x);
        }
        return total;
    }

    public void inThongTinBanDat() {
        System.out.println("Ma don: " +maDon);
        System.out.println("Thong tin ban: ");
        System.out.println(Ban.layHeaderDS());
        thongTinBan.values().forEach(System.out::println);
        System.out.println("Thong tin san pham: ");
        System.out.println("-".repeat(52));
        System.out.printf("| %-20s | %-11s | %-12s |%n","Ten san pham","So Luong", "Gia");
        thongTinSanPham.forEach((k,v) -> {
            System.out.printf("| %-20s | %-11s | %-12s | %n",k.getTen(),v,k.getGiaBan());
        } );
        System.out.println("-".repeat(53));
        System.out.println();
        System.out.println("=".repeat(53));
    }

    public String getMaDon() {
        return maDon;
    }

    public Map<String, Ban> getThongTinBan() {
        return thongTinBan;
    }

    public Map<SanPham, Integer> getThongTinSanPham() {
        return thongTinSanPham;
    }
}