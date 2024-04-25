import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Home extends JFrame implements ActionListener {
    JButton Button1;
    JButton Button2;

    Home(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);

        ImageIcon lock = new ImageIcon("lock.jpg");
        Image scaledLock = lock.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon Lock = new ImageIcon(scaledLock);


        JLabel head = new JLabel();
        JLabel img = new JLabel();
        JLabel credit = new JLabel();

        credit.setText("By: Yathansh-23CSU52 \n Yuva-23CSU357");
        credit.setHorizontalAlignment(JLabel.LEFT);
        credit.setForeground(new Color(57,255,20));
        credit.setFont(new Font("Broadway", Font.BOLD, 20));

        head.setText("A Cool Name");
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setVerticalAlignment(JLabel.BOTTOM);
        head.setForeground(new Color(57,255,20));
        head.setFont(new Font("Broadway", Font.BOLD, 50));

        img.setIcon(Lock);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);

        Button1 = new JButton();
        Button2 = new JButton();

        Button1.setText("Generate Password");
        Button1.setForeground(new Color(57,255,20));
        Button1.setBackground(Color.BLACK);
        Button1.setFont(new Font("Broadway", Font.BOLD, 30));
        Button1.setBorder(BorderFactory.createLineBorder(new Color(57,255,20), 8));
        Button1.addActionListener(this);
        Button1.setBounds(0,0,400,100);
        Button1.setFocusable(false);

        Button2.setText("Check Strength");
        Button2.setForeground(new Color(57,255,20));
        Button2.setBackground(Color.BLACK);
        Button2.setFont(new Font("Broadway", Font.BOLD, 30));
        Button2.setBorder(BorderFactory.createLineBorder(new Color(57,255,20), 8));
        Button2.addActionListener(this);
        Button2.setBounds(0,0,300,100);
        Button2.setFocusable(false);


        JPanel header = new JPanel();
        JPanel image = new JPanel();
        JPanel button1 = new JPanel();
        JPanel button2 = new JPanel();
        JPanel footer = new JPanel();

        header.setBounds(0, 0, 800, 100);
        header.setBackground(Color.BLACK);
        head.setLayout(new BorderLayout());
        header.add(head);

        image.setBounds(450, 210, 300, 300);
        image.setBackground(Color.BLACK);
        image.setLayout(new BorderLayout());
        image.add(img);

        button1.setBounds(10,200, 400, 100 );
        button1.setBackground(Color.GREEN);
        button1.add(Button1);
        button1.setLayout(null);

        button2.setBounds(30,400, 300, 100 );
        button2.setBackground(Color.RED);
        button2.add(Button2);
        button2.setLayout(null);

        footer.setBounds(0, 700, 800, 100);
        footer.setBackground(Color.BLACK);
        footer.setLayout(new BorderLayout());
        footer.add(credit);

        this.add(header);
        this.add(image);
        this.add(button1);
        this.add(button2);
        this.add(footer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Button1){
            this.dispose();
            new passGen();
        }
        if(e.getSource()==Button2){
            this.dispose();
            new Strength();
        }

    }
}