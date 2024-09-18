package Layout.models.FrontEnd.Formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormatter {
    public static String format(float num) {
        BigDecimal trieu = new BigDecimal(num * 1000000);

        Locale vietnam = new Locale("vi", "VN");

        NumberFormat fmoney = NumberFormat.getCurrencyInstance(vietnam);

        return fmoney.format(trieu);
    }

    public static float parsePrice(String formattedPrice) {
        String numberOnly = formattedPrice.replaceAll("[^0-9]", "");
        return Float.parseFloat(numberOnly) / 1000000;
    }
}
