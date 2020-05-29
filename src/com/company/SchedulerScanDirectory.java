package com.company;

import com.company.Service.AllScanner;

import java.util.TimerTask;


public class SchedulerScanDirectory extends TimerTask{
    @Override
    public void run() {
        AllScanner scan = new AllScanner();
        scan.run();
        System.out.println("START JOB!");
    }


}
