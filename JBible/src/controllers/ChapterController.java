/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ChapterModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.BookModel;
import models.Finder;

/**
 *
 * @author pretizy
 */
public class ChapterController {

    //create a reference to the Book Jlist and other instance variables
    private final JList oldList;
    private final JList newList;
    private final ChapterModel cmodel;

    //constructor recieves a list object from the Book view so as to change the chapters
    public ChapterController(JList oldList, JList newList, ChapterModel cmodel) {
        this.oldList = oldList;
        this.newList=newList;
        this.cmodel = cmodel;
       

        //handle a change in the list selection of the book view and updates the model
        oldList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            Finder find= new Finder(new BookModel(oldList.getSelectedIndex(), "old"), oldList.getSelectedIndex());
            cmodel.setFind(find);
            cmodel.setName(oldList.getSelectedValue().toString());
            cmodel.setChapter(find.findChapters());
            }
        });

        newList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
         //use Finder object to set the book and chapters
           Finder find = new Finder(new BookModel(newList.getSelectedIndex(), "new"), newList.getSelectedIndex());
            cmodel.setFind(find);
            cmodel.setName(newList.getSelectedValue().toString());
            cmodel.setChapter(find.findChapters());
            }
        });
    }

}
