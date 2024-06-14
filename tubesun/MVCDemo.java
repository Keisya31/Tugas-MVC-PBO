import javax.swing.SwingUtilities;

public class MVCDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GradeCalculatorView view = new GradeCalculatorView();
                Student model = new Student("", "", 0, 0, 0, 0, 0); // Initial model can be empty
                GradeCalculatorController controller = new GradeCalculatorController(model, view);
                view.setVisible(true);
            }
        });
    }
}
