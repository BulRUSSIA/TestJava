package com.company;

import java.util.Timer;
//todo сделать сканирование подкаталогов
public class Main {

    public  static void main(String[] args) {
        final int schedule_time = 3000;// 5 minutes
        Timer timer = new Timer();
        timer.schedule(new SchedulerScanDirectory(), 0, schedule_time);
    }
}

