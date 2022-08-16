package moonmod.cards.green.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.DoublePoisonAction;
import com.megacrit.cardcrawl.actions.unique.TriplePoisonAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Catalyst extends BaseCard {

    public static final String ID = "Catalyst";
    public static final int COST = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.ENEMY, 
        CardRarity.RARE, 
        CardColor.GREEN
    );
  
    public Catalyst() {
        super(cardInfo);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!this.upgraded) {
          addToBot((AbstractGameAction)new DoublePoisonAction((AbstractCreature)m, (AbstractCreature)p));
        } else {
          addToBot((AbstractGameAction)new TriplePoisonAction((AbstractCreature)m, (AbstractCreature)p));
        } 
      }

}