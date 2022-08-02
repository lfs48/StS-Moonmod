package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.DropkickAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Dropkick extends BaseCard {

    public static final String ID = "Dropkick";
    public static final int COST = 1;
    public static final int BASE_DMG = 8;
    public static final int UPG_DMG = 4;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Dropkick() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
    }

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        for (AbstractMonster m : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (!m.isDeadOrEscaped() && m.hasPower("Vulnerable")) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
            break;
            } 
        } 
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DropkickAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn)));
    }

}