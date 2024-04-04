package MODUL4.Codelab.kendaraan.khusus;

import MODUL4.Codelab.kendaraan.Kendaraan;
import MODUL4.Codelab.kendaraan.util.Flyable;

public class Pesawat extends Kendaraan implements Flyable {
    @Override
    public void Start() {
        System.out.println("Mennyalakan pesawat " + this.getName());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getName());
    }

    @Override
    public void Brake() {
        System.out.println("Pesawat berhenti");
    }

    @Override
    public void fly() {
        System.out.println("Pesawat " + this.getName() + " lepas landas");
    }
}
