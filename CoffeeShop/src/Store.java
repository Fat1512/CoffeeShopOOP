import CauHinh.CauHinh;
import QuanLyBan.Ban;
import QuanLyBan.QLBan;
import QuanLyNhanSu.BoPhan.BoPhan;
import QuanLyNhanSu.BoPhan.QLBoPhan;
import QuanLyNhanSu.Enum.GioiTinh;
import QuanLyNhanSu.NhanVien;
import QuanLyNhanSu.QLNhanVien;
import QuanLySanPham.Enum.DanhMucSP;
import QuanLySanPham.Enum.LoaiThucAn;
import QuanLySanPham.Enum.LoaiThucUong;
import QuanLySanPham.Enum.ThoiDiem;
import QuanLySanPham.QLSanPham;
import QuanLySanPham.SanPham;
import QuanLySanPham.ThucAn;
import QuanLySanPham.ThucUong;
import QuanLyTaiChinh.DonDat;
import QuanLyTaiChinh.HoaDon;
import QuanLyTaiChinh.QLDatBan;
import QuanLyTaiChinh.QLDoanhThu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static CauHinh.CauHinh.batLoiNT;
import static CauHinh.CauHinh.sc;
public class Store {

    private QLBan qlBan;
    private QLDatBan qlDatBan;
    private QLDoanhThu qlDoanhThu;
    private QLBoPhan qlBoPhan;
    private QLNhanVien qlNhanVien;
    private QLSanPham qlSanPham;

