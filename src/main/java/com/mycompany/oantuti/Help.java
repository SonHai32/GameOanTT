package com.mycompany.oantuti;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class Help extends JFrame {
   
    public Help(){
        initComponents();
    } 

    public JFrame mainFrame = this;
   
    public void initComponents(){
        this.setMinimumSize(new Dimension(800, 800));   
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Hướng dẫn game Oẳn tù tì");

        Container mainContainer = this.getContentPane();
        mainContainer.setBackground(new Color(15, 14, 23));
        mainContainer.setLayout(new GridLayout(8,1, 30, 30));

        mainContainer.add(new JLabel("<html><h1 style='color: #f25f4c; text-align: center; font-size: 20px'>HƯỚNG DẪN GAME OẢN TÙ TÌ VỚI MÁY</h1></html>", SwingConstants.CENTER));
        mainContainer.add(new JLabel("<html><h2 style='color: #fffffe; text-align: left; font-size: 16px'>&nbsp;&nbsp;&nbsp;&nbsp;1.Máy đã chọn 1 trong 3 loại: Kéo, Búa hoặc Bao</h2></html>"));
        mainContainer.add(new JLabel("<html><h2 style='color: #fffffe; text-align: left; font-size: 16px'>&nbsp;&nbsp;&nbsp;&nbsp;2.Người chơi chọn 1 trong 3 nút Kéo, Búa và Bao</h2></html>"));
        mainContainer.add(new JLabel("<html><h2 style='color: #fffffe; text-align: left; font-size: 16px'>&nbsp;&nbsp;&nbsp;&nbsp;3.Kết quả trò chơi theo luật: Kéo ăn Bao, Bao ăn Búa, Búa ăn Kéo</h2></html>"));
        mainContainer.add(new JLabel("<html><h2 style='color: #fffffe; text-align: left; font-size: 16px'>&nbsp;&nbsp;&nbsp;&nbsp;4.Điểm số của máy và người chơi hiển thị bên trên ảnh đại diện</h2></html>"));
        mainContainer.add(new JLabel("<html><h2 style='color: #fffffe; text-align: left; font-size: 16px'>&nbsp;&nbsp;&nbsp;&nbsp;5.Ai đạt 10 trước sẽ chiến thắng</h2></html>"));

        JButton btnClose = new JButton("<html><h2 style='color: #fffffe;font-size: 16px'>Đóng</h2></html>");
        btnClose.setBackground(new Color(255, 139, 6));
        btnClose.setBorder(new EmptyBorder(0,0,0,0));
        btnClose.setOpaque(true);
        btnClose.setForeground(new Color(255, 255, 254));
        btnClose.setBorderPainted(false);
        btnClose.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent evt){
                mainFrame.dispose();
           } 
        });
        mainContainer.add(btnClose);

   }

}