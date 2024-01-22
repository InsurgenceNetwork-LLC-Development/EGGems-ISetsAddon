package org.insurgencedev.eggems;

import lombok.NonNull;
import me.elementalgaming.ElementalGems.ElementalGems;
import me.elementalgaming.ElementalGems.GemAPI;
import org.bukkit.entity.Player;
import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.models.currency.Currency;
import org.insurgencedev.insurgencesets.models.currency.TransactionTypes;

public class GemsCurrency extends Currency {

    private static GemAPI api;

    public GemsCurrency() {
        super("Gems", "EG");
        api = ElementalGems.getPlugin(ElementalGems.class).getGemAPI();
    }

    @Override
    public boolean canAfford(@NonNull Player player, @NonNull Object o) {
        return api.getGems(player.getUniqueId()) >= ((Number) o).longValue();
    }

    @NonNull
    @Override
    public TransactionTypes handleDeposit(@NonNull Player player, @NonNull Object o, String s) {
        if (!ISetsAPI.getArmorSetManager().isArmorSetValid(s)) {
            return TransactionTypes.FAIL;
        }


        api.addGems(player.getUniqueId(), ((Number) o).longValue());
        return TransactionTypes.SUCCESS;
    }

    @NonNull
    @Override
    public TransactionTypes handleTransaction(@NonNull Player player, @NonNull Object o, String s) {
        if (!ISetsAPI.getArmorSetManager().isArmorSetValid(s)) {
            return TransactionTypes.FAIL;
        }

        long amount = ((Number) o).longValue();
        if (api.getGems(player.getUniqueId()) < amount) {
            return TransactionTypes.FAIL_INSUFFICIENT_FUNDS;
        }

        api.removeGems(player.getUniqueId(), amount);
        return TransactionTypes.SUCCESS;
    }
}
