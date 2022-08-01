package moonmod.cards.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class HeavyBlade extends BaseCard {

    public static final String ID = "Heavy Blade";
    public static final int COST = 2;
    public static final int BASE_DMG = 15;
    public static final int UPG_DMG = 3;
    public static final int BASE_MAGIC = 3;
    public static final int UPG_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.COMMON, 
        CardColor.RED
    );
  
  public HeavyBlade() {
    super(cardInfo);
    this.setDamage(BASE_DMG, UPG_DMG);
    this.setMagic(BASE_MAGIC, UPG_MAGIC);
    this.tags.add(AbstractCard.CardTags.STRIKE);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    if (m != null)
      addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new VerticalImpactEffect(m.hb.cX + m.hb.width / 4.0F, m.hb.cY - m.hb.height / 4.0F))); 
    addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
  }
  
  public void applyPowers() {
    AbstractPower strength = AbstractDungeon.player.getPower("Strength");
    if (strength != null)
      strength.amount *= this.magicNumber; 
    super.applyPowers();
    if (strength != null)
      strength.amount /= this.magicNumber; 
  }
  
  public void calculateCardDamage(AbstractMonster mo) {
    AbstractPower strength = AbstractDungeon.player.getPower("Strength");
    if (strength != null)
      strength.amount *= this.magicNumber; 
    super.calculateCardDamage(mo);
    if (strength != null)
      strength.amount /= this.magicNumber; 
  }

}