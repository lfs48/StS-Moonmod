package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

public class ConcentrateAction extends AbstractGameAction {
    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("DiscardAction");
  
  public static final String[] TEXT = uiStrings.TEXT;
  
  private AbstractPlayer p;
  
  private int maxAmount;
  
  public static int numDiscarded;
  
  private static final float DURATION = Settings.ACTION_DUR_XFAST;
  
  public ConcentrateAction(AbstractCreature target, AbstractCreature source, int maxAmount) {
    this.p = (AbstractPlayer)target;
    this.maxAmount = maxAmount;
    setValues(target, source, amount);
    this.actionType = AbstractGameAction.ActionType.DISCARD;
    this.duration = DURATION;
  }
  
  public void update() {
    if (this.duration == DURATION) {
      if (this.p.hand.size() == 0) {
        this.isDone = true;
        return;
      } else {
        AbstractDungeon.handCardSelectScreen.open(TEXT[0], this.maxAmount, true, true, false, false, true);
        AbstractDungeon.player.hand.applyPowers();
        tickDuration();
        return;
      }
    } 
    if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
      for (AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
        this.p.hand.moveToDiscardPile(c);
        c.triggerOnManualDiscard();
        GameActionManager.incrementDiscard(false);
      } 
      addToTop(new GainEnergyAction(AbstractDungeon.handCardSelectScreen.selectedCards.group.size()));
      AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
    } 
    tickDuration();
  }
}