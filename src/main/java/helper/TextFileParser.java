package helper;

import exception.FileExtensionNotSupportedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TextFileParser {

    public static Stream<String> parse(File file) throws FileNotFoundException, FileExtensionNotSupportedException {
        if (!file.exists())
            throw new FileNotFoundException();

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.length() - 3);

        if (!fileExtension.equals("txt"))
            throw new FileExtensionNotSupportedException("");

        Stream<String> lines = Stream.empty();

        try {
            lines = Files.lines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
