package akkamaddi.plugins.SteelyGlint;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
dependencies = "required-after:simplecore; required-after:simpleores ; required-after:fusion ; required-after:akkamaddicore")
public class SteelyGlint 
{
	// tab
	public static SimpleTab tabAkkamaddiSteely = new SimpleTab(
			"tabAkkamaddiSteely");

	/**
	 * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by
	 * pieces for their max damage), new int[] {helmet defense, chestplate
	 * defense, leggings defense, boots defense}, enchantability)
	 */
	public static ArmorMaterial armorLowSteel = EnumHelper.addArmorMaterial(
			"LOWSTEEL", 17, new int[] { 3, 6, 5, 3 }, 13);
	public static ArmorMaterial armorHighSteel = EnumHelper.addArmorMaterial(
			"HIGHSTEEL", 16, new int[] { 3, 7, 6, 3 }, 23);

	// set tool properties
	// EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage
	// to entity, enchantability)
	public static ToolMaterial toolCarbonizedIron = EnumHelper.addToolMaterial(
			"CARBONIZEDIRON", 2, 600, 5.0F, 2, 8);
	public static ToolMaterial toolRefinedIron = EnumHelper.addToolMaterial(
			"REFINEDIRON", 2, 450, 8.5F, 3, 18);
	public static ToolMaterial toolLowSteel = EnumHelper.addToolMaterial(
			"LOWSTEEL", 2, 750, 7.5F, 2, 14);
	public static ToolMaterial toolHighSteel = EnumHelper.addToolMaterial(
			"HIGHSTEEL", 3, 375, 10.5F, 3, 22);

	@EventHandler
	// used in 1.6.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "akkamaddi");
		File configFile = new File(configDir, "SteelyGlint.cfg");
		Configuration config = new Configuration(configFile);
		config.load();

		// booleans
		enableRecycling = config.get(Configuration.CATEGORY_GENERAL,
				"Enable Steely Glint item recycling recipes: false or true?",
				false).getBoolean(false);
		itemizeMobs = config.get(Configuration.CATEGORY_GENERAL,
				"Equip mobs with steel gear, true or false", false).getBoolean(false);
		config.save();

