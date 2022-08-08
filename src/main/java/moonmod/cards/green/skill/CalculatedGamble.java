package moonmod.cards.green.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.CalculatedGambleAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class CalculatedGamble extends BaseCard {

    public static final String ID = "Calculated Gamble";
    public static final int COST = 0;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.NONE, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public CalculatedGamble() {
        super(cardInfo);
        this.setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToTop((AbstractGameAction)new CalculatedGambleAction(this.upgraded));
      }

}