package moonmod.cards.red.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import moonmod.actions.SeverSoulAction;
import moonmod.cards.BaseCard;
import moonmod.util.CardInfo;

public class SeverSoul extends BaseCard {

    public static final String ID = "Sever Soul";
    public static final int COST = 1;
    public static final int BASE_MAGIC = 7;
    public static final int UPG_MAGIC = 10;

    private final static CardInfo cardInfo = new CardInfo(
        ID, 
        COST, 
        CardType.ATTACK, 
        CardTarget.ENEMY, 
        CardRarity.UNCOMMON, 
        CardColor.RED
    );
  
  public SeverSoul() {
    super(cardInfo);
    this.setMagic(BASE_MAGIC, UPG_MAGIC);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new SeverSoulAction(p, m, this.magicNumber, this.damageTypeForTurn));
  }

}