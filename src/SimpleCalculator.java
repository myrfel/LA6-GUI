import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1;
    private JPanel pnlMain;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JLabel lblNumber1;
    private JLabel lblNumber2;
    private JLabel lblResultLabel;
    private JLabel lblResult;


    public SimpleCalculator(){
        cbOperations.setModel(new DefaultComboBoxModel<>(
                new String[]{
                        "+",
                        "-",
                        "*",
                        "/"
                }
        ));

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int result = 0;
                int num1 = Integer.parseInt(tfNumber1.getText());
                int num2 = Integer.parseInt(tfNumber2.getText());
                String operation = (String) cbOperations.getSelectedItem();

                switch(operation){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if(num2 == 0){
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                        }
                        result = num1 / num2;
                        break;
                }

                lblResult.setText(result + "");
            }
        });
    }



    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();

        app.setContentPane(app.pnlMain);
        app.setSize(500, 450);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);

    }
}
