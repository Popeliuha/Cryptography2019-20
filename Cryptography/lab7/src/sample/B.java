package sample;

import java.math.BigInteger;
import java.util.Random;

public class B extends Diffi_Hellman {

    public B(BigInteger a, BigInteger p) {
        super(a, p);
    }
    public BigInteger generateY(){
        y = new BigInteger((new Random().nextInt()+1)+"");
        bY = a.modPow(y,p);
        return bY;
    }
    public void generateK(){
        k = bX.modPow(y,p);
    }
}
