package moonmod.powers.blue;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.powers.BasePower;

public class BufferPower extends BasePower {

  public static final String POWER_ID = "Buffer";
  private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
  private static final boolean TURN_BASED = false;

  public BufferPower(AbstractCreature owner, int amount) {
      super(POWER_ID, TYPE, TURN_BASED, owner, amount);
  }
  
  public void updateDescription() {
    if (this.amount <= 1) {
      this.description = DESCRIPTIONS[0];
    } else {
      this.description = DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
    } 
  }
  
  public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
    if (info.type != DamageType.HP_LOSS && damageAmount >= 10) {
        flash();
        addToTop((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this.ID, 1)); 
        return 0;
    } else {
        return damageAmount;
    }
  }
}