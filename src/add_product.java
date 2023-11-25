import java.awt.*;
import javax.swing.*;

class add_product extends JFrame
{
    JButton b1;
    JTextField t1,t2;
    private JLabel l1_1;
    private JLabel l1_2;
    private JLabel l1_3;
    public add_product(backend be, int DSB_ID)
    {
    	frame_setup();
        
        b1.addActionListener(ae -> 
        {
            String product_id,product_name;
            product_id = t1.getText();
            product_name = t2.getText();
            be.insert_product(DSB_ID,product_id,product_name);
            dispose();
            new dashboard(be, DSB_ID);
        });
    }

    public void frame_setup()
    {
    	getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("ADD PRODUCT FRAME CREATED");
        getContentPane().setLayout(null);
        
		JLabel l1 = new JLabel("ADDING A NEW PRODUCT");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        l1.setForeground(Color.RED);
        l1.setBounds(98, 11, 296, 31);
        getContentPane().add(l1);
        
		l1_3 = new JLabel("ENTER PRODUCT ID : ");
        l1_3.setBounds(34, 86, 153, 19);
        l1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        getContentPane().add(l1_3);
        
		t1 = new JTextField(15);
        t1.setBounds(220, 87, 160, 20);
        getContentPane().add(t1);
        
		l1_2 = new JLabel("ENTER PRODUCT NAME : ");
        l1_2.setBounds(34, 143, 176, 19);
        l1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        getContentPane().add(l1_2);
        
		t2 = new JTextField(40);
        t2.setBounds(220, 144, 160, 20);
        getContentPane().add(t2);
        
		b1 = new JButton("ADD PRODUCT");
        b1.setBounds(142, 203, 183, 42);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.setForeground(Color.BLUE);
        b1.setBackground(Color.GREEN);
        getContentPane().add(b1);
        
		l1_1 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_1.setBounds(10, 420, 464, 19);
        l1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(l1_1);
    }
}