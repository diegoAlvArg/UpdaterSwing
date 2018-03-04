/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * This example, like all Swing examples, exists in a package:
 * in this case, the "start" package.
 * If you are using an IDE, such as NetBeans, this should work
 * seamlessly.  If you are compiling and running the examples
 * from the command-line, this may be confusing if you aren't
 * used to using named packages.  In most cases,
 * the quick and dirty solution is to delete or comment out
 * the "package" line from all the source files and the code
 * should work as expected.  For an explanation of how to
 * use the Swing examples as-is from the command line, see
 * http://docs.oracle.com/javase/javatutorials/tutorial/uiswing/start/compile.html#package
 */
package application;

/*
 * HelloWorldSwing.java requires no other files. 
 */
//import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import tools.ResourceLeng;

public class HelloWorld {

    private int count = 0;
    private static ResourceBundle rb;
    private String Text_button;
    private String Text_log;
    private String Text_title;
    private String Text_Hello;
    private JLabel label;
    private JButton button1;
    private JFrame frame;
    
    public HelloWorld() {
        setLanguage(Locale.getDefault());
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        this.frame = new JFrame(Text_title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        Container contentPanel = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPanel.setLayout(layout);

        //******************Label****
        this.label = new JLabel(Text_Hello);
        //******************BUTTON****        
        this.button1 = new javax.swing.JButton();
        button1.setText(Text_button);
//        jButton1.setActionCommand("sayButton");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
//        frame.getContentPane().add(jButton1);
        //**********************
//        String[] languages = new String[] {"English", "French", "Spanish", "Japanese", "Chinese"};
        JComboBox<String> languagueList = new JComboBox<String>(ResourceLeng.getLanguages());
        languagueList.setSelectedIndex(0);
        languagueList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String selectLanguague = (String) combo.getSelectedItem();
//                Locale.forLanguageTag("es")
                changeLanguage(true, Locale.forLanguageTag(ResourceLeng.getIso(selectLanguague)));
                System.out.println("Idioma " + selectLanguague);
            }
        });

        contentPanel.add(label);
        contentPanel.add(button1);
        contentPanel.add(languagueList);
        layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, contentPanel);
        layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, contentPanel);
        layout.putConstraint(SpringLayout.NORTH, button1, 25, SpringLayout.NORTH, contentPanel);
        layout.putConstraint(SpringLayout.WEST, button1, 50, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, languagueList, 50, SpringLayout.NORTH, contentPanel);
        layout.putConstraint(SpringLayout.WEST, languagueList, 10, SpringLayout.WEST, contentPanel);
        //Display the window.
//        frame.pack();
        frame.setVisible(true);
    }

    private void jButton1ActionPerformed(ActionEvent event) {
        System.out.println(Text_log);
    }

    private void setLanguage(Locale _languague) {
        rb = ResourceBundle.getBundle("Resources.Languages.SystemMessages", _languague);
        loadBasicLanguague();
    }
    private void loadBasicLanguague(){
        this.Text_button = rb.getString(ResourceLeng.HELLO_BUTTON);
        this.Text_log = rb.getString(ResourceLeng.HELLO_LOG);
        this.Text_title = rb.getString(ResourceLeng.APP_TITLE);
        this.Text_Hello = rb.getString(ResourceLeng.HELLO_WORLD);
    }
    private void changeLanguage(boolean _refresh, Locale _language) {
        rb = ResourceBundle.getBundle("Resources.Languages.SystemMessages", _language);
        
        this.Text_button = rb.getString(ResourceLeng.HELLO_BUTTON);
        this.Text_log = rb.getString(ResourceLeng.HELLO_LOG);
        this.Text_title = rb.getString(ResourceLeng.APP_TITLE);
        this.Text_Hello = rb.getString(ResourceLeng.HELLO_WORLD);


        if (_refresh) {
            this.button1.setText(Text_button + count);
            this.label.setText(Text_Hello);
            this.frame.setTitle(Text_title);
            
////            this.frame.repaint();
        }
    }

    protected void actionPerformed(ActionEvent event){
        System.out.println("ComboBreak");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new HelloWorld();
    }
}
