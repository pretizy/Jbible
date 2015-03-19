/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JList;
import javax.swing.ListModel;
import models.BookModel;

/**
 *
 * @author pretizy
 */
public class BookList extends JList {

    private BookModel model;

    public BookList() {
        super(new javax.swing.AbstractListModel() {
    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
    public int getSize() { return strings.length; }
    public Object getElementAt(int i) { return strings[i]; }
     }
     
);}

    public BookList(ListModel list) {
        super(list);
        model = (BookModel) list;
    }

    public BookModel getModel() {
        return model;
    }

    public void setModel(BookModel model) {
        this.model = model;
    }

}
