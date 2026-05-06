package com.atguigu.schedule.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for MD5 encryption.
 * Used to convert plaintext strings (e.g., passwords) into encrypted strings.
 */
public final class MD5Util {

    /**
     * Encrypt a string using the MD5 algorithm.
     * @param strSrc the original plaintext string
     * @return the encrypted hexadecimal string
     */
    public static String encrypt(String strSrc) {
        try {
            // Hex characters used to convert bytes to a readable string
            char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9', 'a', 'b', 'c', 'd', 'e', 'f' };

            // Convert the input string into a byte array
            byte[] bytes = strSrc.getBytes();

            // Create MD5 message digest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the digest with input bytes
            md.update(bytes);

            // Perform the encryption (generate hash)
            bytes = md.digest();

            int j = bytes.length;

            // Each byte will be converted to two hex characters
            char[] chars = new char[j * 2];

            int k = 0;

            // Convert each byte to hexadecimal format
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf]; // high 4 bits
                chars[k++] = hexChars[b & 0xf];       // low 4 bits
            }

            // Return the final encrypted string
            return new String(chars);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5 encryption error");
        }
    }
}