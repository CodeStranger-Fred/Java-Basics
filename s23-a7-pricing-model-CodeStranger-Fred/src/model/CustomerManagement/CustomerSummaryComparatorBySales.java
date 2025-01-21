package model.CustomerManagement;

import java.util.Comparator;

public class CustomerSummaryComparatorBySales implements Comparator<CustomerSummary>{

    @Override
    public int compare(CustomerSummary o1, CustomerSummary o2) {
        // TODO Auto-generated method stub
        if (Integer.compare(o2.totalSales, o1.totalSales) !=0) return Integer.compare(o2.totalSales, o1.totalSales);

         return Integer.compare(o2.orderTotal, o1.orderTotal);
    }
    
}
