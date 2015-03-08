/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import models.VerseModel;

/**
 *
 * @author pretizy
 */
public class VerseController {

    //declare instance variables

    private JList chapterjlist;
    private VerseModel vmodel;

    public VerseController(JList list, VerseModel mod) {
        //instantiate the variables with a two argument constructor
        this.chapterjlist = list;
        this.vmodel = mod;
        
        //use the chapters Jlist to change the verse model when selected
        chapterjlist.addListSelectionListener((ListSelectionEvent e) -> {
            //call the setChapter method which changes the model with the selected chapter and notifies the view
            vmodel.setVerse(chapterjlist.getSelectedIndex() + 1);
        });

    }

}
