package Pertemuan14;
import java.util.Scanner;

public class RekapLaundry29 {

    static final String[] HARI = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    public static void inputDataCucian(Scanner sc, int[][] data, String[] namaLayanan) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Input berat cucian untuk layanan: " + namaLayanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  " + HARI[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilTabel(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        System.out.println("\n=== REKAP BERAT CUCIAN (KG) ===");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (String h : HARI) {
            System.out.printf(" %-8s", h);
        }
        System.out.println();

        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.printf("%-15s Rp%-10d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf(" %-8d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    public static void tampilLayananTertinggi(int[][] data, String[] namaLayanan) {
        int idxMax = 0;
        int maxBerat = totalPerLayanan(data, 0);

        for (int i = 1; i < namaLayanan.length; i++) {
            int total = totalPerLayanan(data, i);
            if (total > maxBerat) {
                maxBerat = total;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan total berat tertinggi: " + namaLayanan[idxMax] + " (" + maxBerat + " kg)");
    }

    public static int hariTersibuk(int[][] data) {
        int jumlahHari = data[0].length;
        int idxHariMax = 0;
        int maxBeratHari = 0;

        for (int i = 0; i < data.length; i++) {
            maxBeratHari += data[i][0];
        }

        for (int j = 1; j < jumlahHari; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > maxBeratHari) {
                maxBeratHari = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    public static void tampilPendapatan(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN ===");
        long totalPendapatan = 0;
        for (int i = 0; i < namaLayanan.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            long pendapatan = (long) totalKg * hargaPerKg[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-15s: %3d kg x Rp%,d = Rp%,d%n",
                    namaLayanan[i], totalKg, hargaPerKg[i], pendapatan);
        }
        System.out.printf("Total pendapatan selama 6 hari: Rp%,d%n", totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] namaLayanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] hargaPerKg = {6000, 8000, 5000, 12000};
        int[][] data = {
            {12, 15, 10, 18, 20, 25},
            {20, 18, 22, 15, 30, 35},
            {8, 5, 10, 7, 6, 12},
            {3, 6, 2, 5, 8, 10}
        };

        System.out.print("Apakah ingin menginput ulang data berat cucian? (y/n): ");
        String jawab = sc.next();
        if (jawab.equalsIgnoreCase("y")) {
            inputDataCucian(sc, data, namaLayanan);
        }

        tampilTabel(data, namaLayanan, hargaPerKg);
        tampilLayananTertinggi(data, namaLayanan);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + HARI[idxSibuk] + " (indeks ke-" + idxSibuk + ")");

        tampilPendapatan(data, namaLayanan, hargaPerKg);

        sc.close();
    }
}