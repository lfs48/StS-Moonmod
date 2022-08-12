package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import moonmod.actions.common.KeepDiscardRestAction;

public class UnloadAction extends AbstractGameAction {
  private DamageInfo info;
  
  private float startingDuration;
  
  public UnloadAction(AbstractCreature target, DamageInfo info) {
    this.info = info;
    setValues(target, info);
    this.actionType = AbstractGameAction.ActionType.WAIT;
    this.attackEffect = AbstractGameAction.AttackEffect.SLASH_DIAGONAL;
    this.startingDuration = Settings.ACTION_DUR_FAST;
    this.duration = this.startingDuration;
  }
  
  public void update() {
    int count = AbstractDungeon.player.hand.size() - 1;
    for (int i = 0; i < count; i++) {
        addToTop((AbstractGameAction)new DamageAction(this.target, this.info, AbstractGameAction.AttackEffect.SLASH_DIAGONAL)); 
    }
    addToTop(new KeepDiscardRestAction(AbstractDungeon.player, AbstractDungeon.player, 1)); 
    this.isDone = true;
  }
}