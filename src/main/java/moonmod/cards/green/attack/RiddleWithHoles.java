package moonmod.cards.green.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class RiddleWithHoles extends BaseCard {

    public static final String ID = "Riddle With Holes";
    public static final int COST = 2;
    public static final int BASE_DMG = 3;
    public static final int UPG_DMG = 1;
    public static final int BASE_MAGIC = 5;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.COMMON, 
        CardColor.GREEN
    );
  
    public RiddleWithHoles() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
        this.setMagic(BASE_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AttackEffect[] slashes = new  AttackEffect[]{AttackEffect.SLASH_HORIZONTAL, AttackEffect.SLASH_DIAGONAL, AttackEffect.SLASH_VERTICAL};
        for (int i = 0; i < this.magicNumber; i++)
            addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), slashes[i % 3])); 
        }

}