package com.mycompany.ticketsales;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Contract for the surf shop sales calculations (Q.2.4).
 */

public interface ISurfSales {
    int[][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverTarget();
    int GetSalesUnderTarget();
    int GetYearsProcessed();
    double GetAverageSales();
}
