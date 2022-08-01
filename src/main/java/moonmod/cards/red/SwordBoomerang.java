package moonmod.cards.red;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class SwordBoomerang extends BaseCard {

    public static final String ID = "Sword Boomerang";
    public static final int COST = 1;
    public static final int BASE_DMG = 3;
    public static final int BASE_MAGIC = 3;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ALL_ENEMY, 
        CardRarity.COMMON, 
        CardColor.RED
    );
  
    public SwordBoomerang() {
        super(cardInfo);
        this.setDamage(BASE_DMG);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
        this.tags.add(AbstractCard.CardTags.STRIKE);
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
    for (int i = 0; i < this.magicNumber; i++)
        addToBot((AbstractGameAction)new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL)); 
    }

}