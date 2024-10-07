package Layout.models.FrontEnd.ThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.ImportBUS;
import Layout.models.BackEnd.BUS.InvoiceBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Customer;
import Layout.models.BackEnd.DTO.Import;
import Layout.models.BackEnd.DTO.Invoice;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.BackEnd.DTO.Supplier;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

public class ThongKeForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	private ArrayList<Object[]> dshd;
	private ArrayList<Object[]> dspn = new ArrayList<>();

	private ProductBUS spbus = new ProductBUS();
	private CustomerBUS cusbus = new CustomerBUS();
	private StaffBUS stbus = new StaffBUS();
	private SupplierBUS supbus = new SupplierBUS();

	private InvoiceBUS invoice = new InvoiceBUS();
	private ImportBUS phieunhap = new ImportBUS();
	private ThongKe thongke = new ThongKe();
	private HashMap<String, Object> tongKet;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table2;
	private JLabel lblspnhieunhat;
	private JLabel lblncc;
	private JLabel lblkh;
	private JLabel lblnv;
	private JLabel lblsp;
	private JLabel lblspnhapnhieunhat;
	private JLabel lbltongtienchira;
	private JLabel lbltongtienthudc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeForm frame = new ThongKeForm();
					frame.getPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongKeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		dshd = thongke.ListHD();
		dspn = thongke.ListPN();
		tabbedPane.addTab("Tổng quát", displaybai1()); // Thêm panel1 vào tab 1
		tabbedPane.addTab("Bán ra", displaybai2(dshd, "hoaDon"));
		tabbedPane.addTab("Nhập hàng", displaybai3(dspn, "Phieunhap"));

		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	public JPanel getPanel() {
		return contentPane;
	}

	public JPanel displaybai1() {

		// Tạo một JPanel mới để chứa tất cả các thành phần
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

		JPanel sanpham = new JPanel();
		sanpham.setBackground(new Color(255, 128, 192));
		sanpham.setPreferredSize(new Dimension(180, 200));
		sanpham.setBorder(new LineBorder(Color.BLACK));
		panel_1.add(sanpham);
		sanpham.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(44, 153, 252));
		sanpham.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

		JLabel lblNewLabel = new JLabel("Sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_6 = (FlowLayout) panel_5.getLayout();
		flowLayout_6.setVgap(50);
		JLabel phone = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_google_mobile_100px.png")));
		phone.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(phone);
		sanpham.add(panel_5, BorderLayout.WEST);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(186, 222, 254));
		sanpham.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));

		lblsp = new JLabel();
		lblsp.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblsp);
		lblsp.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(panel_1, BorderLayout.NORTH);

		JPanel nhanvien = new JPanel();
		nhanvien.setBackground(new Color(255, 185, 220));
		nhanvien.setPreferredSize(new Dimension(180, 200));
		nhanvien.setBorder(new LineBorder(Color.BLACK));
		panel_1.add(nhanvien);
		nhanvien.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44, 153, 252));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		nhanvien.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Nhân viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_7 = (FlowLayout) panel_4.getLayout();
		flowLayout_7.setVgap(50);
		JLabel lblnhanvien = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_assistant_100px.png")));
		panel_4.add(lblnhanvien);
		nhanvien.add(panel_4, BorderLayout.WEST);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setVgap(70);
		nhanvien.add(panel_7, BorderLayout.CENTER);

		lblnv = new JLabel();
		lblnv.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_7.add(lblnv);

		JPanel khachhang = new JPanel();
		khachhang.setPreferredSize(new Dimension(180, 200));
		khachhang.setBorder(new LineBorder(Color.BLACK));
		panel_1.add(khachhang);
		khachhang.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(44, 153, 252));
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		khachhang.add(panel_8, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel("Khách hàng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_8.add(lblNewLabel_4);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_8 = (FlowLayout) panel_10.getLayout();
		flowLayout_8.setVgap(25);
		JLabel lblkhachhang = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_person_male_100px.png")));
		panel_10.add(lblkhachhang);
		khachhang.add(panel_10, BorderLayout.WEST);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_4 = (FlowLayout) panel_12.getLayout();
		flowLayout_4.setVgap(70);
		khachhang.add(panel_12, BorderLayout.CENTER);

		lblkh = new JLabel();
		lblkh.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_12.add(lblkh);

		JPanel NCC = new JPanel();
		NCC.setPreferredSize(new Dimension(180, 200));
		NCC.setBorder(new LineBorder(Color.BLACK));
		panel_1.add(NCC);
		NCC.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(44, 153, 252));
		FlowLayout flowLayout_3 = (FlowLayout) panel_9.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		NCC.add(panel_9, BorderLayout.NORTH);

		JLabel lblNewLabel_5 = new JLabel("Nhà cung cấp");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_9.add(lblNewLabel_5);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_9 = (FlowLayout) panel_11.getLayout();
		flowLayout_9.setVgap(50);
		JLabel lblNCC = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_company_100px.png")));
		panel_11.add(lblNCC);
		NCC.add(panel_11, BorderLayout.WEST);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(186, 222, 254));
		FlowLayout flowLayout_5 = (FlowLayout) panel_13.getLayout();
		flowLayout_5.setVgap(70);
		NCC.add(panel_13, BorderLayout.CENTER);

		lblncc = new JLabel();
		lblncc.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_13.add(lblncc);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50));

		thongketonghop();
		// char thong ke

		return panel;
	}

	public JPanel displaybai2(ArrayList<Object[]> list, String type) {

		// Tạo panel chứa nội dung của tab 2
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(20);
		panel.add(panel_1, BorderLayout.NORTH);

		JPanel panel_16 = new JPanel();
		panel_16.setForeground(Color.BLACK);
		panel_16.setBackground(new Color(223, 223, 255));
		panel_1.add(panel_16);
		panel_16.setLayout(new GridLayout(2, 1, 0, 15));

		JLabel lblNewLabel_10 = new JLabel("Sản phẩm được bán nhiều nhất");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBackground(new Color(223, 223, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_16.add(lblNewLabel_10);

		lblspnhieunhat = new JLabel();
		lblspnhieunhat.setText("");
		lblspnhieunhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblspnhieunhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_16.add(lblspnhieunhat);

		JPanel panel3 = new JPanel();
		FlowLayout fl_panel3 = new FlowLayout();
		fl_panel3.setVgap(0);
		panel3.setLayout(fl_panel3);
		panel_1.add(panel3);

		JDateChooser dateChooserFrom = new JDateChooser();
		JDateChooser dateChooserTo = new JDateChooser();
		dateChooserFrom.setPreferredSize(new Dimension(140, 25));
		dateChooserTo.setPreferredSize(new Dimension(140, 25));
		dateChooserTo.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					ArrayList<Object[]> timdc = thongke.timkiem(dateChooserFrom, dateChooserTo, list);
					addrowtable1(timdc, type, table2);
					addrowtable2(timdc, type, table_2);
				}
			}
		});
		JPanel panelloc = new JPanel();
		panelloc.setBorder(new TitledBorder("Thống kê theo thời gian"));
		panelloc.setLayout(new FlowLayout());
		panel3.add(panelloc);

		panelloc.add(dateChooserFrom);

		JLabel lblNewLabel_8 = new JLabel("Đến");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelloc.add(lblNewLabel_8);

		panelloc.add(dateChooserTo);

		JButton btnlammoi = new JButton("Làm mới");
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnlammoi.setPreferredSize(new Dimension(80, 30));
		panel3.add(btnlammoi);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(223, 223, 255));
		panel_1.add(panel_19);
		panel_19.setLayout(new GridLayout(2, 1, 30, 20));

		JLabel label_19 = new JLabel("Tổng tiền thu được ");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_19.add(label_19);

		lbltongtienthudc = new JLabel("");
		lbltongtienthudc.setHorizontalAlignment(SwingConstants.CENTER);
		lbltongtienthudc.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_19.add(lbltongtienthudc);
		btnlammoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reload("Hoadon");
			}
		});
		JPanel panel_2 = new JPanel(new BorderLayout());

		// Tạo JTable với DefaultTableModel
		table2 = new JTable();
		table2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addrowtable1(list, type, table2);
		table2.setShowGrid(false); // Ẩn đường viền
		table2.setShowHorizontalLines(false); // Ẩn đường kẻ ngang
		table2.setShowVerticalLines(false); // Ẩn đường kẻ dọc

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table2.setDefaultRenderer(Object.class, centerRenderer);
		// Thêm JTable vào JScrollPane để có thanh cuộn
		JScrollPane scrollPane = new JScrollPane(table2);
		panel_2.add(scrollPane);
		panel.add(panel_2, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout());

		table_2 = new JTable();
		addrowtable2(list, type, table_2);
		panel_3.add(table_2);
		tab2();
		return panel;

	}

	public JPanel displaybai3(ArrayList<Object[]> list, String type) {

		// Tạo panel chứa nội dung của tab 2
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(20);
		panel.add(panel_1, BorderLayout.NORTH);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(223, 223, 255));
		panel_1.add(panel_15);
		panel_15.setLayout(new GridLayout(2, 1, 0, 15));

		JLabel lblNewLabel_11 = new JLabel("Sản phẩm được nhập nhiều nhất");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_15.add(lblNewLabel_11);

		lblspnhapnhieunhat = new JLabel();
		lblspnhapnhieunhat.setBackground(new Color(223, 223, 255));
		lblspnhapnhieunhat.setText("");
		lblspnhapnhieunhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblspnhapnhieunhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_15.add(lblspnhapnhieunhat);

		JPanel panel3 = new JPanel();
		FlowLayout fl_panel3 = new FlowLayout();
		fl_panel3.setVgap(0);
		panel3.setLayout(fl_panel3);
		panel_1.add(panel3);

		JDateChooser dateChooserFrom = new JDateChooser();
		JDateChooser dateChooserTo = new JDateChooser();
		dateChooserFrom.setPreferredSize(new Dimension(140, 25));
		dateChooserTo.setPreferredSize(new Dimension(140, 25));
		dateChooserTo.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					ArrayList<Object[]> timdc = thongke.timkiem(dateChooserFrom, dateChooserTo, list);
					addrowtable1(timdc, type, table);
					addrowtable2(timdc, type, table_1);
				}
			}
		});
		JPanel panelloc = new JPanel();
		panelloc.setBorder(new TitledBorder("Thống kê theo thời gian"));
		panelloc.setLayout(new FlowLayout());
		panel3.add(panelloc);

		panelloc.add(dateChooserFrom);

		JLabel lblNewLabel_8 = new JLabel("Đến");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelloc.add(lblNewLabel_8);

		panelloc.add(dateChooserTo);

		JButton btnlammoi = new JButton("Làm mới");
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnlammoi.setPreferredSize(new Dimension(80, 30));
		panel3.add(btnlammoi);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(223, 223, 255));
		panel_1.add(panel_18);
		panel_18.setLayout(new GridLayout(2, 1, 0, 10));

		JLabel lblNewLabel_1 = new JLabel("Tổng tiền chi ra mua sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_18.add(lblNewLabel_1);

		lbltongtienchira = new JLabel("0");
		lbltongtienchira.setHorizontalAlignment(SwingConstants.CENTER);
		lbltongtienchira.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_18.add(lbltongtienchira);
		btnlammoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reload("Phieunhap");

			}
		});
		JPanel panel_2 = new JPanel(new BorderLayout());

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addrowtable1(list, type, table);
		table.setShowGrid(false); // Ẩn đường viền
		table.setShowHorizontalLines(false); // Ẩn đường kẻ ngang
		table.setShowVerticalLines(false); // Ẩn đường kẻ dọc

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		// Thêm JTable vào JScrollPane để có thanh cuộn
		JScrollPane scrollPane = new JScrollPane(table);
		panel_2.add(scrollPane);
		panel.add(panel_2, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout());

		table_1 = new JTable();
		addrowtable2(list, type, table_1);
		panel_3.add(table_1);
		tab3();
		return panel;

	}

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

	public void reload(String tab) {
		if (tab.equals("Phieunhap")) {
			dspn = thongke.ListPN();
			addrowtable1(dshd, "Phieunhap", table);
			addrowtable2(dshd, "Phieunhap", table_1);
		} else if (tab.equals("Hoadon")) {

			dshd = thongke.ListHD();
			// Cập nhật dữ liệu cho tab 2
			addrowtable1(dshd, "hoaDon", table2);
			addrowtable2(dshd, "hoaDon", table_2);
		}
	}

	public void thongketonghop() {
		int soluongsp = 0;
		for (Product pr : spbus.getList()) {
			if (pr.getTrangthai() == 0) {
				soluongsp++;
			}
		}
		lblsp.setText(soluongsp + "");

		ArrayList<Staff> dsnv = new ArrayList<>();
		dsnv = stbus.getList();
		int soluongnv = 0;
		for (Staff nv : dsnv) {
			if (nv.getTrangThai() == 0) {
				soluongnv++;
			}
		}
		lblnv.setText(soluongnv + "");

		ArrayList<Customer> dskh = new ArrayList<>();
		dskh = cusbus.getDskh();
		int soluongkh = 0;
		for (Customer kh : dskh) {
			if (kh.getTrangThai() == 0) {
				soluongkh++;
			}
		}
		lblkh.setText(soluongkh + "");

		ArrayList<Supplier> dsncc = new ArrayList<>();
		dsncc = supbus.getList();
		int soluongncc = 0;
		for (Supplier ncc : dsncc) {
			if (ncc.getTrangThai() == 0) {
				soluongncc++;
			}
		}
		lblncc.setText(soluongncc + "");

	}

	public void tab2() {

		String tensp = ""; // Khởi tạo biến tensp trước khi sử dụng
		for (Product pr : spbus.getList()) {
			if (pr.getTrangthai() == 0 && pr.getMaSP().equals(thongke.findMostSoldProductID())) {
				tensp = pr.getTenSP();
			}
		}
		lblspnhieunhat.setText(tensp);

		float tongtienthuduoc = 0;
		ArrayList<Invoice> dsinvoice = invoice.getListInvoice();
		for (Invoice invoi : dsinvoice) {
			tongtienthuduoc += invoi.getTongTien();
			System.out.println(invoi.getTongTien());
		}
		String formattedNumber = PriceFormatter.format(tongtienthuduoc);
		lbltongtienthudc.setText(formattedNumber);
	}

	public void tab3() {

		String tenspnhap = "";
		for (Product pr : spbus.getList()) {
			if (pr.getTrangthai() == 0 && pr.getMaSP().equals(thongke.findMostImportedProductID())) {
				tenspnhap = pr.getTenSP();
			}
		}
		lblspnhapnhieunhat.setText(tenspnhap);

		float tongtienchira = 0;
		ArrayList<Import> dsimport = phieunhap.getDspn();
		for (Import inp : dsimport) {
			tongtienchira += inp.getTongTien();

		}
		lbltongtienchira.setText(tongtienchira + "");

	}

}
