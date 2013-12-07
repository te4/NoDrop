package me.te3.nodrop;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;

/**
 *
 * @author te3
 */
public class NoDrop extends JavaPlugin implements Listener {
    
    /*public NoDrop() {
        
    }*/
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent explosion) {
        // beds and other oddballs
        if (explosion.getEntity() == null) {
            return;
        }
        EntityType cause = explosion.getEntityType();
        if (cause == null || cause == EntityType.CREEPER || cause == EntityType.FIREBALL)
            explosion.setCancelled(true);
    }
}
