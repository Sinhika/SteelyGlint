/**
 * 
 */
package akkamaddi.plugins.SteelyGlint;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import akkamaddi.api.core.ModInfo;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.LogHelper;

/**
 * @author cyhiggin
 *
 */
public class Content
{
    /**
     * Loads all the mod content, by calling the methods below.
     */
    public static void preInitialize()
    {
        try {
            doItems();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All items were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Items were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doBlocks();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All blocks were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Blocks were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doTools();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All tools were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Tools were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doArmor();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All armor was added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Armor was not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        //      try{doAchievements(); LogHelper.verboseInfo(ModInfo.ID, "All achievements were added successfully");}
//          catch(Exception e){LogHelper.severe(ModInfo.ID, "Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
    } // end preInitialize()

    public static void doArmor()
    {
        lowSteelHelm = new SimpleArmor(SteelyGlint.armorLowSteel, 0)
                .modId(ModInfo.ID).setType("lowSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelHelm");
        lowSteelChest = new SimpleArmor(SteelyGlint.armorLowSteel, 1)
                .modId(ModInfo.ID).setType("lowSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelChest");
        lowSteelLegs = new SimpleArmor(SteelyGlint.armorLowSteel, 2)
                .modId(ModInfo.ID).setType("lowSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelLegs");
        lowSteelBoots = new SimpleArmor(SteelyGlint.armorLowSteel, 3)
                .modId(ModInfo.ID).setType("lowSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelBoots");

        highSteelHelm = new SimpleArmor(SteelyGlint.armorHighSteel, 0)
                .modId(ModInfo.ID).setType("highSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelHelm");
        highSteelChest = new SimpleArmor(SteelyGlint.armorHighSteel, 1)
                .modId(ModInfo.ID).setType("highSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelChest");
        highSteelLegs = new SimpleArmor(SteelyGlint.armorHighSteel, 2)
                .modId(ModInfo.ID).setType("highSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelLegs");
        highSteelBoots = new SimpleArmor(SteelyGlint.armorHighSteel, 3)
                .modId(ModInfo.ID).setType("highSteel")
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelBoots");
        
    } // doArmor()

    public static void doBlocks()
    {
        // define blocks
        blockCarbonizedIron = ((SimpleBlock) new SimpleBlock(Material.iron)
                .modId(ModInfo.ID).setHardness(Settings.carbonizedIronHardness)
                .setResistance(Settings.carbonizedIronResistance)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName("blockCarbonizedIron"))
                .setBeaconBase(true)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely);
        blockRefinedIron = ((SimpleBlock) new SimpleBlock(Material.iron).modId(ModInfo.ID)
                .setHardness(Settings.refinedIronHardness)
                .setResistance(Settings.refinedIronResistance)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName("blockRefinedIron"))
                .setBeaconBase(true)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely);
        blockLowSteel = ((SimpleBlock) new SimpleBlock(Material.iron).modId(ModInfo.ID)
                .setHardness(Settings.lowSteelHardness)
                .setResistance(Settings.lowSteelResistance)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName("blockLowSteel"))
                .setBeaconBase(true)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely);
        blockHighSteel = ((SimpleBlock) new SimpleBlock(Material.iron).modId(ModInfo.ID)
                .setHardness(Settings.highSteelHardness)
                .setResistance(Settings.highSteelResistance)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName("blockHighSteel"))
                .setBeaconBase(true)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely);

        blockHighSteel.setHarvestLevel( "pickaxe", Settings.carbonizedIronHarvestLevel);
        blockCarbonizedIron.setHarvestLevel( "pickaxe", Settings.refinedIronHarvestLevel);
        blockRefinedIron.setHarvestLevel( "pickaxe", Settings.lowSteelHarvestLevel);
        blockLowSteel.setHarvestLevel( "pickaxe", Settings.highSteelHarvestLevel);
    } // doBlocks

    public static void doItems()
    {
        // define items
        // Carbonized Iron
        carbonizedIronIngot = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("carbonizedIronIngot");
        largeCarbonizedIronChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("largeCarbonizedIronChunkItem");
        mediumCarbonizedIronChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("mediumCarbonizedIronChunkItem");

        // Refined Iron
        refinedIronIngot = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("refinedIronIngot");
        largeRefinedIronChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("largeRefinedIronChunkItem");
        mediumRefinedIronChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("mediumRefinedIronChunkItem");
        
        // Low Steel
        lowSteelIngot = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelIngot");
        largeLowSteelChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("largeLowSteelChunkItem");
        
        // High Steel
        highSteelIngot = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelIngot");
        largeHighSteelChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("largeHighSteelChunkItem");

        // Other
        grittySoot = new SimpleItem().modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("grittySoot");
   } // end doItems()

    public static void doTools()
    {
        carbonizedIronSword = new SimpleSword(SteelyGlint.toolCarbonizedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("carbonizedIronSword");
        carbonizedIronShovel = new SimpleShovel(SteelyGlint.toolCarbonizedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("carbonizedIronShovel");
        carbonizedIronAxe = new SimpleAxe(SteelyGlint.toolCarbonizedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("carbonizedIronAxe");
        carbonizedIronPickaxe = new SimplePickaxe(
                SteelyGlint.toolCarbonizedIron).modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("carbonizedIronPickaxe");
        carbonizedIronHoe = new SimpleHoe(SteelyGlint.toolCarbonizedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("carbonizedIronHoe");
        
        refinedIronSword = new SimpleSword(SteelyGlint.toolRefinedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("refinedIronSword");
        refinedIronShovel = new SimpleShovel(SteelyGlint.toolRefinedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("refinedIronShovel");
        refinedIronAxe = new SimpleAxe(SteelyGlint.toolRefinedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("refinedIronAxe");
        refinedIronPickaxe = new SimplePickaxe(SteelyGlint.toolRefinedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("refinedIronPickaxe");
        refinedIronHoe = new SimpleHoe(SteelyGlint.toolRefinedIron)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("refinedIronHoe");
        
        lowSteelSword = new SimpleSword(SteelyGlint.toolLowSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelSword");
        lowSteelShovel = new SimpleShovel(SteelyGlint.toolLowSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelShovel");
        lowSteelAxe = new SimpleAxe(SteelyGlint.toolLowSteel).modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelAxe");
        lowSteelPickaxe = new SimplePickaxe(SteelyGlint.toolLowSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelPickaxe");
        lowSteelHoe = new SimpleHoe(SteelyGlint.toolLowSteel).modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("lowSteelHoe");

        highSteelSword = new SimpleSword(SteelyGlint.toolHighSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelSword");
        highSteelShovel = new SimpleShovel(SteelyGlint.toolHighSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelShovel");
        highSteelAxe = new SimpleAxe(SteelyGlint.toolHighSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelAxe");
        highSteelPickaxe = new SimplePickaxe(SteelyGlint.toolHighSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelPickaxe");
        highSteelHoe = new SimpleHoe(SteelyGlint.toolHighSteel)
                .modId(ModInfo.ID)
                .setCreativeTab(SteelyGlint.tabAkkamaddiSteely)
                .setUnlocalizedName("highSteelHoe");
        
    } // end dotools

    public static void setLoot()
    {
       
    }

    // Carbonized Iron
    public static Item carbonizedIronIngot;
    public static Item largeCarbonizedIronChunkItem;
    public static Item mediumCarbonizedIronChunkItem;

    public static Item carbonizedIronSword;
    public static Item carbonizedIronShovel;
    public static Item carbonizedIronAxe;
    public static Item carbonizedIronPickaxe;
    public static Item carbonizedIronHoe;

    // Refined Iron
    public static Item refinedIronIngot;
    public static Item largeRefinedIronChunkItem;
    public static Item mediumRefinedIronChunkItem;

    public static Item refinedIronSword;
    public static Item refinedIronShovel;
    public static Item refinedIronAxe;
    public static Item refinedIronPickaxe;
    public static Item refinedIronHoe;

    // Low Steel
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

    // High Steel
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


} // end class
