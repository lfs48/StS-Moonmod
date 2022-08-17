package moonmod.actions.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;

public class LightningAttackAction extends AbstractGameAction {
    
    private AbstractMonster target;
    private DamageInfo info;

    public LightningAttackAction(AbstractMonster target, DamageInfo info) {
        setValues((AbstractCreature)target, info);
        this.target = target;
        this.info = info;
        this.actionType = AbstractGameAction.ActionType.DEBUFF;
        this.attackEffect = AbstractGameAction.AttackEffect.POISON;
        this.duration = 0.01F;
    }
  
    public void update() {
        addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new LightningEffect(this.target.drawX, this.target.drawY)));
        addToBot((AbstractGameAction)new SFXAction("ORB_LIGHTNING_EVOKE", 0.01F));
        addToBot((AbstractGameAction) new DamageAction(this.target, this.info));
        this.isDone = true;
    }
}