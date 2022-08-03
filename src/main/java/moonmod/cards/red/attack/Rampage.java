package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ModifyDamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Rampage extends BaseCard {

    public static final String ID = "Rampage";
    public static final int COST = 1;
    public static final int BASE_DMG = 8;
    public static final int UPG_DMG = 2;
    public static final int BASE_MAGIC = 5;
    public static final int UPG_MAGIC = 3;

    public int timesUsed;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Rampage() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
        this.timesUsed = 0;
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot((AbstractGameAction)new ModifyDamageAction(this.uuid, this.magicNumber));
        this.timesUsed += 1;
        this.baseMagicNumber += this.timesUsed;
        this.magicNumber = this.baseMagicNumber;
    }

}