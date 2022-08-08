package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.cards.BaseCard;
import moonmod.powers.green.ChokePower;
import moonmod.util.CardInfo;

public class Choke extends BaseCard {

    public static final String ID = "Choke";
    public static final int COST = 2;
    public static final int BASE_DMG = 12;
    public static final int UPG_DMG = 2;
    public static final int BASE_MAGIC = 1;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public Choke() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new ChokePower((AbstractCreature)m, this.magicNumber), this.magicNumber));
      }

}