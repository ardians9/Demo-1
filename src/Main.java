import java.util.Scanner;

class Main {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "ardi313";
    private static final String[] MAHASISWA_NIM = {"202310370311313"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("==== Welcome To UMM Cafe! ====\n");

        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("Silakan pilih jenis login:");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    isLoggedIn = mahasiswaLogin(scanner);
                    break;
                case 2:
                    isLoggedIn = adminLogin(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih telah mengakses UMM Cafe.");
                    return;
                default:
                    System.out.println("Pilihan tidak ada di daftar. Silakan coba lagi.");
            }
        }

    }

    private static boolean mahasiswaLogin(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("Panjang NIM harus tepat 15 karakter.");
            return false;
        }
        for (String validNim : MAHASISWA_NIM) {
            if (validNim.equals(nim)) {
                System.out.println("Berhasil login sebagai mahasiswa");
                return true;
            }
        }
        System.out.println("NIM tidak valid.");
        return false;
    }

    private static boolean adminLogin(Scanner scanner) {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();
        if ( ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)){
            System.out.print("Login admin anda berhasil");
            return true;
        } else {
            System.out.print("username atau password anda salah");
        }
        return false;
    }
}