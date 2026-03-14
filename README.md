# SpawnGuard

![Minecraft Version](https://img.shields.io/badge/minecraft-1.21.4-brightgreen)
![Mod Version](https://img.shields.io/badge/version-1.0.1-blue)
![Fabric](https://img.shields.io/badge/loader-Fabric-dbd0b4)
![Forge](https://img.shields.io/badge/loader-Forge-1c2e45)
![NeoForge](https://img.shields.io/badge/loader-NeoForge-f16436)
![License](https://img.shields.io/badge/license-LGPL--3.0-green)

SpawnGuard is a multiloader Minecraft mod that provides players with a grace period from mob attacks right after they spawn. Perfect for survival worlds, hardcore challenges, or custom modpacks where initial safety is crucial.

## Features

- **Spawn Protection**: Automatically applies protection effect when players spawn
- **Configurable Duration**: Customize protection time to fit your gameplay needs
- **Multiloader Support**: Works seamlessly across Fabric, Forge, and NeoForge
- **Brewing System**: Craft Potion of Mob Attack Protection for extended safety
- **Visual Feedback**: Clear particle effects indicate when protection is active
- **Server-Friendly**: Fully compatible with multiplayer servers

## How It Works

When a player spawns or respawns, SpawnGuard applies a temporary Mob Attack Protection effect. While this effect is active, hostile mobs cannot damage the player, giving them time to:

- Gather initial resources
- Build basic shelter
- Orient themselves in the world
- Prepare defenses

## Brewing Recipes

### Base Potion
- **Awkward Potion** + **Blaze Powder** = **Potion of Mob Attack Protection**

### Extended Duration
- **Potion of Mob Attack Protection** + **Redstone** = **Long Mob Attack Protection**

## Configuration

Configuration files are located in:
- **Fabric**: `config/spawnguard.json5`
- **Forge/NeoForge**: Forge config system

Available options:
- `enableSpawnGuard`: Enable/disable spawn protection (default: true)
- `mobAttackProtectionDuration`: Protection duration in ticks (20 ticks = 1 second)

## Download & Installation

1. Download the mod from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/spawnguard) or [Modrinth](https://modrinth.com/mod/spawnguard)
2. Install the appropriate mod loader (Fabric, Forge, or NeoForge)
3. Place the downloaded `.jar` file in your `mods` folder
4. Launch Minecraft and enjoy!

### Requirements
- **Minecraft**: 1.21.4
- **Java**: 21+
- **Fabric**: Fabric API
- **Fabric**: owo-lib (for configuration UI)

## Building from Source

```bash
# Clone the repository
git clone https://github.com/netleak/spawnguard.git
cd spawnguard

# Build all loaders
./gradlew build

# Or build specific loader
./gradlew :fabric:build
./gradlew :forge:build
./gradlew :neoforge:build
```

Built JARs will be in `{loader}/build/libs/`

## License

SpawnGuard is licensed under the [GNU LGPL 3.0](LICENSE).

## Credits

Created by [Netleak](https://github.com/netleak)
