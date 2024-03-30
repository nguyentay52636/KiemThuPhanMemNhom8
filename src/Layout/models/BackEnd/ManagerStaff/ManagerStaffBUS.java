package Layout.models.BackEnd.ManagerStaff;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagerStaffBUS {
    private ArrayList<Staff> listStaff = new ArrayList<Staff>();
    private ManagerStaffDAO managerStaffDAO = new ManagerStaffDAO();

    public ManagerStaffBUS() {
        listStaff = managerStaffDAO.readDataBase();
    }

    public void showConsole() {
        listStaff.forEach(staff -> {
            System.out.println(staff.getManhanvien() + " ");
            System.out.println(staff.getTennhanvien() + " ");
            System.out.println(staff.getDiachi() + " ");
            System.out.println(staff.getSdt() + " ");
            System.out.println(staff.getNgaysinh() + " ");
        });
    }

    public String[] getHeaders() {
        return new String[]{"Mã nhân viên", "Tên nhân viên", "Địa chỉ", "SĐT", "Ngày sinh"};
    }

    public void readDataBase() {
        listStaff = managerStaffDAO.readDataBase();
    }

    public String getNextID() {
        return "NV" + String.valueOf(this.listStaff.size() + 1);
    }

    public Staff getStaff(String manhanvien) {
        for (Staff staff : listStaff) {
            if (staff.getManhanvien().equals(manhanvien)) {
                return staff;
            }
        }
        return null;
    }

    public ArrayList<Staff> search(String value, String type, LocalDate ngay1, LocalDate ngay2) {
        ArrayList<Staff> result = new ArrayList<>();

        listStaff.forEach(staff -> {
            if (type.equals("Tất cả")) {
                if (staff.getManhanvien().toLowerCase().contains(value.toLowerCase())
                        || staff.getTennhanvien().toLowerCase().contains(value.toLowerCase())
                        || staff.getDiachi().toLowerCase().contains(value.toLowerCase())
                        || staff.getSdt().toLowerCase().contains(value.toLowerCase())
                        || staff.getNgaysinh().toString().toLowerCase().contains(value.toLowerCase())) {
                    result.add(staff);
                }
            } else {
                switch (type) {
                    case "Mã nhân viên":
                        if (staff.getManhanvien().toLowerCase().contains(value.toLowerCase())) {
                            result.add(staff);
                        }
                        break;
                    case "Tên nhân viên":
                        if (staff.getTennhanvien().toLowerCase().contains(value.toLowerCase())) {
                            result.add(staff);
                        }
                        break;
                    case "Địa chỉ":
                        if (staff.getDiachi().toLowerCase().contains(value.toLowerCase())) {
                            result.add(staff);
                        }
                        break;
                    case "SĐT":
                        if (staff.getSdt().toLowerCase().contains(value.toLowerCase())) {
                            result.add(staff);
                        }
                        break;
                    case "Ngày sinh":
                        if (staff.getNgaysinh().toString().toLowerCase().contains(value.toLowerCase())) {
                            result.add(staff);
                        }
                        break;
                }
            }
        });

        // ngay sinh
        for (int i = result.size() - 1; i >= 0; i--) {
            Staff staff = result.get(i);
            LocalDate ngaysinh = staff.getNgaysinh();

            Boolean ngayKhongThoa = (ngay1 != null && ngaysinh.isBefore(ngay1)) || (ngay2 != null && ngaysinh.isAfter(ngay2));

            if (ngayKhongThoa) {
                result.remove(staff);
            }
        }

        return result;
    }

    public Boolean add(Staff staff) {
        Boolean success = managerStaffDAO.add(staff);

        if (success) {
            listStaff.add(staff);
        }
        return success;
    }

    public Boolean add(String manhanvien, String tennhanvien, LocalDate ngaysinh, String diachi, String sdt, int tranthai) {
        Staff staff = new Staff(manhanvien, tennhanvien, diachi, sdt, ngaysinh, tranthai);
        return add(staff);
    }

    public Boolean delete(String manhanvien) {
        Boolean success = managerStaffDAO.delete(manhanvien);

        if (success) {
            for (int i = (listStaff.size() - 1); i >= 0; i--) {
                if (listStaff.get(i).getManhanvien().equals(manhanvien)) {
                    listStaff.remove(i);
                }
            }
        }
        return success;
    }

    public Boolean update(String manhanvien, String tennhanvien, LocalDate ngaysinh, String diachi, String sdt, int trangthai) {
        Boolean success = managerStaffDAO.update(manhanvien, tennhanvien, ngaysinh, diachi, sdt, trangthai);

        if (success) {
            listStaff.forEach(staff -> {
                if (staff.getManhanvien().equals(manhanvien)) {
                    staff.setTennhanvien(tennhanvien);
                    staff.setNgaysinh(ngaysinh);
                    staff.setDiachi(diachi);
                    staff.setSdt(sdt);
                    staff.setTrangthai(trangthai);
                }
            });
        }

        return success;
    }

    public Boolean updateTrangThai(String manhanvien, int trangthai) {
        Boolean success = managerStaffDAO.updateTrangThai(manhanvien, trangthai);

        if (success) {
            listStaff.forEach(staff -> {
                if (staff.getManhanvien().equals(manhanvien)) {
                    staff.setTrangthai(trangthai);
                }
            });
        }
        return success;
    }

    public ArrayList<Staff> getListStaff() {
        return listStaff;
    }
}
