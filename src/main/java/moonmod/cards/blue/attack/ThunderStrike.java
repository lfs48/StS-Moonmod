package moonmod.cards.blue.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

import moonmod.actions.common.LightningAttackAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class ThunderStrike extends BaseCard {

    public static final String ID = "Thunder Strike";
    public static final int COST = 2;
    public static final int BASE_DMG = 6;
    public static final int UPG_DMG = 2;
    public static final int BASE_MAGIC = 0;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON,
        CardColor.BLUE
    );
  
    public ThunderStrike() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.baseMagicNumber = 0;
        for (AbstractOrb o : AbstractDungeon.actionManager.orbsChanneledThisCombat) {
          if (o instanceof com.megacrit.cardcrawl.orbs.Lightning)
            this.baseMagicNumber++; 
        } 
        this.magicNumber = this.baseMagicNumber;
        for (int i = 0; i < this.magicNumber + 1; i++) {
            DamageInfo info = new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn);
            addToBot((AbstractGameAction)new LightningAttackAction(m, info)); 
        }
      }
      
      public void applyPowers() {
        super.applyPowers();
        this.baseMagicNumber = 0;
        this.magicNumber = 0;
        for (AbstractOrb o : AbstractDungeon.actionManager.orbsChanneledThisCombat) {
          if (o instanceof com.megacrit.cardcrawl.orbs.Lightning)
            this.baseMagicNumber++; 
        } 
        if (this.baseMagicNumber > 0) {
          this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
          initializeDescription();
        } 
      }
      
      public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
      }
      
      public void calculateCardDamage(AbstractMonster mo) {
        super.calculateCardDamage(mo);
        if (this.baseMagicNumber > 0)
          this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0]; 
        initializeDescription();
      }

}