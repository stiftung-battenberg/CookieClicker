package banking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kunde {

    public static void Kunde() {

        ArrayList<String> vorname = new ArrayList<>();
        ArrayList<String> nachname = new ArrayList<>();
        ArrayList<String> wohnort = new ArrayList<>();
        int[] kundenID = new int[]{0, 1, 2, 3, 4, 5};

        for (int i = 0; i <= 5; i++) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vorname");
        String Test1 = scanner.next();

        System.out.println("Nachname");
        String Test2 = scanner.next();

        System.out.println("Wohnort");
        String Test3 = scanner.next();

        vorname.add(i,Test1);
        nachname.add(i,Test2);
        wohnort.add(i,Test3);

            System.out.println("Ihre Konto Informationen sind:");
            System.out.println("KundenID: " + kundenID[i]);
            System.out.println("Vorname: " + vorname.get(i));
            System.out.println("Nachname: " + nachname.get(i));
            System.out.println("Wohnort: " + wohnort.get(i));


            try {
                Files.writeString(Paths.get(kundenID[i]+"_"+vorname.get(i)+"_"+nachname.get(i)+".txt"), Arrays.toString(new int[]{kundenID[i]})
                +":" + vorname.get(i) + ":" + nachname.get(i) + ":" + wohnort.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Wollen Sie noch ein Konto erstellen? y/n");
            String Test4 = scanner.next();
            if (Test4.equals("n")){
                break;
            }
        }
    }

    public static void getKontoInfo() {

    }
}

