
package Layout.models.BackEnd.BUS;

import java.text.Normalizer;
import java.util.ArrayList;

import Layout.models.BackEnd.DAO.ProductDAO;
import Layout.models.BackEnd.DTO.Product;

public class ProductBUS {

    ProductDAO spDao = new ProductDAO();
    private ArrayList<Product> dssp;

    public ProductBUS() {

    }

    public void readDB() {
        dssp = spDao.readDB();
    }

    public Product getProduct(String masp) {
        if (dssp == null) {
            Listsp(); // Initialize dssp if it's null
        }
        for (Product sp : dssp) {
            if (sp.getMaSP().equals(masp)) {
                return sp;
            }
        }
        return null;
    }

    public ArrayList<Product> searchProduct(String value, String type) {
        ArrayList<Product> result = new ArrayList<>();
        dssp.forEach((sp) -> {
            switch (type) {
                case "Tất cả":
                    if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())
                            || sp.getMaLSP().toLowerCase().contains(value.toLowerCase())
                            || sp.getTenSP().toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {

                        result.add(sp);
                    }
                    break;
                case "Mã sản phẩm":
                    if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                        result.add(sp);
                    }
                    break;
                case "Mã loại":
                    if (sp.getMaLSP().toLowerCase().contains(value.toLowerCase())) {
                        result.add(sp);
                    }
                    break;
                case "Tên sản phẩm":
                    if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
                        result.add(sp);
                    }
                    break;
                case "Đơn giá":
                    if (String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(sp);
                    }
                    break;
                case "Số lượng":
                    if (String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(sp);
                    }
                    break;
            }
        });
        return result;
    }

    // search
    public ArrayList<Product> search(String value, String type, int soluong1, int soluong2, float gia1, float gia2,
            int trangthai) {
        ArrayList<Product> result = new ArrayList<>();

        dssp.forEach((sp) -> {
            if (type.equals("Tất cả")) {
                if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())
                        || sp.getMaLSP().toLowerCase().contains(value.toLowerCase())
                        || sp.getTenSP().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf((sp.getTrangthai() == 1 ? "Ẩn" : "Hiện")).toLowerCase()
                                .contains(value.toLowerCase())) {
                    result.add(sp);
                }
            } else {
                switch (type) {
                    case "Mã sản phẩm":
                        if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Mã loại":
                        if (sp.getMaLSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Tên":
                        if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Đơn giá":
                        if (String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Số lượng":
                        if (String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Trạng thái":
                        String tt = (sp.getTrangthai() == 1 ? "Ẩn" : "Hiện");
                        if (String.valueOf(tt).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                }
            }
        });

        for (int i = result.size() - 1; i >= 0; i--) {
            Product sp = result.get(i);
            int soluong = sp.getSoLuong();
            float gia = sp.getDonGia();
            int tt = sp.getTrangthai();
            Boolean soLuongKhongThoa = (soluong1 != -1 && soluong < soluong1) || (soluong2 != -1 && soluong > soluong2);
            Boolean giaKhongThoa = (gia1 != -1 && gia < gia1) || (gia2 != -1 && gia > gia2);
            Boolean trangThaiKhongThoa = (trangthai != -1) && tt != trangthai;

            if (soLuongKhongThoa || giaKhongThoa || trangThaiKhongThoa) {
                result.remove(i);
            }
        }

        return result;
    }

    public String getNextID() {
        return "SP" + String.valueOf(this.dssp.size() + 1);
    }

    public ArrayList<Product> getVailableProducts() {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : dssp) {
            if (product.getTrangthai() == 0) {
                result.add(product);
            }
        }
        return result;
    }

    public ArrayList<Product> getList() {
        if (dssp == null) {
            Listsp(); // Gọi phương thức Listsp() nếu danh sách sản phẩm chưa được khởi tạo
        }
        return dssp;
    }

    public void Listsp() {

        dssp = new ArrayList<>();
        dssp = spDao.selectAll();

    }

    public Boolean updateSoLuong(String masp, int soluong) {
        Boolean ok = spDao.updateSoLuong(masp, soluong);

        if (ok) {
            dssp.forEach((sp) -> {
                if (sp.getMaSP().equals(masp)) {
                    sp.setSoLuong(soluong);
                }
            });
        }

        return ok;
    }

    public boolean checkidproduct(String id) {
        ArrayList<Product> listproduct = getList();
        for (Product pr : listproduct) {
            if (id.equals(pr.getMaSP())) {
                return true;
            }
        }
        return false; // Trả về false nếu không tìm thấy sản phẩm trong danh sách
    }

    public Boolean addBus(Product product) {
        Boolean result = spDao.addDao(product);
        return result;
    }

    public Boolean update(Product product) {
        Boolean result = spDao.update(product);
        return result;
    }

    public Boolean updateTrangthai(String manv, int trangthai) {
        Boolean result = spDao.updateTrangThai(manv, trangthai);
        return result;
    }

    public String checkvalid(String tu, String toi, String combox, int trangthai) {
        if (tu.isEmpty() || toi.isEmpty()) {
            return "Nhập đầy đủ giới hạn tìm kiếm";
        }
        if (combox.equals("Dongia")) {
            if (!tu.trim().matches("^\\d*\\.?\\d+$") || !toi.trim().matches("^\\d*\\.?\\d+$")) {
                return "Số lượng phải là số thực không âm";
            }
        } else if (combox.equals("Soluong")) {
            if (!tu.trim().matches("^[1-9]\\d*$") || !toi.trim().matches("^[1-9]\\d*$")) {
                return "Số lượng phải là số dương từ 1 đến 9";
            }
        }
        return null;
    }

    private String removeAccents(String input) {
        // Chuyển đổi chuỗi đầu vào sang chữ thường
        input = input.toLowerCase();
        // Chuẩn hóa chuỗi
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        // Loại bỏ các dấu diacritical
        return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public boolean isMatched(Product product, String combox, String txt) {
        String searchText = removeAccents(txt);
        switch (combox) {
            case "MaSP":
                return removeAccents(product.getMaSP()).contains(searchText);
            case "TenSP":
                return removeAccents(product.getTenSP()).contains(searchText);
            case "MaLSP":
                return removeAccents(product.getMaLSP()).contains(searchText);
            default:
                return false;
        }
    }

    // public String getNextID() {
    // if (dssp == null) {
    // Listsp(); // Initialize dssp if it's null
    // }
    // if (dssp.isEmpty()) {
    // return "SP001"; // Return SP001 if the list is empty
    // }

    // // Find the largest maSP
    // Product maxProduct = dssp.stream()
    // .max(Comparator.comparing(Product::getMaSP))
    // .orElseThrow(NoSuchElementException::new);

    // String maxID = maxProduct.getMaSP();
    // int numericPart = Integer.parseInt(maxID.substring(2));
    // int nextID = numericPart + 1;

    // return "SP" + String.format("%03d", nextID);
    // }

}
