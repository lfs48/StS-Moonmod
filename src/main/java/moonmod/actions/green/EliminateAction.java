package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class EliminateAction extends AbstractGameAction {
  
  private DamageInfo info;
  
  public EliminateAction(AbstractCreature target, DamageInfo info) {
    this.info = info;
    setValues(target, info);
    this.actionType = AbstractGameAction.ActionType.DAMAGE;
    this.duration = Settings.ACTION_DUR_FASTER;
  }
  
  public void update() {
    if (this.duration == Settings.ACTION_DUR_FASTER && 
      this.target != null) {
      AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
      this.target.damage(this.info);
      if (((AbstractMonster)this.target).isDying || this.target.currentHealth <= 0) {
        int energyGainAmt = AbstractDungeon.player.energy.energy - EnergyPanel.totalCount;
        addToBot((AbstractGameAction)new GainEnergyAction(energyGainAmt)); 
      }
      if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead())
        AbstractDungeon.actionManager.clearPostCombatActions(); 
    } 
    tickDuration();
  }
}