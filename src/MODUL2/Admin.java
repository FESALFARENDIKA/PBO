package MODUL2;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.util.Scanner;

class Admin {
    Student student = new Student();
    static String adminUsername = "auser";
    static String adminPassword = "apass";

    int checkAdmin(){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String user = scanString.nextLine();
        System.out.print("Enter your password (admin): ");
        String pass = scanString.nextLine();
        if (user.equals(adminUsername) && pass.equals(adminPassword)) {
            System.out.println("Sukses login sebagai admin\n");
            return 1;
        }
        else {
            System.out.println("Admin tidak ditemukan\n");
            return 0;
        }
    }

    void addStudent(int i){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        Student.nama[i] = scanString.nextLine();

        System.out.print("Masukkan fakultas mahasiswa: ");
        Student.fakultas[i] = scanString.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        Student.nim[i] = scanString.nextLine();
        while(true){
            if (String.valueOf(Student.nim[i]).length() != 15 ) {
                System.out.print("Nim Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM mahasiswa: ");
                Student.nim[i] = scanString.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Masukkan jurusan mahasiswa: ");
        Student.prodi[i] = scanString.nextLine();

        System.out.print("Data Mahasiswa berhasil ditambahkan.\n");
    }

    void dispayStudent(int i){
        System.out.println("Data mahasiswa ke " + (i+1));
        System.out.println("Nama: " + Student.nama[i]);
        System.out.println("Fakultas: " + Student.fakultas[i]);
        System.out.println("nim: " + Student.nim[i]);
        System.out.println("prodi: " + Student.prodi[i]);
    }

}
