

package arraylistdatamemberlecture;

import javax.swing.JOptionPane;
import oop.lecture.Lecture;
 
/**
 *
 * @author Banele
 */
public class ArrayListDataMemberLecture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Qualification q1 = Qualification("Dimploma IT",2005,2);
        Qualification q2 = Qualification("MSc in Computer Science",2000,3);
        Qualification q3 = Qualification("PHd in Computer Science",2001,4);
        Qualification q4 = Qualification("MSc in Mathematics IT",2004,5);
        
        
        Lecture ll = new Lecture("Lail");
     
        ll.addQualification(q1);
        ll.addQualification(q2);
        ll.addQualification(q3);
        ll.addQualification(q4);
        
        JOptionPane.showMessageDialog(null, ll.getQualifications());
        
        JOptionPane.showMessageDialog(null,ll.highestQualification());
    }
    
    
    
    
    
    
    

    private static Qualification Qualification(String dimploma_IT, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
}
