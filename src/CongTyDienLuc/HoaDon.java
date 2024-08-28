package CongTyDienLuc;

public abstract  class HoaDon {
    protected String maKH;
    protected String tenKH;
    protected int chiSoCu;
    protected int chiSoMoi;
    protected long tienThanhToan;

    public static final int VAT = 10;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public long getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(long tienThanhToan) {
        this.tienThanhToan = tienThanhToan;
    }

    public int tinhKwTieuThu(){
        return this.chiSoMoi - this.chiSoCu;
    }

    public abstract long tinhTienDien();
    public abstract long tinhTienThanhToan();
    public void xuat(){
        System.out.print("Ma KH: " + this.maKH + ", ten KH: " + this.tenKH + ", chi so cu: " + this.chiSoCu +
                ", chi so moi: " + this.chiSoMoi + ", tien thanh toan: " + tinhTienThanhToan());
    }
}
