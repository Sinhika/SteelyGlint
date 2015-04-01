package akkamaddi.plugins.SteelyGlint;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    @SuppressWarnings("unchecked")
	public static void doSteelyRecipes()
    {
        // Ore Dictionary
		OreDictionary.registerOre("ingotCarbonizedIron", new ItemStack(
				SteelyGlint.carbonizedIronIngot));
		OreDictionary.registerOre("ingotRefinedIron", new ItemStack(
				SteelyGlint.refinedIronIngot));
		OreDictionary.registerOre("ingotLowSteel", new ItemStack(
				SteelyGlint.lowSteelIngot));
		OreDictionary.registerOre("ingotHighSteel", new ItemStack(
				SteelyGlint.highSteelIngot));
		OreDictionary.registerOre("ingotSteel", new ItemStack(
				SteelyGlint.lowSteelIngot));
		OreDictionary.registerOre("ingotSteel", new ItemStack(
				SteelyGlint.highSteelIngot));
        
        // recipes: Crafting
        //Storage Block
		GameRegistry.addRecipe(new ItemStack(
				SteelyGlint.blockCarbonizedIron, 1), new Object[] { "AAA",
				"AAA", "AAA", 'A', SteelyGlint.carbonizedIronIngot });
		GameRegistry.addRecipe(new ItemStack(SteelyGlint.blockRefinedIron,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
				SteelyGlint.refinedIronIngot });
		GameRegistry.addRecipe(new ItemStack(SteelyGlint.blockLowSteel, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						SteelyGlint.lowSteelIngot });
		GameRegistry.addRecipe(
				new ItemStack(SteelyGlint.blockHighSteel, 1), new Object[] {
						"AAA", "AAA", "AAA", 'A',
						SteelyGlint.highSteelIngot });
        
        //Item Recipe
        //Ingot Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.carbonizedIronIngot, 9),
				new Object[] { SteelyGlint.blockCarbonizedIron });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.refinedIronIngot, 9),
				new Object[] { SteelyGlint.blockRefinedIron });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.lowSteelIngot, 9),
				new Object[] { SteelyGlint.blockLowSteel });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.highSteelIngot, 9),
				new Object[] { SteelyGlint.blockHighSteel });
		
        // Items
        // Chunk Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.mediumCarbonizedIronChunkItem, 2),
				new Object[] { SteelyGlint.largeCarbonizedIronChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.mediumRefinedIronChunkItem, 2),
				new Object[] { SteelyGlint.largeRefinedIronChunkItem });

		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.largeCarbonizedIronChunkItem), new Object[] {
				SteelyGlint.mediumCarbonizedIronChunkItem,
				SteelyGlint.mediumCarbonizedIronChunkItem,
				SteelyGlint.mediumCarbonizedIronChunkItem,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.largeRefinedIronChunkItem), new Object[] {
				SteelyGlint.mediumRefinedIronChunkItem,
				SteelyGlint.mediumRefinedIronChunkItem,
				SteelyGlint.mediumRefinedIronChunkItem,
				new ItemStack(Items.dye, 1, 15) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.largeLowSteelChunkItem), new Object[] {
				SteelyGlint.mediumCarbonizedIronChunkItem,
				SteelyGlint.mediumCarbonizedIronChunkItem,
				SteelyGlint.mediumRefinedIronChunkItem,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.dye, 1, 15), Items.gunpowder,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(
				SteelyGlint.largeHighSteelChunkItem), new Object[] {
				SteelyGlint.mediumRefinedIronChunkItem,
				SteelyGlint.mediumRefinedIronChunkItem,
				SteelyGlint.mediumCarbonizedIronChunkItem,
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
				.add(new ShapedOreRecipe(SteelyGlint.carbonizedIronPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.carbonizedIronAxe,
						true, new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.carbonizedIronShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.carbonizedIronSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.carbonizedIronHoe,
						true, new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		// Refined Iron Tools
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.refinedIronPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.refinedIronAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.refinedIronShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.refinedIronSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.refinedIronHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		// Low Steel Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotLowSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotLowSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		// Low Steel Armor Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.lowSteelBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotLowSteel" }));
		// High Steel Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotHighSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotHighSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		// High Steel Armor Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(SteelyGlint.highSteelBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotHighSteel" }));
		
       // recipes: Smelting
		GameRegistry.addSmelting(
				SteelyGlint.largeCarbonizedIronChunkItem,
				new ItemStack(SteelyGlint.carbonizedIronIngot), 0.8F);
		GameRegistry.addSmelting(
				SteelyGlint.largeRefinedIronChunkItem,
				new ItemStack(SteelyGlint.refinedIronIngot), 0.8F);
		GameRegistry.addSmelting(SteelyGlint.largeLowSteelChunkItem,
				new ItemStack(SteelyGlint.lowSteelIngot), 1.2F);
		GameRegistry.addSmelting(
				SteelyGlint.largeHighSteelChunkItem, new ItemStack(
						SteelyGlint.highSteelIngot), 1.4F);
		GameRegistry.addSmelting(SteelyGlint.grittySoot,
				new ItemStack(Items.gunpowder), 0.2F);
        
        // recipes: Fusion Furnace
		FusionRecipes.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(
				Items.coal, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(
				Items.gunpowder), new ItemStack(
				SteelyGlint.mediumCarbonizedIronChunkItem), 2.0F);
		FusionRecipes
				.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(
						Items.dye, 1, 15), new ItemStack(Items.gunpowder),
						new ItemStack(
								SteelyGlint.mediumRefinedIronChunkItem),
						2.0F);
		// make gunpowder
		FusionRecipes.addSmelting(new ItemStack(Items.sugar, 4, 0),
				new ItemStack(Items.coal, 4, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.flint, 2, 0), new ItemStack(
						SteelyGlint.grittySoot), 0.4F);

        if (SteelyGlint.enableRecycling)
        {
			// Carbonized Iron
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlint.carbonizedIronSword, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlint.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlint.carbonizedIronShovel, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlint.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlint.carbonizedIronAxe, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlint.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlint.carbonizedIronPickaxe, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlint.largeCarbonizedIronChunkItem), 5.0F);
			FusionRecipes
					.addSmelting(new ItemStack(
							SteelyGlint.carbonizedIronHoe, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Blocks.gravel), new ItemStack(Items.coal, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							SteelyGlint.largeCarbonizedIronChunkItem), 5.0F);
			// Refined Iron
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.refinedIronSword, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.refinedIronShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.refinedIronAxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.refinedIronPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeRefinedIronChunkItem),
					5.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.refinedIronHoe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeRefinedIronChunkItem),
					5.0F);
			// Low Steel
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelHelm, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelChest, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlint.largeLowSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelLegs, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlint.largeLowSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelBoots, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelSword, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelAxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.lowSteelHoe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeLowSteelChunkItem),
					10.0F);
			// High Steel
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelHelm, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelChest, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlint.largeHighSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelLegs, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel,
					2, 0), new ItemStack(Items.coal, 2,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					SteelyGlint.largeHighSteelChunkItem, 2, 0), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelBoots, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelSword, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelAxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SteelyGlint.highSteelHoe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(SteelyGlint.largeHighSteelChunkItem),
					10.0F);
        }
    }
}
