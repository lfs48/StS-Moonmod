package moonmod.cards.green.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.green.ConcentrateAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Concentrate extends BaseCard {

    public static final String ID = "Concentrate";
    public static final int COST = 0;
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
  
    public Concentrate() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ConcentrateAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber));
      }

}
