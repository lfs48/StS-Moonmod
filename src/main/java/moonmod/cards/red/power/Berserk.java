package moonmod.cards.red.power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.BerserkAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Berserk extends BaseCard {

    public static final String ID = "Berserk";
    public static final int COST = 1;
    public static final int UPG_COST = 0;
    public static final int BASE_MAGIC = 5;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.RARE, 
        CardColor.RED
    );
  
    public Berserk() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC);
        this.setCostUpgrade(UPG_COST);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new BerserkAction(this.magicNumber));
    }

}
