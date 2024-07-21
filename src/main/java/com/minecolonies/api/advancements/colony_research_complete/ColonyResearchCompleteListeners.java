package com.minecolonies.api.advancements.colony_research_complete;

import com.minecolonies.api.advancements.CriterionListeners;
import com.minecolonies.api.advancements.complete_build_request.CompleteBuildRequestCriterionInstance;
import net.minecraft.server.PlayerAdvancements;

/**
 * The listener instantiated for every advancement that listens to the associated criterion.
 * A basic class to trigger with the correct arguments
 */
public class ColonyResearchCompleteListeners extends CriterionListeners<ColonyResearchCompleteCriterionInstance>
{
    public ColonyResearchCompleteListeners(final PlayerAdvancements playerAdvancements)
    {
        super(playerAdvancements);
    }

    public void trigger(final String researchId)
    {
        trigger(instance -> instance.test(researchId));
    }
}
