/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.bible.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author root
 */
public class LongListFrame  extends JFrame{

    
    private static final int D_W = 300, D_H = 400;
    private String 
            prefix = "The quick brown fox ",
            suffix = " jumps over the lazy dog";
    
    private JList wordList;
    private JLabel label;
    
    
    
    public LongListFrame() throws HeadlessException {
        setTitle("LongList");
        setSize(D_W, D_H);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        wordList = new JList(new WordListModel(3));
        wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wordList.setPrototypeCellValue("www");
        
        JScrollPane list_holder = new JScrollPane(wordList);
        
        JPanel panel = new JPanel();
        panel.add(list_holder);
        wordList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                StringBuilder builder = (StringBuilder)wordList.getSelectedValue();
                setSubject(builder.toString());
            }
        });
        
        
        Container container = getContentPane();
        container.add(panel, BorderLayout.NORTH);
        
        label = new JLabel(prefix + suffix);
        container.add(label, BorderLayout.CENTER);
        setSubject("fox");
    }
    
    
    private void setSubject(String word_to_set)
    {
        StringBuilder text = new StringBuilder(prefix);
        text.append(word_to_set);
        text.append(suffix);
        label.setText(text.toString());
    }
    
    
    public static void main(String[] args) {
        new LongListFrame().setVisible(true);
    }
    
}
