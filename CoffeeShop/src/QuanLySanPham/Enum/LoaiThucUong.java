package QuanLySanPham.Enum;

public enum LoaiThucUong {
    CaPhe("Ca phe"), TraSua("Tra sua"), Tra("Tra sua"), SinhTo("Sinh to");

    private String ten;
    LoaiThucUong(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }
}
