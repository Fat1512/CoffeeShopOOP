package CauHinh;

import java.time.DateTimeException;
import java.util.Scanner;

public class CauHinh {
    public static Scanner sc = new Scanner(System.in);
    public static int batLoiMenu(int soDau, int soCuoi) {
        int luaChon;
        try {
            luaChon = Integer.parseInt(sc.nextLine());
            if(luaChon < soDau|| luaChon > soCuoi) {
                throw new RuntimeException("Vui long nhap tu " + soDau + " den " + soCuoi);
            }
            return luaChon;
        } catch (NumberFormatException error1) {
            System.out.println("Loi nhap chu");
            return -1;
        } catch (RuntimeException error2) {
            System.out.println(error2.getMessage());
            return -1;
        }
    }
    public static boolean batLoiNT(String date) {
        String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
        try {
            if (date.matches(regex)) return true;
            throw new DateTimeException("Nhap sai dinh dang ngay thang(dd/mm/yyyy)!!! ");
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (RuntimeException e) {
            System.out.println("Loi gi do");
            return false;
        }
    }
}
