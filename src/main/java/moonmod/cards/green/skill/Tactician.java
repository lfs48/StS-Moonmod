package moonmod.cards.green.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.green.TacticianAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Tactician extends BaseCard {

    public static final String ID = "Tactician";
    public static final int COST = 1;
    public static final int BASE_MAGIC = 4;
    public static final int UPG_MAGIC = -1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF,
        CardRarity.UNCOMMON, 
        CardColor.GREEN
    );
  
    public Tactician() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new TacticianAction(this.magicNumber));
      }

}