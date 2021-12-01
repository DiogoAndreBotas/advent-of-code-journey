package helper;

import exception.FileExtensionNotSupportedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TextFileParserTest {

    @Test
    @DisplayName("Parses a file with 5 lines")
    public void parse5Lines() {
        File file = new File("./src/test/resources/helper/5_lines.txt");

        try {
            Stream<String> lines = TextFileParser.parse(file);
            assertEquals(5, lines.count());
        } catch (FileExtensionNotSupportedException | FileNotFoundException exception) {
            fail(exception);
        }
    }

    @Test
    @DisplayName("Parses a file with 100 lines")
    public void parse100Lines() {
        File file = new File("./src/test/resources/helper/100_lines.txt");

        try {
            Stream<String> lines = TextFileParser.parse(file);
            assertEquals(100, lines.count());
        } catch (FileExtensionNotSupportedException | FileNotFoundException exception) {
            fail(exception);
        }
    }

    @Test
    @DisplayName("Parses a file with 1000 lines")
    public void parse1000Lines() {
        File file = new File("./src/test/resources/helper/1000_lines.txt");

        try {
            Stream<String> lines = TextFileParser.parse(file);
            assertEquals(1000, lines.count());
        } catch (FileExtensionNotSupportedException | FileNotFoundException exception) {
            fail(exception);
        }
    }

    @Test
    @DisplayName("Parses a file with 0 lines")
    public void parse0Lines() {
        File file = new File("./src/test/resources/helper/0_lines.txt");

        try {
            Stream<String> lines = TextFileParser.parse(file);
            assertEquals(0, lines.count());
        } catch (FileExtensionNotSupportedException | FileNotFoundException exception) {
            fail(exception);
        }
    }

    @Test
    @DisplayName("Parsing fails if the file extension is not .txt")
    public void throwExceptionIfFileExtensionIsNotSupported() {
        File file = new File("./src/test/resources/helper/unsupported_extension.doc");

        assertThrows(
            FileExtensionNotSupportedException.class,
            () -> TextFileParser.parse(file)
        );
    }

    @Test
    @DisplayName("Parsing fails if the file does not exist")
    public void throwExceptionIfFileDoesNotExist() {
        File file = new File("./src/test/resources/helper/i_do_not_exist.wow");

        assertThrows(
            FileNotFoundException.class,
            () -> TextFileParser.parse(file)
        );
    }

}
