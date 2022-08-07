package moonmod.actions.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.utility.UnlimboAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class HavocAction extends AbstractGameAction {
  private AbstractPlayer p;
  
  public HavocAction() {
    this.p = AbstractDungeon.player;
    setValues(null, source, this.amount);
    this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
    this.duration = Settings.ACTION_DUR_FASTER;
  }

  public void update() {
    if (this.duration == Settings.ACTION_DUR_FASTER) {
      if (this.p.discardPile.isEmpty()) {
        this.isDone = true;
        return;
      } 
      if (this.p.discardPile.size() >= 1) {
        AbstractCard card = this.p.discardPile.getTopCard();
        playAndExhaustCard(card);
      } 
    } 
    tickDuration();
  }

  private void playAndExhaustCard(AbstractCard card) {
    this.p.discardPile.removeCard(card);
    (AbstractDungeon.getCurrRoom()).souls.remove(card);
    card.exhaustOnUseOnce = true;
    AbstractDungeon.player.limbo.group.add(card);
    card.current_y = -200.0F * Settings.scale;
    card.target_x = Settings.WIDTH / 2.0F + 200.0F * Settings.xScale;
    card.target_y = Settings.HEIGHT / 2.0F;
    card.targetAngle = 0.0F;
    card.lighten(false);
    card.drawScale = 0.12F;
    card.targetDrawScale = 0.75F;
    card.applyPowers();
    AbstractMonster target = AbstractDungeon.getCurrRoom().monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
    addToTop((AbstractGameAction)new NewQueueCardAction(card, target, false, true));
    addToTop((AbstractGameAction)new UnlimboAction(card));
  }
}