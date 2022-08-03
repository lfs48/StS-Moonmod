package moonmod.cards.red.power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.cards.BaseCard;
import moonmod.powers.red.JuggernautPower;
import moonmod.util.CardInfo;

public class Juggernaut extends BaseCard {

    public static final String ID = "Juggernaut";
    public static final int COST = 2;
    public static final int BASE_MAGIC = 5;
    public static final int UPG_MAGIC = 3;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Juggernaut() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new JuggernautPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
      }

}