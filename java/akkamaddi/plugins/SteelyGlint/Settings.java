/**
 * 
 */
package akkamaddi.plugins.SteelyGlint;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import akkamaddi.api.core.ASettings;

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
        
    } // end ()

    /**
     * Sets the default armor stats.
     */
    public static void armorStatDefaults() {}
    
    /**
     * sets customized armor stats.
     */
    public static void customizeArmorStats() {}
    
    /**
     * Sets the default block stats.
     */
    public static void blockStatDefaults() {}

    /**
     * sets customized block stats.
     */
    public static void customizeBlockStats() {}
    
    /**
     * Sets the default tool stats.
     */
    public static void toolStatDefaults() {}

    /**
     * set customized tool stats.
     */
    public static void customizeToolStats() {}
    

} // end class
