package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.red.HavocAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Havoc extends BaseCard {

    public static final String ID = "Havoc";
    public static final int COST = 1;
    public static final int UPG_COST = 0;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.NONE, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Havoc() {
        super(cardInfo);
        this.setCostUpgrade(UPG_COST);
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new HavocAction());
    }

}