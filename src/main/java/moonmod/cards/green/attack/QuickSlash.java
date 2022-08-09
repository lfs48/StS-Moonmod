package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.green.QuickSlashAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class QuickSlash extends BaseCard {

    public static final String ID = "Quick Slash";
    public static final int COST = 1;
    public static final int BASE_DMG = 5;
    public static final int UPG_DMG = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.COMMON, 
        CardColor.GREEN
    );
  
    public QuickSlash() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        addToBot((AbstractGameAction)new QuickSlashAction());
      }

}