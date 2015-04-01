/**
 * 
 */
package akkamaddi.plugins.SteelyGlint;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import akkamaddi.api.core.ModInfo;
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
    {}

    public static void doBlocks()
    {}

    public static void doItems()
    {}

    public static void doTools()
    {}

    public static void setLoot()
    {}

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
