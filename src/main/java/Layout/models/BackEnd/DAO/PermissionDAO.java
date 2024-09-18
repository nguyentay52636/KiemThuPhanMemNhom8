package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Permission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PermissionDAO {

    ConnectionDB qlqConnection;

    public PermissionDAO() {

    }

    public ArrayList<Permission> readDB() {
        qlqConnection = new ConnectionDB();
        ArrayList<Permission> dsq = new ArrayList<>();
        try {
            String qry = "SELECT * FROM permission";
            ResultSet r = qlqConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String maq = r.getString("MaQuyen");
                    String tenq = r.getString("TenQuyen");
                    String chitietq = r.getString("ChiTietQuyen");

                    dsq.add(new Permission(maq, tenq, chitietq));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng phân quyền");
        } finally {
            qlqConnection.closeConnection();
        }
        return dsq;
    }

    public ArrayList<Permission> search(String columnName, String value) {
        qlqConnection = new ConnectionDB();
        ArrayList<Permission> dsq = new ArrayList<>();

        try {
            String qry = "SELECT * FROM permission WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = qlqConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String maq = r.getString("MaQuyen");
                    String tenq = r.getString("TenQuyen");
                    String chitietq = r.getString("ChiTietQuyen");

                    dsq.add(new Permission(maq, tenq, chitietq));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng phân quyền");
        } finally {
            qlqConnection.closeConnection();
        }

        return dsq;
    }

    public Boolean add(Permission q) {
        qlqConnection = new ConnectionDB();
        Boolean ok = qlqConnection.sqlUpdate("INSERT INTO permission (MaQuyen, TenQuyen, ChiTietQuyen) VALUES ('"
                + q.getMaQuyen()+ "', '"
                + q.getTenQuyen()+ "', '"
                + q.getChiTietQuyen()+ "');");
        qlqConnection.closeConnection();
        return ok;
    }

    public Boolean delete(String maq) {
        qlqConnection = new ConnectionDB();
        Boolean ok = qlqConnection.sqlUpdate("DELETE FROM permission WHERE permission.MaQuyen = '" + maq + "'");
        qlqConnection.closeConnection();
        return ok;
    }

    public Boolean update(String maq, String tenquyen, String chitietquyen) {
        qlqConnection = new ConnectionDB();
        Boolean ok = qlqConnection.sqlUpdate("Update permission Set "
                + "TenQuyen='" + tenquyen
                + "',ChiTietQuyen='" + chitietquyen
                + "' where MaQuyen='" + maq + "';");
        qlqConnection.closeConnection();
        return ok;
    }

    public void close() {
        qlqConnection.closeConnection();
    }
}
