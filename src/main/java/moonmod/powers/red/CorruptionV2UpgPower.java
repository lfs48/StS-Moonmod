package moonmod.powers.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import moonmod.powers.BasePower;

public class CorruptionV2UpgPower extends BasePower {

    public boolean upgraded;
    public static final String POWER_ID = "CorruptionV2Upg";
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public CorruptionV2UpgPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        this.updateDescription();
    }

    public void updateDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(DESCRIPTIONS[0]);
        sb.append(this.amount);
        if (this.amount > 1) {
            sb.append(DESCRIPTIONS[2]);
            for (int i = 0; i < this.amount; i++)
                sb.append("[R] "); 
            sb.append(".");
        } else {
            sb.append(DESCRIPTIONS[1]);
        }
        this.description = sb.toString();
      }
  
    public void atStartOfTurnPostDraw() {
        flash();
        addToBot((AbstractGameAction)new ExhaustAction(this.amount, false, false, false));
        addToBot((AbstractGameAction)new GainEnergyAction(this.amount));
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
      }
}
  
