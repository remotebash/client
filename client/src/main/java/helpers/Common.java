package helpers;

import oshi.util.FormatUtil;

public class Common {
    public static Double parseLong(long value){
        return Double.parseDouble(
                FormatUtil.formatBytes(value).split(" ")[0].replace(",", "."));
    }
}
