/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.EmployeeDirectory;
import model.Personnel.EmployeeProfile;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  static int upperPriceLimit = 50;
  static int lowerPriceLimit = 10;
  static int range = 5;
  static int productMaxQuantity = 5;

  public static Business createABusinessAndLoadALotOfData(String name, int supplierCount, int productCount,
      int customerCount, int orderCount, int itemCount) {
    Business business = new Business(name);

    // Add Suppliers +
    loadSuppliers(business, supplierCount);

    // Add Products +
    loadProducts(business, productCount);

    // Add Customers
    loadCustomers(business, customerCount);

    // Add Order
    loadOrders(business, orderCount, itemCount, customerCount);

    System.out.println(business.getMasterOrderList().getOrders().size());

    return business;
  }

  public static void loadSuppliers(Business b, int supplierCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    for (int index = 1; index <= supplierCount; index++) {
      supplierDirectory.newSupplier("Supplier #" + index);
    }
  }

  static void loadProducts(Business b, int productCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    int count = 5;
    List<String> tempList = new ArrayList<>();
    for (int i = 0; i < count; i++) { // Supplier supplier : supplierDirectory.getSuplierList()
      Supplier supplier = supplierDirectory.pickRandomSupplier();
      // int randomProductNumber = getRandom(1, productCount);
      if (!tempList.contains(supplier.getName())){
      ProductCatalog productCatalog = supplier.getProductCatalog();

      for (int index = 1; index <= productCount; index++) {

        String productName = "Product #" + index + " from " + supplier.getName();
        int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
        int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
        int randomTarget = getRandom(randomFloor, randomCeiling);

        productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
      }
      tempList.add(supplier.getName());
    }else{
      i--;
    }
  }
  }

  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt(upper - lower + 1);
    return randomInt;
  }

  static void loadCustomers(Business b, int customerCount) {
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson("" + index);
      customerDirectory.newCustomerProfile(newPerson);
    }
  }

  static void loadOrders(Business b, int orderCount, int itemCount, int customerCount) {

    // reach out to masterOrderList
    MasterOrderList mol = b.getMasterOrderList();

    // pick a customer (reach to customer directory)
    CustomerDirectory cd = b.getCustomerDirectory();
    SupplierDirectory sd = b.getSupplierDirectory();

    for (int customerIndex = 1; customerIndex <= customerCount; customerIndex++) {

      CustomerProfile customer = cd.findCustomer("" + customerIndex);
      // if (randomCustomer == null) {
      // System.out.println("Cannot generate orders. No customers in the customer
      // directory.");
      // return;
      // }

      // create an orderCount for that customer
      int randomOrderCount = getRandom(5, orderCount);
      for (int randomOrderIndex = 1; randomOrderIndex <= randomOrderCount; randomOrderIndex++) {

        Order fixedOrder = mol.newOrder(customer);

        // add order items
        // -- pick a supplier first (randomly)
        // -- pick a product (randomly)
        // -- actual price, quantity

        int randomItemCount = getRandom(1, itemCount);
        ArrayList<Supplier> supplierList = sd.getFullSupplier();

        for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

          //System.out.println(supplierList.size());
          int supplierRandomIndex = getRandom(0, supplierList.size()-1);
          //System.out.println(supplierRandomIndex);
          Supplier randomSupplier = supplierList.get(supplierRandomIndex);

          
          if (randomSupplier == null) {
            System.out.println("Cannot generate orders. No supplier in the supplier directory.");
            return;
          }
          ProductCatalog pc = randomSupplier.getProductCatalog();
          Product randomProduct = pc.pickRandomProduct();
          if (randomProduct == null) {
            System.out.println("Cannot generate orders. No products in the product catalog.");
            return;
          }

          int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
          int randomQuantity = getRandom(1, productMaxQuantity);

          OrderItem oi = fixedOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
        }
      }

    }

    // Make sure order items are connected to the order

  }

}
