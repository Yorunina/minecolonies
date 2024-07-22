package com.minecolonies.api.colony.event;

import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.research.ILocalResearch;
import org.jetbrains.annotations.NotNull;

/**
 * Colony created event.
 */
public class ColonyResearchCompletedEvent extends AbstractColonyEvent
{

    private final ILocalResearch research;
    /**
     * Constructs a colony research completed event.
     *
     * @param colony The colony related to the event.
     * @param research The research completed
     */
    public ColonyResearchCompletedEvent(final @NotNull IColony colony, final @NotNull ILocalResearch research)
    {
        super(colony);
        this.research = research;
    }

    /**
     * Get what research of information
     *
     * @return The research completed
     */
    public ILocalResearch getResearch()
    {
        return this.research;
    }

}
