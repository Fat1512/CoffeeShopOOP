package QuanLySanPham;

import CauHinh.CauHinh;
import QuanLySanPham.Enum.DanhMucSP;
import QuanLySanPham.Enum.LoaiThucAn;
import QuanLySanPham.Enum.ThoiDiem;

public class ThucAn extends SanPham {
    private boolean isChay;
    private int soLuong;
    private LoaiThucAn loai;

    public ThucAn() {
        super();
    }
    public ThucAn(String ten, double giaBan, boolean tinhTrang, DanhMucSP danhMuc
            , boolean isChay, int soLuong, LoaiThucAn loai, ThoiDiem...thoiDiem) {
        super(ten, giaBan, tinhTrang, danhMuc,  thoiDiem);
        this.isChay = isChay;
        this.soLuong = soLuong;
        this.loai = loai;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.setDanhMuc(DanhMucSP.Thuc_An);

        int isChayInput;
        do {
            System.out.print("Do an chay (khong: 0, co: 1): ");
            isChayInput = CauHinh.batLoiMenu(0, 1);
        } while(isChayInput == -1);
        this.isChay = isChayInput != 0;

        do {
            try {
                System.out.print("So luong: ");
                this.soLuong = Integer.parseInt(CauHinh.sc.nextLine());
                if(soLuong < 0) {
                    throw new Error("So luong phai >= 0");
                } else if(soLuong == 0) {
                    this.setTinhTrang(false);
                }
                break;
            } catch(NumberFormatException e) {
                System.out.println("Loi nhap chu");
            } catch(Error e) {
                System.out.println(e.getMessage());
            }
        } while(true);

        StringBuilder dsMenu = new StringBuilder("Cac loai thuc an: \n");
        for (LoaiThucAn loaiThucAn : LoaiThucAn.values()) {
            dsMenu.append("%d. %s%n".formatted(loaiThucAn.ordinal() + 1, loaiThucAn.getTen()));
        }
        int sl;
        do {
            System.out.print(dsMenu.toString());
            sl = CauHinh.batLoiMenu(1, LoaiThucAn.values().length);
        } while(sl == -1);
        this.loai = LoaiThucAn.values()[sl - 1];
    }

    @Override
    public boolean ban(int soLuong) {
        if(kiemTraSoLuong(soLuong)) {
            this.soLuong -= soLuong;
            if (this.soLuong == 0) {
                this.setTinhTrang(false);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean hoanTra(int soLuong) {
        this.soLuong += soLuong;
        return true;
    }

    public boolean kiemTraSoLuong(int soLuong) {
        return this.soLuong >= soLuong;
    }

    public boolean isChay() {
        return isChay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public LoaiThucAn getLoai() {
        return loai;
    }

    public void setChay(boolean chay) {
        isChay = chay;
    }

    public void setLoai(LoaiThucAn loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        String thoiDiem = "";
        for (ThoiDiem diem : this.getThoiDiem()) {
            thoiDiem += diem + ", ";
        }
        thoiDiem = thoiDiem.substring(0, thoiDiem.length() - 2);
        return "| %-6s | %-20s | %-11.2f | %-12s | %-22s | %-10s | %-8s | %-8s | %-11s |"
                .formatted(this.getMaSP()
                        , this.getTen()
                        , this.getGiaBan()
                        , this.isTinhTrang() ? "Con" : "Het"
                        , thoiDiem
                        , this.getDanhMuc().layTenDanhMuc()
                        , this.isChay ? "Co" : "Khong"
                        , this.soLuong
                        , this.loai.getTen());
    }
}