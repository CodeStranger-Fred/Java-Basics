/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import model.OrderManagement.Order;

/**
 *
 * @author kal bugrara
 */
public class CustomerSummary {
    Order subjectorder;
    int orderTotal;
    int totalSales;
    int totalNumberOfItems;
    float avgPerOrder;
    float avgPerItem;
    CustomerProfile cp;

    public CustomerSummary(CustomerProfile cp) {
        this.cp = cp;
        orderTotal = cp.getOrderTotal();
        totalSales = cp.getTotalSales();
        totalNumberOfItems = cp.getTotalItems();
        //orderpriceperformance = o.getOrderPricePerformance();
        //numberofOrderitemsabovetarget = o.getNumberOfOrderItemsAboveTarget();
        //numberOfItems = o.getNumberOfOrderItems();
        //customerId = o.getCustomerId();
    }

    float averageOrder(){
        if (orderTotal == 0) return 0;
        return (float)totalSales/(float)orderTotal;
    }

    float averageItem(){
        if (totalNumberOfItems == 0) return 0;
        return (float)totalSales/(float)totalNumberOfItems;
        //return (totalSales/totalNumberOfItems);
    }

    public void printOrderSummary() {
        //System.out.println("Customer #" + cp.getCustomerId() + " | " + orderTotal + " | " + totalSales + " | " + totalNumberOfItems + " | " + averageItem() + " | " + averageOrder());
        System.out.printf("Customer # %9s | %5d\t | %8d\t | %8d\t | \t%14.2f\t | \t%14.2f\t |", cp.getCustomerId(),orderTotal,totalSales,totalNumberOfItems,averageItem(),averageOrder());
        System.out.println();
    }
    
}
