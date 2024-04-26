package MODUL4.Tugas.data;
import MODUL4.Tugas.com.main.Main;
import MODUL4.Tugas.books.*;
//import books.TextBook;
//import books.Book;
//import books.HistoryBook;
//import books.StoryBook;
import java.util.Scanner;

public class User {

    public void choiceBook() {
        //public void displayBooks(){
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Stok");
        System.out.println("\n=========================================================================================================================");

        for (Main.BookList i : Main.arr_bookList) {
            System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku, i.stokbuku);
        }

        System.out.print("=========================================================================================================================");
        //MEMASUKKAN METHOD PINJAM BUKU DI DALAM CHOICEBOOK
        Student.borrowedBooks();
    }

    public void inputBook() {
        Admin adminObj = new Admin();
        Scanner inputuser = new Scanner(System.in);

        System.out.println("\n==== Tambah Buku ====");
        System.out.println("Pilih kategori buku :\n1. History Book\n2. Story Book\n3. Text Book");
        System.out.print("Pilih 1-3: ");
        String pilihan = inputuser.nextLine();

        String idBuku = adminObj.generateId();

        System.out.print("Masukkan judul Buku: ");
        String judulBuku = inputuser.nextLine();

        System.out.print("Masukkan Nama Penulis: ");
        String penulisBuku = inputuser.nextLine();

        System.out.print("Masukkan Jumlah Stok Buku: ");
        int stokBuku = inputuser.nextInt();

        Book[] books = new Book[4];
        books[0] = new HistoryBook(idBuku, judulBuku, penulisBuku, stokBuku);
        books[1] = new StoryBook(idBuku, judulBuku, penulisBuku, stokBuku);
        books[2] = new TextBook(idBuku, judulBuku, penulisBuku, stokBuku);
        books[3] = new Book(idBuku, judulBuku, penulisBuku, stokBuku);

        books[3].setBookId(idBuku);
        books[3].setTitle(judulBuku);
        books[3].setAuthor(penulisBuku);
        books[3].setStock(stokBuku);

//        HistoryBook historyBookObj = new HistoryBook(idBuku, judulBuku, penulisBuku, stokBuku);
//        StoryBook storyBookObj     = new StoryBook(idBuku, judulBuku, penulisBuku, stokBuku);
//        TextBook textBookObj       = new TextBook(idBuku, judulBuku, penulisBuku, stokBuku);
//        Book bookObj               = new Book(idBuku, judulBuku, penulisBuku, stokBuku);
//
//        bookObj.setBookId(idBuku);
//        bookObj.setTitle(judulBuku);
//        bookObj.setAuthor(penulisBuku);
//        bookObj.setStock(stokBuku);

        switch (pilihan){
            case "1":
                books[0].setCategory("History Book");
                Main.arr_bookList.add(new Main.BookList(books[3].getBookId(), books[3].getTitle(), books[3].getAuthor(), books[0].getCategory(), books[3].getStock()));
                break;
            case "2":
                books[1].setCategory("Story Book");
                Main.arr_bookList.add(new Main.BookList(books[3].getBookId(), books[3].getTitle(), books[3].getAuthor(), books[1].getCategory(), books[3].getStock()));
                break;
            case "3":
                books[2].setCategory("Text Book");
                Main.arr_bookList.add(new Main.BookList(books[3].getBookId(), books[3].getTitle(), books[3].getAuthor(), books[2].getCategory(), books[3].getStock()));
                break;
        }
        System.out.println("==== Buku berhasil ditambahkan ====");
    }
}
