package cn.travel.utils;

import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String md5(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(MD5Util.class.getName()).log(Level.SEVERE, null, ex);
			}
			BASE64Encoder baseEncoder = new BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}
}