import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Biudzetas biudzetas = new Biudzetas();

        Scanner sc = new Scanner(System.in);

        boolean testiPrograma = true;

        while (testiPrograma) {
            pagrindinisMeniu();
            int pasirinkimas = skaiciausPasirinkimas(sc);

            switch (pasirinkimas) {
                case 1 -> biudzetas.pridetiPajamuIrasa(naujasPajamuIrasas(sc));
                case 2 -> biudzetas.pridetiIslaiduIrasa(naujasIslaiduIrasas(sc));
                case 3 -> spausdintiPajamuIrasus(biudzetas.getPajamos());
                case 4 -> spausdintiIslaiduIrasus(biudzetas.getIslaidos());
                case 5 -> testiPrograma = false;
                case 6 -> spausdintiBalansa(biudzetas);
                case 7 -> istrintiPajamuIrasa(sc, biudzetas);
                case 8 -> istrintiIslaiduIrasa(sc, biudzetas);
            }
        }
        sc.close();
    }

    private static void pagrindinisMeniu() {
        System.out.println(
                """
                            [1] - naujas pajamu irasas
                            [2] - naujas islaidu irasas
                            [3] - spausdinti pajamu irasus
                            [4] - spausdinti islaidu irasus
                            [5] - uzdaryti programa
                            [6] - patikrinti balansa
                            [7] - istrinti pajamu irasa
                            [8] - istrinti islaidu irasa
                        """);
    }

    private static PajamuIrasas naujasPajamuIrasas(Scanner scanner) {
        double suma = sumosIvedimas(scanner);
        PajamuKategorija kategorija = pajamuKaregorijosPasirinkimas(scanner);
        String papildomaInfo = papildomosInformacijosIvedimas(scanner);

        PajamuIrasas pajamuIrasas = new PajamuIrasas(suma, LocalDate.now(), papildomaInfo, kategorija);
        return pajamuIrasas;
    }

    private static IslaiduIrasas naujasIslaiduIrasas(Scanner scanner) {
        double suma = sumosIvedimas(scanner);
        String papildomaInfo = papildomosInformacijosIvedimas(scanner);
        IslaiduKategorija islaiduKategorija = islaiduKategorijosPasirinkimas(scanner);

        IslaiduIrasas islaiduIrasas = new IslaiduIrasas(suma, LocalDate.now(), papildomaInfo, islaiduKategorija);
        return islaiduIrasas;
    }

    private static double sumosIvedimas(Scanner scanner) {
        System.out.println("Suma: ");
        String ivestiDuomenys = scanner.nextLine();
        return Integer.parseInt(ivestiDuomenys);
    }

    private static PajamuKategorija pajamuKaregorijosPasirinkimas(Scanner scanner) {
        System.out.println("Kategorija: ");
        for (PajamuKategorija pk : PajamuKategorija.values()) {
            System.out.println(pk);
        }
        String ivestiDuomenys = scanner.nextLine();
        int skaicius = Integer.parseInt(ivestiDuomenys);
        return PajamuKategorija.kategorijaPagalNumeri(skaicius);
    }

    private static IslaiduKategorija islaiduKategorijosPasirinkimas(Scanner scanner) {
        System.out.println("Kategorija: ");
        for (IslaiduKategorija ik : IslaiduKategorija.values()) {
            System.out.println(ik);
        }
        String ivestiDomenys = scanner.nextLine();
        int skaicius = Integer.parseInt(ivestiDomenys);
        return IslaiduKategorija.kategorijaPagalNumeri(skaicius);
    }


    private static String papildomosInformacijosIvedimas(Scanner scanner) {
        System.out.println("papildoma informacija: ");
        return scanner.nextLine();
    }

    private static int skaiciausPasirinkimas(Scanner scanner) {
        String ivestiDuomenys = scanner.nextLine();
        return Integer.parseInt(ivestiDuomenys);
    }

    private static void spausdintiIslaiduIrasus(ArrayList<IslaiduIrasas> irasai) {
        System.out.println("----------------------------");
        for (IslaiduIrasas irasas : irasai) {
            String spausdintiIslaiduIrasus = String.format("Islaidos: %.2f, Gavimo data: %s, Papildoma info: %s, Kategorija: %s",
                    irasas.getSuma(), irasas.getData(), irasas.getPapildomaInfo(), irasas.getKategorija());
            System.out.println(spausdintiIslaiduIrasus);
        }
        System.out.println("----------------------------");
    }

    private static void spausdintiPajamuIrasus(ArrayList<PajamuIrasas> irasai) {
        System.out.println("----------------------------");
        for (PajamuIrasas irasas : irasai) {
            String spausdintiPajamuIrasus = String.format("Pajamos: %.2f, Gavimo data: %s, Papildoma info: %s, Kategorija: %s",
                    irasas.getSuma(), irasas.getData(), irasas.getPapildomaInfo(), irasas.getKategorija());
            System.out.println(spausdintiPajamuIrasus);
        }
        System.out.println("----------------------------");
    }

    private static void spausdintiBalansa(Biudzetas biudzetas) {
        double balance = biudzetas.balansas();
        System.out.println("---------------------");
        System.out.println("Balansas: " + balance);
        System.out.println("---------------------");
    }

    private static void istrintiPajamuIrasa(Scanner scanner, Biudzetas biudzetas) {
        System.out.println("Pasirinkite pajamu irasa, kuri norite istrinti");
            int indeksas = skaiciausPasirinkimas(scanner);
            biudzetas.istrintiPajamuIrasa(indeksas);
        }

    private static void istrintiIslaiduIrasa(Scanner scanner, Biudzetas biudzetas) {
        System.out.println("Pasirinkite islaidu irasa, kuri norite istrinti");
        int indeksas = skaiciausPasirinkimas(scanner);
        biudzetas.istrintiIslaiduIrasa(indeksas);
    }
}
