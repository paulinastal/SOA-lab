package pl.edu.agh.soa.lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class FileSender {

    private String path;

    public FileSender(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String send(){

        File file = new File(path);
        String encodedfile = null;

        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];

            System.out.println((int)file.length());
            System.out.println(file.length());

            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);

        } catch (FileNotFoundException e) {
            encodedfile = "File doesn't exists";

        } catch (IOException e) {
            encodedfile = "Transfer error";
        }
        return encodedfile;
    }
}
