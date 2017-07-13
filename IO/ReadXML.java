/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package IO;

import ProcessedData.TimeChunk;
import XMLData.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class ReadXML {

    public static ArrayList<XMLCourse> readCourseXML(String file) throws IOException {
        int semester = 0, id, instructor=0;
        String name, size;
        ArrayList<XMLCourse> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                if (line.contains("semester") && (!line.contains("/"))) {
                    semester = line.charAt(line.length() - 3)-48;
                }
                if (line.contains("size")) {
                    id = Integer.parseInt(line.substring(line.indexOf("id") + 10, line.indexOf("name") - 2));
                    name = line.substring(line.indexOf("name") + 6, line.indexOf("instructor") - 2);
                    instructor = Integer.parseInt(line.substring(line.indexOf("instructorId") + 14, line.indexOf("size") - 2));
                    size = line.substring(line.indexOf("size") + 6, line.indexOf(">") - 2);
                    courses.add(new XMLCourse(id, semester, instructor, name, size));
                }
            }         
        }
        return courses;
    }

    public static ArrayList<XMLSlot> readSlotXML(String file) throws IOException {
        int id, time;
        String day = null, roomid;
        ArrayList<XMLSlot> slots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                if (line.contains("day") && (!line.contains("/"))) {
                    day = line.substring(line.indexOf("=") + 2, line.indexOf(">") - 1);
                }
                if (line.contains("slot id")) {
                    id = Integer.parseInt(line.substring(line.indexOf("slot")+13, line.indexOf("room") - 2));
                    time = Integer.parseInt(line.substring(line.indexOf("startTime") + 11, line.indexOf(">") - 2));
                    roomid = line.substring(line.indexOf("roomId") + 8, line.indexOf("start") - 2);
                    slots.add(new XMLSlot(id, time, roomid, day));
                }
            }
        }
        return slots;
    }

    public static ArrayList<XMLRoom> readRoomXML(String file) throws IOException {
        String id, name, size;
        ArrayList<XMLRoom> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                if (line.contains("id")) {
                    id = (line.substring(line.indexOf("id") + 4, line.indexOf("name") - 2));
                    name = line.substring(line.indexOf("name") + 6, line.indexOf("size") - 2);
                    size = line.substring(line.indexOf("size") + 6, line.indexOf("/") - 1);
                    rooms.add(new XMLRoom(id, name, size));
                }
            }
        }
        return rooms;
    }

    public static ArrayList<XMLInstructor> readInstructorXML(String file) throws IOException {
        int id=0,time;
        String name = null,day;
        ArrayList<TimeChunk> times = new ArrayList<>();
        ArrayList<XMLInstructor> instructors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                if (line.contains("id") && (!line.contains("/"))) {
                    if (id!=0){
                        instructors.add(new XMLInstructor(id,name,times));
                    }
                    id = Integer.parseInt(line.substring(line.indexOf("id") + 4, line.indexOf("name") - 2));
                    
                    name = line.substring(line.indexOf("name") + 6, line.indexOf(">") - 1);
                    times.clear();
                }
                if (line.contains("day")) {
                    day = line.substring(line.indexOf("day=")+5,line.indexOf("start")-2);
                    time = Integer.parseInt(line.substring(line.indexOf("startTime=")+11,line.indexOf("/")-1));
                    times.add(new TimeChunk(day,time));
                }
            }
        }
        return instructors;
    }
}
