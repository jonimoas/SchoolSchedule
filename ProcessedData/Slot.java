/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MOYSIDIS IOANNIS STYLIANOS 3090142
package ProcessedData;

/**
 *
 * @author joni
 */
public class Slot {

    private TimeChunk chunk;
    private int id;
    private String roomsize, roomid;

    public Slot() {
    }

    public boolean fromSlotsXML(String day, int time, String roomid, int id) {
        this.chunk = new TimeChunk(day, time);
        this.roomid = roomid;
        this.id = id;
        return true;
    }

    public boolean fromRoomsXML(String id, String name, String size) {
        if (id.equals(this.roomid)) {
            this.roomsize = size;
            return true;
        }
        return false;
    }

    public TimeChunk getTimeChunk() {
        return chunk;
    }
    public String getSize(){
        return roomsize;
    }
    public String getRoomId(){
        return roomid;
    }
    public int getId(){
        return id;
    }
}
