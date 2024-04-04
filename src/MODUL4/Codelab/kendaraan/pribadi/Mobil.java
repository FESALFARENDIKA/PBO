package MODUL4.Codelab.kendaraan.pribadi;

import MODUL4.Codelab.kendaraan.Kendaraan;

public class Mobil extends Kendaraan {
    @Override
    public void Start() {
        System.out.println("Mobil " + this.getName() + " " + this.getModel() + " " + "warna " + this.getWarna() + " dinyalakan");
    }

    @Override
    public void Stop() {
        System.out.println("Mobil " + this.getName() + " " + this.getModel() + " " + "warna " + this.getWarna() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Mobil berhenti");
    }
}
