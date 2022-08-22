package moonmod.powers.blue;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import moonmod.powers.BasePower;

public class HelloPower extends BasePower {

    public static final String POWER_ID = "Hello";
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public HelloPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
          flash();
          for (int i = 0; i < this.amount; i++) {
            AbstractCard c = AbstractDungeon
            .getCard(AbstractCard.CardRarity.COMMON, AbstractDungeon.cardRandomRng)
            .makeCopy();
            c.setCostForTurn(-9);
            addToBot((AbstractGameAction)new MakeTempCardInHandAction(c)); 
          }
        } 
      }

      public void updateDescription() {
        if (this.amount > 1) {
          this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        } else {
          this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
        } 
      }
}