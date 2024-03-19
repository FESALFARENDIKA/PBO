package MODUL1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Codelab1 {
    public static void main(String[] args) {
        String nama;
        char jk;
        String tlahir;
        Scanner objInput = new Scanner(System.in);

        System.out.print("Nama : ");
        nama = objInput.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        jk = objInput.next().charAt(0);
        System.out.print("Tanggal Lahir (yyyy-MM-dd) : ");
        tlahir = objInput.next();
// Mengubah format lahir dan menghitungnya dengan fungsi Period between
        LocalDate tlahir2 = LocalDate.parse(tlahir, DateTimeFormatter.ISO_DATE);
        LocalDate waktusekarang = LocalDate.now();
        Period rentang = Period.between(tlahir2,waktusekarang);
        int tahun = rentang.getYears();
        int bulan = rentang.getMonths();
// Membuat variable jk yang semula char menjadi string untuk dapat dioutputkan secara lengkap
        String jk2 = (jk == 'L' || jk == 'P') ? "Laki-laki" : "Perempuan";
// Membuat fungsi output
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jk2);
        System.out.println("Umur anda: " + tahun + " tahun " + bulan + " bulan  ");



    }
}