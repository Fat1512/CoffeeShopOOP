package QuanLySanPham.Enum;

public enum LoaiThucAn {
    Banh_Mi("Banh Mi")
    , Banh_Kem("Banh Kem")
    , Kem("Kem");

    private String ten;
    LoaiThucAn(String ten) {
        this.ten = ten;
    }
    public String getTen() {
        return ten;
    }
}
