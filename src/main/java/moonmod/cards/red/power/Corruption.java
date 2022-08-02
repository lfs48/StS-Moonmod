package moonmod.cards.red.power;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

import moonmod.cards.BaseCard;
import moonmod.powers.red.CorruptionV2Power;
import moonmod.powers.red.CorruptionV2UpgPower;
import moonmod.util.CardInfo;

public class Corruption extends BaseCard {

    public static final String ID = "Corruption";
    public static final int COST = 1;

    public static final int BASE_MAGIC = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.SELF, 
        CardRarity.RARE, 
        CardColor.RED
    );

    public Corruption() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC);
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.BLACK, p.hb.cX, p.hb.cY), 0.33F));
        addToBot((AbstractGameAction)new SFXAction("ATTACK_FIRE"));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.PURPLE, p.hb.cX, p.hb.cY), 0.33F));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.CYAN, p.hb.cX, p.hb.cY), 0.0F));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new BorderLongFlashEffect(Color.MAGENTA), 0.0F, true));
        if (this.upgraded) 
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new CorruptionV2UpgPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
        else
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new CorruptionV2Power((AbstractCreature)p, this.magicNumber), this.magicNumber));      }

}