package Layout.models.BackEnd.ManagerCustomer;

import java.util.ArrayList;

public class ManagerCustomerBUS {
    private ArrayList<Customer> listCustomer = new ArrayList<Customer>();
    private ManagerCustomerDAO managerCustomerDAO = new ManagerCustomerDAO();

    public ManagerCustomerBUS() {
        listCustomer = managerCustomerDAO.readDataBase();
    }

    public void showConsole() {
        listCustomer.forEach((customer) -> {
            System.out.println(customer.getMaKH() + " " + customer.getTenKH() + " " + customer.getDiaChi() + " " + customer.getSdt() + " " + customer.getTrangThai());
        });
    }

    public String[] getHeaders() {
        return new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "SĐT", "Trạng thái"};
    }

    public void readDateBase() {
        listCustomer = managerCustomerDAO.readDataBase();
    }

    public String getNextID() {
        return "KH" + String.valueOf(this.listCustomer.size() + 1);
    }

    public Customer getCustomer(String makh) {
        for (Customer customer : listCustomer) {
            if (customer.getMaKH().equals(makh)) {
                return customer;
            }
        }
        return null;
    }

    public ArrayList<Customer> search(String value, String type) {
        ArrayList<Customer> result = new ArrayList<>();

        listCustomer.forEach(customer -> {
            if (type.equals("Tất cả")) {
                if (customer.getMaKH().toLowerCase().contains(value.toLowerCase())
                        || customer.getTenKH().toLowerCase().contains(value.toLowerCase())
                        || customer.getDiaChi().toLowerCase().contains(value.toLowerCase())
                        || customer.getSdt().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(customer.getTrangThai() == 1 ? "Ẩn" : "Hiện").toLowerCase().contains(value.toLowerCase())) {
                    result.add(customer);
                }
            } else {
                switch (type) {
                    case "Mã khách hàng":
                        if (customer.getMaKH().toLowerCase().contains(value.toLowerCase())) {
                            result.add(customer);
                        }
                        break;
                    case "Tên khách hàng":
                        if (customer.getTenKH().toLowerCase().contains(value.toLowerCase())) {
                            result.add(customer);
                        }
                        break;
                    case "Địa chỉ":
                        if (customer.getDiaChi().toLowerCase().contains(value.toLowerCase())) {
                            result.add(customer);
                        }
                        break;
                    case "SĐT":
                        if (customer.getSdt().toLowerCase().contains(value.toLowerCase())) {
                            result.add(customer);
                        }
                        break;
                    case "Trạng thái":
                        if (String.valueOf(customer.getTrangThai() == 1 ? "Ẩn" : "Hiện").toLowerCase().contains(value.toLowerCase())) {
                            result.add(customer);
                        }
                        break;
                }
            }
        });
        return result;
    }

    public Boolean add(Customer customer) {
        Boolean ans = managerCustomerDAO.add(customer);
        if (ans) {
            listCustomer.add(customer);
        }
        return ans;
    }

    public Boolean add(String makh, String tenkh, String diachi, String sdt, int trangthai) {
        Customer customer = new Customer(makh, tenkh, diachi, sdt, trangthai);
        return add(customer);
    }

    public Boolean delete(String makh) {
        Boolean ans = managerCustomerDAO.delete(makh);

        if (ans) {
            for (int i = (listCustomer.size() - 1); i >= 0; i--) {
                if (listCustomer.get(i).getMaKH().equals(makh)) {
                    listCustomer.remove(i);
                }
            }
        }
        return ans;
    }

    public Boolean update(String makh, String tenkh, String diachi, String sdt, int trangthai) {
        Boolean ans = managerCustomerDAO.update(makh, tenkh, diachi, sdt, trangthai);

        if (ans) {
            listCustomer.forEach(customer -> {
                if (customer.getMaKH().equals(makh)) {
                    customer.setTenKH(tenkh);
                    customer.setDiaChi(diachi);
                    customer.setSdt(sdt);
                    customer.setTrangThai(trangthai);
                }
            });
        }
        return ans;
    }

    public Boolean updateTrangThai(String makh, int trangthai) {
        Boolean ans = managerCustomerDAO.updateTrangThai(makh, trangthai);

        if (ans) {
            listCustomer.forEach(customer -> {
                if (customer.getMaKH().equals(makh)) {
                    customer.setTrangThai(trangthai);
                }
            });
        }
        return ans;
    }

    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }
}
