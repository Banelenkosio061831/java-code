
package tut.ac.za.Product;


public class Product
{
    private String productID;
    private int quantity;

    public Product(String productID, int quantity) 
    {
        this.productID = productID;
        this.quantity = quantity;
    }

   
    public String getProductID() 
    {
        return productID;
    }

    public int getQuantity()
    {
        return quantity;
    }
    
    
}
