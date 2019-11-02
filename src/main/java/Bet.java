
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
public class Bet {
    
    final private ArrayList<Integer> numbers;
    final private int betMoney;
    
    
    public Bet(ArrayList<Integer> numbers, int betMoney) {
        this.numbers = numbers;
        this.betMoney = betMoney;
    }
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
    public int getBetMoney() {
        return betMoney;
    }
    
    public int computeGain(ArrayList<Integer> drawnNumbers){
        int gainAmount = 0;
        long noOfMatches = numbers.stream().filter(num -> drawnNumbers.contains(num) ).count();
        if(noOfMatches == 3){
            gainAmount = 5*betMoney;
            System.out.println("gainAmount (3) = " + gainAmount);
        }else if(noOfMatches == 4){
            gainAmount = 50*betMoney;
            System.out.println("gainAmount (4) = " + gainAmount);
        }
        return gainAmount;
    } 
    
    
}
