package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.green.FlechetteAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Flechettes extends BaseCard {

    public static final String ID = "Flechettes";
    public static final int COST = 1;
    public static final int BASE_DMG = 4;
    public static final int UPG_DMG = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public Flechettes() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new FlechetteAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn)));
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    public void applyPowers() {
        super.applyPowers();
        int count = 0;
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
          if (c.type == AbstractCard.CardType.SKILL)
            count++; 
        } 
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0] + count;
        if (count == 1) {
          this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[1];
        } else {
          this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[2];
        } 
        initializeDescription();
    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
      }



}