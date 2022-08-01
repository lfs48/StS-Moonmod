package moonmod.cards.red;

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
    public static final int BASE_HP_LOSS = 3;
    public static final int UPG_HP_LOSS = -1;
    public static final int BASE_E_GAIN = 2;
    public static final int UPG_E_GAIN = 1;

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
    this.eGain = BASE_E_GAIN;
    this.setMagic(BASE_HP_LOSS, UPG_HP_LOSS);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new LoseHPAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber));
    addToBot((AbstractGameAction)new GainEnergyAction(this.eGain));
  }

  @Override
  public void upgrade() {
    super.upgrade();
    this.eGain += UPG_E_GAIN;
  }

}