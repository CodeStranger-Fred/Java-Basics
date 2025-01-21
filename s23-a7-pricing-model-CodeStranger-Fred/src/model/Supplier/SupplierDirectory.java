/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.Random;

import model.ProductManagement.ProductCatalog;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    ArrayList<Supplier> suppliers;
    ArrayList<Supplier> suppliersFull;
    public SupplierDirectory(){
        suppliers = new ArrayList<Supplier>();
    }
    public Supplier newSupplier(String n){
        Supplier supplier = new Supplier(n);
        suppliers.add(supplier);
        return supplier;

    }
    public Supplier findSupplier(String id){
        
        for (Supplier supplier: suppliers){
            
            if(supplier.getName().equals(id)) return supplier;
        }
        return null;
        }
    public ArrayList<Supplier> getSuplierList(){
        return suppliers;
    }

    public Supplier pickRandomSupplier(){
        if (suppliers.size() == 0) return null;
        Random r = new Random();
        int randomIndex = r.nextInt(suppliers.size());
        return suppliers.get(randomIndex);
    }


    public void printShortInfo(){
        System.out.println("Checking what's inside the supplier directory.");
        System.out.println("There are " + suppliers.size() + " suppliers.");
        for (Supplier s: suppliers){
            s.printShortInfo();
        }
    }

    public ArrayList<Supplier> getFullSupplier(){
        suppliersFull = new ArrayList<Supplier>();
        for (Supplier s: suppliers){
            ProductCatalog supplierProductCatalog = s.getProductCatalog();
            if (supplierProductCatalog.getProductList().size() != 0){
                //System.out.println(supplierProductCatalog.getProductList());
                suppliersFull.add(s);
            }
        }
        return suppliersFull;
    }

    
}