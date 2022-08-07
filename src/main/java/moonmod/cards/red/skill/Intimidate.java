package moonmod.cards.red.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.red.IntimidateAction;
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
    addToBot((AbstractGameAction)new IntimidateAction(this.magicNumber));
  }

}