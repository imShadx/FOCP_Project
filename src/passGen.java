import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.lang.NumberFormatException;
import java.io.FileWriter;
import java.io.IOException;

public class passGen extends JFrame implements ActionListener {

    ImageIcon tickt = new ImageIcon("tick.jpg");
    Image ticks = tickt.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
    ImageIcon tick = new ImageIcon(ticks);

    ImageIcon crosst = new ImageIcon("cross.jpg");
    Image crosss = tickt.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
    ImageIcon cross = new ImageIcon(crosss);


    JCheckBox Upper;
    JCheckBox Special;
    JCheckBox Num;

    JButton generate;
    JButton Home;
    JLabel result1;

    JLabel result2;

    JLabel result3;
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower ="abcdefghijklmnopqrstuvwxyz";
    String num="1234567890";
    String special="<>@#$&*!";
    String characters = lower;
    String Final;
    JTextField in;
    File file = new File("C:\\Users\\jyath\\Documents\\FOCP FInal Proj.txt");
    passGen(){


        this.setVisible(true);
        this.setResizable(true);
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);

        Upper = new JCheckBox("Include Upper Case Characters");
        Upper.setFont(new Font("Broadway", Font.ITALIC, 20));
        Upper.setForeground(Color.RED);
        Upper.setFocusable(false);
        Upper.setBackground(Color.BLACK);
        Upper.setBounds(350, 500, 500, 50);



        Special = new JCheckBox("Include Special Characters");
        Special.setFont(new Font("Broadway", Font.ITALIC, 20));
        Special.setFocusable(false);
        Special.setBackground(Color.BLACK);
        Special.setForeground(Color.RED);
        Special.setBounds(350, 560, 500, 50);

        Num = new JCheckBox("Include Numerical Characters");
        Num.setFont(new Font("Broadway", Font.ITALIC, 20));
        Num.setFocusable(false);
        Num.setBackground(Color.BLACK);
        Num.setForeground(Color.RED);
        Num.setBounds(350, 620, 500, 50);


        this.add(Upper);
        this.add(Special);
        this.add(Num);
        JLabel warn = new JLabel();

        warn.setText("Please enter the password length*");
        warn.setForeground(new Color(57,255,20));
        warn.setBackground(Color.BLACK);
        warn.setFont(new Font("Broadway",Font.ITALIC,15));
        warn.setBounds(140,120,500,200);

        this.add(warn);

        in = new JTextField();
        in.setPreferredSize(new Dimension(500, 100));
        in.setBounds(140, 250, 500, 60);
        in.setBackground(Color.BLACK);
        in.setForeground(new Color(57,255,20));
        in.setFont(new Font("Broadway", Font.BOLD,20));
        in.setCaretColor(Color.BLACK);
        in.setBorder(BorderFactory.createLineBorder(new Color(57,255,20),10));

        this.add(in);

