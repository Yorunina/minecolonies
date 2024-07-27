package com.minecolonies.api.colony.event;

import com.ldtteam.structurize.blueprints.v1.Blueprint;
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

    private final Blueprint bluePrint;


    public ColonyInformationChangedEvent(final @NotNull IColony colony, final IBuilding building, final ICitizenData citizen)
    {
        super(colony);
        this.type = Type.BUILD_REQUEST_COMPLETED;
        this.research = null;
        this.building = building;
        this.citizen = citizen;
        this.bluePrint = null;
    }

    public ColonyInformationChangedEvent(final @NotNull IColony colony, final @NotNull ILocalResearch research)
    {
        super(colony);
        this.type = Type.RESEARCH_COMPLETED;
        this.research = research;
        this.building = null;
        this.citizen = null;
        this.bluePrint = null;
    }

    public ColonyInformationChangedEvent(final @NotNull IColony colony, final Type type)
    {
        super(colony);
        this.type = type;
        this.research = null;
        this.building = null;
        this.citizen = null;
        this.bluePrint = null;
    }

    public ColonyInformationChangedEvent(final @NotNull IColony colony, final ICitizenData citizen, final Blueprint bluePrint)
    {
        super(colony);
        this.type = Type.SPECIAL_BUILD_REQUEST_COMPLETED;
        this.research = null;
        this.building = null;
        this.citizen = citizen;
        this.bluePrint = bluePrint;
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
    public Blueprint getBluePrint()
    {
        return this.bluePrint;
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
        RESEARCH_COMPLETED,
        SPECIAL_BUILD_REQUEST_COMPLETED
    }
}
