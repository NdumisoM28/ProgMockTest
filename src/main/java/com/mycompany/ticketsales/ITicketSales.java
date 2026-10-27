package com.mycompany.ticketsales;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 
 */
public interface ITicketSales {
    int TotalTicketSales(int[][] ticketSales);
    double AverageTicketSales(int[][] ticketSales);
    int HighestSale(int[][] ticketSales);
    int LowestSale(int[][] ticketSales);
}