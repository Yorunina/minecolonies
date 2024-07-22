package com.minecolonies.api.colony.event;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.colony.buildings.IBuilding;
import com.minecolonies.api.research.ILocalResearch;
import org.jetbrains.annotations.NotNull;

/**
 * Colony created event.
 */
public class ColonyCompleteBuildRequestEvent extends AbstractColonyEvent
{

    private final IBuilding building;

    private final ICitizenData citizen;
    /**
     * Constructs a colony created event.
     *
     * @param colony The colony related to the event.
     * @param building The building had built
     * @param citizen The citizen who built the building
     */
    public ColonyCompleteBuildRequestEvent(final @NotNull IColony colony, final @NotNull IBuilding building,final @NotNull ICitizenData citizen)
    {
        super(colony);
        this.building = building;
        this.citizen = citizen;
    }

    /**
     * Get what building of information
     *
     * @return the building had bulit.
     */
    public IBuilding getBuilding()
    {
        return this.building;
    }

    /**
     * Get what citizen of information
     *
     * @return the citizen who built the building
     */
    public ICitizenData getCitizen()
    {
        return this.citizen;
    }
}
