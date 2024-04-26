package MODUL4.Tugas.com.main;

import MODUL4.Tugas.data.*;
//import data.Admin;
//import data.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }


    //===============================================================================================================//
    public static ArrayList<BookList> arr_bookList = new ArrayList<>();

    //=========================== =====================================
    public static Scanner inputpilihan = new Scanner(System.in);
    static Scanner inputuser = new Scanner(System.in);
    //================================================================
    public static String NIM;
//================================================================

    public static class BookList{
        public String idbuku;
        public String judulbuku;
        public String penulisbuku;
        public String kategoriBuku;
        public int stokbuku;

        public void Booklist(String idbuku, String judulbuku, String penulisbuku){
            this.idbuku          = idbuku;
            this.judulbuku       = judulbuku;
            this.penulisbuku     = penulisbuku;
        }


        public BookList(String idbuku, String judulbuku, String penulisbuku, String kategoriBuku, int stokbuku){
            this.idbuku          = idbuku;
            this.judulbuku       = judulbuku;
            this.penulisbuku     = penulisbuku;
            this.kategoriBuku    = kategoriBuku;
            this.stokbuku        = stokbuku;
        }
    }

    //================================================================
    public static void menu(){
        Admin adminObj = new Admin();
        Student studentObj = new Student();
        int menuloop = 0;

        do{
            System.out.println("\n==== Library System ====");
            System.out.print("\n1. Login as student\n2. Login as admin\n3. Exit\n");
            System.out.print("Choose option (1-3): ");

            int pilihan = inputpilihan.nextInt();
            switch (pilihan) {
                case 1:
                    Student.loginstudent();
                    studentObj.menu();
                    break;

                case 2:
                    adminObj.validasiLogin();
                    adminObj.menu();

                    break;

                case 3:
                    menuloop = 1;
                    break;
            }
        }while(menuloop == 0);
    }

    public static void inputNIM(){
        System.out.println("Masukkan NIM: ");
        NIM = inputuser.nextLine();
    }

    public static void menuadmin() {
        Admin adminObject = new Admin();
        System.out.println("\n==== Admin Menu ====");
        System.out.println("\n1. Tambah Mahasiswa\n2. Daftar Mahasiswa\n3. Tambah Buku\n4. Logout");
        System.out.print("Choose option (1-4): ");

        int pilihan = inputpilihan.nextInt();
        switch (pilihan) {
            case 1:
                Admin.addstudent();
                menuadmin();
                break;
            case 2:
                Admin.displaystudent();
                menuadmin();
                break;
            case 3:
                adminObject.inputBook();
                menuadmin();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.print("Pilih 1-4");
                menuadmin();
        }


    }

    public static void menustudent(){
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
                //Student.borrowedBooks(); METHOD DIMASUKKAN KEDALAM CHOICEBOOK SESUAI PERINTAH TUGAS M4
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
}
