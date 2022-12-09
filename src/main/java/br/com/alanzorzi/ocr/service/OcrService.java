package br.com.alanzorzi.ocr.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class OcrService {

    public String getOcr(MultipartFile multipartFile) throws IOException, TesseractException {

        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(System.getProperty("user.dir") +"/src/main/resources/tessdata");
        tesseract.setLanguage("por");

        String response = tesseract.doOCR(file);

        fos.close();
        file.delete();

        return response;
    }
}
