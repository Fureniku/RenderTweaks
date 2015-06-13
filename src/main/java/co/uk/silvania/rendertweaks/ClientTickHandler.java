package co.uk.silvania.rendertweaks;

import java.util.Iterator;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ClientTickHandler {
	
	@SubscribeEvent
	public void playerTickEvent(TickEvent.PlayerTickEvent event) {
		if (event.side.equals(Side.CLIENT)) {
			onTick();
			RenderLiving.NAME_TAG_RANGE = 4.0F;
			RenderLiving.NAME_TAG_RANGE_SNEAK = 1.0F;;
		}
	}
	
	public void onTick() {
		World world = Minecraft.getMinecraft().theWorld;
		if (world != null) {
			Iterator i = Minecraft.getMinecraft().theWorld.loadedEntityList.iterator();
			while (i.hasNext()) {
				Entity entity = (Entity) i.next();
				RenderTweaks.instance.applyRenderMultiplier(entity);
			}
		}
	}
}
