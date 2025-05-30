package com.roy.mediserve.MediServe.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private static final String FILE_PATH = "/home/rkroy/MediServe-Data";

    private static Logger log = LoggerFactory.getLogger(FileService.class);

    public void uploadFile(MultipartFile file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File is null");
        }
        var targetFile = new File(FILE_PATH + File.separator + file.getOriginalFilename());
        if (!Objects.equals(targetFile.getParent(), FILE_PATH)) {
            throw new SecurityException("File is not in the right directory");
        }
        Files.copy(file.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}

