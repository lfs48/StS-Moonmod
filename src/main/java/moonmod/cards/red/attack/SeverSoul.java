package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class SeverSoul extends BaseCard {

  public static final String ID = "Sever Soul";
  public static final int COST = 2;
  public static final int BASE_MAGIC = 2;
  public static final int UPG_MAGIC = 2;
  public static final int BASE_DMG = 16;
  public static final int UPG_DMG = 4;

  private final static CardInfo cardInfo = new CardInfo(
    ID, 
    COST, 
    CardType.ATTACK, 
    CardTarget.ENEMY, 
    CardRarity.UNCOMMON, 
    CardColor.RED
  );
  
  public SeverSoul() {
    super(cardInfo);
    this.setDamage(BASE_DMG, UPG_DMG);
    this.setMagic(BASE_MAGIC, UPG_MAGIC);
  }

  public void applyPowers() {
    int numExhausted = AbstractDungeon.player.exhaustPile.size();
    int damage = BASE_DMG;
    if (this.upgraded)
      damage += UPG_DMG;
    damage += this.magicNumber * numExhausted;
    this.baseDamage = damage;
    super.applyPowers();
    if (numExhausted > 0)
    this.isDamageModified = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    DamageInfo damageInfo = new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn);
    addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, damageInfo, AbstractGameAction.AttackEffect.FIRE));
  }

}