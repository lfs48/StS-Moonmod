package moonmod.actions.blue;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.RipAndTearEffect;

import moonmod.cards.blue.attack.Claw;

public class RipAndTearAction extends AbstractGameAction {
    private AbstractCreature target;
    private DamageInfo info;

    public RipAndTearAction(AbstractCreature target, DamageInfo info) {
        this.target = target;
        this.info = info;
    }

    public void update() {
        addToTop((AbstractGameAction)new MakeTempCardInDrawPileAction((AbstractCard) new Claw(), 1, true, false, false));
        if (Settings.FAST_MODE) {
            addToTop((AbstractGameAction)new WaitAction(0.05F));
        } else {
            addToTop((AbstractGameAction)new WaitAction(0.2F));
        } 
        addToTop((AbstractGameAction) new DamageAction(this.target, this.info));
        addToTop((AbstractGameAction)new VFXAction((AbstractGameEffect)new RipAndTearEffect(this.target.hb.cX, this.target.hb.cY, Color.RED, Color.GOLD))); 
        tickDuration();
    }
}