package Layout.models.BackEnd.ChangeData;

import com.google.gson.Gson;

import Layout.models.BackEnd.DTO.Invoice;

import java.util.List;

public class InvoiceData {
    // Phương thức chuyển đổi danh sách Invoice thành JSON
    public String toJSON(List<Invoice> invoices) {
        Gson gson = new Gson();
        return gson.toJson(invoices);
    }
}
