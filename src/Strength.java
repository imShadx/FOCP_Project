import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


public class Strength extends JFrame implements ActionListener {

    JTextField Input;
    JButton click;
    JLabel Text1;
    JLabel Text2a;
    JLabel Text2b;
    JLabel Text2c;

    JButton Home;
    String pass;
    Strength(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);

        Home = new JButton();
        ImageIcon icon1 = new ImageIcon("home button.jpg");
        Image icon = icon1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);

        ImageIcon Icon = new ImageIcon(icon);

        Home.setIcon(Icon);
        Home.addActionListener(this);
        Home.setPreferredSize(new Dimension(150, 150));
        Home.setBounds(0,0,150,150);
        Home.setBorder(BorderFactory.createLineBorder((Color.BLACK),8));

        Input = new JTextField();
        Input.setPreferredSize(new Dimension(400,100));
        Input.setBounds(50, 25, 400, 50);
        Input.setForeground(new Color(57,255,20));
        Input.setBackground(Color.BLACK);
        Input.setFont(new Font("Broadway", Font.BOLD,25));
        Input.setBorder(BorderFactory.createLineBorder(new Color(57,255,20),8));

        click = new JButton("Submit");
        click.setFocusable(false);
        click.setBackground(Color.BLACK);
        click.setForeground(new Color(57,255,50));
        click.setFont(new Font("Broadway", Font.BOLD, 30));
        click.setBorder(BorderFactory.createLineBorder(new Color(57,255,50), 8));
        click.setBounds(90, 100, 300, 100);
        click.addActionListener(this);

        JPanel header = new JPanel();
        JPanel button = new JPanel();
        JPanel input = new JPanel();
        JPanel home = new JPanel();
        JPanel text1 = new JPanel();
        JPanel text2 = new JPanel();

        Text1 = new JLabel();
        Text2a = new JLabel();
        Text2b = new JLabel();
        Text2c = new JLabel();

        Text1.setForeground(new Color(57,255,50));
        Text1.setFont(new Font("Broadway", Font.BOLD, 20));
        Text1.setHorizontalAlignment(JLabel.LEFT);
        Text1.setVerticalAlignment(JLabel.CENTER);

        Text2a.setForeground(Color.RED);
        Text2a.setFont(new Font("Broadway", Font.BOLD, 20));
        Text2a.setBounds(10,30,500,100);

        Text2b.setForeground(Color.RED);
        Text2b.setFont(new Font("Broadway", Font.BOLD, 20));
        Text2b.setBounds(10,100,500,100);

        Text2c.setForeground(Color.RED);
        Text2c.setFont(new Font("Broadway", Font.BOLD, 20));
        Text2c.setBounds(10,180,500,100);

        JLabel Header = new JLabel();
        Header.setText("Strength Checker");
        Header.setForeground(new Color(57, 255, 20));
        Header.setFont(new Font("Broadway", Font.BOLD,40));
        Header.setBounds(60,5, 500, 100);

        home.setBounds(0, 20, 150, 150);
        home.setBackground(Color.ORANGE);
        home.setLayout(null);
        home.add(Home);

        header.setBounds(130, 50, 500, 100);
        header.setBackground(Color.BLACK);
        header.setLayout(null);
        header.add(Header);



        input.setBounds(135, 230, 500,200 );
        input.setBackground(Color.BLACK);
        input.setLayout(null);
        input.add(click);
        input.add(Input);

        text1.setBounds(20, 400, 800, 100);
        text1.setBackground(Color.BLACK);
        text1.setLayout(new BorderLayout());
        text1.add(Text1);

        text2.setBounds(20,500, 800, 500 );
        text2.setBackground(Color.BLACK);
        text2.setLayout(null);
        text2.add(Text2a);
        text2.add(Text2b);
        text2.add(Text2c);


        this.add(header);
        this.add(home);
        this.add(input);
        this.add(text1);
        this.add(text2);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==click) {
            pass = Input.getText();
            Text1.setText("");
            Text2a.setText("");
            Text2a.setForeground(Color.RED);
            Text2b.setText("");
            Text2b.setForeground(Color.RED);
            Text2c.setText("");
            Text2c.setForeground(Color.RED);


            if (pass.isEmpty()) {
                Text1.setText("Please Enter a Password");
            } else {

                if (pass.length() > 25 || pass.length() < 5) {
                    Text1.setText("The password must be between 5 and 15 characters");
                } else {
                    Pattern upperCase = Pattern.compile("[A-Z]");
                    Pattern numbers = Pattern.compile("[0-9]");
                    Pattern special = Pattern.compile("[^A-Za-z0-9]");

                    Matcher upper = upperCase.matcher(pass);
                    Matcher number = numbers.matcher(pass);
                    Matcher spec = special.matcher(pass);

                    boolean a = upper.find();
                    boolean b = number.find();
                    boolean c = spec.find();

                    if (a && b && c && pass.length()>=16) {
                        Text1.setText("The password looks strong");

                        Text2a.setForeground(new Color(57,255,20));
                        Text2a.setText("*uppercase letters");

                        Text2b.setForeground(new Color(57,255,20));
                        Text2b.setText("*numbers");

                        Text2c.setForeground(new Color(57,255,20));
                        Text2c.setText("*special characters");

                    } else {
                        if ((a && b) || (b && c) || (c && a)) {
                            Text1.setText("The password strength is average");
                            if (!a) {
                                Text2a.setText("*Try adding some uppercase letters");
                            }
                            else{
                                Text2a.setForeground(new Color(57,255,20));
                                Text2a.setText("*uppercase letters");
                            }
                            if (!b) {
                                Text2b.setText("*Try adding some numbers");
                            }
                            else{
                                Text2b.setForeground(new Color(57,255,20));
                                Text2b.setText("*numbers");
                            }
                            if (!c) {
                                Text2c.setText("*Try adding some special characters");
                            }
                            else{
                                Text2c.setForeground(new Color(57,255,20));
                                Text2c.setText("*special characters");
                            }
                        } else {
                            Text1.setText("The password seems pretty weak");
                            if (!a) {
                                Text2a.setText("*Try adding some uppercase letters");
                            }
                            else{
                                Text2a.setForeground(new Color(57,255,20));
                                Text2a.setText("*uppercase letters");
                            }
                            if (!b) {
                                Text2b.setText("*Try adding some numbers");
                            }
                            else{
                                Text2b.setForeground(new Color(57,255,20));
                                Text2b.setText("*numbers");
                            }
                            if (!c) {
                                Text2c.setText("*Try adding some special characters");
                            }
                            else{
                                Text2c.setForeground(new Color(57,255,20));
                                Text2c.setText("*special characters");
                            }
                        }
                    }


                }
            }

        }
        if (e.getSource() == Home) {
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                // Create and show the frame on the EDT
                new Home();
            });
        }
    }
}
