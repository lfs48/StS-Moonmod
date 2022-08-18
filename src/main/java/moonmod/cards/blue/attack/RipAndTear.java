package moonmod.cards.blue.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.blue.RipAndTearAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class RipAndTear extends BaseCard {

    public static final String ID = "Rip and Tear";
    public static final int COST = 1;
    public static final int BASE_DMG = 8;
    public static final int UPG_DMG = 3;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.BLUE
    );
  
    public RipAndTear() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.cardsToPreview = new Claw();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        DamageInfo info = new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn);
        addToBot((AbstractGameAction)new RipAndTearAction(m, info));    }

}