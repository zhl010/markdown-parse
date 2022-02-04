/*
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

    
}*/
import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinks1() throws IOException{
        String file=Files.readString(Path.of("test-file.md"));
        assertEquals(MarkdownParse.getLinks(file), List.of("https://something.com","some-page.html"));
    }
    @Test
    public void testGetLinks2() throws IOException{
        String file=Files.readString(Path.of("test-file2.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.google.com/maps"));
    }
    @Test
    public void testGetLinks3() throws IOException{
        String file=Files.readString(Path.of("test-file3.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
    }
    @Test
    public void testGetLinksBulk() throws IOException{
        String file=Files.readString(Path.of("test-file4.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        file=Files.readString(Path.of("test-file6.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        file=Files.readString(Path.of("test-file7.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        //tests below are bugged
        file=Files.readString(Path.of("test-file8.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of("a link on the first line"));
        file=Files.readString(Path.of("test-file5.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
    }
}
