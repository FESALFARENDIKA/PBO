package MODUL4.Codelab.kendaraan.khusus;

import MODUL4.Codelab.kendaraan.Kendaraan;
import MODUL4.Codelab.kendaraan.util.ShootAble;
//perbaikan penamaan class
public class Tank extends Kendaraan implements ShootAble{
    @Override
    public void Start() {
        System.out.println("Menyalakan tank " + this.getName() + " " + this.getModel());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan tank " + this.getName() + " " + this.getModel());
    }

    @Override
    public void Brake() {
        System.out.println("Tank berhenti");
    }

    @Override
    public void Shoot(String vehicle) {
        System.out.println("Tank menembak " + vehicle);
    }
}
