package QuanLySanPham;

import CauHinh.CauHinh;
import QuanLySanPham.Enum.DanhMucSP;
import QuanLySanPham.Enum.LoaiThucUong;
import QuanLySanPham.Enum.ThoiDiem;

public class ThucUong extends SanPham {
    private boolean isDa;
    private LoaiThucUong loai;
    public ThucUong() {
        super();
    }
    public ThucUong(String ten, double giaBan, boolean tinhTrang, DanhMucSP danhMuc
            , boolean isDa, LoaiThucUong loai, ThoiDiem...thoiDiem) {
        super(ten, giaBan, tinhTrang, danhMuc, thoiDiem);
        this.isDa = isDa;
        this.loai = loai;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.setDanhMuc(DanhMucSP.Thuc_Uong);

        int isDaInput;
        do {
            System.out.print("Do an chay (khong: 0, co: 1): ");
            isDaInput = CauHinh.batLoiMenu(0, 1);
        } while(isDaInput == -1);
        this.isDa = isDaInput != 0;

        StringBuilder dsMenu = new StringBuilder("Cac loai thuc uong: \n");
        for (LoaiThucUong loaiThucUong : LoaiThucUong.values()) {
            dsMenu.append("%d. %s%n".formatted(loaiThucUong.ordinal() + 1, loaiThucUong.getTen()));
        }
        int sl;
        do {
            System.out.print(dsMenu.toString());
            sl = CauHinh.batLoiMenu(1, LoaiThucUong.values().length);
        } while(sl == -1);
        this.loai = LoaiThucUong.values()[sl - 1];
    }

    public boolean isDa() {
        return isDa;
    }

    public LoaiThucUong getLoai() {
        return loai;
    }

    public void setDa(boolean da) {
        isDa = da;
    }

    public void setLoai(LoaiThucUong loai) {
        this.loai = loai;
    }
    @Override
    public String toString() {
        String thoiDiem = "";
        for (ThoiDiem diem : this.getThoiDiem()) {
            thoiDiem += diem + ", ";
        }
        thoiDiem = thoiDiem.substring(0, thoiDiem.length() - 2);

        String ketQua = "| %-6s | %-20s | %-11.2f | %-12s | %-22s | %-10s | %-8s | %-11s |"
                .formatted(this.getMaSP()
                        , this.getTen()
                        , this.getGiaBan()
                        , this.isTinhTrang() ? "Con" : "Het"
                        , thoiDiem
                        , this.getDanhMuc().layTenDanhMuc()
                        , this.isDa ? "Co" : "Khong"
                        , this.loai.getTen());
        return ketQua;
    }
}