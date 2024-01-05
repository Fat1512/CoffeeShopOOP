package QuanLySanPham;

import CauHinh.CauHinh;
import QuanLySanPham.Enum.DanhMucSP;
import QuanLySanPham.Enum.ThoiDiem;

import java.util.ArrayList;
import java.util.List;

public abstract class SanPham {
    private String maSP;
    private String ten;
    private double giaBan;
    private boolean tinhTrang;
    private List<ThoiDiem> thoiDiem;
    private DanhMucSP danhMuc;
    private static int dem = 0;
    {
        this.maSP = "SP%02d".formatted(++dem);
    }
    public SanPham() {

    }
    public SanPham(String ten, double giaBan, boolean tinhTrang, DanhMucSP danhMuc, ThoiDiem...thoiDiem) {
        this(ten, giaBan, tinhTrang, danhMuc);
        this.thoiDiem = new ArrayList<>(List.of(thoiDiem));
    }

    public SanPham(String ten, double giaBan, boolean tinhTrang, DanhMucSP danhMuc) {
        this.ten = ten;
        this.giaBan = giaBan;
        this.tinhTrang = tinhTrang;
        this.thoiDiem = new ArrayList<>(List.of(ThoiDiem.values()));
        this.danhMuc = danhMuc;
    }

    public void nhapThongTin() {
        System.out.print("Ten: ");
        this.ten = CauHinh.sc.nextLine();
        do {
            try {
                System.out.print("Gia ban: ");
                double giaBan = Double.parseDouble(CauHinh.sc.nextLine());
                if(giaBan <= 0) {
                    System.out.println("Gia phai > 0");
                    continue;
                }
                this.giaBan = giaBan;
                break;
            } catch (NumberFormatException error) {
                System.out.println("Loi nhap chu");
            }
        } while(true);

        int tinhTrang;
        do {
            System.out.print("Tinh trang (Con: 1, Khong con: 0): ");
            tinhTrang = CauHinh.batLoiMenu(0, 1);
        } while (tinhTrang == -1);
        this.tinhTrang = tinhTrang != 0;

        this.thoiDiem = new ArrayList<>();
        int sl = 10000;
        while(sl != 0) {
            StringBuilder dsMenu = new StringBuilder("Cac thoi diem: \n");
            for (ThoiDiem thoiDiem : ThoiDiem.values()) {
                dsMenu.append("%d. %s%n".formatted(thoiDiem.ordinal() + 1, thoiDiem));
            }
            dsMenu.append("Chon thoi diem (nhap 0 de thoat): ");
            do {
                System.out.print(dsMenu);
                sl = CauHinh.batLoiMenu(0, ThoiDiem.values().length);
            } while(sl == -1);

            if(sl == 0 && thoiDiem.isEmpty()) {
                System.out.println("Chua co thoi diem! Hay nhap lai");
                sl = 1;
                continue;
            }
            if(sl == 0) break;
            if(thoiDiem.contains(ThoiDiem.values()[sl - 1])) {
                System.out.println("Da co thoi diem nay trong danh sach!");
                continue;
            }
            if(sl != 0)
                thoiDiem.add(ThoiDiem.values()[sl - 1]);
        }
    }
    public boolean ban(int soLuong) {
        return true;
    }
    public boolean hoanTra(int soLuong) {
        return true;
    }
    public boolean kiemTraSoLuong(int soLuong) {
        return true;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTen() {
        return ten;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public List<ThoiDiem> getThoiDiem() {
        return thoiDiem;
    }

    public DanhMucSP getDanhMuc() {
        return danhMuc;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setThoiDiem(List<ThoiDiem> thoiDiem) {
        this.thoiDiem = thoiDiem;
    }

    public void setDanhMuc(DanhMucSP danhMuc) {
        this.danhMuc = danhMuc;
    }
}