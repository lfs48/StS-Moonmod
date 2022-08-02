package moonmod.cards.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Immolate extends BaseCard {

    public static final String ID = "Immolate";
    public static final int COST = 2;
    public static final int BASE_DMG = 21;
    public static final int UPG_DMG = 7;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.RARE, 
        CardColor.RED
    );
  
    public Immolate() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.isMultiDamage = true;
        this.cardsToPreview = (AbstractCard)new Burn();
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
        addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(new Burn(), 2));
    }

}