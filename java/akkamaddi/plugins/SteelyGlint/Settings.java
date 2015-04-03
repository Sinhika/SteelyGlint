/**
 * 
 */
package akkamaddi.plugins.SteelyGlint;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import akkamaddi.api.core.ASettings;
import alexndr.api.core.LogHelper;

/**
 * @author cyhiggin
 *
 */
public class Settings extends ASettings
{
    /** 
     * umbrella config loading routine. must be instantiated by child classes.
     * @param event
     */
    public static void createOrLoadSettings(FMLPreInitializationEvent event) 
    {
        config = GetConfig(event, "akkamaddi", "SteelyGlint.cfg");

        try {
            LogHelper.verboseInfo(ModInfo.ID, "Loading Settings...");
            config.load();
            genericSettings(ModInfo.ID, "Tungsten & Tungsten alloys");

             // Armor Stat Modification
            armorStatDefaults();
            if (enableArmorStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Armor Stat Modification enabled!");
                customizeArmorStats();
            } // end-if enableArmorStatModification

            // Block Stat Modification
            blockStatDefaults();
            if (enableBlockStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Block Stat Modification enabled!");
                customizeBlockStats();
            }

            toolStatDefaults();
            if (enableToolStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Tool Stat Modification enabled!");
                customizeToolStats();
            }
        } // end-try
        catch (Exception e) {
            LogHelper
                    .severe(ModInfo.ID,
                            "Settings failed to load correctly. The plugin may not function correctly");
        }

        finally {
            config.save();
            LogHelper.verboseInfo(ModInfo.ID, "Settings loaded successfully");
        }
        
    } // end ()

    /**
     * Sets the default armor stats.
     */
    public static void armorStatDefaults() 
    {
        lowSteelArmorDurability = 17;
        lowSteelArmorDamageReduction = new int[] { 3, 6, 5, 3 };
        lowSteelArmorEnchantability = 13;
        highSteelArmorDurability = 16;
        highSteelArmorDamageReduction = new int[] {3, 7, 6, 3 };
        highSteelArmorEnchantability = 23;
    }
    
    /**
     * sets customized armor stats.
     */
    public static void customizeArmorStats() 
    {
        lowSteelArmorDurability = config.getInt("Low Steel Armor Durability",
                "Armor Stat Modification", lowSteelArmorDurability, 0, 255,
                "Controls the durability of Low Steel Armor.");
        lowSteelArmorDamageReduction = config.get("Armor Stat Modification",
                "Low Steel Armor Damage Reduction Array",
                lowSteelArmorDamageReduction).getIntList();
        lowSteelArmorEnchantability = config.getInt(
                "Low Steel Armor Enchantability", "Armor Stat Modification", 
                lowSteelArmorEnchantability,
                0, 255, "Controls the enchantability of Low Steel Armor.");

        highSteelArmorDurability = config.getInt("High Steel Armor Durability",
                "Armor Stat Modification", highSteelArmorDurability, 0, 255,
                "Controls the durability of High Steel Armor.");
        highSteelArmorDamageReduction = config.get("Armor Stat Modification",
                "High Steel Armor Damage Reduction Array",
                highSteelArmorDamageReduction).getIntList();
        highSteelArmorEnchantability = config.getInt(
                "High Steel Armor Enchantability", "Armor Stat Modification", 
                highSteelArmorEnchantability,
                0, 255, "Controls the enchantability of High Steel Armor.");

    } // end customizeArmorStats
    
    /**
     * Sets the default block stats.
     */
    public static void blockStatDefaults() 
    {
        carbonizedIronHardness = 10.0F;
        carbonizedIronResistance = 16.0F;
        carbonizedIronHarvestLevel = 0;
        refinedIronHardness = 11.0F;
        refinedIronResistance = 18.0F;
        refinedIronHarvestLevel = 0;
        lowSteelHardness = 14.0F;
        lowSteelResistance = 20.0F;
        lowSteelHarvestLevel = 0;
        highSteelHardness = 16.0F;
        highSteelResistance = 24.0F;
        highSteelHarvestLevel = 0;
    }

