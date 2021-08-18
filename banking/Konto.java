package banking;

public class Konto {
    String kontoInhaber;
    int inhaberID;
    double kontoSaldo;
    int kontoID;

    Kunde kunde;

    public Konto(String kontoInhaber, int inhaberID, double kontoSaldo, int kontoID) {
        this.kontoInhaber = kontoInhaber;
        this.inhaberID = inhaberID;
        this.kontoSaldo = kontoSaldo;
        this.kontoID = kontoID;

    }
    private static double Saldo = 0;

    public static double getSaldo() {
        return Saldo;
    }

    public static double Abhebung(double value) {
        return Saldo -= value;
    }

    public static double Einzahlung(double value) {
        return Saldo += value;
    }
    public static void kontoInfo() {

    }
}

