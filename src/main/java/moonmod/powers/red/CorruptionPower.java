package moonmod.powers.red;

import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.powers.BasePower;

public class CorruptionPower extends BasePower {

  public static final String POWER_ID = "Corruption";
  private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
  private static final boolean TURN_BASED = false;
  
  public CorruptionPower(AbstractCreature owner) {
    super(POWER_ID, TYPE, TURN_BASED, owner, 0);
  }

  public void applyPowers() {
    for (AbstractCard c : AbstractDungeon.player.hand.group) {
        if (c.type == CardType.SKILL) {
            c.setCostForTurn(-9);
        }
    }
  }

  public void onCardDraw(AbstractCard card) {
    if (card.type == AbstractCard.CardType.SKILL)
      card.setCostForTurn(-9); 
  }
  
  public void onUseCard(AbstractCard card, UseCardAction action) {
    if (card.type == AbstractCard.CardType.SKILL) {
      flash();
      action.exhaustCard = true;
    } 
  }
}