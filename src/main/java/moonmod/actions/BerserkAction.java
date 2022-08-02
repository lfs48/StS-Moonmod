package moonmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import moonmod.powers.red.BerserkPower;

public class BerserkAction extends AbstractGameAction {
  private AbstractPlayer p = AbstractDungeon.player;
  private static final int VULN_AMOUNT = 1;
  private int magicNumber;

  public BerserkAction(int magicNumber) {
    this.magicNumber = magicNumber;
  }
  
  public void update() {
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)p, VULN_AMOUNT, false), VULN_AMOUNT));
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new BerserkPower((AbstractCreature)p, VULN_AMOUNT), VULN_AMOUNT));
    tickDuration();
  }
}