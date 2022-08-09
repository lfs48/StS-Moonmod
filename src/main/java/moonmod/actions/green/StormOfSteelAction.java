package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class StormOfSteelAction extends AbstractGameAction {
    private int shivsPerEnemy;

    public StormOfSteelAction(int shivsPerEnemy) {
        this.shivsPerEnemy = shivsPerEnemy;
    }
    
    public void update() {
        int count = 0;
        for (AbstractMonster m : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
          if (!m.isDeadOrEscaped()) {
            count += this.shivsPerEnemy;      } 
        } 
        if (count >= 1)
            addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Shiv(), count));  
        tickDuration();
    }

}
