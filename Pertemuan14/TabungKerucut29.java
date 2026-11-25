package Pertemuan14;
import java.util.Scanner;

public class TabungKerucut29 {

    public static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    public static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    public static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + 2 * Math.PI * r * t;
    }

    public static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU BANGUN RUANG (TABUNG & KERUCUT) ===");
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            double r, t;
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari (r): ");
                    r = sc.nextDouble();
                    System.out.printf("Luas Lingkaran: %.2f%n", luasLingkaran(r));
                    break;
                case 2:
                    System.out.print("Masukkan jari-jari (r): ");
                    r = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    t = sc.nextDouble();
                    System.out.printf("Volume Tabung: %.2f%n", volumeTabung(r, t));
                    break;
                case 3:
                    System.out.print("Masukkan jari-jari (r): ");
                    r = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    t = sc.nextDouble();
                    System.out.printf("Luas Permukaan Tabung: %.2f%n", luasPermukaanTabung(r, t));
                    break;
                case 4:
                    System.out.print("Masukkan jari-jari (r): ");
                    r = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    t = sc.nextDouble();
                    System.out.printf("Volume Kerucut: %.2f%n", volumeKerucut(r, t));
                    break;
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}