import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.lang.NumberFormatException;

public class passGen extends JFrame implements ActionListener {
    JButton generate;
    JButton Home;
    JLabel result;
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower ="abcdefghijklmnopqrstuvwxyz";
    String num="1234567890";
    String special="<>@#$&*!";
    String combination = upper+lower+num+special;
    String Final;
    JTextField in;
    passGen(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);

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
        JLabel fixed  = new JLabel("your password: ");
        result = new JLabel();

        Header.setText("PASSWORD GENERATOR");
        Header.setHorizontalAlignment(JLabel.CENTER);
        Header.setVerticalAlignment(JLabel.CENTER);
        Header.setForeground(new Color(57,255,20));
        Header.setFont(new Font("Broadway", Font.BOLD, 45));

        fixed.setForeground(new Color(57,255,20));
        fixed.setFont(new Font("Broadway",Font.BOLD,25));
        fixed.setBounds(10,350,500,500);



        result.setForeground(new Color(57,255,20));
        result.setFont(new Font("Broadway",Font.BOLD,25));
        result.setBounds(280,350,700,500);


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

//        display.setBounds(0, 500, 800, 150);
//        display.setBackground(Color.BLACK);
//        display.setLayout(null);
//        display.add(fixed);
//        display.add(result);

        this.add(header);
        this.add(button);
        this.add(display);
        this.add(home);
        this.add(result);
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
            result.setForeground(new Color(57,255,20));
            try {
                int a = Integer.parseInt(n);

                if (a < 5 || a > 15) {
                    result.setText("length must be between 5 and 15");
                } else {
                    char[] password = new char[a];

                    Random r = new Random();

                    for (int i = 0; i < a; i++) {
                        password[i] = combination.charAt(r.nextInt(combination.length()));
                    }

                    result.setText(Final = new String(password));
                }

            }

            catch(NumberFormatException exception){
                result.setForeground(Color.RED);
                result.setText("Enter a valid Input");
            }

        }
    }
}
