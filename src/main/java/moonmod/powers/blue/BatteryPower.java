package moonmod.powers.blue;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import moonmod.powers.BasePower;

public class BatteryPower extends BasePower {

  public static final String POWER_ID = "Battery";
  private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
  private static final boolean TURN_BASED = true;

  public BatteryPower(AbstractCreature owner, int amount) {
      super(POWER_ID, TYPE, TURN_BASED, owner, amount);
  }
  
  public void updateDescription() {
    if (this.amount <= 1) {
      this.description = DESCRIPTIONS[0];
    } else {
      this.description = DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
    } 
  }

  public void atEndOfRound() {
    if (this.amount == 0) {
      addToBot((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "Battery"));
    } else {
      AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ReducePowerAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, "Battery", 1));
    }
  }
  
}