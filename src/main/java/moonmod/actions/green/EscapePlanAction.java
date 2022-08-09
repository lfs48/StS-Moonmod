package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class EscapePlanAction extends AbstractGameAction {
    private AbstractCreature p = (AbstractCreature)AbstractDungeon.player;
  private int blockGain;
  private int maxRepeat;
  private int timesRepeated;
  
  public EscapePlanAction(int blockGain, int maxRepeat, int timesRepeated) {
    this.duration = 0.0F;
    this.actionType = AbstractGameAction.ActionType.WAIT;
    this.blockGain = blockGain;
    this.maxRepeat = maxRepeat;
    this.timesRepeated = timesRepeated;
  }
  
  public void update() {
    for (AbstractCard c : DrawCardAction.drawnCards) {
      if (c.type == AbstractCard.CardType.SKILL) {
        if (timesRepeated < maxRepeat) {
            addToTop((AbstractGameAction)new DrawCardAction(1, (AbstractGameAction)new EscapePlanAction(this.blockGain, this.maxRepeat, timesRepeated + 1)));  
        }
        addToTop((AbstractGameAction)new GainBlockAction(p, p, this.blockGain));
        addToTop((AbstractGameAction)new WaitAction(0.1F));
        break;
      } 
    } 
    this.isDone = true;
  }
}
