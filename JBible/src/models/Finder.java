/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pretizy
 */
public class Finder {

    private String testament;
    private int chapter;
    private Scanner scan;
    private List list;
    private List chap;
    private BookModel bmodel;
 //empty parameter Finder constructor suitable for calling the search method which doesnt need initialization
    public Finder() {
  
    }

    // one parameter Finder constructor
    public Finder(BookModel model) {
        this(model, 0);
    }

    //two parameter Finder Constructor
    public Finder(BookModel model, int chapter) {
        //initialize instance variable
        this.testament = model.getTestament();
        this.chapter = chapter;
        this.bmodel = model;
    }

    public List findChapters() {
        //create a new list object
        chap = new ArrayList();
        int c_count = 0;
        //check if testament is old 
        if (testament.equals("old")) {
            //assign the value of the number of chapters to c_count
            c_count = Integer.parseInt(BookModel.old[chapter][1]);
        } //check if testament is new 
        else if (testament.equals("new")) {
            //assign the value of the number of chapters to c_count
            c_count = Integer.parseInt(BookModel.newT[chapter][1]);
        }

        //add chapter number to a string for each chapter
        for (int y = 1; y <= c_count; y++) {
            chap.add("Chapter " + y);
        }
        //return a list of chapters for the selected book
        return chap;
    }

    public List findVerses(int chapt) {
        //check if the the book selected is old or new testament
        if (testament.equals("old")) {
            try {
                //if its old testament then open old testament folder
                this.scan = new Scanner(new File("Old Testament\\" + BookModel.old[chapter][0] + ".txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Finder.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (testament.equals("new")) {
            try {
                //if its new testament then open new testament folder
                this.scan = new Scanner(new File("New Testament\\" + BookModel.newT[chapter][0] + ".txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Finder.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //compile pattern object with a digit regex which finds numeric digits
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m;
        list = new ArrayList();
        int numb;
        //loop through each line in the selected file
        while (scan.hasNext()) {
            String txt = scan.nextLine();
            m = p.matcher(txt);
            m.find();
            //check if the line starts with a numbered book so as to loop twice to get the chapter
            if (txt.startsWith("1", 2) || txt.startsWith("2", 2) || txt.startsWith("3", 2)) {
                //call find again to get the chapter as the second number and assign the chapter to numb
                m.find();
                numb = Integer.parseInt(m.group());
                if (chapt == numb) {
                    //call find again to get the verse so as to edit the line
                    m.find();
                    txt = txt.substring(m.end() + 1, txt.length() - 1);
                    //add edited text to list
                    list.add(m.group() + ". " + txt);
                }
            } //if the book is not nuumbered get the chapter from the first find
            else {
                numb = Integer.parseInt(m.group());
                if (chapt == numb) {
                    //call find again to get the verse number so as to edit the line
                    m.find();
                    txt = txt.substring(m.end() + 1, txt.length() - 1);
                    //add edited text to list
                    list.add(m.group() + ". " + txt);
                }
            }
        }

        scan.close();
        return list;
    }

    public List search(String str) {
        //create new list object to insert search results
        List searchList = new ArrayList();
        try {
            //set the scanner to the entire bible file
            scan = new Scanner(new File("kjvdat.txt"));
            //set the regex pattern with the search string
            Pattern p = Pattern.compile("(" + str + ")");
            //scan through the entire verses for the search parameter
            while (scan.hasNext()) {
                String txt = scan.nextLine();
                Matcher m = p.matcher(txt);
                if (m.find()) {
                    //insert verses that are found into the searchlist
                    searchList.add(txt.substring(0, txt.length() - 1));
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Finder.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return list of all verses found containing the search parameter
        scan.close();
        return searchList;
    }

}
