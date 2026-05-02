package eu.netleak.spawnguard.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.netleak.spawnguard.config.SpawnGuardConfigModel;
import me.shedaniel.autoconfig.AutoConfig;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        @SuppressWarnings("removal")
        ConfigScreenFactory<?> factory = parent -> AutoConfig.getConfigScreen(SpawnGuardConfigModel.class, parent).get();
        return factory;
    }
}
