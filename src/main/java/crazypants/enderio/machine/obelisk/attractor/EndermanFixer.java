package crazypants.enderio.machine.obelisk.attractor;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EndermanFixer {

    @SubscribeEvent
    public void onEndermanTeleport(EnderTeleportEvent event) {
        if (event.entityLiving instanceof EntityEnderman
                && event.entityLiving.getEntityData().getBoolean("EIO:tracked")) {
            event.setCanceled(true);
        }
    }
}
