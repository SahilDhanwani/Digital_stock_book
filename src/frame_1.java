import java.awt.*;
import javax.swing.*;

class frame_1 extends JFrame
{
    JButton b1,b2;
   
    public frame_1(backend be)
    {
    	setForeground(Color.PINK);
    	setFont(null);
    	setTitle("DIGITAL STOCK BOOK");
    	System.out.println("THIS IS FIRST FRAME");
    	setBackground(Color.ORANGE);
    	getContentPane().setForeground(Color.MAGENTA);
    	getContentPane().setBackground(new Color(255, 255, 128));
        frame_setup();
        b1.addActionListener(ae -> 
        {
            dispose();
            new login(be);
        });

        b2.addActionListener(ae -> 
        {
            dispose();
            new signup(be);
        });
    }

    public void frame_setup()
    {
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("FIRST FRAME CREATED");
        getContentPane().setLayout(null);
        b2 = new JButton("SIGN UP");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b2.setForeground(new Color(255, 0, 255));
        b2.setBackground(new Color(0, 255, 0));
        b2.setBounds(170, 230, 125, 43);
        getContentPane().add(b2);
        b1 = new JButton("LOG IN");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b1.setForeground(new Color(255, 0, 255));
        b1.setBackground(new Color(0, 255, 0));
        b1.setBounds(170, 162, 125, 43);
        getContentPane().add(b1);
        JLabel l1 = new JLabel("DIGITAL STOCK BOOK");
        l1.setToolTipText("");
        l1.setLabelFor(this);
        l1.setFont(new Font("Colonna MT", Font.BOLD | Font.ITALIC, 30));
        l1.setForeground(new Color(255, 0, 128));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBackground(Color.RED);
        l1.setBounds(10, 11, 468, 51);
        getContentPane().add(l1);
        JLabel l2 = new JLabel("A PROJECT BY : Sahil Dhanwani & Pallavi Kadam");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l2.setForeground(new Color(128, 0, 255));
        l2.setBackground(new Color(0, 0, 255));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setBounds(10, 421, 464, 29);
        getContentPane().add(l2);
    }
}