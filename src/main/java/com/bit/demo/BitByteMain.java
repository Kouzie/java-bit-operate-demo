package com.bit.demo;

import com.bit.demo.util.BitOperationUtil;

import java.util.Arrays;

public class BitByteMain {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        // 1010_1101_01
        boolean[] bits = new boolean[]{true, false, true, false, true, true, false, true, false, true};
        // 10 bit -> 16bit
        byte[] bytes = BitOperationUtil.bitArrayToByteArray(bits);
        for (byte b : bytes) {
            System.out.printf(String.format("%X", b)); //AD4
        }
        System.out.println();

        // {true, false, true, false, true, true, false, true, false, true};
        // [true, false, true, false, true, true, false, true, false, true, false, false, false, false, false, false]
        boolean[] newBits = BitOperationUtil.byteArrayToBitArray(bytes);
        System.out.println(Arrays.toString(newBits));
    }


}
