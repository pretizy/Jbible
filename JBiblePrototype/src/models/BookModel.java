/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author pretizy
 */
public class BookModel {
    int index;
    String testament;
 public static String[][] old={
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
       {"Proverbs", "31"},
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
       {"Zecharia", "14"},
       {"Malachi", "1"}
   };
   
 
 public static String[][] newT={
     {"Matthew", "Mat"},
     {"Mark", "Mak"},
     {"Luke", "Luk"},
     {"John", "Joh"},
     {"Acts", "Act"},
     {"Romans", "Rom"},
     {"Corinthians 1", "Co1"},
     {"Corinthians 2", "Co2"},
     {"Galatians", "Gal"},
     {"Ephesians", "Eph"},
     {"Philippians", "Phi"},
     {"Colossians", "Col"},
     {"Thessalonians 1", "Th1"},
     {"Thessalonians 2", "Th2"},
     {"Timothy 1", "Ti1"},
     {"Timothy 2", "Ti2"},
     {"Titus", "Tit"},
     {"Philemon", "Plm"},
     {"Hebrews", "Heb"},
     {"James", "Jam"},
     {"Peter 1", "Pe1"},
     {"Peter 2", "Pe2"},
     {"John 1", "Jo1"},
     {"John 2", "Jo2"},
     {"John 3", "Jo3"},
     {"Jude", "Jde"},
     {"Revelation", "Rev"}
    };
   
   
   public BookModel(int index, String testament){
       this.index=index;
       this.testament=testament;
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
   
   
}
