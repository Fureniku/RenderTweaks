package co.uk.silvania.rendertweaks;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=RenderTweaks.ModId, name="RenderTweaks", version=RenderTweaks.version)
public class RenderTweaks {
	
	public static final String ModId = "rendertweaks";
	public static final String version = "1.2";
	
	@Instance(RenderTweaks.ModId)
	public static RenderTweaks instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RTConfig.loadConfig(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		RenderLiving.NAME_TAG_RANGE = 4.0F;
		RenderLiving.NAME_TAG_RANGE_SNEAK = 1.0F;
	}
	
	public void applyRenderMultiplier(Entity entity) {
		entity.renderDistanceWeight = entity.renderDistanceWeight / RTConfig.entityRenderRange;
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
