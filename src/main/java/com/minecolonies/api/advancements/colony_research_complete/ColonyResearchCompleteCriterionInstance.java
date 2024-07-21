package com.minecolonies.api.advancements.colony_research_complete;

import com.google.gson.JsonObject;
import com.minecolonies.api.advancements.create_build_request.CreateBuildRequestCriterionInstance;
import com.minecolonies.api.util.constant.Constants;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.NotNull;


/**
 * An undertaker recieves a totem of undying criterion instance.
 */
public class ColonyResearchCompleteCriterionInstance extends AbstractCriterionTriggerInstance
{
    private String        researchId;

    public ColonyResearchCompleteCriterionInstance()
    {
        super(new ResourceLocation(Constants.MOD_ID, Constants.COLONY_RESEARCH_COMPLETE), ContextAwarePredicate.ANY);
    }

    public ColonyResearchCompleteCriterionInstance(String researchId)
    {
        super(new ResourceLocation(Constants.MOD_ID, Constants.COLONY_RESEARCH_COMPLETE), ContextAwarePredicate.ANY);
        this.researchId = researchId;
    }



    public boolean test(final String researchId)
    {
        return true;
    }

    @NotNull
    public static ColonyResearchCompleteCriterionInstance deserializeFromJson(@NotNull final JsonObject jsonObject,
                                                                          @NotNull final DeserializationContext context)
    {
        if (jsonObject.has("research_id"))
        {
            final String researchId = GsonHelper.getAsString(jsonObject, "research_id");
            return new ColonyResearchCompleteCriterionInstance(researchId);
        }

        return new ColonyResearchCompleteCriterionInstance();
    }

    @NotNull
    @Override
    public JsonObject serializeToJson(@NotNull final SerializationContext context)
    {
        final JsonObject json = super.serializeToJson(context);
        if (this.researchId != null)
        {
            json.addProperty("research_id", this.researchId);
        }
        return json;
    }
}
