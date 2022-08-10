package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

import moonmod.cards.green.attack.StormOfSteel;

public class StormOfSteelAction extends AbstractGameAction {
    private AbstractPlayer p = AbstractDungeon.player;
    private StormOfSteel card;

    public StormOfSteelAction(StormOfSteel card) {
        this.card = card;
    }
    
    public void update() {
        int count = 0;
        for (AbstractMonster m : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
          if (!m.isDeadOrEscaped())
            count += card.magicNumber;
        } 
        if (count >= 1) {
            addToBot((AbstractGameAction)new SFXAction("ATTACK_WHIRLWIND"));
            addToBot((AbstractGameAction)new VFXAction(p, (AbstractGameEffect)new CleaveEffect(), 0.0F));
            addToBot((AbstractGameAction)new DamageAllEnemiesAction(p, card.multiDamage, card.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
            addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Shiv(), count));  
        }
        tickDuration();
    }

}