    public static void main(String[] args) throws NoSuchMethodException {
        Store store = new Store();
        store.qlBan = new QLBan();
        store.qlDatBan = new QLDatBan();
        store.qlDoanhThu = new QLDoanhThu();
        store.qlNhanVien = new QLNhanVien();
        store.qlBoPhan = new QLBoPhan();
        store.qlSanPham = new QLSanPham();

        Ban b1 = new Ban(1);
        Ban b2 = new Ban(2);
        Ban b3 = new Ban(2);
        Ban b4 = new Ban(3);
        Ban b5 = new Ban(4);

        SanPham sp1 = new ThucAn("Banh mi pate", 45000, true, DanhMucSP.Thuc_An
                , false, 100, LoaiThucAn.Banh_Mi, ThoiDiem.Chieu, ThoiDiem.Toi);
        SanPham sp2 = new ThucAn("Banh nuong", 30000, true, DanhMucSP.Thuc_An
                , false, 10, LoaiThucAn.Banh_Mi, ThoiDiem.Chieu, ThoiDiem.Toi);
        SanPham sp8 = new ThucAn("Kem oc que", 30000, true, DanhMucSP.Thuc_An
                , false, 10, LoaiThucAn.Kem, ThoiDiem.Sang, ThoiDiem.Trua);
        SanPham sp9 = new ThucAn("Banh mi chay", 30000, true, DanhMucSP.Thuc_An
                , true, 10, LoaiThucAn.Banh_Mi, ThoiDiem.Sang, ThoiDiem.Toi);

        SanPham sp3 = new ThucUong("Tra sua", 32000, true, DanhMucSP.Thuc_Uong
                , false, LoaiThucUong.CaPhe, ThoiDiem.Chieu, ThoiDiem.Toi);
        SanPham sp4 = new ThucUong("Ca phe", 25000, true, DanhMucSP.Thuc_Uong
                , true, LoaiThucUong.CaPhe, ThoiDiem.Chieu, ThoiDiem.Toi);
        SanPham sp5 = new ThucUong("Ca phe sua", 28000, true, DanhMucSP.Thuc_Uong
                , true, LoaiThucUong.CaPhe, ThoiDiem.Sang, ThoiDiem.Chieu, ThoiDiem.Toi);
        SanPham sp6 = new ThucUong("Sinh to matcha", 50000, true, DanhMucSP.Thuc_Uong
                , true, LoaiThucUong.SinhTo, ThoiDiem.Chieu, ThoiDiem.Toi);
        SanPham sp7 = new ThucUong("Sinh to dau", 28000, true, DanhMucSP.Thuc_Uong
                , true, LoaiThucUong.SinhTo, ThoiDiem.Toi);


        store.qlSanPham.themSanPham(sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9);
        store.qlBan.themBan(b1, b2, b3, b4, b5);

        BoPhan bp1 = new BoPhan("Pha Che");
        BoPhan bp2 = new BoPhan("Thu Ngan");
        BoPhan bp3 = new BoPhan("Tiep Tan");
        store.qlBoPhan.themBoPhan(bp1, bp2, bp3);

        DonDat donDat1 = new DonDat();
        DonDat donDat2 = new DonDat();
        DonDat donDat3 = new DonDat();

        donDat1.themBan(b1);
        donDat1.themSanPham(sp3, 2);
        donDat1.themSanPham(sp2, 2);

        donDat2.themBan(b2);
        donDat2.themSanPham(sp2, 2);
        donDat2.themSanPham(sp1, 10);

        donDat3.themBan(b3);
        donDat3.themSanPham(sp3, 2);
        donDat3.themSanPham(sp2, 2);

        store.qlDatBan.themDonDat(donDat1);
        store.qlDatBan.themDonDat(donDat2);
        store.qlDatBan.themDonDat(donDat3);

//        NhanVien nv1 = new NhanVien("Phat", GioiTinh.Nam, "Sai Gon"
//                , LocalDate.now(), LocalDate.now().minusMonths(2), store.qlBoPhan.timKiem("BP00001"));
//        NhanVien nv2 = new NhanVien("Ngoc", GioiTinh.Nu, "Can Tho"
//                , LocalDate.now(), LocalDate.now().minusMonths(2), store.qlBoPhan.timKiem("BP00002"));
//        NhanVien nv3 = new NhanVien("Quan", GioiTinh.Nam, "Soc Trang"
//                , LocalDate.now().minusMonths(2), LocalDate.now().minusMonths(2), store.qlBoPhan.timKiem("BP00001"));
//        NhanVien nv4 = new NhanVien("Hao", GioiTinh.Nam, "Ha Noi"
//                , LocalDate.now().minusDays(253), LocalDate.now().minusMonths(2), store.qlBoPhan.timKiem("BP00003"));
//        store.qlNhanVien.themNV(nv1, nv2, nv3, nv4);
        store.getData();
        NhanVien nhanVienTrongCa = null;
        boolean flag = true;
        boolean unlock = false;
        int select = -1;
        while (flag) {
            do {
                System.out.println("--------------------- Dang  Nhap ---------------------------");
                System.out.print("Tai khoan: ");
                String userName = sc.nextLine();
                System.out.print("Mat khau: ");
                String password = sc.nextLine();
                if (store.dangNhap(userName, password) != null) {
                    nhanVienTrongCa = store.qlNhanVien.traCuu(store.dangNhap(userName, password));
                    store.qlNhanVien.setNhanVienTrongCa(nhanVienTrongCa);
                    unlock = true;
                    break;
                } else {
                    System.out.println("Mat khau hoac tai khoan khong dung!!!");
                    int opt;
                    while (true) {
                        System.out.println("""
                                1. Chon lai
                                2. Thoat """);
                        System.out.println("Nhap lua chon: ");
                        try {
                            opt = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Chi nhap so (1 hoac 2)!!");
                        }
                    }
                    if (opt == 2) {
                        flag = false;
                        break;
                    }
                }
            } while (true);
            if (unlock) {
                boolean continute = true;
                while (continute) {
                    do {
                        System.out.print("""
                                ------------ Menu ---------------
                                1. Quan ly don dat
                                2. Quan ly ban
                                3. Quan ly nhan vien
                                4. Quan ly san pham
                                5. Thanh toan
                                6. Quan ly doanh thu
                                7. Dang xuat
                                Nhap lua chon: """);
                        select = CauHinh.batLoiMenu(1, 7);
                    } while (select == -1);
                    switch (select) {
                        case 1 -> {
                            while (true) {
                                int option = 1;
                                do {
                                    System.out.print("""
                                            ------------Quan ly don dat ---------------
                                            1. Tao don dat
                                            2. In thong tin ban dat
                                            3. Them ban cho don dat
                                            4. Them san pham cho don dat    
                                            5. Xoa ban
                                            6. Xoa san pham
                                            7. Xem danh sach don dat
                                            8. Xoa don dat
                                            9. Thoat
                                            Nhap lua chon cua ban:""");
                                    option = CauHinh.batLoiMenu(1, 9);
                                } while (option == -1);
                                if (option == 9) break;
                                store.quanLyDonDat(option);
                            }
                        }
                        case 2 -> {
                            while (true) {
                                int option = -1;
                                do {
                                    System.out.print("""
                                            ------------Quan ly ban ------------
                                            1. Them ban
                                            2. Xoa ban
                                            3. Tim kiem theo so luong
                                            4. Tim kiem theo khoang suc chua
                                            5. Tim kiem theo ma ban
                                            6. Xem danh sach ban
                                            7. Lay danh sach ban trong
                                            8. Cap nhat ban
                                            9. Thoat
                                            Nhap lua chon cua ban:
                                            """);
                                    option = CauHinh.batLoiMenu(1, 9);
                                } while (option == -1);
                                if (option == 9) break;
                                store.quanLyBan(option);
                            }
                        }
                        case 3 -> {
                            do {
                                System.out.print("""
                                        ------------ Quan ly nhan vien ------------
                                        1. Them nhan vien
                                        2. Cap nhat nhan vien
                                        3. Xoa nhan vien
                                        4. Xem danh sach nhan vien
                                        5. Xem danh sach nhan vien co sinh nhat trong thang
                                        6. Tra cuu nhan vien
                                        7. Thoat
                                        Nhap lua chon:""");
                                int lc;
                                do {
                                    lc = CauHinh.batLoiMenu(1, 7);
                                } while (lc == -1);
                                if (lc == 7) break;
                                store.quanLyNhanVien(lc);
                            } while (true);
                        }
                        case 4 -> {
                            do {
                                System.out.print("""
                                        ------------ Quan ly thuc an thuc uong ------------
                                        1. Them thuc an / uong
                                        2. Xoa thuc an / uong
                                        3. Tim kiem thuc an / uong
                                        4. Sap xep thuc an / uong
                                        5. In san pham
                                        6. Cap nhat san pham
                                        7. Thoat
                                        Nhap lua chon:""");
                                int lc;
                                do {
                                    lc = CauHinh.batLoiMenu(1, 7);
                                } while (lc == -1);
                                if (lc == 7) break;
                                store.quanLyThucAnUong(lc);
                            } while (true);
                        }
                        case 5 -> {
                            System.out.print("Nhap ma don dat muon thanh toan: ");
                            DonDat thanhToan = store.qlDatBan.thanhToan(sc.nextLine());
                            if (thanhToan == null) {
                                System.out.println("Ma don khong ton tai!!");
                                break;
                            } else if (thanhToan.getThongTinBan().isEmpty() || thanhToan.getThongTinSanPham().isEmpty()) {
                                System.out.println("Don khong hop le");
                                break;
                            }
                            HoaDon hoaDon = new HoaDon(thanhToan, nhanVienTrongCa);
                            hoaDon.inHoanDon();
                            store.qlDoanhThu.themHoaDon(hoaDon);
                        }
                        case 6 -> {
                            while (true) {
                                int option = -1;
                                do {
                                    System.out.println("""
                                            1. Thong ke doan thu theo 1 thang
                                            2. Thong ke doanh thu theo tat ca thang trong nam
                                            3. Thong ke doanh thu theo khoang ngay
                                            4. In lai hoa don
                                            5. Thoat
                                            Nhap lua chon: """);
                                    option = CauHinh.batLoiMenu(1, 5);
                                } while (option == -1);
                                if (option == 5) break;
                                store.quanLyDoanhThu(option);
                            }
                        }
                        case 7 -> {
                            unlock = false;
                            continute = false;
                            System.out.print("Ban co muon thoat ca chuong trinh(Y de thoat) : ");
                            if (sc.nextLine().equalsIgnoreCase("Y")) {
                                flag = false;
                            }
                            store.insert();
                        }
                    }
                }
            }
        }
    }
    private void quanLyDoanhThu(int select) {
        switch (select) {
            case 1 -> {
                Month month1 = null;
                do {
                    try {
                        System.out.println("Nhap thang muon thong ke: ");
                        int month = Integer.parseInt(sc.nextLine());
                        month1 = Month.of(month);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Vui long nhap so");
                    } catch (DateTimeException e) {
                        System.out.println("Vui long nhap tu thang 1 den thang 12");
                    }
                } while (true);
                qlDoanhThu.thongKeDoanhThu(month1);
            }
            case 2 -> {
                int year;
                while (true) {
                    System.out.print("Nhap nam muon thong ke: ");
                    try {
                        year = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi duoc nhap so");
                    }
                }
                qlDoanhThu.thongKeDoanhThu(year);
            }
            case 4 -> {
                sc.nextLine();
                System.out.println("Nhap ma hoa don can tim: ");
                HoaDon hoaDon = qlDoanhThu.timHoaDon(sc.nextLine());
                qlDoanhThu.kiemTraTrong(hoaDon, HoaDon::inHoanDon, "Khong ton tai hoa don");
            }
            case 3 -> {
                sc.nextLine();
                String fromDate = null;
                String toDate = null;
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                do {
                    System.out.println("Nhap vao ngay muon thong ke: ");
                    fromDate = sc.nextLine();
                } while (!CauHinh.batLoiNT(fromDate));
                do {
                    System.out.println("Nhap vao ngay ket thuc: ");
                    toDate = sc.nextLine();
                } while (!CauHinh.batLoiNT(toDate));
                qlDoanhThu.thongKeDoanhThu(LocalDate.parse(fromDate, dateTimeFormatter)
                        , LocalDate.parse(toDate, dateTimeFormatter));
            }
        }
    }

