package System;

import entity.SinhVien;
import entity.SinhVienTN;
import entity.SinhVienXH;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    List<SinhVien> sinhVienList;
    public Menu() {
        scanner = new Scanner(System.in);
        sinhVienList = new ArrayList<>();
        dataTest();
    }
    void dataTest() {
        // add sinh viên tự nhiên
        sinhVienList.add(new SinhVienTN("SV01","Võ Thanh Tùng",28,"HCM",9,9,9,9,9));
        sinhVienList.add(new SinhVienXH("SV10", "Hoàng Văn E", 25, "NT", 4, 1, 2, 3));
        sinhVienList.add(new SinhVienTN("SV02","Phạm Huy Hoàng",20,"HCM",6,6,7,5,8));
        sinhVienList.add(new SinhVienTN("SV03","Nguyễn Trà My",20,"HCM",6,7,8,7,6));
        sinhVienList.add(new SinhVienXH("SV07", "Trần Thị B", 22, "ĐN", 6.5, 7, 8, 7.5));
        sinhVienList.add(new SinhVienTN("SV04","Khứa nào ai biết",20,"HCM",4,4,3,4,3));
        sinhVienList.add(new SinhVienXH("SV06", "Lê Văn A", 21, "HN", 7, 8, 7.5, 8));
        sinhVienList.add(new SinhVienXH("SV09", "Phạm Thị D", 24, "CT", 2, 4, 4, 2));
        sinhVienList.add(new SinhVienXH("SV08", "Nguyễn Văn C", 23, "SG", 8, 7.5, 7, 8));
        sinhVienList.add(new SinhVienTN("SV05","Khứa nào đó",20,"HCM",2,1,3,2,3));

        // add sinh viên xã hội


    }

    public void showMenu() {
        System.out.println("|======= Hệ Thống Menu =======|");
        System.out.println("|1. Nhập thông tin nhân viên  |");
        System.out.println("|2. Xuất thông tin sinh viên  |");
        System.out.println("|3. Thoát                     |");
        System.out.println("|=============================|");
        System.out.print("Chọn một chức năng: ");
    }
    public void showMenuSinhVien() {
        System.out.println("|====== Lựa chọn Sinh Viên =======|");
        System.out.println("|1. Sinh viên tự nhiên            |");
        System.out.println("|2. Sinh viên xã hội              |");
        System.out.println("|3. Thoát                         |");
        System.out.println("|=================================|");
        System.out.print("Chon sinh viên tự nhiện/xã hội: ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    boolean runningSinhVien = true;
                    while(runningSinhVien) {
                        showMenuSinhVien();
                        int choiceSV = scanner.nextInt();
                        scanner.nextLine();
                        switch (choiceSV) {
                            case 1:
                                System.out.println("Nhập thông tin sinh viên tự nhiên");
                                SinhVien sinhVienTN = new SinhVienTN();
                                sinhVienTN.setThongTinSinhVien(scanner);
                                sinhVienList.add(sinhVienTN);
                                break;
                            case 2:
                                System.out.println("Nhập thông tin sinh viên xã hội");
                                SinhVien sinhVienXH = new SinhVienXH();
                                sinhVienXH.setThongTinSinhVien(scanner);
                                sinhVienList.add(sinhVienXH);
                                break;
                            case 3:
                                runningSinhVien = false;
                                System.out.println("Trở lại menu chính.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("|===========================================================================================|");
                    System.out.println("|========Thông tin sinh viên=======|");
                    xuatThongTinSinhVien();
                    System.out.println("|===========================================================================================|");
                    break;
                case 3:
                    running = false;
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    public void xuatThongTinSinhVien() {
        if (sinhVienList.isEmpty()) {
            System.out.println("Chưa có thông tin sinh viên nào.");
        } else {
            for (SinhVien sv : sinhVienList) {
                System.out.println(sv.getThongTinSinhVien());
            }
        }
    }
}
