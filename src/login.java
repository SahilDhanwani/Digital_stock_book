import java.awt.*;
import javax.swing.*;

class login extends JFrame
{
    JTextField t1,t2;
    JButton b1;
    private JLabel l1_1;
    private JLabel l1_2;
    private JLabel l1_3;

    public login(backend be)
    {
    	getContentPane().setBackground(Color.ORANGE);
        frame_setup();
        b1.addActionListener(ae -> 
        {
            int s;
            String usr_name = t1.getText();
            String pswd = t2.getText();
            System.out.println(usr_name);
            System.out.println(pswd);
            s = be.pswd_check(usr_name,pswd);
            if(s!=0)
            {
                JLabel l1 = new JLabel("LOGIN SUCCESSFULL");
                add(l1);
                System.out.println("LOGIN IS DONE");
                dispose();
                new dashboard(be,s);
            }
            else 
            {
                dispose();
                new login(be); 
            }
        }); 
    }

    public void frame_setup()
    {
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("LOGIN FRAME CREATED");
        getContentPane().setLayout(null);
        JLabel l1 = new JLabel("LOGIN PAGE");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 30));
        l1.setForeground(Color.BLUE);
        l1.setBackground(Color.ORANGE);
        l1.setBounds(10, 35, 464, 31);
        getContentPane().add(l1);
        l1_1 = new JLabel("ENTER YOUR USERNAME : ");
        l1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        l1_1.setHorizontalAlignment(SwingConstants.CENTER);
        l1_1.setBounds(26, 104, 201, 19);
        getContentPane().add(l1_1);
        t1 = new JTextField(15);
        t1.setBounds(259, 105, 126, 20);
        getContentPane().add(t1);
        l1_2 = new JLabel("ENTER YOUR PASSWORD : ");
        l1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        l1_2.setBounds(26, 163, 205, 19);
        getContentPane().add(l1_2);
        t2 = new JTextField(17);
        t2.setBounds(259, 164, 142, 20);
        getContentPane().add(t2);
        b1 = new JButton("OK");
        b1.setForeground(new Color(0, 0, 255));
        b1.setBackground(new Color(0, 255, 0));
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.setBounds(213, 229, 59, 33);
        getContentPane().add(b1);
        l1_3 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_3.setHorizontalAlignment(SwingConstants.CENTER);
        l1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_3.setBounds(10, 436, 464, 19);
        getContentPane().add(l1_3);
    }   
}