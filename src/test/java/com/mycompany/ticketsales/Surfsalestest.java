/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsales;
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Q.2.5 - Unit tests for the SurfSales class. */
public class Surfsalestest {

    private SurfSales surfSales;

    @BeforeEach
    void setUp() {
        surfSales = new SurfSales();   // uses the exam data
    }

    @Test
    void GetSalesOverTarget_ReturnsNumberOfSales() {
        // 520, 610 and 450 are greater than 400
        assertEquals(3, surfSales.GetSalesOverTarget());
    }

    @Test
    void GetSalesUnderTarget_ReturnsNumberOfSales() {
        // The other 6 values are 400 or less
        assertEquals(6, surfSales.GetSalesUnderTarget());
    }
}