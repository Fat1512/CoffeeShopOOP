package QuanLyNhanSu;

import Interface.Checkable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLNhanVien implements Checkable<NhanVien> {
    private List<NhanVien> dsNV;
    private NhanVien nhanVienTrongCa;
    {
        dsNV = new ArrayList<>();
    }
    public boolean themNV(NhanVien nv) {
        return this.dsNV.add(nv);
    }
    public boolean themNV(NhanVien...nv) {
        return this.dsNV.addAll(List.of(nv));
    }

    public boolean xoaNV(String maNV) {
        return this.dsNV.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(maNV.trim()));
    }


    public NhanVien traCuu(String ma) {
        return dsNV.stream().filter(nv -> nv.getMaNV().equalsIgnoreCase(ma.trim())).findFirst().orElse(null);
    }

    public List<NhanVien> traCuu(Method m, String kw) {
        return dsNV.stream().filter(nv -> {
            try {
                return m.invoke(nv).toString().equalsIgnoreCase(kw.trim());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    public void xuatDS() {
        xuatDS(this.dsNV);
    }

    public void xuatDS(List<NhanVien> dsNV) {
        System.out.println(layHeaderDS());
        dsNV.forEach(nv -> {
            System.out.println(nv);
            System.out.println("-".repeat(105));
        });
    }

    public List<NhanVien> layDSSN() {
        return dsNV.stream().filter(nv -> nv.getNgaySinh().getMonth().equals(LocalDate.now().getMonth())).toList();
    }

    public List<NhanVien> layDSNV() {
        return dsNV;
    }

    @Override
    public boolean kiemTraTrong(String message) {
        if(this.dsNV.isEmpty()) {
            System.out.println(message);
            return true;
        }
        return false;
    }
    public static String layHeaderDS() {
         return "-".repeat(105)
                + "%n| %-8s | %-20s | %-11s | %-10s | %-12s | %-12s | %-10s |%n"
                .formatted("MaNV", "Ho Ten", "Gioi Tinh", "Que Quan", "Ngay Sinh", "Ngay Vao Lam", "Bo Phan")
                + "-".repeat(105);
    }

    public NhanVien getNhanVienTrongCa() {
        return nhanVienTrongCa;
    }

    public void setNhanVienTrongCa(NhanVien nhanVienTrongCa) {
        this.nhanVienTrongCa = nhanVienTrongCa;
    }
}