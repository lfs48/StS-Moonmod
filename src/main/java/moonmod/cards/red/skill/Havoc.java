package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.PlayTopCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class Havoc extends BaseCard {

    public static final String ID = "Havoc";
    public static final int COST = 0;
    public static final int BASE_DMG = 1;
    public static final int UPG_DMG = 1;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.SKILL, 
        CardTarget.NONE, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
    public Havoc() {
        super(cardInfo);
        this.setDamage(BASE_DMG, UPG_DMG);
    }
  
    public void use(AbstractPlayer p, AbstractMonster m) {
        int times = 1;
        if (this.upgraded) 
            times++;
        for (int i = 0; i < times; i++) {
            addToBot((AbstractGameAction)new PlayTopCardAction(
                (AbstractCreature)(AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng), true
            ));
        }
    }

}