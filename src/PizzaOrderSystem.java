import javax.swing.*;

public class PizzaOrderSystem extends JFrame{
    private JPanel pnlMain;
    private JComboBox cbSize;
    private JComboBox cbToppings;
    private JComboBox cbExtraCheese;
    private JButton btnTotal;
    private JLabel lblSize;
    private JLabel lblToppings;
    private JLabel lblExtraCheese;
    private JLabel lblTotal;

    public PizzaOrderSystem (){

        cbSize.setName("pizzaSizeChoice");
        cbToppings.setName("pizzaToppingsChoice");
        cbExtraCheese.setName("extraCheeseChoice");
        lblTotal.setName("totalLabel");
        btnTotal.setName("calculateButton");

        cbSize.setModel(new DefaultComboBoxModel<>(
                new String[]{
                        "Small",
                        "Medium",
                        "Large"
                }
        ));

        cbToppings.setModel(new DefaultComboBoxModel<>(
                new String[]{
                        "Mushroom",
                        "Pepperoni",
                        "Onions"
                }
        ));

        cbExtraCheese.setModel(new DefaultComboBoxModel<>(
                new String[]{
                        "Yes",
                        "No"
                }
        ));

        lblTotal.setText("0");

        btnTotal.addActionListener(e -> {

            String size = (String) cbSize.getSelectedItem();
            String cheese = (String) cbExtraCheese.getSelectedItem();

            int total = 0;

            switch (size) {
                case "Small":
                    total = 10;
                    break;
                case "Medium":
                    total = 15;
                    break;
                case "Large":
                    total = 20;
                    break;
            }

            total += 2;

            if ("Yes".equals(cheese)) {
                total += 3;
            }

            lblTotal.setText(total + "");
        });
    }


    public static void main(String[] args) {
        PizzaOrderSystem app = new PizzaOrderSystem();

        app.setContentPane(app.pnlMain);
        app.setSize(400, 250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
