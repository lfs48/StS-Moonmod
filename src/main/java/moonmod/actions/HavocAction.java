package moonmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class HavocAction extends AbstractGameAction {
  
  public HavocAction(AbstractCreature target) {
    this.duration = Settings.ACTION_DUR_FAST;
    this.actionType = AbstractGameAction.ActionType.WAIT;
    this.source = (AbstractCreature)AbstractDungeon.player;
    this.target = target;
  }
  
  public void update() {
    if (this.duration == Settings.ACTION_DUR_FAST) {
      if (AbstractDungeon.player.drawPile.size() + AbstractDungeon.player.discardPile.size() == 0) {
        this.isDone = true;
        return;
      } 
      if (AbstractDungeon.player.drawPile.isEmpty()) {
        addToTop(new HavocAction(this.target));
        addToTop(new EmptyDeckShuffleAction());
        this.isDone = true;
        return;
      } 
      if (!AbstractDungeon.player.drawPile.isEmpty()) {
        AbstractCard card = AbstractDungeon.player.drawPile.getTopCard();
        AbstractDungeon.player.drawPile.group.remove(card);
        (AbstractDungeon.getCurrRoom()).souls.remove(card);
        card.exhaustOnUseOnce = true;

        AbstractDungeon.player.limbo.group.add(card);
        card.current_y = -200.0F * Settings.scale;
        card.target_x = Settings.WIDTH / 2.0F * Settings.xScale;
        card.target_y = Settings.HEIGHT / 2.0F;
        card.targetAngle = 0.0F;
        card.lighten(false);
        card.drawScale = 0.12F;
        card.targetDrawScale = 0.75F;
        card.applyPowers();

        AbstractCard tmp = card.makeSameInstanceOf();
        AbstractDungeon.player.limbo.group.add(tmp);
        tmp.current_x = card.current_x;
        tmp.current_y = card.current_y;
        tmp.target_x = Settings.WIDTH / 2.0F - 300.0F * Settings.xScale;
        tmp.target_y = card.target_y;
        tmp.purgeOnUse = true;

        addToTop((AbstractGameAction)new NewQueueCardAction(tmp, this.target, false, true));
        addToTop((AbstractGameAction)new NewQueueCardAction(card, this.target, false, true));

        if (!Settings.FAST_MODE) {
            addToTop((AbstractGameAction)new WaitAction(Settings.ACTION_DUR_MED));
          } else {
            addToTop((AbstractGameAction)new WaitAction(Settings.ACTION_DUR_FASTER));
          } 
      } 
      this.isDone = true;
    } 
  }

}