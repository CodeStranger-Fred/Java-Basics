/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 import Campus.*;

/**
 *
 * @author kal bugrara
 */
public class CampusMainExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         * 0. Create Address object
         * 1. create campus object
         * 2. Create and add buildings
         * 3. Create and floors
         * 4. Create and add rooms
         * 5. Assign sprinkers.
         * 6. Write methods to determine is campus safe => are builinds safe etc.
         */

         Address address_for_campus = new Address(203, "New burry Northeastern University", "02139","290 320" );
         Campus camp = new Campus(address_for_campus);


         Address address_for_CarmBuilding = new Address(186, "North Station", "02140","280 330" );
         Address address_for_MaryBuilding = new Address(192, "Curry Center LOL", "02141","282 335" );
         
         Building CarmBuilding = camp.addNewBuilding(1, address_for_CarmBuilding);

    
         Floor CarmBuildingFloor1 = CarmBuilding.addNewFloor(1);
         Floor CarmBuildingFloor2 = CarmBuilding.addNewFloor(2);
         

         Classroom Carm101 = CarmBuildingFloor1.newRoom(101);
         Classroom Carm102 = CarmBuildingFloor1.newRoom(102);
         Classroom Carm103 = CarmBuildingFloor1.newRoom(103);
         Classroom Carm210 = CarmBuildingFloor2.newRoom(210);
         Classroom Carm211 = CarmBuildingFloor2.newRoom(211);

         Carm101.setSprinkler("111111", "2222222");
         Carm102.setSprinkler("222222", "3333333");
         Carm103.setSprinkler("333333", "4444444");
         Carm210.setSprinkler("444444", "5555555");
         Carm211.setSprinkler("555555", "6666666");



         Building MarryBuilding = camp.addNewBuilding(2, address_for_MaryBuilding);

         Floor MarryBuildingFloor1 = MarryBuilding.addNewFloor(1);
         Floor MarryBuildingFloor2 = MarryBuilding.addNewFloor(2);
         Floor MarryBuildingFloor3 = MarryBuilding.addNewFloor(3);

         Classroom Marry101 = MarryBuildingFloor1.newRoom(101);
         Classroom Marry102 = MarryBuildingFloor1.newRoom(102);
         Classroom Marry201 = MarryBuildingFloor2.newRoom(201);
         Classroom Marry202 = MarryBuildingFloor2.newRoom(202);
         Classroom Marry340 = MarryBuildingFloor3.newRoom(340);

         Marry101.setSprinkler("11", "222");
         Marry102.setSprinkler("22", "333");
         Marry201.setSprinkler("33", "444");
         Marry202.setSprinkler("44", "555");
         Marry340.setSprinkler("55", "666");


         System.out.println("At Initial Stage(All sprinklers are active):");
         camp.printCampusSafe();


         Carm101.setSprinklerInactive();
         System.out.println("If Carm101 is on fire:");
         camp.printCampusSafe();
         

         Carm101.setSprinklerReset();
         System.out.println("After Carm101 fire put out:");
         camp.printCampusSafe();


    }

}
