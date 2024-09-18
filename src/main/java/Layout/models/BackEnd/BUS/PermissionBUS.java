package Layout.models.BackEnd.BUS;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DAO.PermissionDAO;
import Layout.models.BackEnd.DTO.Permission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PermissionBUS {

    private ArrayList<Permission> dsq = new ArrayList<>();
    PermissionDAO qlqDAO = new PermissionDAO();
    ConnectionDB connectionDB = new ConnectionDB();

    public PermissionBUS() {
        dsq = qlqDAO.readDB();
    }

    public void showConsole() {
        dsq.forEach((q) -> {
            System.out.print(q.getMaQuyen() + " ");
            System.out.print(q.getChiTietQuyen());
        });
    }

    public String[] getHeaders() {
        return new String[]{"Mã quyền", "Tên quyền", "Chi tiết quyền"};
    }

    public void readDB() {
        dsq = qlqDAO.readDB();
    }

    public String getNextID() {
        return "Q" + String.valueOf(this.dsq.size() + 1);
    }

    public Permission getQuyen(String maquyen) {
        for (Permission q : dsq) {
            if (q.getMaQuyen().equals(maquyen)) {
                return q;
            }
        }
        return null;
    }

    public ArrayList<Permission> getPermission() {
        ArrayList<Permission> result = new ArrayList<>();
        String query = "SELECT * FROM permission";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Permission permission = new Permission(resultSet.getString("MaQuyen"), resultSet.getString("TenQuyen"), resultSet.getString("ChiTietQuyen"));
                result.add(permission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Permission> search(String value, String type) {
        ArrayList<Permission> result = new ArrayList<>();

        dsq.forEach((q) -> {
            if (type.equals("Tất cả")) {
                if (q.getMaQuyen().toLowerCase().contains(value.toLowerCase())
                        || q.getTenQuyen().toLowerCase().contains(value.toLowerCase())
                        || q.getChiTietQuyen().toLowerCase().contains(value.toLowerCase())) {
                    result.add(q);
                }
            } else {
                switch (type) {
                    case "Mã quyền":
                        if (q.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(q);
                        }
                        break;
                    case "Tên quyền":
                        if (q.getTenQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(q);
                        }
                        break;
                    case "Chi tiết quyền":
                        if (q.getChiTietQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(q);
                        }
                        break;
                }
            }

        });

        return result;
    }

    public Boolean add(Permission sp) {
        Boolean ok = qlqDAO.add(sp);

        if (ok) {
            dsq.add(sp);
        }
        return ok;
    }

    public Boolean add(String maquyen, String tenquyen, String chitiet) {
        Permission sp = new Permission(maquyen, tenquyen, chitiet);
        return add(sp);
    }

    public Boolean delete(String maquyen) {
        Boolean ok = qlqDAO.delete(maquyen);

        if (ok) {
            for (int i = (dsq.size() - 1); i >= 0; i--) {
                if (dsq.get(i).getMaQuyen().equals(maquyen)) {
                    dsq.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String maquyen, String tenquyen, String chitiet) {
        Boolean ok = qlqDAO.update(maquyen, tenquyen, chitiet);

        if (ok) {
            dsq.forEach((q) -> {
                if (q.getMaQuyen().equals(maquyen)) {
                    q.setTenQuyen(tenquyen);
                    q.setChiTietQuyen(chitiet);
                }
            });
        }

        return ok;
    }

    public ArrayList<Permission> getDsq() {
        if (dsq == null) {
            dsq = qlqDAO.readDB();
        }
        return dsq;
    }
}
