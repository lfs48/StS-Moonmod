package moonmod.cards.red.skill;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.common.ChooseFreeCardAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class InfernalBlade extends BaseCard {

    public static final String ID = "Infernal Blade";
    public static final int COST = 1;
    public static final int UPG_COST = 0;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.NONE, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public InfernalBlade() {
        super(cardInfo);
        this.setExhaust(true);
        this.setCostUpgrade(UPG_COST);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ChooseFreeCardAction(CardType.ATTACK, false, 1));
    }

}