    private void quanLyDonDat(int select) {
        switch (select) {
            case 1 -> {
                DonDat donDat = new DonDat();
                if (qlDatBan.themDonDat(donDat)) {
                    while (true) {
                        quanLyBan(3);
                        System.out.println("Nhap ma ban de them ban: ");
                        if (donDat.themBan(qlBan.timKiem(sc.nextLine()))) {
                            System.out.println("Them ban vao don dat thanh cong!!");
                            break;
                        } else {
                            System.out.println("Them ban khong thanh cong!!!");
                            int opt;
                            while (true) {
                                System.out.println("""
                                        1. Chon lai
                                        2. Thoat """);
                                System.out.println("Nhap lua chon: ");
                                try {
                                    opt = Integer.parseInt(sc.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Chi nhap so (1 hoac 2)!!");
                                }
                            }
                            if (opt == 2) break;
                        }
                    }
                    while (true) {
                        quanLyThucAnUong(5);
                        System.out.println("Nhap ten san pham: ");
                        String name = sc.nextLine();
                        int sl;
                        while (true) {
                            System.out.println("Nhap so luong: ");
                            try {
                                sl = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Chi nhap so!!");
                            }
                        }
                        SanPham sanPham = qlSanPham.timKiem(name);
                        if (donDat.themSanPham(sanPham, sl)) {
                            System.out.println("Them san pham thanh cong");
                            int continute;
                            while (true) {
                                try {
                                    System.out.print("""
                                            1. Tiep tuc chon
                                            2. Thoat
                                            Nhap lua chon cua ban: """);
                                    continute = Integer.parseInt(sc.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Chi nhap so");
                                }
                            }
                            if (continute == 2) break;

                        } else {
                            int opt;
                            while (true) {
                                System.out.println("""
                                        1. Chon lai
                                        2. Thoat """);
                                System.out.println("Nhap lua chon: ");
                                try {
                                    opt = Integer.parseInt(sc.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Chi nhap so (1 hoac 2)!!");
                                }
                            }
                            if (opt == 2) break;
                        }
                    }
                } else {
                    System.out.println("Loi");
                }
            }
            case 2 -> {
                System.out.print("Nhap ma don muon xem: ");
                DonDat donDat = qlDatBan.timDonDat(sc.nextLine());
                qlDatBan.kiemTraTrong(donDat, DonDat::inThongTinBanDat, "Khong ton tai ma don");
            }
            case 3 -> {
                System.out.println("Nhap ma don can them: ");
                DonDat donDat = qlDatBan.timDonDat(sc.nextLine());
                if (donDat == null) {
                    System.out.println("Khon ton tai don dat");
                    break;
                }
                quanLyBan(3);
                System.out.print("Nhap ma ban de them ban: ");
                if (donDat.themBan(qlBan.timKiem(sc.next()))) {
                    System.out.println("Them ban vao don dat thanh cong!!");
                } else {
                    System.out.println("Them ban vao don dat khong thanh cong!!");
                }
                sc.nextLine();
            }
            case 4 -> {
                System.out.print("Nhap ma don can them: ");
                DonDat donDat = qlDatBan.timDonDat(sc.nextLine());
                if (donDat == null) {
                    System.out.println("Khong ton tai don dat");
                    break;
                }
                quanLyThucAnUong(5);
                System.out.println("Nhap ten san pham: ");
                String name = sc.nextLine();
                int sl;
                while (true) {
                    System.out.println("Nhap so luong: ");
                    try {
                        sl = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi dc nhap so");
                    }
                }
                SanPham sanPham = qlSanPham.timKiem(name);
                if (donDat.themSanPham(sanPham, sl)) {
                    System.out.println("Them san pham thanh cong");
                }

            }
            case 5 -> {
                System.out.print("Nhap ma don can xoa ban: ");
                DonDat donDat = qlDatBan.timDonDat(sc.nextLine());
                if (donDat == null) {
                    System.out.println("Khong ton tai don dat");
                    break;
                }
                donDat.inThongTinBanDat();
                System.out.print("Nhap ma ban can xoa: ");
                if (donDat.xoaBan(sc.nextLine())) {
                    System.out.println("Xoa ban thanh cong");
                } else {
                    System.out.println("Loi khong xoa dc ban");
                }
            }
            case 6 -> {
                System.out.print("Nhap ma don can xoa san pham: ");
                DonDat donDat = qlDatBan.timDonDat(sc.nextLine());
                if (donDat == null) {
                    System.out.println("Khong ton tai don dat");
                    break;
                }
                donDat.inThongTinBanDat();
                System.out.print("Nhap ten san pham can xoa: ");
                SanPham sanPham = qlSanPham.timKiem(sc.nextLine());
                int sl;
                while (true) {
                    System.out.print("Nhap so luong: ");
                    try {
                        sl = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi dc nhap so");
                    }
                }
                if (sanPham == null) {
                    System.out.println("Khong ton tai san pham");
                    break;
                }
                if (donDat.xoaSanPham(sanPham, sl)) {
                    System.out.println("Xoa san pham thanh cong");
                }
            }
            case 7 -> {
                qlDatBan.inDSDonDat();
            }
            case 8 -> {
                qlDatBan.inDSDonDat();
                System.out.println("Nhap ma don can xoa: ");
                if (qlDatBan.xoaDonDat(sc.nextLine())) {
                    System.out.println("Xoa don dat thanh cong!!");
                }
            }
        }
    }

    private void quanLyBan(int select) {
        switch (select) {
            case 1 -> {
                int sucChua;
                while (true) {
                    System.out.print("Nhap so luong cho ngoi: ");
                    try {
                        sucChua = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi nhap so");
                    }
                }
                if (qlBan.themBan(new Ban(sucChua))) {
                    System.out.println("Them ban thanh cong !!!");
                } else {
                    System.out.println("Them ban that bai !!!!!");
                }
            }
            case 2 -> {
                System.out.print("Nhap ma ban muon xoa: ");
                String maBan = sc.nextLine();
                if (qlBan.xoaBan(maBan)) {
                    System.out.println("Xoa ban thanh cong!!!");
                } else {
                    System.out.println("Xoa ban that bai!!!");
                }
            }
            case 3 -> {
                int sucChua;
                while (true) {
                    System.out.print("Nhap so luong cho ngoi muon tim: ");
                    try {
                        sucChua = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi nhap so");
                    }
                }
                List<Ban> bans = qlBan.timKiem(sucChua);
                qlBan.kiemTraTrong(bans, qlBan::xuatDS, "Khong co loi ban phu hop");
            }
            case 4 -> {
                int min;
                int max;
                while (true) {
                    System.out.print("Nhap suc chua min: ");
                    try {
                        min = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi dc nhap so");
                    }
                }
                while (true) {
                    System.out.print("Nhap suc chua max: ");
                    try {
                        max = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Chi dc nhap so");
                    }
                }

                List<Ban> bans = qlBan.timKiem(min, max);
                qlBan.kiemTraTrong(bans, qlBan::xuatDS, "Khong co loi ban phu hop");
            }
            case 5 -> {
                System.out.print("Nhap ma ban muon tim: ");
                Ban ban = qlBan.timKiem(sc.nextLine());
                qlBan.kiemTraTrong(ban, x -> {
                    System.out.println(Ban.layHeaderDS());
                    System.out.println(ban);
                }, "Khong ton tai ma ban!!!");
            }
            case 6 -> {
                System.out.println("Danh sach tat ca ban trong quan");
                qlBan.xuatDS();
            }
            case 7 -> {
                System.out.println("Danh sach ban trong hien tai: ");
                List<Ban> dsBanTrong = qlBan.layDsBanTrong();
                qlBan.kiemTraTrong(dsBanTrong, qlBan::xuatDS, "Hien tai khong co ban trong");
            }
            case 8 -> {
                int option = -1;
                do {
                    System.out.println("""
                            1. Cap nhat so luong
                            2. Cap nhat tinh trang
                            3. Thoat""");
                    option = CauHinh.batLoiMenu(1, 3);
                } while (option == -1);
                switch (option) {
                    case 1 -> {
                        System.out.print("Nhap ma ban can cap nhat so luong: ");
                        Ban ban = qlBan.timKiem(sc.nextLine());
                        if (ban == null) {
                            System.out.println("Ma ban khong ton tai");
                            break;
                        }
                        System.out.println(Ban.layHeaderDS());
                        System.out.println(ban);
                        int sucChua = 0;
                        while (true) {
                            try {
                                System.out.print("Nhap suc chua moi: ");
                                sucChua = Integer.parseInt(sc.nextLine());
                                if (sucChua < 0) {
                                    throw new Error("Suc chua phai lon hon 0");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Loi cu phap!!! Chi dc nhap so");
                            } catch (Error e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        ban.setSucChua(sucChua);
                        System.out.println("Cap nhat thanh cong !!!!");

                    }
                    case 2 -> {
                        System.out.print("Nhap ma ban can cap nhat tinh trang: ");
                        Ban ban = qlBan.timKiem(sc.nextLine());
                        if (ban == null) {
                            System.out.println("Ma ban khong ton tai");
                            break;
                        }
                        System.out.println(Ban.layHeaderDS());
                        System.out.println(ban);
                        int tinhTrang = 0;
                        while (true) {
                            System.out.print("Nhap tinh trang hien tai(Trong(0) | Da dat(1) )");
                            try {
                                tinhTrang = Integer.parseInt(sc.nextLine());
                                if (tinhTrang < 0 || tinhTrang > 1) {
                                    throw new Error("Nhap 1 hoac 0");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Loi cu phap!! Chi nhap so");
                            } catch (Error e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        ban.setTinhTrang(tinhTrang == 0 ? false : true);
                        System.out.println("Cap nhat tinh trang thanh cong!!!");

                    }
                }
            }
        }
    }

    public void quanLyNhanVien(int luaChon) throws NoSuchMethodException {
        switch (luaChon) {
            case 1 -> {
                if (qlBoPhan.kiemTraTrong("Danh sach bo phan trong ! Khong the them nhan vien")) return;
                String hoTen, queQuan;
                GioiTinh gioiTinh;
                LocalDate ngaySinh, ngayVaoLam;
                BoPhan boPhan;
                //Ho ten
                System.out.print("Ho ten: ");
                hoTen = CauHinh.sc.nextLine();

                //Gioi tinh
                int gioiTinhInput;
                do {
                    System.out.print("Gioi tinh: Nam(0) / Nu(1): ");
                    gioiTinhInput = CauHinh.batLoiMenu(0, 1);
                } while (gioiTinhInput == -1);
                gioiTinh = gioiTinhInput == 0 ? GioiTinh.Nam : GioiTinh.Nu;

                //Que quan
                System.out.print("Que quan: ");
                queQuan = CauHinh.sc.nextLine();

                String ngaySinhs, ngayVaoLams;
                //Ngay sinh
                do {
                    System.out.print("Ngay sinh(dd/MM/yyyy): ");
                    ngaySinhs = CauHinh.sc.nextLine();
                } while (!CauHinh.batLoiNT(ngaySinhs));

                //Ngay vao lam
                do {
                    System.out.print("Ngay vao lam(dd/MM/yyyy): ");
                    ngayVaoLams = CauHinh.sc.nextLine();
                } while (!CauHinh.batLoiNT(ngayVaoLams));
                ngaySinh = LocalDate.parse(ngaySinhs, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                ngayVaoLam = LocalDate.parse(ngayVaoLams, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                //Bo phan
                do {
                    System.out.println("Danh sach bo phan: ");
                    qlBoPhan.xuatDS();
                    System.out.print("\nNhap ma bo phan: ");
                    String maBP = CauHinh.sc.nextLine();
                    boPhan = qlBoPhan.timKiem(maBP);
                    if (boPhan != null) {
                        break;
                    }
                    System.out.println("Sai ma bo phan");
                } while (true);
                qlNhanVien.themNV(new NhanVien(hoTen, gioiTinh, queQuan, ngaySinh, ngayVaoLam, boPhan));
            }
            case 2 -> {
                if (qlBoPhan.kiemTraTrong("Danh sach bo phan trong ! Khong the cap nhat nhan vien") ||
                        qlNhanVien.kiemTraTrong("Danh sach nhan vien trong ! Khong the cap nhat nhan vien")) return;

                System.out.println("Nhap ma nhan vien muon cap nhat: ");
                String ma = CauHinh.sc.nextLine();
                NhanVien nv = qlNhanVien.traCuu(ma);
                if (nv == null) {
                    System.out.println("Khong tim thay nhan vien");
                    return;
                }

                boolean subIsThoat = false;
                while (!subIsThoat) {
                    System.out.println(QLNhanVien.layHeaderDS());
                    System.out.println(nv);
                    System.out.println("-".repeat(105));
                    int lc;
                    do {
                        System.out.println("""
                                ----------------------------------------------
                                1. Ho Ten
                                2. Gioi Tinh
                                3. Que Quan
                                4. Ngay Sinh
                                5. Ngay Vao Lam
                                6. Bo Phan
                                7. Thoat
                                ----------------------------------------------
                                Nhap lua chon : """);
                        lc = CauHinh.batLoiMenu(1, 8);
                    } while (lc == -1);

                    String truongDuLieu;
                    switch (lc) {
                        case 1 -> {
                            System.out.println("Nhap vao ho ten: ");
                            truongDuLieu = CauHinh.sc.nextLine();
                            nv.setHoTen(truongDuLieu);
                        }
                        case 2 -> {
                            GioiTinh gioiTinh;
                            int gioiTinhInput;
                            System.out.print("Gioi tinh: Nam(0) / Nu(1): ");
                            do {
                                gioiTinhInput = CauHinh.batLoiMenu(0, 1);
                            } while (gioiTinhInput == -1);
                            gioiTinh = gioiTinhInput == 0 ? GioiTinh.Nam : GioiTinh.Nu;
                            nv.setGioiTinh(gioiTinh);
                        }
                        case 3 -> {
                            System.out.println("Nhap vao que quan: ");
                            truongDuLieu = CauHinh.sc.nextLine();
                            nv.setQueQuan(truongDuLieu);
                        }
                        case 4 -> {
                            do {
                                System.out.println("Nhap vao ngay sinh: ");
                                truongDuLieu = CauHinh.sc.nextLine();
                            } while (batLoiNT(truongDuLieu));
                            nv.setNgaySinh(LocalDate.parse(truongDuLieu, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        }
                        case 5 -> {
                            do {
                                System.out.println("Nhap vao ngay vao lam: ");
                                truongDuLieu = CauHinh.sc.nextLine();
                            } while (batLoiNT(truongDuLieu));
                            nv.setNgayVaoLam(LocalDate.parse(truongDuLieu, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        }
                        case 6 -> {
                            BoPhan boPhan;
                            do {
                                System.out.println("Danh sach bo phan: ");
                                qlBoPhan.xuatDS();
                                System.out.print("\nNhap ma bo phan: ");

                                truongDuLieu = CauHinh.sc.nextLine();
                                boPhan = qlBoPhan.timKiem(truongDuLieu);
                                if (boPhan != null)
                                    break;
                                System.out.println("Sai ma bo phan");
                            } while (true);
                            nv.setBoPhan(qlBoPhan.timKiem(truongDuLieu));
                        }
                        case 7 -> subIsThoat = true;
                    }
                }
            }
            case 3 -> {
                System.out.print("Nhap ma nhan vien muon xoa: ");
                String ma = CauHinh.sc.nextLine();
                if(qlNhanVien.traCuu(ma) == qlNhanVien.getNhanVienTrongCa()) {
                    System.out.println("Nhan vien dang trong ca khong the xoa");
                }
                else if (qlNhanVien.xoaNV(ma)) {
                    System.out.println("Xoa thanh cong");
                } else {
                    System.out.println("Khong ton tai ma nhan vien");
                }
            }
            case 4 -> {
                if (qlNhanVien.kiemTraTrong("Danh sach trong")) break;
                qlNhanVien.xuatDS();
            }
            case 5 -> {
                List<NhanVien> dsNV = qlNhanVien.layDSSN();
                qlNhanVien.kiemTraTrong(dsNV, ds -> qlNhanVien.xuatDS(ds), "Danh sach trong");
            }
            case 6 -> {
                boolean subIsThoat = false;
                while (!subIsThoat) {
                    int lc;
                    do {
                        System.out.print("""
                                ----------------------------------------------
                                1. Tra cuu nhan vien theo ho ten
                                2. Tra cuu nhan vien theo gioi tinh
                                3. Tra cuu nhan vien theo ngay sinh
                                4. Tra cuu nhan vien theo que quan
                                5. Thoat
                                ----------------------------------------------
                                Nhap lua chon:""");
                        lc = CauHinh.batLoiMenu(1, 5);
                    } while (lc == -1);
                    List<NhanVien> dsNV = null;
                    switch (lc) {
                        case 1 -> {
                            //Ho ten
                            Method method = NhanVien.class.getMethod("getHoTen");
                            System.out.print("Nhap vao ho ten: ");
                            String hoTen = CauHinh.sc.nextLine();
                            dsNV = qlNhanVien.traCuu(method, hoTen);
                        }
                        case 2 -> {
                            //Gioi tinh
                            Method method = NhanVien.class.getMethod("getGioiTinh");
                            GioiTinh gioiTinh;

                            int gioiTinhInput;
                            System.out.print("Gioi tinh: Nam(0) / Nu(1): ");
                            do {
                                gioiTinhInput = CauHinh.batLoiMenu(0, 1);
                            } while (gioiTinhInput == -1);
                            gioiTinh = gioiTinhInput == 0 ? GioiTinh.Nam : GioiTinh.Nu;

                            dsNV = qlNhanVien.traCuu(method, String.valueOf(gioiTinh));
                        }
                        case 3 -> {
                            //ngay sinh
                            Method method = NhanVien.class.getMethod("getNgaySinh");
                            String ngaySinhs;
                            do {
                                System.out.print("Ngay sinh(dd/MM/yyyy): ");
                                ngaySinhs = CauHinh.sc.nextLine();
                            } while (batLoiNT(ngaySinhs));
                            LocalDate ngaySinh = LocalDate.parse(ngaySinhs, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            dsNV = qlNhanVien.traCuu(method, ngaySinh.toString());
                        }
                        case 4 -> {
                            //Que quan
                            Method method = NhanVien.class.getMethod("getQueQuan");
                            System.out.print("""
                                    Nhap vao que quan :""");
                            String queQuan = CauHinh.sc.nextLine();
                            dsNV = qlNhanVien.traCuu(method, queQuan);
                        }
                        case 5 -> {
                            subIsThoat = true;
                            break;
                        }
                    }
                    if (subIsThoat) break;
                    qlNhanVien.kiemTraTrong(dsNV, ds -> qlNhanVien.xuatDS(ds), "Khong ton tai nhan vien");
                }
            }
            case 7 -> {
                return;
            }
        }
    }

    public void quanLyThucAnUong(int luaChon) {
        switch (luaChon) {
            case 1 -> {
                boolean subIsThoat = false;
                while (!subIsThoat) {
                    int lc;
                    do {
                        System.out.print("""
                                1. Them thuc an
                                2. Them thuc uong
                                3. Thoat
                                Nhap lua chon:""");
                        lc = CauHinh.batLoiMenu(1, 3);
                    } while (lc == -1);
                    SanPham sp = null;
                    switch (lc) {
                        case 1 -> {
                            sp = new ThucAn();
                            sp.nhapThongTin();
                        }
                        case 2 -> {
                            sp = new ThucUong();
                            sp.nhapThongTin();
                        }
                        case 3 -> subIsThoat = true;
                    }
                    if (!subIsThoat) {
                        qlSanPham.themSanPham(sp);
                        System.out.println(sp.getDanhMuc().layHeaderDS());
                        System.out.println(sp);
                    }
                }
            }
            case 2 -> {
                System.out.print("Nhap ten thuc an / uong: ");
                String ten = CauHinh.sc.nextLine();
                if (qlSanPham.xoaSanPham(ten)) {
                    System.out.println("Xoa thanh cong");
                } else {
                    System.out.println("Xoa khong thanh cong ! Khong tim thay do an uong");
                }
            }
            case 3 -> {
                boolean subIsThoat = false;
                while (!subIsThoat) {

                    int lc;
                    do {
                        System.out.print("""
                                ----------------------------------------------
                                1. Tim theo ten
                                2. Tim theo khoang gia
                                3. Thoat
                                ----------------------------------------------
                                Nhap lua chon:""");
                        lc = CauHinh.batLoiMenu(1, 3);

                    } while (lc == -1);
                    switch (lc) {
                        case 1 -> {
                            System.out.print("Nhap ten muon tim: ");
                            String ten = CauHinh.sc.nextLine();
                            SanPham sp = qlSanPham.timKiem(ten);
                            if (sp != null) {
                                System.out.println(sp.getDanhMuc().layHeaderDS());
                                System.out.println(sp);
                            } else
                                System.out.println("Ten khong ton tai");
                        }
                        case 2 -> {
                            double giaDau, giaCuoi;
                            do {
                                try {
                                    System.out.print("Nhap gia bat dau: ");
                                    giaDau = Double.parseDouble(CauHinh.sc.nextLine());
                                    System.out.print("Nhap gia ket thuc: ");
                                    giaCuoi = Double.parseDouble(CauHinh.sc.nextLine());
                                    break;
                                } catch (NumberFormatException error) {
                                    System.out.println("Loi bat chu");
                                }
                            } while (true);
                            Map<DanhMucSP, List<SanPham>> dsSP = qlSanPham.timKiem(giaDau, giaCuoi);
                            if (dsSP.isEmpty()) {
                                System.out.println("Khong tim thay san pham trong khoang gia");
                                break;
                            }
                            dsSP.forEach((k, v) -> qlSanPham.xuatDS(k, v));
                        }
                        case 3 -> {
                            subIsThoat = true;
                        }
                    }
                }

            }
            case 4 -> {
                boolean subIsThoat = false;
                while (!subIsThoat) {

                    int lc;
                    do {
                        System.out.println("""
                                ----------------------------------------------
                                Sap xep theo danh sanh:
                                1. Thuc uong
                                2. Thuc An
                                3. Tat ca
                                4. Thoat
                                ----------------------------------------------
                                Nhap lua chon:""");
                        lc = CauHinh.batLoiMenu(1, 4);
                    } while (lc == -1);
                    String subMenu = """
                            ----------------------------------------------
                            1. Giam dan gia
                            2. Tang dan gia
                            3. Thoat
                            ----------------------------------------------
                            Nhap lua chon:""";
                    var cmp = Comparator.comparing(SanPham::getGiaBan);
                    switch (lc) {
                        case 1 -> {
                            do {
                                System.out.print(subMenu);
                                lc = CauHinh.batLoiMenu(1, 3);
                            } while (lc == -1);
                            switch (lc) {
                                case 1 -> qlSanPham.sapXep(DanhMucSP.Thuc_Uong, cmp.reversed());
                                case 2 -> qlSanPham.sapXep(DanhMucSP.Thuc_Uong, cmp);
                            }
                        }
                        case 2 -> {
                            do {
                                System.out.print(subMenu);
                                lc = CauHinh.batLoiMenu(1, 3);
                            } while (lc == -1);
                            switch (lc) {
                                case 1 -> qlSanPham.sapXep(DanhMucSP.Thuc_An, cmp.reversed());
                                case 2 -> qlSanPham.sapXep(DanhMucSP.Thuc_An, cmp);
                            }
                        }
                        case 3 -> {
                            do {
                                System.out.print(subMenu);
                                lc = CauHinh.batLoiMenu(1, 3);
                            } while (lc == -1);
                            switch (lc) {
                                case 1 -> qlSanPham.sapXep(cmp.reversed());
                                case 2 -> qlSanPham.sapXep(cmp);
                            }
                        }
                        case 4 -> {
                            subIsThoat = true;
                            break;
                        }
                    }
                }
            }
            case 5 -> qlSanPham.xuatDS();
            case 6 -> {
                int option;
                do {
                    System.out.print("""
                        1. Thuc an
                        2. Thuc uong
                        3. Thoat
                        Vui long chon:""");
                    option = CauHinh.batLoiMenu(1, 2);
                } while (option == -1);
                if(option == 3) {
                    break;
                }
                System.out.print("Nhap ten muon tim: ");
                String ten = CauHinh.sc.nextLine();
                switch(option) {
                    case 1 -> {
                        SanPham sp = qlSanPham.timKiem(DanhMucSP.Thuc_An, ten);
                        if(sp == null) {
                            System.out.println("San pham khong ton tai");
                            break;
                        }
                        System.out.print("Nhap so luong muon them vao: ");
                        int sl;
                        do {
                            try {
                                sl = Integer.parseInt(sc.nextLine());
                                if(sl <= 0) {
                                    throw new Error("so luong phai > 0");
                                }
                                break;
                            } catch (Error e) {
                                System.out.println(e.getMessage());
                            } catch (NumberFormatException ex) {
                                System.out.println("Loi nhap chu!");
                            }
                        } while(true);
                        if(sp instanceof ThucAn s) {
                            s.setSoLuong(s.getSoLuong() + sl);
                            s.setTinhTrang(true);
                        }
                    }
                    case 2 -> {
                        SanPham sp = qlSanPham.timKiem(DanhMucSP.Thuc_Uong, ten);
                        if(sp == null) {
                            System.out.println("San pham khong ton tai");
                            break;
                        }
                        int tinhTrang;
                        do {
                            System.out.print("Tinh trang (Con: 1, Khong con: 0): ");
                            tinhTrang = CauHinh.batLoiMenu(0, 1);
                        } while (tinhTrang == -1);
                        boolean boolTinhTrang = tinhTrang != 0;
                        sp.setTinhTrang(boolTinhTrang);
                    }
                }
            }
            case 7 -> {
                return;
            }
        }
    }

    public String dangNhap(String tk, String mk) {
        try (Scanner scanner = new Scanner(Path.of("CoffeeShop\\src\\Account.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data[0].trim().equals(tk) && data[1].trim().equals(mk)) {
                    return data[0];
                }
            }
        } catch (IOException e) {
            System.out.println("Loi Khong tim thay file");
        }
        return null;
    }

    public void getData() {
        try (Scanner scanner = new Scanner(Path.of("CoffeeShop\\src\\Account.txt"))){
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Arrays.asList(data).replaceAll(String::trim);
                GioiTinh gioiTinh = GioiTinh.valueOf(data[3]);
                BoPhan boPhan = qlBoPhan.timKiem(data[7]);
                LocalDate ngaySinh =  LocalDate.parse(data[5],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate ngayVaoLam =  LocalDate.parse(data[6],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                NhanVien nhanVien = new NhanVien(data[2],gioiTinh,data[4],ngaySinh,ngayVaoLam,boPhan,data[0],data[1]);
                qlNhanVien.themNV(nhanVien);
            }
        } catch (IOException e) {
            System.out.println("Loi Khong tim thay file");
        }
    }

    public void insert() {
        try(PrintWriter writer = new PrintWriter("CoffeeShop\\src\\Account.txt")) {
            for (var x : qlNhanVien.layDSNV()) {
                writer.println(x.wrapInfo());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        }
    }
}