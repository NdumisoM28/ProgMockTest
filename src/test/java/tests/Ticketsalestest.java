/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Q.1.3 - Unit tests for the TicketSales class. */
public class Ticketsalestest {

    private TicketSales ticketSalesCalc;
    private int[][] data;

    @BeforeEach
    void setUp() {
        ticketSalesCalc = new TicketSales();
        data = new int[][]{
            {420, 310, 180, 390},
            {450, 280, 220, 390}
        };
    }

    @Test
    void CalculateTotalTicketSales_ReturnsTotalTicketSales() {
        // 1300 (year 1) + 1340 (year 2) = 2640
        assertEquals(2640, ticketSalesCalc.TotalTicketSales(data));
    }

    @Test
    void AverageTicketSales_ReturnsAverageTicketSales() {
        // 2640 / 8 seasons = 330
        assertEquals(330.0, ticketSalesCalc.AverageTicketSales(data), 0.001);
    }
}