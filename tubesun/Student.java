public class Student {
    private String name;
    private String nim;
    private int quiz1;
    private int quiz2;
    private int uts;
    private int uas;
    private int tugasBesar;

    public Student(String name, String nim, int quiz1, int quiz2, int uts, int uas, int tugasBesar) {
        this.name = name;
        this.nim = nim;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.uts = uts;
        this.uas = uas;
        this.tugasBesar = tugasBesar;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public int calculateAverage() {
        return (quiz1 + quiz2 + uts + uas + tugasBesar) / 5;
    }

    public String getGrade() {
        int ratarata = calculateAverage();
        if (ratarata < 50) {
            return "E";
        } else if (ratarata < 60) {
            return "D";
        } else if (ratarata < 70) {
            return "C";
        } else if (ratarata < 80) {
            return "B";
        } else {
            return "A";
        }
    }

    public String getStatus() {
        int ratarata = calculateAverage();
        if (ratarata < 50) {
            return "Anda harus mengulang mata kuliah ini";
        } else if (ratarata < 60) {
            return "Nilai kurang silakan ikut perbaikan";
        } else if (ratarata < 70) {
            return "Lulus dengan nilai cukup";
        } else if (ratarata < 80) {
            return "Lulus dengan nilai baik";
        } else {
            return "Lulus dengan nilai sangat baik";
        }
    }
}
