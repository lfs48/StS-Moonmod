package moonmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class LimitBreakAction extends AbstractGameAction {
  private AbstractPlayer p = AbstractDungeon.player;
  private boolean upgraded;

  public LimitBreakAction(boolean upgraded) {
    this.upgraded = upgraded;
  }
  
  public void update() {
    if (this.p.hasPower(StrengthPower.POWER_ID)) {
      int strAmt = (this.p.getPower(StrengthPower.POWER_ID)).amount;
      if (this.upgraded)
        strAmt += strAmt;
      addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)this.p, (AbstractCreature)this.p, (AbstractPower)new StrengthPower((AbstractCreature)this.p, strAmt), strAmt));
    } 
    tickDuration();
  }
}
