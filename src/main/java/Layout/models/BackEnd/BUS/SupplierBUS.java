package Layout.models.BackEnd.BUS;
import Layout.models.BackEnd.DAO.SupplierDAO;
import Layout.models.BackEnd.DTO.Supplier;

import java.text.Normalizer;
import java.util.ArrayList;



public class SupplierBUS {
    private ArrayList<Supplier> listNcc;
    private SupplierDAO nccDao= new SupplierDAO();

    public SupplierBUS() {
        
    }

    public void listNCC() {
    	listNcc= new ArrayList<Supplier>();
        listNcc = nccDao.selectAll();
    }

    public Boolean add(Supplier supplier) {
        return nccDao.add(supplier);
    }

    public Boolean update(Supplier supplier) {
        return nccDao.update(supplier);
    }

    public Boolean checkId(String id) {
        for (Supplier supplier : listNcc) {
            if (id.equals(supplier.getMaNCC())) {
                return true;
            }
        }
        return false;
    }

    public Boolean updateTrangthai(String manv,int trangthai) {
		Boolean result = nccDao.updateTrangThai(manv, trangthai);
        return result;
	}
    public ArrayList<Supplier> getList() {
        if (listNcc == null) {
            listNCC();
        }
        return listNcc;
    }

    public Supplier getsupplierDTO(String mancc) {

        for (Supplier ncc : getList()) {
            if (ncc.getMaNCC().equals(mancc)) {
                return ncc;
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
    public boolean isMatched(Supplier sup, String selectedField, String txt) {
        // Chuẩn hóa chuỗi txt
        String normalizedTxt = removeAccents(txt.toLowerCase());

        switch (selectedField) {
            case "MaNCC":
                return removeAccents(sup.getMaNCC().toLowerCase()).contains(normalizedTxt);
            case "TenNCC":
                return removeAccents(sup.getTenNCC().toLowerCase()).contains(normalizedTxt);
            case "SDT":
                return removeAccents(sup.getSDT().toLowerCase()).contains(normalizedTxt);
            case "Địa chỉ":
                return removeAccents(sup.getDiaChi().toLowerCase()).contains(normalizedTxt);
            default:
                return false;
        }
    }
    
    public static void main(String[] args) {
		 SupplierBUS manager= new SupplierBUS(); // Tạo một đối tượng của ManagerProductBUS
		  ArrayList<Supplier> list = manager.getList();
		  for(Supplier a: list) {
			  System.out.println(a.getTenNCC());
		  }
		 
		
	}
}
