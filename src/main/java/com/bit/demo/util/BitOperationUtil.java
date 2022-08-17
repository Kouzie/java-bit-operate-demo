package com.bit.demo.util;


public class BitOperationUtil {

    public static String byteArrayToHex(byte[] bytes) {
        return "";
    }

    public static byte[] hexToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }

    public static boolean[] byteArrayToBitArray(byte[] bytes) {
        return new boolean[20];
    }

    public static byte[] bitArrayToByteArray(boolean[] bits) {
        return new byte[20];
    }

    public static String bitArrayToHex(boolean[] bits) {
        // bit -> byte -> hex
        byte[] bytes = bitArrayToByteArray(bits);
        String hex = byteArrayToHex(bytes);
        return hex;
    }

    public static boolean[] hexToBitArray(String hex) {
        // hex -> byte -> bit
        byte[] bytes = hexToByteArray(hex);
        boolean[] bits = byteArrayToBitArray(bytes);
        return bits;
    }
}
