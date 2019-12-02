package sample;

import java.math.BigInteger;


public class Diffi_Hellman {
    protected BigInteger a,p,x,y, bX, bY,k;
    public Diffi_Hellman(BigInteger a, BigInteger p) {
        this.a = a;
        this.p = p;
    }

    public BigInteger getA() {
        return a;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getbX() {
        return bX;
    }

    public void setbX(BigInteger bX) {
        this.bX = bX;
    }

    public BigInteger getbY() {
        return bY;
    }

    public void setbY(BigInteger bY) {
        this.bY = bY;
    }

    public BigInteger getK() {
        return k;
    }

    public void setK(BigInteger k) {
        this.k = k;
    }

    public BigInteger getX() {
        return x;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }
}
