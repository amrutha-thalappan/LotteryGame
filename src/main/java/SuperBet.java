
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amrutha Nair THALAPPAN
 */
public class SuperBet extends Bet{
    
    final private int luckyNumber;

    public SuperBet(int luckyNumber, ArrayList<Integer> numbers, int betMoney) {
        super(numbers, betMoney);
        this.luckyNumber = luckyNumber;
    }

    
    
    public int getLuckyNumber() {
        return luckyNumber;
    }

    @Override
    public int computeGain(ArrayList<Integer> drawnNumbers) {
        int superBetLuckyNumber = drawnNumbers.get(4);
        drawnNumbers.remove(4);
        int gainAmount = super.computeGain(drawnNumbers);
        drawnNumbers.add(superBetLuckyNumber);
        if(luckyNumber == superBetLuckyNumber){
            gainAmount = 5*gainAmount;
            System.out.println("Lucky Match");
            System.out.println("gainAmount (5) = " + gainAmount);
        }
        return gainAmount;
    }   
}
