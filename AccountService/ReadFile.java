package com.example.palindrome.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Nabeel on 9/11/2017.
 */
@Component
public class ReadFile {

    // file directive find by using the file object.
    private File file;
    // fetch-ing file data by using Scanner.
    private Scanner input;
    // list for store the number of line fetch from the file.
    private List<String> lines = new ArrayList<String>();
    // check is palindrome or not
    private Map<String, Boolean> palindrome = new HashMap<>();
    // count number line from the array
    private Integer lineCount = 0;
    // getMessage work fine
    public String getMessage(){
        readingFile().toString();
        return this.palindrome.toString();
    }

    // read file work fine
    public List<String> readingFile() {

        try {
            this.file = new ClassPathResource("/file/palindrome.txt").getFile();
            // checking the file is empty or not
            if (file.isFile()) {
                if (file.length() != 0) {
                    this.input = new Scanner(file);
                    while (input.hasNextLine()) {
                        String message = this.input.nextLine();
                        lines.add(message);
                        this.palindrome.put(message, this.isPalindrome(message));
                    }
                    input.close();
                    return lines;
                } else {
                    System.out.println("File Empty found");
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }
        return  null;
    }

    // checking the palindrome
    public Boolean isPalindrome(String message) {
        System.out.println(message+"\n");
        return false;
    }


    // count the total line
    public Integer getLine(){
        return this.lines.size();
    }
    // count total word
    public Integer getTotalWord() {
        return 0;
    }
    // count the word per line
    public Integer getWordPerLine(){
        return 0;
    }
    // count the total char
    public Integer getTotalChar() {
        return 0;
    }
    // count the total char per line
    public Integer getCharPerLine() {
        return 0;
    }
    // count the total vowel( a,e,i,o,u)
    public Map<String, Integer> getTotalVowel(){
        return null;
    }
    // count the total space per line
    public Integer getSpacePerLine() {
        return 0;
    }
    // count all space in the file
    public Integer getTotalSpace(){
        return 0;
    }

    // count the total punctuation
    public Integer getTotalPunctuation() {
        return 0;
    }

   


}
