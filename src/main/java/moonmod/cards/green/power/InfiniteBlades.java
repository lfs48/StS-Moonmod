package moonmod.cards.green.power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.cards.BaseCard;
import moonmod.powers.green.InfiniteBladesPower;
import moonmod.util.CardInfo;

public class InfiniteBlades extends BaseCard {

    public static final String ID = "Infinite Blades";
    public static final int COST = 2;
    public static final int UPG_COST = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public InfiniteBlades() {
        super(cardInfo);
        this.setCostUpgrade(UPG_COST);
        this.cardsToPreview= new Shiv();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new InfiniteBladesPower((AbstractCreature)p, 1), 1));
      }

}