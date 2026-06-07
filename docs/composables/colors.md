# Colors

Kore provides multiple color systems: utility extensions on `Color`, Tailwind CSS color palette, and Radix UI color scales.

---

## Color Extensions

### Color.blend()

Blends this color toward a target [blendColor] using linear interpolation.

```kotlin
val blended = KoreTheme.colorScheme.primary.blend(
    blendColor = Color.White,
    blendValue = 0.85f
)
```

### Parameters

| Parameter | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `blendColor` | `Color` | — | The target color to blend into. |
| `blendValue` | `Float` | `0.85f` | Blend amount in the range `0f..1f`. `0f` returns this color, `1f` returns `blendColor`. |

### Color.toHexString()

Converts the color to an ARGB hex string prefixed with `0x`.

```kotlin
val hex = Color.Red.toHexString() // "0xFFFF0000"
```

---

## Tailwind Colors

The `TailwindColors` object provides the complete Tailwind CSS color palette with 22 color families and 11 shades each (50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 950).

### Usage

```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    containerColor = TailwindColors.Blue.swatch500
) {
    Text(
        text = "Tailwind Blue 500",
        color = TailwindColors.White
    )
}
```

### Color Families

| Family   | swatch50 | swatch100 | swatch200 | swatch300 | swatch400 | swatch500 | swatch600 | swatch700 | swatch800 | swatch900 | swatch950 |
|----------|----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
| Slate | `#F8FAFC` | `#F1F5F9` | `#E2E8F0` | `#CBD5E1` | `#94A3B8` | `#64748B` | `#475569` | `#334155` | `#1E293B` | `#0F172A` | `#020617` |
| Gray | `#F9FAFB` | `#F3F4F6` | `#E5E7EB` | `#D1D5DB` | `#9CA3AF` | `#6B7280` | `#4B5563` | `#374151` | `#1F2937` | `#111827` | `#030712` |
| Zinc | `#FAFAFA` | `#F4F4F5` | `#E4E4E7` | `#D4D4D8` | `#A1A1AA` | `#71717A` | `#52525B` | `#3F3F46` | `#27272A` | `#18181B` | `#09090B` |
| Neutral | `#FAFAFA` | `#F5F5F5` | `#E5E5E5` | `#D4D4D4` | `#A3A3A3` | `#737373` | `#525252` | `#404040` | `#262626` | `#171717` | `#0A0A0A` |
| Stone | `#FAFAF9` | `#F5F5F4` | `#E7E5E4` | `#D6D3D1` | `#A8A29E` | `#78716C` | `#57534E` | `#44403C` | `#292524` | `#1C1917` | `#0C0A09` |
| Red | `#FEF2F2` | `#FEE2E2` | `#FECACA` | `#FCA5A5` | `#F87171` | `#EF4444` | `#DC2626` | `#B91C1C` | `#991B1B` | `#7F1D1D` | `#450A0A` |
| Orange | `#FFF7ED` | `#FFEDD5` | `#FED7AA` | `#FDBA74` | `#FB923C` | `#F97316` | `#EA580C` | `#C2410C` | `#9A3412` | `#7C2D12` | `#431407` |
| Amber | `#FFFBEB` | `#FEEFC7` | `#FDE68A` | `#FCD34D` | `#FBBF24` | `#F59E0B` | `#D97706` | `#B45309` | `#92400E` | `#78350F` | `#451A03` |
| Yellow | `#FEFCE8` | `#FEF9C3` | `#FEF08A` | `#FDE047` | `#FACC15` | `#EAB308` | `#CA8A04` | `#A16207` | `#854D0E` | `#713F12` | `#422006` |
| Lime | `#F7FEE7` | `#ECFCCB` | `#D9F99D` | `#BEF264` | `#A3E635` | `#84CC16` | `#65A30D` | `#4D7C0F` | `#3F6212` | `#365314` | `#1A2E05` |
| Green | `#F0FDF4` | `#DCFCE7` | `#BBF7D0` | `#86EFAC` | `#4ADE80` | `#22C55E` | `#16A34A` | `#15803D` | `#166534` | `#14532D` | `#052E16` |
| Emerald | `#ECFDF5` | `#D1FAE5` | `#A7F3D0` | `#6EE7B7` | `#34D399` | `#10B981` | `#059669` | `#047857` | `#065F46` | `#064E3B` | `#022C22` |
| Teal | `#F0FDFA` | `#CCFBF1` | `#99F6E4` | `#5EEAD4` | `#2DD4BF` | `#14B8A6` | `#0D9488` | `#0F766E` | `#115E59` | `#134E4A` | `#042F2E` |
| Cyan | `#ECFEFF` | `#CEFEFE` | `#AFFAF8` | `#67E8F9` | `#22D3EE` | `#06B6D4` | `#0891B2` | `#0E7490` | `#155E75` | `#164E63` | `#083344` |
| Sky | `#F0F9FF` | `#E0F2FE` | `#BAE6FD` | `#7DD3FC` | `#38BDF8` | `#0EA5E9` | `#0284C7` | `#0369A1` | `#075985` | `#0C4A6E` | `#082F49` |
| Blue | `#EFF6FF` | `#DBEAFE` | `#BFDBFE` | `#93C5FD` | `#60A5FA` | `#3B82F6` | `#2563EB` | `#1D4ED8` | `#1E40AF` | `#1E3A8A` | `#172554` |
| Indigo | `#EEF2FF` | `#E0E7FF` | `#C7D2FE` | `#A5B4FC` | `#818CF8` | `#6366F1` | `#4F46E5` | `#4338CA` | `#3730A3` | `#312E81` | `#1E1B4B` |
| Violet | `#F5F3FF` | `#EDE9FE` | `#DDD6FE` | `#C4B5FD` | `#A78BFA` | `#8B5CF6` | `#7C3AED` | `#6D28D9` | `#5B21B6` | `#4C1D95` | `#2E1065` |
| Purple | `#FAF5FF` | `#F3E8FF` | `#E9D5FF` | `#D8B4FE` | `#C084FC` | `#A855F7` | `#9333EA` | `#7E22CE` | `#6B21A8` | `#581C87` | `#3B0764` |
| Fuchsia | `#FDF4FF` | `#FAE8FF` | `#F5D0FE` | `#F0ABFC` | `#E879F9` | `#D946EF` | `#C026D3` | `#A21CAF` | `#86198F` | `#701A75` | `#4A044E` |
| Pink | `#FDF2F8` | `#FCE7F3` | `#FBCFE8` | `#F9A8D4` | `#F472B6` | `#EC4899` | `#DB2777` | `#BE185D` | `#9D174D` | `#831843` | `#500724` |
| Rose | `#FFF1F2` | `#FFE4E6` | `#FECDD3` | `#FDA4AF` | `#FB7185` | `#F43F5E` | `#E11D48` | `#BE123C` | `#9F1239` | `#881337` | `#4C0519` |

