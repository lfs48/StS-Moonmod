package moonmod.cards.blue.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;

import moonmod.actions.common.LightningAttackAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class BallLightning extends BaseCard {

    public static final String ID = "Ball Lightning";
    public static final int COST = 1;
    public static final int BASE_DMG = 7;
    public static final int UPG_DMG = 3;
    public static final int BASE_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.COMMON, 
        CardColor.BLUE
    );
  
    public BallLightning() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        DamageInfo info = new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn);
        addToBot((AbstractGameAction)new LightningAttackAction(m, info));
        addToBot((AbstractGameAction)new ChannelAction((AbstractOrb)new Lightning())); 
    }

}