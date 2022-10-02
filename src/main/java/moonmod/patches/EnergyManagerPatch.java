package moonmod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

@SpirePatch(clz= EnergyManager.class,method="recharge")
public class EnergyManagerPatch {
    public static void Replace(EnergyManager obj) {
        if (AbstractDungeon.player.hasRelic("Ice Cream")) {
            if (EnergyPanel.totalCount > 0) {
              AbstractDungeon.player.getRelic("Ice Cream").flash();
              AbstractDungeon.actionManager.addToTop((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, AbstractDungeon.player
                    .getRelic("Ice Cream")));
            } 
            EnergyPanel.addEnergy(obj.energy);
          } else if (AbstractDungeon.player.hasPower("Conserve")) {
            if (EnergyPanel.totalCount > 0)
            EnergyPanel.addEnergy(obj.energy);
          } else {
            EnergyPanel.setEnergy(obj.energy);
          } 
          AbstractDungeon.actionManager.updateEnergyGain(obj.energy);
    }
}