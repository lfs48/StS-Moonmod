package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Bloodletting extends BaseCard {

    public static final String ID = "Bloodletting";
    public static final int COST = 0;
    public static final int HP_LOSS = 2;
    public static final int BASE_MAGIC = 2;
    public static final int UPG_MAGIC = 1;

    public int eGain;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF,
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
  public Bloodletting() {
    super(cardInfo);
    this.setMagic(BASE_MAGIC, UPG_MAGIC);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new LoseHPAction((AbstractCreature)p, (AbstractCreature)p, HP_LOSS));
    addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));
  }

}