/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package IO;

import ProcessedData.AcademicWeek;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author joni
 */
public class WriteTXT {

    public static void writeScheduleTXT(AcademicWeek a, String file) throws FileNotFoundException, IOException {
        File fout = new File(file);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ - ΩΡΟΛΟΓΙΟ ΠΡΟΓΡΑΜΜΑ ΜΑΘΗΜΑΤΩΝ");
        bw.newLine();
        bw.newLine();
        int semester = 1;
        while (semester <= 8) {
            bw.write(semester + "o εξάμηνο");
            bw.newLine();
            int i = 0, j = 0, z = 0;
            while (i < 5) {
                bw.write(dayIntToGRE(i));
                bw.newLine();
                while (j < 5) {
                    while (z < 10) {
                        if (a.courses[i][j][z] != null) {
                            if (a.courses[i][j][z].getSemester() == semester) {
                                bw.write(a.slots[i][j][z].getTimeChunk().getTime()+":00-"+(a.slots[i][j][z].getTimeChunk().getTime()+2)+":00 ("+a.slots[i][j][z].getRoomId()+") "+a.courses[i][j][z].getName()+" ("+a.courses[i][j][z].getInstructorName()+")");
                                bw.newLine();
                            }
                        }
                        z++;
                    }
                    j++;
                    z = 0;
                }
                i++;
                j = 0;
                z = 0;
            }

            semester++;
            semester++;
        }
        bw.close();
    }

    private static String dayIntToGRE(int day) {
        switch (day) {
            case 0:
                return "Δευτέρα";
            case 1:
                return "Τρίτη";
            case 2:
                return "Τετάρτη";
            case 3:
                return "Πέμπτη";
            default:
                return "Παρασκευή";
        }

    }
}
