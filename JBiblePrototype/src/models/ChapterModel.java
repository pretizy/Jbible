/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

/**
 *
 * @author pretizy
 */
public class ChapterModel extends AbstractListModel {

    //create instance variables
    private static final long serialVersionUID = 1L;
    private BookModel book;
    private int chapter;
    private Scanner scan;
    private int c_count;
    private List<String> list;
    //fake sample data
    private String[] strings;

    //constructor with String parameter
    public ChapterModel(BookModel book, int chapter) {
        try {
            //write code to use book value to initialize the begining state of the chapter UI //
            this.chapter= chapter;
            this.book = book;
            this.scan=new Scanner(new File("Old Testament\\"+BookModel.old[book.getIndex()][0]+".txt"));
            c_count = Integer.parseInt(BookModel.old[0][1]);
            String[] chap = new String[c_count];
            for (int y = c_count - 1; y >= 0; y--) {
                chap[y] = "Chapter " + c_count;
                c_count--;
            }
            
            //assign new array to strings
            strings = chap;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChapterModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BookModel getBook() {
        return book;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter, BookModel book) {
        try {
            this.chapter = chapter;
            this.book = book;
            //check to see the current testament
            if (getBook().getTestament().equals("old")) {
                scan = new Scanner(new File("Old Testament\\" + BookModel.old[getBook().getIndex()][0] + ".txt"));
                c_count = Integer.parseInt(BookModel.old[getBook().getIndex()][1]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChapterModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        //generate test data to test the app  
        String[] chap = new String[c_count];
        for (int y = c_count - 1; y >= 0; y--) {
            chap[y] = "Chapter " + c_count;
            c_count--;
        }

        //assign new array to strings
        strings = chap;
        //change the UI whenever a different book is selected
        this.fireContentsChanged(this, 0, strings.length);

    }

    public Scanner getScan() {
        return scan;
    }

    //return size of the list
    public int getSize() {
        return strings.length;
    }

    public Object getElementAt(int index) {
        //write code to implement which chapter to be returned here.
        return strings[index];
    }

}
