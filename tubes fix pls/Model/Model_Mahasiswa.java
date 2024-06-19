package Model;

public class Model_Mahasiswa {
    private String nama;
    private String nim;
    private int nilaiQuiz;
    private int nilaiTugas;
    private int nilaiUTS;
    private int nilaiUAS;
    private int nilaiTugasBesar;

    public Model_Mahasiswa(String nama, String nim, int nilaiQuiz, int nilaiTugas, int nilaiUTS, int nilaiUAS, int nilaiTugasBesar) {
        this.nama = nama;
        this.nim = nim;
        this.nilaiQuiz = nilaiQuiz;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        this.nilaiTugasBesar = nilaiTugasBesar;
    }

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

    public int hitungRataRata() {
        return (nilaiQuiz + nilaiTugas + nilaiUTS + nilaiUAS + nilaiTugasBesar) / 5;
    }
}
