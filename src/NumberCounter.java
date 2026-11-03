import javax.swing.*;

public class NumberCounter extends JFrame {
    private JPanel pnlMain;
    private JLabel lblCount;
    private JButton btnDecrease;
    private JButton btnIncrease;

    private int count = 0;

    public NumberCounter() {
        lblCount.setName("countLabel");
        btnIncrease.setName("increaseButton");
        btnDecrease.setName("decreaseButton");

        lblCount.setText("0");

        btnIncrease.addActionListener(e -> {
            count++;
            lblCount.setText(String.valueOf(count));
        });

        btnDecrease.addActionListener(e -> {
            count--;
            lblCount.setText(String.valueOf(count));
        });
    }
    public static void main(String[] args) {
        NumberCounter app = new NumberCounter();

        app.setContentPane(app.pnlMain);
        app.setSize(400, 250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }


}
