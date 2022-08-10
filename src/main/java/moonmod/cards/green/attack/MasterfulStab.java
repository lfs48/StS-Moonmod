package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class MasterfulStab extends BaseCard {

    public static final String ID = "Masterful Stab";
    public static final int COST = 1;
    public static final int BASE_DMG = 3;
    public static final int BASE_MAGIC = 3;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.RARE, 
        CardColor.GREEN
    );
  
    public MasterfulStab() {
        super(cardInfo);
        this.setDamage(BASE_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < this.magicNumber; i++)
            addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AttackEffect.SLASH_VERTICAL)); 
    }

    public void applyPowers() {
        AbstractPower strength = AbstractDungeon.player.getPower("Strength");
        AbstractPower dex = AbstractDungeon.player.getPower("Dexterity");
        int tmpStr = 0;

        if (strength != null) {
            tmpStr = strength.amount;
            if (dex != null)
                strength.amount = dex.amount;
            else
                strength.amount = 0;
        } else if (strength == null && dex != null) {
            this.baseDamage = BASE_DMG + dex.amount;
        }
        super.applyPowers();
        if (strength != null)
            strength.amount = tmpStr;
        if (dex != null)
            this.isDamageModified = true;
    }

    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower strength = AbstractDungeon.player.getPower("Strength");
        AbstractPower dex = AbstractDungeon.player.getPower("Dexterity");
        int tmpStr = 0;

        if (strength != null) {
            tmpStr = strength.amount;
            if (dex != null)
                strength.amount = dex.amount;
            else
                strength.amount = 0;
        } else if (strength == null && dex != null) {
            this.baseDamage = BASE_DMG + dex.amount;
        }
        super.calculateCardDamage(mo);
        if (strength != null)
            strength.amount = tmpStr;
        if (dex != null)
            this.isDamageModified = true;
    }

}