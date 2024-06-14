import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorController {
    private Student model;
    private GradeCalculatorView view;

    public GradeCalculatorController(Student model, GradeCalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.getCalculateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        this.view.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.resetFields();
            }
        });
    }

    private void calculateGrade() {
        try {
            String name = view.getName();
            String nim = view.getNim();
            int quiz1 = view.getQuiz1();
            int quiz2 = view.getQuiz2();
            int uts = view.getUts();
            int uas = view.getUas();
            int tugasBesar = view.getTugasBesar();

            model = new Student(name, nim, quiz1, quiz2, uts, uas, tugasBesar);

            String result = String.format(
                "Name: %s\nNIM: %s\nRata-rata nilai: %d\nNilai: %s\nStatus: %s\n\n",
                model.getName(), model.getNim(), model.calculateAverage(), model.getGrade(), model.getStatus()
            );

            view.setResult(result);
        } catch (NumberFormatException ex) {
            view.showError("Masukkan nilai harus berupa bilangan bulat.");
        }
    }
}
