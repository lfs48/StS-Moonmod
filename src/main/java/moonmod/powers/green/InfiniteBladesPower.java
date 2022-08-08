package moonmod.powers.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import moonmod.powers.BasePower;

public class InfiniteBladesPower extends BasePower {

    public static final String POWER_ID = "Infinite Blades";
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public InfiniteBladesPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        updateDescription();
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if(card.type == CardType.SKILL) {
            flash();
            addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Shiv(), this.amount, false));
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