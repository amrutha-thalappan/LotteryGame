
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amrutha Nair THALAPPAN
 */
public class Tolo {
    
    private ArrayList<Integer> drawnNumbers;
    ResultsTolo resultsTolo;
    
    private Bet bet;
    private SuperBet superBet;

    public Tolo() {
         
    }

    public ArrayList<Integer> getDrawnNumbers() {
        return drawnNumbers;
    }

    public int getGain (boolean isSuperBet, Object obj){

        int gainAmount = 0;
        int max = 20;
        int min = 1;
        
        Random rand = new Random(); 
        for (int i = 0; i < 4; i++) {
            int randNumber = rand.nextInt(max - min + 1) + min;
            System.out.println(randNumber);
            drawnNumbers.add(randNumber);
        }
        
        if(isSuperBet){
            max = 10;
            min = 1;
            superBet = (SuperBet) obj;
            int luckyRandNumber = rand.nextInt(max - min + 1) + min;
            System.out.println(luckyRandNumber);
            drawnNumbers.add(luckyRandNumber);
            gainAmount = superBet.computeGain(drawnNumbers);
        }else{
            bet = (Bet) obj;
            gainAmount = bet.computeGain(drawnNumbers);
        }
        
        if(resultsTolo != null)
        {
            resultsTolo.dispose();
           // resultsTolo
        }
        resultsTolo = new ResultsTolo(drawnNumbers, isSuperBet, gainAmount);
        resultsTolo.setLocationRelativeTo(null);
        resultsTolo.setTitle("Lottery Result");
        resultsTolo.setVisible(true);
        //resultsTolo.setModalExclusionType(Dialog.ModalExclusionType.DISPOSE_ON_CLOSE);
        
        resultsTolo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                resultsTolo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        return gainAmount;
    }
    
    public Bet createBet(int n1, int n2, int n3, int n4, int betMoney){
        drawnNumbers = new ArrayList<>();
        ArrayList numbers = new ArrayList();
        numbers.add(n1);
        numbers.add(n2);
        numbers.add(n3);
        numbers.add(n4);        
        bet = new Bet(numbers, betMoney);
        return bet;
    }
    
    public SuperBet createBet(int n1, int n2, int n3, int n4, int luckyN, int betMoney){
        drawnNumbers = new ArrayList<>();
        ArrayList numbers = new ArrayList();
        numbers.add(n1);
        numbers.add(n2);
        numbers.add(n3);
        numbers.add(n4);        
        superBet = new SuperBet(luckyN, numbers, betMoney);
        return superBet;
    }
    
}
