/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package XMLData;

import ProcessedData.TimeChunk;
import java.util.ArrayList;

/**
 *
 * @author joni
 */
public class XMLInstructor {
    int id;
    String name;
    ArrayList<TimeChunk> unavailable;
    public XMLInstructor(int id,String name,ArrayList<TimeChunk> unavailable){
        this.id = id;
        this.name = name;
        this.unavailable = unavailable;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public ArrayList<TimeChunk> getUnavailable(){
        return unavailable;
    }
}
