/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

/**
 *
 * @author pretizy
 */
public class CustomVerseList implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String format = value.toString();
        JTextArea area = new JTextArea(5, 20);
        area.setText(format);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        int count = 1;
        for (int i = 40; i < format.length()+40; i += 40) {
            if (format.length() < i) {
                area.setRows(count);
                break;
            } else {
                count++;
                continue;
            }
        }

        /*
         if (format.length() < 40) {
         area.setRows(1);
         } else if (format.length() < 80) {
         area.setRows(2);
         } else if (format.length() < 120) {
         area.setRows(3);
         } else if (format.length() < 160) {
         area.setRows(4);
         } else if (format.length() < 200) {
         area.setRows(5);
         } else if (format.length() < 240) {
         area.setRows(6);
         } else if (format.length() < 280) {
         area.setRows(7);
         } else if (format.length() < 320) {
         area.setRows(8);
         } else if (format.length() < 360) {
         area.setRows(9);
         } else if (format.length() < 400) {
         area.setRows(10);
         } else {
         area.setRows(11);
         }
         */
        area.setBackground(new Color(45, 12, 12));
        area.setForeground(Color.white);
        return area;
    }

}
