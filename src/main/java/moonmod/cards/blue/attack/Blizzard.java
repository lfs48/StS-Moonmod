package moonmod.cards.blue.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.BlizzardEffect;
import com.megacrit.cardcrawl.core.Settings;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Blizzard extends BaseCard {

    public static final String ID = "Blizzard";
    public static final int COST = 1;
    public static final int BASE_DMG = 0;
    public static final int BASE_MAGIC = 3;
    public static final int UPG_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.BLUE
    );
  
    public Blizzard() {
        super(cardInfo);
        this.setDamage(BASE_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int frostCount = 0;
        for (AbstractOrb o : AbstractDungeon.actionManager.orbsChanneledThisCombat) {
          if (o instanceof com.megacrit.cardcrawl.orbs.Frost)
            frostCount++; 
        } 
        this.baseDamage = frostCount * this.magicNumber;
        calculateCardDamage((AbstractMonster)null);
        if (Settings.FAST_MODE) {
          addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BlizzardEffect(frostCount, 
                  AbstractDungeon.getMonsters().shouldFlipVfx()), 0.25F));
        } else {
          addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BlizzardEffect(frostCount, AbstractDungeon.getMonsters().shouldFlipVfx()), 1.0F));
        } 
        addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.BLUNT_HEAVY, false));
      }
      
      public void applyPowers() {
        int frostCount = 0;
        for (AbstractOrb o : AbstractDungeon.actionManager.orbsChanneledThisCombat) {
          if (o instanceof com.megacrit.cardcrawl.orbs.Frost)
            frostCount++; 
        } 
        if (frostCount > 0) {
          this.baseDamage = frostCount * this.magicNumber;
          super.applyPowers();
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
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
      }

}