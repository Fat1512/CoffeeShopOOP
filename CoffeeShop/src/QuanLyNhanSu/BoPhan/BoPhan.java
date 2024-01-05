package QuanLyNhanSu.BoPhan;

public class BoPhan {
    private String maBP;
    private String tenBP;
    private static int dem = 0;

    public BoPhan(String tenBP) {
        this.maBP = "BP%05d".formatted(++dem);
        this.tenBP = tenBP;
    }
    public String getMaBP() {
        return maBP;
    }
    public String getTenBP() {
        return this.tenBP;
    }

    @Override
    public String toString() {
        return "| %-12s | %-11s |".formatted(this.maBP, this.tenBP);
    }
}