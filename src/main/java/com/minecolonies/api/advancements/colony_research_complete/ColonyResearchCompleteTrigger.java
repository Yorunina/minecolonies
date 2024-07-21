package com.minecolonies.api.advancements.colony_research_complete;

import com.google.gson.JsonObject;
import com.minecolonies.api.advancements.AbstractCriterionTrigger;
import com.minecolonies.api.util.constant.Constants;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public class ColonyResearchCompleteTrigger extends AbstractCriterionTrigger<ColonyResearchCompleteListeners, ColonyResearchCompleteCriterionInstance>
{

    public ColonyResearchCompleteTrigger()
    {
        super(new ResourceLocation(Constants.MOD_ID, Constants.COLONY_RESEARCH_COMPLETE), ColonyResearchCompleteListeners::new);
    }

    /**
     * Triggers the listener checks if there are any listening in
     * @param player the player the check regards
     */
    public void trigger(final ServerPlayer player, final String researchId)
    {
        if (player != null)
        {
            final ColonyResearchCompleteListeners listeners = this.getListeners(player.getAdvancements());
            if (listeners != null)
            {
                listeners.trigger(researchId);
            }
        }
    }

    @NotNull
    @Override
    public ColonyResearchCompleteCriterionInstance createInstance(@NotNull final JsonObject object, @NotNull final DeserializationContext conditions)
    {
        return new ColonyResearchCompleteCriterionInstance();
    }
}
