package moonmod.cards.blue.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.NewRipAndTearAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class RipAndTear extends BaseCard {

    public static final String ID = "Rip and Tear";
    public static final int COST = 1;
    public static final int BASE_DMG = 7;
    public static final int UPG_DMG = 2;
    public static final int BASE_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.COMMON, 
        CardColor.BLUE
    );
  
    public RipAndTear() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < this.magicNumber; i++)
            addToBot((AbstractGameAction)new NewRipAndTearAction(this)); 
    }

}