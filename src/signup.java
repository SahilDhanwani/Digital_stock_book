import java.awt.*;
import javax.swing.*;

class signup extends JFrame
{
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1;
    private JLabel l1_1;
    private JLabel l1_2;
    private JLabel l1_3;
    private JLabel l1_4;
    private JLabel l1_5;
    private JLabel l1_6;
    private JLabel l1_7;
    private JLabel l1_8;
    public signup(backend be)
    {
    	getContentPane().setBackground(Color.ORANGE);
        frame_setup();
        b1.addActionListener(ae ->
        {
            int s;
            String usr_name,pswd,bns_name,prp_name,mail,cat;
            double mob;
            usr_name = t1.getText();
            System.out.println(usr_name);
            pswd = t2.getText();
            bns_name = t3.getText();
            System.out.println(bns_name);
            prp_name = t4.getText();
            mob = Double.parseDouble(t5.getText());
            System.out.println(mob);
            mail = t6.getText();
            System.out.println(mail);
            cat = t7.getText();

            s = be.insert_admin(usr_name,pswd,bns_name,prp_name,mob,mail,cat);
            if(s!=0)
            {
                new dashboard(be,s);
            }
        });
    }
    public void frame_setup()
    {
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("SIGNUP FRAME CREATED");
        getContentPane().setLayout(null);
        JLabel l1 = new JLabel("SIGNUP PAGE");
        l1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.RED);
        l1.setBackground(Color.ORANGE);
        l1.setBounds(7, 22, 467, 31);
        getContentPane().add(l1);
        l1_1 = new JLabel("ENTER YOUR USERNAME : ");
        l1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_1.setBounds(7, 84, 184, 19);
        getContentPane().add(l1_1);
        t1 = new JTextField(15);
        t1.setBounds(235, 85, 173, 20);
        getContentPane().add(t1);
        l1_2 = new JLabel("ENTER YOUR PASSWORD : ");
        l1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_2.setBounds(7, 127, 187, 19);
        getContentPane().add(l1_2);
        t2 = new JTextField(17);
        t2.setBounds(235, 128, 173, 20);
        getContentPane().add(t2);
        l1_3 = new JLabel("BUSINESS NAME(optional) : ");
        l1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_3.setBounds(7, 169, 187, 19);
        getContentPane().add(l1_3);
        t3 = new JTextField(50);
        t3.setBounds(235, 170, 173, 20);
        getContentPane().add(t3);
        l1_4 = new JLabel("PROPRITER NAME(optional) : ");
        l1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_4.setBounds(7, 213, 198, 19);
        getContentPane().add(l1_4);
        t4 = new JTextField(40);
        t4.setBounds(235, 214, 173, 20);
        getContentPane().add(t4);
        l1_5 = new JLabel("MOB NO : ");
        l1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_5.setBounds(7, 254, 73, 19);
        getContentPane().add(l1_5);
        t5 = new JTextField(10);
        t5.setBounds(235, 255, 173, 20);
        getContentPane().add(t5);
        l1_6 = new JLabel("MAIL ID : ");
        l1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_6.setBounds(7, 293, 70, 19);
        getContentPane().add(l1_6);
        t6 = new JTextField(40);
        t6.setBounds(235, 294, 173, 20);
        getContentPane().add(t6);
        l1_7 = new JLabel("BUSINESS CATEGORY : ");
        l1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_7.setBounds(7, 332, 163, 19);
        getContentPane().add(l1_7);
        t7 = new JTextField(20);
        t7.setBounds(235, 333, 173, 20);
        getContentPane().add(t7);
        b1 = new JButton("PROCEED");
        b1.setForeground(new Color(0, 0, 255));
        b1.setBackground(new Color(0, 255, 0));
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.setBounds(171, 381, 127, 27);
        getContentPane().add(b1);
        l1_8 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_8.setHorizontalAlignment(SwingConstants.CENTER);
        l1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_8.setBounds(7, 431, 464, 19);
        getContentPane().add(l1_8);
    }
}