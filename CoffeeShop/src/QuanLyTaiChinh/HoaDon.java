package QuanLyTaiChinh;

import QuanLyNhanSu.NhanVien;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class HoaDon {
    private String maHD;
    private DonDat datBan;
    private LocalDateTime ngayThanhToan;
    private double tien;
    private NhanVien nhanVien;
    private static int dem = 0;
    public HoaDon(DonDat datBan,NhanVien nhanVien) {
        this.maHD = "%03d".formatted(++dem);
        this.tien = datBan.tinhTongGiaTri();
        this.datBan = datBan;
        this.ngayThanhToan = LocalDateTime.now().minusMonths(new Random().nextInt(1,13));
        this.nhanVien =nhanVien;
    }

    public void inHoanDon() {
        System.out.printf("%30s%n", "Hoa don");
        System.out.printf("Ma hoan don: %s%n", maHD);
        System.out.printf("Ngay gio thanh toan: %s%n", ngayThanhToan.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.printf("Nhan Vien: %s%n",nhanVien.getMaNV());
        datBan.inThongTinBanDat();
        System.out.printf("Phai thanh toan:%-22s%.3f%n"," ",tien);
    }
    public LocalDateTime getNgayThanhToan() {
        return ngayThanhToan;
    }

    public double getTien() {
        return tien;
    }

    public String getMaHD() {
        return maHD;
    }
}
