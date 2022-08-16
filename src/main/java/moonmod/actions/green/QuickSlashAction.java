package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import moonmod.actions.common.DrawAndDiscountAction;
public class QuickSlashAction extends AbstractGameAction {
    
    private AbstractPlayer p = AbstractDungeon.player;
  
    public void update() {
        addToTop((AbstractGameAction)new DrawAndDiscountAction());
        if (p.drawPile.isEmpty())
            addToTop((AbstractGameAction)new EmptyDeckShuffleAction());
        tickDuration();
    }
}