package Layout.models.BackEnd.ConnectDataBasee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ConnectionDB {
    static int countConnection = 0;
    static int countQuery = 0;
    static int countUpdate = 0;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    String dataBaseName = null;
    String userName = null;
    String pass = null;
    String ipAddress = "localhost:3306";

    public ConnectionDB() {
        checkDriver();
        dataBaseName = "taytay";
        userName = "root";
        pass = "";
        ipAddress = "localhost:3306";
        setupConnect();
    }

    public ConnectionDB(String dataBaseName) {
        checkDriver();
        this.dataBaseName = dataBaseName;
    }

    public ConnectionDB(String dataBaseName, String userName, String pass) {
        checkDriver();
        this.dataBaseName = dataBaseName;
        this.userName = userName;
        this.pass = pass;
        setupConnect();
    }

    public Connection getConnection() {
        return conn;
    }

    // ket noi toi database
    private void setupConnect() {
        try {

            String url = "jdbc:mysql://" + ipAddress + "/" + dataBaseName + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, userName, pass);
            stmt = conn.createStatement();
            countConnection++;
            System.out.println("**\n" + countConnection + ": Success! Đã kết nối tới '" + dataBaseName + "'");

        } catch (SQLException e) {

            System.err.println("--ERROR! Không thể kết nối tới '" + dataBaseName + "'");
            JOptionPane.showMessageDialog(null, "--ERROR! Không thể kết nối tới '" + dataBaseName + "'");

        }
    }

    // login
    public void logIn(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
        setupConnect();
    }

    // query
    public ResultSet sqlQuery(String qry) {
        if (checkConnect()) {

            try {
                rset = stmt.executeQuery(qry);
                countQuery++;
                System.out.println(countQuery + ": Success Query!" + qry);
                return rset;
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null,
                        "--ERROR! Không thể lấy dữ liệu từ '" + dataBaseName + "'" + "\n" + e.getLocalizedMessage());
                return null;

            }
        }
        return null;
    }

    // ghi data update
    public Boolean sqlUpdate(String qry) {

        if (checkConnect()) {

            try {

                stmt.executeUpdate(qry);
                countUpdate++;
                System.out.println(countUpdate + ": Success Update!" + qry);
                return true;

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null,
                        "--ERROR! Không thể ghi dữ liệu xuống '" + dataBaseName + "'" + "\n" + e.getLocalizedMessage());
                return false;
            }
        }
        return false;
    }

    // dong connection
    public void closeConnection() {

        try {

            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }

            System.out.println("Success! Đóng kết nối tới '" + dataBaseName + "' thành công.\n");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "--ERROR! Không thể đóng kết nối tới '" + dataBaseName + "'\n" + e.getLocalizedMessage());

        }
    }

    // check login and connect
    public Boolean checkConnect() {

        if (conn == null || stmt == null) {
            JOptionPane.showMessageDialog(null, "--ERROR! Chưa thiết lập kết nối với '" + dataBaseName
                    + "'. Vui lòng đăng nhập để thiết lập kết nối ");
            return false;
        }
        return true;
    }

    // check Driver
    private void checkDriver() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Không tìm thấy Driver mysql!");
        }
    }

    // get header
    public ArrayList<String> getHeaders(String tableName) {
        ArrayList<String> headers = new ArrayList<>();
        if (checkConnect()) {
            try {
                ResultSetMetaData rsMetaData = sqlQuery("SELECT * FROM " + tableName).getMetaData();
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    headers.add(rsMetaData.getColumnName(i));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "-- ERROR! Không thể lấy headers của " + tableName + " trong " + dataBaseName);
            }
        }
        return headers;
    }

    // lấy chiTietQuyen từ maQuyen
    public String getUserPermissionDetailsFromDatabase(String maQuyen) {
        String chiTietQuyen = "";

        try {
            // tạo đối tượng Connection để kết nối với cơ sở dữ liệu
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taytay", "root", "");

            // tạo đối tượng Statement để thực thi câu lệnh sql
            Statement statement = connection.createStatement();

            // thực hiện truy vấn sql
            String sql = "SELECT ChiTietQuyen FROM permission WHERE MaQuyen = '" + maQuyen + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            // lấy chi tiết quyền từ kết quả truy vấn
            if (resultSet.next()) {
                chiTietQuyen = resultSet.getString("ChiTietQuyen");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chiTietQuyen;
    }

    // test this file
    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        ResultSet resultSet = connectionDB.sqlQuery("SELECT * FROM some_table"); // replace "some_table" with your
                                                                                 // actual table name

        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)); // replace 1 with the column index you want to print
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection();
        }
    }
}
