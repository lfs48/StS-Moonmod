package moonmod.actions.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;

public class IntimidateAction extends AbstractGameAction {
  private AbstractPlayer p = AbstractDungeon.player;
  private int amount;

  public IntimidateAction(int amount) {
    this.amount = amount;
  }
  
  public void update() {
    addToBot((AbstractGameAction)new SFXAction("INTIMIDATE"));
    addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new IntimidateEffect(p.hb.cX, p.hb.cY), 1.0F));
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
        if (!mo.hasPower("Artifact")) {
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)mo, -this.amount), -this.amount, true, AbstractGameAction.AttackEffect.NONE)); 
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new GainStrengthPower((AbstractCreature)mo, this.amount), this.amount, true, AbstractGameAction.AttackEffect.NONE)); 
        } else {
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)mo, -this.amount), -this.amount, true, AbstractGameAction.AttackEffect.NONE)); 
        }
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.amount, false), this.amount, true, AbstractGameAction.AttackEffect.NONE));
    }
    tickDuration();
  }
}