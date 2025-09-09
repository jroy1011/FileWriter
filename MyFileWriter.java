
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String data = "Hello, World!"; // what goes into the file 
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createHiddenFile() {
        String data = "thisIsMyPassword";
        String secretFileName = ".hiddenFileWithPassword";
        try {
            Files.write(Paths.get(secretFileName), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void createRegularFile() {
        String data = "this has confidential info ";
        String regularFileName = "personal.txt";

        try {
            Files.write(Paths.get(regularFileName), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // String finalLocation  = "\\.hiddenFolder\\personal.txt";
        // Path pathSource = Paths.get("").toAbsolutePath();
        // String pathSourceString = pathSource.toString();
        // String StringFinalLocation = pathSourceString + finalLocation;
        // Path pathDestination = Paths.get(StringFinalLocation);
        // System.out.println("hiii " + pathDestination);
        try {
            String finalLocation = "\\.hiddenFolder\\personal.txt";
            Path pathSource = Paths.get("").toAbsolutePath(); // to-do: add personal.txt end 
            String pathSourceString = pathSource.toString();
            String OriginalLocation = pathSourceString + "\\personal.txt";
            String StringFinalLocation = pathSourceString + finalLocation;
            Path FinalPathSource = Paths.get(OriginalLocation);
            Path pathDestination = Paths.get(StringFinalLocation);
            File source = new File(pathSource.toString());
            System.out.println(source.exists());
            System.out.println("hiii " + FinalPathSource);
            Files.move(FinalPathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void personalInfoWrite(){
        String data = "My favorite ice cream flavor is mint chip, I like the color blue, my birthday is June ";
        String regularFileName = "StuffAboutMe.txt";

        try {
            Files.write(Paths.get(regularFileName), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}