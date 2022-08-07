package moonmod.actions.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class BaneAction extends AbstractGameAction {
    
    private AbstractPlayer p = AbstractDungeon.player;
    private AbstractMonster m;
    private int poisonAmount;

    private static final float POST_ATTACK_WAIT_DUR = 0.1F;


    public BaneAction(AbstractMonster target, DamageInfo info, int poisonAmount) {
    this.poisonAmount =  poisonAmount;
    setValues((AbstractCreature)target, info);
    this.m = target;
    this.actionType = AbstractGameAction.ActionType.DEBUFF;
    this.attackEffect = AbstractGameAction.AttackEffect.POISON;
    this.duration = 0.01F;
    }
  
    public void update() {
        if (this.target == null) {
        this.isDone = true;
        return;
    } 
    if (this.m.hasPower("Poison")) {
        tickDuration();
        AbstractPower poison = (AbstractPower)new PoisonPower((AbstractCreature)m, (AbstractCreature)p, this.poisonAmount);
        AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, this.attackEffect));
        addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, poison, this.poisonAmount, AbstractGameAction.AttackEffect.POISON));
        if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead())
        AbstractDungeon.actionManager.clearPostCombatActions(); 
        addToTop((AbstractGameAction)new WaitAction(POST_ATTACK_WAIT_DUR));
    } else
        this.isDone = true;
    }
}