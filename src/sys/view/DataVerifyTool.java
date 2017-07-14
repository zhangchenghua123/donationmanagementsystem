package sys.view;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证数据格式类
 * 
 * @author 顾伟宏
 * 
 */
public class DataVerifyTool {
	// wi =2(n-1)(mod 11)
	private final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8,
			4, 2, 1 };
	// verify digit
	private final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
	private int[] ai = new int[18];
	private static String[] _areaCode = { "11", "12", "13", "14", "15", "21",
			"22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42",
			"43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
			"63", "64", "65", "71", "81", "82", "91" };
	private static HashMap<String, Integer> dateMap;
	private static HashMap<String, String> areaCodeMap;
	static {
		dateMap = new HashMap<String, Integer>();
		dateMap.put("01", 31);
		dateMap.put("02", null);
		dateMap.put("03", 31);
		dateMap.put("04", 30);
		dateMap.put("05", 31);
		dateMap.put("06", 30);
		dateMap.put("07", 31);
		dateMap.put("08", 31);
		dateMap.put("09", 30);
		dateMap.put("10", 31);
		dateMap.put("11", 30);
		dateMap.put("12", 31);
		areaCodeMap = new HashMap<String, String>();
		for (String code : _areaCode) {
			areaCodeMap.put(code, null);
		}
	}

	// 验证身份证位数,15位和18位身份证
	private boolean verifyLength(String code) {
		int length = code.length();
		if (length == 15 || length == 18) {
			return true;
		} else {
			return false;
		}
	}

	// 判断地区码
	private boolean verifyAreaCode(String code) {
		String areaCode = code.substring(0, 2);
		if (areaCodeMap.containsKey(areaCode)) {
			return true;
		} else {
			return false;
		}
	}

	// 判断月份和日期
	public boolean verifyBirthdayCode(String code) {

		//验证年份
		int year=Integer.parseInt((String) code.subSequence(6, 10));
		if(year<1970||year>2017)
			return false;
		// 验证月份
		String month = code.substring(10, 12);
		boolean isEighteenCode = (18 == code.length());
		if (!dateMap.containsKey(month)) {
			return false;
		}
		// 验证日期
		String dayCode = code.substring(12, 14);
		Integer day = dateMap.get(month);
		String yearCode = code.substring(6, 10);
	
		// 非2月的情况
		if (day != null) {
			if (Integer.valueOf(dayCode) > day || Integer.valueOf(dayCode) < 1) {
				return false;
			}
		}
		// 2月的情况
		else {
			// 闰月的情况
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				if (Integer.valueOf(dayCode) > 29
						|| Integer.valueOf(dayCode) < 1) {
					return false;
				}
			}
			// 非闰月的情况
			else {
				if (Integer.valueOf(dayCode) > 28
						|| Integer.valueOf(dayCode) < 1) {
					return false;
				}
			}
		}
		return true;
	}

	// 验证身份除了最后位其他的是否包含字母
	private boolean containsAllNumber(String code) {
		String str = "";
		if (code.length() == 15) {
			str = code.substring(0, 15);
		} else if (code.length() == 18) {
			str = code.substring(0, 17);
		}
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (!(ch[i] >= '0' && ch[i] <= '9')) {
				return false;
			}
		}
		return true;
	}

	// 验证18位校验码,校验码采用ISO 7064：1983，MOD 11-2 校验码系统
	private boolean verifyMOD(String code) {
		String verify = code.substring(17, 18);
		if ("x".equals(verify)) {
			code = code.replaceAll("x", "X");
			verify = "X";
		}
		String verifyIndex = getVerify(code);
		if (verify.equals(verifyIndex)) {
			return true;
		}
		return false;
	}

	// 获得校验位
	private String getVerify(String eightcardid) {
		int remaining = 0;

		if (eightcardid.length() == 18) {
			eightcardid = eightcardid.substring(0, 17);
		}

		if (eightcardid.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eightcardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}

			for (int i = 0; i < 17; i++) {
				sum = sum + wi[i] * ai[i];
			}
			remaining = sum % 11;
		}

		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	// 15位转18位身份证
	private String uptoeighteen(String fifteencardid) {
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}

	// 验证身份证所有位
	public boolean verify(String idcard) {
		// 验证身份证位数,15位和18位身份证
		if (!verifyLength(idcard)) {
			return false;
		}
		// 验证身份除了最后位其他的是否包含字母
		if (!containsAllNumber(idcard)) {
			return false;
		}

		// 如果是15位的就转成18位的身份证
		String eifhteencard = "";
		if (idcard.length() == 15) {
			eifhteencard = uptoeighteen(idcard);
		} else {
			eifhteencard = idcard;
		}
		// 验证身份证的地区码
		if (!verifyAreaCode(eifhteencard)) {
			return false;
		}
		// 判断月份和日期
		if (!verifyBirthdayCode(eifhteencard)) {
			return false;
		}
		// 验证18位校验码,校验码采用ISO 7064：1983，MOD 11-2 校验码系统
		if (!verifyMOD(eifhteencard)) {
			return false;
		}
		return true;
	}

	/**
	 * 验证是不是正确的金额，浮点数，最多可以有两位小数
	 */
	public boolean verifyMoney(String text) {
		Pattern pattern = Pattern
				.compile("^[1-9]\\d*\\.\\d{1,2}|^0\\.([0-9]){1,2}$|^[1-9]*$");
		Matcher matcher = pattern.matcher(text);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * 检测一个字符串是不是纯数字，只要是纯数字就是正确的银行卡号
	 */
	public boolean verifyBank(String text) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(text);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * 检测一个字符串是不是手机号
	 */
	public boolean verifyPhone(String text) {
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
		Matcher matcher = pattern.matcher(text);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * 验证邮箱格式
	 */
	public boolean verifyMail(String text) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		return p.matcher(text).matches();
	}
}
