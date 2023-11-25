import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class product_txn extends JFrame
{
    JButton b1;
    JTextField t1;
    private JLabel l1_1;
    private JLabel l1_2;
    private JTable table;
    private DefaultTableModel model;
    
    product_txn(backend be,int DSB_ID)
    {
    	
    	frame_setup();
        b1.addActionListener(ae ->
        {
        	String product_id = t1.getText();
        	model = be.showProductTxn(product_id,DSB_ID);
        	table = new JTable();
            table.setModel(model);
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(22, 102, 538, 409);
            getContentPane().add(sp);
        });
    }

    public void frame_setup()
    {
    	getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame
        .EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("product_txn FRAME CREATED");
        getContentPane().setLayout(null);
        
        JLabel l1 = new JLabel("PRODUCT TRANSACTION");
        l1.setFont(new Font("Tahoma", Font.BOLD, 25));
        l1.setForeground(Color.RED);
        l1.setBounds(137, 15, 313, 31);
        getContentPane().add(l1);
        
        l1_1 = new JLabel("ENTER PRODUCT ID :");
        l1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_1.setBackground(Color.ORANGE);
        l1_1.setBounds(25, 56, 154, 27);
        getContentPane().add(l1_1);
        
        t1 = new JTextField(15);
        t1.setBounds(189, 58, 135, 26);
        getContentPane().add(t1);
        
        b1 = new JButton("GET TRANSACTIONS");
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setForeground(Color.BLUE);
        b1.setBackground(Color.GREEN);
        b1.setBounds(334, 57, 218, 27);
        getContentPane().add(b1);
        
        l1_2 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_2.setHorizontalAlignment(SwingConstants.CENTER);
        l1_2.setForeground(Color.BLACK);
        l1_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
        l1_2.setBackground(Color.ORANGE);
        l1_2.setBounds(10, 531, 564, 19);
        getContentPane().add(l1_2);   
    }
}