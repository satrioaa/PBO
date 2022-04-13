package week5;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Prototype {
    int[] data;

    void setArray(int[] data) {
        this.data = data;
    }

    void cetakArray() {
        String print = IntStream.of(data)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Isi array: " + print);
    }

    void sumOfArray() {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println("Jumlah Angka = " + sum);
    }

}

public class ArrayAksi {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Data: ");
        int total = data.nextInt();
        int[] array = new int[total];
        for (int i = 0; i < total; i++) {
            System.out.print("Masukkan Angka ke-" + (i + 1) + ": ");
            array[i] = data.nextInt();
        }
        data.close();
        Prototype prototype = new Prototype();
        prototype.setArray(array);
        prototype.cetakArray();
        prototype.sumOfArray();
    }
}
