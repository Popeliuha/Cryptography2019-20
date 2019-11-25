import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the 10 Bit Key :");
        //1010000010
        int K = Integer.parseInt(inp.readLine(),2);

        SDES sdes = new SDES(K);

        System.out.println("Enter the 8 Bit message To be Encrypt  : ");
        int m = Integer.parseInt(inp.readLine(),2);
        // 10100100
        System.out.print("\nKey K1: ");
        SDES.printData( sdes.K1, 8);
        System.out.print("\nKey K2: ");
        SDES.printData( sdes.K2, 8);

        m = sdes.encrypt( m);
        System.out.print("\nEncrypted Message: ");
        SDES.printData( m, 8);

        m = sdes.decrypt( m);
        System.out.print("\nDecrypted Message: ");
        SDES.printData( m, 8);
    }
}
