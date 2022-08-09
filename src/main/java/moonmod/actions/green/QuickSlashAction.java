package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
public class QuickSlashAction extends AbstractGameAction {
    
    private AbstractPlayer p = AbstractDungeon.player;
  
    public void update() {
        AbstractCard c = p.drawPile.getTopCard();
        addToTop((AbstractGameAction)new DrawCardAction((AbstractCreature)p, 1));
        c.setCostForTurn(c.costForTurn - 1);
        tickDuration();
    }
}