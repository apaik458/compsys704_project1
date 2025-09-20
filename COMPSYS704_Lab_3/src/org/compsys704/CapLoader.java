// CapLoader.java - POS-only version with compact layout
package org.compsys704;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CapLoader extends JFrame {
    private JPanel panel;

    public CapLoader() {
        panel = new Canvas(); // your 1920x1080 drawing panel
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(1000, 800));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, c);

        // --- POS SYSTEM PANEL ---
        JPanel posPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        posPanel.setBorder(BorderFactory.createTitledBorder("POS System"));

        // ---- First row: Liquid controls ----
        JPanel liquidPanel = new JPanel(new GridLayout(2, 3, 5, 5)); // two rows, side by side
        // Liquid 1
        JLabel l1Label = new JLabel("Liquid 1 (%)");
        JTextField liquid1Field = new JTextField("50", 5);
        liquid1Field.setEditable(false);
        JButton l1Up = new JButton("▲");
        JButton l1Down = new JButton("▼");

        // Liquid 2
        JLabel l2Label = new JLabel("Liquid 2 (%)");
        JTextField liquid2Field = new JTextField("50", 5);
        liquid2Field.setEditable(false);
        JButton l2Up = new JButton("▲");
        JButton l2Down = new JButton("▼");

        // Action logic for linked percentages (step = 10)
        l1Up.addActionListener(e -> {
            int v1 = Integer.parseInt(liquid1Field.getText());
            if (v1 <= 90) {
                v1 += 10;
                int v2 = 100 - v1;
                liquid1Field.setText(String.valueOf(v1));
                liquid2Field.setText(String.valueOf(v2));
            }
        });
        l1Down.addActionListener(e -> {
            int v1 = Integer.parseInt(liquid1Field.getText());
            if (v1 >= 10) {
                v1 -= 10;
                int v2 = 100 - v1;
                liquid1Field.setText(String.valueOf(v1));
                liquid2Field.setText(String.valueOf(v2));
            }
        });
        l2Up.addActionListener(e -> {
            int v2 = Integer.parseInt(liquid2Field.getText());
            if (v2 <= 90) {
                v2 += 10;
                int v1 = 100 - v2;
                liquid2Field.setText(String.valueOf(v2));
                liquid1Field.setText(String.valueOf(v1));
            }
        });
        l2Down.addActionListener(e -> {
            int v2 = Integer.parseInt(liquid2Field.getText());
            if (v2 >= 10) {
                v2 -= 10;
                int v1 = 100 - v2;
                liquid2Field.setText(String.valueOf(v2));
                liquid1Field.setText(String.valueOf(v1));
            }
        });

        // Layout: each liquid control in its own row
        JPanel l1Panel = new JPanel(new GridLayout(1, 3));
        l1Panel.add(liquid1Field);
        l1Panel.add(l1Up);
        l1Panel.add(l1Down);

        JPanel l2Panel = new JPanel(new GridLayout(1, 3));
        l2Panel.add(liquid2Field);
        l2Panel.add(l2Up);
        l2Panel.add(l2Down);

        liquidPanel.add(l1Label);
        liquidPanel.add(l1Panel);
        liquidPanel.add(l2Label);
        liquidPanel.add(l2Panel);

        // ---- Second row: Bottle size + Amount ----
        JPanel optionsPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        JCheckBox smallBottle = new JCheckBox("Small Bottle");
        
        JCheckBox largeBottle = new JCheckBox("Large Bottle");
        JLabel amountLabel = new JLabel("Amount");
        JTextField amountField = new JTextField("1", 5);

        optionsPanel.add(smallBottle);
        optionsPanel.add(largeBottle);
        JPanel amountPanel = new JPanel(new GridLayout(1, 2));
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);
        optionsPanel.add(amountPanel);

        // ---- Third row: Start button ----
        JButton startPOS = new JButton("Start POS");
        startPOS.addActionListener(e -> {
            SignalClient sc = new SignalClient(Ports.PORT_LOADER_PLANT, Ports.ENABLE_SIGNAL);
            new Thread(() -> {
                for (int i = 0; i < 5; i++) { // emit for ~200ms
                    sc.actionPerformed(null);
                    try { Thread.sleep(20); } catch (InterruptedException ex) {}
                }
            }).start();
        });

        // Add everything to posPanel
        posPanel.add(liquidPanel);
        posPanel.add(optionsPanel);
        posPanel.add(startPOS);

        c.gridy = 1;
        c.weighty = 0;
        this.add(posPanel, c);

        this.setTitle("Cap Loader - POS System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        System.out.println("Program starting...");
        CapLoader cl = new CapLoader();
        cl.pack();
        cl.setVisible(true);

        SignalServer<LoaderVizWorker> server =
            new SignalServer<>(Ports.PORT_LOADER_VIZ, LoaderVizWorker.class);
        new Thread(server).start();
        System.out.println("Server Started");

        while (true) {
            try {
                cl.repaint();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