### Semantic Colors

| Color | Value |
|-------|-------|
| `TailwindColors.Black` | `#FF000000` |
| `TailwindColors.White` | `#FFFFFFFF` |
| `TailwindColors.Transparent` | `#00000000` |

### Convenience Accessor

```kotlin
Color.Tailwind // equivalent to TailwindColors
```

---

## Radix Colors

The `RadixColors` object provides the Radix UI color system with both light and dark variants for each color scale. Each scale has 12 steps with consistent semantic meaning:

| Steps | Usage |
|-------|-------|
| 1–2 | App / page backgrounds |
| 3–5 | Component backgrounds (default, hover, active) |
| 6–8 | Borders (subtle, normal, strong) |
| 9–10 | Solid fills (buttons, badges, tags) |
| 11–12 | Text & icons (low contrast, high contrast) |

### Usage

```kotlin
// Light mode
val surface = RadixColors.Gray.light.step1
val text = RadixColors.Gray.dark.step12

// Dark mode
val background = RadixColors.Gray.dark.step1
val border = RadixColors.Gray.dark.step7
```

### Color Scales

| Scale | Light Variant | Dark Variant |
|-------|--------------|--------------|
| White | `RadixColors.White.scale` | — |
| Black | `RadixColors.Black.scale` | — |
| Gray | `RadixColors.Gray.light` | `RadixColors.Gray.dark` |
| Mauve | `RadixColors.Mauve.light` | `RadixColors.Mauve.dark` |
| Slate | `RadixColors.Slate.light` | `RadixColors.Slate.dark` |
| Sage | `RadixColors.Sage.light` | `RadixColors.Sage.dark` |
| Olive | `RadixColors.Olive.light` | `RadixColors.Olive.dark` |
| Sand | `RadixColors.Sand.light` | `RadixColors.Sand.dark` |
| Gold | `RadixColors.Gold.light` | `RadixColors.Gold.dark` |
| Bronze | `RadixColors.Bronze.light` | `RadixColors.Bronze.dark` |
| Brown | `RadixColors.Brown.light` | `RadixColors.Brown.dark` |
| Yellow | `RadixColors.Yellow.light` | `RadixColors.Yellow.dark` |
| Amber | `RadixColors.Amber.light` | `RadixColors.Amber.dark` |
| Orange | `RadixColors.Orange.light` | `RadixColors.Orange.dark` |
| Tomato | `RadixColors.Tomato.light` | `RadixColors.Tomato.dark` |
| Red | `RadixColors.Red.light` | `RadixColors.Red.dark` |
| Ruby | `RadixColors.Ruby.light` | `RadixColors.Ruby.dark` |
| Crimson | `RadixColors.Crimson.light` | `RadixColors.Crimson.dark` |
| Pink | `RadixColors.Pink.light` | `RadixColors.Pink.dark` |
| Plum | `RadixColors.Plum.light` | `RadixColors.Plum.dark` |
| Purple | `RadixColors.Purple.light` | `RadixColors.Purple.dark` |
| Violet | `RadixColors.Violet.light` | `RadixColors.Violet.dark` |
| Iris | `RadixColors.Iris.light` | `RadixColors.Iris.dark` |
| Indigo | `RadixColors.Indigo.light` | `RadixColors.Indigo.dark` |
| Blue | `RadixColors.Blue.light` | `RadixColors.Blue.dark` |
| Cyan | `RadixColors.Cyan.light` | `RadixColors.Cyan.dark` |
| Teal | `RadixColors.Teal.light` | `RadixColors.Teal.dark` |
| Jade | `RadixColors.Jade.light` | `RadixColors.Jade.dark` |
| Green | `RadixColors.Green.light` | `RadixColors.Green.dark` |
| Grass | `RadixColors.Grass.light` | `RadixColors.Grass.dark` |
| Lime | `RadixColors.Lime.light` | `RadixColors.Lime.dark` |
| Mint | `RadixColors.Mint.light` | `RadixColors.Mint.dark` |
| Sky | `RadixColors.Sky.light` | `RadixColors.Sky.dark` |
