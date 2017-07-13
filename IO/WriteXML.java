/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package IO;

import ProcessedData.AcademicWeek;
import ProcessedData.CourseCandidate;
import ProcessedData.Slot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class WriteXML {

    public static void writeScheduleXML(AcademicWeek a, String file) throws IOException {
        File fout = new File(file);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
        bw.newLine();
        bw.write("<scheduledCourses>");
        bw.newLine();
        int semester = 1;
        while (semester <= 8) {
            bw.write("  <semester semesterId=\"semester" + semester + "\">");
            bw.newLine();
            ArrayList<CourseCandidate> cand = new ArrayList<>();
            boolean newcourse = true;
            int i = 0, j = 0, z = 0;
            while (i < 5) {
                while (j < 5) {
                    while (z < 10) {
                        if (a.courses[i][j][z] != null) {
                            if (a.courses[i][j][z].getSemester() == semester) {
                                for (CourseCandidate c : cand) {
                                    if (c.getCourse() == a.courses[i][j][z]) {
                                        c.addSlot(a.slots[i][j][z]);
                                        newcourse = false;
                                    }
                                }
                                if (newcourse) {
                                    ArrayList<Slot> s = new ArrayList<>();
                                    s.add(a.slots[i][j][z]);
                                    cand.add(new CourseCandidate(a.courses[i][j][z], s));
                                }
                            }
                            
                        }
                        newcourse = true;
                        z++;
                    }
                    j++;
                    z = 0;
                }
                i++;
                j = 0;
                z = 0;
            }
            for (CourseCandidate c : cand) {
                bw.write("    <scheduledCourse courseId=\"course" + c.getCourse().getId() + "\" slotId1=\"slot" + c.getSlots().get(0).getId() + "\" slotId2=\"slot" + c.getSlots().get(1).getId() + "\" /> ");
                bw.newLine();
            }
            semester++;
            semester++;
            bw.write("  </semester>");
            bw.newLine();
        }
        bw.write("</scheduledCourses>");
        bw.close();
    }
}
