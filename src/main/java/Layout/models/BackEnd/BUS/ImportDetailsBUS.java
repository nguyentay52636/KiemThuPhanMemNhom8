/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout.models.BackEnd.BUS;

import Layout.models.BackEnd.DAO.ImportDetailsDAO;
import Layout.models.BackEnd.DTO.ImportDetails;
import Layout.models.BackEnd.DTO.Product;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ImportDetailsBUS {

    ImportDetailsDAO qlctpnDAO = new ImportDetailsDAO();
    ImportBUS qlpnBUS = new ImportBUS();
    ProductBUS qlspBUS = new ProductBUS();
    static ArrayList<ImportDetails> dsctpn = new ArrayList<>();

    public ImportDetailsBUS() {
        dsctpn = qlctpnDAO.readDB();
    }

    public void readDB() {
        dsctpn = qlctpnDAO.readDB();
    }

    public ArrayList<ImportDetails> getImportDetailsByMaHD(String maHD) {
        ArrayList<ImportDetails> result = new ArrayList<>();
        for (ImportDetails detail : dsctpn) {
            if (detail.getMa().equals(maHD)) {
                result.add(detail);
            }
        }
        return result;
    }

    public ArrayList<ImportDetails> getlist() {
        if(dsctpn==null) {
            readDB();
        }
        return dsctpn;
    }

    public static ArrayList<ImportDetails> search(String type, String value) {

        ArrayList<ImportDetails> result = new ArrayList<>();
        dsctpn.forEach((ctpn) -> {
            if (type.equals("Tất cả")) {
                if (ctpn.getMa().toLowerCase().contains(value.toLowerCase())
                        || ctpn.getMaSP().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(ctpn.getDonGia()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(ctpn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(ctpn);
                }
            } else {
                switch (type) {
                    case "Mã phiếu nhập":
                        if (ctpn.getMa().toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Mã sản phẩm":
                        if (ctpn.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Đơn giá":
                        if (String.valueOf(ctpn.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Số lượng":
                        if (String.valueOf(ctpn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                }
            }

        });

        return result;
    }

    public ArrayList<ImportDetails> search1(String type, String value) {

        ArrayList<ImportDetails> result = new ArrayList<>();
        dsctpn.forEach((ctpn) -> {
            if (type.equals("Tất cả")) {
                if (ctpn.getMa().toLowerCase().contains(value.toLowerCase())
                        || ctpn.getMaSP().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(ctpn.getDonGia()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(ctpn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(ctpn);
                }
            } else {
                switch (type) {
                    case "Mã phiếu nhập":
                        if (ctpn.getMa().toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Mã sản phẩm":
                        if (ctpn.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Đơn giá":
                        if (String.valueOf(ctpn.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Số lượng":
                        if (String.valueOf(ctpn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                }
            }

        });

        return result;
    }

    public Boolean deleteAll(String _maPhieuNhap) {
        Boolean success = qlctpnDAO.deleteAll(_maPhieuNhap);
        if (success) {
            for (ImportDetails cthd : dsctpn) {
                if (cthd.getMa().equals(_maPhieuNhap)) {
                    dsctpn.remove(cthd);
                }
            }
            updateTongTien(_maPhieuNhap);
            return true;
        }
        return false;
    }

    public ImportDetails getChiTiet(String mapn, String masp) {
        for (ImportDetails ct : dsctpn) {
            if (ct.getMaSP().equals(masp) && ct.getMa().equals(mapn)) {
                return ct;
            }
        }
        return null;
    }

    public ArrayList<ImportDetails> getAllChiTiet(String mapn) {
        ArrayList<ImportDetails> result = new ArrayList<>();
        for(ImportDetails ctpn : dsctpn) {
            if(ctpn.getMa().equals(mapn)) {
                result.add(ctpn);
            }
        }
        return result;
    }

    public Boolean delete(String _maPhieuNhap, String _maSanPham) {
        Boolean success = qlctpnDAO.delete(_maPhieuNhap, _maSanPham);
        if (success) {
            for (ImportDetails ctpn : dsctpn) {
                if (ctpn.getMa().equals(_maPhieuNhap) && ctpn.getMaSP().equals(_maSanPham)) {
                    updateSoLuongSanPham(_maSanPham, ctpn.getSoLuong());
                    dsctpn.remove(ctpn);
                    updateTongTien(_maPhieuNhap);
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean add(ImportDetails ct) {
        int soLuongChiTietMoi = ct.getSoLuong();

        // tìm các chi tiết cùng mã, và tính tổng số lượng
        ArrayList<ImportDetails> toRemove = new ArrayList<>();
        int tongSoLuong = ct.getSoLuong();

        for (ImportDetails ctpn : dsctpn) {
            if (ctpn.getMa().equals(ct.getMa()) && ctpn.getMaSP().equals(ct.getMaSP())) {
                tongSoLuong += ctpn.getSoLuong();
                toRemove.add(ctpn);
            }
        }
        // xóa chi tiết cũ cùng mã
        dsctpn.removeAll(toRemove);
        qlctpnDAO.delete(ct.getMa(), ct.getMaSP());

        // thêm chi tiết mới có số lượng = tổng số lượng tìm ở trên
        ct.setSoLuong(tongSoLuong);
        Boolean success = qlctpnDAO.add(ct);
        if (success) {
            dsctpn.add(ct);
            updateSoLuongSanPham(ct.getMaSP(), soLuongChiTietMoi);
            updateTongTien(ct.getMa());
            return true;
        }
        return false;
    }

    private Boolean updateSoLuongSanPham(String _masp, int _soLuongThayDoi) {
        Boolean success = false;
        for (Product sp : qlspBUS.getList()) {
            if (sp.getMaSP().equals(_masp)) {
                success = qlspBUS.updateSoLuong(_masp, sp.getSoLuong() + _soLuongThayDoi);
            }
        }
        return success;
    }

    public boolean add(String ma, String masp, Integer soluong, Float dongia) {
        ImportDetails ctpn = new ImportDetails(ma, masp, soluong, dongia);
        return add(ctpn);
    }

    public boolean delete(String ma) {
        Boolean ok = qlctpnDAO.deleteAll(ma);
        if (ok) {
            for (int i = (dsctpn.size() - 1); i >= 0; i--) {
                if (dsctpn.get(i).getMa().equals(ma)) {
                    dsctpn.remove(i);
                }
            }

        }
        return ok;
    }

    public Boolean update(String mapn, String masp, int soluong, float dongia) {
        Boolean ok = qlctpnDAO.update(mapn, masp, soluong, dongia);

        if (ok) {
            dsctpn.forEach((ctpn) -> {
                if (ctpn.getMa().equals(mapn) && ctpn.getMaSP().equals(masp)) {
                    ImportDetails pn = new ImportDetails(mapn, masp, soluong, dongia);
                    dsctpn.add(pn);
                }
            });
        }

        return ok;
    }

    private Boolean updateTongTien(String _mapn) {
        float tong = 0;
        for (ImportDetails ct : dsctpn) {
            if (ct.getMa().equals(_mapn)) {
                tong += ct.getSoLuong() * ct.getDonGia();
            }
        }
        Boolean success = qlpnBUS.updateTongTien(_mapn, tong);

        return success;
    }
}
