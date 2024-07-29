package Utils;

import entity.SinhVien;

import java.util.Comparator;

public interface SinhVienCPRT {
    Comparator<SinhVien> sortSinhVienByTen();
    Comparator<SinhVien> sortSinhVienByMSSV();
}
