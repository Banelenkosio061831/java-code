/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.lecture;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oop.qualification.Qualification;

/**
 *
 * @author Banele
 */
public class Lecture
{
    private String surname;
    private ArrayList<Qualification> qualifications;

    public Lecture(String surname) 
    {
        this.surname = surname;
        qualifications  = new ArrayList<Qualification>();
    }

    public void addQualification(Qualification pQ)
    {
        qualifications.add(pQ);
    
    }
    
    
    public void removeQualification(Qualification pQ)
    {
        int index=0;
        Qualification temp;
        
        for(int a=0; a < qualifications.size(); a++)
        {
            temp = qualifications.get(a);
            
            if(temp.getDegree().equals(pQ.getDegree()))
            {
                index = a;
                qualifications.remove(index);
                break;
            }
        }
        
        if(index==-1)
        {
            JOptionPane.showMessageDialog(null,"No qualification");
        }
    
    }
    
    
    
    public ArrayList<Qualification> getQualifications() 
    {
        return qualifications;
    }
    
    public String highestQualification(Qualification pQ)
    {
        int highest = 0;//qualifation.get(0).getLevel();
        String high ="";
        
        for(Qualification g: qualifications)
        {
            if(g.getLevel()> highest)
            {
                highest = g.getLevel();
                high = g.getDegree();           
            }
        }     
   
        return high;
    }

    public Object highestQualification() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
