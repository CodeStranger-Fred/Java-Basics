package model.CustomerManagement;

import java.util.Comparator;

public class CustomerSummaryComparator implements Comparator<CustomerSummary>{

    @Override
    public int compare(CustomerSummary o1, CustomerSummary o2) {
        // TODO Auto-generated method stub
        if (Integer.compare(o2.orderTotal, o1.orderTotal) !=0) return Integer.compare(o2.orderTotal, o1.orderTotal);

         return Integer.compare(o2.totalSales, o1.totalSales); 
    }

    
}
