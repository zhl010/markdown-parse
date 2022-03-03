import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;

public class MarkdownParseTest {
    ArrayList<String> file = new ArrayList<>();

    public String readFile(String path) throws IOException{
        Path fileName = Path.of(path);
        String contents = Files.readString(fileName);
        return contents;
    }
    
	
    /*
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLink1() throws IOException{
        file.add("www.google.com");
        file.add("www.canvas.ucsd.edu");
        String text = readFile("test-file1.md");
        assertEquals(file,MarkdownParse.getLinks(text));

    }

    @Test
    public void testGetLink2() throws IOException{
        file.add("https://something.com");
        file.add("some-page.html");
        String text = readFile("test-file2.md");
        assertEquals(file, MarkdownParse.getLinks(text));
    }

    @Test
    public void testGetLink3() throws IOException{
        String text = readFile("test-file3.md");
        assertEquals(file, MarkdownParse.getLinks(text));
    }

    @Test
    public void testGetLink4() throws IOException{
        file.add("www.alink.com");
        String text = readFile("test-file4.md");
        assertEquals(file, MarkdownParse.getLinks(text));
    }
*/
    // --- test added for content in lab report 4 ---

    @Test
    public void testGetLinkS1() throws IOException{
        file.add("`google.com");
        file.add("google.com");
        file.add("ucsd.edu");
        String text = readFile("test-sni1.md");
        assertEquals(file, MarkdownParse.getLinks(text));
    }

    @Test
    public void testGetLinkS2() throws IOException{
        file.add("a.com");
        file.add("a.com(())");
        file.add("example.com");
        String text = readFile("test-sni2.md");
        assertEquals(file, MarkdownParse.getLinks(text));
    }

    @Test
    public void testGetLinkS3() throws IOException{
        file.add("\n    https://ucsd-cse15l-w22.github.io/\n");
        String text = readFile("test-sni3.md");
        assertEquals(file, MarkdownParse.getLinks(text));
    }
    
}
