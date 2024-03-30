package Layout.models.BackEnd.ManagerStaff;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;

import javax.swing.*;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManagerStaffDAO {
    ConnectionDB managerStaffConnection = new ConnectionDB();

    public ManagerStaffDAO() {

    }

    public ArrayList<Staff> readDataBase() {
        ArrayList<Staff> listStaff = new ArrayList<>();
        managerStaffConnection = new ConnectionDB();

        try  {
            String query = "SELECT * FROM nhanvien";
            ResultSet resultSet = managerStaffConnection.sqlQuery(query);

            if (resultSet != null) {
                String manv = resultSet.getString("MaNV");
                String tennv = resultSet.getString("TenNV");
                LocalDate ngaysinh = resultSet.getDate("NgaySinh").toLocalDate();
                String diachi = resultSet.getString("DiaChi");
                String sdt = resultSet.getString("SDT");
                int trangthai = resultSet.getInt("TrangThai");

                listStaff.add(new Staff(manv, tennv, diachi, sdt, ngaysinh, trangthai));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng nhân viên!");
        } finally {
            managerStaffConnection.closeConnection();
        }

        return listStaff;
    }

    public ArrayList<Staff> search(String columnName, String value) {
        managerStaffConnection = new ConnectionDB();
        ArrayList<Staff> listStaff = new ArrayList<>();

        try {
            String query = "SELECT * FROM nhanvien WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = managerStaffConnection.sqlQuery(query);

            if (resultSet != null) {
                String manv = resultSet.getString("MaNV");
                String tennv = resultSet.getString("TenNV");
                LocalDate ngaysinh = resultSet.getDate("NgaySinh").toLocalDate();
                String diachi = resultSet.getString("DiaChi");
                String sdt = resultSet.getString("SDT");
                int trangthai = resultSet.getInt("TrangThai");

                listStaff.add(new Staff(manv, tennv, diachi, sdt, ngaysinh, trangthai));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi tìm kiếm dữ liệu từ bảng nhân viên!");
        } finally {
            managerStaffConnection.closeConnection();
        }

        return listStaff;
    }

    public Boolean add(Staff staff) {
        managerStaffConnection = new ConnectionDB();
        Boolean success = managerStaffConnection.sqlUpdate("INSERT INTO nhanvien(MaNV, TenNV, DiaChi, SDT, NgaySinh, TrangThai) VALUES ('"
                + staff.getManhanvien() + "','"
                + staff.getTennhanvien() + "','"
                + staff.getDiachi() + "','"
                + staff.getSdt() + "','"
                + staff.getNgaysinh() + "','"
                + staff.getTrangthai() + "');");
        managerStaffConnection.closeConnection();
        return success;
    }

    public Boolean delete(String manhanvien) {
        managerStaffConnection = new ConnectionDB();

        Boolean succes = managerStaffConnection.sqlUpdate("DELETE FROM nhanvien WHERE MaNV = '" + manhanvien + "'");

        managerStaffConnection.closeConnection();
        return succes;
    }

    public Boolean update(String manhanvien, String tennhanvien, LocalDate ngaysinh, String diachi, String sdt, int trangthai) {
        managerStaffConnection = new ConnectionDB();

        Boolean success = managerStaffConnection.sqlUpdate("UPDATE nhanvien SET TenNV = '" + tennhanvien + "', NgaySinh = '" + ngaysinh + "', DiaChi = '" + diachi + "', SDT = '" + sdt + "', TrangThai = " + trangthai + ") WHERE MaNV = '" + manhanvien + "'");
        managerStaffConnection.closeConnection();
        return success;
    }

    public Boolean updateTrangThai(String manhanvien, int trangthai) {
        managerStaffConnection = new ConnectionDB();

        Boolean success = managerStaffConnection.sqlUpdate("UPDATE nhanvien SET TrangThai = " + trangthai + " WHERE MaNV = '" + manhanvien + "'");

        managerStaffConnection.closeConnection();
        return success;
    }

    public void close() {
        managerStaffConnection.closeConnection();
    }
}
