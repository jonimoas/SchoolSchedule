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
public class XMLRoom {
    String id,name,size;
    public XMLRoom(String id,String name,String size){
        this.id = id;
        this.name = name;
        this.size = size;
    }
    public String getSize(){
        return size;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
}
