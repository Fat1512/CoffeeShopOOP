package QuanLyNhanSu;

import QuanLyNhanSu.BoPhan.BoPhan;
import QuanLyNhanSu.Enum.GioiTinh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NhanVien {
    private String maNV;
    private String hoTen;
    private GioiTinh gioiTinh;
    private String queQuan;

    private LocalDate ngaySinh;
    private LocalDate ngayVaoLam;
    private BoPhan boPhan;
    private String username, password;
    private static int dem = 0;

    {
        this.maNV = "NV%05d".formatted(++dem);
    }

    public NhanVien(String hoTen, GioiTinh gioiTinh, String queQuan, LocalDate ngaySinh, LocalDate ngayVaoLam, BoPhan boPhan) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhan = boPhan;
        this.username = this.maNV;
        this.username = String.valueOf(123456);
    }
    public NhanVien(String hoTen, GioiTinh gioiTinh, String queQuan, LocalDate ngaySinh, BoPhan boPhan) {
        this(hoTen, gioiTinh, queQuan, ngaySinh, LocalDate.now(), boPhan);
    }

    public NhanVien(String hoTen, GioiTinh gioiTinh, String queQuan, LocalDate ngaySinh, LocalDate ngayVaoLam,
                    BoPhan boPhan, String username, String password) {
        this(hoTen, gioiTinh, queQuan, ngaySinh, ngayVaoLam, boPhan);
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String wrapInfo() {
        return maNV+", " + password + ", " + hoTen + ", " + gioiTinh.toString() + ", " +queQuan +
                ", " + ngaySinh.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", " + ngayVaoLam.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
                + boPhan.getMaBP();
    }
    @Override
    public String toString() {
        String ketQua = "| %-8s | %-20s | %-11s | %-10s | %-12s | %-12s | %-10s |".formatted(
                maNV, hoTen, gioiTinh, queQuan, this.ngaySinh.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                , this.ngayVaoLam.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), boPhan.getTenBP());

        return ketQua;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public BoPhan getBoPhan() {
        return boPhan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
    }
}