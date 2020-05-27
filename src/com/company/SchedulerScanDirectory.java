package com.company;

import com.company.Service.DirectoryScanner;
import java.util.TimerTask;


public class SchedulerScanDirectory extends TimerTask{
    public static String catalog = FileSettings.GetPatch();
    DirectoryScanner scanner = new DirectoryScanner();

    @Override
    public void run() {
        scanner.scan(catalog);
        System.out.println("START JOB!");
    }


}
