package entity;

import java.util.Scanner;

public class SinhVienTN extends SinhVien {
    private double toan;
    private double van;
    private double ly;
    private double hoa;
    private double sinh;



    public SinhVienTN() {
    }


    @Override
    public double tinhDTB() {
        return ((this.getToan() * 2) +
                this.getVan() +
                (this.getLy() * 2) +
                this.getHoa() +
                this.getSinh())/7;
    }
@Override
    public void DiemCong(double diemCongThem) {
        double dtbMoi = this.tinhDTB() + diemCongThem;
        if (dtbMoi > 10) {
            dtbMoi = 10;
        }
        double tiLe = dtbMoi / this.tinhDTB();
        this.toan *= tiLe;
        this.van *= tiLe;
        this.ly *= tiLe;
        this.hoa *= tiLe;
        this.sinh *= tiLe;
    }

    public void setThongTinSinhVien(Scanner sc){
        super.setThongTinSinhVien(sc);
        System.out.print("Nhập điểm toán: ");
        this.setToan(sc.nextDouble());
        System.out.print("Nhâp điểm văn: ");
        this.setVan(sc.nextDouble());
        System.out.print("Nhập điểm lý: ");
        this.setLy(sc.nextDouble());
        System.out.print("Nhập điểm hóa: ");
        this.setHoa(sc.nextDouble());
        System.out.print("Nhập điểm sinh: ");
        this.setSinh(sc.nextDouble());
        sc.nextLine();
    }
    @Override
    public String getThongTinSinhVien() {
        return "Sinh viên tự nhiên, " + super.getThongTinSinhVien() + String.format(", ĐTB: %.2f",
                this.tinhDTB());
    }

    public SinhVienTN(String maSSV, String tenSV, int tuoi, String queQuan, double toan, double van, double ly, double hoa, double sinh) {
        super(maSSV, tenSV, tuoi, queQuan);
        this.toan = toan;
        this.van = van;
        this.ly = ly;
        this.hoa = hoa;
        this.sinh = sinh;
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

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public double getSinh() {
        return sinh;
    }

    public void setSinh(double sinh) {
        this.sinh = sinh;
    }

}
