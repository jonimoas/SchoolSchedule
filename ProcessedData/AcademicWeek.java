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
public class AcademicWeek {
    //[day][time][room]

    public Course[][][] courses = new Course[5][5][10];
    public Slot[][][] slots = new Slot[5][5][10];

    public AcademicWeek(ArrayList<Slot> s) {
        int i = 0, j = 0, z = 0;
        while (i < 5) {
            while (j < 5) {
                while (z < 10) {
                    slots[i][j][z] = null;
                    courses[i][j][z] = null;
                    z++;
                }
                j++;
                z = 0;
            }
            i++;
            j = 0;
            z = 0;
        }
        for (Slot slot : s) {
            addSlot(slot);
        }
    }

    private int roomconversion(String id) {
        switch (id) {
            case "A24":
                return 0;
            case "A25":
                return 1;
            case "A32":
                return 2;
            case "D12":
                return 3;
            case "D23":
                return 4;
            case "D21":
                return 5;
            case "AD":
                return 6;
            case "B":
                return 7;
            case "DO":
                return 8;
            default:
                return 9;
        }
    }

    private int timeconversion(int i) {
        switch (i) {
            case 9:
                return 0;
            case 11:
                return 1;
            case 13:
                return 2;
            case 15:
                return 3;
            default:
                return 4;
        }
    }

    private int dayconversion(String day) {
        switch (day) {
            case "Monday":
                return 0;
            case "Tuesday":
                return 1;
            case "Wednesday":
                return 2;
            case "Thursday":
                return 3;
            default:
                return 4;
        }
    }

    private void addSlot(Slot s) {
        TimeChunk d = s.getTimeChunk();
        this.slots[dayconversion(d.getName())][timeconversion(d.getTime())][roomconversion(s.getRoomId())] = s;
    }

    public void addCourse(Slot s, Course c) {
        TimeChunk d = s.getTimeChunk();
        this.courses[dayconversion(d.getName())][timeconversion(d.getTime())][roomconversion(s.getRoomId())] = c;
    }
    public boolean slotfull(Slot s,Course c){
        TimeChunk d = s.getTimeChunk();
        if (this.courses[dayconversion(d.getName())][timeconversion(d.getTime())][roomconversion(s.getRoomId())]==null){
            return false;
        }
        return true;
    }

    public Course getCourse(Slot s) {
        //ti ginetai se mia ai8ousa mia sigekrimeni xroniki stigmi
        TimeChunk d = s.getTimeChunk();
        return this.courses[dayconversion(d.getName())][timeconversion(d.getTime())][roomconversion(s.getRoomId())];
    }

    public Course[] getTimeStamp(Slot s) {
        //ti ginetai mia sigekrimeni xroniki stigmi se oles tis ai8ouses
        TimeChunk d = s.getTimeChunk();
        return this.courses[dayconversion(d.getName())][timeconversion(d.getTime())];
    }

    public Course[][] getDayStamp(Slot s) {
        //ti ginetai se mia mera se oles tis ai8ouses oles tis wres
        TimeChunk d = s.getTimeChunk();
        return this.courses[dayconversion(d.getName())];
    }


}
