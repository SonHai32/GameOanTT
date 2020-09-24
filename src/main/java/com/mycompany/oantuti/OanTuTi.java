package com.mycompany.oantuti;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import com.mycompany.*;

public class OanTuTi extends JFrame {

    private JLabel lblTitle;
    private JPanel pnlMain;
    private JLabel mainContainer;
    private JLabel lblComputerOption;
    private JLabel lblComputerScore;
    private JLabel lblYourScore;
    private JLabel lblImageYouWin;
    private JLabel lblImageComputerWin;
    private JButton btnKeo;
    private JButton btnBua;
    private JButton btnBao;

    private String currentUsername;
    private String currentUserClass;

    private int computerOption = 0;
    private int yourOption = 0;

    private int computerScore = 0;
    private int yourScore = 0;

    private final String computerWin = "COMPUTER_WIN";
    private final String youWin = "YOU_WIN";

    private static Users currentUser;

    public OanTuTi(String userName, String userClass) throws Exception {
        currentUser = new Users(userName, userClass);
        initComponent();
    }

    public void initComponent() throws Exception {

        final int WIDTH = 1200;
        final int HEIGHT = 900;

        final Image imgKeo = ImageIO.read(getClass().getResource("images/keo1.png"));
        final Image imgBua = ImageIO.read(getClass().getResource("images/bua1.png"));
        final Image imgBao = ImageIO.read(getClass().getResource("images/bao1.png"));
        final Image imgComputer = ImageIO.read(getClass().getResource("images/may_tinh.png"));
        final Image imgYou = ImageIO.read(getClass().getResource("images/you.png"));
        final Image imgComputerWin = ImageIO.read(getClass().getResource("images/may_win.png"));
        final Image imgYouWin = ImageIO.read(getClass().getResource("images/you_win.png"));

        Image imgBG = ImageIO.read(getClass().getResource("images/bg.jpg"));
        ImageIcon imgIconBG = new ImageIcon(imgBG.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));

