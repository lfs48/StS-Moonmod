package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class FlyingKnee extends BaseCard {

    public static final String ID = "Flying Knee";
    public static final int COST = 1;
    public static final int BASE_DMG = 8;
    public static final int UPG_DMG = 1;
    public static final int BASE_MAGIC = 1;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.COMMON, 
        CardColor.GREEN
    );
  
    public FlyingKnee() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EnergizedPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
      }

}