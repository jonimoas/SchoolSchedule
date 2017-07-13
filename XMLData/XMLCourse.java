/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package XMLData;

/**
 *
 * @author joni
 */
public class XMLCourse {
    int id,semester,instructor;
    String name,size;
    public XMLCourse(int id,int semester,int instructor,String name,String size){
        this.id = id;
        this.semester = semester;
        this.instructor = instructor;
        this.name = name;
        this.size = size;
    }
    public int getId(){
        return id;
    }
    public int getSemester(){
        return semester;
    }
    public int getInstructor(){
       return instructor; 
    }
    public String getName(){
        return name;
    }
    public String getSize(){
        return size;
    }
}
