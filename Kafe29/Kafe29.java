package Kafe29;
// Percobaan 1
// public class Kafe29 {
//     public static void Menu() {
//         System.out.println("===== MENU RESTO KAFE =====");
//         System.out.println("1. Kopi Hitam - Rp 15.000");
//         System.out.println("2. Cappucino - Rp 20.000");
//         System.out.println("3. Latte - Rp 22.000");
//         System.out.println("4. Teh Tarik - Rp 12.000");
//         System.out.println("5. Roti Bakar - Rp 10.000");
//         System.out.println("6. Mie Goreng - Rp 18.000");
//         System.out.println("==========================");
//         System.out.println("Silahkan pilih menu yang Anda inginkan. ");
//     }

//     public static void main(String[] args) {
//         Menu();
//     }
// }


// Percobaan 2 & 3
import java.util.Scanner;
public class Kafe29 {
    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15.000");
        System.out.println("2. Cappucino - Rp 20.000");
        System.out.println("3. Latte - Rp 22.000");
        System.out.println("4. Teh Tarik - Rp 12.000");
        System.out.println("5. Roti Bakar - Rp 10.000");
        System.out.println("6. Mie Goreng - Rp 18.000");
        System.out.println("==========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan. ");
    }

    public static int hitungTotalHargaNoAbsen(int pilihanMenu, int banyakItem){
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu("Andi", true);

        System.out.println("\nMasukkan nomor menu yang ingin Anda Pesan");
        int pilihanMenu = sc.nextInt();
        System.out.println("Masukkan jumlah item yang ingin dipesan: ");
        int banyakItem = sc.nextInt();

        int totalBayar = hitungTotalHargaNoAbsen(pilihanMenu, banyakItem);

        System.out.println("Total harga untuk pesanan Anda: Rp " + totalBayar   ); 
    }
}

