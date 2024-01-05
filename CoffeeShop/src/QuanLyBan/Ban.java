package QuanLyBan;

public class Ban {
    private String maBan;
    private int sucChua;
    private boolean tinhTrang;
    private static int dem = 0;

    public Ban(int sucChua) {
        this.maBan ="B%03d".formatted(++dem);
        this.sucChua = sucChua;
        this.tinhTrang = false;
    }
    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    };
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getMaBan() {
        return maBan;
    }

    public int getSucChua() {
        return sucChua;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }
    public static String layHeaderDS() {
        return "-".repeat(39)
                + "%n| %-8s | %-10s | %-11s | %n"
                .formatted("Ma Ban", "Suc Chua", "Tinh Trang")
                + "-".repeat(39);
    }
    @Override
    public String toString() {
        return  "| %-8s | %-10s | %-11s | %n"
                .formatted(maBan,sucChua,tinhTrang?"Da dat":"Trong")
                + "-".repeat(39);
    }
}
