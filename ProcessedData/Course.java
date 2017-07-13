
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package ProcessedData;

import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class Course {

    private int semester, id, instructorid;
    private String name, instructorname, sizerequire;
    private ArrayList<TimeChunk> unavailable= new ArrayList<>();

    public Course() {
    }

    public boolean fromCoursesXML(int id, String name, int instructor, String size, int semester) {
        this.name = name;
        this.id = id;
        this.instructorid = instructor;
        this.sizerequire = size;
        this.semester = semester;
        return true;
    }

    public boolean fromInstructorsXML(int id, String name, ArrayList<TimeChunk> day) {
        if (id == this.instructorid) {
            this.instructorname = name;
            this.unavailable = day;
            return true;
        }
        return false;
    }
    public String getInstructorName(){
        return instructorname;
    }
    public int getSemester(){
        return semester;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public ArrayList<TimeChunk> getUnavailable(){
        return unavailable;
    }
    public String getSize(){
        return sizerequire;
    }
    
    public int getInstructorId(){
        return instructorid;
    }
}
