
package processscheduler;

import java.util.Random;

/**
 *
 * @author islam
 * @since November 9, 2013
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random generator = new Random();
        Scheduler queue = new Scheduler();
        
        for (int processID = 0; processID < 5; processID++) {
            
            double random = generator.nextDouble() * 5.0;
            double time = Math.round(random * 100.00) / 100.00;
            
            Process process = new Process(processID, time);
            queue.addProcess(process);
        }

        
        System.out.println("------------------------------------------------");
        System.out.println(queue);
        
//        queue.DescendingOrder();
//        System.out.println(queue);

        
        while(!queue.isEmpty()){    
            System.out.println("------------------------------------------------");
            queue.scheduleNext();
            System.out.println(queue);
        }
        System.out.println("Empty Queue!");
    }
}
