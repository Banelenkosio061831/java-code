
package hackathonapplicationarraysact;
import java.util.Random;
public class HackathonApplicationArraysAct 
{
    public static void main(String[] args)
    {
        // TODO code application logic here
        String[] Universities = {"TUT","NWU","UP","UL","WSU","VUT","UJ"};
        int[] JugeScore = {75,65,60,55,60,70,77};
        int[] OnlineScore = new int[Universities.length];
        int[] TotalScore = new int[Universities.length];
        int min =5;
        int max = 100;
        
         Random rand = new Random();
         
        //Declare variable 
        for(int a=0; a < OnlineScore.length; a++)
        {
            OnlineScore[a] = rand.nextInt(max-min)+min;
        }
        
        //Sum of Totals Scores
        for(int b=0; b < TotalScore.length; b++)
        {
            TotalScore[b] = JugeScore[b]+OnlineScore[b];
        
        }
        
        //Display Output 
        System.out.println("Universities\t\tJudge Score\t\tOnline Score\t\tTota Score");
        for(int c =0; c<Universities.length; c++)
        {
            System.out.println(Universities[c]+"\t\t\t"+JugeScore[c]+"\t\t\t"+OnlineScore[c]+"\t\t\t"+TotalScore[c]);
        
        }
        
        //Total Highest Score
        int index = -1;
        int HighestSore = TotalScore[0];
        
       for(int d=0; d < TotalScore.length; d++)
       {
           if(HighestSore < TotalScore[d])
           {
               HighestSore =TotalScore[d];
               index = d;
           }
       }
       
        System.out.println("The Hackathon is "+Universities[index]+"\tTotal Score "+TotalScore[index]);
    }
    
}
