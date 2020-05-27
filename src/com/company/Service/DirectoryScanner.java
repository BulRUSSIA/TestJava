package com.company.Service;

import com.company.Models.FileExtensions;
import java.io.File;
import java.util.Objects;

//todo Сканирование и нахождение файлов
public class DirectoryScanner {

    FileConverter fileconverter;

    public DirectoryScanner() {
        fileconverter = new FileConverter();
    }
    public void scan(String directory) {

        try {
            File dir = new File(directory);
            //todo проверять все вложенные каталоги
            if (dir.isDirectory()) {
                // получаем все вложенные объекты в каталоге
                for (File item : Objects.requireNonNull(dir.listFiles())) {
                    if (item.isDirectory()) {
                        System.out.println(item.getName() + "  \t folder");

                    } else {
                        String ext = getFileExtension(item);
                        FileExtensions found_ext = asMyEnum(ext);
                        if (found_ext != null) {
                            System.out.println("find enum\t" + found_ext);
                            switch (found_ext) {
                                case PDF:
                                    fileconverter.Convert(directory,item.getName());
                                    break;
                                case JPG:
                                    break;

                            }
                        }

                    }
                }
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // сравниваем тип с enum
    private FileExtensions asMyEnum(String filename) {
        for (FileExtensions ext : FileExtensions.values()) {
            if (ext.name().equalsIgnoreCase(filename))
                return ext;
        }
        return null;
    }
    // получаем расширение файла
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf + 1);
    }
}
