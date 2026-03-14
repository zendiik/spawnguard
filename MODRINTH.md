# SpawnGuard

Survive your first night with confidence! SpawnGuard provides a protective grace period from mob attacks when you spawn.

## Overview

SpawnGuard is a multiloader mod (Fabric, Forge, NeoForge) that automatically applies a Mob Attack Protection effect when players spawn or respawn. This gives you crucial time to gather resources and establish yourself without the frustration of instant death.

## Features

### Automatic Spawn Protection
- Protection effect applied automatically on spawn/respawn
- Hostile mobs cannot damage you while protected
- Time to gather resources and build shelter
- Configurable duration to match your difficulty preference

### Brewable Protection Potions
Craft potions to extend your protection beyond the initial spawn:

```
Awkward Potion + Blaze Powder = Potion of Mob Attack Protection
Potion of Mob Attack Protection + Redstone = Long Mob Attack Protection
```

Perfect for dangerous expeditions or challenging tasks!

### Visual Feedback
Clear particle effects indicate when protection is active - no guessing!

### Multiloader Support
Works on:
- Fabric (requires Fabric API + owo-lib)
- Forge
- NeoForge

### Fully Configurable
Adjust settings to match your playstyle:
- Toggle spawn protection on/off
- Customize protection duration
- Configure per-world or server-wide

### Server Compatible
Works perfectly on multiplayer servers!

## Configuration

**Fabric:** `config/spawnguard.json5`
**Forge/NeoForge:** Forge config system

Available options:
- `enableSpawnGuard` - Enable/disable spawn protection (default: true)
- `mobAttackProtectionDuration` - Protection time in ticks (20 ticks = 1 second)

## Requirements

| Loader | Requirements |
|--------|--------------|
| Fabric | Fabric API, owo-lib |
| Forge | Forge 54.1.0+ |
| NeoForge | NeoForge 21.4.147+ |

**Minecraft:** 1.21.4
**Java:** 21+

## FAQ

**Does this work on servers?**
Yes! Fully compatible with multiplayer servers.

**Can I adjust the protection duration?**
Absolutely! Edit the config file and change `mobAttackProtectionDuration`.

**Will this make the game too easy?**
No - protection is temporary and only affects mob damage. You can still take fall damage, fire damage, etc.

**Does it protect against all damage?**
No, only hostile mob damage. Environmental hazards are still dangerous!

**Can I use this in my modpack?**
Yes! Licensed under GNU LGPL 3.0 - free to use in modpacks.

## Support

**Issues:** [GitHub Issues](https://github.com/netleak/spawnguard/issues)
**Source:** [GitHub Repository](https://github.com/netleak/spawnguard)

## License

GNU Lesser General Public License v3.0

Created by **Netleak**
