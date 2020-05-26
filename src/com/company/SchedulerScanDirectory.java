package com.company;
import java.util.Timer;
import java.util.TimerTask;
//todo schedule something
public class SchedulerScanDirectory {
    Timer timer;

    public SchedulerScanDirectory(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("times up");
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String[] args) {
        new SchedulerScanDirectory(3000);
        System.out.println("Task scheduled");
    }

}
