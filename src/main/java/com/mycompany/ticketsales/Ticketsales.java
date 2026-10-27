/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 * Calculates statistics for a 2D array of ticket sales.
 * Rows = years, columns = seasons.
 */
public class TicketSales implements ITicketSales {

    /** Adds up every value in the 2D array. */
    @Override
    public int TotalTicketSales(int[][] ticketSales) {
        int total = 0;
        for (int[] year : ticketSales) {      // each row is a year
            for (int sale : year) {           // each column is a season
                total += sale;
            }
        }
        return total;
    }

    /** Total divided by the number of entries (seasons across all years). */
    @Override
    public double AverageTicketSales(int[][] ticketSales) {
        int count = 0;
        for (int[] year : ticketSales) {
            count += year.length;             // count cells, no hard-coded 8
        }
        return count == 0 ? 0 : (double) TotalTicketSales(ticketSales) / count;
    }

    /** Largest value in the array. */
    @Override
    public int HighestSale(int[][] ticketSales) {
        int highest = ticketSales[0][0];      // start with the first value
        for (int[] year : ticketSales) {
            for (int sale : year) {
                if (sale > highest) {
                    highest = sale;
                }
            }
        }
        return highest;
    }

    /** Smallest value in the array. */
    @Override
    public int LowestSale(int[][] ticketSales) {
        int lowest = ticketSales[0][0];
        for (int[] year : ticketSales) {
            for (int sale : year) {
                if (sale < lowest) {
                    lowest = sale;
                }
            }
        }
        return lowest;
    }
}