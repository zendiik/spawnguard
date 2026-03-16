# Replace owo-lib with cloth-config (gui-scaler pattern)

## Context
Odebrat owo-lib dependency z Fabric a nahradit cloth-config (AutoConfig + Jankson).
Forge a NeoForge zůstávají na nativních config systémech.
Přidat ConfigProvider abstrakci do common (gui-scaler pattern).
Aktualizovat README.md a description. Provést na všech 3 větvích.

---

## 1. `gradle.properties`
- Odebrat `owo_version=...`
- Přidat `cloth_config_version=...` (verze dle MC)

## 2. `fabric/build.gradle`
- Odebrat owo-lib závislosti (modImplementation, include, annotationProcessor)
- Odebrat wispforest maven repo
- Přidat cloth-config: `modApi("me.shedaniel.cloth:cloth-config-fabric:${cloth_config_version}") { exclude(group: "net.fabricmc.fabric-api") }`

## 3. `fabric/src/.../config/SpawnGuardConfigModel.java`
- Přepsat na cloth-config `@Config` + `ConfigData`
- Pole: `enableSpawnGuard` (boolean), `mobAttackProtectionDuration` (int)

## 4. `fabric/src/.../SpawnGuard.java`
- Nahradit `SpawnGuardConfig.createAndLoad()` za `AutoConfig.register()` + `getConfigHolder().getConfig()`
- Implementovat `ModMenuApi` pro config screen
- Nastavit `CommonClass.setConfigProvider()`

## 5. `common/src/.../CommonClass.java`
- Přidat `ConfigProvider` interface: `isEnabled()`, `getDuration()`
- Přidat `setConfigProvider()` a getter

## 6. `fabric/src/.../event/ModEntityEvents.java`
- Použít `CommonClass.getConfigProvider()` místo přímého `SpawnGuard.CONFIG`

## 7. Forge/NeoForge `SpawnGuard.java`
- Nastavit `CommonClass.setConfigProvider()` s wrapper nad nativním configem

## 8. Forge/NeoForge `ModEvents.java`
- Použít `CommonClass.getConfigProvider()` místo přímého přístupu

## 9. `README.md`
- Aktualizovat description a obsah

## 10. `gradle.properties` description
- Aktualizovat `description=...`

## 11. `fabric.mod.json` entrypoints
- Přidat `"modmenu"` entrypoint

---

## Pořadí implementace
1. master (1.21.4) — implementovat + ověřit
2. branch 1.21.1 — portovat
3. branch 1.20.1 — portovat
