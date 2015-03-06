/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ChapterModel;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import models.BookModel;

/**
 *
 * @author pretizy
 */
public class ChapterController {

    //create a reference to the Book Jlist and other instance variables

    JList bookJlist;
    ChapterModel model;
    BookModel bmodel;

    //constructor recieves a list object from the Book view so as to change the chapters
    public ChapterController(JList booklist, AbstractListModel models) {
        this.bookJlist = booklist;
        this.model = (ChapterModel) models;

        //handle a change in the list selection of the book view and updates the model
        bookJlist.addListSelectionListener((ListSelectionEvent event) -> {
            bmodel = new BookModel(bookJlist.getSelectedIndex(), "old");
            model.setChapter(1, bmodel);
        });

    }

}
