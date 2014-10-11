package akkamaddi.SteelyGlint.code;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class SteelyRecipes
{
    @SuppressWarnings("unchecked")
	public static void doSteelyRecipes()
    {
        // Ore Dictionary
		OreDictionary.registerOre("ingotCarbonizedIron", new ItemStack(
				SteelyGlintCore.carbonizedIronIngot));
		OreDictionary.registerOre("ingotRefinedIron", new ItemStack(
				SteelyGlintCore.refinedIronIngot));
		OreDictionary.registerOre("ingotLowSteel", new ItemStack(
				SteelyGlintCore.lowSteelIngot));
		OreDictionary.registerOre("ingotHighSteel", new ItemStack(
				SteelyGlintCore.highSteelIngot));
		OreDictionary.registerOre("ingotSteel", new ItemStack(
				SteelyGlintCore.lowSteelIngot));
		OreDictionary.registerOre("ingotSteel", new ItemStack(
				SteelyGlintCore.highSteelIngot));
        
        // recipes: Crafting
        //Storage Block
		GameRegistry.addRecipe(new ItemStack(
				SteelyGlintCore.blockCarbonizedIron, 1), new Object[] { "AAA",
				"AAA", "AAA", 'A', SteelyGlintCore.carbonizedIronIngot });
		GameRegistry.addRecipe(new ItemStack(SteelyGlintCore.blockRefinedIron,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
				SteelyGlintCore.refinedIronIngot });
		GameRegistry.addRecipe(new ItemStack(SteelyGlintCore.blockLowSteel, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						SteelyGlintCore.lowSteelIngot });
		GameRegistry.addRecipe(
				new ItemStack(SteelyGlintCore.blockHighSteel, 1), new Object[] {
						"AAA", "AAA", "AAA", 'A',
						SteelyGlintCore.highSteelIngot });
        
        //Item Recipe
        //Ingot Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.carbonizedIronIngot, 9),
				new Object[] { SteelyGlintCore.blockCarbonizedIron });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.refinedIronIngot, 9),
				new Object[] { SteelyGlintCore.blockRefinedIron });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.lowSteelIngot, 9),
				new Object[] { SteelyGlintCore.blockLowSteel });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.highSteelIngot, 9),
				new Object[] { SteelyGlintCore.blockHighSteel });
		
        // Items
        // Chunk Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.mediumCarbonizedIronChunkItem, 2),
				new Object[] { SteelyGlintCore.largeCarbonizedIronChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.mediumRefinedIronChunkItem, 2),
				new Object[] { SteelyGlintCore.largeRefinedIronChunkItem });

		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.largeCarbonizedIronChunkItem), new Object[] {
				SteelyGlintCore.mediumCarbonizedIronChunkItem,
				SteelyGlintCore.mediumCarbonizedIronChunkItem,
				SteelyGlintCore.mediumCarbonizedIronChunkItem,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.largeRefinedIronChunkItem), new Object[] {
				SteelyGlintCore.mediumRefinedIronChunkItem,
				SteelyGlintCore.mediumRefinedIronChunkItem,
				SteelyGlintCore.mediumRefinedIronChunkItem,
				new ItemStack(Items.dye, 1, 15) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.largeLowSteelChunkItem), new Object[] {
				SteelyGlintCore.mediumCarbonizedIronChunkItem,
				SteelyGlintCore.mediumCarbonizedIronChunkItem,
				SteelyGlintCore.mediumRefinedIronChunkItem,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.dye, 1, 15), Items.gunpowder,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlintCore.largeHighSteelChunkItem), new Object[] {
				SteelyGlintCore.mediumRefinedIronChunkItem,
				SteelyGlintCore.mediumRefinedIronChunkItem,
				SteelyGlintCore.mediumCarbonizedIronChunkItem,
				new ItemStack(Items.dye, 1, 15),
				new ItemStack(Items.dye, 1, 15),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				Items.redstone,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });      
        
        //Carbonized Iron Tools
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.carbonizedIronPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.carbonizedIronAxe,
						true, new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.carbonizedIronShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.carbonizedIronSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.carbonizedIronHoe,
						true, new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		// Refined Iron Tools
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.refinedIronPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.refinedIronAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.refinedIronShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.refinedIronSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.refinedIronHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		// Low Steel Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotLowSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotLowSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		// Low Steel Armor Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.lowSteelBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotLowSteel" }));
		// High Steel Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotHighSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotHighSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		// High Steel Armor Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlintCore.highSteelBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotHighSteel" }));
		
       // recipes: Smelting
		GameRegistry.addSmelting(
				SteelyGlintCore.largeCarbonizedIronChunkItem,
				new ItemStack(SteelyGlintCore.carbonizedIronIngot), 0.8F);
		GameRegistry.addSmelting(
				SteelyGlintCore.largeRefinedIronChunkItem,
				new ItemStack(SteelyGlintCore.refinedIronIngot), 0.8F);
		GameRegistry.addSmelting(SteelyGlintCore.largeLowSteelChunkItem,
				new ItemStack(SteelyGlintCore.lowSteelIngot), 1.2F);
		GameRegistry.addSmelting(
				SteelyGlintCore.largeHighSteelChunkItem, new ItemStack(
						SteelyGlintCore.highSteelIngot), 1.4F);
		GameRegistry.addSmelting(SteelyGlintCore.grittySoot,
				new ItemStack(Items.gunpowder), 0.2F);
        
        // recipes: Fusion Furnace
		FusionRecipes.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(
				Items.coal, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(
				Items.gunpowder), new ItemStack(
				SteelyGlintCore.mediumCarbonizedIronChunkItem), 2.0F);
		FusionRecipes
				.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(
						Items.dye, 1, 15), new ItemStack(Items.gunpowder),
						new ItemStack(
								SteelyGlintCore.mediumRefinedIronChunkItem),
						2.0F);
		// make gunpowder
		FusionRecipes.addSmelting(new ItemStack(Items.sugar, 4, 0),
				new ItemStack(Items.coal, 4, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.flint, 2, 0), new ItemStack(
						SteelyGlintCore.grittySoot), 0.4F);

        if (SteelyGlintCore.enableRecycling)
        {
			// Carbonized Iron
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlintCore.carbonizedIronSword, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlintCore.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlintCore.carbonizedIronShovel, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlintCore.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlintCore.carbonizedIronAxe, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlintCore.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlintCore.carbonizedIronPickaxe, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlintCore.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlintCore.carbonizedIronHoe, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlintCore.largeCarbonizedIronChunkItem), 5.0F);
			// Refined Iron
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.refinedIronSword, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.refinedIronShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.refinedIronAxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.refinedIronPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.refinedIronHoe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeRefinedIronChunkItem),
					5.0F);
			// Low Steel
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelHelm, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelChest, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlintCore.largeLowSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelLegs, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlintCore.largeLowSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelBoots, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelSword, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelAxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.lowSteelHoe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeLowSteelChunkItem),
					10.0F);
			// High Steel
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelHelm, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelChest, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlintCore.largeHighSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelLegs, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlintCore.largeHighSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelBoots, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelSword, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelAxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlintCore.highSteelHoe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlintCore.largeHighSteelChunkItem),
					10.0F);
        }
    }
}
