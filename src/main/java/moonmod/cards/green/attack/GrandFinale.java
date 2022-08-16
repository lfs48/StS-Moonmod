package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.GrandFinalEffect;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GrandFinale extends BaseCard {

    public static final String ID = "Grand Finale";
    public static final int COST = 0;
    public static final int BASE_DMG = 25;
    public static final int UPG_DMG = 7;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.RARE, 
        CardColor.GREEN
    );
  
    public GrandFinale() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (Settings.FAST_MODE) {
          addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new GrandFinalEffect(), 0.7F));
        } else {
          addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new GrandFinalEffect(), 1.0F));
        } 
        addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }

      public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        if (AbstractDungeon.player.hand.size() == 1)
          this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy(); 
    }
      
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = super.canUse(p, m);
        if (!canUse)
            return false; 
        if (p.hand.size() > 1) {
            return false;
        } 
        return canUse;
    }

}