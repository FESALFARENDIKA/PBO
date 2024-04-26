package MODUL4.Tugas.data;
import MODUL4.Tugas.com.main.Main;
import MODUL4.Tugas.books.Book;
import util.iMenu;
import java.util.ArrayList;
import java.util.Scanner;

import static MODUL4.Tugas.com.main.Main.inputpilihan;
import static MODUL4.Tugas.com.main.Main.menustudent;

public class Student extends User implements iMenu {

    static  Scanner inputuser = new Scanner(System.in);
    static  String idBukuYangDipinjam;
    static int inputwaktuPinjaman;

    static ArrayList<BorrowedBook>arr_borrowedBook = new ArrayList<>();
    static ArrayList<UserStudent> arr_userStudent = new ArrayList<>();

    @Override
    public void menu() {
        Student studentObject = new Student();
        Student.displayInfo();
        System.out.println("\n==== Student Menu ====");
        System.out.print("\n1. Buku Terpinjam\n2. Pinjam buku\n3. Kembalikan buku\n4. Logout");
        System.out.println("\n Choose option (1-4): ");

        int pilihan = inputpilihan.nextInt();
        switch (pilihan){
            case 1:
                Student.showBorrowedBooks();
                menustudent();
                break;
            case 2:
                studentObject.choiceBook();
                Student.borrowedBooks();
                menustudent();
                break;
            case 3:
                Student.showBorrowedBooks();
                Student.returnBooks();
                menustudent();
                break;
            case 4:
                Student.logout();
                break;
            default:
                System.out.print("Pilih 1-4");
                menustudent();
        }

    }

    static class BorrowedBook {
        String id;
        int waktupinjaman;

        public BorrowedBook(String id, int waktupinjaman) {
            this.id = id;
            this.waktupinjaman = waktupinjaman;
        }
    }
    static class UserStudent{
        String nama,nim,fakultas,prodi;
        public UserStudent(String nama, String nim, String fakultas, String prodi){
            this.nama = nama;
            this.nim = nim;
            this.fakultas = fakultas;
            this.prodi = prodi;
        }
    }
    public static void displayInfo() {
        for (UserStudent i : arr_userStudent) {
            if (Main.NIM.equals(i.nim)) {
                System.out.println("\n");
                System.out.print("> Nama: " + i.nama);
                System.out.println("\n> NIM : " + i.nim);
                break;
            }
        }
    }
    public static void showBorrowedBooks(){

        System.out.println("=======================================  Informasi Buku Yang Dipinjam  ==================================================");
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Durasi");
        System.out.println("\n=========================================================================================================================");

        for (BorrowedBook a : arr_borrowedBook) {
            for (Main.BookList i : Main.arr_bookList) {
                if (i.idbuku.equals(a.id)) {
                    System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-5s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku, a.waktupinjaman);
                }

            }

        }

        System.out.print("=========================================================================================================================");
    }

    @Override
    public void choiceBook(){
        super.choiceBook();
    }
    //public void displayBooks(){     super.displayBooks();}
    public static void logout(){
        Main.menu();
    }

    public static void returnBooks(){
        boolean validasiReturnBooks = false;
        System.out.println("\n● Inputkan ID buku yang ingin dikembalikan.");
        System.out.print("> ID : ");
        idBukuYangDipinjam = inputuser.nextLine();
        for (int i = 0; i < arr_borrowedBook.size(); i++ ) {
            if (arr_borrowedBook.get(i).id.equals(idBukuYangDipinjam)) {
                for (Main.BookList a : Main.arr_bookList) {
                    if (a.idbuku.equals(idBukuYangDipinjam)) {
                        a.stokbuku++;
                        arr_borrowedBook.remove(i);
                        validasiReturnBooks = true;
                    }
                }
            }
        }
        if(validasiReturnBooks){
            System.out.print("Pengembalian Berhasil");
        }else{
            System.out.print("Buku tidak ditemukan.");
        }
    }

    public static void borrowedBooks(){
        int loop;
        Book bookObj = new Book(null,null,null,0);
        System.out.println("\n>> Input ID buku yang ingin dipinjam");
        System.out.print(">  ID: ");
        idBukuYangDipinjam = inputuser.nextLine();
        for (Main.BookList i : Main.arr_bookList) {
            if (i.idbuku.equals(idBukuYangDipinjam)) {
                if (i.stokbuku > 0) {
                    i.stokbuku--;
                    do{
                        System.out.println("\n>> Berapa lama buku ingin dipinjam? (maksimal 14 hari)");
                        System.out.print(">  Berapa hari ? : ");
                        inputwaktuPinjaman = inputuser.nextInt();
                        inputuser.nextLine();

                        if(inputwaktuPinjaman > 14){
                            System.out.print("Maksimal hanya 14 Hari!");
                            loop = 0;
                        }else{
                            loop = 1;
                        }
                    }while(loop == 0);
                    bookObj.setDuration(inputwaktuPinjaman);
                    arr_borrowedBook.add(new BorrowedBook(idBukuYangDipinjam, bookObj.getDuration()));
                    System.out.print("==== Buku berhasil dipinjam! ====");
                    break;
                }else if (i.stokbuku == 0){
                    System.out.print("Stok buku habis!");
                    break;
                }

            }
        }


    }

    public static void  loginstudent(){
        boolean validasi = false;
        int loop = 0;
        do{
            Main.inputNIM();
            if(Main.NIM.length() != 15) {
                System.out.println("NIM harus 15 digit\n");
                continue;

            }
            for(UserStudent i : arr_userStudent){
                if(i.nim.equals(Main.NIM)){
                    validasi = true;
                    break;
                }
            }
            if(validasi){
                System.out.println("==== Login berhasil ====\n");
                loop = 1;
            }else{
                System.out.println("==== NIM tidak terdaftar ===");
                Main.inputNIM();
            }

        } while(loop == 0);

    }

}
