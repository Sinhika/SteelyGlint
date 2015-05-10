package akkamaddi.plugins.SteelyGlint;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.ContentTypes;
import alexndr.api.core.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
dependencies = "required-after:simplecore; required-after:fusion ; required-after:akkamaddicore; after: GardenStuff; after: wootzpigngray")
public class SteelyGlint 
{
	public static SimpleTab tabAkkamaddiSteely;
	public static ArmorMaterial armorLowSteel, armorHighSteel;
	public static ToolMaterial toolCarbonizedIron, toolRefinedIron,toolLowSteel, toolHighSteel;

    /**
     * Called during the PreInit phase.
     * @param event FMLPreInitializationEvent
     */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
        LogHelper.info("Loading SteelyGlint...");
        tabAkkamaddiSteely = new SimpleTab("tabAkkamaddiSteely", ContentTypes.CreativeTab.GENERAL);
       
        //Configuration
        Settings.createOrLoadSettings(event);
        
        //Content
        setToolAndArmorStats();
        Content.preInitialize();
        Recipes.preInitialize();
        Content.setLoot();
	} // end preInit()

    /**
     * Called during the Init phase.
     * @param event FMLInitializationEvent
     */
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
        // run tab icon call
        setTabIcons();
        setRepairMaterials();
        Recipes.initialize();
 	} // end load()

    /**
     * Called during the PostInit phase.
     * @param event FMLPostInitializationEvent
     */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
	    Recipes.craftGardenStuff();
        LogHelper.info("SteelyGlint loaded");
	}
	
    /**
     * Creating the custom tabs using the API class "SimpleTab" and setting
     * their icon.
     */
    public void setTabIcons() {
        tabAkkamaddiSteely
                .setIcon(new ItemStack(Content.blockHighSteel));
    }


    /**
     * Sets the tool and armor stats from the Settings file.
     */
    private static void setToolAndArmorStats() 
    {
        /**
         * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by
         * pieces for their max damage), new int[] {helmet defense, chestplate
         * defense, leggings defense, boots defense}, enchantability)
         */
        armorLowSteel = EnumHelper.addArmorMaterial("LOWSTEEL", 
                Settings.lowSteelArmorDurability,
                Settings.lowSteelArmorDamageReduction,
                Settings.lowSteelArmorEnchantability);
        armorHighSteel = EnumHelper.addArmorMaterial("HIGHSTEEL", 
                Settings.highSteelArmorDurability,
                Settings.highSteelArmorDamageReduction,
                Settings.highSteelArmorEnchantability);
        
        // set tool properties
        // EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage
        // to entity, enchantability)
        toolCarbonizedIron = EnumHelper.addToolMaterial("CARBONIZEDIRON",
                Settings.carbonizedIronMiningLevel,
                Settings.carbonizedIronUsesNum,
                Settings.carbonizedIronMiningSpeed,
                Settings.carbonizedIronDamageVsEntity,
                Settings.carbonizedIronEnchantability);
        toolRefinedIron = EnumHelper.addToolMaterial("REFINEDIRON",
                Settings.refinedIronMiningLevel, Settings.refinedIronUsesNum,
                Settings.refinedIronMiningSpeed,
                Settings.refinedIronDamageVsEntity,
                Settings.refinedIronEnchantability);
        toolLowSteel = EnumHelper.addToolMaterial("LOWSTEEL",
                Settings.lowSteelMiningLevel, Settings.lowSteelUsesNum,
                Settings.lowSteelMiningSpeed, Settings.lowSteelDamageVsEntity,
                Settings.lowSteelEnchantability);
        toolHighSteel = EnumHelper.addToolMaterial("HIGHSTEEL",
                Settings.highSteelMiningLevel, Settings.highSteelUsesNum,
                Settings.highSteelMiningSpeed,
                Settings.highSteelDamageVsEntity,
                Settings.highSteelEnchantability);
       
    } // end setToolAndArmorStats()
    
    /**
     * Sets repair materials for the tools/armor of that type. ie. Copper Ingot to repair copper tools and armor.
     */
    private static void setRepairMaterials()
    {
        toolCarbonizedIron.setRepairItem(new ItemStack(Content.carbonizedIronIngot));
        toolRefinedIron.setRepairItem(new ItemStack(Content.refinedIronIngot));
        toolLowSteel.setRepairItem(new ItemStack(Content.lowSteelIngot));
        toolHighSteel.setRepairItem(new ItemStack(Content.highSteelIngot));
        armorLowSteel.customCraftingMaterial = Content.lowSteelIngot;
        armorHighSteel.customCraftingMaterial = Content.highSteelIngot;
    } // end setRepairMaterials()

} // end class SteelyGlint
