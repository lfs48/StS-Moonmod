package moonmod.actions.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DrawPileToDiscardAction extends AbstractGameAction {
  public static final String[] TEXT = (CardCrawlGame.languagePack.getUIString("DrawPileToDiscardAction")).TEXT;
  
  private AbstractPlayer p;
  
  public DrawPileToDiscardAction(int amount) {
    this.p = AbstractDungeon.player;
    setValues((AbstractCreature)this.p, (AbstractCreature)AbstractDungeon.player, amount);
    this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
  }
  
  public void update() {
    if (this.p.drawPile.size() <= 0) {
        this.isDone = true;
        return;
    } 
    if (this.p.drawPile.size() == 1) {
        AbstractCard card = this.p.drawPile.group.get(0);
        this.p.discardPile.addToTop(card);
        this.p.drawPile.removeCard(card);
        card.lighten(false);
        this.isDone = true;
        return;
    } 
    if (this.duration == 0.5F) {
        AbstractDungeon.gridSelectScreen.open(this.p.drawPile, this.amount, TEXT[0], false);
        tickDuration();
        return;
    } 
    if (AbstractDungeon.gridSelectScreen.selectedCards.size() != 0) {
        for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
            this.p.discardPile.addToBottom(c);
            this.p.drawPile.removeCard(c);
            c.lighten(false);
            c.unhover();
        } 
        AbstractDungeon.gridSelectScreen.selectedCards.clear();
        for (AbstractCard c : this.p.drawPile.group) {
            c.unhover();
            c.target_x = CardGroup.DRAW_PILE_X;
            c.target_y = 0.0F;
        } 
        this.isDone = true;
    } 
    tickDuration();
  }
}
