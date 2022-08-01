package moonmod.powers.red;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

import moonmod.powers.BasePower;

public class CorruptionStrPower extends BasePower {

    public int baseHPLoss;
    public int hpLoss;
    public static final String POWER_ID = "CorruptionStr";
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public CorruptionStrPower(AbstractCreature owner, int strengthAmount, int hpLossAmount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, strengthAmount);
        this.baseHPLoss = hpLossAmount;
        this.hpLoss = this.baseHPLoss;
        this.updateDescription();
    }
  
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.hpLoss + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
    }
  
    public void atStartOfTurnPostDraw() {
        flash();
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)owner, (AbstractGameEffect)new VerticalAuraEffect(Color.BLACK, owner.hb.cX, owner.hb.cY), 0.0F));
        addToBot((AbstractGameAction)new SFXAction("ATTACK_FIRE"));
        addToBot((AbstractGameAction)new LoseHPAction(this.owner, this.owner, this.hpLoss));
        addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, new StrengthPower(this.owner, this.amount), this.amount));
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
        this.hpLoss += this.baseHPLoss;
      }
}
  
