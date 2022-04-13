package week6;

import mahasiswa.*;
import week6.mahasiswa.Mahasiswa;

public class MahasiswaAksi {
    public static void main(String[] args) {
        // a. Membuat objek dari class Mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa("A11.2020.12739", "Satrio Arda Alfiansyah", 3.4, 23, "2003-01-24");
        // b. Mencari nama program studi berdasarkan nim
        System.out.println("Nama Program Studi : " + mahasiswa.getProgdi());
        // c. Mencari status berdasarkan ipk
        System.out.println("Status : " + mahasiswa.ipkStatus());
        // d. Mencari tahun angkatan berdasarkan nim
        System.out.println("Tahun Angkatan : " + mahasiswa.getTahun());
        // e. Mencari tagihan berdasarkan sks
        System.out.println("Tagihan : " + mahasiswa.getTagihanSks());
        // f. Mencari berapa semester mahasiswa sudah kuliah
        System.out.println("Semester : " + mahasiswa.getMhsSemester());
        // g. Mencari umur mahasiswa
        System.out.println("Umur : " + mahasiswa.getUmur());
    }
}
