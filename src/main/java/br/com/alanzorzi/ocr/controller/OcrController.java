package br.com.alanzorzi.ocr.controller;

import br.com.alanzorzi.ocr.service.OcrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/ocr")
public class OcrController {

    private final OcrService ocrService;

    public OcrController(OcrService ocrService){this.ocrService = ocrService;}

    @PostMapping("")
    public ResponseEntity<Object> ocr(@RequestParam(value = "file") MultipartFile multipartFile) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ocrService.getOcr(multipartFile));
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}
