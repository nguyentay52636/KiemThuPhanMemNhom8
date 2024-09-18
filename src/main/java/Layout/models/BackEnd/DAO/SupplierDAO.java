package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SupplierDAO {
	private ConnectionDB con ;
	private ArrayList<Supplier> dsncc = new ArrayList<>();
	
	
	public SupplierDAO() {
		
	}
	public ArrayList<Supplier> selectAll() {
		try {
			con= new ConnectionDB();
			ResultSet rs = con.sqlQuery("select * from supplier") ;
				
			    while (rs.next()) {
			        String mancc = rs.getString("MaNCC");
			        String tenncc = rs.getString("TenNCC");
			        String diachi = rs.getString("DiaChi");
			        String sdt = rs.getString("SDT");
			        String fax = rs.getString("Fax");
			        int trangthai=rs.getInt("TrangThai");
					Supplier ncc = new Supplier(mancc, tenncc, diachi, sdt, fax,trangthai);
			        dsncc.add(ncc); // Add supplier to the list
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return dsncc;
    }
	
	public Boolean add(Supplier supplier) {
		con= new ConnectionDB();
		String sql = "INSERT INTO supplier(MaNCC, TenNCC, DiaChi, SDT, Fax, TrangThai) VALUES (" +
	            "'" + supplier.getMaNCC() + "'," +
	            "'" + supplier.getTenNCC() + "'," +
	            "'" + supplier.getDiaChi() + "'," +
	            "'" + supplier.getSDT() + "'," +
	            "'" + supplier.getFax() + "'," + // Thêm dấu phẩy ở đây
	            "'" + supplier.getTrangThai() + "'" +
	            ")";

		
		Boolean kq = con.sqlUpdate(sql);
		return kq;			
	}
	
	public Boolean update(Supplier supplier) {
		con= new ConnectionDB();
		String sql = "UPDATE supplier SET " +
	            "TenNCC='" + supplier.getTenNCC() + "', " +
	            "DiaChi='" + supplier.getDiaChi() + "', " +
	            "SDT='" + supplier.getSDT() + "', " +
	            "Fax='" + supplier.getFax() + "', " + // Thêm dấu phẩy ở đây
	            "TrangThai='" + supplier.getTrangThai() + "' " + // Thêm dấu phẩy ở đây
	            "WHERE MaNCC='" + supplier.getMaNCC() + "'";

		Boolean kq = con.sqlUpdate(sql);
		return kq;
	}
	
	public boolean updateTrangThai(String maNCC, int trangThai) {
	    con = new ConnectionDB();
	    String sql = "UPDATE supplier SET TrangThai = " + trangThai + " WHERE MaNCC = '" + maNCC + "'";
	    Boolean kq = con.sqlUpdate(sql);
	    con.closeConnection();
	    return kq;
	}
	public static void main(String[] args) {
//		ManagerSupplierDAO a = new ManagerSupplierDAO();
//		SupplierDTO sup= new SupplierDTO("1","1","1","1","1",1);
//		a.add(sup);
		
	}
}
