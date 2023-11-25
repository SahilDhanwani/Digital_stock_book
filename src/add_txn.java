import java.awt.*;
import javax.swing.*;

class add_txn extends JFrame
{
    JButton b1;
    JTextField t1,t2,t3;
    JRadioButton r1,r2;
    private JLabel l1_1;
    add_txn(backend be,int DSB_ID)
    {
        frame_setup();
        
        b1.addActionListener(ae -> 
        {
            String product_id,type;
            int qty;
            float amt;

            product_id = t1.getText();
            qty = Integer.parseInt(t2.getText());
            amt = Float.parseFloat(t3.getText());
            if(r1.isSelected())
                type = "Purchase";
            else 
                type = "Sales";
            be.insert_txn_and_update(type,product_id,DSB_ID,qty,amt);
            dispose();
            new dashboard(be,DSB_ID);
        });
    }

    public void frame_setup()
    {
    	getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("ADD TXN FRAME CREATED");
        getContentPane().setLayout(null);
        
        JLabel l1 = new JLabel("ADDING A NEW TXN");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        l1.setBounds(127, 23, 232, 31);
        getContentPane().add(l1);
        
        r1 = new JRadioButton("PURCHASE");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        r1.setBounds(127, 81, 121, 33);
        getContentPane().add(r1);
        
        r2 = new JRadioButton("SALE");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        r2.setBounds(277, 81, 69, 33);
        getContentPane().add(r2);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        JLabel l2 = new JLabel("ENTER PRODUCT ID : ");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l2.setBounds(44, 166, 153, 19);
        getContentPane().add(l2);
        
        t1 = new JTextField(15);
        t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        t1.setBounds(207, 163, 201, 25);
        getContentPane().add(t1);
        
        JLabel l3 = new JLabel("ENTER QUANTITY : ");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l3.setBounds(44, 201, 141, 19);
        getContentPane().add(l3);
        
        t2 = new JTextField(10);
        t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        t2.setBounds(207, 198, 201, 25);
        getContentPane().add(t2);
        
        JLabel l4 = new JLabel("ENTER AMOUNT : ");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l4.setBounds(44, 237, 127, 19);
        getContentPane().add(l4);
        
        t3 = new JTextField(10);
        t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        t3.setBounds(207, 234, 201, 25);
        getContentPane().add(t3);
        
        b1 = new JButton("MAKE TXN");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b1.setForeground(Color.BLUE);
        b1.setBackground(Color.GREEN);
        b1.setBounds(172, 303, 153, 46);
        getContentPane().add(b1);
        
        l1_1 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_1.setBounds(13, 431, 461, 19);
        l1_1.setHorizontalAlignment(SwingConstants.CENTER);
        l1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        getContentPane().add(l1_1);
    }
}