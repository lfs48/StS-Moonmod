package moonmod.actions.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DiscountDrawnCardsAction extends AbstractGameAction {
  private int discountAmount;

  public DiscountDrawnCardsAction(int discountAmount) {
    this.discountAmount = discountAmount;
  }

  public void update() {
    AbstractDungeon.actionManager.addToTop((AbstractGameAction)new WaitAction(0.4F));
    tickDuration();
    if (this.isDone)
      for (AbstractCard c : DrawCardAction.drawnCards) {
        c.setCostForTurn(c.costForTurn - discountAmount);
      }  
  }
}