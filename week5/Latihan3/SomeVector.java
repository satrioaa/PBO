package week5;

import java.util.Vector;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SomeVector {

    static Vector<String> mamalia = new Vector<>();
    static Vector<String> unggas = new Vector<>();
    static Vector<String> hewan = new Vector<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);

        int menu = 1;
        String name;
        do {
            System.out.print(
                    "\nMenu\n1. Tambah Mamalia\n2. Tampilkan Mamalia\n3. Tambah Unggas\n4. Tampilkan Unggas\n5. Tambah Hewan\n6. Tampilkan Semua Hewan\n7. Update Hewan\n8. Hapus Hewan\n9. Keluar\nPilih menu: ");
            menu = choice.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nama mamalia: ");
                    name = input.nextLine();
                    mamalia.add(name);
                    System.out.println("Mamalia " + name + " berhasil ditambahkan");
                    break;
                case 2:
                    System.out.println("Mamalia yang ada: ");
                    show(mamalia);
                    break;
                case 3:
                    System.out.print("Masukkan nama unggas: ");
                    name = input.nextLine();
                    unggas.add(name);
                    System.out.println("Unggas " + name + " berhasil ditambahkan");
                    break;
                case 4:
                    System.out.println("Unggas yang ada: ");
                    show(unggas);
                    break;
                case 5:
                    System.out.print("Masukkan nama hewan: ");
                    name = input.nextLine();
                    hewan.add(name);
                    System.out.println("Hewan " + name + " berhasil ditambahkan");
                    break;
                case 6:
                    reload();
                    System.out.println("Semua hewan yang ada: ");
                    show(hewan);
                    break;
                case 7:
                    reload();
                    System.out.print("Masukkan nama hewan yang ingin diupdate: ");
                    String existing = input.nextLine();
                    if (hewan.contains(existing)) {
                        System.out.print("Masukkan nama hewan baru: ");
                        name = input.nextLine();
                        update(existing, name);
                        System.out.println("Hewan " + existing + " berhasil diupdate ke " + name);
                    } else {
                        System.out.println("Hewan " + existing + " tidak ditemukan");
                    }
                    break;
                case 8:
                    reload();
                    System.out.print("Masukkan nama hewan yang ingin dihapus: ");
                    name = input.nextLine();
                    if (hewan.contains(name)) {
                        destroy(name);
                        System.out.println("Hewan " + name + " berhasil dihapus");
                    } else {
                        System.out.println("Hewan " + name + " tidak ditemukan");
                    }
                    break;
                default:
                    break;
            }
        } while (menu != 9);

        input.close();
        choice.close();
    }

    public static void show(Vector<String> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Data ke-" + (i + 1) + " : " + list.get(i));
            }
        } else {
            System.out.println("Tidak ada data");
        }
    }

    public static void reload() {
        hewan.addAll(mamalia);
        hewan.addAll(unggas);

        LinkedHashSet<String> hashSet = new LinkedHashSet<String>(hewan);
        hewan.clear();
        hewan.addAll(hashSet);
    }

    public static void update(String existing, String name) {
        if (mamalia.contains(existing)) {
            mamalia.set(mamalia.indexOf(existing), name);
        }

        if (unggas.contains(existing)) {
            unggas.set(unggas.indexOf(existing), name);
        }

        if (hewan.contains(existing)) {
            hewan.set(hewan.indexOf(existing), name);
        }
    }

    public static void destroy(String existing) {
        if (mamalia.contains(existing)) {
            mamalia.remove(existing);
        }

        if (unggas.contains(existing)) {
            unggas.remove(existing);
        }

        if (hewan.contains(existing)) {
            hewan.remove(existing);
        }
    }
}
