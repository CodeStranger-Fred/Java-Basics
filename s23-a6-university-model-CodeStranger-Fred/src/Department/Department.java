/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Degree.Degree;
import Employer.EmployerDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    Degree degree;

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n,String degreeName) {
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory = new FacultyDirectory(this);
        degree = new Degree(degreeName);
        
    }
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
    }
    public void addElectiveCourse(Course c){
        degree.addElectiveCourse(c);
        
    }
    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);
        if (css == null){
            System.out.println("Revenue for "+ name + ": 0 since there is no course schedule for "+ semester);
            return 0;
        }
        int revenue = css.calculateTotalRevenues();
        System.out.println("Revenue for "+ name +  ": " + revenue);

        return revenue;

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);
        if (sp==null) {
            System.out.println("Student with id" + studentid + "was not found");
            return;
        }

        CourseSchedule cs = mastercoursecatalog.get(semester);
        if (cs == null){
            System.out.println("This is not schedule for " + semester + " Please add a course schedule first.");
            return;
        }

        CourseOffer co = cs.getCourseOfferByNumber(cn);
        if (co == null){
            System.out.println("There is no such course in " + semester);
            return;
        }

        CourseLoad cl = sp.getCurrentCourseLoad();
        if (cl == null){
            //System.out.println("This is first time student is registering... creating new section in transcript");
            cl = sp.newCourseLoad(semester);
        }

        SeatAssignment sa = co.assignEmptySeat(cl);
        if (sa == null){
            System.out.println("Unfortunately, there were no empty seats.");
            return;
        }

        //System.out.println("Congrats, You are registered for" + co.getCourseNumber());

    }

    public void PrintDepartmentInfo(){
        System.out.println("===============");
        System.out.println("Department:" + name);
        degree.DegreeInfo();
        System.out.println("----------------");
        coursecatalog.CourseInfo();
        System.out.println("----------------");
        printMasterCourseCatalog();
        System.out.println("-----------------");
        studentdirectory.printStudents();
    }

    private void printMasterCourseCatalog(){
        System.out.println("List of Semster:");
        for (String semster: mastercoursecatalog.keySet()){
            System.out.println(semster);
            mastercoursecatalog.get(semster).PrintScheduleInfo();
        }
    }

}
