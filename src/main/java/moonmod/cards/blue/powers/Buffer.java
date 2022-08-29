package moonmod.cards.blue.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.cards.BaseCard;
import moonmod.powers.blue.BufferPower;
import moonmod.util.CardInfo;

public class Buffer extends BaseCard {

    public static final String ID = "Buffer";
    public static final int COST = 2;
    public static final int BASE_MAGIC = 1;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.RARE, 
        CardColor.BLUE
    );
  
    public Buffer() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new BufferPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
      }

}