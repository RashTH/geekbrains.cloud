package com.cloud.storage.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSClass implements Serializable {
    File file;
    String name;
    Long fileSize;
    byte[] arr;

    public FileSClass(String path) {
        this.file = new File(path);
        name = file.getName();
        fileSize = file.length();
        fileToByte(file);

    }

    private void fileToByte(File file){
        try {
            arr = Files.readAllBytes(Paths.get(file.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public byte[] getArr() {
        return arr;
    }
}
