import java.util.*; 
class Card { 
    String suit; 
    String rank; 
    public Card(String rank, String suit) { 
        this.rank = rank; 
        this.suit = suit; 
    } 
    public String toString() { 
        return rank + " of " + suit; 
    } 

} 
class CardCollectionSystem { 
    Set<String> cards = new HashSet<>(); 
    Map<String, List<Card>> suitMap = new HashMap<>(); 
    public void addCard(String rank, String suit) { 
        String cardKey = rank + " of " + suit; 
        if (cards.contains(cardKey)) { 
            System.out.println("Error: Card \"" + cardKey + "\" already exists."); 
            return; 
        } 
        cards.add(cardKey); 
        suitMap.putIfAbsent(suit, new ArrayList<>()); 
        suitMap.get(suit).add(new Card(rank, suit)); 
        System.out.println("Card added: " + cardKey); 
    } 
    public void findCardsBySuit(String suit) { 
        if (suitMap.containsKey(suit) && !suitMap.get(suit).isEmpty()) { 
            for (Card card : suitMap.get(suit)) { 
                System.out.println(card); 
            } 
        } else { 
            System.out.println("No cards found for " + suit + "."); 
        } 

    } 
    public void removeCard(String rank, String suit) { 
        String cardKey = rank + " of " + suit; 
        if (cards.remove(cardKey)) { 
            suitMap.get(suit).removeIf(card -> card.rank.equals(rank)); 
            System.out.println("Card removed: " + cardKey); 
        } else { 
            System.out.println("Error: Card \"" + cardKey + "\" not found."); 
        } 
    } 
    public void displayAllCards() { 
        if (cards.isEmpty()) { 
            System.out.println("No cards found."); 
        } else { 
            for (String card : cards) { 
                System.out.println(card); 
            }}}} 
public class CardMain { 
    public static void main(String[] args) { 
        CardCollectionSystem ccs = new CardCollectionSystem(); 
        ccs.displayAllCards(); 
        ccs.addCard("Ace", "Spades"); 
        ccs.addCard("King", "Hearts"); 
 
        ccs.addCard("10", "Diamonds"); 
        ccs.addCard("5", "Clubs"); 
        ccs.findCardsBySuit("Hearts"); 
        ccs.findCardsBySuit("Diamonds"); 
        ccs.displayAllCards(); 
        ccs.addCard("King", "Hearts"); 
        ccs.removeCard("10", "Diamonds"); 
    } 
} 
