//MOYSIDIS IOANNIS STYLIANOS 3090142
package Main;

import IO.ReadXML;
import java.io.IOException;
import java.util.ArrayList;
import Functions.XMLProcess;
import IO.WriteTXT;
import IO.WriteXML;
import ProcessedData.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joni
 */
public class ProgramMathimatwn {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter location of files:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Slot> slots = XMLProcess.Slot(ReadXML.readSlotXML(input + "slots.xml"), ReadXML.readRoomXML(input + "rooms.xml"));
        ArrayList<Course> courses = XMLProcess.Course(ReadXML.readCourseXML(input + "courses.xml"), ReadXML.readInstructorXML(input + "instructors.xml"));
        AcademicWeek a = Functions.Build.init(courses, slots);
        WriteXML.writeScheduleXML(a, input + "schedule.xml");
        WriteTXT.writeScheduleTXT(a, input + "table.txt");
    }
}
