// ------------ WEEK 3 VERSION (DIFFERENT LAB GROUP) -------------------------------

// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseOld {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);

            if (nextOpenBracket == -1 || nextCloseBracket == -1) {
                break;
            }

            if (nextCloseBracket != markdown.length()-1 && markdown.substring(nextCloseBracket+1, nextCloseBracket+2).equals("(")) {
                int openParen = markdown.indexOf("(", nextCloseBracket);
                int closeParen = markdown.indexOf(")", openParen);

                if (closeParen == -1) {
                    break;
                }

                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;

                System.out.println("CI: " + currentIndex + 
                                ", [: " + nextOpenBracket +
                                ", ]: " + nextCloseBracket +
                                ", (: " + openParen +
                                ", ): " + closeParen);
            } else {
                currentIndex = nextCloseBracket+1;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}