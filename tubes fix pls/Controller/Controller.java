package Controller;

import Model.Model_Mahasiswa;
import View.View;

public class Controller {
    private Model_Mahasiswa model;
    private View view;

    public Controller(Model_Mahasiswa model, View view) {
        this.model = model;
        this.view = view;
    }

    public String hitungNilai() {
        int rataRata = model.hitungRataRata();
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

    public String hitungStatus() {
        int rataRata = model.hitungRataRata();
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

    public void tampilkanHasil() {
        String nama = model.getNama();
        String nim = model.getNim();
        int rataRata = model.hitungRataRata();
        String nilai = hitungNilai();
        String status = hitungStatus();
        view.tampilkanHasil(nama, nim, rataRata, nilai, status);
    }
}