        Home = new JButton();
        ImageIcon icon1 = new ImageIcon("home button.jpg");
        Image icon = icon1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);

        ImageIcon Icon = new ImageIcon(icon);

        Home.setIcon(Icon);
        Home.addActionListener(this);
        Home.setPreferredSize(new Dimension(150, 150));
        Home.setBounds(0,0,150,150);
        Home.setBorder(BorderFactory.createLineBorder((Color.BLACK),8));

        generate = new JButton("Generate");
        generate.addActionListener(this);
        generate.setForeground(new Color(57,255,20));
        generate.setBackground(Color.BLACK);
        generate.setFont(new Font("Broadway",Font.BOLD,30));
        generate.setBorder(BorderFactory.createLineBorder(new Color(57,255,20), 8));
        generate.setBounds(50,30,400,100);
        generate.setFocusable(false);

        JLabel Header = new JLabel();
        JLabel fixed  = new JLabel("your passwords: ");
        result1 = new JLabel();
        result2 = new JLabel();
        result3 = new JLabel();

        Header.setText("PASSWORD GENERATOR");
        Header.setHorizontalAlignment(JLabel.CENTER);
        Header.setVerticalAlignment(JLabel.CENTER);
        Header.setForeground(new Color(57,255,20));
        Header.setFont(new Font("Broadway", Font.BOLD, 45));

        fixed.setForeground(new Color(57,255,20));
        fixed.setFont(new Font("Broadway",Font.BOLD,25));
        fixed.setBounds(10,450,500,500);



        result1.setForeground(new Color(57,255,20));
        result1.setFont(new Font("Broadway",Font.BOLD,25));
        result1.setBounds(10,500,700,500);

        result2.setForeground(new Color(57,255,20));
        result2.setFont(new Font("Broadway",Font.BOLD,25));
        result2.setBounds(300,500,700,500);

        result3.setForeground(new Color(57,255,20));
        result3.setFont(new Font("Broadway",Font.BOLD,25));
        result3.setBounds(600,500,700,500);


        JPanel header = new JPanel();
        JPanel button = new JPanel();
        JPanel display = new JPanel();
        JPanel home = new JPanel();

        home.setBounds(0, 20, 150, 150);
        home.setBackground(Color.ORANGE);
        home.setLayout(null);
        home.add(Home);

        header.setBounds(60, 50, 800, 100);
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.add(Header);

        button.setBounds(145, 300, 500, 150);
        button.setBackground(Color.BLACK);
        button.add(generate);
        button.setLayout(null);

        display.setBounds(0, 500, 800, 150);
        display.setBackground(Color.BLACK);
        display.setLayout(null);
        display.add(fixed);
//        display.add(result1);
//        display.add(result2);
//        display.add(result3);

        this.add(header);
        this.add(button);
        this.add(display);
        this.add(home);
        this.add(result1);
        this.add(result2);
        this.add(result3);
        this.add(fixed);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Home){
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                // Create and show the frame on the EDT
                new Home();
            });
        }

        if(e.getSource()==generate) {
            String n = in.getText();
            result1.setForeground(new Color(57,255,20));
            result2.setForeground(new Color(57,255,20));
            result3.setForeground(new Color(57,255,20));
            try {
                int a = Integer.parseInt(n);

                result1.setText("");
                result2.setText("");
                result3.setText("");

                if (a < 5 || a > 15) {
                    result1.setText("length must be between 5 and 15");
                } else {
                    char[] password1 = new char[a];
                    char[] password2 = new char[a];
                    char[] password3 = new char[a];
                    Random r = new Random();
                    Upper.setForeground(Color.RED);
                    Num.setForeground(Color.RED);
                    Special.setForeground(Color.RED);
                    characters = lower;

                    if(Upper.isSelected()){
                        Upper.setForeground(new Color(57,255,20));
                        characters+= upper;
                    }
                    if(Special.isSelected()){
                        Special.setForeground(new Color(57,255,20));
                        characters+= special;
                    }
                    if(Num.isSelected()){
                        Num.setForeground(new Color(57,255,20));
                        characters+= num;
                    }
                    for(int i=0;i<a;i++){
                        password1[i] = characters.charAt(r.nextInt(characters.length()));
                        password2[i] = characters.charAt(r.nextInt(characters.length()));
                        password3[i] = characters.charAt(r.nextInt(characters.length()));
                    }
                    result1.setText(Final = new String(password1));
                    result2.setText(Final = new String(password2));
                    result3.setText(Final = new String(password3));

                    try{
                        FileWriter file = new FileWriter("C:\\Users\\jyath\\Documents\\FOCP FInal Proj.txt");
                        file.write(String.valueOf(password1)+"\n");
                        file.write(String.valueOf(password2)+"\n");
                        file.write(String.valueOf(password3)+"\n");
                        file.close();
                    }
                    catch(IOException exception){
                        result1.setText("File could not be saved");
                    }


                }

            }

            catch(NumberFormatException exception){
                result1.setForeground(Color.RED);
                result1.setText("Enter a valid Input");
            }

        }
    }
}