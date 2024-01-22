package org.insurgencedev.eggems;

import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;
import org.insurgencedev.insurgencesets.libs.fo.Common;

@ISetsAddon(name = "EG-Gems", version = "1.0.1", author = "Insurgence Dev Team", description = "Use ElementalGems's gems as currency")
public class ElementalGemsCurrencyAddon extends InsurgenceSetsAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Common.doesPluginExist("ElementalGems")) {
            ISetsAPI.getCurrencyManager().registerCurrency(new GemsCurrency());
        }
    }
}
