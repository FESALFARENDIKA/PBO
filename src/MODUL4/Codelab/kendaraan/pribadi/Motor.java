package MODUL4.Codelab.kendaraan.pribadi;

import MODUL4.Codelab.kendaraan.Kendaraan;

public class Motor extends Kendaraan {
    @Override
    public void Start() {
        System.out.println("Motor " + this.getName() + " " + this.getModel() + " " + this.getTahun() + " dinyalakan");
    }


    @Override
    public void Stop() {
        System.out.println("Motor " + this.getName() + " " + this.getModel() + " " + this.getTahun() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Motor berhenti");
    }
}
