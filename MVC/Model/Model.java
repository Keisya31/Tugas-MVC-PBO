package Model;

public class Model {
    // Deklarasi Atribut
    private String nama;
    private String nim;
    private int nilaiQuiz;
    private int nilaiTugas;
    private int nilaiUTS;
    private int nilaiUAS;
    private int nilaiTugasBesar;

    // Deklarasi Konstruktor
    public Model(String nama, String nim, int nilaiQuiz, int nilaiTugas, int nilaiUTS, int nilaiUAS, int nilaiTugasBesar) {
        this.nama = nama;
        this.nim = nim;
        this.nilaiQuiz = nilaiQuiz;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        this.nilaiTugasBesar = nilaiTugasBesar;
    }

    // Deklarasi Metode - Getter dan/atau Setter
    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    public int getNilaiQuiz() {
        return nilaiQuiz;
    }
    public int getNilaiTugas() {
        return nilaiTugas;
    }
    public int getNilaiUTS() {
        return nilaiUTS;
    }
    public int getNilaiUAS() {
        return nilaiUAS;
    }
    public int getNilaiTugasBesar() {
        return nilaiTugasBesar;
    }

    // Deklarasi Metode - method hitungRataRata untuk menghitung rerata seluruh nilai
    public int hitungRataRata() {
        return (nilaiQuiz + nilaiTugas + nilaiUTS + nilaiUAS + nilaiTugasBesar) / 5;
    }

    // Deklarasi Metode - method hitungNilai untuk menghitung nilai dalam skala A - E
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

    // Deklarasi Metode - method hitungStatus untuk menentukan apakah mahasiswa lulus mata kuliah atau harus mengulang
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
}
