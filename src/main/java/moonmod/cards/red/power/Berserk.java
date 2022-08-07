package moonmod.cards.red.power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.red.BerserkAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Berserk extends BaseCard {

    public static final String ID = "Berserk";
    public static final int COST = 0;
    public static final int BASE_MAGIC = 5;
    public static final int UPG_MAGIC = 3;

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
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new BerserkAction(this.magicNumber));
    }

}
