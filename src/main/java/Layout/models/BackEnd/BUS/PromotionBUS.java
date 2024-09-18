package Layout.models.BackEnd.BUS;

import Layout.models.BackEnd.DAO.PromotionDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PromotionBUS {
    private ArrayList<Layout.models.BackEnd.DTO.Promotion> dskm = new ArrayList<>();
    PromotionDAO qlkmDAO = new PromotionDAO();

    public PromotionBUS() {
        dskm = qlkmDAO.readDB();
    }

    public void showConsole() {
        dskm.forEach((km) -> {
            System.out.print(km.getMaKhuyenMai()+ " ");
            System.out.print(km.getTenKhuyenMai()+ " ");
            System.out.println(km.getDieuKienKhuyenMai()+ " ");
            System.out.println(km.getPhanTramKhuyenMai()+ " ");
            System.out.println(km.getNgayBatDau()+ " ");
            System.out.println(km.getNgayKetThuc());
        });
    }

    public String[] getHeaders() {
        return new String[]{"Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện khuyến mãi", "Phần trăm khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc"};
    }

    public void readDB() {
        dskm = qlkmDAO.readDB();
    }

    public String getNextID() {
        return "KM" + String.valueOf(this.dskm.size() + 1);
    }

    public Layout.models.BackEnd.DTO.Promotion getKhuyenMai(String makm) {
        for (Layout.models.BackEnd.DTO.Promotion km : dskm) {
            if (km.getMaKhuyenMai().equals(makm)) {
                return km;
            }
        }
        return null;
    }

    public ArrayList<Layout.models.BackEnd.DTO.Promotion> search(String value, String type, int dk1, int dk2, float phantram1, float phantram2, LocalDate ngay1, LocalDate ngay2) {
        ArrayList<Layout.models.BackEnd.DTO.Promotion> result = new ArrayList<>();

        dskm.forEach((km) -> {
            if (type.equals("Tất cả")) {
                if (km.getMaKhuyenMai().toLowerCase().contains(value.toLowerCase())
                        || km.getTenKhuyenMai().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getDieuKienKhuyenMai()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getPhanTramKhuyenMai()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getNgayBatDau()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getNgayKetThuc()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(km);
                }
            } else {
                switch (type) {
                    case "Mã khuyến mãi":
                        if (km.getMaKhuyenMai().toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Tên khuyến mãi":
                        if (km.getTenKhuyenMai().toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Điều kiện khuyến mãi":
                        if (String.valueOf(km.getDieuKienKhuyenMai()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Phần trăm khuyến mãi":
                        if (String.valueOf(km.getPhanTramKhuyenMai()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Ngày bắt đầu":
                        if (String.valueOf(km.getNgayBatDau()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Ngày kết thúc":
                        if (String.valueOf(km.getNgayKetThuc()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                }
            }
        });

        for (int i = result.size() - 1; i >= 0; i--) {
            Layout.models.BackEnd.DTO.Promotion km = result.get(i);
            float dkkm = km.getDieuKienKhuyenMai();
            float phantram = km.getPhanTramKhuyenMai();
            LocalDate ngaybd = km.getNgayBatDau();
            LocalDate ngaykt = km.getNgayKetThuc();

            Boolean dkKhongThoa = (dk1 != -1 && dkkm < dk1) || (dk2 != -1 && dkkm > dk2);
            Boolean phantramKhongThoa = (phantram1 != -1 && phantram < phantram1) || (phantram2 != -1 && phantram > phantram2);
            Boolean ngayBDKhongThoa = (ngay1 != null && ngaybd.isBefore(ngay1)) || (ngay2 != null && ngaybd.isAfter(ngay2));
            Boolean ngayKTKhongThoa = (ngay1 != null && ngaykt.isBefore(ngay1)) || (ngay2 != null && ngaykt.isAfter(ngay2));

            if (dkKhongThoa || phantramKhongThoa || (ngayBDKhongThoa && ngayKTKhongThoa)) {
                result.remove(i);
            }
        }

        return result;
    }

    public Boolean add(Layout.models.BackEnd.DTO.Promotion km) {
        Boolean ok = qlkmDAO.add(km);

        if (ok) {
            dskm.add(km);
        }
        return ok;
    }

    public Boolean add(String makm, String tenkm, float dkkm, float phantramkm, LocalDate ngaybd, LocalDate ngaykt) {
        Layout.models.BackEnd.DTO.Promotion sp = new Layout.models.BackEnd.DTO.Promotion(makm, tenkm, dkkm, phantramkm, ngaybd, ngaykt);
        return add(sp);
    }

    public Boolean delete(String makm) {
        Boolean ok = qlkmDAO.delete(makm);

        if (ok) {
            for (int i = (dskm.size() - 1); i >= 0; i--) {
                if (dskm.get(i).getMaKhuyenMai().equals(makm)) {
                    dskm.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String makm, String tenkm, float dkkm, float phantramkm, LocalDate ngaybd, LocalDate ngaykt) {
        Boolean ok = qlkmDAO.update(makm, tenkm, dkkm, phantramkm, ngaybd, ngaykt);

        if (ok) {
            dskm.forEach((km) -> {
                if (km.getMaKhuyenMai().equals(makm)) {
                    km.setTenKhuyenMai(tenkm);
                    km.setDieuKienKhuyenMai(dkkm);
                    km.setPhanTramKhuyenMai(phantramkm);
                    km.setNgayBatDau(ngaybd);
                    km.setNgayKetThuc(ngaykt);
                }
            });
        }

        return ok;
    }

    public ArrayList<Layout.models.BackEnd.DTO.Promotion> getDskm() {
        return dskm;
    }
}
