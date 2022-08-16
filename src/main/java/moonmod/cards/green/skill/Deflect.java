package moonmod.cards.green.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Deflect extends BaseCard {

    public static final String ID = "Deflect";
    public static final int COST = 0;
    public static final int BASE_BLOCK = 2;
    public static final int UPG_BLOCK = 1;
    public static final int BASE_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.COMMON, 
        CardColor.GREEN
    );
  
    public Deflect() {
        super(cardInfo);
        this.setBlock(BASE_BLOCK, UPG_BLOCK);
        this.setMagic(BASE_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < this.magicNumber; i++)
            addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
    }

}