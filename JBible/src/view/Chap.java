/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author pretizy
 */
public class Chap extends JList {

    public Chap() {
        super(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        }
        );
    }

    public Chap(ListModel list) {
        super(list);
    }

}
