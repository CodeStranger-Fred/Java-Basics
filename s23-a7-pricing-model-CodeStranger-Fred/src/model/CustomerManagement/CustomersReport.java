/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kal bugrara
 */
public class CustomersReport {
    ArrayList<CustomerSummary> customerlist;
    
    public CustomersReport(){
        customerlist = new ArrayList<CustomerSummary>();
    }

    public void addCustomerSummary(CustomerSummary cs){
        customerlist.add(cs);
    }


    public void printCustomerReport(){
        int orderCounts = 0;
        int totalSales = 0;
        System.out.println("Customer Order Report");
        System.out.printf("%18s\t | %8s\t | %s\t | %s| %4s|%s|", "Customer Name","Order Counts","Total Sales","Order of Items","Average Sale(per Item)","Average Sale(per Order)");
        System.out.println();
        for (CustomerSummary cs: customerlist){
            int index = customerlist.indexOf(cs);
            System.out.printf("%-4d",(index+1));
            cs.printOrderSummary();
            orderCounts = orderCounts + cs.orderTotal;
            totalSales = totalSales + cs.totalSales;
        }
        System.out.println("Total order counts for all customer is :"+ orderCounts + "     Total sales for all customer is :" + totalSales);
    }

    public void sortCustomerReportByOrderCounts(){
        CustomerSummaryComparator comparator = new CustomerSummaryComparator();
        Collections.sort(customerlist,comparator);
    }

    public void sortCustomerReportByTotalSales(){
        CustomerSummaryComparatorBySales comparator = new CustomerSummaryComparatorBySales();
        Collections.sort(customerlist,comparator);
    }

}
