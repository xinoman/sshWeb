/**
 * 
 */
package com.its.util;

import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午9:35:50
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public class CryptoUtil {
	
	static {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
    }

    // Salt
    static byte[] salt = {
        (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
        (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99
    };

    // Iteration count
    static int count = 20;

    static char[] password = {
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'
    };

    /** Singleton instance */
    private CryptoUtil() {
    }

    /**
     * Decrypt a String.
     * @param input The encrypted string.
     * @return The decrypted string.
     */
    public static String doDecrypt(String input) throws Exception {

        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec;
        SecretKeyFactory keyFac;
        byte[] buf = input.getBytes("ISO-8859-1");

        // Create PBE parameter set
        pbeParamSpec = new PBEParameterSpec(salt, count);

        pbeKeySpec = new PBEKeySpec(password);
        keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

        // Initialize PBE Cipher with key and parameters
        pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);

        // Our cleartext
        byte[] ciphertext = buf;

        // Encrypt the cleartext
        byte[] cleartext = pbeCipher.doFinal(ciphertext);

        return new String(cleartext, "ISO-8859-1");
    }

    /**
     * Encrypt a String.
     * @param input The input string.
     * @return The encrypted string.
     */
    public static String doEncrypt(String input) throws Exception {

        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec;
        SecretKeyFactory keyFac;
        //byte[] buf = input.getBytes();

        // Create PBE parameter set
        pbeParamSpec = new PBEParameterSpec(salt, count);

        pbeKeySpec = new PBEKeySpec(password);
        keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

        // Initialize PBE Cipher with key and parameters
        pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

        // Our cleartext
        byte[] cleartext = input.getBytes();

        // Encrypt the cleartext
        byte[] ciphertext = pbeCipher.doFinal(cleartext);

        return new String(ciphertext, "ISO-8859-1");
    }

    /**
     * Digest a String.
     * @param input The input string.
     * @return The digested string.
     */
    public static String doDigest(String input) throws Exception {
        byte[] buf = input.getBytes();
        return CryptoUtil.doDigest(buf);
    }
    
    public static String doDigest(byte[] buf) throws Exception {
        byte[] digest = null;
        StringBuffer hexString = new StringBuffer();
        MessageDigest algorithm = MessageDigest.getInstance("MD5");

        algorithm.reset();
        algorithm.update(buf);
        digest = algorithm.digest();
        int digestLen = digest.length;
        for (int i = 0; i < digestLen; i++) {
            byte b = digest[i];
            if (b >= 0 && b <= 0xF) {
            	hexString.append("0").append(Integer.toHexString(0xF & b));
            }
            else {
            	hexString.append(Integer.toHexString(0xFF & b));
            }
        }

        return hexString.toString().toUpperCase();    	
    }

    /*
     * Converts a byte to hex digit and writes to the supplied buffer
     */
    public static void byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int high = ( (b & 0xf0) >> 4);
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

    /*
     * Converts a byte array to hex string
     */
    public static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();

        int len = block.length;

        for (int i = 0; i < len; i++) {
            byte2hex(block[i], buf);
            if (i < len - 1) {
                buf.append(":");
            }
        }
        return buf.toString();
    }

    public static byte[] hex2byte(String input) {
        byte[] ret_val = new byte[input.length() / 2];
        for (int i = 0; i < ret_val.length; i++) {
            ret_val[i] = (byte) (hexcharvalue(input.charAt( (i + 1) * 2 - 1))
                                 +
                                 (hexcharvalue(input.charAt( (i + 1) * 2 - 2)) *
                                  16));
        }

        return ret_val;
    }

    public static int hexcharvalue(char input) {
        char[] hexChars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < hexChars.length; i++) {
            if (input == hexChars[i]) {
                return i;
            }
        }

        return 0;
    }
    
    /**
	 * 转换字符串为MD5字符串
	 * 
	 * @param data
	 * @return
	 */
	public static final String toMd5(String data) throws Exception{
		MessageDigest digest = null;
		digest = MessageDigest.getInstance("MD5");		
		// 计算哈希数据
		digest.update(data.getBytes());
		return encodeHex(digest.digest());
	}

	/**
	 * 将字节数组转换为十六进制大写字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static final String encodeHex(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString().toUpperCase();
	}

    public static void main(String[] args) {
        try {
            //System.out.println("Result = K"+CryptoUtil.doDecrypt("AAAAAAAA")+"k");
            String result = CryptoUtil.doDigest("admin");
            System.out.println("Result = " + result);
            System.out.println("Length = " + result.length());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
