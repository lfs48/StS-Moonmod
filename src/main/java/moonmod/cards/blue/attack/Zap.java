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

public class Zap extends BaseCard {

    public static final String ID = "Zap";
    public static final int COST = 0;
    public static final int BASE_DMG = 3;
    public static final int UPG_DMG = 2;
    public static final int BASE_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.BASIC, 
        CardColor.BLUE
    );
  
    public Zap() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC);
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        DamageInfo info = new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn);
        addToBot((AbstractGameAction)new LightningAttackAction(m, info));
        addToBot((AbstractGameAction)new ChannelAction((AbstractOrb)new Lightning())); 
    }

}