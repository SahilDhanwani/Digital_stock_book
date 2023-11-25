import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class dashboard extends JFrame
{
    JButton b1,b2,b3,b4;
    private JLabel l1_1;
    private DefaultTableModel model;
    private JTable table;
    
    dashboard(backend be, int DSB_ID)
    {
    	model = be.showStockBook(DSB_ID);
    	
        frame_setup();
        
        b1.addActionListener(ae ->
        {
            dispose();
            new add_product(be,DSB_ID);
        });

        b2.addActionListener(ae -> 
        {
            new all_txn(be,DSB_ID);
        });

        b3.addActionListener( ae ->
        {
            new product_txn(be,DSB_ID);
        });
        b4.addActionListener(ae -> 
        {
            dispose();
            new add_txn(be,DSB_ID);
        });

    }
    public void frame_setup()
    {
    	getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        getContentPane().setLayout(null);
        
        JLabel l1 = new JLabel("STOCK DASHBOARD");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        l1.setBounds(10, 9, 564, 25);
        getContentPane().add(l1);
        
        b1 = new JButton("NEW PRODUCT");
        b1.setForeground(new Color(0, 0, 255));
        b1.setBackground(new Color(0, 255, 0));
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBounds(316, 62, 219, 27);
        getContentPane().add(b1);
        
        b2 = new JButton("ALL TRANSACTIONS");
        b2.setForeground(new Color(0, 0, 255));
        b2.setBackground(new Color(0, 255, 0));
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setBounds(54, 62, 240, 27);
        getContentPane().add(b2);
        
        b3 = new JButton("PRODUCT TRANSACTION");
        b3.setForeground(new Color(0, 0, 255));
        b3.setBackground(new Color(0, 255, 0));
        b3.setFont(new Font("Tahoma", Font.BOLD, 15));
        b3.setBounds(54, 96, 240, 27);
        getContentPane().add(b3);
        
        b4 = new JButton("NEW TRANSACTION");
        b4.setForeground(new Color(0, 0, 255));
        b4.setBackground(new Color(0, 255, 0));
        b4.setFont(new Font("Tahoma", Font.BOLD, 15));
        b4.setBounds(316, 96, 219, 27);
        getContentPane().add(b4);
        
        l1_1 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_1.setHorizontalAlignment(SwingConstants.CENTER);
        l1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1_1.setBounds(10, 536, 564, 14);
        getContentPane().add(l1_1);
        
        table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);
        table.setFillsViewportHeight(true);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(61, 154, 452, 354);
        getContentPane().add(scrollPane);
    }
}
