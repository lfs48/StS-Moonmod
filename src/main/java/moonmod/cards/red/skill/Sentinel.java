package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Sentinel extends BaseCard {

    public static final String ID = "Sentinel";
    public static final int COST = 1;
    public static final int BASE_BLOCK = 8;
    public static final int UPG_BLOCK = 4;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Sentinel() {
        super(cardInfo);
        this.setBlock(BASE_BLOCK, UPG_BLOCK);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
      }
      
    public void triggerOnExhaust() {
        AbstractCreature player = (AbstractCreature)AbstractDungeon.player;
        addToBot((AbstractGameAction)new GainBlockAction(player, player, this.block));
    }

}