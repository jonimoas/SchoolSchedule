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
public class TimeChunk {
    
    private final String name;
    private final int time;
    
    public TimeChunk(String name, int time) {
        this.name = name;
        this.time = time;
    }
    

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }
}
