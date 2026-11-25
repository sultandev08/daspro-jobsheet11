package Pertemuan14;
import java.util.Scanner;

public class RekapLaundryDinamis29 {

    public static void inputLayanan(Scanner sc, String[] namaLayanan, int[] hargaPerKg) {
        sc.nextLine(); 
        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.print("Masukkan nama layanan ke-" + (i + 1) + ": ");
            namaLayanan[i] = sc.nextLine();
            System.out.print("Masukkan harga per kg untuk " + namaLayanan[i] + ": ");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void inputDataCucian(Scanner sc, int[][] data, String[] namaLayanan, int jumlahHari) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Input berat cucian untuk layanan: " + namaLayanan[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("  Hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilTabel(int[][] data, String[] namaLayanan, int[] hargaPerKg, int jumlahHari) {
        System.out.println("\n=== REKAP BERAT CUCIAN (KG) ===");
        System.out.printf("%-18s %-12s", "Layanan", "Harga/kg");
        for (int j = 0; j < jumlahHari; j++) {
            System.out.printf(" %-10s", "Hari ke-" + (j + 1));
        }
        System.out.println();

        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.printf("%-18s Rp%-10d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf(" %-10d", data[i][j]);
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

    public static void tampilPendapatan(int[][] data, String[] namaLayanan, int[] hargaPerKg, int jumlahHari) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN ===");
        long totalPendapatan = 0;
        for (int i = 0; i < namaLayanan.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            long pendapatan = (long) totalKg * hargaPerKg[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-18s: %3d kg x Rp%,d = Rp%,d%n",
                    namaLayanan[i], totalKg, hargaPerKg[i], pendapatan);
        }
        System.out.printf("Total pendapatan selama %d hari: Rp%,d%n", jumlahHari, totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = sc.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = sc.nextInt();

        String[] namaLayanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        int[][] data = new int[jumlahLayanan][jumlahHari];

        inputLayanan(sc, namaLayanan, hargaPerKg);
        inputDataCucian(sc, data, namaLayanan, jumlahHari);

        tampilTabel(data, namaLayanan, hargaPerKg, jumlahHari);
        tampilLayananTertinggi(data, namaLayanan);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: Hari ke-" + (idxSibuk + 1) + " (indeks ke-" + idxSibuk + ")");

        tampilPendapatan(data, namaLayanan, hargaPerKg, jumlahHari);

        sc.close();
    }
}