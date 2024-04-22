package Modul2;

import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    public String nama;
    public String nim;
    public String jurusan;
    public static final String universitas = "Universitas Muhammadiyah Malang";

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static void tampilUniversitas() {
        System.out.println(universitas);
    }

    public String tampilDataMahasiswa() {
        return "Nama: " + nama + ", NIM: " + nim + ", Jurusan: " + jurusan;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}

class Main {
    private static final ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa();
                    break;
                case 2:
                    tampilkanDataMahasiswa();
                    break;
                case 3:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);
    }

    public static void tambahDataMahasiswa() {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        while (nim.length() != 15) {
            System.out.println("NIM yang di input harus 15 digit!!!");
            System.out.print("Masukkan NIM mahasiswa: ");
            nim = scanner.nextLine();
        }
        System.out.print("Masukkan jurusan mahasiswa: ");
        String jurusan = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
        daftarMahasiswa.add(mahasiswa);
        System.out.println("Data mahasiswa berhasil ditambahkan.\n");
    }

    public static void tampilkanDataMahasiswa() {
        System.out.println("Data Mahasiswa:");
        Mahasiswa.tampilUniversitas();
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println(mahasiswa.tampilDataMahasiswa());
        }
        System.out.println();
    }
}