////package Layout.models.BackEnd.BUS;
////
////import Layout.models.BackEnd.DAO.ProductDAO;
////import Layout.models.BackEnd.DTO.Product;
////
////import java.util.ArrayList;
////
////public class ProductBUS {
////    private ArrayList<Product> dssp = new ArrayList<>();
////
////    ProductDAO qlspDAO = new ProductDAO();
////
////    public ProductBUS() {
////        dssp = qlspDAO.readDB();
////    }
////
////    public void hienThi() {
////        dssp.forEach((sp) -> {
////            System.out.print(sp.getMaSP() + " ");
////            System.out.print(sp.getMaLSP() + " ");
////            System.out.println(sp.getTenSP() + " ");
////            System.out.println(sp.getDonGia() + " ");
////            System.out.println(sp.getSoLuong() + " ");
////            System.out.println(sp.getTrangthai());
////        });
////    }
////
////    public String[] getHeaders() {
////        return new String[]{"Mã sản phẩm", "Mã loại", "Tên", "Đơn giá", "Số lượng", "Trạng thái"};
////    }
////
////    public void readDB() {
////        dssp = qlspDAO.readDB();
////    }
////
////    public String getNextID() {
////        return "SP" + String.valueOf(this.dssp.size() + 1);
////    }
////
////    public Product getSanPham(String masp) {
////        for (Product sp : dssp) {
////            if (sp.getMaSP().equals(masp)) {
////                return sp;
////            }
////        }
////        return null;
////    }
////
////    public ArrayList<Product> search(String value, String type, int soluong1, int soluong2, float gia1, float gia2, int trangthai) {
////        ArrayList<Product> result = new ArrayList<>();
////
////        dssp.forEach((sp) -> {
////            if (type.equals("Tất cả")) {
////                if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())
////                        || sp.getMaLSP().toLowerCase().contains(value.toLowerCase())
////                        || sp.getTenSP().toLowerCase().contains(value.toLowerCase())
////                        || String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())
////                        || String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())
////                        || String.valueOf((sp.getTrangthai() == 1 ? "Ẩn" : "Hiện")).toLowerCase().contains(value.toLowerCase())) {
////                    result.add(sp);
////                }
////            } else {
////                switch (type) {
////                    case "Mã sản phẩm":
////                        if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
////                            result.add(sp);
////                        }
////                        break;
////                    case "Mã loại":
////                        if (sp.getMaLSP().toLowerCase().contains(value.toLowerCase())) {
////                            result.add(sp);
////                        }
////                        break;
////                    case "Tên":
////                        if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
////                            result.add(sp);
////                        }
////                        break;
////                    case "Đơn giá":
////                        if (String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
////                            result.add(sp);
////                        }
////                        break;
////                    case "Số lượng":
////                        if (String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
////                            result.add(sp);
////                        }
////                        break;
////                    case "Trạng thái":
////                        String tt = (sp.getTrangthai() == 1 ? "Ẩn" : "Hiện");
////                        if (String.valueOf(tt).toLowerCase().contains(value.toLowerCase())) {
////                            result.add(sp);
////                        }
////                        break;
////                }
////            }
////        });
////
////        for (int i = result.size() - 1; i >= 0; i--) {
////            Product sp = result.get(i);
////            int soluong = sp.getSoLuong();
////            float gia = sp.getDonGia();
////            int tt = sp.getTrangthai();
////            Boolean soLuongKhongThoa = (soluong1 != -1 && soluong < soluong1) || (soluong2 != -1 && soluong > soluong2);
////            Boolean giaKhongThoa = (gia1 != -1 && gia < gia1) || (gia2 != -1 && gia > gia2);
////            Boolean trangThaiKhongThoa = (trangthai != -1) && tt != trangthai;
////
////            if (soLuongKhongThoa || giaKhongThoa || trangThaiKhongThoa) {
////                result.remove(i);
////            }
////        }
////
////        return result;
////    }
////
////    public Boolean add(Product sp) {
////        Boolean ok = qlspDAO.add(sp);
////
////        if (ok) {
////            dssp.add(sp);
////        }
////        return ok;
////    }
////
////    public Boolean add(String masp, String malsp, String tensp, float dongia, int soluong, String filename, int trangthai) {
////        Product sp = new Product(masp, malsp, tensp, dongia, soluong, filename, trangthai);
////        return add(sp);
////    }
////
////    public Boolean delete(String masp) {
////        Boolean ok = qlspDAO.delete(masp);
////
////        if (ok) {
////            for (int i = (dssp.size() - 1); i >= 0; i--) {
////                if (dssp.get(i).getMaSP().equals(masp)) {
////                    dssp.remove(i);
////                }
////            }
////        }
////        return ok;
////    }
////
////    public Boolean update(String masp, String malsp, String tensp, float dongia, int soluong, String filename, int trangthai) {
////        Boolean ok = qlspDAO.update(masp, malsp, tensp, dongia, soluong, filename, trangthai);
////
////        if (ok) {
////            dssp.forEach((sp) -> {
////                if (sp.getMaSP().equals(masp)) {
////                    sp.setMaLSP(malsp);
////                    sp.setTenSP(tensp);
////                    sp.setDonGia(dongia);
////                    sp.setSoLuong(soluong);
////                    sp.setHinhAnh(filename);
////                    sp.setTrangthai(trangthai);
////                }
////            });
////        }
////
////        return ok;
////    }
////
////    public Boolean updateSoLuong(String masp, int soluong) {
////        Boolean ok = qlspDAO.updateSoLuong(masp, soluong);
////
////        if (ok) {
////            dssp.forEach((sp) -> {
////                if (sp.getMaSP().equals(masp)) {
////                    sp.setSoLuong(soluong);
////                }
////            });
////        }
////
////        return ok;
////    }
////
////    public Boolean updateTrangThai(String masp, int trangthai) {
////        Boolean ok = qlspDAO.updateTrangThai(masp, trangthai);
////
////        if (ok) {
////            dssp.forEach((sp) -> {
////                if (sp.getMaSP().equals(masp)) {
////                    sp.setTrangthai(trangthai);
////                }
////            });
////        }
////
////        return ok;
////    }
////
////    public ArrayList<Product> getDssp() {
////        return dssp;
////    }
////
////    public static void main(String[] args) {
////        ProductBUS productBUS = new ProductBUS();
////
////        // Create a new product
////        Product product1 = new Product();
////        product1.setMaSP("P001");
////        product1.setMaLSP("LSP1");
////        product1.setTenSP("Product 1");
////        product1.setDonGia(100.0f);
////        product1.setSoLuong(10);
////        product1.setHinhAnh("product1.jpg");
////        product1.setTrangthai(1);
////
////        // Add the product
////        productBUS.add(product1);
////
////        // Create another product
////        Product product2 = new Product();
////        product2.setMaSP("P002");
////        product2.setMaLSP("LSP2");
////        product2.setTenSP("Product 2");
////        product2.setDonGia(200.0f);
////        product2.setSoLuong(20);
////        product2.setHinhAnh("product2.jpg");
////        product2.setTrangthai(1);
////
////        // Add the second product
////        productBUS.add(product2);
////
////        // Display the products
////        productBUS.hienThi();
////    }
////}
//
//package Layout.models.BackEnd.BUS;
//
//
//import java.util.ArrayList;
//
//import Layout.models.BackEnd.DAO.ProductDAO;
//import Layout.models.BackEnd.DTO.Product;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
//
//public class ProductBUS  {
//
//    ProductDAO spDao= new ProductDAO();
//    private ArrayList<Product> dssp;
//
//    public ProductBUS() {
//
//    }
//
//
//
//    public void Listsp() {
//
//        dssp= new ArrayList<>();
//        dssp=spDao.selectAll();
//
//    }
//
//
//
//    public boolean checkidproduct(String id) {
//        ArrayList<Product > listproduct = getList();
//        for(Product  pr: listproduct) {
//            if(id.equals(pr.getMaSP())) {
//                return true;
//            }
//        }
//        return false; // Trả về false nếu không tìm thấy sản phẩm trong danh sách
//    }
//
//
//
//    public Boolean addBus(Product  product) {
//        Boolean result = spDao.addDao(product);
//        return result;
//
//    }
//
//    public Boolean update(Product  product) {
//        Boolean result = spDao.update(product);
//        return result;
//    }
//
//    public ArrayList<Product > getList(){
//        if (dssp == null) {
//            Listsp(); // Gọi phương thức Listsp() nếu danh sách sản phẩm chưa được khởi tạo
//        }
//        return dssp;
//
//
//    }
//    public static void main(String[] args) {
//        ProductBUS manager = new ProductBUS(); // Tạo một đối tượng của ManagerProductBUS
//        ArrayList<Product> list = manager.getList();
//        for(Product a: list) {
//            System.out.println(a.getMaSP());
//        }
//
//
//    }
//
//}

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

    public static void main(String[] args) {
        ProductBUS manager = new ProductBUS(); // Tạo một đối tượng của ManagerProductBUS
        ArrayList<Product> list = manager.getList();
    }

}
