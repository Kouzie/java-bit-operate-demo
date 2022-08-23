package com.bit.demo;

import com.bit.demo.util.BitOperationUtil;

import java.util.Arrays;

public class ByteHexMain {

    public static void main(String[] args) {
        // 0F F3
        byte[] bytes = new byte[]{0b0000_1111, (byte) 0b1111_0011, 0b000_0000, 0b0000_0000, 0b0000_0000};
        String hex = BitOperationUtil.byteArrayToHex(bytes);
        System.out.println(hex);
        boolean[] bits = BitOperationUtil.hexToBitArray(hex);
        System.out.println(Arrays.toString(bits));
        String hex1 = BitOperationUtil.bitArrayToHex(bits);
        System.out.println(hex1);
    }

}
