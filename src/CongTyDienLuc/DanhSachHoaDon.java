package CongTyDienLuc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachHoaDon {
    private List<HoaDon> arr;
    public DanhSachHoaDon() {
        this.arr = new ArrayList<>();
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\r?\n");
        System.out.println("Cau 1: ");
        System.out.print("Nhap so hoa don: ");
        int soHoaDon = sc.nextInt();
        for (int i = 0; i < soHoaDon; i++) {
            System.out.println("########################");
            System.out.println("1: Ho kinh doanh");
            System.out.println("2: Ho binh thuong");
            System.out.print("Chon loai ho hoa don: ");
            int flag = sc.nextInt();

            if (flag == 1) {
                HoKinhDoanh h = new HoKinhDoanh();
                sc.nextLine();
                System.out.print("Nhap ma khach hang: ");
                h.setMaKH(sc.nextLine());
                System.out.print("Nhap ten khach hang: ");
                h.setTenKH(sc.nextLine());
                System.out.print("Nhap chi so dien cu: ");
                h.setChiSoCu(sc.nextInt());
                System.out.print("Nhap chi so dien moi: ");
                h.setChiSoMoi(sc.nextInt());

                System.out.println("1: Nha hang");
                System.out.println("2: Khach san");
                System.out.println("3: Tu nhan");
                System.out.println("4: Nha nuoc");
                System.out.print("Loai kinh doanh cua ban la: ");
                int linhVucKinhDoanh = sc.nextInt();
                if (linhVucKinhDoanh == 1) {
                    h.setLinhVuc(HoKinhDoanh.NHA_HANG);
                } else if (linhVucKinhDoanh == 2) {
                    h.setLinhVuc(HoKinhDoanh.KHACH_SAN);
                } else if (linhVucKinhDoanh == 3) {
                    h.setLinhVuc(HoKinhDoanh.TU_NHAN);
                } else if (linhVucKinhDoanh == 4) {
                    h.setLinhVuc(HoKinhDoanh.NHA_NUOC);
                }
                this.arr.add(h);
            } else if (flag == 2) {
                HoaDon h = new HoBinhThuong();
                sc.nextLine();
                System.out.print("Nhap ma khach hang: ");
                h.setMaKH(sc.nextLine());
                System.out.print("Nhap ten khach hang: ");
                h.setTenKH(sc.nextLine());
                System.out.print("Nhap chi so dien cu: ");
                h.setChiSoCu(sc.nextInt());
                System.out.print("Nhap chi so dien moi: ");
                h.setChiSoMoi(sc.nextInt());
                this.arr.add(h);
            }
        }
    }

    public void xuat() {
        System.out.println("Cau 2: ");
        for (HoaDon h : this.arr) {
            h.xuat();
        }
    }

    public void cau3() {
        System.out.println("Cau 3: ");
        long tongTienThanhToan = this.arr.stream().mapToLong(HoaDon::tinhTienThanhToan).sum();
        System.out.println("Tong tien dien cac ho su dung: " + tongTienThanhToan);
    }

    public int tinhSoKwNhieuNhat() {
        return this.arr.stream().filter(k -> k instanceof HoKinhDoanh).mapToInt(HoaDon::tinhKwTieuThu)
                .max().getAsInt();
    }

    public void cau4() {
        // Cach 1
        System.out.println("Cau 4: ");
        int maxDien = tinhSoKwNhieuNhat();
        for (HoaDon h : this.arr) {
            if (h.tinhKwTieuThu() == maxDien && h instanceof HoKinhDoanh) {
                System.out.println("Ma khach hang " + h.getMaKH() + " su dung dien nhieu nhat!");
            }
        }

        // Cach 2
        this.arr.stream()
                .filter(k -> k.tinhKwTieuThu() == maxDien && k instanceof HoKinhDoanh)
                .forEach(k -> {
                    System.out.println("Ho kinh doanh voi ma khach hang: " + k.getMaKH() + ", ten khach hang: " + k.getTenKH() + ", su dung dien nhieu nhat!");
                });
    }
}