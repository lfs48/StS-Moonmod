package moonmod.cards.red.power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DarkEmbracePower;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class DarkEmbrace extends BaseCard {

    public static final String ID = "Dark Embrace";
    public static final int COST = 2;
    public static final int UPG_COST = 1;
    public static final int BASE_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.RARE, 
        CardColor.RED
    );
  
    public DarkEmbrace() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC);
        this.setCostUpgrade(UPG_COST);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DarkEmbracePower((AbstractCreature)p, this.magicNumber), this.magicNumber));
    }

}