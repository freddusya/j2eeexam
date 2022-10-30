package sg.com.Util;

import java.text.DecimalFormat;

public class NumberUtil {
	
	public static String formatIDStr(long number) {
		DecimalFormat f = new DecimalFormat("000000");
		return f.format(number);
	}
	
}
