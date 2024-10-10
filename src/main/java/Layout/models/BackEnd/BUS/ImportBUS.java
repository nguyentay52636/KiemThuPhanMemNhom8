/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout.models.BackEnd.BUS;

import Layout.models.BackEnd.DAO.ImportDAO;
import Layout.models.BackEnd.DAO.InvoiceDAO;
import Layout.models.BackEnd.DTO.Import;
import Layout.models.BackEnd.DTO.Invoice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ImportBUS {
    private static ArrayList<Import> listImport = new ArrayList<>();

    ImportDAO DAO = new ImportDAO();

    public ImportBUS() {
        listImport = DAO.readDB();
    }

    public void readDB() {
        listImport = DAO.readDB();
    }

    public String getNextID() {
        return "PN" + (listImport.size() + 1);
    }

    public Import getPhieuNhap(String mapn) {
        for (Import pn : listImport) {
            if (pn.getMaPN().equals(mapn)) {
                return pn;
            }
        }
        return null;
    }

    public ArrayList<Import> getDspn() {
        return this.listImport;
    }

    public ArrayList<Import> searchByDate(LocalDate from, LocalDate to) {
        ArrayList<Import> result = new ArrayList<>();
        for (Import import1 : listImport) {
            if ((import1.getNgayNhap().isEqual(from)) || (import1.getNgayNhap().isAfter(from))
                    && (import1.getNgayNhap().isEqual(to)) || (import1.getNgayNhap().isBefore(to))) {
                result.add(import1);
            }
        }
        return result;
    }

    public ArrayList<Import> searchByTotalPrice(double from, double to) {
        ArrayList<Import> result = new ArrayList<>();
        for (Import pn : listImport) {
            if (pn.getTongTien() >= from && pn.getTongTien() <= to) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<Import> searchByDateAndTotalPrice(LocalDate fromDate, LocalDate toDate, double fromPrice,
            double toPrice) {
        ArrayList<Import> result = new ArrayList<>();
        for (Import import1 : listImport) {
            if ((import1.getNgayNhap().isEqual(fromDate) || import1.getNgayNhap().isAfter(fromDate))
                    && (import1.getNgayNhap().isEqual(toDate) || import1.getNgayNhap().isBefore(toDate))
                    && (import1.getTongTien() >= fromPrice && import1.getTongTien() <= toPrice)) {
                result.add(import1);
            }
        }
        return result;
    }

    public static ArrayList<Import> search(String value, String type) {
        ArrayList<Import> result = new ArrayList<>();

        listImport.forEach((pn) -> {

            switch (type) {
                case "Tất cả":
                    if (pn.getMaNCC().toLowerCase().contains(value.toLowerCase())
                            || pn.getMaNCC().toLowerCase().contains(value.toLowerCase())
                            || (pn.getMaNV()).toLowerCase().contains(value.toLowerCase())
                            || pn.getNgayNhap().toString().toLowerCase().contains(value.toLowerCase())
                            || pn.getGioNhap().toString().toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(pn.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
                case "Mã phiếu nhập":
                    if (pn.getMaPN().toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
                case "Mã nhà cung cấp":
                    if (pn.getMaNCC().toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
                case "Mã nhân viên":
                    if (pn.getMaNV().toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
                case "Ngày nhập":
                    if (pn.getNgayNhap().toString().toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
                case "Giờ nhập":
                    if (pn.getGioNhap().toString().toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
                case "Tổng tiền":
                    if (String.valueOf(pn.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(pn);
                    }
                    break;
            }

        });
        // //Ngay lap, tong tien
        // for (int i = result.size() - 1; i >= 0; i--) {
        // Import pn = result.get(i);
        // LocalDate ngaynhap = pn.getNgayNhap();
        // float tongtien = pn.getTongTien();
        //
        // Boolean ngayKhongThoa = (_ngay1 != null && ngaynhap.isBefore(_ngay1)) ||
        // (_ngay2 != null && ngaynhap.isAfter(_ngay2));
        // Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1
        // && tongtien > _tong2);
        //
        // if (ngayKhongThoa || tienKhongThoa) {
        // result.remove(pn);
        // }
        // }

        return result;

    }

    public boolean checkImportExist(String maPhieuNHap) {
        ImportDAO invoiceDAO = new ImportDAO();
        Import invoice = invoiceDAO.getImport(maPhieuNHap);

        return invoice != null;
    }

    public ArrayList<Import> search1(String type, String value, LocalDate _ngay1, LocalDate _ngay2, int _tong1,
            int _tong2) {
        ArrayList<Import> result = new ArrayList<>();

        listImport.forEach((pn) -> {
            if (type.equals("Tất cả")) {
                if (pn.getMaPN().toLowerCase().contains(value.toLowerCase())
                        || pn.getMaNCC().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(pn.getMaNV()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(pn.getNgayNhap()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(pn.getGioNhap()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(pn.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(pn);
                }
            } else {
                switch (type) {
                    case "Mã phiếu nhập":
                        if (pn.getMaPN().toLowerCase().contains(value.toLowerCase())) {
                            result.add(pn);
                        }
                        break;
                    case "Mã nhà cung cấp":
                        if (pn.getMaNCC().toLowerCase().contains(value.toLowerCase())) {
                            result.add(pn);
                        }
                        break;
                    case "Mã nhân viên":
                        if (String.valueOf(pn.getMaNV()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(pn);
                        }
                        break;
                    case "Ngày nhập":
                        if (String.valueOf(pn.getNgayNhap()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(pn);
                        }
                        break;
                    case "Giờ nhập":
                        if (String.valueOf(pn.getGioNhap()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(pn);
                        }
                        break;
                    case "Tổng tiền":
                        if (String.valueOf(pn.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(pn);
                        }
                        break;
                }
            }

        });
        // Ngay lap, tong tien
        for (int i = result.size() - 1; i >= 0; i--) {
            Import pn = result.get(i);
            LocalDate ngaynhap = pn.getNgayNhap();
            float tongtien = pn.getTongTien();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaynhap.isBefore(_ngay1))
                    || (_ngay2 != null && ngaynhap.isAfter(_ngay2));
            Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1 && tongtien > _tong2);

            if (ngayKhongThoa || tienKhongThoa) {
                result.remove(pn);
            }
        }

        return result;
    }

    public boolean add(Import pn) {
        Boolean ok = DAO.add(pn);
        if (ok) {
            listImport.add(pn);
        }
        return ok;
    }

    public Boolean update(String maPN, String maNCC, String maNV, LocalDate ngayNhap, LocalTime gioNhap,
            float tongTien) {
        Import pn = new Import(maPN, maNCC, maNV, ngayNhap, gioNhap, tongTien);
        return update(pn);
    }

    public Boolean update(Import pn) {
        Boolean success = DAO.update(pn);
        if (success) {
            for (Import cthd : listImport) {
                if (cthd.getMaPN().equals(pn.getMaPN())) {
                    cthd = pn;
                }
            }
            return true;
        }
        return false;
    }

    public Boolean updateTongTien(String _mapn, float _tongTien) {
        Boolean success = DAO.updateTongTien(_mapn, _tongTien);
        if (success) {
            for (Import pn : listImport) {
                if (pn.getMaPN().equals(_mapn)) {
                    pn.setTongTien(_tongTien);
                }
            }
            return true;
        }
        return false;
    }

    public boolean add(String maPN, String maNCC, String maNV, LocalDate ngayNhap, LocalTime gioNhap, float tongTien) {
        Import pn = new Import(maPN, maNCC, maNV, ngayNhap, gioNhap, tongTien);
        return add(pn);
    }

    public boolean delete(String ma) {
        Boolean ok = DAO.delete(ma);
        if (ok) {
            for (int i = (listImport.size() - 1); i >= 0; i--) {
                if (listImport.get(i).getMaPN().equals(ma)) {
                    listImport.remove(i);
                }
            }

        }
        return ok;
    }
}
