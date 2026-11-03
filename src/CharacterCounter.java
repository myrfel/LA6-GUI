import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCounter extends JFrame {
    private JTextArea taMessage;
    private JPanel pnlMain;
    private JTextField tfCharacter;
    private JButton btnCount;
    private JLabel lblEnter;
    private JLabel lblCount;
    private JLabel lblCounter;

    public CharacterCounter(){
        taMessage.setName("messageTextArea");
        tfCharacter.setName("characterTextField");
        btnCount.setName("countButton");
        lblCount.setName("countLabel");
        lblCounter.setText("0");

        btnCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = taMessage.getText();
                String input = tfCharacter.getText();
                char target = input.charAt(0);
                int count  = 0;

                for(int i = 0; i < message.length(); i++){
                    if(message.charAt(i) == target){
                        count++;
                    }
                }

                lblCounter.setText(String.valueOf(count));
            }
        });
    }




    public static void main(String[] args) {
        CharacterCounter app = new CharacterCounter();

        app.setContentPane(app.pnlMain);
        app.setSize(500, 450);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
