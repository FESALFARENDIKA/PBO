package MODUL3.Codelab;

import java.util.Scanner;

public class Kubus extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double sisi;

    //Menambahkan method string kubus agar memberikan keterangan sedang menghitung kubus
    Kubus (String name){
        super(name);
    }

    @Override
    public void inputNilai(){
        //Memperbaiki nama method fungsi sout dan scanner
        super.inputNilai();
        System.out.print("Input sisi: ");
        this.sisi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan(){
        //Memperbaiki fungsi super dan sout
        double hasil = 6 * sisi * sisi;
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        //Memperbaiki variable hasil dengan memberikan tipe data di bagian kirinya
        double hasil = Math.pow(sisi, 3);
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}