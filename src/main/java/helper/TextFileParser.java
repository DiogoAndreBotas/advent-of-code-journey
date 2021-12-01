package helper;

import exception.FileExtensionNotSupportedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TextFileParser {

    public static ArrayList<String> parse(File file) throws FileExtensionNotSupportedException, FileNotFoundException {
        if (!file.exists())
            throw new FileNotFoundException();

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.length() - 3);

        System.out.println("file extension " + fileExtension);

        if (!fileExtension.equals("txt"))
            throw new FileExtensionNotSupportedException("");

        ArrayList<String> lines = new ArrayList<>();

        try (Stream<String> linesStream = Files.lines(file.toPath())) {
            linesStream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
