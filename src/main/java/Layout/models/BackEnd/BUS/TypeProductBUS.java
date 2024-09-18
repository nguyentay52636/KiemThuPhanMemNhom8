package Layout.models.BackEnd.BUS;

import Layout.models.BackEnd.DAO.TypeProductDAO;
import Layout.models.BackEnd.DTO.TypeProduct;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TypeProductBUS {
    private ArrayList<TypeProduct> dslsp = new ArrayList<>();
    private TypeProductDAO qllspDAO = new TypeProductDAO();

    public TypeProductBUS() {
        dslsp = qllspDAO.readDB();
    }

    public void hienThi() {
        dslsp.forEach((lsp) -> {
            System.out.print(lsp.getMaLoaiSanPham() + " ");
            System.out.print(lsp.getTenLoaiSanPham());
        });
    }

    public String[] getHeaders() {
        return new String[]{"Mã loại", "Tên loại", "Mô tả"};
    }

    public String getNextID() {
        return "LSP" + String.valueOf(this.dslsp.size() + 1);
    }

    public void readDB() {
        dslsp = qllspDAO.readDB();
    }

    public TypeProduct getLoaiSanPham(String maloaiSanPham) {
        for (TypeProduct lsp : dslsp) {
            if (lsp.getMaLoaiSanPham().equals(maloaiSanPham)) {
                return lsp;
            }
        }
        return null;
    }

    public ArrayList<TypeProduct> search(String value, String type) {

        ArrayList<TypeProduct> result = new ArrayList<>();

        dslsp.forEach((lsp) -> {
            if (type.equals("Tất cả")) {
                if (lsp.getMaLoaiSanPham().toLowerCase().contains(value.toLowerCase())
                        || lsp.getTenLoaiSanPham().toLowerCase().contains(value.toLowerCase())
                        || lsp.getMoTa().toLowerCase().contains(value.toLowerCase()))  {
                    result.add(lsp);
                }
            } else {
                switch (type) {
                    case "Mã loại":
                        if (lsp.getMaLoaiSanPham().toLowerCase().contains(value.toLowerCase())) {
                            result.add(lsp);
                        }
                        break;
                    case "Tên loại":
                        if (lsp.getTenLoaiSanPham().toLowerCase().contains(value.toLowerCase())) {
                            result.add(lsp);
                        }
                        break;
                    case "Mô tả":
                        if (lsp.getMoTa().toLowerCase().contains(value.toLowerCase())) {
                            result.add(lsp);
                        }
                        break;

                }
            }
        });

        return result;
    }

    public Boolean add(TypeProduct typeProduct) {
        Boolean result = qllspDAO.add(typeProduct);

        if (result) {
            dslsp.add(typeProduct);
        }
        return false;
    }

    public Boolean add(String maLoaiSanPham, String tenLoaiSanPham, String moTa) {
        TypeProduct typeProduct = new TypeProduct(maLoaiSanPham, tenLoaiSanPham, moTa);
        return add(typeProduct);
    }

    public Boolean delete(String maLoaiSanPham) {
        Boolean result = qllspDAO.delete(maLoaiSanPham);

        if (result) {
            for (int i = 0; i < dslsp.size(); i++) {
                if (dslsp.get(i).getMaLoaiSanPham().equals(maLoaiSanPham)) {
                    dslsp.remove(i);
                }
            }
        }
        return result;
    }

    public Boolean update(String maLoaiSanPham, String tenLoaiSanPham, String moTa) {
        Boolean result = qllspDAO.update(maLoaiSanPham, tenLoaiSanPham, moTa);

        if (result) {
            dslsp.forEach((lsp) -> {
                if (lsp.getMaLoaiSanPham().equals(maLoaiSanPham)) {
                    lsp.setTenLoaiSanPham(tenLoaiSanPham);
                    lsp.setMoTa(moTa);
                }
            });
        }
        return result;
    }

    public ArrayList<TypeProduct> getDslsp() {
        return dslsp;
    }

}
