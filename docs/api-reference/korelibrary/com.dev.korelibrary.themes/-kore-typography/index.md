//[korelibrary](../../../index.md)/[com.dev.korelibrary.themes](../index.md)/[KoreTypography](index.md)

# KoreTypography

[common]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [KoreTypography](index.md)(val display1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 57.sp,
        lineHeight    = 64.sp,
        letterSpacing = (-0.25).sp
    ), val display2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 45.sp,
        lineHeight    = 52.sp,
        letterSpacing = 0.sp
    ), val display3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 36.sp,
        lineHeight    = 44.sp,
        letterSpacing = 0.sp
    ), val heading1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 32.sp,
        lineHeight    = 40.sp,
        letterSpacing = 0.sp
    ), val heading2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 28.sp,
        lineHeight    = 36.sp,
        letterSpacing = 0.sp
    ), val heading3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 24.sp,
        lineHeight    = 32.sp,
        letterSpacing = 0.sp
    ), val title1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 22.sp,
        lineHeight    = 28.sp,
        letterSpacing = 0.sp
    ), val title2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.15.sp
    ), val title3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.1.sp
    ), val body1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.5.sp
    ), val body2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.25.sp
    ), val body3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Normal,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.4.sp
    ), val label1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 20.sp,
        letterSpacing = 0.1.sp
    ), val label2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 12.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp
    ), val label3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(
        fontWeight    = FontWeight.Medium,
        fontSize      = 11.sp,
        lineHeight    = 16.sp,
        letterSpacing = 0.5.sp
    ))

## Constructors

| | |
|---|---|
| [KoreTypography](-kore-typography.md) | [common]<br>constructor(display1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 57.sp,         lineHeight    = 64.sp,         letterSpacing = (-0.25).sp     ), display2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 45.sp,         lineHeight    = 52.sp,         letterSpacing = 0.sp     ), display3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 36.sp,         lineHeight    = 44.sp,         letterSpacing = 0.sp     ), heading1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 32.sp,         lineHeight    = 40.sp,         letterSpacing = 0.sp     ), heading2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 28.sp,         lineHeight    = 36.sp,         letterSpacing = 0.sp     ), heading3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 24.sp,         lineHeight    = 32.sp,         letterSpacing = 0.sp     ), title1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 22.sp,         lineHeight    = 28.sp,         letterSpacing = 0.sp     ), title2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Medium,         fontSize      = 16.sp,         lineHeight    = 24.sp,         letterSpacing = 0.15.sp     ), title3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Medium,         fontSize      = 14.sp,         lineHeight    = 20.sp,         letterSpacing = 0.1.sp     ), body1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 16.sp,         lineHeight    = 24.sp,         letterSpacing = 0.5.sp     ), body2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 14.sp,         lineHeight    = 20.sp,         letterSpacing = 0.25.sp     ), body3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Normal,         fontSize      = 12.sp,         lineHeight    = 16.sp,         letterSpacing = 0.4.sp     ), label1: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Medium,         fontSize      = 14.sp,         lineHeight    = 20.sp,         letterSpacing = 0.1.sp     ), label2: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Medium,         fontSize      = 12.sp,         lineHeight    = 16.sp,         letterSpacing = 0.5.sp     ), label3: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = TextStyle(         fontWeight    = FontWeight.Medium,         fontSize      = 11.sp,         lineHeight    = 16.sp,         letterSpacing = 0.5.sp     )) |

## Properties

| Name | Summary |
|---|---|
| [body1](body1.md) | [common]<br>val [body1](body1.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [body2](body2.md) | [common]<br>val [body2](body2.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [body3](body3.md) | [common]<br>val [body3](body3.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [display1](display1.md) | [common]<br>val [display1](display1.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [display2](display2.md) | [common]<br>val [display2](display2.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [display3](display3.md) | [common]<br>val [display3](display3.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [heading1](heading1.md) | [common]<br>val [heading1](heading1.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [heading2](heading2.md) | [common]<br>val [heading2](heading2.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [heading3](heading3.md) | [common]<br>val [heading3](heading3.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [label1](label1.md) | [common]<br>val [label1](label1.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [label2](label2.md) | [common]<br>val [label2](label2.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [label3](label3.md) | [common]<br>val [label3](label3.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [title1](title1.md) | [common]<br>val [title1](title1.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [title2](title2.md) | [common]<br>val [title2](title2.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |
| [title3](title3.md) | [common]<br>val [title3](title3.md): [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |