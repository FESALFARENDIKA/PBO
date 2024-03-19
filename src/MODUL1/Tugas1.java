package MODUL1;

import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
        int login;

        String nim = "202303111037337";
        String username = "adminuser";
        String password = "adminpass";
        Scanner objInput = new Scanner(System.in);

        System.out.print("=== Library ===\n1. Student\n2. Admin\n3. Exit\nMasukkan Pilihan : ");
        login = objInput.nextInt();
        if (login == 1){
            String Inim;
            System.out.print("Masukkan NIM : ");
            Inim = objInput.next();
            if (Inim.length() == 15 && Inim.equals(nim)){
                System.out.print("Berhasil Login");
            } else {
                System.out.print("User tidak nemu1");
            }
        }
        if (login == 2) {
            String Iuser, Ipass;
            System.out.print("Masukkan user : ");
            Iuser = objInput.next();
            System.out.print("Masukkan pass : ");
            Ipass = objInput.next();
            if (Iuser.equals(username) && Ipass.equals(password)) {
                System.out.print("Berhasil login sebagai admin");
                } else {
                    System.out.print("User admin tidak nemu");
                }
        }
        if (login == 3){
            System.out.print("Bayy");
        }
    }
}