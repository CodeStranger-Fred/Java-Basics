/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Lab Topic: Populating University
        //0.Create a college
        College NEU_coe_college = new College("Northeastern University-college of engineering");

        //0.Create Department
        Department InfoSysDepartment = NEU_coe_college.newDepartment("MGEN", "Information Systems");
        Department damgDepartment = NEU_coe_college.newDepartment("DAMG", "Data Architecture and Management");
        Department CsyeDepartment = NEU_coe_college.newDepartment("CSYE", "Software Engineering Systems");

        //1.Create courses
        CourseCatalog InfoCatalog = InfoSysDepartment.getCourseCatalog();
        CourseCatalog damCatalog = damgDepartment.getCourseCatalog();
        CourseCatalog CsyeCatalog = CsyeDepartment.getCourseCatalog();

        //course for INFO
        InfoCatalog.newCourse("Application Modeling and Design","5100", 4);
        InfoCatalog.newCourse("Python Basics","5002", 4);
        InfoCatalog.newCourse("Web Design and User Experience","6150", 4);

        //course for DAMG
        damCatalog.newCourse("Data Science Engineering with Python","6105", 4);
        damCatalog.newCourse("Data Management and Database Design", "6210", 4);
        damCatalog.newCourse("Advanced Database Management Systems", "7275", 4);

        //course for CSYE
        CsyeCatalog.newCourse("Concepts of Object-Oriented Design", "6200", 4);
        CsyeCatalog.newCourse("Network Structures and Cloud Computing", "6225", 4);
        CsyeCatalog.newCourse("Operating Systems", "6230", 4);

        //2.Create faculty
        FacultyDirectory InfoFacultyDirectory = InfoSysDepartment.getFacultydirectory();
        FacultyDirectory damFacultyDirectory = damgDepartment.getFacultydirectory();
        FacultyDirectory CsyeFacultyDirectory = CsyeDepartment.getFacultydirectory();
        PersonDirectory InfoPersonDirectory = InfoSysDepartment.getPersonDirectory();
        PersonDirectory damPersonDirectory = damgDepartment.getPersonDirectory();
        PersonDirectory CsyePersonDirectory = CsyeDepartment.getPersonDirectory();


        Person Archill = InfoPersonDirectory.newPerson("Archill");
        Person Benjamin = InfoPersonDirectory.newPerson("Benjamin");
        Person Cammella = InfoPersonDirectory.newPerson("Cammella");
        Person Danniel = damPersonDirectory.newPerson("Danniel");
        Person Erick = damPersonDirectory.newPerson("Erick");
        Person Farremick = damPersonDirectory.newPerson("Farremick");
        Person Galricgech = CsyePersonDirectory.newPerson("Galricgech");
        Person Hades = CsyePersonDirectory.newPerson("Hades");
        Person Ismatwere = CsyePersonDirectory.newPerson("Ismatwere");


        FacultyProfile ArchillTA = InfoFacultyDirectory.newFacultyProfile(Archill);
        FacultyProfile BenjaminProf = InfoFacultyDirectory.newFacultyProfile(Benjamin);
        FacultyProfile CammellaProf = InfoFacultyDirectory.newFacultyProfile(Cammella);
        FacultyProfile DannielProf = damFacultyDirectory.newFacultyProfile(Danniel);
        FacultyProfile ErickTA = damFacultyDirectory.newFacultyProfile(Erick);
        FacultyProfile FarremickTA = damFacultyDirectory.newFacultyProfile(Farremick);
        FacultyProfile GalricgechTA = CsyeFacultyDirectory.newFacultyProfile(Galricgech);
        FacultyProfile HadesTA = CsyeFacultyDirectory.newFacultyProfile(Hades);
        FacultyProfile IsmatwereTA = CsyeFacultyDirectory.newFacultyProfile(Ismatwere);

        //3.Create Student
        StudentDirectory InfoStudentDirectory = InfoSysDepartment.getStudentDirectory();
        StudentDirectory damStudentDirectory = damgDepartment.getStudentDirectory();
        StudentDirectory CsyeStudentDirectory = CsyeDepartment.getStudentDirectory();

        //student for Info program
        Person A1 = InfoPersonDirectory.newPerson("A1");
        Person A2 = InfoPersonDirectory.newPerson("A2");
        Person A3 = InfoPersonDirectory.newPerson("A3");
        Person A4 = InfoPersonDirectory.newPerson("A4");
        Person A5 = InfoPersonDirectory.newPerson("A5");
        Person A6 = InfoPersonDirectory.newPerson("A6");
        Person A7 = InfoPersonDirectory.newPerson("A7");
        Person A8 = InfoPersonDirectory.newPerson("A8");
        Person A9 = InfoPersonDirectory.newPerson("A9");
        Person A10 = InfoPersonDirectory.newPerson("A10");



        StudentProfile A1Student = InfoStudentDirectory.newStudentProfile(A1);
        StudentProfile A2Student = InfoStudentDirectory.newStudentProfile(A2);
        StudentProfile A3Student = InfoStudentDirectory.newStudentProfile(A3);
        StudentProfile A4Student = InfoStudentDirectory.newStudentProfile(A4);
        StudentProfile A5Student = InfoStudentDirectory.newStudentProfile(A5);
        StudentProfile A6Student = InfoStudentDirectory.newStudentProfile(A6);
        StudentProfile A7Student = InfoStudentDirectory.newStudentProfile(A7);
        StudentProfile A8Student = InfoStudentDirectory.newStudentProfile(A8);
        StudentProfile A9Student = InfoStudentDirectory.newStudentProfile(A9);
        StudentProfile A10Student = InfoStudentDirectory.newStudentProfile(A10);

        //student for damg program
        Person B1 = damPersonDirectory.newPerson("B1");
        Person B2 = damPersonDirectory.newPerson("B2");
        Person B3 = damPersonDirectory.newPerson("B3");
        Person B4 = damPersonDirectory.newPerson("B4");
        Person B5 = damPersonDirectory.newPerson("B5");
        Person B6 = damPersonDirectory.newPerson("B6");
        Person B7 = damPersonDirectory.newPerson("B7");
        Person B8 = damPersonDirectory.newPerson("B8");
        Person B9 = damPersonDirectory.newPerson("B9");
        Person B10 = damPersonDirectory.newPerson("B10");


        StudentProfile B1Student = damStudentDirectory.newStudentProfile(B1);
        StudentProfile B2Student = damStudentDirectory.newStudentProfile(B2);
        StudentProfile B3Student = damStudentDirectory.newStudentProfile(B3);
        StudentProfile B4Student = damStudentDirectory.newStudentProfile(B4);
        StudentProfile B5Student = damStudentDirectory.newStudentProfile(B5);
        StudentProfile B6Student = damStudentDirectory.newStudentProfile(B6);
        StudentProfile B7Student = damStudentDirectory.newStudentProfile(B7);
        StudentProfile B8Student = damStudentDirectory.newStudentProfile(B8);
        StudentProfile B9Student = damStudentDirectory.newStudentProfile(B9);
        StudentProfile B10Student = damStudentDirectory.newStudentProfile(B10);


        //student for Csye program
        Person C1 = CsyePersonDirectory.newPerson("C1");
        Person C2 = CsyePersonDirectory.newPerson("C2");
        Person C3 = CsyePersonDirectory.newPerson("C3");
        Person C4 = CsyePersonDirectory.newPerson("C4");
        Person C5 = CsyePersonDirectory.newPerson("C5");
        Person C6 = CsyePersonDirectory.newPerson("C6");
        Person C7 = CsyePersonDirectory.newPerson("C7");
        Person C8 = CsyePersonDirectory.newPerson("C8");
        Person C9 = CsyePersonDirectory.newPerson("C9");
        Person C10 = CsyePersonDirectory.newPerson("C10");



        StudentProfile C1Student = CsyeStudentDirectory.newStudentProfile(C1);
        StudentProfile C2Student = CsyeStudentDirectory.newStudentProfile(C2);
        StudentProfile C3Student = CsyeStudentDirectory.newStudentProfile(C3);
        StudentProfile C4Student = CsyeStudentDirectory.newStudentProfile(C4);
        StudentProfile C5Student = CsyeStudentDirectory.newStudentProfile(C5);
        StudentProfile C6Student = CsyeStudentDirectory.newStudentProfile(C6);
        StudentProfile C7Student = CsyeStudentDirectory.newStudentProfile(C7);
        StudentProfile C8Student = CsyeStudentDirectory.newStudentProfile(C8);
        StudentProfile C9Student = CsyeStudentDirectory.newStudentProfile(C9);
        StudentProfile C10Student = CsyeStudentDirectory.newStudentProfile(C10);


        //4.Create Course Schedule
        CourseSchedule InfoSpring2023 = InfoSysDepartment.newCourseSchedule("Spring 2023 Full Semster");
        CourseSchedule damSpring2023 = damgDepartment.newCourseSchedule("Spring 2023 Full Semster");
        CourseSchedule CsyeSpring2023 = CsyeDepartment.newCourseSchedule("Spring 2023 Full Semster");

        //5. Course Offer
        //course offer for Info Program
        CourseOffer Info5100 = InfoSpring2023.newCourseOffer("5100");
        CourseOffer Info5002 = InfoSpring2023.newCourseOffer("5002");
        CourseOffer Info6150 = InfoSpring2023.newCourseOffer("6150");
        
        //course offer for damg Program
        CourseOffer dam6105 = damSpring2023.newCourseOffer("6105");
        CourseOffer dam6210 = damSpring2023.newCourseOffer("6210");
        CourseOffer dam7270 = damSpring2023.newCourseOffer("7275");

        //course offer for Csye Program
        CourseOffer Csye6200 = CsyeSpring2023.newCourseOffer("6200");
        CourseOffer Csye6225 = CsyeSpring2023.newCourseOffer("6225");
        CourseOffer Csye6230 = CsyeSpring2023.newCourseOffer("6230");

        //6. Generate Seats
        //Generate seats for Info Program 
        InfoSpring2023.generateSeatsForCourse("5100", 50);
        InfoSpring2023.generateSeatsForCourse("5002", 25);
        InfoSpring2023.generateSeatsForCourse("6150", 50);

        damSpring2023.generateSeatsForCourse("6105", 20);
        damSpring2023.generateSeatsForCourse("6210", 40);
        damSpring2023.generateSeatsForCourse("7275", 20);

        CsyeSpring2023.generateSeatsForCourse("6200", 30);
        CsyeSpring2023.generateSeatsForCourse("6225", 20);
        CsyeSpring2023.generateSeatsForCourse("6230", 40);


        //7. Assign Faculty
    

        InfoSpring2023.assignAsTeacher("5100",ArchillTA);
        InfoSpring2023.assignAsTeacher("5002",BenjaminProf);
        InfoSpring2023.assignAsTeacher("6150", IsmatwereTA);


        damSpring2023.assignAsTeacher("6105", GalricgechTA);
        damSpring2023.assignAsTeacher("6210", ErickTA);
        damSpring2023.assignAsTeacher("7275", DannielProf);


        CsyeSpring2023.assignAsTeacher("6200", CammellaProf);
        CsyeSpring2023.assignAsTeacher("6225", FarremickTA);
        CsyeSpring2023.assignAsTeacher("6230", HadesTA);



        //8.Register for courses(Different students register different courses)
        InfoSysDepartment.RegisterForAClass("A1", "5100", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A1", "6150", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A1", "5002", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A2", "5100", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A2", "5002", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A3", "5100", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A3", "6150", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A4", "5100", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A5", "6150", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A5", "5002", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A6", "6150", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A8", "5002", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A9", "5002", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A9", "5100", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A10", "5002", "Spring 2023 Full Semster");
        InfoSysDepartment.RegisterForAClass("A10", "6150", "Spring 2023 Full Semster");



        damgDepartment.RegisterForAClass("B1", "6210", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B1", "7275", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B1", "6105", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B2", "6210", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B2", "6105", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B3", "7275", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B4", "6105", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B4", "7275", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B5", "7275", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B6", "6210", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B7", "6105", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B7", "7275", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B8", "6105", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B8", "6210", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B9", "6105", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B9", "7275", "Spring 2023 Full Semster");
        damgDepartment.RegisterForAClass("B9", "6210", "Spring 2023 Full Semster");



        CsyeDepartment.RegisterForAClass("C1", "6200", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C1", "6225", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C2", "6230", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C3", "6200", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C3", "6225", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C4", "6225", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C5", "6225", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C6", "6225", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C6", "6200", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C6", "6230", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C7", "6200", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C7", "6200", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C8", "6200", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C9", "6225", "Spring 2023 Full Semster");
        CsyeDepartment.RegisterForAClass("C10", "6200", "Spring 2023 Full Semster");


        NEU_coe_college.printCollegeInformation();

        //9.Calculate Revenue
        System.out.println("------------------------Calculate Revenues for Department-------------------------");
        int totalRevenue = NEU_coe_college.calculateRevenuesDepartmentBySemester("Spring 2023 Full Semster");
        System.out.println("-------------------------");
        System.out.println("Total Revenue for the college: " + totalRevenue);



        
        //CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        //if (courseoffer==null)return;
        //courseoffer.generatSeats(10);
        //PersonDirectory pd = department.getPersonDirectory();
        //Person person = pd.newPerson("0112303");
        //StudentDirectory sd = department.getStudentDirectory();
        //StudentProfile student = sd.newStudentProfile(person);
        //CourseLoad courseload = student.newCourseLoad("Fall2020");         
        //courseload.newSeatAssignment(courseoffer); //register student in class
        
        //int total = department.calculateRevenuesBySemester("Fall2020");
        //System.out.print("Total: " + total);

    }

}
