package Layout.models.FrontEnd.ThongKe.components.RenderTable;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Layout.models.FrontEnd.Formatter.PriceFormatter;
import Layout.models.FrontEnd.ThongKe.ThongKe;

public class DataTable {
    private ThongKe thongke = new ThongKe();
    private HashMap<String, Object> tongKet;

    public void addrowtable1(ArrayList<Object[]> list, String type, JTable a) {
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        Font font = new Font("Segoe", 0, 16);
        Font fontHeader = new Font("Segoe", Font.BOLD, 16);

        // font for table1
        a.setFont(font);
        a.getTableHeader().setFont(fontHeader);

        // set size for table1
        a.setRowHeight(30);
        TableColumnModel columnModel = a.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }
        // Thêm các tên cột vào model
        String[] columns;
        if (type.equals("hoaDon")) {
            columns = new String[] { "MaHD", "TenNV", "TenKH", "TenSP", "SoLuong", "DonGia", "ThanhTien", "NgayLap" };
        } else {
            columns = new String[] { "MaPN", "TenNV", "TenNCC", "TenSP", "SoLuong", "DonGia", "ThanhTien", "NgayNhap" };
        }
        for (String column : columns) {
            model.addColumn(column);
        }
        // Thêm các dòng đối với mỗi hóa đơn
        for (Object[] invoice : list) {
            model.addRow(new Object[] {
                    invoice[0], invoice[3], invoice[4], "", "", "", "", invoice[1]
            });

            // Thêm các dòng chi tiết cho mỗi hóa đơn
            ArrayList<Object[]> chiTietHoaDon = (ArrayList<Object[]>) invoice[5];

            for (Object[] chiTiet : chiTietHoaDon) {
                double donGia = Double.parseDouble(chiTiet[2].toString());
                int soLuong = Integer.parseInt(chiTiet[3].toString());

                float tongTien = (float) (donGia * soLuong);
                String formattedTongTien = PriceFormatter.format(tongTien);

                model.addRow(new Object[] {
                        "", "", "", chiTiet[1], chiTiet[3], chiTiet[2], formattedTongTien, ""
                });
            }

            String formattedTongTien1 = PriceFormatter.format((float) invoice[2]);

            // Thêm hàng tổng tiền của mỗi hóa đơn vào cuối
            model.addRow(new Object[] {
                    "", "", "", "", "", "Tổng tiền:", formattedTongTien1, ""
            });

            // Thêm dòng trống để phân biệt giữa các đơn hàng
            model.addRow(new Object[] {
                    "", "", "", "", "", "", "", ""
            });
        }

        a.setModel(model);

    }

    public void addrowtable2(ArrayList<Object[]> list, String type, JTable a) {
        Font font = new Font("Segoe", 0, 16);
        Font fontHeader = new Font("Segoe", Font.BOLD, 16);

        // font for table1
        a.setFont(font);
        a.getTableHeader().setFont(fontHeader);

        // set size for table1
        a.setRowHeight(30);
        TableColumnModel columnModel = a.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }
        // Tính toán tổng kết dựa trên danh sách đã cho
        tongKet = thongke.tongket(list);
        Object[][] newData;
        if (type.equals("hoaDon")) {
            float tongTien = ((Number) tongKet.get("TongTien")).floatValue();
            String formattedTongTien = PriceFormatter.format(tongTien);
            newData = new Object[][] {
                    { "Tổng kết", null, null, null, null, null, "Tổng tiền", null },
                    { tongKet.get("TongSoHoaDon") + "hoadon", tongKet.get("TongSoNhanVien") + " nhân viên",
                            tongKet.get("TongSoKhachHang") + " khách hàng",
                            tongKet.get("SoTenSanPham") + " mặt hàng", tongKet.get("TongSoSanPhamDaBan") + " sản phẩm",
                            null, formattedTongTien, null }
            };
        } else {
            newData = new Object[][] {
                    { "Tổng kết", null, null, null, null, null, "Tổng tiền", null },
                    { tongKet.get("TongSoHoaDon") + "phieunhap", tongKet.get("TongSoNhanVien") + " nhân viên",
                            tongKet.get("TongSoKhachHang") + " NCC",
                            tongKet.get("SoTenSanPham") + " mặt hàng", tongKet.get("TongSoSanPhamDaBan") + " sản phẩm",
                            null, tongKet.get("TongTien"), null }
            };
        }
        // Tạo một mảng chứa tên của các cột
        String[] columns = { "Tổng kết", "New column", "New column", "New column", "New column", "New column",
                "Tổng tiền", "New column" };

        // Tạo một model mới với dữ liệu và tên cột đã tính toán
        DefaultTableModel newTableModel = new DefaultTableModel(newData, columns);

        // Cập nhật model cho table_1
        a.setModel(newTableModel);
    }
}
