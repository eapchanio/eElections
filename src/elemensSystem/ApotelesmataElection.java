/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemensSystem;

import java.util.HashMap;
import java.util.Map;

public class ApotelesmataElection extends HashMap{
    private String name;
    public ApotelesmataElection() {
        super();
    }
    public ApotelesmataElection(String name) {
        super();
        this.name = name;
    }
    //Αντιγράφει τη λίστα m στην τρέχουσα λίστα
    public ApotelesmataElection(String name, Map m) {
        super(m);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
