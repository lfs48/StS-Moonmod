package moonmod.actions.common;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

public class KeepDiscardRestAction extends AbstractGameAction {
  private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("KeepDiscardRestAction");
  
  public static final String[] TEXT = uiStrings.TEXT;
  
  private AbstractPlayer p;
  
  public static int numDiscarded;
  
  private static final float DURATION = Settings.ACTION_DUR_XFAST;
  
  public KeepDiscardRestAction(AbstractCreature target, AbstractCreature source, int amount) {
    this.p = (AbstractPlayer)target;
    setValues(target, source, amount);
    this.actionType = AbstractGameAction.ActionType.DISCARD;
    this.duration = DURATION;
  }
  
  public void update() {
    int handsize = this.p.hand.size();
    if (this.duration == DURATION) {
      if (AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
        this.isDone = true;
        return;
      } 
      if (handsize <= this.amount) {
        tickDuration();
        return;
      } 
        if (this.amount < 0) {
          AbstractDungeon.handCardSelectScreen.open(TEXT[0], 99, true, true);
          AbstractDungeon.player.hand.applyPowers();
          tickDuration();
          return;
        } 
        numDiscarded = handsize - this.amount;
        AbstractDungeon.handCardSelectScreen.open(TEXT[0], this.amount, false); 
        AbstractDungeon.player.hand.applyPowers();
        tickDuration();
        return;
    } 
    if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
      ArrayList<AbstractCard> cardsToDiscard = new ArrayList<>();
      for (AbstractCard c : AbstractDungeon.player.hand.group) {
        boolean selected = false;
        for(AbstractCard s : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
          if (s.uuid == c.uuid)
            selected = true;
        }
        if ( !selected )
          cardsToDiscard.add(c);
      }
      for(AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
        this.p.hand.addToHand(c);
      }
      for (AbstractCard c : cardsToDiscard) {
        this.p.hand.moveToDiscardPile(c);
        c.triggerOnManualDiscard();
        GameActionManager.incrementDiscard(false);
      }
      AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
    } 
    tickDuration();
  }
}