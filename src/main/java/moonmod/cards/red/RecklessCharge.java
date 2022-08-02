package moonmod.cards.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class RecklessCharge extends BaseCard {

  public static final String ID = "Reckless Charge";
  public static final int COST = 0;
  public static final int BASE_DMG = 7;
  public static final int UPG_DMG = 10;

  private final static CardInfo cardInfo = new CardInfo(
      ID, 
      COST, 
      CardType.ATTACK, 
      CardTarget.ENEMY, 
      CardRarity.UNCOMMON, 
      CardColor.RED
  );
  
  public RecklessCharge() {
    super(cardInfo);
    this.setDamage(BASE_DMG, UPG_DMG);
    this.tags.add(AbstractCard.CardTags.STRIKE);
    this.cardsToPreview = (AbstractCard)new Dazed();
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
    addToBot((AbstractGameAction)new MakeTempCardInDiscardAction((AbstractCard)new Dazed(), 1));
  }

}