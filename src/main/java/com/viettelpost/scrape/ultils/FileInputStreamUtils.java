package com.viettelpost.scrape.ultils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

@Component
@Slf4j
public class FileInputStreamUtils {

    @Value("${path.local}")
    private static String filepath;

    public static Boolean WriteObjectToFile(Object serObj) {
        File file = new File("");
        String currentDirectory = file.getAbsolutePath();
        File fileNew = new File(currentDirectory+"/"+filepath);
        Boolean aBoolean = false;
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            log.info("The Object  was succesfully written to a file");
            aBoolean = true;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return aBoolean;
    }

    public static void main(String[] args) {
        File file = new File("");
        String currentDirectory = file.getAbsolutePath();
        System.out.println(currentDirectory);
    }

}
