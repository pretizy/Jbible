/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Finder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author pretizy
 */
public class ChapterModel extends AbstractListModel {

    //create instance variables
    private BookModel book;
    private String name;
    private int chapter;
    private Finder find;
    private List string= new ArrayList();


    //constructor with String parameter
    public ChapterModel(BookModel book) {
        this.book=book;
        this.find = new Finder(book);
        this.string=find.findChapters();
        this.chapter=1;
        this.name= "Genesis";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public BookModel getBook() {
        return book;
    }

    public Finder getFind() {
        return find;
    }

    public void setFind(Finder find) {
        this.find = find;
    }

    
    
    public int getChapter() {
        return chapter;
    }

    public void setChapter(List list) {
        this.string= list;
        //change the UI whenever a different book is selected
        this.fireContentsChanged(this, 0, string.size());
    }

    //return size of the list
    public int getSize() {
        return string.size();
    }

    public Object getElementAt(int index) {
        //write code to implement which chapter to be returned here.
        return string.get(index);
    }

    
    
}
