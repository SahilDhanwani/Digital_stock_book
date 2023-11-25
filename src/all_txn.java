import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class all_txn extends JFrame
{
	private JLabel l1_1;
	private JTable table;
	private DefaultTableModel model;
	
    public all_txn(backend be,int DSB_ID)
    {
    	model = be.showAllTxn(DSB_ID);
    	
        frame_setup();
    }
    public void frame_setup()
    {
    	getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE = 3;
        System.out.println("ALL TXN FRAME CREATED");
        getContentPane().setLayout(null);
        
        JLabel l1 = new JLabel("ALL TRANSACTIONS : ");
        l1.setBounds(116, 5, 252, 31);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(l1);
        
        l1_1 = new JLabel("A PROJECT BY : Sahil D & Pallavi K");
        l1_1.setBounds(10, 431, 464, 19);
        l1_1.setHorizontalAlignment(SwingConstants.CENTER);
        l1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        getContentPane().add(l1_1);
        
        table = new JTable();
        table.setModel(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 47, 464, 373);
        getContentPane().add(sp);
    }
}