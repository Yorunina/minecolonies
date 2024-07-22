package com.minecolonies.api.colony.event;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.colony.buildings.IBuilding;
import com.minecolonies.api.research.ILocalResearch;
import org.jetbrains.annotations.NotNull;

/**
 * Colony information changed event.
 */
public class ColonyInformationChangedEvent extends AbstractColonyEvent
{
    /**
     * What type of information changed on the colony.
     */
    private final Type type;

    private final IBuilding building;

    private final ICitizenData citizen;
    private final ILocalResearch research;


    public ColonyInformationChangedEvent(final @NotNull IColony colony, final IBuilding building, final @NotNull ICitizenData citizen)
    {
        super(colony);
        this.type = Type.BUILD_REQUEST_COMPLETED;
        this.research = null;
        this.building = building;
        this.citizen = citizen;
    }

    public ColonyInformationChangedEvent(final @NotNull IColony colony, final @NotNull ILocalResearch research)
    {
        super(colony);
        this.type = Type.RESEARCH_COMPLETED;
        this.research = research;
        this.building = null;
        this.citizen = null;
    }

    public ColonyInformationChangedEvent(final @NotNull IColony colony, final Type type)
    {
        super(colony);
        this.type = type;
        this.research = null;
        this.building = null;
        this.citizen = null;
    }

    /**
     * Get what type of information changed on the colony.
     *
     * @return the enum value.
     */
    public Type getType()
    {
        return type;
    }

    public ILocalResearch getResearch()
    {
        return this.research;
    }

    public IBuilding getBuilding()
    {
        return this.building;
    }

    public ICitizenData getCitizen()
    {
        return this.citizen;
    }

    /**
     * What information of the colony changed.
     */
    public enum Type
    {
        NAME,
        TEAM_COLOR,
        FLAG,
        BUILD_REQUEST_COMPLETED,
        RESEARCH_COMPLETED
    }
}