        lblTitle = new JLabel();
        pnlMain = new JPanel();
        mainContainer = new JLabel();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(255, 255, 255));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        // ------------------START-MENU-BAR---------------
        JMenuBar menu = new JMenuBar();

        JMenu menuInfo = new JMenu("Thông tin");
        JMenu menuHelp = new JMenu("Hướng dẫn");
        JMenu menuHistory = new JMenu("Lịch sử");

        menuInfo.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(null, "Họ Tên: " + currentUser.getName() +"\nLớp: " + currentUser.getInClass(), "Thông tin", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                return;
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                return;
            }
        });

        menuHelp.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                new Help().setVisible(true);
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                new Help().setVisible(false);

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                new Help().setVisible(false);
            }
        });
        menuHistory.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                new History().setVisible(true);
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                new History().setVisible(false);

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                new History().setVisible(false);
            }
        });
        menu.add(menuInfo);
        menu.add(menuHelp);
        menu.add(menuHistory);

        this.setJMenuBar(menu);

        // ------------------END-MENU-BAR---------------

        lblTitle.setText(
                "<html><h1 style='color: red; text-align: center; font-size: 30px'>TRÒ CHƠI OẢN TÙ TÌ VỚI MÁY</h1></html>");
        lblTitle.setBounds(0, 0, WIDTH, 100);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setVerticalAlignment(SwingConstants.CENTER);

        // main Pane
        JLabel leftPane = new JLabel();
        JLabel middlePane = new JLabel();
        JLabel rightPane = new JLabel();

        btnKeo = new JButton();
        btnBua = new JButton();
        btnBao = new JButton();

        int xAlign = (1200 / 3) / 2;
        int yAlign = 900 / 2;

        // ----------START-MIDDLE-PANE------------------
        btnKeo.setBounds(xAlign - 60, yAlign + 100, 120, 120);
        btnKeo.setIcon(new ImageIcon(imgKeo.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
        btnKeo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnKeoActionPerformed(evt);
            }
        });

        btnBua.setBounds(xAlign - 60, yAlign - 60, 120, 120);
        btnBua.setIcon(new ImageIcon(imgBua.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
        btnBua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBuaActionPerformed(evt);
            }
        });

        btnBao.setBounds(xAlign - 60, yAlign - 220, 120, 120);
        btnBao.setIcon(new ImageIcon(imgBao.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
        btnBao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBaoActionPerformed(evt);
            }
        });

        middlePane.setLayout(null);
        middlePane.add(noneBackgroundButton(btnKeo));
        middlePane.add(noneBackgroundButton(btnBua));
        middlePane.add(noneBackgroundButton(btnBao));

        // ----------END-MIDDLE-PANE------------------

        // ----------START-LEFT-PANE------------------

        JLabel lblImageComputer = new JLabel();
        lblImageComputer.setBounds(xAlign - 150, yAlign - 150, 300, 300);
        lblImageComputer.setIcon(new ImageIcon(imgComputer.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

        lblComputerOption = new JLabel();
        lblComputerOption.setBounds(xAlign - 60, yAlign - 110, 120, 120);
        lblComputerOption.setIcon(new ImageIcon(imgBao.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));

        lblImageComputerWin = new JLabel();
        lblImageComputerWin.setBounds(xAlign - 75, yAlign * 2 - 150, 150, 150);
        lblImageComputerWin
            .setIcon(new ImageIcon(imgComputerWin.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        lblImageComputerWin.setVisible(false);

        JLabel lblComputerScoreTitle = new JLabel();

        lblComputerScoreTitle
                .setText("<html><h2 style='color: black; text-align: center; font-size: 24px'>Điểm máy: </h2></html>");
        lblComputerScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblComputerScoreTitle.setVerticalAlignment(SwingConstants.CENTER);
        lblComputerScoreTitle.setBounds(xAlign - 160, yAlign - 200, 250, 35);

        lblComputerScore = new JLabel();

        lblComputerScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblComputerScore.setVerticalAlignment(SwingConstants.CENTER);
        lblComputerScore.setBounds(xAlign + 50, yAlign - 200, 50, 35);


        leftPane.add(lblComputerOption);
        leftPane.add(lblImageComputer);
        leftPane.add(lblImageComputerWin);
        leftPane.add(lblComputerScoreTitle);
        leftPane.add(lblComputerScore);

        // ----------END-LEFT-PANE------------------

        // ----------START-RIGHT-PANE------------------

        JLabel lblImageYou = new JLabel();
        lblImageYou.setBounds(xAlign - 150, yAlign - 150, 300, 300);
        lblImageYou.setIcon(new ImageIcon(imgYou.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

        lblImageYouWin = new JLabel();
        lblImageYouWin.setBounds(xAlign - 75, yAlign * 2 - 150, 150, 150);
        lblImageYouWin.setIcon(new ImageIcon(imgYouWin.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        lblImageYouWin.setVisible(false);

        JLabel lblYourScoreTitle = new JLabel();
        lblYourScoreTitle
                .setText("<html><h2 style='color: black; text-align: center; font-size: 24px'>Điểm bạn: </h2></html>");
        lblYourScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblYourScoreTitle.setVerticalAlignment(SwingConstants.CENTER);
        lblYourScoreTitle.setBounds(xAlign - 160, yAlign - 200, 250, 35);

        lblYourScore = new JLabel();
        lblYourScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblYourScore.setVerticalAlignment(SwingConstants.CENTER);
        lblYourScore.setBounds(xAlign + 50, yAlign - 200, 50, 35);

        rightPane.add(lblImageYou);
        rightPane.add(lblImageYouWin);
        rightPane.add(lblYourScoreTitle);
        rightPane.add(lblYourScore);
        // ----------END-RIGHT-PANE------------------

        GridLayout mainLayout = new GridLayout(1, 3, 0, 0);
        mainContainer.setBounds(0, 0, WIDTH, HEIGHT);
        mainContainer.setIcon(imgIconBG);
        mainContainer.setLayout(mainLayout);
        mainContainer.add(leftPane);
        mainContainer.add(middlePane);
        mainContainer.add(rightPane);

        this.getContentPane().add(lblTitle);
        this.getContentPane().add(mainContainer);

        setScore(computerScore, yourScore);
    }

    int count = 0;

    private JButton noneBackgroundButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }

    // 0: keo
    // 1: bua
    // 2: bao
    private boolean hasWinner() {
        return yourScore == 10 || computerScore == 10;
    }

    private void setScore(int computerScore, int yourScore){
        lblComputerScore.setText(String.format("<html><h2 style='color: red; text-align: center; font-size: 24px'>%s</h2></html>", computerScore));
        lblYourScore.setText(String.format("<html><h2 style='color: green; text-align: center; font-size: 24px'>%s</h2></html>", yourScore));
    }

    ///
    ///Doc file
    ///
    private void writeFile() throws IOException {
        ScoreHistory scoreHistory = new ScoreHistory(currentUser, yourScore, computerScore);
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("history.data", true),
                StandardCharsets.UTF_8)) {
            osw.write(scoreHistory.toString());
            osw.close();
        }

    }
//khi nhan vao btn Keo => chay tro choi
    private void btnKeoActionPerformed(ActionEvent evt) {
        if (hasWinner()) {
            try {
                writeFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        yourOption = 0;
        ramdomComputerOptions(); //chay random may
    }

    private void btnBuaActionPerformed(ActionEvent evt) {
        if (hasWinner()) {
            try {
                writeFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        
        yourOption = 1;
        ramdomComputerOptions();
    }

    private void btnBaoActionPerformed(ActionEvent evt) {
        if (hasWinner()) {
            try {
                writeFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        yourOption = 2;
        ramdomComputerOptions();
    }

    /// Hien thi diem khi co nguoi thang
    private void appendScore() {
        try {
            if (winner(computerOption, yourOption).equals(youWin)) {
                yourScore ++;
                lblImageYouWin.setVisible(true);
                setScore(computerScore, yourScore);
            } else if (winner(computerOption, yourOption).equals(computerWin)) {
                computerScore++;
                lblImageComputerWin.setVisible(true);
                setScore(computerScore, yourScore);
            } else {
                lblImageYouWin.setVisible(true);
                lblImageComputerWin.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /// Hien thi choi lai neu thang
    private void showAgainOption() {
        int playAgain = JOptionPane.YES_OPTION;
        playAgain = JOptionPane.showConfirmDialog(null,
                (yourScore > computerScore ? "Bạn thắng!!!" : "Máy thắng!!!") + "\nBạn có muốn chơi lại ?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (playAgain == JOptionPane.NO_OPTION)
            System.exit(0);
        else {
            yourScore = 0;
            computerScore = 0;
            setScore(computerScore, yourScore);
        }
    }
/// Vo hieu hoa cac nut tro choi
    private void disableUserOption(){
        btnKeo.setEnabled(false);
        btnBua.setEnabled(false);
        btnBao.setEnabled(false);
    }
    private void EnableUserOption(){
        btnKeo.setEnabled(true);
        btnBua.setEnabled(true);
        btnBao.setEnabled(true);
    }

    ///random lua chon cua may
    private void ramdomComputerOptions() {
        try {
            disableUserOption();
            count = 0;
            computerOption = 0;

            lblImageComputerWin.setVisible(false);
            lblImageYouWin.setVisible(false);

            Timer time = new Timer();
            TimerTask timer = new TimerTask() {
                public void run() {
                    try {
                        count++;
                        int num = new Random().nextInt(3);
                        computerOption = num;

                        String[] images = { "images/keo1.png", "images/bua1.png", "images/bao1.png" };

                        lblComputerOption.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(images[num]))
                                .getScaledInstance(120, 120, Image.SCALE_SMOOTH)));

                        if (count >= 50) {
                            time.cancel();
                            EnableUserOption();
                            appendScore();
                        }
                        if (hasWinner()) {
                            writeFile();
                            lblImageComputerWin.setVisible(false);
                            lblImageYouWin.setVisible(false);
                            showAgainOption();

                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            time.schedule(timer, 1, 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String winner(int comOption, int yourOption) {
        String status = "==";

        if (comOption == 0) {
            if (yourOption == 1)
                status = youWin;
            else if (yourOption == 2)
                status = computerWin;
        } else if (comOption == 1) {
            if (yourOption == 0)
                status = computerWin;
            else if (yourOption == 2)
                status = youWin;
        } else if (comOption == 2) {
            if (yourOption == 0)
                status = youWin;
            else if (yourOption == 1)
                status = computerWin;
        }
        return status;
    }

}