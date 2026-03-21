# SpawnGuard

**Survive your first moments.** SpawnGuard protects players from hostile mob attacks for a configurable duration after spawning — no more losing everything to a creeper before you even find wood.

## ✨ Features

*   **Automatic Spawn Protection** — Every new player gets a Mob Attack Protection effect the moment they join the world
*   **Fully Configurable** — Set the protection duration to whatever fits your server or playstyle
*   **Brewable Potions** — Craft your own protection on demand with the Potion of Mob Attack Protection
*   **Multiloader** — Works on **Fabric** and **NeoForge** (Forge supported up to 1.21.4)
*   **ModMenu Support** — Fabric users get an in-game config screen via ModMenu

## 🧪 Brewing Recipes

| Recipe                                     |Result                               | |
| ------------------------------------------ |------------------------------------ | --- |
| Potion of Weakness + <strong>Blaze Powder</strong> |<strong>Potion of Mob Attack Protection</strong> |<img src="https://media.forgecdn.net/attachments/description/1183148/description_d75a5dc4-550b-419f-8848-185ce39de644.png" alt="Recipe"> |
| Potion of Mob Attack Protection + <strong>Redstone</strong> |<strong>Long Potion of Mob Attack Protection</strong> |<img src="https://media.forgecdn.net/attachments/description/1183148/description_48f6dca9-f51b-4bbe-b8b3-8849bda09e9f.png" alt="Recipe"> |

## ⚙️ Configuration

**Fabric** (`config/spawnguard.json5`):

```
{
  "enableSpawnGuard": true,
  "mobAttackProtectionDuration": 6000
}
```

**NeoForge** (`config/spawnguard-common.toml`):

```
enableSpawnGuard = true
mobAttackProtectionDuration = 6000
```

*   `enableSpawnGuard` — Toggle spawn protection on or off
*   `mobAttackProtectionDuration` — Duration in ticks (20 ticks = 1 second, default: 6000 = 5 minutes)

## 📦 Supported Platforms

| Loader   |Required Dependencies    |
| -------- |------------------------ |
| Fabric   |Fabric API, Cloth Config |
| NeoForge |—                        |
| Forge    |— *(up to 1.21.4 only)*  |

## 🔗 Links

*   [GitHub](https://github.com/zendiik/spawnguard)
*   [Issue Tracker](https://github.com/zendiik/spawnguard/issues)