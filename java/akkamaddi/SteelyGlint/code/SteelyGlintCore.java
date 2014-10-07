package akkamaddi.SteelyGlint.code;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.ForgeSubscribe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleOre;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.LootHelper;;

@Mod(modid = "steelyglint", name = "Steely Glint, iron and steel alloys", version = "1.0.0", dependencies = "required-after:simpleores ; required-after:simpleoresfusion")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class SteelyGlintCore
{
    // The instance of your mod that Forge uses.
    @Instance("steelyglint")
    public static SteelyGlintCore instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "akkamaddi.SteelyGlint.code.ClientProxy", serverSide = "akkamaddi.SteelyGlint.code.CommonProxy")
    public static CommonProxy proxy;

    // set item ID, to-from config file

    //Carbonized Iron
    public static int carbonizedIronIngotID;
    public static int largeCarbonizedIronChunkItemID;
    public static int mediumCarbonizedIronChunkItemID;
    public static int blockCarbonizedIronID;

    public static int carbonizedIronSwordID;
    public static int carbonizedIronShovelID;
    public static int carbonizedIronAxeID;
    public static int carbonizedIronPickaxeID;
    public static int carbonizedIronHoeID;

    //Refined Iron
    public static int refinedIronIngotID;
    public static int largeRefinedIronChunkItemID;
    public static int mediumRefinedIronChunkItemID;
    public static int blockRefinedIronID;

    public static int refinedIronSwordID;
    public static int refinedIronShovelID;
    public static int refinedIronAxeID;
    public static int refinedIronPickaxeID;
    public static int refinedIronHoeID;

    //Low Steel
    public static int lowSteelIngotID;
    public static int largeLowSteelChunkItemID;
    //public static int mediumLowSteelChunkItemID;
    public static int blockLowSteelID;

    public static int lowSteelSwordID;
    public static int lowSteelShovelID;
    public static int lowSteelAxeID;
    public static int lowSteelPickaxeID;
    public static int lowSteelHoeID;

    public static int lowSteelHelmID;
    public static int lowSteelChestID;
    public static int lowSteelLegsID;
    public static int lowSteelBootsID;

    //High Steel
    public static int highSteelIngotID;
    public static int largeHighSteelChunkItemID;
    //public static int mediumHighSteelChunkItemID;
    public static int blockHighSteelID;

    public static int highSteelSwordID;
    public static int highSteelShovelID;
    public static int highSteelAxeID;
    public static int highSteelPickaxeID;
    public static int highSteelHoeID;

    public static int highSteelHelmID;
    public static int highSteelChestID;
    public static int highSteelLegsID;
    public static int highSteelBootsID;
    
    //other
    public static int grittySootID;

    // set actual item names

    //Carbonized Iron
    public static Item carbonizedIronIngot;
    public static Item largeCarbonizedIronChunkItem;
    public static Item mediumCarbonizedIronChunkItem;

    public static Item carbonizedIronSword;
    public static Item carbonizedIronShovel;
    public static Item carbonizedIronAxe;
    public static Item carbonizedIronPickaxe;
    public static Item carbonizedIronHoe;

    //Refined Iron
    public static Item refinedIronIngot;
    public static Item largeRefinedIronChunkItem;
    public static Item mediumRefinedIronChunkItem;

    public static Item refinedIronSword;
    public static Item refinedIronShovel;
    public static Item refinedIronAxe;
    public static Item refinedIronPickaxe;
    public static Item refinedIronHoe;

    //Low Steel
    public static Item lowSteelIngot;
    public static Item largeLowSteelChunkItem;
    public static Item mediumLowSteelChunkItem;

    public static Item lowSteelSword;
    public static Item lowSteelShovel;
    public static Item lowSteelAxe;
    public static Item lowSteelPickaxe;
    public static Item lowSteelHoe;

    public static Item lowSteelHelm;
    public static Item lowSteelChest;
    public static Item lowSteelLegs;
    public static Item lowSteelBoots;

    //High Steel
    public static Item highSteelIngot;
    public static Item largeHighSteelChunkItem;
    public static Item mediumHighSteelChunkItem;

    public static Item highSteelSword;
    public static Item highSteelShovel;
    public static Item highSteelAxe;
    public static Item highSteelPickaxe;
    public static Item highSteelHoe;

    public static Item highSteelHelm;
    public static Item highSteelChest;
    public static Item highSteelLegs;
    public static Item highSteelBoots;
    
    // other
    public static Item grittySoot;

    // set block names
    public static Block blockCarbonizedIron;
    public static Block blockRefinedIron;
    public static Block blockLowSteel;
    public static Block blockHighSteel;

    public static boolean enableRecycling;

    // tab
    public static SimpleTab tabAkkamaddiSteely = new SimpleTab("tabAkkamaddiSteely");

    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    public static EnumArmorMaterial armorLowSteel = EnumHelper.addArmorMaterial("LOWSTEEL", 17, new int[] {3, 6, 5, 3}, 13);
    public static EnumArmorMaterial armorHighSteel = EnumHelper.addArmorMaterial("HIGHSTEEL", 16, new int[] {3, 7, 6, 3}, 23);

    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
    public static int rendererLowSteel;
    public static int rendererHighSteel;

    // set tool properties
    // EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
    public static EnumToolMaterial toolCarbonizedIron = EnumHelper.addToolMaterial("CARBONIZEDIRON", 2, 600, 5.0F, 2, 8);
    public static EnumToolMaterial toolRefinedIron = EnumHelper.addToolMaterial("REFINEDIRON", 2, 450, 8.5F, 3, 18);
    public static EnumToolMaterial toolLowSteel = EnumHelper.addToolMaterial("LOWSTEEL", 2, 750, 7.5F, 2, 14);
    public static EnumToolMaterial toolHighSteel = EnumHelper.addToolMaterial("HIGHSTEEL", 3, 375, 10.5F, 3, 22);

    // Tab
    public void setTabIcons()
    {
        /**
         * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
         */
        tabAkkamaddiSteely.setIcon(new ItemStack(SteelyGlintCore.blockHighSteel));
    }

    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event)
    {
        File installDir = event.getModConfigurationDirectory();
        File configDir = new File(installDir, "akkamaddi");
        File configFile = new File(configDir, "SteelyGlint.cfg");
        Configuration config = new Configuration(configFile);
        config.load();
        // Carbonized Iron
        carbonizedIronIngotID = config.getItem("01 Carbonized Iron", "Carbonized Iron Ingot", 12520).getInt();
        largeCarbonizedIronChunkItemID = config.getItem("01 Carbonized Iron", "Large Carbonized Iron Chunk", 12521).getInt();
        mediumCarbonizedIronChunkItemID = config.getItem("01 Carbonized Iron", "Medium Carbonized Iron Chunk", 12522).getInt();
        carbonizedIronSwordID = config.getItem("01 Carbonized Iron", "Carbonized Iron Sword", 12523).getInt();
        carbonizedIronShovelID = config.getItem("01 Carbonized Iron", "Carbonized Iron Shovel", 12524).getInt();
        carbonizedIronAxeID = config.getItem("01 Carbonized Iron", "Carbonized Iron Axe", 12525).getInt();
        carbonizedIronPickaxeID = config.getItem("01 Carbonized Iron", "Carbonized Iron Pickaxe", 12526).getInt();
        carbonizedIronHoeID = config.getItem("01 Carbonized Iron", "Carbonized Iron Hoe", 12527).getInt();
        blockCarbonizedIronID = config.getBlock("01 Carbonized Iron", "Carbonized Iron Block", 1347).getInt();
        //Refined Iron
        refinedIronIngotID = config.getItem("02 Refined Iron", "Refined Iron Ingot", 12528).getInt();
        largeRefinedIronChunkItemID = config.getItem("02 Refined Iron", "Large Refined Iron Chunk", 12529).getInt();
        mediumRefinedIronChunkItemID = config.getItem("02 Refined Iron", "Medium Refined Iron Chunk", 12530).getInt();
        refinedIronSwordID = config.getItem("02 Refined Iron", "Refined Iron Sword", 12531).getInt();
        refinedIronShovelID = config.getItem("02 Refined Iron", "Refined Iron Shovel", 12532).getInt();
        refinedIronAxeID = config.getItem("02 Refined Iron", "Refined Iron Axe", 12533).getInt();
        refinedIronPickaxeID = config.getItem("02 Refined Iron", "Refined Iron Pickaxe", 12534).getInt();
        refinedIronHoeID = config.getItem("02 Refined Iron", "Refined Iron Hoe", 12535).getInt();
        blockRefinedIronID = config.getBlock("02 Refined Iron", "Refined Iron Block", 1348).getInt();
        // Low Steel
        lowSteelIngotID = config.getItem("03 Low Steel", "Low Steel Ingot", 12536).getInt();
        largeLowSteelChunkItemID = config.getItem("03 Low Steel", "Large Low Steel Chunk", 12537).getInt();
        //mediumLowSteelChunkItemID = config.getItem("03 Low Steel", "Medium Low Steel Chunk", 12538).getInt();
        lowSteelSwordID = config.getItem("03 Low Steel", "Low Steel Sword", 12538).getInt();
        lowSteelShovelID = config.getItem("03 Low Steel", "Low Steel Shovel", 12539).getInt();
        lowSteelAxeID = config.getItem("03 Low Steel", "Low Steel Axe", 12540).getInt();
        lowSteelPickaxeID = config.getItem("03 Low Steel", "Low Steel Pickaxe", 12541).getInt();
        lowSteelHoeID = config.getItem("03 Low Steel", "Low Steel Hoe", 12542).getInt();
        lowSteelHelmID = config.getItem("03 Low Steel", "Low Steel Helm", 12543).getInt();
        lowSteelChestID = config.getItem("03 Low Steel", "Low Steel Chest", 12544).getInt();
        lowSteelLegsID = config.getItem("03 Low Steel", "Low Steel Legs", 12545).getInt();
        lowSteelBootsID = config.getItem("03 Low Steel", "Low Steel Boots", 12546).getInt();
        blockLowSteelID = config.getBlock("03 Low Steel", "Low Steel Block", 1349).getInt();
        // High Steel
        highSteelIngotID = config.getItem("04 High Steel", "High Steel Ingot", 12547).getInt();
        largeHighSteelChunkItemID = config.getItem("04 High Steel", "Large High Steel Chunk", 12548).getInt();
        //mediumHighSteelChunkItemID = config.getItem("04 High Steel", "Medium High Steel Chunk", 12550).getInt();
        highSteelSwordID = config.getItem("04 High Steel", "High Steel Sword", 12549).getInt();
        highSteelShovelID = config.getItem("04 High Steel", "High Steel Shovel", 12550).getInt();
        highSteelAxeID = config.getItem("04 High Steel", "High Steel Axe", 12551).getInt();
        highSteelPickaxeID = config.getItem("04 High Steel", "High Steel Pickaxe", 12552).getInt();
        highSteelHoeID = config.getItem("04 High Steel", "High Steel Hoe", 12553).getInt();
        highSteelHelmID = config.getItem("04 High Steel", "High Steel Helm", 12554).getInt();
        highSteelChestID = config.getItem("04 High Steel", "High Steel Chest", 12555).getInt();
        highSteelLegsID = config.getItem("04 High Steel", "High Steel Legs", 12556).getInt();
        highSteelBootsID = config.getItem("04 High Steel", "High Steel Boots", 12557).getInt();
        blockHighSteelID = config.getBlock("04 High Steel", "High Steel Block", 1350).getInt();
        // Other
        grittySootID = config.getItem("Miscellaneous", "Gritty Soot", 12558).getInt();
        
        //booleans
        enableRecycling = config.get(Configuration.CATEGORY_GENERAL, "Enable Steely Glint item recycling recipes: false or true?", false).getBoolean(false);
        config.save();
        // define items
        // Carbonized Iron
        carbonizedIronIngot = new SimpleIngot(carbonizedIronIngotID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("carbonizedIronIngot");
        largeCarbonizedIronChunkItem = new SimpleIngot(largeCarbonizedIronChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("largeCarbonizedIronChunkItem");
        mediumCarbonizedIronChunkItem = new SimpleIngot(mediumCarbonizedIronChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("mediumCarbonizedIronChunkItem");
        carbonizedIronSword = new SimpleSword(carbonizedIronSwordID, toolCarbonizedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("carbonizedIronSword");
        carbonizedIronShovel = new SimpleShovel(carbonizedIronShovelID, toolCarbonizedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("carbonizedIronShovel");
        carbonizedIronAxe = new SimpleAxe(carbonizedIronAxeID, toolCarbonizedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("carbonizedIronAxe");
        carbonizedIronPickaxe = new SimplePickaxe(carbonizedIronPickaxeID, toolCarbonizedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("carbonizedIronPickaxe");
        carbonizedIronHoe = new SimpleAxe(carbonizedIronHoeID, toolCarbonizedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("carbonizedIronHoe");
        // Refined Iron
        refinedIronIngot = new SimpleIngot(refinedIronIngotID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("refinedIronIngot");
        largeRefinedIronChunkItem = new SimpleIngot(largeRefinedIronChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("largeRefinedIronChunkItem");
        mediumRefinedIronChunkItem = new SimpleIngot(mediumRefinedIronChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("mediumRefinedIronChunkItem");
        refinedIronSword = new SimpleSword(refinedIronSwordID, toolRefinedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("refinedIronSword");
        refinedIronShovel = new SimpleShovel(refinedIronShovelID, toolRefinedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("refinedIronShovel");
        refinedIronAxe = new SimpleAxe(refinedIronAxeID, toolRefinedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("refinedIronAxe");
        refinedIronPickaxe = new SimplePickaxe(refinedIronPickaxeID, toolRefinedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("refinedIronPickaxe");
        refinedIronHoe = new SimpleAxe(refinedIronHoeID, toolRefinedIron).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("refinedIronHoe");
        // Low Steel
        lowSteelIngot = new SimpleIngot(lowSteelIngotID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelIngot");
        largeLowSteelChunkItem = new SimpleIngot(largeLowSteelChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("largeLowSteelChunkItem");
        //mediumLowSteelChunkItem = new SimpleIngot(mediumLowSteelChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("mediumLowSteelChunkItem");
        lowSteelSword = new SimpleSword(lowSteelSwordID, toolLowSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelSword");
        lowSteelShovel = new SimpleShovel(lowSteelShovelID, toolLowSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelShovel");
        lowSteelAxe = new SimpleAxe(lowSteelAxeID, toolLowSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelAxe");
        lowSteelPickaxe = new SimplePickaxe(lowSteelPickaxeID, toolLowSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelPickaxe");
        lowSteelHoe = new SimpleHoe(lowSteelHoeID, toolLowSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelHoe");
        lowSteelHelm = new SimpleArmor(lowSteelHelmID, armorLowSteel, rendererLowSteel, 0).modId("steelyglint").setType("lowSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelHelm");
        lowSteelChest = new SimpleArmor(lowSteelChestID, armorLowSteel, rendererLowSteel, 1).modId("steelyglint").setType("lowSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelChest");
        lowSteelLegs = new SimpleArmor(lowSteelLegsID, armorLowSteel, rendererLowSteel, 2).modId("steelyglint").setType("lowSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelLegs");
        lowSteelBoots = new SimpleArmor(lowSteelBootsID, armorLowSteel, rendererLowSteel, 3).modId("steelyglint").setType("lowSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("lowSteelBoots");
        // High Steel
        highSteelIngot = new SimpleIngot(highSteelIngotID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelIngot");
        largeHighSteelChunkItem = new SimpleIngot(largeHighSteelChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("largeHighSteelChunkItem");
        //mediumHighSteelChunkItem = new SimpleIngot(mediumHighSteelChunkItemID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("mediumHighSteelChunkItem");
        highSteelSword = new SimpleSword(highSteelSwordID, toolHighSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelSword");
        highSteelShovel = new SimpleShovel(highSteelShovelID, toolHighSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelShovel");
        highSteelAxe = new SimpleAxe(highSteelAxeID, toolHighSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelAxe");
        highSteelPickaxe = new SimplePickaxe(highSteelPickaxeID, toolHighSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelPickaxe");
        highSteelHoe = new SimpleHoe(highSteelHoeID, toolHighSteel).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelHoe");
        highSteelHelm = new SimpleArmor(highSteelHelmID, armorHighSteel, rendererHighSteel, 0).modId("steelyglint").setType("highSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelHelm");
        highSteelChest = new SimpleArmor(highSteelChestID, armorHighSteel, rendererHighSteel, 1).modId("steelyglint").setType("highSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelChest");
        highSteelLegs = new SimpleArmor(highSteelLegsID, armorHighSteel, rendererHighSteel, 2).modId("steelyglint").setType("highSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelLegs");
        highSteelBoots = new SimpleArmor(highSteelBootsID, armorHighSteel, rendererHighSteel, 3).modId("steelyglint").setType("highSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("highSteelBoots");
        // Other
        grittySoot = new SimpleIngot(grittySootID).modId("steelyglint").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely).setUnlocalizedName("grittySoot");
        // define blocks
        blockCarbonizedIron = new SimpleOre(blockCarbonizedIronID, Material.iron).modId("steelyglint")
        .setHardness(10.0F).setResistance(16.0F).setStepSound(Block.soundMetalFootstep)
        .setUnlocalizedName("blockCarbonizedIron").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely);
        blockRefinedIron = new SimpleOre(blockRefinedIronID, Material.iron).modId("steelyglint")
        .setHardness(11.0F).setResistance(18.0F).setStepSound(Block.soundMetalFootstep)
        .setUnlocalizedName("blockRefinedIron").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely);
        blockLowSteel = new SimpleOre(blockLowSteelID, Material.iron).modId("steelyglint")
        .setHardness(14.0F).setResistance(20.0F).setStepSound(Block.soundMetalFootstep)
        .setUnlocalizedName("blockLowSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely);
        blockHighSteel = new SimpleOre(blockHighSteelID, Material.iron).modId("steelyglint")
        .setHardness(16.0F).setResistance(24.0F).setStepSound(Block.soundMetalFootstep)
        .setUnlocalizedName("blockHighSteel").setCreativeTab(SteelyGlintCore.tabAkkamaddiSteely);
        // loot
        //LootHelper.addLoot("villageBlacksmith", new ItemStack(lowSteelIngot), 2, 4, 4);
        //LootHelper.addLoot("dungeonChest", new ItemStack(lowSteelIngot), 2, 4, 6);
        //LootHelper.addLoot("mineshaftCorridor", new ItemStack(lowSteelSword), 1, 3, 1);
        //LootHelper.addLoot("pyramidDesertyChest", new ItemStack(hephaestanGoldSword), 1, 3, 1);
        //LootHelper.addLoot("pyramidJungleChest", new ItemStack(carbonizedIronIngot), 1, 4, 4);
        // run tab icon call
        setTabIcons();
        //recipes
        SteelyRecipes.doSteelyRecipes();
    }

    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
        MinecraftForge.EVENT_BUS.register(new HandlerJoinWorld());
        //Armor Renderers
        rendererLowSteel = proxy.addArmor("lowSteel");
        rendererHighSteel = proxy.addArmor("highSteel");
        // name stuff
        LanguageRegistry.addName(carbonizedIronIngot, "Carbonized Iron Ingot");
        LanguageRegistry.addName(largeCarbonizedIronChunkItem, "Large Carbonized Iron Chunk");
        LanguageRegistry.addName(mediumCarbonizedIronChunkItem, "Medium Carbonized Iron Chunk");
        LanguageRegistry.addName(carbonizedIronSword, "Carbonized Iron Sword");
        LanguageRegistry.addName(carbonizedIronShovel, "Carbonized Iron Shovel");
        LanguageRegistry.addName(carbonizedIronAxe, "Carbonized Iron Axe");
        LanguageRegistry.addName(carbonizedIronPickaxe, "Carbonized Iron Pickaxe");
        LanguageRegistry.addName(carbonizedIronHoe, "Carbonized Iron Hoe");
        LanguageRegistry.addName(refinedIronIngot, "Refined Iron Ingot");
        LanguageRegistry.addName(largeRefinedIronChunkItem, "Large Refined Iron Chunk");
        LanguageRegistry.addName(mediumRefinedIronChunkItem, "Medium Refined Iron Chunk");
        LanguageRegistry.addName(refinedIronSword, "Refined Iron Sword");
        LanguageRegistry.addName(refinedIronShovel, "Refined Iron Shovel");
        LanguageRegistry.addName(refinedIronAxe, "Refined Iron Axe");
        LanguageRegistry.addName(refinedIronPickaxe, "Refined Iron Pickaxe");
        LanguageRegistry.addName(refinedIronHoe, "Refined Iron Hoe");
        LanguageRegistry.addName(lowSteelIngot, "Low Steel Ingot");
        LanguageRegistry.addName(largeLowSteelChunkItem, "Large Low Steel Chunk");
        //LanguageRegistry.addName(mediumLowSteelChunkItem, "Medium Low Steel Chunk");
        LanguageRegistry.addName(lowSteelSword, "Low Steel Sword");
        LanguageRegistry.addName(lowSteelShovel, "Low Steel Shovel");
        LanguageRegistry.addName(lowSteelAxe, "Low Steel Axe");
        LanguageRegistry.addName(lowSteelPickaxe, "Low Steel Pickaxe");
        LanguageRegistry.addName(lowSteelHoe, "Low Steel Hoe");
        LanguageRegistry.addName(lowSteelHelm, "Low Steel Helm");
        LanguageRegistry.addName(lowSteelChest, "Low Steel Chestplate");
        LanguageRegistry.addName(lowSteelLegs, "Low Steel Leggings");
        LanguageRegistry.addName(lowSteelBoots, "Low Steel Boots");
        LanguageRegistry.addName(highSteelIngot, "High Steel Ingot");
        LanguageRegistry.addName(largeHighSteelChunkItem, "Large High Steel Chunk");
        //LanguageRegistry.addName(mediumHighSteelChunkItem, "Medium High Steel Chunk");
        LanguageRegistry.addName(highSteelSword, "High Steel Sword");
        LanguageRegistry.addName(highSteelShovel, "High Steel Shovel");
        LanguageRegistry.addName(highSteelAxe, "High Steel Axe");
        LanguageRegistry.addName(highSteelPickaxe, "High Steel Pickaxe");
        LanguageRegistry.addName(highSteelHoe, "High Steel Hoe");
        LanguageRegistry.addName(highSteelHelm, "High Steel Helm");
        LanguageRegistry.addName(highSteelChest, "High Steel Chestplate");
        LanguageRegistry.addName(highSteelLegs, "High Steel Leggings");
        LanguageRegistry.addName(highSteelBoots, "High Steel Boots");
        LanguageRegistry.addName(grittySoot, "Gritty Soot Clump");
        
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabAkkamaddiSteely", "en_US", "akkamaddi's Steely Glint");
        LanguageRegistry.addName(blockCarbonizedIron, "Carbonized Iron Block");
        MinecraftForge.setBlockHarvestLevel(blockCarbonizedIron, "pickaxe", 0);
        LanguageRegistry.addName(blockRefinedIron, "Refined Iron Block");
        MinecraftForge.setBlockHarvestLevel(blockRefinedIron, "pickaxe", 0);
        LanguageRegistry.addName(blockLowSteel, "Low Steel Block");
        MinecraftForge.setBlockHarvestLevel(blockLowSteel, "pickaxe", 0);
        LanguageRegistry.addName(blockHighSteel, "High Steel Block");
        MinecraftForge.setBlockHarvestLevel(blockHighSteel, "pickaxe", 0);
        MinecraftForge.setToolClass(carbonizedIronPickaxe, "pickaxe", 3);
        MinecraftForge.setToolClass(carbonizedIronShovel, "shovel", 3);
        MinecraftForge.setToolClass(carbonizedIronAxe, "axe", 3);
        MinecraftForge.setToolClass(refinedIronPickaxe, "pickaxe", 5);
        MinecraftForge.setToolClass(refinedIronShovel, "shovel", 5);
        MinecraftForge.setToolClass(refinedIronAxe, "axe", 5);
        MinecraftForge.setToolClass(lowSteelPickaxe, "pickaxe", 1);
        MinecraftForge.setToolClass(lowSteelShovel, "shovel", 1);
        MinecraftForge.setToolClass(lowSteelAxe, "axe", 1);
        MinecraftForge.setToolClass(highSteelPickaxe, "pickaxe", 1);
        MinecraftForge.setToolClass(highSteelShovel, "shovel", 1);
        MinecraftForge.setToolClass(highSteelAxe, "axe", 1);
        toolCarbonizedIron.customCraftingMaterial = SteelyGlintCore.carbonizedIronIngot;
        toolRefinedIron.customCraftingMaterial = SteelyGlintCore.refinedIronIngot;
        toolLowSteel.customCraftingMaterial = SteelyGlintCore.lowSteelIngot;
        armorLowSteel.customCraftingMaterial = SteelyGlintCore.lowSteelIngot;
        toolHighSteel.customCraftingMaterial = SteelyGlintCore.highSteelIngot;
        armorHighSteel.customCraftingMaterial = SteelyGlintCore.highSteelIngot;
    }

    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event)
    {
        // Stub Method
    }
}
