package com.company;
import com.company.Service.DirectoryScanner;

import java.util.Timer;
import java.util.TimerTask;
//todo schedule something
public class SchedulerScanDirectory {
    public String catalog = "C:\\Users\\Professional\\IdeaProjects\\TestProj\\";
    Timer timer;
    DirectoryScanner scanner;
    public SchedulerScanDirectory(int seconds) {
        scanner = new DirectoryScanner();
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            scanner.scan(catalog);
            System.out.println("times up");
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String[] args) {
        new SchedulerScanDirectory(3);
        System.out.println("Task scheduled");
    }

}
