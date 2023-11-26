package org.insurgencedev.eggems;

import org.bukkit.Bukkit;
import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;

@ISetsAddon(name = "EG-Gems", version = "1.0.0", author = "Insurgence Dev Team", description = "Use ElementalGems's gems as currency")
public class ElementalGemsCurrencyAddon extends InsurgenceSetsAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (isDependentEnabled()) {
            ISetsAPI.getCurrencyManager().registerCurrency(new GemsCurrency());
        }
    }

    public static boolean isDependentEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("ElementalGems");
    }

}
