package com.company;

import java.util.Timer;

public class Main {

    public  static void main(String[] args) {
        final int schedule_time = 300000;// 5 minutes
        Timer timer = new Timer();
        timer.schedule(new SchedulerScanDirectory(), 0, schedule_time);
    }
}

