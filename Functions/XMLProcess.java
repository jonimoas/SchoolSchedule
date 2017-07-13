/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package Functions;

import ProcessedData.Course;
import ProcessedData.Slot;
import XMLData.XMLCourse;
import XMLData.XMLInstructor;
import XMLData.XMLRoom;
import XMLData.XMLSlot;
import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class XMLProcess {

    public static ArrayList<Slot> Slot(ArrayList<XMLSlot> slots, ArrayList<XMLRoom> rooms) {
        ArrayList<Slot> result = new ArrayList<>();
        for (XMLSlot s : slots) {
            Slot e = new Slot();
            e.fromSlotsXML(s.getDay(), s.getTime(), s.getRoom(), s.getId());
            for (XMLRoom r : rooms) {
                if (r.getId().equals(e.getRoomId())) {
                    e.fromRoomsXML(r.getId(), r.getName(), r.getSize());
                }
            }
            result.add(e);
        }
        return result;
    }

    public static ArrayList<Course> Course(ArrayList<XMLCourse> courses, ArrayList<XMLInstructor> instructors) {
        ArrayList<Course> result = new ArrayList<>();
        
        for (XMLCourse c : courses) {

            Course e = new Course();
            e.fromCoursesXML(c.getId(), c.getName(), c.getInstructor(), c.getSize(), c.getSemester());
            for (XMLInstructor i : instructors) {
                if (i.getId() == e.getInstructorId()) {
                    e.fromInstructorsXML(i.getId(), i.getName(), i.getUnavailable());
                }
            }
            result.add(e);
            
        }
        return result;
    }
}
