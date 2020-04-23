package com.memoire.wohaya.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/files")
public class FilesController {

    public static String UPLOAD_DIR = "uploads";

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        try {
            String fileName = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + fileName;
            saveFile(file.getInputStream(), path);
            return fileName;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void saveFile(InputStream inputStream, String path){
        try {
            OutputStream stream = new FileOutputStream(new File(path));
            int read = 0;
            byte [] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1){
                stream.write(bytes, 0, read);
            }
            stream.flush();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
