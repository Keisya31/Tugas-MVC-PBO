package View;

public class View {
    // Deklarasi Metode - method tampilkanHasil, untuk menampilkan informasi nilai mata kuliah mahasiswa
    public void tampilkanHasil(String nama, String nim, int rataRata, String nilai, String status) {
        System.out.println("Name: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Rata-rata nilai: " + rataRata);
        System.out.println("Nilai: " + nilai);
        System.out.println("Status: " + status);
    }
}
