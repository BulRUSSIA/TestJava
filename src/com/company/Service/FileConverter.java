package com.company.Service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;


public class FileConverter implements IFileConverter {
    @Override
    public  void Convert(String filepatch, String filename) {
        try {
            String sourceDir = filepatch + "\\" +filename;
            System.out.println(sourceDir);// Читаем pdf из заданной директории
            String destinationDir = filepatch+ "\\JPG\\"; // Сохраняем конвертированный pdf  в заданную директорию
            File sourceFile = new File(sourceDir);
            File destinationFile = new File(destinationDir);
            if (!destinationFile.exists()) { //Проверяем наличие папки для сохранения
                destinationFile.mkdir();
                System.out.println("Папка создана-> "+ destinationFile.getAbsolutePath());
            }
            System.out.println(sourceFile);
            if (sourceFile.exists()) { //Проверяем наличие файла в заданной директории

                //Логика работы с документом
                PDDocument document = PDDocument.load(sourceDir);
                List<PDPage> list = document.getDocumentCatalog().getAllPages();
                System.out.println("Всего файлов сконвертировано -> "+ list.size());
                String fileName = sourceFile.getName().replace(".pdf", "");
                int pageNumber = 1;
                for (PDPage page : list) {
                    BufferedImage image = page.convertToImage();
                    File outputfile = new File( destinationDir + fileName + "_"+ pageNumber +".jpg");
                    System.out.println("Изображение создано -> "+ outputfile.getName());
                    ImageIO.write(image, "jpg", outputfile);
                    pageNumber++;
                }
                document.close();
                System.out.println("Сохраняем сконвертированное изображение -> "+ destinationFile.getAbsolutePath());
            } else {
                System.err.println(sourceFile.getName() + "Файл не найден");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}