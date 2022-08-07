package moonmod.actions.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;

public class SecondWindAction extends AbstractGameAction {
  private int healPerCard;
  
  public SecondWindAction(int healAmount) {
    this.healPerCard = healAmount;
    setValues((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player);
    this.actionType = AbstractGameAction.ActionType.BLOCK;
  }
  
  public void update() {
    ArrayList<AbstractCard> cardsToExhaust = new ArrayList<>();
    for (AbstractCard c : AbstractDungeon.player.hand.group) {
      if (c.type != AbstractCard.CardType.ATTACK)
        cardsToExhaust.add(c); 
    } 
    for (AbstractCard c : cardsToExhaust)
      addToTop((AbstractGameAction)new HealAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, this.healPerCard)); 
    for (AbstractCard c : cardsToExhaust)
      addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand)); 
    this.isDone = true;
  }
}