		// define items
		// Carbonized Iron
		carbonizedIronIngot = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("carbonizedIronIngot");
		largeCarbonizedIronChunkItem = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("largeCarbonizedIronChunkItem");
		mediumCarbonizedIronChunkItem = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("mediumCarbonizedIronChunkItem");
		carbonizedIronSword = new SimpleSword(toolCarbonizedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("carbonizedIronSword");
		carbonizedIronShovel = new SimpleShovel(toolCarbonizedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("carbonizedIronShovel");
		carbonizedIronAxe = new SimpleAxe(toolCarbonizedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("carbonizedIronAxe");
		carbonizedIronPickaxe = new SimplePickaxe(toolCarbonizedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("carbonizedIronPickaxe");
		carbonizedIronHoe = new SimpleAxe(toolCarbonizedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("carbonizedIronHoe");

		// Refined Iron
		refinedIronIngot = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("refinedIronIngot");
		largeRefinedIronChunkItem = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("largeRefinedIronChunkItem");
		mediumRefinedIronChunkItem = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("mediumRefinedIronChunkItem");
		refinedIronSword = new SimpleSword(toolRefinedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("refinedIronSword");
		refinedIronShovel = new SimpleShovel(toolRefinedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("refinedIronShovel");
		refinedIronAxe = new SimpleAxe(toolRefinedIron).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("refinedIronAxe");
		refinedIronPickaxe = new SimplePickaxe(toolRefinedIron)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("refinedIronPickaxe");
		refinedIronHoe = new SimpleAxe(toolRefinedIron).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("refinedIronHoe");

		// Low Steel
		lowSteelIngot = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelIngot");
		largeLowSteelChunkItem = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("largeLowSteelChunkItem");
		// mediumLowSteelChunkItem = new
		// SimpleIngot().modId("steelyglint").setCreativeTab(SteelyGlint.tabAkkamaddiSteely).setUnlocalizedName("mediumLowSteelChunkItem");
		lowSteelSword = new SimpleSword(toolLowSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelSword");
		lowSteelShovel = new SimpleShovel(toolLowSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelShovel");
		lowSteelAxe = new SimpleAxe(toolLowSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelAxe");
		lowSteelPickaxe = new SimplePickaxe(toolLowSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelPickaxe");
		lowSteelHoe = new SimpleHoe(toolLowSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelHoe");
		lowSteelHelm = new SimpleArmor(armorLowSteel, rendererLowSteel, 0)
				.modId("steelyglint").setType("lowSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelHelm");
		lowSteelChest = new SimpleArmor(armorLowSteel, rendererLowSteel, 1)
				.modId("steelyglint").setType("lowSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelChest");
		lowSteelLegs = new SimpleArmor(armorLowSteel, rendererLowSteel, 2)
				.modId("steelyglint").setType("lowSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelLegs");
		lowSteelBoots = new SimpleArmor(armorLowSteel, rendererLowSteel, 3)
				.modId("steelyglint").setType("lowSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("lowSteelBoots");

		// High Steel
		highSteelIngot = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelIngot");
		largeHighSteelChunkItem = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("largeHighSteelChunkItem");
		// mediumHighSteelChunkItem = new
		// SimpleIngot().modId("steelyglint").setCreativeTab(SteelyGlint.tabAkkamaddiSteely).setUnlocalizedName("mediumHighSteelChunkItem");
		highSteelSword = new SimpleSword(toolHighSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelSword");
		highSteelShovel = new SimpleShovel(toolHighSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelShovel");
		highSteelAxe = new SimpleAxe(toolHighSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelAxe");
		highSteelPickaxe = new SimplePickaxe(toolHighSteel)
				.modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelPickaxe");
		highSteelHoe = new SimpleHoe(toolHighSteel).modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelHoe");
		highSteelHelm = new SimpleArmor(armorHighSteel, rendererHighSteel, 0)
				.modId("steelyglint").setType("highSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelHelm");
		highSteelChest = new SimpleArmor(armorHighSteel, rendererHighSteel, 1)
				.modId("steelyglint").setType("highSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelChest");
		highSteelLegs = new SimpleArmor(armorHighSteel, rendererHighSteel, 2)
				.modId("steelyglint").setType("highSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelLegs");
		highSteelBoots = new SimpleArmor(armorHighSteel, rendererHighSteel, 3)
				.modId("steelyglint").setType("highSteel")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("highSteelBoots");

		// Other
		grittySoot = new SimpleIngot().modId("steelyglint")
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
				.setUnlocalizedName("grittySoot");

		// define blocks
		blockCarbonizedIron = ((SimpleBlock) new SimpleBlock(Material.iron)
				.modId("steelyglint").setHardness(10.0F).setResistance(16.0F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockCarbonizedIron"))
				.setAsBeaconBase(true)
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely);
		blockRefinedIron = ((SimpleBlock) new SimpleBlock(Material.iron).modId("steelyglint")
				.setHardness(11.0F).setResistance(18.0F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockRefinedIron"))
				.setAsBeaconBase(true)
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely);
		blockLowSteel = ((SimpleBlock) new SimpleBlock(Material.iron).modId("steelyglint")
				.setHardness(14.0F).setResistance(20.0F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockLowSteel"))
				.setAsBeaconBase(true)
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely);
		blockHighSteel = ((SimpleBlock) new SimpleBlock(Material.iron).modId("steelyglint")
				.setHardness(16.0F).setResistance(24.0F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockHighSteel"))
				.setAsBeaconBase(true)
				.setCreativeTab(SteelyGlint.tabAkkamaddiSteely);

		blockHighSteel.setHarvestLevel( "pickaxe", 0);
		blockCarbonizedIron.setHarvestLevel( "pickaxe", 0);
		blockRefinedIron.setHarvestLevel( "pickaxe", 0);
		blockLowSteel.setHarvestLevel( "pickaxe", 0);

		((SimpleBlock) blockHighSteel).setAsBeaconBase(true);
		((SimpleBlock) blockCarbonizedIron).setAsBeaconBase(true);
		((SimpleBlock) blockRefinedIron).setAsBeaconBase(true);
		((SimpleBlock) blockLowSteel).setAsBeaconBase(true);
		
		toolCarbonizedIron.customCraftingMaterial = SteelyGlint.carbonizedIronIngot;
		toolRefinedIron.customCraftingMaterial = SteelyGlint.refinedIronIngot;
		toolLowSteel.customCraftingMaterial = SteelyGlint.lowSteelIngot;
		armorLowSteel.customCraftingMaterial = SteelyGlint.lowSteelIngot;
		toolHighSteel.customCraftingMaterial = SteelyGlint.highSteelIngot;
		armorHighSteel.customCraftingMaterial = SteelyGlint.highSteelIngot;

		// loot
		// LootHelper.addLoot("villageBlacksmith", new ItemStack(lowSteelIngot),
		// 2, 4, 4);
		// LootHelper.addLoot("dungeonChest", new ItemStack(lowSteelIngot), 2,
		// 4, 6);
		// LootHelper.addLoot("mineshaftCorridor", new ItemStack(lowSteelSword),
		// 1, 3, 1);
		// LootHelper.addLoot("pyramidDesertyChest", new
		// ItemStack(hephaestanGoldSword), 1, 3, 1);
		// LootHelper.addLoot("pyramidJungleChest", new
		// ItemStack(carbonizedIronIngot), 1, 4, 4);
		
		// run tab icon call
		setTabIcons();
		// recipes
		Recipes.doSteelyRecipes();
		if (itemizeMobs) {
			APIcore.instance.joinWorldModRegistry.add(new JoinWorldHandler());
		}
	} // end preInit()

	@EventHandler
	// used in 1.6.2
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();

		// name stuff
		// LanguageRegistry.addName(mediumLowSteelChunkItem,
		// "Medium Low Steel Chunk");
		// LanguageRegistry.addName(mediumHighSteelChunkItem,
		// "Medium High Steel Chunk");
	} // end load()

	@EventHandler
	// used in 1.6.2
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
	
    /**
     * Creating the custom tabs using the API class "SimpleTab" and setting
     * their icon.
     */
    public void setTabIcons() {
        tabAkkamaddiSteely
                .setIcon(new ItemStack(SteelyGlint.blockHighSteel));
    }


} // end class SteelyGlint
