package entity;

import java.util.Scanner;

public abstract class SinhVien {
    private String maSSV;
    private String tenSV;
    private int tuoi;
    private String queQuan;




    public SinhVien() {

    }
    public SinhVien(String maSSV,String tenSV, int tuoi, String queQuan) {
        this.maSSV = maSSV;
        this.tenSV = tenSV;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
    }

    public String getMaSSV() {
        return maSSV;
    }

    public void setMaSSV(String maSSV) {
        this.maSSV = maSSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public void setThongTinSinhVien(Scanner sc){
        System.out.print("Nhập mã số sinh viên: ");
        this.setMaSSV(sc.nextLine());
        System.out.print("Nhâp tên sinh viên: ");
        this.setTenSV(sc.nextLine());
        System.out.print("Nhập tuổi: ");
        this.setTuoi(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập quê quán: ");
        this.setQueQuan(sc.nextLine());
    }
    public String getThongTinSinhVien() {
        return String.format("Mã SV: %s, Tên: %s, Tuổi: %d, Quê quán: %s",
                this.getMaSSV(), this.getTenSV(), this.getTuoi(), this.getQueQuan());
    }

    public abstract double tinhDTB();
}
