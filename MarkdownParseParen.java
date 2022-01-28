// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class MarkdownParseParen {
public static ArrayList<String> getLinks(String markdown) {
ArrayList<String> toReturn = new ArrayList<>();
// find the next [, then find the ], then find the (, then take up to
// the next )
int currentIndex = 0;
//System.out.println(currentIndex);
while(currentIndex < markdown.length()) {
int nextOpenBracket = markdown.indexOf("[", currentIndex);
if(nextOpenBracket<0) break;
int nextCloseBracket = findMatchParen(markdown, nextOpenBracket);
//int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
if(nextCloseBracket<0) break;
int openParen = markdown.indexOf("(", nextCloseBracket);
if(openParen<0) break;

int closeParen = findMatchParen(markdown, openParen);
//int closeParen = markdown.indexOf(")", openParen);
if(closeParen<0) break;
toReturn.add(markdown.substring(openParen + 1, closeParen));
currentIndex = closeParen + 1;
//System.out.println(currentIndex);
}
return toReturn;
}
public static int matchParen(char a,char b){
int toReturn = 0;
//return value of 0 indicates the second char is not a paren
if(Character.toString(b).equals("[") || Character.toString(b).equals("(")) toReturn = 2;
//! Replacing .equals() method with "==" caused a bug!!!
//return value of 2 indicates the second char is a open paren
else if(Character.toString(a).equals("[")&&Character.toString(b).equals("]") ||
Character.toString(a).equals("(")&&Character.toString(b).equals(")")){
toReturn = 1;
//return value 1 indicates two chars can match each other
}
return toReturn;
}

//find the index of the close paren matching the open
public static int findMatchParen(String text,int OpenParen){
//System.out.println(OpenParen);
Stack<Integer> pairParen = new Stack<>();
int index = OpenParen+1;
int i = 1;
pairParen.push(OpenParen);
while(i!=0 && index<text.length()){
//System.out.println(pairParen.size()+10);
Integer top = pairParen.pop();
//System.out.println(pairParen.size()+10);
//System.out.println(matchParen(text.charAt(top),text.charAt(index)));//print for debug
if(matchParen(text.charAt(top),text.charAt(index))==1); //System.out.println(pairParen.size()+10);
//when next char match the top of stack, remove the top(do not push it back)
else if(matchParen(text.charAt(top),text.charAt(index))==2){
//when next char is a new open paren, push back the top and push index of the new open paren
pairParen.push(top);
pairParen.push(index);
//System.out.println("K");

}
else {pairParen.push(top);}//System.out.println("?");}
i = pairParen.size();
index++;
//System.out.println(i);
//when next char matches nothing, push back the top only
}
//System.out.println(index);
return index-1;


}
public static void main(String[] args) throws IOException {
//Path fileName = Path.of("test-file.md");//for debug purpose
Path fileName = Path.of(args[0]);
String contents = Files.readString(fileName);
ArrayList<String> links = getLinks(contents);
System.out.println(links);
}
}
