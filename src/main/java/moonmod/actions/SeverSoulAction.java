package moonmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ModifyDamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SeverSoulAction extends AbstractGameAction {
  private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("ExhaustAction");
  
  public static final String[] TEXT = uiStrings.TEXT;
  
  private AbstractPlayer player;
  private AbstractMonster target;
  private AbstractCard card;
  
  public SeverSoulAction(AbstractPlayer player, AbstractCard card, AbstractMonster target) {
    this.player = player;
    this.card = card;
    this.target = target;
    this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
    this.actionType = AbstractGameAction.ActionType.EXHAUST;
  }

  public void update() {
    if (this.duration == this.startDuration) {
      if (this.player.hand.size() == 0) {
        this.isDone = true;
        return;
      } 
      if (this.player.hand.size() <= 1) {
        this.amount = this.player.hand.size();
        int tmp = this.player.hand.size();
        for (int i = 0; i < tmp; i++) {
          AbstractCard c = this.player.hand.getTopCard();
          this.player.hand.moveToExhaustPile(c);
          calcAndDealDamage(c);
        } 
        CardCrawlGame.dungeon.checkForPactAchievement();
        return;
      } 
      AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, false);
      tickDuration();
      return;
    } 
    if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
      for (AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
        this.player.hand.moveToExhaustPile(c); 
        calcAndDealDamage(c);
      }
      CardCrawlGame.dungeon.checkForPactAchievement();
      AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
    } 
    tickDuration();
  }
  
  private void calcAndDealDamage(AbstractCard c) {
    int damage = 0;
    damage = c.costForTurn * card.magicNumber;
    DamageInfo damageInfo = new DamageInfo(this.player, damage, this.card.damageTypeForTurn);
    damageInfo.applyPowers(this.player, this.target);
    addToBot((AbstractGameAction)new DamageAction(this.target, damageInfo, AbstractGameAction.AttackEffect.FIRE));
  } 
}
