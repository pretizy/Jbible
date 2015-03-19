/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author pretizy
 */
public class Vmodel extends AbstractListModel {

    //create local variables

    private List list;
    private ChapterModel cmodel;
 
    
   
    
    public Vmodel(ChapterModel cmodel) {
        //assign references of the current chapter to the instance variable
        this.cmodel = cmodel;
        Finder find= cmodel.getFind();
        setVerse(find.findVerses(1));
    }

    public void setVerse(List verses){
       this.list= verses;
       this.fireContentsChanged(this, 0, list.size());
    }

    public ChapterModel getCmodel() {
        return cmodel;
    }
    
    
    
    @Override
    public int getSize() {
        //return size of the verse to the list
        return this.list.size();
    }

    @Override
    public Object getElementAt(int index) {
        //get the current input output operation froom the chapter

        return list.get(index);
    }
}
