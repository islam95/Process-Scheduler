/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduler;

import java.text.DecimalFormat;

/**
 *
 * @author islam
 */

public class Process implements Comparable<Process> {

    private int processID;
    private double timeRequired;
    private double timeRemaining;
    

    public Process(int process, double timeRem) {
        processID = process;
        timeRemaining = timeRem;
    }

    public int getProcessID() {
        return processID;
    }

    public double getTimeReq() {
        return timeRequired;
    }

    public double getTimeRemaining() {
        return timeRemaining;
    }

    public boolean schedule() {

        double rem = timeRemaining;
        
        while(timeRemaining > 0){
            if(rem < 0.4){
                timeRemaining = rem - timeRemaining;
                timeRemaining = Math.round(timeRemaining * 100.0) / 100.0;
            }
            else{
            timeRemaining = rem - 0.4;
            timeRemaining = Math.round(timeRemaining * 100.0) / 100.0;
            return false;
            }
        }
        return true;
    }

    public void setProcessID(int process) {
        processID = process;
    }

    public void setTimeReq(double timeReq) {
        timeRequired = timeReq;
    }

    public void setTimeRem(double timeRem) {
        timeRemaining = timeRem;
    }

    @Override
    public int compareTo(Process timeReq) {

        double time1 = this.getTimeReq();
        double time2 = timeReq.getTimeReq();

        if (time1 > time2) {
            return 1;
        } else if (time1 < time2) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {

        return "Process ID: " + processID
                + "  requires: " + timeRemaining + "s";
    }
}
