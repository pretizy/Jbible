/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.bible.test;

import javax.swing.AbstractListModel;

/**
 *
 * @author root
 */
public class WordListModel extends AbstractListModel<Object>{

    private int length;
    private final char FIRST = 'a', LAST = 'z';
    public WordListModel(int no_of_word) {
        length = no_of_word;
        
    }

    
    
    @Override
    public int getSize() {
        return (int)Math.pow(LAST - FIRST + 1, length);
    }

    @Override
    public Object getElementAt(int index) {
        
        StringBuilder builder = new StringBuilder();
        for(int count = 0; count < length; count++){
            char c = (char)(FIRST + index  % (LAST - FIRST + 1));
            builder.insert(0, c);
            index = index / (LAST - FIRST + 1);
        }
        
        return builder;
    }
    
    
    
    
}
