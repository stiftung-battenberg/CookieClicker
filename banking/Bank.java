package banking;

import java.util.Scanner;

public class Bank {

    public static Bank bank;

    public Bank() {
        boolean run = true;
        boolean eBanking = false;

        while (run) {
            System.out.println("Guten Tag");
            System.out.println("************************");
            System.out.println("1. E-Banking");
            System.out.println("2. Neuer Kunde");
            System.out.println("3. Neues Konto erstellen");
            System.out.println("4. Exit");
            System.out.println("************************");
            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.next();

            switch (eingabe) {
                case "1" -> {
                    eBanking = true;
                    while (eBanking){
                    System.out.println("1: Saldo abfragen");
                    System.out.println("2: Einzahlen");
                    System.out.println("3: Abheben");
                    System.out.println("4: Konto Informationen");
                    System.out.println("5: Exit");
                    Scanner scan = new Scanner(System.in);
                    String test = scan.next();

                    switch (test) {
                        case "1" -> {
                            System.out.println("Ihr Saldo beträgt: " + Konto.getSaldo());
                        }
                        case "2" -> {
                            System.out.println("Wie viel möchten Sie einzahlen?");
                            double value = scan.nextDouble();
                            Konto.Einzahlung(value);
                            System.out.println("Ihr neues Saldo beträgt: " + Konto.getSaldo());
                        }
                        case "3" -> {
                            System.out.println("Wie viel möchten Sie abheben?");
                            double value = scan.nextDouble();
                            Konto.Abhebung(value);
                            System.out.println("Ihr neues Saldo beträgt: " + Konto.getSaldo());
                        }
                        case "4" -> {

                        }
                        case "5" -> {
                            eBanking = false;
                        }
                    }
                    }
                }
                case "2" -> {
                    Kunde.Kunde();
                    System.out.println("Wollen Sie noch was machen? y/n");
                    String entscheid = scanner.next();
                    if (entscheid.equals("n")) {
                        System.out.println("******* Auf Wiedersehen ********");
                        run = false;
                    }
                }
                case "3" -> {
                    //Konto test = new Konto();
                }
                case "4" -> {
                    System.out.println("******* Auf Wiedersehen ********");
                    run = false;
                }
            }
        }
    }
}
class main {
    public static void main (String[] args) {
        Bank.bank = new Bank();
    }
}
