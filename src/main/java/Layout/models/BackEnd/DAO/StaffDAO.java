
package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Staff;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffDAO {
	
	private ConnectionDB con;
	ArrayList<Staff> dsnv= new ArrayList<Staff>() ;
	public StaffDAO() {
		
	}
	
	
	public ArrayList<Staff> selectAll() {
		//Tạo danh sách kết quả lưu các danh sách khách hàng rồi in ra
		
		try {
			con= new ConnectionDB();
			
			String sql="select* from employee";
			ResultSet rs=con.sqlQuery(sql);
			
			//Lấy từng khách hàng từ rs cho vào kết quả
			while(rs.next()) {
				String MaNV=rs.getString("MaNV");
				String TenNV=rs.getString("TenNV");
				Date NgaySinh=rs.getDate("NgaySinh");
				String DiaChi=rs.getString("DiaChi");
				String SDT=rs.getString("SDT");
				int TrangThai=rs.getInt("TrangThai");
				Staff staff= new Staff(MaNV,TenNV,NgaySinh,DiaChi,SDT,TrangThai);
				dsnv.add(staff);
				
				
			}
			con.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}

	public Staff getStaffByMaNV(String manv) {
		Staff staff = null;

		try {
			con = new ConnectionDB();
			String sql = "SELECT * FROM employee WHERE MaNV = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(sql);
			pst.setString(1, manv);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String MaNV = rs.getString("MaNV");
				String TenNV = rs.getString("TenNV");
				Date NgaySinh = rs.getDate("NgaySinh");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				int TrangThai = rs.getInt("TrangThai");
				staff = new Staff(MaNV, TenNV, NgaySinh, DiaChi, SDT, TrangThai);
			}
			con.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	public Boolean addDao(Staff staff) {
	    con = new ConnectionDB();
	       
	    String sql = "INSERT INTO employee (MaNV, TenNV, NgaySinh, DiaChi, SDT, TrangThai) VALUES ('" +
                staff.getMaNV() + "', '" +
                staff.getTenNV() + "', '" +
                new Date(staff.getNgaySinh().getTime()) + "', '" +
                staff.getDiachi() + "', '" +
                staff.getSDT() + "', " +
                staff.getTrangThai() + ")";
	    Boolean result = con.sqlUpdate(sql);
	       
	    System.out.println("Thêm nhân viên thành công!");
	    con.closeConnection();
	    return result;
	}


	public Boolean update(Staff staff) {
	    
	         con= new ConnectionDB();
	        // Tạo đối tượng prepareStatement
	         String sql = "UPDATE employee SET TenNV='" + staff.getTenNV() + "', NgaySinh='" + staff.getNgaySinh() + "', DiaChi='" + staff.getDiachi() +
	                 "', SDT='" + staff.getSDT() + "', TrangThai=" + staff.getTrangThai() + " WHERE MaNV='" + staff.getMaNV() + "'";
	        // Set các giá trị cho các tham số
	        Boolean kq=con.sqlUpdate(sql);
	        con.closeConnection();
	        return kq; // Return the number of affected rows
	    
	
	}	
	
	public boolean updateTrangThai(String manv, int trangThai) {
	    con = new ConnectionDB();
	    String sql = "UPDATE employee SET TrangThai = " + trangThai + " WHERE MaNV = '" + manv + "'";
	    Boolean kq = con.sqlUpdate(sql);
	    con.closeConnection();
	    return kq;
	}

	
	 
}


