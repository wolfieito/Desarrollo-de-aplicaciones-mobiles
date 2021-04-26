package com.example.aaa;

import java.util.ArrayList;

public class randomCardGetter {

    private ArrayList<Integer> disponibleCards;

    public randomCardGetter(){
        disponibleCards= new ArrayList<>();
        initCards();
    }

    public void initCards(){
        for (int i = 0; i < 52;i++)
            disponibleCards.add(new Integer(i+1));
    }

    public void updateDisponibleCards(int chosenCard){

        disponibleCards.remove(new Integer(chosenCard));
    }

    public Card getRandomCard(){
        int cardIndex = (int) (Math.random()*disponibleCards.size());
        int chosenCard = disponibleCards.get(cardIndex);
        updateDisponibleCards(chosenCard);
        return new Card(CardGetter.getCard(chosenCard),convertTagNumberToValue(chosenCard));

    }

    private int convertTagNumberToValue(int chosenCard){
        int cardValue;
        cardValue = (chosenCard)%13;

        if(cardValue == 0)
            cardValue = 13;

        return cardValue;
    }

}
