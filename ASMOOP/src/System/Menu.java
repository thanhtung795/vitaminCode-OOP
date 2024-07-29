package System;

import Utils.CompeTo.SinhVienCPTo;
import entity.SinhVien;
import entity.SinhVienTN;
import entity.SinhVienXH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    List<SinhVien> sinhVienList;
    List<SinhVien> sinhVienListNhoHon5;
    SinhVienCPTo sinhVienCPTo;

    public Menu() {
        scanner = new Scanner(System.in);
        sinhVienList = new ArrayList<>();
        sinhVienCPTo = new SinhVienCPTo();
        dataTest();
    }

    void dataTest() {
        // add sinh viên tự nhiên
        sinhVienList.add(new SinhVienTN("SV01", "Võ Thanh Tùng", 28, "HCM", 9, 9, 9, 9, 9));
        sinhVienList.add(new SinhVienXH("SV10", "Khứa kìa kìa", 25, "NT", 4, 1, 2, 3));
        sinhVienList.add(new SinhVienTN("SV02", "Khứa đó đó", 20, "HCM", 6, 6, 7, 5, 8));
        sinhVienList.add(new SinhVienTN("SV03", "Khứa kìa trời", 20, "HCM", 6, 7, 8, 7, 6));
        sinhVienList.add(new SinhVienXH("SV07", "Biết khứa nào đâu", 22, "ĐN", 6.5, 7, 8, 7.5));
        sinhVienList.add(new SinhVienTN("SV04", "Khứa nào ai biết", 20, "HCM", 4, 4, 3, 4, 3));
        sinhVienList.add(new SinhVienXH("SV06", "Là khúa nào", 21, "HN", 7, 8, 7.5, 8));
        sinhVienList.add(new SinhVienXH("SV09", "Khứa  này này", 24, "CT", 2, 4, 4, 2));
        sinhVienList.add(new SinhVienXH("SV08", "Khứa bửa hỗm", 23, "SG", 8, 7.5, 7, 8));
        sinhVienList.add(new SinhVienTN("SV05", "Khứa nào đó", 20, "HCM", 2, 1, 3, 2, 3));
    }

    public void showMenu() {
        System.out.println("|======= Hệ Thống Menu =======|");
        System.out.println("|1. Nhập thông tin nhân viên  |");
        System.out.println("|2. Xuất thông tin sinh viên  |");
        System.out.println("|3. Sắp xếp sinh viên         |");
        System.out.println("|4. xuất sinh viên ĐTB +1     |");
        System.out.println("|5. Thoát                     |");
        System.out.println("|=============================|");
        System.out.print("Chọn một chức năng: ");
    }

    public void showMenuSinhVien() {
        System.out.println("|====== Lựa chọn Sinh Viên =======|");
        System.out.println("|1. Sinh viên tự nhiên            |");
        System.out.println("|2. Sinh viên xã hội              |");
        System.out.println("|3. Trở lại menu chính            |");
        System.out.println("|=================================|");
        System.out.print("Chon sinh viên tự nhiện/xã hội: ");
    }

    public void showSortMenu() {
        System.out.println("|============= Lựa chọn Sắp xếp ===============|");
        System.out.println("|1. Điẻm TB >= 5 và sắp xếp theo tên           |");
        System.out.println("|2. Điẻm TB < 5 và Sắp xếp theo mã số SV       |");
        System.out.println("|3. Trở lại menu chính                         |");
        System.out.println("|==============================================|");
        System.out.print("Chọn cách sắp xếp: ");
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
                    while (runningSinhVien) {
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
                    System.out.println("|=====================================Thông tin sinh viên===================================|");
                    xuatThongTinSinhVien(sinhVienList);
                    System.out.println("|===========================================================================================|");
                    break;
                case 3:
                    boolean sorting = true;
                    while (sorting) {
                        showSortMenu();
                        int sortChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sortChoice) {
                            case 1:
                                xuatSVLonHonBang5VaSapXepTheoTen();
                                break;
                            case 2:
                                xuatSVNhoHon5VaSapXepTheoMSSV();
                                break;
                            case 3:
                                sorting = false;
                                System.out.println("Trở lại menu chính.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Sinh viên điểm trung bình cộng 1");
                    xuatSVNhoHon5VaCongThem1DTB();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public void xuatSVLonHonBang5VaSapXepTheoTen() {
        if (sinhVienList.isEmpty()) {
            System.out.println("Chưa có thông tin sinh viên nào.");
        } else {
            List<SinhVien> danhSachMoi = new ArrayList<>(sinhVienList);
            danhSachMoi.sort(sinhVienCPTo.sortSinhVienByTen());
            for (SinhVien sv : danhSachMoi) {
                if (sv.tinhDTB() >= 5) {
                    System.out.println(sv.getThongTinSinhVien());
                }
            }
        }
    }

    public void xuatSVNhoHon5VaSapXepTheoMSSV() {
        if (sinhVienList.isEmpty()) {
            System.out.println("Chưa có thông tin sinh viên nào.");
        } else {
            List<SinhVien> danhSachMoi = new ArrayList<>(sinhVienList);
            danhSachMoi.sort(sinhVienCPTo.sortSinhVienByMSSV());
            for (SinhVien sv : danhSachMoi) {
                if (sv.tinhDTB() < 5) {
                    System.out.println(sv.getThongTinSinhVien());
                }
            }
        }
    }

    public void xuatSVNhoHon5VaCongThem1DTB() {
        sinhVienListNhoHon5 = new ArrayList<>();
        for (SinhVien sv : sinhVienList) {
            if (sv.tinhDTB() < 5) {
                SinhVien svMoi = null;
                if (sv instanceof SinhVienTN) {
                    svMoi = new SinhVienTN(
                            sv.getMaSSV(),
                            sv.getTenSV(),
                            sv.getTuoi(),
                            sv.getQueQuan(),
                            ((SinhVienTN) sv).getToan(),
                            ((SinhVienTN) sv).getVan(),
                            ((SinhVienTN) sv).getLy(),
                            ((SinhVienTN) sv).getHoa(),
                            ((SinhVienTN) sv).getSinh()
                    );
                } else if (sv instanceof SinhVienXH) {
                    svMoi = new SinhVienXH(
                            sv.getMaSSV(),
                            sv.getTenSV(),
                            sv.getTuoi(),
                            sv.getQueQuan(),
                            ((SinhVienXH) sv).getToan(),
                            ((SinhVienXH) sv).getVan(),
                            ((SinhVienXH) sv).getSu(),
                            ((SinhVienXH) sv).getDia(),
                            ((SinhVienXH) sv).getGDCD()
                    );
                }
                svMoi.DiemCong(1);
                sinhVienListNhoHon5.add(svMoi);
            }
        }
        xuatThongTinSinhVien(sinhVienListNhoHon5);
    }


    public void
    xuatThongTinSinhVien(List<SinhVien> list) {
        if (list.isEmpty()) {
            System.out.println("Chưa có thông tin sinh viên nào.");
        } else {
            for (SinhVien sv : list) {
                System.out.println(sv.getThongTinSinhVien());
            }
        }
    }
}
