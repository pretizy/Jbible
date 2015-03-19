/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author pretizy
 */
public class BookModel extends AbstractListModel {

    int index;
    String testament;
    public List books = new ArrayList();
    public static String[][] old = {
        {"Genesis", "50"},
        {"Exodus", "40"},
        {"Leveticus", "27"},
        {"Numbers", "36"},
        {"Deuteronomy", "34"},
        {"Joshua", "24"},
        {"Judges", "21"},
        {"Ruth", "4"},
        {"Samuel 1", "31"},
        {"Samuel 2", "24"},
        {"Kings 1", "22"},
        {"Kings 2", "25"},
        {"Chronicles 1", "29"},
        {"Chronicles 2", "36"},
        {"Ezra", "10"},
        {"Nehemiah", "13"},
        {"Esther", "10"},
        {"Job", "42"},
        {"Psalms", "150"},
        {"Proverb", "31"},
        {"Ecclesiastes", "12"},
        {"Song of Solomon", "8"},
        {"Isaiah", "66"},
        {"Jeremiah", "52"},
        {"Lamentations", "5"},
        {"Ezeikel", "48"},
        {"Daniel", "12"},
        {"Hosea", "14"},
        {"Joel", "3"},
        {"Amos", "9"},
        {"Obadiah", "1"},
        {"Jonah", "4"},
        {"Micah", "7"},
        {"Nahum", "3"},
        {"Habakkuk", "3"},
        {"Zephaniah", "3"},
        {"Haggai", "2"},
        {"Zechariah", "14"},
        {"Malachi", "1"}
    };
    
    public static String[][] newT = {
        {"Matthew", "28"},
        {"Mark", "16"},
        {"Luke", "24"},
        {"John", "21"},
        {"Acts", "28"},
        {"Romans", "16"},
        {"Corinthians 1", "16"},
        {"Corinthians 2", "13"},
        {"Galatians", "6"},
        {"Ephesians", "6"},
        {"Philippians", "4"},
        {"Colossians", "4"},
        {"Thessalonians 1", "5"},
        {"Thessalonians 2", "3"},
        {"Timothy 1", "6"},
        {"Timothy 2", "4"},
        {"Titus", "3"},
        {"Philemon", "1"},
        {"Hebrews", "13"},
        {"James", "5"},
        {"Peter 1", "5"},
        {"Peter 2", "3"},
        {"John 1", "5"},
        {"John 2", "1"},
        {"John 3", "1"},
        {"Jude", "1"},
        {"Revelation", "22"}
    };
    
    public BookModel(int index, String testament) {
        this.index = index;
        this.testament = testament;
        if (testament.equals("old")) {
            for (String[] old1 : old) {
                books.add(old1[0]);
            }
        } else if (testament.equals("new")) {
            for (String[] new1 : newT) {
                books.add(new1[0]);
            }
        }
    }
    
    public int getIndex() {
        return index;
    }
    
    public String getTestament() {
        return testament;
    }
    
    public void setTestament(String testament) {
        this.testament = testament;
    }
    
    public void setName(int index) {
        this.index = index;
    }
    
    @Override
    public int getSize() {
        return books.size();
    }
    
    @Override
    public Object getElementAt(int index) {
        return books.get(index);
    }
    
}
