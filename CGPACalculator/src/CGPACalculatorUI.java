import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CGPACalculatorUI extends JFrame {
    private JTextField semesterField;
    private JPanel semesterPanel;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton generateButton;

    public CGPACalculatorUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("CGPA Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(173, 216, 230)); // Light Blue background

        // Centering mainPanel contents
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(173, 216, 230)); // Light Blue background
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel for entering the number of semesters
        JPanel semesterInputPanel = new JPanel();
        semesterInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        semesterInputPanel.setBackground(new Color(173, 216, 230)); // Light Blue background
        JLabel semesterLabel = new JLabel("Enter number of semesters:");
        semesterLabel.setForeground(Color.BLACK);
        semesterInputPanel.add(semesterLabel);
        semesterField = new JTextField(5);
        semesterInputPanel.add(semesterField);
        generateButton = new JButton("Generate");
        generateButton.setBackground(new Color(144, 238, 144)); // Light Green background
        generateButton.setForeground(Color.BLACK);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSemesters();
            }
        });
        semesterInputPanel.add(generateButton);

        // Panel for entering grades and credits
        semesterPanel = new JPanel();
        semesterPanel.setLayout(new BoxLayout(semesterPanel, BoxLayout.Y_AXIS));
        semesterPanel.setBackground(new Color(173, 216, 230)); // Light Blue background
        JScrollPane scrollPane = new JScrollPane(semesterPanel);
        scrollPane.getViewport().setBackground(new Color(173, 216, 230)); // Light Blue background

        // Panel for the result
        resultLabel = new JLabel("CGPA: ");
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton = new JButton("Calculate CGPA");
        calculateButton.setBackground(new Color(144, 238, 144)); // Light Green background
        calculateButton.setForeground(Color.BLACK);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCGPA();
            }
        });

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBackground(new Color(173, 216, 230)); // Light Blue background
        resultPanel.add(calculateButton);
        resultPanel.add(resultLabel);

        centerPanel.add(semesterInputPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(scrollPane);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(resultPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void generateSemesters() {
        semesterPanel.removeAll();
        try {
            int numberOfSemesters = Integer.parseInt(semesterField.getText());
            for (int i = 1; i <= numberOfSemesters; i++) {
                addSemesterPanel(i);
            }
            revalidate();
            repaint();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of semesters.");
        }
    }

    private void addSemesterPanel(int semesterNumber) {
        JPanel semesterInputPanel = new JPanel();
        semesterInputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Semester " + semesterNumber, 0, 0, null, Color.BLACK));
        semesterInputPanel.setLayout(new GridLayout(0, 2, 10, 10));
        semesterInputPanel.setBackground(new Color(173, 216, 230)); // Light Blue background

        JLabel gradeLabel = new JLabel("Semester Grade:");
        gradeLabel.setForeground(Color.BLACK);
        JTextField gradeField = new JTextField(5);

        semesterInputPanel.add(gradeLabel);
        semesterInputPanel.add(gradeField);

        semesterPanel.add(semesterInputPanel);
    }

    private void calculateCGPA() {
        double totalGradePoints = 0.0;
        double totalCredits = 0.0;

        Component[] semesterPanels = semesterPanel.getComponents();
        for (Component semesterComponent : semesterPanels) {
            if (semesterComponent instanceof JPanel) {
                JPanel semesterInputPanel = (JPanel) semesterComponent;
                Component[] components = semesterInputPanel.getComponents();

                try {
                    JTextField gradeField = (JTextField) components[1];

                    double grade = Double.parseDouble(gradeField.getText());
                    double credits = 10.0; // Fixed credit value for each semester
                    totalGradePoints += grade * credits;
                    totalCredits += credits;
                } catch (NumberFormatException e) {
                    resultLabel.setText("Please enter valid numbers for grades.");
                    return;
                }
            }
        }

        if (totalCredits == 0) {
            resultLabel.setText("CGPA: Invalid, total credits cannot be zero.");
        } else {
            double cgpa = totalGradePoints / totalCredits;
            resultLabel.setText(String.format("CGPA: %.2f", cgpa));
        }
    }
}


  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
