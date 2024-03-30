package Layout.models.BackEnd.ConnectDataBasee;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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
        dataBaseName = "Quanlysieuthidienthoai";
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

                JOptionPane.showMessageDialog(null, "--ERROR! Không thể lấy dữ liệu từ '" + dataBaseName + "'" + "\n" + e.getLocalizedMessage());
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

                JOptionPane.showMessageDialog(null, "--ERROR! Không thể ghi dữ liệu xuống '" + dataBaseName + "'" + "\n" + e.getLocalizedMessage());
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

            JOptionPane.showMessageDialog(null, "--ERROR! Không thể đóng kết nối tới '" + dataBaseName + "'\n" + e.getLocalizedMessage());

        }
    }

    // check login and connect
    public Boolean checkConnect() {

        if (conn == null || stmt == null) {
            JOptionPane.showMessageDialog(null, "--ERROR! Chưa thiết lập kết nối với '" + dataBaseName + "'. Vui lòng đăng nhập để thiết lập kết nối ");
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

    // lay cac tieu de cua mot bang trong co so du lieu
    public ArrayList<String> getHeaders(String talbleName) {
        ArrayList<String> headers = new ArrayList<String>();

        if (checkConnect()) {
            try {
                ResultSetMetaData rsMetaData = sqlQuery("SELECT * FROM " + talbleName).getMetaData();

                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    headers.add(rsMetaData.getColumnName(i));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "--ERROR! Không thể lấy headers của '" + talbleName + "' trong '" + dataBaseName + "'");
            }
        }
        return headers;
    }

    // test this file
    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();

        if (connectionDB.checkConnect()) {
            System.out.println("Connection to the database successful");

            // Lấy danh sách các tiêu đề của bảng "tableName"
            String tableName = "invoice";
            ArrayList<String> headers = connectionDB.getHeaders(tableName);
            System.out.println("Headers of table " + tableName + ": " + headers);

            // Thực hiện truy vấn dữ liệu từ bảng
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = connectionDB.sqlQuery(query);

            // In ra kết quả truy vấn
            if (resultSet != null) {
                try {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // In tiêu đề của các cột
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnName(i) + "\t");
                    }
                    System.out.println();

                    // In dữ liệu từ các hàng
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Query returned null");
            }
        } else {
            System.out.println("Connection to the database failed!");
        }

        connectionDB.closeConnection();
    }

}
