/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package Functions;

import ProcessedData.AcademicWeek;
import ProcessedData.CourseCandidate;
import ProcessedData.Course;
import ProcessedData.Slot;
import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class Build {

    static AcademicWeek a;
    static ArrayList<CourseCandidate> cand = new ArrayList<>();
    static ArrayList<CourseCandidate> skipped = new ArrayList<>();

    public static AcademicWeek init(ArrayList<Course> courses, ArrayList<Slot> slots) {

        a = new AcademicWeek(slots);
        ArrayList<Course> DoubleCourses = new ArrayList<>();
        for (Course c : courses){
            DoubleCourses.add(c);
        }
        for (Course c : courses){
            DoubleCourses.add(c);
        }
        for (Course b : DoubleCourses) {
            Scan s = new Scan(a, b);
            CourseCandidate cc = new CourseCandidate(b, s.getEligible());
            cand.add(cc);
        }
        cand = InsertionSort.InsertionSort(cand);
        AllConstrains();
        return a;
    }

    private static void AllConstrains() {

        for (CourseCandidate b : cand) {
            Scan s = new Scan(a, b.getCourse());
            s.scanroomsize();
            s.scantutor();
            s.scaninstructor();
            s.scanfull();
            s.scanlessonid();
            s.scansemester();
            b.setSlots(s.getEligible());
            if (!b.getSlots().isEmpty()) {
                a.addCourse(b.getSlots().get(0), b.getCourse());
            } else {
                skipped.add(b);
            }
        }
        cand.clear();
        skipped = InsertionSort.InsertionSort(skipped);
        Noteacherhours();
    }

    private static void Noteacherhours() {
        for (CourseCandidate b : skipped) {
            Scan s = new Scan(a, b.getCourse());
            s.scanroomsize();
            s.scaninstructor();
            s.scanfull();
            s.scanlessonid();
            s.scansemester();
            b.setSlots(s.getEligible());
            if (!b.getSlots().isEmpty()) {
                a.addCourse(b.getSlots().get(0), b.getCourse());
            } else {
                cand.add(b);
            }
        }
        skipped.clear();
        cand = InsertionSort.InsertionSort(cand);
        Nodifferentdaysaweek();
    }

    private static void Nodifferentdaysaweek() {
        for (CourseCandidate b : cand) {
            Scan s = new Scan(a, b.getCourse());
            s.scanroomsize();
            s.scaninstructor();
            s.scanfull();
            s.scansemester();
            b.setSlots(s.getEligible());
            if (!b.getSlots().isEmpty()) {
                a.addCourse(b.getSlots().get(0), b.getCourse());
            } else {
                skipped.add(b);
            }
        }
        cand.clear();
        skipped = InsertionSort.InsertionSort(skipped);
        Norooms();
    }

    private static void Norooms() {
        for (CourseCandidate b : skipped) {
            Scan s = new Scan(a, b.getCourse());
            s.scaninstructor();
            s.scanfull();
            s.scansemester();
            b.setSlots(s.getEligible());
            if (!b.getSlots().isEmpty()) {
                a.addCourse(b.getSlots().get(0), b.getCourse());
            } else {
                cand.add(b);
            }
        }
        skipped.clear();
        cand = InsertionSort.InsertionSort(cand);
        NoSemester();
    }

    private static void NoSemester() {
        for (CourseCandidate b : cand) {
            Scan s = new Scan(a, b.getCourse());
            s.scaninstructor();
            s.scanfull();
            b.setSlots(s.getEligible());

            if (!b.getSlots().isEmpty()) {
                a.addCourse(b.getSlots().get(0), b.getCourse());
            } else {
                skipped.add(b);
            }
        }
        cand.clear();
        skipped = InsertionSort.InsertionSort(skipped);
        NoSameinstructor();
    }

    private static void NoSameinstructor() {
        for (CourseCandidate b : skipped) {
            Scan s = new Scan(a, b.getCourse());
            s.scanfull();
            CourseCandidate toAdd = b;
            toAdd.setSlots(s.getEligible());
            if (!toAdd.getSlots().isEmpty()) {
                a.addCourse(toAdd.getSlots().get(0), toAdd.getCourse());
            } else {
                cand.add(b);
            }
        }
        skipped.clear();
    }

}
