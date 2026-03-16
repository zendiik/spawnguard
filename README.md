# SpawnGuard

Multiloader Minecraft mod (Fabric, Forge, NeoForge) that protects players from mob attacks for a configurable duration after spawning.

## Features

- **Spawn Protection** — Automatically applies a Mob Attack Protection effect when a player joins the world for the first time, preventing damage from hostile mobs.
- **Configurable Duration** — The protection duration is fully configurable (default: 5 minutes / 6000 ticks).
- **Potion Brewing** — Brew a Potion of Mob Attack Protection for on-demand safety:
  - Potion of Weakness + Blaze Powder = Potion of Mob Attack Protection
  - Potion of Mob Attack Protection + Redstone = Long Potion of Mob Attack Protection
- **Multiloader** — Works on Fabric, Forge, and NeoForge.

## Configuration

| Option | Default | Description |
|--------|---------|-------------|
| `enableSpawnGuard` | `true` | Enable or disable spawn protection |
| `mobAttackProtectionDuration` | `6000` | Duration of protection in ticks (20 ticks = 1 second) |

Config file locations:
- **Fabric**: `config/spawnguard.json5`
- **Forge/NeoForge**: `config/spawnguard-common.toml`

## Requirements

| | Minecraft | Java | Loader |
|---|-----------|------|--------|
| Fabric | 1.21.4 | 21 | Fabric Loader >=0.14, Fabric API |
| Forge | 1.21.4 | 21 | Forge 54+ |
| NeoForge | 1.21.4 | 21 | NeoForge 21.4+ |

## Download

- [GitHub Releases](https://github.com/zendiik/spawnguard/releases)

## Building from Source

```bash
./gradlew clean build
```

JARs will be in `fabric/build/libs/`, `forge/build/libs/`, `neoforge/build/libs/`.

## License

GNU LGPL 3.0
