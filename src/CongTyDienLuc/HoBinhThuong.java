package CongTyDienLuc;

public class HoBinhThuong extends HoaDon {
    public static final int M1 = 1500;
    public static final int M2 = 2000;
    public static final int M3 = 2800;

    @Override
    public long tinhTienDien() {
        int soKwTieuThu = this.tinhKwTieuThu();
        long tienDien = 0;
        if (soKwTieuThu < 51) {
            tienDien = soKwTieuThu * M1;
        } else if (soKwTieuThu < 101) {
            tienDien = 50 * M1 + (soKwTieuThu - 50) * M2;
        } else {
            tienDien = 50 * M1 + 50 * M2 + (soKwTieuThu - 100) * M3;
        }
        return tienDien;
    }

    @Override
    public long tinhTienThanhToan() {
        long tienDien = tinhTienDien();
        long thue = tienDien * this.VAT / 100;
        this.tienThanhToan = tienDien + thue;
        return this.tienThanhToan;
    }

    @Override
    public void xuat(){
        System.out.print("Ho binh thuong (");
        super.xuat();
        System.out.println(")");
    }
}
