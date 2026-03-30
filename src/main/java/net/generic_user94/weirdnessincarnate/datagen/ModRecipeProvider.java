package net.generic_user94.weirdnessincarnate.datagen;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.block.ModBlocks;
import net.generic_user94.weirdnessincarnate.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> ANULITE_SMELTABLES = List.of(ModItems.RAW_ANULITE.get(),
            ModBlocks.ANULITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ANULITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ANULITE.get())
                .unlockedBy("has_anulite", has(ModItems.ANULITE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANULITE.get(), 9)
                .requires(ModBlocks.ANULITE_BLOCK)
                .unlockedBy("has_anulite_block", has(ModBlocks.ANULITE_BLOCK))
                .save(recipeOutput);

        oreSmelting(recipeOutput, ANULITE_SMELTABLES, RecipeCategory.MISC, ModItems.ANULITE.get(), 0.25f, 200, "anulite");
        oreBlasting(recipeOutput, ANULITE_SMELTABLES, RecipeCategory.MISC, ModItems.ANULITE.get(), 0.25f, 100, "anulite");


        stairBuilder(ModBlocks.ANULITE_STAIR.get(), Ingredient.of(ModBlocks.ANULITE_BLOCK)).group("anulite")
                .unlockedBy("has_anulite_block", has(ModBlocks.ANULITE_BLOCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANULITE_SLAB.get(), ModBlocks.ANULITE_BLOCK);


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, WeirdnessIncarnate.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
