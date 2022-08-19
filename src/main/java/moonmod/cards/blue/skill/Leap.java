package moonmod.cards.blue.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Leap extends BaseCard {

    public static final String ID = "Leap";
    public static final int COST = 1;
    public static final int BASE_MAGIC = 7;
    public static final int UPG_MAGIC = 3;
    public static final int BASE_BLOCK = 0;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.COMMON, 
        CardColor.BLUE
    );
  
    public Leap() {
        super(cardInfo);
        this.setBlock(BASE_BLOCK);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
    }

    public void applyPowers() {
        this.baseBlock = this.magicNumber + (EnergyPanel.totalCount - this.costForTurn);
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
      }

}