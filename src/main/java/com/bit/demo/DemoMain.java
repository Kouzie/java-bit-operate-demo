package com.bit.demo;

import java.util.Arrays;

public class DemoMain {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        // 1010_1101_01
        // 10bit ->
        boolean[] bits = new boolean[]{true, false, true, false, true, true, false, true, false, true};
        byte[] bytes = bitArrayToHexByteArray(bits);
        for (byte b : bytes) {
            System.out.printf(String.format("%X", b));
        }

        boolean[] newBits = hexByteArrayToBitArray(bytes);
        System.out.println(Arrays.toString(newBits));
    }


    // https://stackoverflow.com/questions/42913981/bit-array-to-byte-array
    private static byte[] bitArrayToHexByteArray(boolean[] bits) {
        // 8bit 묶음 개수로 results 배열 생성
        byte[] results = new byte[(bits.length + 3) / 4];
        int byteValue = 0;
        int index;
        for (index = 0; index < bits.length; index++) {
            // 한개씩 leftshift 하고 끝자리에 추가하는 형식
            byteValue = (byteValue << 1) | (bits[index] ? 1 : 0);
            // 1byte 만큼 반복했다면
            if (index % 4 == 3) {
                results[index / 4] = (byte) byteValue; // 배열에 1byte 에 해당하는 byteValue 추가
                byteValue = 0; // 4bit 씩만 사용해야 하기에 초기화 해야함
            }
        }
        // 마지막 index 가 나누어 떨어지지 않는다면
        if (index % 4 != 0) {
            // 나머지 개수만큼 뒤에 0을 채워넣음
            results[index / 4] = (byte) (byteValue << (4 - (index % 4)));
        }
        return results;
    }

    private static boolean[] hexByteArrayToBitArray(byte[] bytes) {
        boolean[] result = new boolean[bytes.length * 4];
        for (int i = 0; i < bytes.length; i++) {
            byte byteValue = bytes[i];
            for (int j = 0; j < 4; j++) {
                result[i * 4 + j] = (0b0000_1000 & byteValue) == 0b0000_1000;
                byteValue = (byte) (byteValue << 1);
            }
        }
        return result;
    }


}
