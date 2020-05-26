package com.company.Service;
import java.io.File;
import java.util.Objects;

//todo Сканирование и нахождение файлов
public class ScanDirectory {

    public String scan(String directory) {
        File dir = new File(directory);
        if(dir.isDirectory())

        {
            // получаем все вложенные объекты в каталоге
            for(File item : Objects.requireNonNull(dir.listFiles())){
                if(item.isDirectory()){

                    System.out.println(item.getName() + "  \t folder");

                }
                else
                    {
                    System.out.println(item.getName() + "\t file");
                }
            }
        }
        return directory;
    }

}
