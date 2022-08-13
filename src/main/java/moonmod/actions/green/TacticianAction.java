package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TacticianAction extends AbstractGameAction {
  private int divideAmount;
  
  public TacticianAction(int divideAmountNum) {
    this.duration = Settings.ACTION_DUR_FAST;
    this.divideAmount = divideAmountNum;
  }
  
  public void update() {
    if (this.duration == Settings.ACTION_DUR_FAST)
      AbstractDungeon.player.gainEnergy(AbstractDungeon.player.discardPile.size() / this.divideAmount); 
    tickDuration();
  }
}