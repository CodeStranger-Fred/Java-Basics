/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    String name;
    ArrayList<Department> departments;
    
    public College(String name){
        this.name = name;
        departments = new ArrayList<Department>();
    }

    public Department newDepartment(String n, String degreeName){
        Department c = new Department(n, degreeName);
        departments.add(c);
        return c;
    }

    public void printCollegeInformation(){
        System.out.println("College"+name);
        System.out.println("--------------------------------------");
        System.out.println("List of programs");
        for (Department d: departments){
            d.PrintDepartmentInfo();
        }
    }

    public int calculateRevenuesDepartmentBySemester(String semester){
        int sum = 0;
        for (Department d: departments){
            sum = sum + d.calculateRevenuesBySemester(semester);
        }
        return sum;
    }
}
