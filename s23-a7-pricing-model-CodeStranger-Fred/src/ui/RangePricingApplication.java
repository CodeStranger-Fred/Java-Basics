/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomersReport;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here


    // 1. Populate the model +

    //Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 50, 10, 30, 100, 10);

   // 2. Maybe some interaction with the user (optional)
    Scanner sc = new Scanner(System.in);
    boolean exitCode = false;

    while (!exitCode){
      System.out.println("-------------------------------------------------------Report-----------------------------------------");
      System.out.println("Whether to Print a new Customer Report. Please enter Yes or No.");
      String input = sc.next().toLowerCase();
      if (input.equals("yes")){
        Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 30, 20, 30, 15, 5);
        CustomerDirectory mol = business.getCustomerDirectory();
        CustomersReport customerReport = mol.generatCustomerPerformanceReport();
        customerReport.printCustomerReport();


        System.out.println("----------------------------------------------------Sort Report--------------------------------------");
        System.out.println("Do you want a sorted report? Please Enter 1,2,3:");
        System.out.println("1.Sort by Order Counts");
        System.out.println("2.Sort by Total Sales");
        System.out.println("3.Don't Sort");
        String input2 = sc.next().toLowerCase();
        
        
        if (input2.equals("1")){
          customerReport.sortCustomerReportByOrderCounts();
          customerReport.printCustomerReport();
        }

        if (input2.equals("2")){
          customerReport.sortCustomerReportByTotalSales();
          customerReport.printCustomerReport();
        }
      }
      if (input.equals("no")) exitCode = true;
      System.out.println("");
    }
   // 3. Show some analytics (Summerizing, comparing, sorting, grouping data by some criteria)

    



    //business.printShortInfo();

    //SupplierDirectory sd = business.getSupplierDirectory();
    //Supplier randomSupplier = sd.pickRandomSupplier();
    //ProductCatalog pd = randomSupplier.getProductCatalog();
    //ProductsReport myFirstReport = pd.generatProductPerformanceReport();
    //myFirstReport.printProductReport();
    //CustomerDirectory mol = business.getCustomerDirectory();
    //CustomersReport customerReport = mol.generatCustomerPerformanceReport();
    //customerReport.printCustomerReport();

    //Collections.sort()


  }
}
