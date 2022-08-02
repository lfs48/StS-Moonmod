package moonmod.cards.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Flex extends BaseCard {

  public static final String ID = "Flex";
  public static final int COST = 0;
  public static final int BASE_MAGIC = 3;
  public static final int UPG_MAGIC = 2;

  private final static CardInfo cardInfo = new CardInfo(
      ID, 
      COST, 
      CardType.SKILL, 
      CardTarget.SELF, 
      CardRarity.COMMON, 
      CardColor.RED
  );
  
  public Flex() {
    super(cardInfo);
    this.setMagic(BASE_MAGIC, UPG_MAGIC);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new LoseStrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
  }

}