# QuickStart

Quickstart guide for using Kore.

Make sure you have installed the Kore library into your project:

```kotlin
implementation("io.github.dev778g-me:kore:1.0.0-alpha01")
```

Download and install the Kore companion app or web app.

<figure><img src="quickstart_images/companion_app.png" alt="companion app"><figcaption></figcaption></figure>

Although Kore comes with default themes `KoreDefaults`, you can customize it using the Kore Companion app **ThemeBuilder**. From there, choose color schemes for dark and light mode, shapes, and sizes — then hit export and you get your `theme.kt` file.

<figure><img src="quickstart_images/customize.png" alt="Customizing"><figcaption></figcaption></figure>

Replace your project's `theme.kt` (which comes by default with Material Theme) or add this file directly to your project.

<figure><img src="quickstart_images/export.png" alt="export theme"><figcaption></figcaption></figure>

Wrap your main content with `AppTheme` (renameable inside `theme.kt`) and you're all set.

{% columns %}
{% column %}
<figure><img src="quickstart_images/material_theme_wrapper.png" alt="Material Theme"></figure>
{% endcolumn %}
{% column %}
<figure><img src="quickstart_images/apptheme_wrapper.png" alt="App Theme"></figure>
{% endcolumn %}
{% endcolumns %}

*Happy building 😻*