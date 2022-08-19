package moonmod.cards.blue.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.blue.HologramAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Hologram extends BaseCard {

    public static final String ID = "Hologram";
    public static final int COST = 0;
    public static final int BASE_MAGIC = 1;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.UNCOMMON, 
        CardColor.BLUE
    );
  
    public Hologram() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new HologramAction(this.magicNumber));
    }

}