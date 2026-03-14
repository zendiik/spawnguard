# SpawnGuard

**Survive your first night with confidence!**

SpawnGuard is a multiloader mod (Fabric, Forge, NeoForge) that gives players a protective grace period from mob attacks right after spawning. Perfect for survival worlds, hardcore challenges, or any scenario where starting safely is essential.

---

## Why SpawnGuard?

Starting a new Minecraft world can be brutal. One wrong move and you're respawning before you've even found wood. SpawnGuard changes that by giving you a fair chance to establish yourself without compromising the survival experience.

**Key Benefits:**
- No more instant death on spawn in difficult scenarios
- Balanced protection that doesn't break gameplay
- Perfect for modpack creators who want fair spawn mechanics
- Great for servers with challenging spawn areas
- Configurable to match your preferred difficulty

---

## Features

### Automatic Spawn Protection
When you spawn or respawn, SpawnGuard automatically applies the Mob Attack Protection effect. While protected, hostile mobs cannot harm you, giving you precious time to:
- Gather basic resources
- Find shelter
- Craft initial tools
- Orient yourself in the world

### Brewable Protection Potions
Extend your safety beyond the initial spawn with craftable potions:

**Base Potion:**
- Awkward Potion + Blaze Powder = Potion of Mob Attack Protection

**Extended Duration:**
- Potion of Mob Attack Protection + Redstone = Long Mob Attack Protection

Perfect for dangerous expeditions or preparing for challenging tasks!

### Visual Feedback
Clear particle effects let you know when you're protected. No guessing, no confusion - you'll always know your status.

### Fully Configurable
Customize the experience to match your playstyle:
- Enable/disable spawn protection
- Adjust protection duration (measured in ticks)
- Configure per-world or server-wide

### Multiloader Support
One mod, three loaders:
- **Fabric** (with Fabric API and owo-lib)
- **Forge**
- **NeoForge**

### Server-Friendly
Works perfectly on multiplayer servers with no client-side requirements (though having it on both is recommended for the best experience).

---

## Configuration

**Fabric:** `config/spawnguard.json5`
**Forge/NeoForge:** Forge config system

### Available Options

| Option | Description | Default |
|--------|-------------|---------|
| `enableSpawnGuard` | Enable/disable spawn protection | `true` |
| `mobAttackProtectionDuration` | Protection time in ticks (20 ticks = 1 second) | varies by loader |

---

## Requirements

- **Minecraft:** 1.21.4
- **Java:** 21+
- **Fabric:** Fabric API + owo-lib
- **Forge:** Forge 54.1.0+
- **NeoForge:** NeoForge 21.4.147+

---

## Installation

1. Download the correct version for your mod loader
2. Install the required dependencies (Fabric API for Fabric, owo-lib for Fabric config UI)
3. Drop the `.jar` file into your `mods` folder
4. Launch Minecraft and configure if desired
5. Spawn safely!

---

## FAQ

**Q: Does this work on servers?**
A: Yes! SpawnGuard is fully compatible with multiplayer servers.

**Q: Can I adjust how long the protection lasts?**
A: Absolutely! Check the config file and adjust `mobAttackProtectionDuration` to your liking.

**Q: Will this make the game too easy?**
A: The protection only lasts for a limited time (configurable). It gives you a fair start without removing the survival challenge.

**Q: Does it protect against all damage?**
A: No, only damage from hostile mobs. You can still take fall damage, fire damage, drowning, etc.

**Q: Can I use this in my modpack?**
A: Yes! This mod is licensed under GNU LGPL 3.0. Feel free to include it in modpacks.

---

## Support & Links

- **Issues & Suggestions:** [GitHub Issues](https://github.com/netleak/spawnguard/issues)
- **Source Code:** [GitHub Repository](https://github.com/netleak/spawnguard)

---

## License

SpawnGuard is licensed under the GNU Lesser General Public License v3.0.

Created with care by **Netleak**
