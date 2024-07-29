package entity;

import java.util.Scanner;

public class SinhVienXH extends SinhVien {
    private double toan;
    private double van;
    private double su;
    private double dia;
    private double GDCD;

    public SinhVienXH() {
    }

    public SinhVienXH(String maSSV, String tenSV, int tuoi, String queQuan, double toan, double van, double su, double dia, double GDCD) {
        super(maSSV, tenSV, tuoi, queQuan);
        this.toan = toan;
        this.van = van;
        this.su = su;
        this.dia = dia;
        this.GDCD = GDCD;
    }

    @Override
    public double tinhDTB() {
        return (this.getToan() + this.getVan() + (this.getSu() * 2) + (this.getDia() * 2) + (this.getGDCD() * 2)) / 8;
    }

    @Override
    public void DiemCong(double diemCongThem) {
        double dtbMoi = this.tinhDTB() + diemCongThem;
        if (dtbMoi > 10) {
            dtbMoi = 10; // Đảm bảo ĐTB không vượt quá 10
        }
        double tiLe = dtbMoi / this.tinhDTB();
        this.toan *= tiLe;
        this.van *= tiLe;
        this.su *= tiLe;
        this.dia *= tiLe;
        this.GDCD *= tiLe;
    }

    public void setThongTinSinhVien(Scanner sc) {
        super.setThongTinSinhVien(sc);

        System.out.print("Nhập điểm toán: ");
        this.setToan(sc.nextDouble());
        System.out.print("Nhâp điểm văn: ");
        this.setVan(sc.nextDouble());
        System.out.print("Nhập điểm sử: ");
        this.setSu(sc.nextDouble());
        System.out.print("Nhập điểm địa: ");
        this.setDia(sc.nextDouble());
        System.out.print("Nhập điểm GDCD: ");
        this.setGDCD(sc.nextDouble());
        sc.nextLine();
    }

    @Override
    public String getThongTinSinhVien() {
        return "Sinh viên xã hội, " + super.getThongTinSinhVien() + String.format(", ĐTB: %.2f", this.tinhDTB());
    }

    public SinhVienXH(String maSSV, String tenSV, int tuoi, String queQuan, double toan, double van, double su, double dia) {
        super(maSSV, tenSV, tuoi, queQuan);
        this.toan = toan;
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getSu() {
        return su;
    }

    public void setSu(double su) {
        this.su = su;
    }

    public double getDia() {
        return dia;
    }

    public void setDia(double dia) {
        this.dia = dia;
    }

    public double getGDCD() {
        return GDCD;
    }

    public void setGDCD(double GDCD) {
        this.GDCD = GDCD;
    }
}
