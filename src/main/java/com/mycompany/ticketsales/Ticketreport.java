/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsales;

/**
 * .
 */
public class Ticketreport {

    private static final String LINE = "----------------------------------------------";

    public static void main(String[] args) {
        // Season names in a 1D array
        String[] seasons = {"Summer", "Autumn", "Winter", "Spring"};

        // Ticket sales in a 2D array: row = year, column = season
        int[][] ticketSales = {
            {420, 310, 180, 390},   // Year 1
            {450, 280, 220, 390}    // Year 2
        };

        ITicketSales calculator = new Ticketsales();

        System.out.println("THEATRE TICKET SALES REPORT - 2026");
        System.out.println(LINE);

        // Header row: season names in upper case
        System.out.printf("%-7s", "");
        for (String season : seasons) {
            System.out.printf("%-7s", season.toUpperCase());
        }
        System.out.println();

        // One line per year
        for (int year = 0; year < ticketSales.length; year++) {
            System.out.printf("%-7s", "YEAR " + (year + 1));
            for (int sale : ticketSales[year]) {
                System.out.printf("%-7d", sale);
            }
            System.out.println();
        }

        System.out.println(LINE);
        System.out.println("Total tickets sold:  " + calculator.TotalTicketSales(ticketSales));
        // Math.round rounds the average to the nearest whole number
        System.out.println("Average per season:  " + Math.round(calculator.AverageTicketSales(ticketSales)));
        System.out.println("Highest season:      " + calculator.HighestSale(ticketSales));
        System.out.println("Lowest season:       " + calculator.LowestSale(ticketSales));
        System.out.println(LINE);
    }
}