package com.company;

import com.company.SDES;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the 10 Bit Key :");
        //1010000010

int K = Integer.parseInt(inp.readLine(), 2);
        // DataInputStream inp = new DataInputStream(System.in);
        // System.out.println("Enter the 10 Bit Key :");
        // int K = Integer.parseInt(inp.readLine(), 2);

        SDES sdes = new SDES(K);

        System.out.println("Enter the 8 Bit message To be Encrypt  : ");
        // 10100100
        char m = (char)System.in.read();

        int z = Integer.parseInt(Integer.toBinaryString((int)m));

        System.out.print("\nKey K1: ");
        SDES.printData(sdes.K1, 8);
        System.out.print("\nKey K2: ");
        SDES.printData(sdes.K2, 8);

        z = sdes.encrypt(z);
        System.out.print("\nEncrypted Message: ");
        String str = Character.toString((char)z);
        System.out.println(str);
        SDES.printData(m, 8);

        z = sdes.decrypt(z);
        System.out.print("\nDecrypted Message: ");
        SDES.printData(z, 8);
    }
}
