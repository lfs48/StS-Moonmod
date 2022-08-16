package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.ThrowDaggerEffect;

public class FlechetteAction extends AbstractGameAction {
  private DamageInfo info;
  
  public FlechetteAction(AbstractCreature target, DamageInfo info) {
    this.duration = Settings.ACTION_DUR_XFAST;
    this.info = info;
    this.actionType = AbstractGameAction.ActionType.BLOCK;
    this.target = target;
  }
  
  public void update() {
    if (this.target != null && this.target.hb != null) {
        addToTop((AbstractGameAction)new DamageAction(this.target, this.info, true));
        addToTop((AbstractGameAction)new VFXAction((AbstractGameEffect)new ThrowDaggerEffect(this.target.hb.cX, this.target.hb.cY))); 
    }
    for (AbstractCard c : AbstractDungeon.player.hand.group) {
      if (c.type == AbstractCard.CardType.SKILL) {
        addToTop((AbstractGameAction)new DamageAction(this.target, this.info, true));
        if (this.target != null && this.target.hb != null)
          addToTop((AbstractGameAction)new VFXAction((AbstractGameEffect)new ThrowDaggerEffect(this.target.hb.cX, this.target.hb.cY))); 
      } 
    } 
    this.isDone = true;
  }
}
