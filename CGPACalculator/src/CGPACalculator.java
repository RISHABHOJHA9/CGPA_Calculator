import javax.swing.SwingUtilities;

public class CGPACalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CGPACalculatorUI ui = new CGPACalculatorUI();
            ui.setVisible(true);
        });
    }
}
