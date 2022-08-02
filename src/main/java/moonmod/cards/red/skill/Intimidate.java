package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Intimidate extends BaseCard {

    public static final String ID = "Intimidate";
    public static final int COST = 0;
    public static final int BASE_MAGIC = 1;
    public static final int UPG_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.ALL_ENEMY, 
        CardRarity.COMMON, 
        CardColor.RED
    );
  
  public Intimidate() {
    super(cardInfo);
    this.setMagic(BASE_MAGIC, UPG_MAGIC);
    this.setExhaust(true);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new SFXAction("INTIMIDATE"));
    addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new IntimidateEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 1.0F));
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)mo, -this.magicNumber), -this.magicNumber, true, AbstractGameAction.AttackEffect.NONE)); 
        if (!mo.hasPower("Artifact"))
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new GainStrengthPower((AbstractCreature)mo, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE)); 
    }
  }

}