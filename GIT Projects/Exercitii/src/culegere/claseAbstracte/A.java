package culegere.claseAbstracte;

//Să se dezvolte clasa abstractă A în care sunt definite două metode:
//        ‐ metoda abstractă calcul();
//        ‐ metoda durataCalcul() ce returnează durata exprimată în
//        milisecunde, a execuţiei metodei calcul();
//        Din clasa abstractă A, se va deriva clasa B ce conţine implementarea
//        metodei calcul(). Se va dezvolta şi o clasă de test, pentru clasa
//        derivată B.
public abstract class A {

    public abstract void executieMetodaCalcul(int n);

    public long durataCalcul(int n) {
        long t1 = System.currentTimeMillis();
        executieMetodaCalcul(n);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

}

class B extends A {

    @Override
    public void executieMetodaCalcul(int n) {
        //calculeaza n*n*n produse
        int i, j, k;
        long rezultat;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                for (k = 1; k <= n; k++)
                    rezultat = i * j * k;
    }
}

class Test {
    public static void main(String args[]) {
        final int n = 1000;
        B b = new B();
        System.out.println("durata calcul = " + b.durataCalcul(n) + " ms.");
    }
}

