/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layout.models.WritePDF;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.ImportDetailsBUS;
import Layout.models.BackEnd.BUS.InvoiceDetailBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.PromotionBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Customer;
import Layout.models.BackEnd.DTO.Import;
import Layout.models.BackEnd.DTO.ImportDetails;
import Layout.models.BackEnd.DTO.Invoice;
import Layout.models.BackEnd.DTO.InvoiceDetail;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.Promotion;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.BackEnd.DTO.Supplier;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

/**
 *
 * @author tham xinh
 *         gaigai
 */
public class WritePDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public WritePDF() {
        try {
            fontData = new Font(BaseFont.createFont("src/main/resources/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("src/main/resources/Roboto/Roboto-Regular.ttf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("src/main/resources/Roboto/Roboto-Regular.ttf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    public void writePhieuNhap(Import imp) {
        String url = "";
        try {
            fd.setTitle("In phiếu Nhập");
            fd.setLocationRelativeTo(null);
            url = getFile(imp.getMaPN());
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN PHIẾU NHẬP");

            Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + imp.getMaPN(), fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + imp.getNgayNhap(), fontData));
            StaffBUS stbus = new StaffBUS();
            SupplierBUS nhaCungCapBus = new SupplierBUS();
            Supplier nhaCungCap = nhaCungCapBus.getsupplierDTO(imp.getMaNCC());

            Staff st = stbus.getStaff(imp.getMaNV());
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + st.getTenNV(), fontData));
            Paragraph para4 = new Paragraph(new Phrase(" Nhà cung cấp: " + st.getTenNV(), fontData));

            // PromotionBUS prom= new PromotionBUS();
            // Promotion pro= prom.getKhuyenMai(invoice.getMaKhuyenMai());
            // Paragraph para4 = new Paragraph(new Phrase("Thông tin khuyến mãi : "
            // +pro.getTenKhuyenMai()+" + Phần trăm khuyến mãi: "
            // +pro.getPhanTramKhuyenMai(), fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            para4.setIndentationLeft(40);

            // para4.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            // document.add(para4);
            document.add(Chunk.NEWLINE);// add hang trong de tao khoang cach

            // Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[] { 10f, 30f, 15f, 5f, 15f });
            PdfPCell cell;

            // Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            ImportDetailsBUS indebus = new ImportDetailsBUS();
            ArrayList<ImportDetails> list = indebus.getImportDetailsByMaHD(imp.getMaPN());
            // Truyen thong tin tung chi tiet vao table
            ProductBUS pr = new ProductBUS();
            for (ImportDetails ctpn : list) {

                Product prd = pr.getProduct(ctpn.getMaSP());
                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMa(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(prd.getTenSP(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(PriceFormatter.format(prd.getDonGia()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));
                float tonTien = ctpn.getDonGia() * ctpn.getSoLuong();
                pdfTable.addCell(new PdfPCell(new Phrase(PriceFormatter.format(tonTien), fontData)));
            }
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(
                    new Phrase("Tổng thanh toán: " + PriceFormatter.format(imp.getTongTien()), fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writePhieuXuat(Invoice invoice) {
        String url = "";
        try {
            fd.setTitle("In phiếu Xuất");
            fd.setLocationRelativeTo(null);
            url = getFile(invoice.getMaHoaDon());
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN PHIẾU XUẤT");

            Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + invoice.getMaHoaDon(), fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + invoice.getNgayLap(), fontData));
            StaffBUS stbus = new StaffBUS();
            CustomerBUS customerBUS = new CustomerBUS();
            Customer customer = customerBUS.getCustomer(invoice.getMaKhachHang());
            Staff st = stbus.getStaff(invoice.getMaNhanVien());
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + st.getTenNV(), fontData));
            Paragraph para5 = new Paragraph(new Phrase("Khách hàng: " + customer.getTenKh(), fontData));
            PromotionBUS prom = new PromotionBUS();
            Promotion pro = prom.getKhuyenMai(invoice.getMaKhuyenMai());
            Paragraph para4 = new Paragraph(new Phrase("Thông tin khuyến mãi : " + pro.getTenKhuyenMai()
                    + " + Phần trăm khuyến mãi: " + pro.getPhanTramKhuyenMai(), fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            para4.setIndentationLeft(40);
            para5.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para5);
            document.add(para4);
            document.add(Chunk.NEWLINE);// add hang trong de tao khoang cach

            // Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[] { 10f, 30f, 15f, 5f, 15f });
            PdfPCell cell;

            // Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("số lượng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            InvoiceDetailBUS indebus = new InvoiceDetailBUS();
            ArrayList<InvoiceDetail> list = indebus.getInvoiceDetailsByMaHD(invoice.getMaHoaDon());
            // Truyen thong tin tung chi tiet vao table
            ProductBUS pr = new ProductBUS();
            for (InvoiceDetail cthd : list) {

                Product prd = pr.getProduct(cthd.getMaSanPham());
                pdfTable.addCell(new PdfPCell(new Phrase(cthd.getMaHoaDon(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(prd.getTenSP(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(PriceFormatter.format(prd.getDonGia()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(cthd.getSoLuong()), fontData)));
                pdfTable.addCell(
                        new PdfPCell(new Phrase(PriceFormatter.format(prd.getDonGia() * cthd.getSoLuong()), fontData)));
            }
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(
                    new Phrase("Tổng thanh toán: " + PriceFormatter.format(invoice.getTongTien()), fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }
}
