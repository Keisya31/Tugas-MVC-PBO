package Controller;

import Model.Model;
import View.View;

public class Controller {
    // Deklarasi Atribut
    private Model model;
    private View view;

    // Deklarasi Konstruktor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

        // Deklarasi Metode - method hitungRataRata untuk menghitung rerata seluruh nilai. Delegasi dari method hitungRataRata yang ada pada kelas Model
    public int hitungRataRata() {
        return (model.getNilaiQuiz() + model.getNilaiTugas() + model.getNilaiUTS() + model.getNilaiUAS() + model.getNilaiTugasBesar()) / 5;
    }

    // Deklarasi Metode - method hitungNilai untuk menghitung nilai dalam skala A - E. Delegasi dari method hitungNilai yang ada pada kelas Model
    public String hitungNilai() {
        int rataRata = hitungRataRata();
        if (rataRata < 50) {
            return "E";
        } else if (rataRata < 60) {
            return "D";
        } else if (rataRata < 70) {
            return "C";
        } else if (rataRata < 80) {
            return "B";
        } else {
            return "A";
        }
    }

    // Deklarasi Metode - method hitungStatus untuk menentukan apakah mahasiswa lulus mata kuliah atau harus mengulang. Delegasi dari method hitungStatus yang ada pada kelas Model
    public String hitungStatus() {
        int rataRata = hitungRataRata();
        if (rataRata < 50) {
            return "Anda harus mengulang mata kuliah ini";
        } else if (rataRata < 60) {
            return "Nilai kurang silakan ikut perbaikan";
        } else if (rataRata < 70) {
            return "Lulus dengan nilai cukup";
        } else if (rataRata < 80) {
            return "Lulus dengan nilai baik";
        } else {
            return "Lulus dengan nilai sangat baik";
        }
    }

    // Deklarasi Metode - method tampilkanHasil, untuk menampilkan informasi nilai mata kuliah mahasiswa. Delegasi dari method tampilkanHasil yang ada pada kelas View
    public void tampilkanHasil() {
        String nama = model.getNama();
        String nim = model.getNim();
        int rataRata = hitungRataRata();
        String nilai = hitungNilai();
        String status = hitungStatus();
        view.tampilkanHasil(nama, nim, rataRata, nilai, status);
    }
}
