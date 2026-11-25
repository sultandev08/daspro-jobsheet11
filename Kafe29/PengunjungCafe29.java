package Kafe29;

// Percobaan 4
public class PengunjungCafe29 {
    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Nomor Meja: " + nomorMeja);
        System.out.println("Daftar Nama Pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        String[] tamu = { "Ali", "Budi", "Citra" };
        daftarPengunjung(tamu);
    }
}

// Percobaan 4 pertanyaan 4
// public class CafeBelanja29 {

//     static int hitungTotalBelanja(int... harga) {
//         int total = 0;
//         for (int h : harga) {
//             total += h;
//         }
//         return total;
//     }

//     public static void main(String[] args) {
//         int total1 = hitungTotalBelanja(15000);
//         int total3 = hitungTotalBelanja(15000, 20000, 12000);
//         int total5 = hitungTotalBelanja(15000, 20000, 22000, 12000, 10000);

//         System.out.println("Total (1 argumen): Rp " + total1);
//         System.out.println("Total (3 argumen): Rp " + total3);
//         System.out.println("Total (5 argumen): Rp " + total5);
//     }
// }
