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
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

import moonmod.cards.BaseCard;
import moonmod.powers.red.CorruptionPower;
import moonmod.util.CardInfo;

public class DemonForm extends BaseCard {

    public static final String ID = "Demon Form";
    public static final int COST = 3;


    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.POWER, 
        CardTarget.NONE, 
        CardRarity.RARE, 
        CardColor.RED
    );
  
    public DemonForm() {
        super(cardInfo);
        this.setEthereal(true, false);
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.RED, p.hb.cX, p.hb.cY), 0.33F));
        addToBot((AbstractGameAction)new SFXAction("ATTACK_FIRE"));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.BLACK, p.hb.cX, p.hb.cY), 0.33F));
        boolean powerExists = false;
        for (AbstractPower pow : p.powers) {
            if (pow.ID.equals("DemonFormNew")) {
            powerExists = true;
            break;
            } 
        } 
        if (!powerExists)
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new CorruptionPower((AbstractCreature)p))); 
    }

}