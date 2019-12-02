package sample;

import java.math.BigInteger;
import java.util.Random;


public class A  extends Diffi_Hellman{
    public A(BigInteger a, BigInteger p) {
        super(a, p);
    }

    public BigInteger generateX(){
        x = new BigInteger((new Random().nextInt()+1)+"");
        bX = a.modPow(x,p);
        return bX;
    }
    public void generateK(){
        k = bY.modPow(x,p);
    }

}
