import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class GeographyQuiz extends JFrame {

    private JPanel pnlMain;
    private JPanel pnl1;
    private JPanel pnl2;
    private JPanel pnl3;
    private JPanel pnl4;

    private JLabel lblQ1;
    private JLabel lblQ2;
    private JLabel lblQ3;
    private JLabel lblMessage4;

    private JLabel lblScore1;
    private JLabel lblScore2;
    private JLabel lblScore3;
    private JLabel lblScore4;

    private JTextField tfAnswer1;
    private JTextField tfAnswer2;
    private JTextField tfAnswer3;

    private JButton btnNext1;
    private JButton btnBack2;
    private JButton btnNext2;
    private JButton btnBack3;
    private JButton btnNext3;
    private JButton btnBack4;

    private int score = 0;


    public GeographyQuiz() {

        pnl1.setName("panel1");
        pnl2.setName("panel2");
        pnl3.setName("panel3");
        pnl4.setName("panel4");

        tfAnswer1.setName("question1TextField");
        tfAnswer2.setName("question2TextField");
        tfAnswer3.setName("question3TextField");

        lblScore1.setName("scoreLabel");
        lblScore2.setName("scoreLabel");
        lblScore3.setName("scoreLabel");
        lblScore4.setName("scoreLabel");

        btnNext1.setName("nextButton");
        btnNext2.setName("nextButton");
        btnNext3.setName("nextButton");

        btnBack2.setName("backButton");
        btnBack3.setName("backButton");
        btnBack4.setName("backButton");


        final CardLayout cardLayout = (CardLayout) pnlMain.getLayout();


        // pnl1 next button
        btnNext1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                updateScore();
                cardLayout.next(pnlMain);

            }
        });


        // pnl2 back button
        btnBack2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cardLayout.previous(pnlMain);

            }
        });


        // pnl2 next button
        btnNext2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                updateScore();
                cardLayout.next(pnlMain);

            }
        });


        // pnl3 back button
        btnBack3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cardLayout.previous(pnlMain);

            }
        });


        // pnl3 next button
        btnNext3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                updateScore();

                lblMessage4.setText("Congratulations! Your final score is " + score + "/3.");

                saveScore();

                cardLayout.next(pnlMain);

            }
        });


        // pnl4 back button
        btnBack4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cardLayout.previous(pnlMain);

            }
        });

    }


    public int calculateScore() {

        int score = 0;

        if (tfAnswer1.getText().trim().equalsIgnoreCase("Paris")) {
            score++;
        }

        if (tfAnswer2.getText().trim().equalsIgnoreCase("Tokyo")) {
            score++;
        }

        if (tfAnswer3.getText().trim().equalsIgnoreCase("Berlin")) {
            score++;
        }

        return score;

    }


    public void updateScore() {

        score = calculateScore();

        JLabel[] scoreLabels = {lblScore1, lblScore2, lblScore3, lblScore4};

        for (int i = 0; i < scoreLabels.length; i++) {
            scoreLabels[i].setText("Your Score: " + score + "/3");
        }

    }

    public void saveScore() {

        try {

            FileWriter writer = new FileWriter("quiz_results.txt", true);

            writer.write("Final Score: " + score + "/3\n");

            writer.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this, "Unable to save quiz results.");

        }

    }


    public static void main(String[] args) {

        GeographyQuiz quiz = new GeographyQuiz();

        quiz.setTitle("Geography Quiz");
        quiz.setContentPane(quiz.pnlMain);
        quiz.setSize(500, 450);
        quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quiz.setLocationRelativeTo(null);
        quiz.setVisible(true);

    }

}