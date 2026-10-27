package com.mycompany.ticketsales;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Holds the Southcoast Surf Co. sales data and calculates the report values.
 * Rows = years, columns = products (Surfboards, Wetsuits, Bodyboards).
 */
public class SurfSales implements ISurfSales {

    // Sales target stored as a constant
    public static final int SALES_TARGET = 400;

    private final int[][] productSales;

    /** Default constructor loads the data from the exam table. */
    public SurfSales() {
        this(new int[][]{
            {520, 380, 150},   // Year 1
            {610, 340, 210},   // Year 2
            {450, 290, 200}    // Year 3
        });
    }

    /** Extra constructor so other data can be supplied (useful for testing). */
    public SurfSales(int[][] productSales) {
        this.productSales = productSales;
    }

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double GetAverageSales() {
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return count == 0 ? 0 : (double) GetTotalSales() / count;
    }

    /** Over target means strictly greater than the target. */
    @Override
    public int GetSalesOverTarget() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > SALES_TARGET) {
                    count++;
                }
            }
        }
        return count;
    }

    /** Under target means equal to or less than the target. */
    @Override
    public int GetSalesUnderTarget() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale <= SALES_TARGET) {
                    count++;
                }
            }
        }
        return count;
    }

    /** Years = number of rows, worked out from the array (not hard-coded). */
    @Override
    public int GetYearsProcessed() {
        return productSales.length;
    }
}