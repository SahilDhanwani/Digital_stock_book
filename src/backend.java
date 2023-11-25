import javax.swing.table.DefaultTableModel;
import java.sql.*;

class backend 
{
    Connection con;
    Statement smt;
    PreparedStatement psmt;

    public backend()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@SahilD_PC:1521:orcl","system","352023");
        }
        catch(Exception e)
        {
            System.out.println("ERROR IS GENERATED IN CONNECTING ORACLE");
            System.out.print(e);
        }
    }

    public int pswd_check(String usr_name,String pswd)
    {
        String pswd_temp;
        int id;
        try
        {
            System.out.println("SELECT DSB_ID,password from admin where user_name = '" +usr_name +"'");
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT DSB_ID,password from admin where user_name = '" +usr_name +"'");
            
            while(rs.next())
            {
                System.out.println("INSIDE RS.NEXT");
                id = rs.getInt(1);
                pswd_temp = rs.getString(2);
                System.out.println(id);
                System.out.println(pswd_temp);
                if(pswd.equals(pswd_temp))
                {
                    System.out.println("ID returned");
                return id;
                }
                else 
                {
                    System.out.println("ELSE ");
                    return 0;
                }
            }
            return 0;
        }
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN IN CHECKING PSWD (BACKEND) : ");
            System.out.println(e);
            return 0;
        }   
    }

    public int insert_admin(String usr_name,String pswd,String bns_name,String prp_name,double mob,String mail,String cat)
    {
        try 
        {
            psmt = con.prepareStatement("INSERT INTO ADMIN VALUES (?,DSB_ID.nextval,?,?,?,?,?,?)");
            psmt.setString(1, usr_name);
            psmt.setString(2, pswd);
            psmt.setString(3, bns_name);
            psmt.setString(4, prp_name);
            psmt.setDouble(5, mob);
            psmt.setString(6, mail);
            psmt.setString(7, cat);

            psmt.executeUpdate();

            System.out.println("DATA INSERTED");
            return (pswd_check(usr_name, pswd));

        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN INSERT ADMIN(BACKEND)");
            e.printStackTrace();
            return 0;
        }
    }
    
    public void insert_product(int DSB_ID,String product_id,String Product_name)
    {
        try 
        {
            psmt = con.prepareStatement("INSERT INTO stock_overview(product_ID,product_name,DSB_ID) VALUES (?,?,?)");
            psmt.setString(1, product_id);
            psmt.setString(2, Product_name);
            psmt.setInt(3, DSB_ID);
            psmt.executeUpdate();
            System.out.println("NEW PRODUCT ADDED");
        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN INSERT PRODUCT");
            e.printStackTrace();
        }

    }
    
    public void insert_txn_and_update(String type,String product_id,int DSB_ID,int qty,float amt)
    {
        int pur_qty,sale_qty,curr_stock;
        float pur_amt,sale_amt,net_p_l;

        try 
        {
            psmt = con.prepareStatement("INSERT INTO transactions VALUES (?,?,?,?,?,to_date(sysdate),txn_ID.nextval)");
            psmt.setString(1, type);
            psmt.setString(2, product_id);
            psmt.setInt(3, DSB_ID);
            psmt.setInt(4,qty);
            psmt.setFloat(5, amt);
            psmt.executeUpdate();
            System.out.println("NEW PRODUCT ADDED");
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select pur_qty,sale_qty,pur_amt,sale_amt,curr_stock,P_or_L from stock_overview where DSB_ID = " +DSB_ID +" and product_ID = "+product_id);

            while(rs.next())
            {
                
                pur_qty = rs.getInt(1);
                sale_qty = rs.getInt(2);
                pur_amt = rs.getFloat(3);
                sale_amt = rs.getFloat(4);
                curr_stock = rs.getInt(5);
                net_p_l = rs.getFloat(6);

                if(type.equals("Sales"))
                {
                    sale_amt += amt;
                    sale_qty += qty;
                    curr_stock -= qty;
                }
                else
                {
                    pur_amt += amt;
                    pur_qty += qty;
                    curr_stock += qty;
                }
                net_p_l = sale_amt - pur_amt;
                smt = con.createStatement();
                smt.executeUpdate("update stock_overview set pur_qty = "+pur_qty +", sale_qty = " +sale_qty +", pur_amt = " +pur_amt +", sale_amt = " +sale_amt +", curr_stock = " +curr_stock +", P_or_L = " +net_p_l +" where DSB_ID = " +DSB_ID +" and product_ID = " +product_id);
            }   System.out.println("QUERY UPDATED");
        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN INSERT PRODUCT");
            e.printStackTrace();
        }
    }
    
    public DefaultTableModel showAllTxn(int DSB_ID)
    {
    	DefaultTableModel model = new DefaultTableModel();
    	
    	model.addColumn("TXN ID");
        model.addColumn("TYPE");
        model.addColumn("PRODUCT ID");
        model.addColumn("QTY");
        model.addColumn("AMOUNT");
        model.addColumn("DATE");
        
        String [] data;
        data = new String[6];

        try
        {
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select txn_ID,type,product_ID,qty,amt,txn_date from transactions where DSB_ID = " +DSB_ID);
            while(rs.next())
            {
                data[0] = Integer.toString(rs.getInt(1));
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = Integer.toString(rs.getInt(4));
                data[4] = Float.toString(rs.getFloat(5));
                data[5] = rs.getDate(6).toString();
                model.addRow(data);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN showAllTxn");
            e.printStackTrace();
        }
        
        return model;
    }

    public DefaultTableModel showProductTxn(String product_id,int DSB_ID)
    {
        
        String [] data;
        data = new String[6];
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("TXN ID");
        model.addColumn("TYPE");
        model.addColumn("PRODUCT ID");
        model.addColumn("QTY");
        model.addColumn("AMOUNT");
        model.addColumn("DATE");

        try
        {
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select txn_ID,type,product_ID,qty,amt,txn_date from transactions where DSB_ID = " +DSB_ID +" and product_ID = " +product_id);
            
            while(rs.next())
            {
                data[0] = Integer.toString(rs.getInt(1));
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = Integer.toString(rs.getInt(4));
                data[4] = Float.toString(rs.getFloat(5));
                data[5] = rs.getDate(6).toString();
                model.addRow(data);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN showAllTxn");
            e.printStackTrace();
        }
        
        return model;
    } 

    public DefaultTableModel showStockBook(int DSB_ID)
    {
    	String [] data;
        data = new String[8];
        
    	DefaultTableModel model = new DefaultTableModel();
    	model.addColumn("PRO ID");
        model.addColumn("PROD NAME");
        model.addColumn("PUR QTY");
        model.addColumn("SALE QTY");
        model.addColumn("NET PUR AMT");
        model.addColumn("NET SALE AMT");
        model.addColumn("CURR STOCK");
        model.addColumn("NET PF/LS");
        try
        {
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select product_ID,product_name,pur_qty,sale_qty,pur_amt,sale_amt,curr_stock,P_or_L from stock_overview where DSB_ID = " +DSB_ID);
            while(rs.next())
            {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = Integer.toString(rs.getInt(3));
                data[3] = Integer.toString(rs.getInt(4));
                data[4] = Float.toString(rs.getFloat(5));
                data[5] = Float.toString(rs.getFloat(6));
                data[6] = Integer.toString(rs.getInt(7));
                data[7] = Float.toString(rs.getFloat(8));
                model.addRow(data);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN showAllTxn");
            e.printStackTrace();
        }
        
        return model;
    }

    public void close()
    {
        try 
        {
            con.close();
            System.out.println("CONNECTION CLOSED SUCCESSFULLY");
        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR GENERATED IN CLOSING CONNECTION (BACKEND)");
            e.printStackTrace();
        }       
    }
}