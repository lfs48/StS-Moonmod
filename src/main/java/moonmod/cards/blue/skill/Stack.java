package moonmod.cards.blue.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Stack extends BaseCard {

    public static final String ID = "Stack";
    public static final int COST = 0;
    public static final int BASE_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.COMMON, 
        CardColor.BLUE
    );
  
    public Stack() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC);
    }

    public void applyPowers() {
        this.baseBlock = AbstractDungeon.player.discardPile.size();
        if (this.upgraded)
          this.baseBlock += this.magicNumber; 
        super.applyPowers();
        if (!this.upgraded) {
            this.rawDescription = cardStrings.DESCRIPTION;
        } else {
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        } 
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        initializeDescription();
      }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
    }

}