package application;

public class Inp {
    int p,r,m,n;

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    @Override
    public String toString(){
      String send = "number of candidates: "+this.p+", number of rooms"+this.r+", number of rows:"+this.m+", number of column:"+this.n;
      return send;
    }
}
