/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Lesson11;

public class ControlFlow {
    enum Suit{
        SPADE, DIAMONDS,CLUBS,HEARTS
    }

    public static void main(String[] args) {
        Suit suit = Suit.HEARTS;

        switch (suit) {
            case CLUBS:
                System.out.println("clubs");
                break;
            case DIAMONDS:
                System.out.println("diamonds");
        break;
            case HEARTS:
                System.out.println("hearts");
                break;
            case SPADE:
                System.out.println("spade");
                break;
            default:
                //asserted statement (prove that system works)
                assert false: suit;
        }
    }
}
