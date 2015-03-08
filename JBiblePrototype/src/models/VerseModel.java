/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JTextArea;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author pretizy
 */

//class VerseModel extends class Observvable in other to use the Observer pattern for the JTextArea component
public class VerseModel {
//create instance variables
    private int verse;
    private JTextArea area;
    private ChapterModel cmodel;
    private Scanner scan;
    private List verseList;

    public ChapterModel getCmodel() {
        return cmodel;
    }
    
   
   
    public VerseModel(int verse, JTextArea area, ChapterModel cmodel){
        //assign references of the JTextArea and current chapter to the instance variable
        this.verse= verse;
        this.area=area;
        this.cmodel=cmodel;
    }
    
    
    //setChapter method which changes the value of the current chapter;
 public void setVerse(int verse){
     this.verse= verse;
 /*    area.setText("");
     area.append(" "+new Random().nextInt());
*/
        List list= getVerses();
        Iterator itr= list.iterator();
       
        while(itr.hasNext()){
            area.append(itr.next().toString());
            area.append("\n");
        } 
    
     //using the observer pattern method setChanged confirms that the model has changed
 }
    
 public List getVerses(){
            //do input output stuff here with the current chapter value and return a string
            //fake data to test
            area.setText("");
            scan= cmodel.getScan();
            Pattern p= Pattern.compile("(\\d+)");
            Matcher m;
            verseList= new ArrayList<>();
            int numb;
            while(scan.hasNext()){
                String txt= scan.nextLine();
                m=p.matcher(txt);
                m.find();
                numb= Integer.parseInt(m.group());
               if(verse==numb){
                   m.find();
                   txt= txt.substring(m.end()+1);
                    verseList.add(m.group()+". "+txt);
               }
            }
     
       
     return verseList;
 }
 
}
