package moonmod.cards.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.MetallicizePower;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Metallicize extends BaseCard {

    public static final String ID = "Metallicize";
    public static final int COST = 1;
    public static final int BASE_MAGIC = 4;
    public static final int UPG_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Metallicize() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new MetallicizePower((AbstractCreature)p, this.magicNumber), this.magicNumber));
    }

}