package MODUL2;//
import java.util.Scanner;

class Main {

    static int[] stok_buku = new int[]{4, 0, 2};
    static String[] author = new String[]{"author", "author", "author"};
    static String[] id_buku = new String[]{"388c-e681-9152", "ed90-be30-5cdb", "d95e-0c4a-9523"};
    static String[] judul = new String[]{"title", "title", "title"};
    static String[] category = new String[]{"Sejarah", "Sejarah", "Sejarah"};

    Main() {
    }

    void menuUtama() {
        System.out.println("\n==== Library System ====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Pilihan Anda: ");
    }

    void menuStudent() {
        System.out.println("\n==== Student Menu ====");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void menuAdmin() {
        System.out.println("\n==== Admin Menu ====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void displayBook() {
        System.out.println("===========================================================================================================================================");
        System.out.println("|| No. || Id Buku\t\t\t || Nama Buku\t\t\t || Author\t\t || Category\t\t || Stock\t || ");

        for(int i = 0; i < 3; ++i) {
            System.out.printf("|| %d   || %s\t\t || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i, id_buku[i], judul[i], author[i], category[i], stok_buku[i]);
        }

        System.out.println("===========================================================================================================================================");
    }

    public static void main(String[] args) {
        Student student = new Student();
        Admin admin = new Admin();
        Main main = new Main();
        mainMenu:
        while (true) {
            main.menuUtama();
            Scanner scanInt = new Scanner(System.in);
            int pilih = scanInt.nextInt();
            if (pilih   == 1) {
                if (student.checkStudent() == 0) {
                    continue mainMenu;
                }
                int j = 0;
                while (true) {
                    main.menuStudent();
                    pilih = scanInt.nextInt();
                    if (pilih == 1){
                        student.bukuTerpinjam();
                    } else if (pilih == 2){
                        main.displayBook();
                        student.pinjamBuku(j);
                        j++;
                    } else {
                        break;
                    }
                }
            } else if (pilih == 2) {
                if (admin.checkAdmin() == 0) {
                    continue mainMenu;
                }
                while (true) {
                    main.menuAdmin();
                    pilih = scanInt.nextInt();
                    int i = 0;
                    if (pilih == 1) {
                        admin.addStudent(i);
                        ++i;
                    } else if (pilih == 2) {
                        admin.dispayStudent(i);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}
