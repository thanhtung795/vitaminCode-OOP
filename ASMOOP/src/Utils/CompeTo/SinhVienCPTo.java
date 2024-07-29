package Utils.CompeTo;

import Utils.SinhVienCPRT;
import entity.SinhVien;

import java.util.Comparator;

public class SinhVienCPTo implements SinhVienCPRT {

    @Override
    public Comparator<SinhVien> sortSinhVienByTen() {
        return new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getTenSV().compareTo(o2.getTenSV());
            }
        };
    }

    @Override
    public Comparator<SinhVien> sortSinhVienByMSSV() {
        return new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getMaSSV().compareTo(o2.getMaSSV());
            }
        };
    }
}
