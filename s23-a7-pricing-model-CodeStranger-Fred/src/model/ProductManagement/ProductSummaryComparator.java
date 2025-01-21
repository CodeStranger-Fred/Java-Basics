package model.ProductManagement;

import java.util.Comparator;

public class ProductSummaryComparator implements Comparator<ProductSummary>{

    @Override
    public int compare(ProductSummary o1, ProductSummary o2) {
        // TODO Auto-generated method stub
        if (o1.getSalesRevenues() == o2.getSalesRevenues()) return 0;

        if (o1.getSalesRevenues() < o2.getSalesRevenues()) return -1;

        return 1;

    }
    
}
