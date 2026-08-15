package tut.ac.za;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import tut.ac.za.Product.Product;
import tut.ac.za.StockCheck.StockCheck;

/**
 *
 * @author Banele
 */
public class InventoryManagement extends JFrame
{
    //declare JPanel
    private JPanel mainPnl;
    private JPanel ProductIDPnl;
    private JPanel QuantityPnl;
    private JPanel detailsPnl;
    private JPanel btnPnl;
    
    //declare JLabel
    private JLabel ProductIDLbl;
    private JLabel QuantityLbl;
    
    //declare JTextField
    private JTextField ProductIDFlb;
    private JTextField QuantityFlb;
    
    //declare JButton
    private JButton checkStockBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    
    
    public InventoryManagement()
    {
        setTitle("Inventory Managements");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));
       
        
        
        //Create a Panel
        detailsPnl = new JPanel(new GridLayout(2, 1, 5,5));
        
        //detailsPnl = new JPanel(new GridLayout(3,2));
        
            
        ProductIDPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        QuantityPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        btnPnl =  new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        //declare Label for Input
        ProductIDLbl = new JLabel("Enter ProductIDLbl:   ");
        QuantityLbl = new JLabel("Enter Quantity:        ");
        
        //declare TextField for Prompts the Input
        ProductIDFlb = new JTextField(10);
        QuantityFlb = new JTextField(10);
        
        
      
        
        //group your labels and textFields together in their panel
        ProductIDPnl.add(ProductIDLbl);
        ProductIDPnl.add(ProductIDFlb);
        
        QuantityPnl.add(QuantityLbl);
        QuantityPnl.add(QuantityFlb);
                
                
       //group JPanel in the detailsPnl
       detailsPnl.add(ProductIDPnl);
       detailsPnl.add(QuantityPnl);
       
       //Initialize buttons
       checkStockBtn = new JButton("Check Stock");
       
       checkStockBtn.addActionListener(e -> 
       {
       
        String id = ProductIDFlb.getText();
        int qty = Integer.parseInt(ProductIDFlb.getText());
    
        Product p = new Product(id, qty);
        StockCheck sc = new StockCheck(new File("inventory.txt"));

        if (sc.isProductInStock(p)) 
        {
             JOptionPane.showMessageDialog(null, "Product is in stock.");
        }
        else 
        {
          int restock = sc.getRestockAmount(p);
          JOptionPane.showMessageDialog(null, "Out of stock. Restock amount: " + restock);
        }
      });
      
       // Inside your constructor, after initializing buttons:
       /*checkStockBtn.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String productID = ProductIDFlb.getText().trim();
                String quantityStr = ProductIDFlb.getText().trim();
                
                if (productID.isEmpty() || quantityStr.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter both Product ID and Quantity.");
                    return;
                }
                
                try
                {
                    int quantity = Integer.parseInt(quantityStr);
                    Product product = new Product(productID, quantity);
                    StockCheck stockCheck = new StockCheck(" ");
                    
                    if (stockCheck.isProductInStock(product)) 
                    {
                        JOptionPane.showMessageDialog(null, "Product is in stock.");
                    }
                    else 
                    {
                        int restock = stockCheck.getRestockAmount(product);
                        JOptionPane.showMessageDialog(null, "Product is out of stock. Need to restock " + restock + " units.");
                    }
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Quantity must be a valid number.");
                }  }
        }); */

       
       clearBtn = new JButton("Clear");
       //Clear Prompt Information
       clearBtn.addActionListener(new clearStockListener());
       
       exitBtn = new JButton("Exit");
       //Exit Menu
       exitBtn.addActionListener(new exitStockListener());
       
             
       //Add buttons to button panel
       btnPnl.add(checkStockBtn);
       btnPnl.add(clearBtn);
       btnPnl.add(exitBtn);
       
      // mainPnl.add(detailsPnl, BorderLayout.CENTER);
      // mainPnl.add(btnPnl,BorderLayout.SOUTH);
      
      //Add panels to main Frame
      add(detailsPnl, BorderLayout.CENTER);
      add(btnPnl,BorderLayout.SOUTH);
       
      // add(mainPnl);
       pack();
       setVisible(true);
              
    }
    
    
    
    
    
    //declare the method Clear 
    public class clearStockListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            ProductIDFlb.setText("");
            QuantityFlb.setText("");
            
        }
    
    }
    
    
//declare the method exitStockListener
    public class exitStockListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    
    }  
}
