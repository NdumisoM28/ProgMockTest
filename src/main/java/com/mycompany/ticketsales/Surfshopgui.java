/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Q.2 - Surf Shop Sales Tracker GUI.
 */
public class Surfshopgui extends JFrame {

    private static final String LOG_FILE = "sales_log.txt";
    private static final String STARS = "******************************";

    private final ISurfsales surfSales = new SurfSales();

    private final JButton loadButton = new JButton("Load Sales Data");
    private final JButton saveButton = new JButton("Save Sales Data");
    private final JTextArea resultsArea = new JTextArea(5, 30);
    private final JLabel yearsLabel = new JLabel("");   // read-only: no editing possible

    public Surfshopgui() {
        super("Surf Shop Sales Tracker");
        buildMenu();
        buildForm();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /** Creates the File and Tools menus. Menu items reuse the same methods as the buttons. */
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> dispose());      // close the application
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Sales Data");
        JMenuItem saveItem = new JMenuItem("Save Sales Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        loadItem.addActionListener(e -> loadSalesData());
        saveItem.addActionListener(e -> saveSalesData());
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    /** Lays out the buttons, text area and label. */
    private void buildForm() {
        resultsArea.setEditable(false);   // results are display-only

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);

        loadButton.addActionListener(e -> loadSalesData());
        saveButton.addActionListener(e -> saveSalesData());

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        add(yearsLabel, BorderLayout.SOUTH);
    }

    /** Calculates the figures and shows them. Shared by the button and menu item. */
    private void loadSalesData() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total Sales: ").append(surfSales.GetTotalSales()).append("\n");
        sb.append("Average Sales: ").append(Math.round(surfSales.GetAverageSales())).append("\n");
        sb.append("Sales over target: ").append(surfSales.GetSalesOverTarget()).append("\n");
        sb.append("Sales under target: ").append(surfSales.GetSalesUnderTarget()).append("\n");
        resultsArea.setText(sb.toString());
        yearsLabel.setText("Years Processed: " + surfSales.GetYearsProcessed());
    }

    /** Writes the text area contents to sales_log.txt. Shared by the button and menu item. */
    private void saveSalesData() {
        if (resultsArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Load the sales data before saving.");
            return;
        }
        // try-with-resources closes the file automatically
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            writer.println("SALES LOG");
            writer.println(STARS);
            writer.print(resultsArea.getText());
            writer.println(STARS);
            JOptionPane.showMessageDialog(this, "Saved to " + LOG_FILE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Empties the text area and the Years Processed label. */
    private void clearForm() {
        resultsArea.setText("");
        yearsLabel.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SurfShopGUI().setVisible(true));
    }
}
