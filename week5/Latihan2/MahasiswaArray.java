package week5;

import java.util.ArrayList;
import java.util.Scanner;

public class MahasiswaArray {

    static int n;

    public static void main(String[] args) {
        System.out.print("Masukkan Jumlah Data: ");
        Scanner inp = new Scanner(System.in);
        n = inp.nextInt();

        ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan NIM: ");
            String nim = inp.next();
            System.out.print("Masukkan Nama: ");
            String nama = inp.next();
            System.out.print("Masukkan IPK: ");
            double ipk = inp.nextDouble();
            mahasiswa.add(new Mahasiswa(nim, nama, ipk));
        }

        inp.close();

        cetakMahasiswa(mahasiswa);
    }

    public static void cetakMahasiswa(ArrayList<Mahasiswa> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Data ke-" + (i + 1));
            System.out.println("NIM: " + list.get(i).nim);
            System.out.println("Nama: " + list.get(i).nama);
            System.out.println("IPK: " + list.get(i).ipk);
        }
    }

}