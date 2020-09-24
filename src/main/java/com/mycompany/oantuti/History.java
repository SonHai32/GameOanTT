package com.mycompany.oantuti;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class History extends JFrame{

        public History(){
            initComponent();
        }
        private JTextArea txtHistory;
        public void initComponent(){
            this.setMinimumSize(new Dimension(800, 800));
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setTitle("Lịch sử game Oẳn tù xì");

            Container mainContainer = this.getContentPane();
            mainContainer.setLayout(null);
            mainContainer.setBackground(new Color(15, 14, 23));

            JLabel lblTitle = new JLabel("<html><h1 style='color: #e53170'>Lịch sử game Oẳn tù tì</h1></html>", SwingConstants.CENTER);
            lblTitle.setBounds(0,0, 800, 80);

            txtHistory = new JTextArea();
            txtHistory.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
            txtHistory.setBackground(new Color(229, 49, 112));
            txtHistory.setForeground(new Color(255, 255, 254));
            txtHistory.setEditable(false);
            
            JScrollPane scrollPane = new JScrollPane(txtHistory, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(40, 120, 720, 580);


            mainContainer.add(lblTitle);
            mainContainer.add(scrollPane);
            try {
                readFile();
            } catch (Exception e) {
                Logger.getLogger(OanTuTi.class.getName()).log(Level.SEVERE, null, e);
            }

            
        }
        private void readFile() throws IOException{
            String data = "Tên Bạn\tĐiểm bạn\tĐiểm máy\tKết quả\n\n";
            try(
            BufferedReader buff = new BufferedReader(new FileReader("history.data"))){
                String score;
                while((score = buff.readLine()) != null){
                    data += new String(score.getBytes(), "UTF-8");
                    data += "\n";
                }   
                txtHistory.setText(data);
            }

        }
    
}