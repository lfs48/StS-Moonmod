package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Bane extends BaseCard {

    public static final String ID = "Bane";
    public static final int COST = 1;
    public static final int BASE_DMG = 7;
    public static final int UPG_DMG = 3;
    public static final int BASE_MAGIC = 7;
    public static final int UPG_MAGIC = 3;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public Bane() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        DamageInfo info = new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn);
        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, info, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        addToBot((AbstractGameAction)new moonmod.actions.green.BaneAction(m, info, this.magicNumber));
    }

}