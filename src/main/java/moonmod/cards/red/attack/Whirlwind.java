package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Whirlwind extends BaseCard {

    public static final String ID = "Whirlwind";
    public static final int COST = -1;
    public static final int BASE_DMG = 5;
    public static final int UPG_DMG = 3;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Whirlwind() {
        super(cardInfo);
        this.isMultiDamage = true;
        this.setDamage(BASE_DMG, UPG_DMG);
        this.tags.add(AbstractCard.CardTags.STRIKE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new WhirlwindAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
    }

}