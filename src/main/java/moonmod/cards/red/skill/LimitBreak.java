package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.LimitBreakAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class LimitBreak extends BaseCard {

    public static final String ID = "Limit Break";
    public static final int COST = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.RARE, 
        CardColor.RED
    );
  
    public LimitBreak() {
        super(cardInfo);
        this.setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new LimitBreakAction(this.upgraded));
    }

}