package com.bit.demo.util;


public class BitOperationUtil {

    public static String byteArrayToHex(byte[] byteArray) {
        StringBuffer hexText = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexText.append(String.format("%02X", byteArray[i]));
        }
        return hexText.toString();
    }

    public static byte[] hexToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
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

    /**
     * https://stackoverflow.com/questions/42913981/bit-array-to-byte-array
     * 8bit 배수로 출력된다.
     */
    public static byte[] bitArrayToByteArray(boolean[] bits) {
        // 4bit 묶음 개수로 results 배열 생성
        byte[] results = new byte[(bits.length + 7) / 8];
        int byteValue = 0;
        int index;
        for (index = 0; index < bits.length; index++) {
            // 한개씩 leftshift 하고 끝자리에 추가하는 형식
            byteValue = (byteValue << 1) | (bits[index] ? 1 : 0);
            // 1byte 만큼 반복했다면
            if (index % 8 == 7) {
                results[index / 8] = (byte) byteValue; // 배열에 1byte 에 해당하는 byteValue 추가
                // byteValue = 0; // 4bit 씩만 사용해야 하기에 초기화 해야함
            }
        }
        // 마지막 index 가 나누어 떨어지지 않는다면
        if (index % 8 != 0) {
            // 나머지 개수만큼 뒤에 0을 채워넣음
            results[index / 8] = (byte) (byteValue << (8 - (index % 8)));
        }
        return results;
    }

    public static boolean[] byteArrayToBitArray(byte[] bytes) {
        boolean[] result = new boolean[bytes.length * 8];
        for (int i = 0; i < bytes.length; i++) {
            byte byteValue = bytes[i];
            for (int j = 0; j < 8; j++) {
                result[i * 8 + j] = (0b1000_0000 & byteValue) == 0b1000_0000;
                byteValue = (byte) (byteValue << 1);
            }
        }
        return result;
    }
}