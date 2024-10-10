package Layout.models.BackEnd.BUS;

import java.text.Normalizer;
import java.util.ArrayList;

import Layout.models.BackEnd.DAO.StaffDAO;
import Layout.models.BackEnd.DTO.Staff;

public class StaffBUS {

	StaffDAO nvDao = new StaffDAO();
	private ArrayList<Staff> dsnv;

	public StaffBUS() {

	}

	public void readDB() {
		dsnv = nvDao.selectAll();
	}

	public void Listsp() {

		dsnv = new ArrayList<>();
		dsnv = nvDao.selectAll();

	}

	public Staff getStaffByMaNV(String manv) {
		return nvDao.getStaffByMaNV(manv);
	}

	public boolean checkMaMV(String id) {
		ArrayList<Staff> liststaff = getList();
		for (Staff pr : liststaff) {
			if (id.equals(pr.getMaNV())) {
				return true;
			}
		}
		return false; // Trả về false nếu không tìm thấy sản phẩm trong danh sách
	}

	public String getNextID() {
		return "NV" + String.valueOf(this.dsnv.size() + 1);
	}

	public Boolean addBus(Staff product) {
		Boolean result = nvDao.addDao(product);
		return result;

	}

	public Boolean update(Staff product) {
		Boolean result = nvDao.update(product);
		return result;
	}

	public Boolean updateTrangthai(String manv, int trangthai) {
		// Boolean result = nvDao.updateTrangThai(manv, trangthai);
		// return result;
		Boolean result = nvDao.updateTrangThai(manv, trangthai);

		if (result) {
			dsnv.forEach((nv) -> {
				if (nv.getMaNV().equals(manv)) {
					nv.setTrangThai(trangthai);
				}
			});
		}
		return result;
	}

	public ArrayList<Staff> getList() {
		if (dsnv == null) {
			Listsp(); // Gọi phương thức Listsp() nếu danh sách sản phẩm chưa được khởi tạo
		}
		return dsnv;

	}

	public Staff getStaff(String maNV) {
		if (dsnv == null) {
			Listsp();
		}
		for (Staff i : dsnv) {
			if (i.getMaNV().equals(maNV)) {
				return i;
			}
		}
		return null;
	}

	// search
	public ArrayList<Staff> search(String value, String type) {
		ArrayList<Staff> result = new ArrayList<>();

		dsnv.forEach((nv) -> {
			if (type.equals("Tất cả")) {
				if (nv.getMaNV().toLowerCase().contains(value.toLowerCase())
						|| nv.getTenNV().toLowerCase().contains(value.toLowerCase())
						|| nv.getNgaySinh().toString().toLowerCase().contains(value.toLowerCase())
						|| nv.getDiachi().toLowerCase().contains(value.toLowerCase())
						|| nv.getSDT().toLowerCase().contains(value.toLowerCase())
						|| String.valueOf(nv.getTrangThai() == 1 ? "Ẩn" : "Hiện").toLowerCase()
								.contains(value.toLowerCase())) {
					result.add(nv);
				}
			} else {
				switch (type) {
					case "Mã nhân viên":
						if (nv.getMaNV().contains(value)) {
							result.add(nv);
						}
						break;
					case "Tên nhân viên":
						if (nv.getTenNV().contains(value)) {
							result.add(nv);
						}
						break;
					case "Ngày sinh":
						if (nv.getNgaySinh().toString().contains(value)) {
							result.add(nv);
						}
						break;
					case "Địa chỉ":
						if (nv.getDiachi().contains(value)) {
							result.add(nv);
						}
						break;
					case "Số điện thoại":
						if (nv.getSDT().contains(value)) {
							result.add(nv);
						}
						break;
					case "Trạng thái":
						if (String.valueOf(nv.getTrangThai() == 1 ? "Ẩn" : "Hiện").contains(value)) {
							result.add(nv);
						}
						break;
				}
			}
		});
		return result;
	}

	public boolean isMatched(Staff staff, String selectedField, String txt) {
		// Chuẩn hóa chuỗi txt
		String normalizedTxt = removeAccents(txt);
		switch (selectedField) {
			case "MaNV":
				return removeAccents(staff.getMaNV()).contains(normalizedTxt);
			case "TenNV":
				return removeAccents(staff.getTenNV()).contains(normalizedTxt);
			case "SDT":
				return removeAccents(staff.getSDT()).contains(normalizedTxt);
			case "DiaChi":
				return removeAccents(staff.getDiachi()).contains(normalizedTxt);
			default:
				return false;
		}
	}

	private String removeAccents(String input) {
		// Chuyển đổi chuỗi đầu vào sang chữ thường
		input = input.toLowerCase();
		// Chuẩn hóa chuỗi
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
		// Loại bỏ các dấu diacritical
		return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	public static void main(String[] args) {
		StaffBUS manager = new StaffBUS(); // Tạo một đối tượng của ManagerProductBUS
		ArrayList<Staff> list = manager.getList();
		for (Staff a : list) {
			System.out.println(a.getTenNV());
		}
	}

}
