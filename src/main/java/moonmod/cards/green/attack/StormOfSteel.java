package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

import moonmod.actions.green.StormOfSteelAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class StormOfSteel extends BaseCard {

    public static final String ID = "Storm of Steel";
    public static final int COST = 2;
    public static final int BASE_DMG = 6;
    public static final int UPG_DMG = 3;
    public static final int BASE_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public StormOfSteel() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.isMultiDamage = true;
        this.setMagic(BASE_MAGIC);
        this.cardsToPreview = new Shiv();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new SFXAction("ATTACK_WHIRLWIND"));
        addToBot((AbstractGameAction)new VFXAction(p, (AbstractGameEffect)new CleaveEffect(), 0.0F));
        addToBot((AbstractGameAction)new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction) new StormOfSteelAction(this.magicNumber));
    }

}