    /**
     * sets customized block stats.
     */
    public static void customizeBlockStats() 
    {
        carbonizedIronHardness = config.getFloat("Carbonized Iron Hardness",
                "Block Stat Modification", carbonizedIronHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        carbonizedIronResistance = config.getFloat("Carbonized Iron Resistance",
                "Block Stat Modification", carbonizedIronResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        carbonizedIronHarvestLevel = config.getInt("Carbonized Iron Harvest Level",
                "Block Stat Modification", carbonizedIronHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        refinedIronHardness = config.getFloat("Refined Iron Hardness",
                "Block Stat Modification", refinedIronHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        refinedIronResistance = config.getFloat("Refined Iron Resistance",
                "Block Stat Modification", refinedIronResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        refinedIronHarvestLevel = config.getInt("Refined Iron Harvest Level",
                "Block Stat Modification", refinedIronHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        lowSteelHardness = config.getFloat("Low Steel Hardness",
                "Block Stat Modification", lowSteelHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        lowSteelResistance = config.getFloat("Low Steel Resistance",
                "Block Stat Modification", lowSteelResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        lowSteelHarvestLevel = config.getInt("Low Steel Harvest Level",
                "Block Stat Modification", lowSteelHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        highSteelHardness = config.getFloat("High Steel Hardness",
                "Block Stat Modification", highSteelHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        highSteelResistance = config.getFloat("High Steel Resistance",
                "Block Stat Modification", highSteelResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        highSteelHarvestLevel = config.getInt("High Steel Harvest Level",
                "Block Stat Modification", highSteelHarvestLevel, 0, 255,
                "Tool level required to harvest this block");
     } // end customizeBlocks
    
    /**
     * Sets the default tool stats.
     */
    public static void toolStatDefaults() 
    {
        carbonizedIronMiningLevel = 2;
        carbonizedIronUsesNum =  600;
        carbonizedIronMiningSpeed =  5.0F ;
        carbonizedIronDamageVsEntity = 2;
        carbonizedIronEnchantability =  8;
        refinedIronMiningLevel = 2 ;
        refinedIronUsesNum = 450 ;
        refinedIronMiningSpeed = 8.5F ;
        refinedIronDamageVsEntity = 3 ;
        refinedIronEnchantability = 18;
        lowSteelMiningLevel = 2;
        lowSteelUsesNum = 800;
        lowSteelMiningSpeed = 8.0F;
        lowSteelDamageVsEntity = 3;
        lowSteelEnchantability = 14;
        highSteelMiningLevel = 3;
        highSteelUsesNum =  375;
        highSteelMiningSpeed =  10.5F;
        highSteelDamageVsEntity =  3;
        highSteelEnchantability =  22;
    } // end toolStatDefaults

    /**
     * set customized tool stats.
     */
    public static void customizeToolStats() 
    {
        carbonizedIronMiningLevel = config
                .getInt("Carbonized Iron Mining Level",
                        "Tool Stat Modification",
                        carbonizedIronMiningLevel,
                        0,
                        255,
                        "Controls the mining level of Carbonized Iron Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
        carbonizedIronUsesNum = config.getInt("Carbonized Iron Tools Durability",
                "Tool Stat Modification", carbonizedIronUsesNum, 0, 32000,
                "Controls the number of uses Carbonized Iron Tools have.");
        carbonizedIronMiningSpeed = config
                .getFloat(
                        "Carbonized Iron Mining Speed",
                        "Tool Stat Modification",
                        carbonizedIronMiningSpeed,
                        0,
                        32000,
                        "Controls the speed at which Carbonized Iron Tools harvest their appropriate blocks.");
        carbonizedIronDamageVsEntity = config
                .getFloat("Carbonized Iron Damage Vs. Entities",
                        "Tool Stat Modification", carbonizedIronDamageVsEntity, 0,
                        32000,
                        "Controls the amount of damage Carbonized Iron Tools will do to entities.");
        carbonizedIronEnchantability = config.getInt(
                "Carbonized Iron Tools Enchantability", "Tool Stat Modification",
                carbonizedIronEnchantability, 0, 32000,
                "Controls the enchantability of Carbonized Iron Tools.");

        refinedIronMiningLevel = config
                .getInt("Refined Iron Mining Level",
                        "Tool Stat Modification",
                        refinedIronMiningLevel,
                        0,
                        255,
                        "Controls the mining level of Refined Iron Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
        refinedIronUsesNum = config.getInt("Refined Iron Tools Durability",
                "Tool Stat Modification", refinedIronUsesNum, 0, 32000,
                "Controls the number of uses Refined Iron Tools have.");
        refinedIronMiningSpeed = config
                .getFloat(
                        "Refined Iron Mining Speed",
                        "Tool Stat Modification",
                        refinedIronMiningSpeed,
                        0,
                        32000,
                        "Controls the speed at which Refined Iron Tools harvest their appropriate blocks.");
        refinedIronDamageVsEntity = config
                .getFloat("Refined Iron Damage Vs. Entities",
                        "Tool Stat Modification", refinedIronDamageVsEntity,
                        0, 32000,
                        "Controls the amount of damage Refined Iron Tools will do to entities.");
        refinedIronEnchantability = config.getInt(
                "Refined Iron Tools Enchantability", "Tool Stat Modification",
                refinedIronEnchantability, 0, 32000,
                "Controls the enchantability of Refined Iron Tools.");
        
    } // end customize ToolStats

    // Armor Stats
    public static int lowSteelArmorDurability, highSteelArmorDurability;
    public static int[] highSteelArmorDamageReduction, lowSteelArmorDamageReduction;
    public static int highSteelArmorEnchantability, lowSteelArmorEnchantability;

    // Tool Stats
    public static int carbonizedIronMiningLevel, refinedIronMiningLevel;
    public static int carbonizedIronUsesNum, refinedIronUsesNum;
    public static float carbonizedIronMiningSpeed, refinedIronMiningSpeed;
    public static float carbonizedIronDamageVsEntity, refinedIronDamageVsEntity;
    public static int carbonizedIronEnchantability, refinedIronEnchantability;
    
    public static int lowSteelMiningLevel, highSteelMiningLevel;
    public static int lowSteelUsesNum, highSteelUsesNum;
    public static float lowSteelMiningSpeed, highSteelMiningSpeed;
    public static float lowSteelDamageVsEntity, highSteelDamageVsEntity;
    public static int lowSteelEnchantability, highSteelEnchantability;

    // Block stats
    public static float carbonizedIronHardness, refinedIronHardness,
            lowSteelHardness, highSteelHardness;

    public static float carbonizedIronResistance, refinedIronResistance,
            lowSteelResistance, highSteelResistance;

    public static int carbonizedIronHarvestLevel, refinedIronHarvestLevel,
            lowSteelHarvestLevel, highSteelHarvestLevel;
    
    
} // end class
