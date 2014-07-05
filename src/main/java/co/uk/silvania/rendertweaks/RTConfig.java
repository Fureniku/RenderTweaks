package co.uk.silvania.rendertweaks;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class RTConfig {
	
	public static final String CATEGORY_VALUES = "Values";
	public static final String CATEGORY_ENABLE = "Configuration";
		
	public static int nameRenderRange;
	public static int sneakingRenderRange;
	public static double entityRenderRange;
	
	public static boolean alterHealth;
	public static boolean alterHunger;
	public static boolean alterNameplates;
	public static boolean alterEntityRender;
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();		
		nameRenderRange = config.get(CATEGORY_VALUES, "Nameplate Render Range", 64).getInt();
		sneakingRenderRange = config.get(CATEGORY_VALUES, "Sneaking Nameplate Render Range", 32).getInt();
		entityRenderRange = config.get(CATEGORY_VALUES, "Entity Range. MUST BE ABOVE 0 AND LESS THAN 1!", 0.125).getDouble(entityRenderRange);
		
		alterNameplates = config.get(CATEGORY_ENABLE, "Alter Nameplates", true).getBoolean(true);
		alterEntityRender = config.get(CATEGORY_ENABLE, "Alter Entity Render", true).getBoolean(true);
		config.save();
	}

}
