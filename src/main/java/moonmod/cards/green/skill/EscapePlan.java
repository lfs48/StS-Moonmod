package moonmod.cards.green.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.green.EscapePlanAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class EscapePlan extends BaseCard {

    public static final String ID = "Escape Plan";
    public static final int COST = 0;
    public static final int BASE_BLOCK = 2;
    public static final int UPG_BLOCK = 1;
    public static final int BASE_MAGIC = 2;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public EscapePlan() {
        super(cardInfo);
        this.setBlock(BASE_BLOCK, UPG_BLOCK);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DrawCardAction(1, (AbstractGameAction)new EscapePlanAction(this.block, this.magicNumber, 0)));    }

}