package Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField nameField;
    private JTextField nimField;
    private JTextField quiz1Field;
    private JTextField quiz2Field;
    private JTextField utsField;
    private JTextField uasField;
    private JTextField tugasBesarField;
    private JTextArea resultArea;

    public Main() {
        setTitle("KALKULASI NILAI MAHASISWA");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(240, 248, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Panel for input
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

        JLabel quiz1Label = new JLabel("Nilai Quiz:");
        quiz1Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(quiz1Label, gbc);

        quiz1Field = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(quiz1Field, gbc);

        JLabel quiz2Label = new JLabel("Nilai Tugas:");
        quiz2Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(quiz2Label, gbc);

        quiz2Field = new JTextField(5);
        gbc.gridx = 1;
        inputPanel.add(quiz2Field, gbc);

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

        // Calculate button
        JButton calculateButton = new JButton("Hitung Nilai");
        calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        calculateButton.setBackground(new Color(173, 216, 230));
        gbc.gridy = 1;
        add(calculateButton, gbc);

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        resetButton.setBackground(new Color(255, 182, 193));
        gbc.gridy = 2;
        add(resetButton, gbc);

        // Panel for result
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

        // Action listener for calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        // Action listener for reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    private void calculateGrade() {
        try {
            String name = nameField.getText();
            String nim = nimField.getText();
            int quiz1 = Integer.parseInt(quiz1Field.getText());
            int quiz2 = Integer.parseInt(quiz2Field.getText());
            int uts = Integer.parseInt(utsField.getText());
            int uas = Integer.parseInt(uasField.getText());
            int tugasBesar = Integer.parseInt(tugasBesarField.getText());

            int ratarata = (quiz1 + quiz2 + uts + uas + tugasBesar) / 5;
            String nilai;
            String status = "";

            if (ratarata < 50) {
                nilai = "E";
                status = "Anda harus mengulang mata kuliah ini";
            } else if (ratarata < 60) {
                nilai = "D";
                status = "Nilai kurang silakan ikut perbaikan";
            } else if (ratarata < 70) {
                nilai = "C";
                status = "Lulus dengan nilai cukup";
            } else if (ratarata < 80) {
                nilai = "B";
                status = "Lulus dengan nilai baik";
            } else {
                nilai = "A";
                status = "Lulus dengan nilai sangat baik";
            }

            String result = String.format(
                    "Name: %s\nNIM: %s\nRata-rata nilai: %d\nNilai: %s\nStatus: %s\n\n",
                    name, nim, ratarata, nilai, status
            );

            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan nilai harus berupa bilangan bulat.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        nameField.setText("");
        nimField.setText("");
        quiz1Field.setText("");
        quiz2Field.setText("");
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
