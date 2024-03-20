package MODUL3.Codelab;

public class BangunRuang {
    private String name;

    BangunRuang(String name){
        // Memperbaiki parameter method dengan menyesuaikan namanya
        this.name = name;
    }

    public void inputNilai(){
        // Menambahkan atribute name agar memberikan keterangan sedang menginput nilai apa (balok/kubus/tabung)
        System.out.println("\nInput nilai " + name);
    }

    public void luasPermukaan() {
        System.out.println("\nMenghitung luas permukaan " + name);
    }

    public void volume(){
        System.out.println("\nMenghitung volume " + name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        //MEMPERBAIKI NILAI BALIK NAMA DI METHOD getName
        return name;
    }
}