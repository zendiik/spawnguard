# SpawnGuard

[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1183148?logo=curseforge&label=CurseForge&color=F16436)](https://www.curseforge.com/minecraft/mc-mods/spawnguard)
[![CurseForge Version](https://img.shields.io/curseforge/v/1183148?logo=curseforge&label=Latest&color=F16436)](https://www.curseforge.com/minecraft/mc-mods/spawnguard)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/spawnguard?logo=modrinth&label=Modrinth&color=00AF5C)](https://modrinth.com/mod/spawnguard)
[![Modrinth Version](https://img.shields.io/modrinth/v/spawnguard?logo=modrinth&label=Latest&color=00AF5C)](https://modrinth.com/mod/spawnguard)

**SpawnGuard** protects players from mob attacks for a configurable duration after spawning. No more dying to a creeper 10 seconds into a new world. Works on Fabric, Forge, and NeoForge.

## Features

- **Spawn Protection** — Automatically applies Mob Attack Protection when a player first joins the world
- **Configurable Duration** — Set exactly how long protection lasts (default: 5 minutes)
- **Potion Brewing** — Brew a Potion of Mob Attack Protection for on-demand safety
- **Multiloader** — Single mod, three loaders: Fabric, Forge, NeoForge

## Brewing Recipes

| Recipe | Result |
|--------|--------|
| Potion of Weakness + Blaze Powder | Potion of Mob Attack Protection |
| Potion of Mob Attack Protection + Redstone | Long Potion of Mob Attack Protection |

## Configuration

| Option | Default | Description |
|--------|---------|-------------|
| `enableSpawnGuard` | `true` | Enable or disable spawn protection |
| `mobAttackProtectionDuration` | `6000` | Duration in ticks (20 ticks = 1 second) |

**Fabric** (`config/spawnguard.json5`):
```json5
{
  "enableSpawnGuard": true,
  "mobAttackProtectionDuration": 6000
}
```

**Forge / NeoForge** (`config/spawnguard-common.toml`):
```toml
enableSpawnGuard = true
mobAttackProtectionDuration = 6000
```

Fabric users with [ModMenu](https://modrinth.com/mod/modmenu) installed get an in-game config screen.

## Installation

1. Install the mod loader of your choice (Fabric, Forge, or NeoForge)
2. Download SpawnGuard for your loader from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/spawnguard) or [Modrinth](https://modrinth.com/mod/spawnguard)
3. Place the JAR in your `mods/` folder
4. **Fabric only**: Requires [Fabric API](https://modrinth.com/mod/fabric-api) and [Cloth Config](https://modrinth.com/mod/cloth-config)

## Requirements

- **Minecraft**: 1.21.4
- **Java**: 21
- **Fabric**: Fabric Loader + Fabric API + Cloth Config
- **Forge**: Forge 54+
- **NeoForge**: NeoForge 21.4+

## Links

- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/spawnguard)
- [Modrinth](https://modrinth.com/mod/spawnguard)
- [GitHub](https://github.com/zendiik/spawnguard)
- [Issues](https://github.com/zendiik/spawnguard/issues)

## Building from Source

```bash
./gradlew clean build
```

JARs will be in `fabric/build/libs/`, `forge/build/libs/`, `neoforge/build/libs/`.

## License

GNU LGPL 3.0
