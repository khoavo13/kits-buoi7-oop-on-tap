package CongTyDienLuc;

public class HoKinhDoanh extends HoaDon {
    public static final int NHA_HANG = 1;
    public static final int KHACH_SAN = 2;
    public static final int TU_NHAN = 3;
    public static final int NHA_NUOC = 4;

    public static final int UU_DAI = 5;
    protected int linhVuc;

    public int getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(int linhVuc) {
        this.linhVuc = linhVuc;
    }

    @Override
    public long tinhTienDien() {
        return this.tinhKwTieuThu() * 3000;
    }

    @Override
    public long tinhTienThanhToan() {
        long tienDien = tinhTienDien();
        long thue = tienDien * this.VAT / 100;
        long tienUuDai = 0;
        if (this.linhVuc == NHA_NUOC){
            tienUuDai = tienDien * this.UU_DAI / 100;
        }

        this.tienThanhToan = tienDien + thue - tienUuDai;
        return this.tienThanhToan;
    }

    @Override
    public void xuat(){
        System.out.print("Ho kinh doanh (");
        super.xuat();
        if (this.linhVuc == NHA_HANG){
            System.out.println(", linh vuc kinh doanh: nha hang)");
        }
        else if (this.linhVuc == KHACH_SAN){
            System.out.println(", linh vuc kinh doanh: khach san)");
        }
        else if (this.linhVuc == TU_NHAN){
            System.out.println(", linh vuc kinh doanh: cong ty tu nhan)");
        }
        else if (this.linhVuc == NHA_NUOC){
            System.out.println(", linh vuc kinh doanh: cong ty nha nuoc)");
        }
    }
}
