package moonmod.cards.green.power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.powers.WraithFormPower;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class WraithForm extends BaseCard {

    public static final String ID = "Wraith Form v2";
    public static final int COST = 3;
    public static final int BASE_MAGIC = 3;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.RARE, 
        CardColor.GREEN
    );
  
    public WraithForm() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC);
        this.setEthereal(true, false);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new IntangiblePlayerPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new WraithFormPower((AbstractCreature)p, -1), -1));
    }

}