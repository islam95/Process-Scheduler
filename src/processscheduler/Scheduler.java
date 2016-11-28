/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author islam
 */
public class Scheduler {

    private List<Process> queue;

    public Scheduler() {
        queue = new ArrayList<Process>();
    }

    public void DescendingOrder() {
        Collections.sort(queue);
        
    }
    
    public void scheduleNext(){
        
        Process p = queue.get(0);
        p.schedule();
        queue.remove(p);
        
        if(p.getTimeRemaining() > 0){
            queue.add(p);
        }
     
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public int getSize(){
        return queue.size();
    }

    public void addProcess(Process p) {
        queue.add(p);
    }

    public String toString() {
        String str = "";
        for (Process process : queue) {
            str += process + "\n";
        }
        return str;

    }
}
