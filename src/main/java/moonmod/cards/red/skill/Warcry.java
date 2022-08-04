package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;
import com.badlogic.gdx.graphics.Color;

import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Warcry extends BaseCard {

    public static final String ID = "Warcry";
    public static final int COST = 0;
    public static final int BASE_MAGIC = 2;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.SELF, 
        CardRarity.COMMON, 
        CardColor.RED
    );
  
    public Warcry() {
        super(cardInfo);
        this.setMagic(BASE_MAGIC);
        this.cardsToPreview = (AbstractCard)new Dazed();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new ShockWaveEffect(p.hb.cX, p.hb.cY, Color.RED, ShockWaveEffect.ShockWaveType.ADDITIVE), 0.5F));
        addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
        addToBot((AbstractGameAction)new MakeTempCardInDrawPileAction((AbstractCard)new Dazed(), 1, this.upgraded, !this.upgraded));

      }

}