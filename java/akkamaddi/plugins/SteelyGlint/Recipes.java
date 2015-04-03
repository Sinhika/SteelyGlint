package akkamaddi.plugins.SteelyGlint;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.api.core.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    public static final GardenStuffContents GS = new GardenStuffContents();
    
    public static void preInitialize()
    {
        try {
            addOreDictEntries();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All OreDictionary entries were added successfully.");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
             "OreDictionary entries were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end preInitialize()
    
    public static void initialize()
    {
        try {
            addRecipes();
            addFurnaceRecipes();
            addFusionFurnaceRecipes();
            if (Settings.enableRecycling)
            {
                addRecyclingRecipes();
            } // end if recycling
            LogHelper.verboseInfo(ModInfo.ID,
                    "All recipes were added successfully.");
        } catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Recipes were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end initialize()
    
    public static void addOreDictEntries()
    {
        // Ore Dictionary
        OreDictionary.registerOre("ingotCarbonizedIron", new ItemStack(
                Content.carbonizedIronIngot));
        OreDictionary.registerOre("ingotRefinedIron", new ItemStack(
                Content.refinedIronIngot));
        OreDictionary.registerOre("ingotLowSteel", new ItemStack(
                Content.lowSteelIngot));
        OreDictionary.registerOre("ingotHighSteel", new ItemStack(
                Content.highSteelIngot));
        OreDictionary.registerOre("ingotSteel", new ItemStack(
                Content.lowSteelIngot));
        OreDictionary.registerOre("ingotSteel", new ItemStack(
                Content.highSteelIngot));
    } // end addOreDictEntries()
    
    @SuppressWarnings("unchecked")
	public static void addRecipes()
    {
        // recipes: Crafting
        //Storage Block
		GameRegistry.addRecipe(new ItemStack(
				Content.blockCarbonizedIron, 1), new Object[] { "AAA",
				"AAA", "AAA", 'A', Content.carbonizedIronIngot });
		GameRegistry.addRecipe(new ItemStack(Content.blockRefinedIron,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
				Content.refinedIronIngot });
		GameRegistry.addRecipe(new ItemStack(Content.blockLowSteel, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						Content.lowSteelIngot });
		GameRegistry.addRecipe(
				new ItemStack(Content.blockHighSteel, 1), new Object[] {
						"AAA", "AAA", "AAA", 'A',
						Content.highSteelIngot });
        
        //Item Recipe
        //Ingot Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.carbonizedIronIngot, 9),
				new Object[] { Content.blockCarbonizedIron });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.refinedIronIngot, 9),
				new Object[] { Content.blockRefinedIron });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.lowSteelIngot, 9),
				new Object[] { Content.blockLowSteel });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.highSteelIngot, 9),
				new Object[] { Content.blockHighSteel });
		
        // Items
        // Chunk Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumCarbonizedIronChunkItem, 2),
				new Object[] { Content.largeCarbonizedIronChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumRefinedIronChunkItem, 2),
				new Object[] { Content.largeRefinedIronChunkItem });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeCarbonizedIronChunkItem), new Object[] {
				Content.mediumCarbonizedIronChunkItem,
				Content.mediumCarbonizedIronChunkItem,
				Content.mediumCarbonizedIronChunkItem,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeRefinedIronChunkItem), new Object[] {
				Content.mediumRefinedIronChunkItem,
				Content.mediumRefinedIronChunkItem,
				Content.mediumRefinedIronChunkItem,
				new ItemStack(Items.dye, 1, 15) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeLowSteelChunkItem), new Object[] {
				Content.mediumCarbonizedIronChunkItem,
				Content.mediumCarbonizedIronChunkItem,
				Content.mediumRefinedIronChunkItem,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.dye, 1, 15), Items.gunpowder,
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeHighSteelChunkItem), new Object[] {
				Content.mediumRefinedIronChunkItem,
				Content.mediumRefinedIronChunkItem,
				Content.mediumCarbonizedIronChunkItem,
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
				.add(new ShapedOreRecipe(Content.carbonizedIronPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.carbonizedIronAxe,
						true, new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.carbonizedIronShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.carbonizedIronSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.carbonizedIronHoe,
						true, new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotCarbonizedIron", 'Y', "stickWood" }));
		// Refined Iron Tools
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.refinedIronPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.refinedIronAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.refinedIronShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.refinedIronSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.refinedIronHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotRefinedIron", 'Y', "stickWood" }));
		// Low Steel Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotLowSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotLowSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotLowSteel", 'Y', "stickWood" }));
		// Low Steel Armor Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotLowSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.lowSteelBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotLowSteel" }));
		// High Steel Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotHighSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotHighSteel",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotHighSteel", 'Y', "stickWood" }));
		// High Steel Armor Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotHighSteel" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.highSteelBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotHighSteel" }));
		
    } // end addRecipes
    
    private static void addFurnaceRecipes()
    {
        // recipes: Smelting
        GameRegistry.addSmelting(
                Content.largeCarbonizedIronChunkItem,
                new ItemStack(Content.carbonizedIronIngot), 0.8F);
        GameRegistry.addSmelting(
                Content.largeRefinedIronChunkItem,
                new ItemStack(Content.refinedIronIngot), 0.8F);
        GameRegistry.addSmelting(Content.largeLowSteelChunkItem,
                new ItemStack(Content.lowSteelIngot), 1.2F);
        GameRegistry.addSmelting(
                Content.largeHighSteelChunkItem, new ItemStack(
                        Content.highSteelIngot), 1.4F);
        GameRegistry.addSmelting(Content.grittySoot,
                new ItemStack(Items.gunpowder), 0.2F);
        
    } // end addFurnaceRecipes
    
    private static void addFusionFurnaceRecipes()
    {
        // recipes: Fusion Furnace
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Items.iron_ingot), 
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
                new ItemStack(Items.gunpowder), 
                new ItemStack( Content.mediumCarbonizedIronChunkItem), 2.0F);
        
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Items.iron_ingot), 
                new ItemStack(Items.dye, 1, 15), 
                new ItemStack(Items.gunpowder),
                new ItemStack(Content.mediumRefinedIronChunkItem), 2.0F);
        
        // make gunpowder
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Items.sugar, 4, 0),
                new ItemStack(Items.coal, 4, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Items.flint, 2, 0), 
                new ItemStack(Content.grittySoot), 0.4F);
    } // end addFusionFurnaceRecipes
    
    private static void addRecyclingRecipes()
    {
        // Carbonized Iron
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.carbonizedIronSword, 1,
                OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Content.largeCarbonizedIronChunkItem), 5.0F);
        
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.carbonizedIronShovel, 1,
                OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Content.largeCarbonizedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.carbonizedIronAxe, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeCarbonizedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.carbonizedIronPickaxe, 1,
                OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Content.largeCarbonizedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.carbonizedIronHoe, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeCarbonizedIronChunkItem), 5.0F);
        
        // Refined Iron
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.refinedIronSword, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeRefinedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.refinedIronShovel, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeRefinedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.refinedIronAxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeRefinedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.refinedIronPickaxe, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeRefinedIronChunkItem), 5.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.refinedIronHoe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeRefinedIronChunkItem), 5.0F);
        // Low Steel
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelHelm, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelChest, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal,
                        2, OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem, 2, 0), 20.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelLegs, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal,
                        2, OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem, 2, 0), 20.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelBoots, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelSword, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelShovel, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.lowSteelPickaxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeLowSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(Content.lowSteelAxe,
                1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Content.largeLowSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(Content.lowSteelHoe,
                1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel),
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Content.largeLowSteelChunkItem), 10.0F);
        // High Steel
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelHelm, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelChest, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal,
                        2, OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem, 2, 0), 20.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelLegs, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal,
                        2, OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem, 2, 0), 20.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelBoots, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelSword, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelShovel, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelPickaxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelAxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
        FusionFurnaceRecipes.addSmelting(new ItemStack(
                Content.highSteelHoe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(
                        Content.largeHighSteelChunkItem), 10.0F);
    } // end addRecyclingRecipes

    public static void craftGardenStuff()
    {
        WootzContents W = new WootzContents();
        
        if (!GS.isModLoaded()) {
            return;
        }
        // 1. you can use carbonizedIron in place of Wrought Iron.
        OreDictionary.registerOre("ingotWroughtIron", new ItemStack(Content.carbonizedIronIngot));
        
        // 2. If Wootz is loaded, register pigIron to use in place of Wrought Iron.
        if (W.isModLoaded())
        {
            OreDictionary.registerOre("ingotWroughtIron", new ItemStack(W.pigIronIngot.get()));
        } 
        // 3. If Wootz ! loaded, add FF recipe for Wrought Iron.
        else {
            FusionFurnaceRecipes.addSmelting(
                    new ItemStack(Items.iron_ingot),
                    new ItemStack(Items.coal, 1, 1),
                    new ItemStack(Blocks.sand),
                    new ItemStack(GS.wroughtIronIngot.get()), 2.0F);
                    
        } // end-else ! Wootz
    } // end craftGardenStuff
    
} // end class Recipes
