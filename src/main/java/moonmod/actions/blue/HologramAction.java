package moonmod.actions.blue;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

public class HologramAction extends AbstractGameAction {
  private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("CopyAction");
  
  public static final String[] TEXT = uiStrings.TEXT;
  
  private AbstractPlayer p = AbstractDungeon.player;
  
  private int numCopies;
  
  private static final float DURATION = Settings.ACTION_DUR_XFAST;
  
  public HologramAction(int numCopies) {
    this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
    this.duration = DURATION;
    this.numCopies = numCopies;
  }
  
  public void update() {
    if (this.duration == DURATION) {
      if (this.p.discardPile.isEmpty()) {
        this.isDone = true;
        return;
      } 
      if (this.p.discardPile.size() == 1) {
        AbstractCard c = this.p.discardPile.getBottomCard();
        addToTop((AbstractGameAction)new MakeTempCardInDrawPileAction(c, this.numCopies, true, false));
        this.isDone = true;
        return;
      } 
      AbstractDungeon.gridSelectScreen.open(this.p.discardPile, 1, TEXT[0], false, false, false, false);
      tickDuration();
      return;
    } 
    if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
        for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
            addToTop((AbstractGameAction)new MakeTempCardInDrawPileAction(c, this.numCopies, true, false));
        } 
      AbstractDungeon.gridSelectScreen.selectedCards.clear();
    } 
    tickDuration();
  }
}