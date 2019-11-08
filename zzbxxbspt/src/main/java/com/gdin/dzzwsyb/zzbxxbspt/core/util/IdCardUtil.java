package com.gdin.dzzwsyb.zzbxxbspt.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;

public class IdCardUtil {

	private static String[] cityCode = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35",
			"36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65",
			"71", "81", "82", "91" };

	private static int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	public static Message validate18Idcard(String idcard) {
		if (idcard == null) {
			return new Message(false, "身份证不能为空！");
		}

		// 非18位为假
		int s = 18;
		if (idcard.length() != s) {
			return new Message(false, "身份证位数不正确!");
		}
		// 获取前17位
		String idcard17 = idcard.substring(0, 17);
		// 前17位全部为数字
		if (!isDigital(idcard17)) {
			return new Message(false, "身份证不能为非数字!");
		}

		String provinceid = idcard.substring(0, 2);
		// 校验省份
		if (!checkProvinceid(provinceid)) {
			return new Message(false, "身份证无效的省份代码!");
		}

		// 校验出生日期
		String birthday = idcard.substring(6, 14);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date birthDate = sdf.parse(birthday);
			String tmpDate = sdf.format(birthDate);
			// 出生年月日不正确
			if (!tmpDate.equals(birthday)) {
				return new Message(false, "身份证无效的出生日期!");
			}
		} catch (ParseException e1) {
			return new Message(false, "身份证无效的出生日期!");
		}

		// 获取第18位
		String idcard18Code = idcard.substring(17, 18);

		char c[] = idcard17.toCharArray();

		int bit[] = converCharToInt(c);

		int sum17 = 0;

		sum17 = getPowerSum(bit);

		// 将和值与11取模得到余数进行校验码判断
		String checkCode = getCheckCodeBySum(sum17);
		if (null == checkCode) {
			return new Message(false, "身份证无效的校验位!");
		}
		// 将身份证的第18位与算出来的校码进行匹配，不相等就为假
		if (!idcard18Code.equalsIgnoreCase(checkCode)) {
			return new Message(false, "身份证无效的校验位!");
		}
		// System.out.println("正确");
		return new Message(true, "");
	}

	/**
	 * 校验省份
	 * 
	 * @param provinceid
	 * @return 合法返回TRUE，否则返回FALSE
	 */
	private static boolean checkProvinceid(String provinceid) {
		for (String id : cityCode) {
			if (id.equals(provinceid)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 数字验证
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isDigital(String str) {
		return str.matches("^[0-9]*$");
	}

	/**
	 * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
	 * 
	 * @param bit
	 * @return
	 */
	private static int getPowerSum(int[] bit) {

		int sum = 0;

		if (power.length != bit.length) {
			return sum;
		}

		for (int i = 0; i < bit.length; i++) {
			for (int j = 0; j < power.length; j++) {
				if (i == j) {
					sum = sum + bit[i] * power[j];
				}
			}
		}
		return sum;
	}

	/**
	 * 将和值与11取模得到余数进行校验码判断
	 * 
	 * @param checkCode
	 * @param sum17
	 * @return 校验位
	 */
	private static String getCheckCodeBySum(int sum17) {
		String checkCode = null;
		switch (sum17 % 11) {
		case 10:
			checkCode = "2";
			break;
		case 9:
			checkCode = "3";
			break;
		case 8:
			checkCode = "4";
			break;
		case 7:
			checkCode = "5";
			break;
		case 6:
			checkCode = "6";
			break;
		case 5:
			checkCode = "7";
			break;
		case 4:
			checkCode = "8";
			break;
		case 3:
			checkCode = "9";
			break;
		case 2:
			checkCode = "x";
			break;
		case 1:
			checkCode = "0";
			break;
		case 0:
			checkCode = "1";
			break;
		default:
		}
		return checkCode;
	}

	/**
	 * 将字符数组转为整型数组
	 * 
	 * @param c
	 * @return
	 * @throws NumberFormatException
	 */
	private static int[] converCharToInt(char[] c) throws NumberFormatException {
		int[] a = new int[c.length];
		int k = 0;
		for (char temp : c) {
			a[k++] = Integer.parseInt(String.valueOf(temp));
		}
		return a;
	}

}
