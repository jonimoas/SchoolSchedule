/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import ProcessedData.AcademicWeek;
import ProcessedData.Course;
import ProcessedData.Slot;
import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class Scan {

    private final ArrayList<Slot> eligible = new ArrayList<>();
    private final AcademicWeek given;
    private final Course c;

    public Scan(AcademicWeek d, Course c) {//8ewrw ola ta slots eligible
        given = d;
        int i = 0, j = 0, z = 0;
        while (i < 5) {
            while (j < 5) {
                while (z < 10) {
                    if (given.slots[i][j][z] != null) {
                        eligible.add(given.slots[i][j][z]);
                    }
                    z++;
                }
                j++;
                z = 0;
            }
            i++;
            z = 0;
            j = 0;
        }
        this.c = c;
    }

    public void scantutor() {//afairw apta 
        //eligible afta sta opoia den borei o didaskontas
        ArrayList<Slot> remove = new ArrayList<>();
        for (Slot s : eligible) {
            if (c.getUnavailable().contains(s.getTimeChunk())) {
                remove.add(s);
            }
        }
        for (Slot s : remove) {
            eligible.remove(s);
        }

    }

    public void scanroomsize() {//afairw apta eligible 
        //afta pou den exoun katalili xwritikotita, 8ewrontas oti ma8hmata pou
        //apaitoun medium ai8ousa didaskontai kai se large
        int i = 0;
        while (i < eligible.size()) {
            Slot s = eligible.get(i);
            if (!(s.getSize().equals(c.getSize())) && "large".equals(c.getSize())) {
                eligible.remove(s);
            }
            i++;
        }
    }

    public void scansemester() {
        //an didasketai allo ma8hma idiou eksamhnou tin idia wra se allh ai8ousa
        //tote to sigekrimeno slot vgainei apta eligible
        ArrayList<Slot> remove = new ArrayList<>();
        for (Slot s : eligible) {
            int i = 0;
            Course taught[] = given.getTimeStamp(s);
            while (i < 10) {
                if (taught[i] != null) {
                    if (c.getSemester() == taught[i].getSemester()) {
                        remove.add(s);
                        i = 10;
                    }
                }
                i++;
            }
        }
        for (Slot s : remove) {
            eligible.remove(s);
        }
    }

    public void scanfull() {
        //afairw apta eligible ola ta slots sta opoia
        //hdh didasketai kati allo
        ArrayList<Slot> remove = new ArrayList<>();
        for (Slot s : eligible) {
            if (given.slotfull(s, c)) {
                remove.add(s);
            }
        }
        for (Slot s : remove) {
            eligible.remove(s);
        }
    }

    public void scaninstructor() {
        //an didasketai allo ma8hma idiou didaskontos tin idia wra se allh ai8ousa
        //tote to sigekrimeno slot vgainei apta eligible
        ArrayList<Slot> remove = new ArrayList<>();
        for (Slot s : eligible) {
            int i = 0;
            while (i < 10) {
                if (given.getTimeStamp(s)[i] != null) {
                    if (c.getInstructorId() == given.getTimeStamp(s)[i].getInstructorId()) {
                        remove.add(s);
                        i = 10;
                    }
                }
                i++;
            }
        }
        for (Slot s : remove) {
            eligible.remove(s);
        }
    }

    public void scanlessonid() {
        //an didasketai to idio ma8hma thn idia mera, tote to slot afaireitai
        //apta eligible
        ArrayList<Slot> remove = new ArrayList<>();
        for (Slot s : eligible) {
            int i = 0, j = 0;
            Course taught[][] = given.getDayStamp(s);
            while (i < 10) {
                while (j < 10) {
                    if (taught[i][j] != null) {
                        if (c.getId() == taught[i][j].getId()) {
                            remove.add(s);
                            i = 10;
                            j = 10;
                        }
                    }
                    j++;
                }
                i++;
            }
        }
        for (Slot s : remove) {
            eligible.remove(s);
        }
    }

    public ArrayList<Slot> getEligible() {
        return eligible;
    }
}
