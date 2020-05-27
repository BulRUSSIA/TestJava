package com.company.Service;

import com.company.Models.FileExtensions;

import java.io.File;
import java.util.Objects;

//todo Сканирование и нахождение файлов
public class DirectoryScanner {
    public String scan(String directory) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \t folder");
                } else {
                    System.out.println(item.getName() + "\t file");
                    String ext = getFileExtension(item);

                }
            }
        }
        return directory;
    }

    private FileExtensions asMyEnum(String filename) {
        for (FileExtensions me : FileExtensions.values()) {
            if (me.name().equalsIgnoreCase(filename))
                return me;
        }
        return null;
    }


    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }

}
