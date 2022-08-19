package moonmod.cards.blue.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.common.DrawPileToDiscardAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class SteamBarrier extends BaseCard {

    public static final String ID = "Steam";
    public static final int COST = 1;
    public static final int BASE_BLOCK = 8;
    public static final int UPG_BLOCK = 3;
    public static final int BASE_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.COMMON, 
        CardColor.BLUE
    );
  
    public SteamBarrier() {
        super(cardInfo);
        this.setBlock(BASE_BLOCK, UPG_BLOCK);
        this.setMagic(BASE_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));   
        addToBot((AbstractGameAction) new DrawPileToDiscardAction(this.magicNumber)); 
    }

}