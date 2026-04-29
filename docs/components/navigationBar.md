# Navigation Bar

A Navigation Bar (often called a Bottom Navigation) is a persistent component placed at the bottom of the screen. It provides quick access to the app's top-level destinations, allowing users to switch between core features with a single tap.

You can use Navigation Bars for:
- Primary app routing containing 3 to 5 distinct, equally important destinations.
- Features that require direct, immediate access from anywhere in the app (e.g., Home, Search, Profile).

When not to use Navigation Bars:
- For secondary or nested navigation (use standard `Tabs` or `Appbars` instead).
- For single-task flows, like checkout screens or deep-focus editors (hide the navigation bar entirely to maximize screen real estate).



---

## Basic Example 

The best practice for managing a Navigation Bar in Compose is to drive it using a stateless data class. This keeps your labels, icons, and routing logic tightly coupled and prevents mismatched lists.

<figure><img src="showcases/navigationBarShowcase/navigation_bar.png" alt="Navigation Bar example image"><figcaption></figcaption></figure>

```kotlin
// 1. Create a data class to represent your destinations
data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String // Useful for actual NavController routing
)

// 2. Build the Navigation Bar
@Composable
fun AppBottomNavigation() {
    var selectedIndex by remember { mutableStateOf(0) }
    
    // Define your destinations
    val navItems = listOf(
        NavigationItem("Home", PhIcons.Bold.House, "home"),
        NavigationItem("Search", PhIcons.Bold.MagnifyingGlass, "search"),
        NavigationItem("Settings", PhIcons.Bold.Gear, "settings")
    )

    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = (selectedIndex == index),
                onClick = { selectedIndex = index },
                icon = { 
                    Icon(imageVector = item.icon, contentDescription = item.label) 
                },
                label = { 
                    Text(item.label) 
                }
            )
        }
    }
}
```

---

## Navigation Bar (Container)

The `NavigationBar` acts as the root container. It handles the layout background, minimum heights, and automatically applies system window insets so your navigation bar isn't obscured by the Android gesture navigation pill.

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | Applied to the root container of the Navigation Bar. |
| `containerColor`| `Color` | `KoreTheme.colorScheme.surface` | The background color of the entire navigation row. |
| `contentPadding`| `PaddingValues`| `NavigationBarDefaults...`| The horizontal and vertical padding applied around the items. |
| `content` | `@Composable RowScope.() -> Unit`| — | The `NavigationBarItem`s to display. Arranged with `SpaceBetween`. |

---

## Navigation Bar Item

The `NavigationBarItem` represents a single destination. It manages the layout of the icon and text label, handles the interactive touch states, and provides smooth, built-in visual feedback.

### Behavior & Best Practices
Under the hood, this component does a lot of heavy lifting for you:
* **Automatic Tinting:** It uses `CompositionLocalProvider` to override the `LocalContentColor`. This means you can drop a standard `Icon()` or `Text()` inside the slots without having to manually set their `tint` or `color` parameters.
* **Smooth Animations:** It automatically interpolates the colors of the icon, label, and background indicator when the `selected` state changes.
* **Smart Ripples:** The touch target spans the entire column height to be easily tappable, but the visual ripple effect is smartly bound only to the pill-shaped indicator around the icon.

### Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `selected` | `Boolean` | — | The current selected state of the destination. |
| `onClick` | `() -> Unit` | — | Callback invoked when the user taps anywhere on this item's column. |
| `icon` | `@Composable () -> Unit` | — | The main visual icon for the destination. |
| `label` | `@Composable () -> Unit` | — | The text label positioned below the icon. |
| `modifier` | `Modifier` | `Modifier` | Applied to the root column container of the individual item. |
| `enabled` | `Boolean` | `true` | Controls whether the item is interactive. |
| `indicatorShape`| `Shape` | `NavigationBarDefaults...`| The clipping shape of the highlight drawn behind the icon when selected. |
| `iconLabelSpacing`| `Dp` | `NavigationBarDefaults...`| The vertical gap (Spacer) between the icon and the text label. |
| `colors` | `NavigationBarItemColor`| `NavigationBarDefaults...`| The resolved colors for active/inactive/disabled states. |
| `interactionSource`| `MutableInteractionSource`| `remember { ... }` | Represents the stream of interactions (e.g., pressed, hovered). |

---

## Customization

### Custom Indicator Shapes

You can easily swap out the standard indicator shape for something more unique, like a perfect circle or a sharp rectangle, without breaking the ripple effect.

<figure><img src="showcases/navigationBarShowcase/customized_navigation_bar.png" alt="Navigation Bar example image"><figcaption></figcaption></figure>

```kotlin
NavigationBarItem(
    selected = true,
    onClick = { /* ... */ },
    icon = { Icon(imageVector = PhIcons.Bold.Bell, contentDescription = "Alerts") },
    label = { Text("Alerts") },
    iindicatorShape = CircleShape,
    colors = NavigationBarDefaults.defaultNavigationBarColors(
    selectedIndicatorColor = KoreTheme.colorScheme.primaryContainer,
    selectedIconColor = KoreTheme.colorScheme.onPrimaryContainer,
    selectedLabelColor = KoreTheme.colorScheme.onPrimaryContainer,
    unSelectedIndicatorColor = Color.Transparent,
    ),
)
```