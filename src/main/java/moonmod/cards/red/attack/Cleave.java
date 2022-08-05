package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Cleave extends BaseCard {

  public static final String ID = "Cleave";
  public static final int COST = 1;
  public static final int BASE_DMG = 8;
  public static final int UPG_DMG = 3;

  private final static CardInfo cardInfo = new CardInfo(
    ID, 
    COST, 
    CardType.ATTACK, 
    CardTarget.ALL_ENEMY, 
    CardRarity.COMMON, 
    CardColor.RED
  );
  
  public Cleave() {
    super(cardInfo);
    this.setDamage(BASE_DMG, UPG_DMG);
    this.tags.add(AbstractCard.CardTags.STRIKE);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new SFXAction("ATTACK_HEAVY"));
    addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new CleaveEffect(), 0.1F));
    addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
  }

}