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
public class CourseCandidate implements Comparable<Object> {

    private Course c;
    private ArrayList<Slot> s;

    public CourseCandidate(Course c, ArrayList<Slot> s) {
        this.c = c;
        this.s = s;
    }

    public Course getCourse() {
        return c;
    }

    public ArrayList<Slot> getSlots() {
        return s;
    }
    public void setSlots(ArrayList<Slot> a){
        this.s = a;
    }
    public void addSlot(Slot s){
        this.s.add(s);
    }

    @Override
    public int compareTo(Object o) {
        CourseCandidate a = (CourseCandidate) o;
        if (a.getSlots().size() == this.s.size()) {
            return 0;
        }
        if (a.getSlots().size() > this.s.size()) {
            return -1;
        }
        return 1;
    }
}
