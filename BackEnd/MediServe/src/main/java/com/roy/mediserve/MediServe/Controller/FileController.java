package com.roy.mediserve.MediServe.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.roy.mediserve.MediServe.Services.FileService;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    private static Logger log = LoggerFactory.getLogger(FileController.class);

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public boolean uploadFile(@RequestParam("file") MultipartFile file)  {
        try {
            fileService.uploadFile(file);
            log.info("File uploaded Successfully");
            return true;
        } catch (Exception e) {
            log.error("Error uploading file", e);
        }
        log.error("File was not uploaded");
        return false;
    }
}
