package com.tulin.common.utlis;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @Description 工具类
 * @author ShiXian
 * @date 2017-8-15
 * @version 1.0
 *
 */
public class Tools {

	/** 数字 包括小数点*/
	public final static Pattern NUMBERS = Pattern.compile("^\\d+(\\.\\d+)?$");
	/** 邮件 */
	public final static Pattern EMAIL = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
	/** 移动电话 */
	public final static Pattern MOBILE = Pattern.compile("(?:0|86|\\+86)?1[34578]\\d{8,9}");
	/** 银行卡号 **/
	public final static Pattern BANKCARDNO = Pattern.compile("^([1-9]{1})(\\d{15}|\\d{18}|\\d{19})$");
	/** 身份证号码 */
	public final static Pattern CITIZEN_ID = Pattern.compile("[1-9]\\d{5}[1-2]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}(\\d|X|x)");
	/** URL */
	public final static Pattern PWD = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
	/** 密码固定6位 */
	public final static Pattern PWD_LENGTH_6 = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6}$");
	/** 日期是否符合正则表达式：包括年月日，闰年、平年和每月31天、30天和闰月的28天或者29天 */
	public static final Pattern DATE = Pattern  
            .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");
	/** 随机字符 */
	private static final String[] codeBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
		"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
		"Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
		"u", "v", "w", "x", "y", "z", "/", "=", "_", "-", "+" };
	
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String UUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	/**
	 * 
	 * 通过正则表达式验证
	 * 
	 * @param regex
	 *            正则
	 * 
	 * @param value
	 *            值
	 * 
	 * @return 是否匹配正则
	 * 
	 */
	public static boolean isMactchRegex(Pattern pattern, String value) {
		Matcher mat = pattern.matcher(value);
		return mat.matches();
	}

	/**
	 * 随机生成六位数验证码
	 * 
	 * @return
	 */
	public static int getRandomNum() {
		Random r = new Random();
		return r.nextInt(900000) + 100000;// (Math.random()*(999999-100000)+100000)
	}
	
	/**
	 * 生成token
	 * 
	 * @return
	 */
	public static String getToken(int bit) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bit; i++) {
			sb.append(codeBase[r.nextInt(codeBase.length)]);
		}
		return sb.toString();
	}

	/**
	 * 判断字符串是否为数字包括小数点
	 * 
	 * @param strnum
	 * @return boolean
	 */
	public static boolean isNumber(String strnum) {
		return isMactchRegex(NUMBERS, strnum);
	}

	/**
	 * 验证邮箱
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmail(String email) {
		return isMactchRegex(EMAIL, email);
	}

	/**
	 * 验证手机号码
	 * 
	 * @param mobiles
	 * @return boolean
	 */
	public static boolean isMobile(String mobileNumber) {
		return isMactchRegex(MOBILE, mobileNumber);
	}

	/**
	 * 验证日期  格式：yyyy-MM-dd
	 * @author ShiXian
	 * @return boolean
	 * @date 2017年10月10日
	 *
	 */
	public static boolean isDate(String strdt){
		return isMactchRegex(DATE, strdt);
	}
	
	/**
	 * 验证身份证号
	 * @author ShiXian
	 * @return boolean
	 * @date 2017年10月10日
	 *
	 */
	public static boolean isIDCard(String str){
		return isMactchRegex(CITIZEN_ID, str);
	}
	
	/**
	 * 
	 * 验证银行卡号
	 * @author ShiXian
	 * @return boolean
	 *
	 */
	public static boolean isBankCardNo(String str){
		return isMactchRegex(BANKCARDNO, str);
	}
	
	/**
	 * 验证密码
	 * @author ShiXian
	 * @return boolean
	 * @date 2017年10月10日
	 *
	 */
	public static boolean isPassword(String str){
		return isMactchRegex(PWD, str);
	}
	/**
	 * 固定6位密码
	 * @param str
	 * @return
	 */
	public static boolean isPWD_Length_6(String str){
		return isMactchRegex(PWD_LENGTH_6, str);
	}
	
	public static void main(String[] args) {
		System.out.println(isBankCardNo("62568978454564666770"));
	}
}
