/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campus;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Campus {
    
    Address address;
    ArrayList<Building> buildings;
    
    public Campus(Address a){
    
        address = a;
        buildings = new ArrayList<Building>();
        
    }

    public Building addNewBuilding(int n,Address ad) {
        Building build = new Building(n,ad); // reference back to building;
        buildings.add(build);
        return build;
    }

    public boolean CheckCampusIsSafe(){
        boolean CampusIsSafe = true;
        for (Building eachbuilding:buildings){
            if (eachbuilding.isBuildingSafe() == false) CampusIsSafe = false;
        }
        return CampusIsSafe;
    }

    public void printCampusSafe(){
        if (CheckCampusIsSafe() == false){
            System.out.println("Campus Is Not Safe");
        }else{
            System.out.println("Campus Is Safe");
        }
    }

}
