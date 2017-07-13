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
public class XMLSlot {
    private final int id,time;
    private final String room,day;
    public XMLSlot(int id,int time,String room,String day){
        this.id = id;
        this.time = time;
        this.room = room;
        this.day = day;
    }
    public int getId(){
        return id;
    }
    public int getTime(){
        return time;
    }
    public String getRoom(){
        return room;
    }
    public String getDay(){
        return day;
    }
}
