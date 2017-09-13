package Lab2;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DownloadWithExceptions {
    public static void main(String[] args) {

        try(InputStream in = new URL("http://speedtest.tele2.net/100MB.zip").openStream()) {
            Files.copy(in, new File("C:\\Users\\tinga\\Documents\\test").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
