package Layout.models.BackEnd.ManagerSupplier;

import java.util.ArrayList;

public class ManagerSupplierBUS {
    public ArrayList<Supplier> listSupplier = new ArrayList<>();

    ManagerSupplierDAO managerSupplierDAO = new ManagerSupplierDAO();

    public ManagerSupplierBUS() {
        listSupplier = managerSupplierDAO.readDateBase();
    }

    public void show() {
        listSupplier.forEach(supplier -> {
            System.out.println(supplier.getMaNhaCungCap() + " ");
            System.out.println(supplier.getTenNhaCungCap() + " ");
            System.out.println(supplier.getDiaChi() + " ");
            System.out.println(supplier.getSoDienThoai() + " ");
            System.out.println(supplier.getFax());
        });
    }

    public void readDataBase() {
        listSupplier = managerSupplierDAO.readDateBase();
    }

    public String getNextID() {
        return "NCC" + String.valueOf(this.listSupplier.size() + 1);
    }

    public Supplier getSupplier(String manhacungcap) {
        for (Supplier supplier : listSupplier) {
            if (supplier.getMaNhaCungCap().equals(manhacungcap)) {
                return supplier;
            }
        }
        return null;
    }

    public ArrayList<Supplier> search(String value, String type) {
        ArrayList<Supplier> result = new ArrayList<>();

        listSupplier.forEach(supplier -> {
            if (type.equals("Tất cả")) {
                if (supplier.getMaNhaCungCap().toLowerCase().contains(value.toLowerCase())
                        || supplier.getTenNhaCungCap().toLowerCase().contains(value.toLowerCase())
                        || supplier.getDiaChi().toLowerCase().contains(value.toLowerCase())
                        || supplier.getSoDienThoai().toLowerCase().contains(value.toLowerCase())
                        || supplier.getFax().toLowerCase().contains(value.toLowerCase())) {
                    result.add(supplier);
                }
            } else {
                switch (type) {
                    case "Mã nhà cung cấp":
                        if (supplier.getMaNhaCungCap().toLowerCase().contains(value.toLowerCase())) {
                            result.add(supplier);
                        }
                        break;
                    case "Tên nhà cung cấp":
                        if (supplier.getTenNhaCungCap().toLowerCase().contains(value.toLowerCase())) {
                            result.add(supplier);
                        }
                        break;
                    case "Địa chỉ":
                        if (supplier.getDiaChi().toLowerCase().contains(value.toLowerCase())) {
                            result.add(supplier);
                        }
                        break;
                    case "Số điện thoại":
                        if (supplier.getSoDienThoai().toLowerCase().contains(value.toLowerCase())) {
                            result.add(supplier);
                        }
                        break;
                    case "Fax":
                        if (supplier.getFax().toLowerCase().contains(value.toLowerCase())) {
                            result.add(supplier);
                        }
                        break;
                }
            }
        });
        return result;
    }

    public Boolean add(Supplier supplier) {
        managerSupplierDAO = new ManagerSupplierDAO();
        Boolean success = managerSupplierDAO.add(supplier);
        if (success) {
            listSupplier.add(supplier);
        }
        return success;
    }

    public Boolean add(String manhacungcap, String tennhacungcap, String diachi, String sdt, String fax) {
        Supplier supplier = new Supplier(manhacungcap, tennhacungcap, diachi, sdt, fax);
        return add(supplier);
    }

    public Boolean delete(String manhacungcap) {
        managerSupplierDAO = new ManagerSupplierDAO();

        Boolean success = managerSupplierDAO.delete(manhacungcap);

        if (success) {
            for (int i = 0; i < listSupplier.size(); i++) {
                if (listSupplier.get(i).getMaNhaCungCap().equals(manhacungcap)) {
                    listSupplier.remove(i);
                    break;
                }
            }
        }
        return success;
    }

    public Boolean update(String manhacungcap, String tennhacungcap, String diachi, String sdt, String fax) {
        managerSupplierDAO = new ManagerSupplierDAO();
        Boolean success = managerSupplierDAO.update(manhacungcap, tennhacungcap, diachi, sdt, fax);

        if (success) {
            listSupplier.forEach(supplier -> {
                if (supplier.getMaNhaCungCap().equals(manhacungcap)) {
                    supplier.setTenNhaCungCap(tennhacungcap);
                    supplier.setDiaChi(diachi);
                    supplier.setSoDienThoai(sdt);
                    supplier.setFax(fax);
                }
            });
        }
        return success;
    }

    public ArrayList<Supplier> getListSupplier() {
        return listSupplier;
    }
}
