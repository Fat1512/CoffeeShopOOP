package QuanLySanPham.Enum;

public enum DanhMucSP {
    Thuc_An("Thuc An", "| %-6s | %-20s | %-11s | %-12s | %-22s | %-10s | %-8s | %-4s | %-11s |"
            .formatted("Ma", "Ten", "  Gia Ban", " Tinh trang", "  Thoi diem", " Danh Muc", "  Chay", "So luong", "   Loai"))
    , Thuc_Uong("Thuc Uong", "| %-6s | %-20s | %-11s | %-12s | %-22s | %-10s | %-8s | %-11s |"
            .formatted("Ma", "Ten", "  Gia Ban", " Tinh trang", "  Thoi diem", " Danh Muc", "   Da", "   Loai"));
    private String header, tenDM;
    DanhMucSP(String tenDM, String header) {
        this.tenDM = tenDM;
        this.header = header;
    }

    public String layHeaderDS() {
        return header;
    }

    public String layTenDanhMuc() {
        return tenDM;
    }
}