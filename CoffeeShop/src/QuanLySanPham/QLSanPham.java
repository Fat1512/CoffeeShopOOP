package QuanLySanPham;

import Interface.Checkable;
import QuanLySanPham.Enum.DanhMucSP;

import java.util.*;
import java.util.stream.Collectors;

public class QLSanPham implements Checkable<SanPham> {
    private Map<DanhMucSP, List<SanPham>> dsSanPham;
    {
        dsSanPham = new HashMap<>();
        for (DanhMucSP value : DanhMucSP.values()) {
            dsSanPham.put(value, new ArrayList<>());
        }
    }
    public boolean themSanPham(SanPham sp) {
        List<SanPham> spList =  dsSanPham.get(sp.getDanhMuc());
        spList.add(sp);
        return true;
    }
    public boolean themSanPham(SanPham...dsSP) {
        for (SanPham sp : dsSP) {
            this.themSanPham(sp);
        }
        return true;
    }
    public boolean xoaSanPham(String ten) {
        for(var dssp : dsSanPham.entrySet()) {
            if(dssp.getValue().removeIf(sp -> sp.getTen().equalsIgnoreCase(ten))) return true;
        }
        return false;
    }

    public SanPham timKiem(String ten) {
        SanPham sp = null;
        for (DanhMucSP danhMuc : DanhMucSP.values()) {
            sp = timKiem(danhMuc, ten);
            if(sp != null) return sp;
        }
        return null;
    }

    public Map<DanhMucSP, List<SanPham>> timKiem(double giaDau, double giaCuoi) {
        Map<DanhMucSP, List<SanPham>> mapDS = new HashMap<>();
        dsSanPham.forEach((k, v) -> {
            List<SanPham> dsSP = timKiem(k, giaDau, giaCuoi);
            if(!dsSP.isEmpty()) {
                mapDS.merge(k, dsSP, (dsCu, dsMoi) -> {
                    dsCu.addAll(dsMoi);
                    return dsCu;
                });
            }
        });
        return mapDS;
    }

    public List<SanPham> timKiem(DanhMucSP danhMuc, double giaDau, double giaCuoi) {
        return dsSanPham.get(danhMuc).stream()
                .filter(sp -> sp.getGiaBan() <= giaCuoi && sp.getGiaBan() >= giaDau)
                .collect(Collectors.toList());
    }

    public SanPham timKiem(DanhMucSP danhMuc, String ten) {
        return dsSanPham.get(danhMuc)
                .stream()
                .filter(sp -> sp.getTen().equalsIgnoreCase(ten.trim()))
                .findFirst()
                .orElse(null);
    }

    public void sapXep(DanhMucSP danhMuc, Comparator<SanPham> cmp) {
        dsSanPham.get(danhMuc).sort(cmp);
    }

    public void sapXep(Comparator<SanPham> cmp) {
        dsSanPham.forEach((k, v) -> v.sort(cmp));
    }

    public void xuatDS() {
        dsSanPham.forEach(this::xuatDS);
    }
    public void xuatDS(DanhMucSP danhMucSP, List<SanPham> dsSanPham) {
        System.out.println("---------------" + danhMucSP.layTenDanhMuc() + "---------------");
        System.out.println(danhMucSP.layHeaderDS());
        if(kiemTraTrong("Danh sach hien trong!")) {
            return;
        }
        dsSanPham.forEach(System.out::println);
    }
    @Override
    public boolean kiemTraTrong(String message) {
        for(var sanPham : dsSanPham.entrySet()) {
            if(!sanPham.getValue().isEmpty()) return false;
        }
        System.out.println(message);
        return true;
    }
}