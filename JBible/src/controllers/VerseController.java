/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import models.BookModel;
import models.ChapterModel;
import models.Vmodel;

/**
 *
 * @author pretizy
 */
public class VerseController {

    //declare instance variables
    private JList chapterjlist;
    private Vmodel vmodel;
    private ChapterModel cmodel;
    private JLabel lab;

    public VerseController(JList list, ChapterModel cmodel, Vmodel mod, JLabel label) {
        //instantiate the variables with a two argument constructor
        this.chapterjlist = list;
        this.vmodel = mod;
        this.cmodel = cmodel;
        this.lab = label;

        //use the chapters Jlist to change the verse model when selected
        chapterjlist.addListSelectionListener((ListSelectionEvent e) -> {
            //call the setChapter method which changes the model with the selected chapter and notifies the view
            int chapter = chapterjlist.getSelectedIndex() + 1;
            Finder find = cmodel.getFind();
            List verse = find.findVerses(chapter);
            vmodel.setVerse(verse);
            if (cmodel.getBook().getTestament().equals("old")) {
                lab.setText(cmodel.getName() + ", " + chapter
                        + " vs 1-" + verse.size());
            } else if (cmodel.getBook().getTestament().equals("new")) {
                lab.setText(cmodel.getName() + ", " + chapter
                        + " vs 1-" + verse.size());
            }
        });

    }
    
    

}

