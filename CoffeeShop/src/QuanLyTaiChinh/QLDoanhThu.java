package QuanLyTaiChinh;

import Interface.Checkable;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLDoanhThu implements Checkable<HoaDon> {
    private List<HoaDon> dsHoaDon =new ArrayList<>();

    public boolean themHoaDon(HoaDon hoaDon) {
        if(hoaDon !=null) {
            this.dsHoaDon.add(hoaDon);
            return true;
        }
        return false;
    }
    public void thongKeDoanhThu(Month month) {
        var dsTheoThang =dsHoaDon.stream()
                .filter(s->s.getNgayThanhToan().getMonth() ==month);
        var tongTien = dsHoaDon.stream()
                .filter(s->s.getNgayThanhToan().getMonth() == month)
                .mapToDouble(HoaDon::getTien)
                .summaryStatistics();
       // dsTheoThang.forEach(System.out::println);
        System.out.printf("Tong doanh thu cua thang %s: %.3f%nTong so hoa don:%d%n",month.toString()
                ,tongTien.getSum(),tongTien.getCount());
    }

    public void thongKeDoanhThu(LocalDate fromDate, LocalDate toDate) {
        var dsTheoThang = dsHoaDon.stream()
                .filter(s->s.getNgayThanhToan().toLocalDate().isAfter(fromDate)
                        &&s.getNgayThanhToan().toLocalDate().isBefore(toDate))
                .mapToDouble(HoaDon::getTien)
                .summaryStatistics();
        System.out.printf("Tong doanh thu tu ngay %s den ngay %s: %.3f%nTong so hoan don:%d%n",fromDate.toString()
                ,toDate.toString(),dsTheoThang.getSum(),dsTheoThang.getCount());
    }

    public void thongKeDoanhThu(int year) {
        var dsTheoThang  =dsHoaDon.stream()
                .filter(s->s.getNgayThanhToan().getYear() == year)
                .collect(Collectors.groupingBy(s->s.getNgayThanhToan().getMonth()
                        ,Collectors.summarizingDouble(HoaDon::getTien)));
        if(dsTheoThang.isEmpty()) {
            System.out.println("Nam " + year +" khong co doanh thu");
        } else {
            dsTheoThang.forEach((k,v)->System.out.printf("Thang %s%nTong doanh thu: %.3f%nTong Hoa don: %d%n",
                    k.toString(),v.getSum(),v.getCount()));
        }
    }

    public HoaDon timHoaDon(String maHoaDon) {
        return dsHoaDon.stream()
                .filter(s->s.getMaHD().equals(maHoaDon))
                .findFirst()
                .orElseGet(()->null);
    }

    @Override
    public boolean kiemTraTrong(String message) {
        if(dsHoaDon.isEmpty()) {
            System.out.println(message);
            return true;
        }
        return false;
    }
}