package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.ClashEffect;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Clash extends BaseCard {

    public static final String ID = "Clash";
    public static final int COST = 2;
    public static final int BASE_DMG = 14;
    public static final int UPG_DMG = 4;
    
    private boolean costChangedByOwnEffect;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.COMMON, 
        CardColor.RED
    );
  
    public Clash() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.costChangedByOwnEffect = false;
    }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new ClashEffect(m.hb.cX, m.hb.cY), 0.1F)); 
        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.NONE));
  }

    public void drawn() {
        applyPowers();
    }



    public void applyPowers() {
        super.applyPowers();
        boolean allCardsAreAttacks = true;
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.type != CardType.ATTACK) {
                allCardsAreAttacks = false;
            }
        }
        if (allCardsAreAttacks && !freeToPlay()) {
            this.freeToPlayOnce = true;
            this.costChangedByOwnEffect = true;
        } else if (!allCardsAreAttacks && freeToPlay() && costChangedByOwnEffect)  {
            this.freeToPlayOnce = false;
        }
    }

}