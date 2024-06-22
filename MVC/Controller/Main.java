// Untuk ke penerapan method, ada di Line 168

package Controller;

import Model.Model;
import View.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    // Deklarasi Atribut
    private JTextField nameField;
    private JTextField nimField;
    private JTextField tugasField;
    private JTextField quizField;
    private JTextField utsField;
    private JTextField uasField;
    private JTextField tugasBesarField;
    private JTextArea resultArea;

    public Main() {
        // Deklarasi Method
        setTitle("KONVERSI NILAI MAHASISWA");
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(240, 248, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Panel input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        Border inputBorder = BorderFactory.createTitledBorder("Input Data");
        inputPanel.setBorder(inputBorder);

        JLabel nameLabel = new JLabel("Nama Mahasiswa:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);

        nameField = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);

        JLabel nimLabel = new JLabel("NIM:");
        nimLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(nimLabel, gbc);

        nimField = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(nimField, gbc);

        JLabel tugasLabel = new JLabel("Nilai Quiz:");
        tugasLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(tugasLabel, gbc);

        tugasField = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(tugasField, gbc);

        JLabel quizLabel = new JLabel("Nilai Tugas:");
        quizLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(quizLabel, gbc);

        quizField = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(quizField, gbc);

        JLabel utsLabel = new JLabel("Nilai UTS:");
        utsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(utsLabel, gbc);

        utsField = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(utsField, gbc);

        JLabel uasLabel = new JLabel("Nilai UAS:");
        uasLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(uasLabel, gbc);

        uasField = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(uasField, gbc);

        JLabel tugasBesarLabel = new JLabel("Nilai Tugas Besar:");
        tugasBesarLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(tugasBesarLabel, gbc);

        tugasBesarField = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(tugasBesarField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(inputPanel, gbc);

        // Tombol hitung nilai
        JButton calculateButton = new JButton("Hitung Nilai");
        calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        calculateButton.setBackground(new Color(173, 216, 230));
        gbc.gridy = 1;
        add(calculateButton, gbc);

        // Tombol reset
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        resetButton.setBackground(new Color(255, 182, 193));
        gbc.gridy = 2;
        add(resetButton, gbc);

        // Panel hasil
        JPanel resultPanel = new JPanel(new GridBagLayout());
        resultPanel.setOpaque(false);
        Border resultBorder = BorderFactory.createTitledBorder("Hasil");
        resultPanel.setBorder(resultBorder);

        resultArea = new JTextArea(10, 40);
        resultArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0;
        gbc.gridy = 0;
        resultPanel.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(resultPanel, gbc);

        // Memanggil fungsi hitungNilaiMahasiswa ketika tombol ditekan
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungNilaiMahasiswa();
            }
        });

        /// Memanggil fungsi resetFields ketika tombol ditekan
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    // Penerapan method 
    private void hitungNilaiMahasiswa() {
        try {
            // Deklarasi dan pengisian atribut
            String nama = nameField.getText();
            String nim = nimField.getText();
            int tugas = Integer.parseInt(tugasField.getText());
            int quiz = Integer.parseInt(quizField.getText());
            int uts = Integer.parseInt(utsField.getText());
            int uas = Integer.parseInt(uasField.getText());
            int tugasBesar = Integer.parseInt(tugasBesarField.getText());

            // Membuat objek Model
            Model model = new Model(nama, nim, tugas, quiz, uts, uas, tugasBesar);

            // Membuat objek View
            View view = new View();

            // Membuat objek Controller
            Controller controller = new Controller(model, view);

            // Mendapatkan hasil rata-rata, nilai, serta status dari method yang ada pada controller
            int rataRata = controller.hitungRataRata();
            String nilai = controller.hitungNilai();
            String status = controller.hitungStatus();

            String result = String.format(
                    "Name: %s\nNIM: %s\nRata-rata nilai: %d\nNilai: %s\nStatus: %s\n\n",
                    nama, nim, rataRata, nilai, status
            );

            resultArea.setText(result);
        } 
        // Penanganan error: masukan nilai bukan berupa bilangan bulat
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan nilai harus berupa bilangan bulat.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        nameField.setText("");
        nimField.setText("");
        tugasField.setText("");
        quizField.setText("");
        utsField.setText("");
        uasField.setText("");
        tugasBesarField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
