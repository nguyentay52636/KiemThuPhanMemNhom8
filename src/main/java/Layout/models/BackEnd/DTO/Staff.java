package Layout.models.BackEnd.DTO;

import java.sql.Date;


public class Staff {
	//"MaNV", "TenNV", "NgaySinh", "DiaChi", "SDT", "TrangThai"
	private String MaNV,TenNV,Diachi,SDT;
	private int TrangThai;
	private Date NgaySinh;
	
	public Staff() {
		
	}

	public Staff(String maNV, String tenNV, Date ngaySinh, String diachi, String sDT, int trangThai) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		Diachi = diachi;
		SDT = sDT;
		TrangThai = trangThai;
		NgaySinh = ngaySinh;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	
	

}
