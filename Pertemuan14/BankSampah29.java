package Pertemuan14;
import java.util.Scanner;

public class BankSampah29 {

    static final double HARGA_PER_KG = 3000.0;

    public static double[] inputSetoran(Scanner sc, int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== DATA SETORAN NASABAH ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.printf("Nasabah ke-%d: %.2f kg%n", (i + 1), setoran[i]);
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    public static double hitungSaldo(double beratKg, double hargaPerKg) {
        return beratKg * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(sc, n);
        tampilSetoran(setoran);

        double totalBerat = totalSetoran(setoran);
        System.out.printf("%nTotal berat setoran seluruh nasabah: %.2f kg%n", totalBerat);

        System.out.println("\n=== SALDO SETIAP NASABAH (Rp3.000/kg) ===");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], HARGA_PER_KG);
            System.out.printf("Nasabah ke-%d: Rp%,.0f%n", (i + 1), saldo);
        }

        int idxTerbanyak = nasabahTerbanyak(setoran);
        System.out.printf("%nSetoran terbesar dimiliki oleh Nasabah ke-%d (%.2f kg)%n",
                (idxTerbanyak + 1), setoran[idxTerbanyak]);

        sc.close();
    }
}