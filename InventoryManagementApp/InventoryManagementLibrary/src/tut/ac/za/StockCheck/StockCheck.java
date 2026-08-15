
package tut.ac.za.StockCheck;

/**
 *
 * @author Banele
 */


import java.io.*;
import java.util.*;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import tut.ac.za.Product.Product;

import tut.ac.za.Product.Product;

public class StockCheck 
{
   // private ArrayList<Product> products = new ArrayList<>();
     ArrayList<Product> products = new ArrayList<>();
    
    public StockCheck(File inventoryFile)
    {
        if (!inventoryFile.exists() || !inventoryFile.canRead()) 
        {
            System.err.println("Error: Inventory file does not exist or cannot be read.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFile)))
        {
            String line;
            
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length == 2)
                {
                    String id = parts[0].trim();
                    int qty = Integer.parseInt(parts[1].trim());
                    products.add(new Product(id, qty));
                }
            }
        } 
        catch (IOException | NumberFormatException e)
        {
            System.err.println("Error reading inventory file: " + e.getMessage());
        }
    }

    public boolean isProductInStock(Product requestedProduct) 
    {
        for (Product p : products)
        {
            if (p.getProductID().equalsIgnoreCase(requestedProduct.getProductID()))
            {
                return p.getQuantity() >= requestedProduct.getQuantity();
            }
        }
        return false;
    }

    public int getRestockAmount(Product requestedProduct) 
    {
        for (Product p : products)
        {
            if (p.getProductID().equalsIgnoreCase(requestedProduct.getProductID()))
            {
                int currentQty = p.getQuantity();
                return Math.max(0, 100 - currentQty); // Restock to full level (100)
            }
        }
        return 100; // Assume full restock needed if product not found
    }
    
}