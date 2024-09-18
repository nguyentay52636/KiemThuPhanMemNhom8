package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Promotion;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PromotionDAO {
    ConnectionDB qlkmConnection;

    public PromotionDAO() {

    }

    public ArrayList<Promotion> readDB() {
        qlkmConnection = new ConnectionDB();
        ArrayList<Promotion> dssp = new ArrayList<>();
        try {
            String qry = "SELECT * FROM promotion";
            ResultSet r = qlkmConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makm = r.getString("MaKM");
                    String tenkm = r.getString("TenKM");
                    float dkkm = r.getFloat("DieuKienKM");
                    float phantramkm = r.getFloat("PhanTramKM");
                    LocalDate ngaybd = r.getDate("NgayBD").toLocalDate();
                    LocalDate ngaykt = r.getDate("NgayKT").toLocalDate();
                    dssp.add(new Promotion(makm, tenkm, dkkm, phantramkm, ngaybd, ngaykt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng khuyến mãi");
        } finally {
            qlkmConnection.closeConnection();
        }
        return dssp;
    }

    public ArrayList<Promotion> search(String columnName, String value) {
        qlkmConnection = new ConnectionDB();
        ArrayList<Promotion> dssp = new ArrayList<>();

        try {
            String qry = "SELECT * FROM promotion WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = qlkmConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makm = r.getString("MaKM");
                    String tenkm = r.getString("TenKM");
                    float dkkm = r.getFloat("DieuKienKM");
                    float phantramkm = r.getFloat("PhanTramKM");
                    LocalDate ngaybd = r.getDate("NgayBD").toLocalDate();
                    LocalDate ngaykt = r.getDate("NgayKT").toLocalDate();
                    dssp.add(new Promotion(makm, tenkm, dkkm, phantramkm, ngaybd, ngaykt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng khuyến mãi");
        } finally {
            qlkmConnection.closeConnection();
        }

        return dssp;
    }

    public Boolean add(Promotion km) {
        qlkmConnection = new ConnectionDB();
        Boolean ok = qlkmConnection.sqlUpdate("INSERT INTO promotion (MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT) VALUES ('"
                + km.getMaKhuyenMai()+ "', '"
                + km.getTenKhuyenMai() + "', '"
                + km.getDieuKienKhuyenMai() + "', '"
                + km.getPhanTramKhuyenMai() + "', '"
                + km.getNgayBatDau() + "', '"
                + km.getNgayKetThuc() + "');");
        qlkmConnection.closeConnection();
        return ok;
    }

    public Boolean delete(String makm) {
        qlkmConnection = new ConnectionDB();
        Boolean ok = qlkmConnection.sqlUpdate("DELETE FROM promotion WHERE promotion.MaKM = '" + makm + "'");
        qlkmConnection.closeConnection();
        return ok;
    }

    public Boolean update(String makm, String tenkm, float dkkm, float phantramkm, LocalDate ngaybd, LocalDate ngaykt) {
        qlkmConnection = new ConnectionDB();
        Boolean ok = qlkmConnection.sqlUpdate("Update promotion Set "
                + "TenKM='" + tenkm
                + "', DieuKienKM='" + dkkm
                + "', PhanTramKM='" + phantramkm
                + "', NgayBD='" + ngaybd
                + "', NgayKT='" + ngaykt
                + "' where MaKM='" + makm + "'");
        qlkmConnection.closeConnection();
        return ok;
    }

    public void close() {
        qlkmConnection.closeConnection();
    }
}
