/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.project.test;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Вова
 */
public class MyInputVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        if("".equals(text)) { 
            return false;
        }else return true;
    }
    
}
