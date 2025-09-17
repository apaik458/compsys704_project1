package org.compsys704;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class POSUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(POSUI::new);
    }

    public POSUI() {
        JFrame frame = new JFrame("POS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 220);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Liquid 1
        c.gridx = 0; c.gridy = 0;
        frame.add(new JLabel("Liquid 1:"), c);
        JTextField liquid1Field = new JTextField();
        c.gridx = 1;
        frame.add(liquid1Field, c);

        // Liquid 2
        c.gridx = 0; c.gridy = 1;
        frame.add(new JLabel("Liquid 2:"), c);
        JTextField liquid2Field = new JTextField();
        c.gridx = 1;
        frame.add(liquid2Field, c);

        // Order amount
        c.gridx = 0; c.gridy = 2;
        frame.add(new JLabel("Order Amount:"), c);
        JTextField orderAmountField = new JTextField();
        c.gridx = 1;
        frame.add(orderAmountField, c);

        // Size checkboxes (only Small and Large)
        c.gridx = 0; c.gridy = 3;
        frame.add(new JLabel("Size:"), c);
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox smallBox = new JCheckBox("Small");
        JCheckBox largeBox = new JCheckBox("Large");
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallBox);
        sizeGroup.add(largeBox);
        sizePanel.add(smallBox);
        sizePanel.add(largeBox);
        c.gridx = 1;
        frame.add(sizePanel, c);

        // Submit button
        JButton submitButton = new JButton("Submit");
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2;
        frame.add(submitButton, c);

        // Action listener for Submit
        submitButton.addActionListener(e -> {
            try {
                int liquid1 = Integer.parseInt(liquid1Field.getText());
                int liquid2 = Integer.parseInt(liquid2Field.getText());
                int orderAmount = Integer.parseInt(orderAmountField.getText());
                String size = smallBox.isSelected() ? "Small" :
                              largeBox.isSelected() ? "Large" : "Not selected";

                JOptionPane.showMessageDialog(frame,
                        "Liquid 1: " + liquid1 +
                        "\nLiquid 2: " + liquid2 +
                        "\nOrder Amount: " + orderAmount +
                        "\nSize: " + size);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter valid integers for liquids and order amount.");
            }
        });

        frame.setVisible(true);
    }

}