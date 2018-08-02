package Polynomial;

public interface PolyInter {
    public float evaluate(int x);

    public int degree();

    public Poly addPoly(Poly P1, Poly P2);

    public Poly multiplyPoly(Poly P1, Poly P2);

}

