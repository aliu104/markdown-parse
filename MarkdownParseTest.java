import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
  Commands in terminal for windows:
  javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
  java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
*/
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-files/test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
    @Test
    public void testFile2() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile3() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file3.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile4() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file4.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile5() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file5.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile6() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file6.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile7() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file7.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile8() throws IOException {
        String contents = Files.readString(Path.of("./test-files/test-file8.md"));
        List<String> expect = List.of("a link on the first line");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile9() throws IOException {
        String contents = Files.readString(Path.of("./test-files/faulty-file1.md"));
        // List<String> expect = List.of("wrong assertion"); // wrong assertion, should give failed test
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect); // should fix wrong assertion
    }

    @Test
    public void testSnip1() throws IOException {
        String contents = Files.readString(
            Path.of("./test-files/snippet-1.md"));
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnip2() throws IOException {
        String contents = Files.readString(
            Path.of("./test-files/snippet-2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnip3() throws IOException {
        String contents = Files.readString(
            Path.of("./test-files/snippet-3.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}
