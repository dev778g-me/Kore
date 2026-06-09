
@file:Suppress("unused")

package com.dev.kore.themes.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

/**
 * Radix UI Color System
 * All color scales in one object both Light and Dark mode.
 *
 * Each scale has 12 steps with consistent semantic meaning:
 *   1–2  : App / page backgrounds
 *   3–5  : Component backgrounds (default, hover, active)
 *   6–8  : Borders (subtle, normal, strong)
 *   9–10 : Solid fills (buttons, badges, tags)
 *  11–12 : Text & icons (low contrast, high contrast)
 */

object RadixColors {

    object White {
        val white = Color(0xFFffffff)

        val scale = RadixScale(
            step1  = Color(0x04ffffff),
            step2  = Color(0x09ffffff),
            step3  = Color(0x11ffffff),
            step4  = Color(0x1Affffff),
            step5  = Color(0x24ffffff),
            step6  = Color(0x30ffffff),
            step7  = Color(0x40ffffff),
            step8  = Color(0x5Dffffff),
            step9  = Color(0x73ffffff),
            step10 = Color(0x80ffffff),
            step11 = Color(0xB3ffffff),
            step12 = Color(0xEDffffff),
        )
    }

    object Black {
        val black = Color(0xFF000000)

        val scale = RadixScale(
            step1 = Color(0x04000000),
            step2 = Color(0x09000000),
            step3 = Color(0x11000000),
            step4 = Color(0x1A000000),
            step5 = Color(0x24000000),
            step6 = Color(0x30000000),
            step7 = Color(0x40000000),
            step8 = Color(0x5D000000),
            step9 = Color(0x73000000),
            step10 = Color(0x80000000),
            step11 = Color(0xB3000000),
            step12 = Color(0xED000000),
        )
    }

    object Gray {
        val light = RadixScale(
            step1 = Color(0xFFfcfcfc),
            step2 = Color(0xFFf9f9f9),
            step3 = Color(0xFFf0f0f0),
            step4 = Color(0xFFe8e8e8),
            step5 = Color(0xFFe0e0e0),
            step6 = Color(0xFFd9d9d9),
            step7 = Color(0xFFcecece),
            step8 = Color(0xFFbbbbbb),
            step9 = Color(0xFF8d8d8d),
            step10 = Color(0xFF838383),
            step11 = Color(0xFF646464),
            step12 = Color(0xFF202020),
        )

        val dark = RadixScale(
            step1  = Color(0xFF111111),
            step2  = Color(0xFF191919),
            step3  = Color(0xFF222222),
            step4  = Color(0xFF2a2a2a),
            step5  = Color(0xFF313131),
            step6  = Color(0xFF3a3a3a),
            step7  = Color(0xFF484848),
            step8  = Color(0xFF606060),
            step9  = Color(0xFF6e6e6e),
            step10 = Color(0xFF7b7b7b),
            step11 = Color(0xFFb4b4b4),
            step12 = Color(0xFFeeeeee),
        )
    }

    object Mauve {
        val light = RadixScale(
            step1  = Color(0xFFfdfcfd),
            step2  = Color(0xFFfaf9fb),
            step3  = Color(0xFFf2eff3),
            step4  = Color(0xFFeae7ec),
            step5  = Color(0xFFe3dfe6),
            step6  = Color(0xFFdbd8e0),
            step7  = Color(0xFFd0cdd7),
            step8  = Color(0xFFbcbac7),
            step9  = Color(0xFF8e8c99),
            step10 = Color(0xFF84828e),
            step11 = Color(0xFF65636d),
            step12 = Color(0xFF211f26),
        )

        val dark = RadixScale(
            step1  = Color(0xFF121113),
            step2  = Color(0xFF1a191b),
            step3  = Color(0xFF232225),
            step4  = Color(0xFF2b292d),
            step5  = Color(0xFF323035),
            step6  = Color(0xFF3c393f),
            step7  = Color(0xFF49474e),
            step8  = Color(0xFF625f69),
            step9  = Color(0xFF6f6d78),
            step10 = Color(0xFF7c7a85),
            step11 = Color(0xFFb5b2bc),
            step12 = Color(0xFFeeeef0),
        )
    }

    object Slate {
        val light = RadixScale(
            step1  = Color(0xFFfcfcfd),
            step2  = Color(0xFFf9f9fb),
            step3  = Color(0xFFf0f0f3),
            step4  = Color(0xFFe8e8ed),
            step5  = Color(0xFFe0e1e6),
            step6  = Color(0xFFd9d9e0),
            step7  = Color(0xFFcdced6),
            step8  = Color(0xFFb9bbc6),
            step9  = Color(0xFF8b8d98),
            step10 = Color(0xFF80838d),
            step11 = Color(0xFF60646c),
            step12 = Color(0xFF1c2024),
        )

        val dark = RadixScale(
            step1  = Color(0xFF111113),
            step2  = Color(0xFF18191b),
            step3  = Color(0xFF212225),
            step4  = Color(0xFF272a2d),
            step5  = Color(0xFF2e3135),
            step6  = Color(0xFF363a3f),
            step7  = Color(0xFF43484e),
            step8  = Color(0xFF5a6169),
            step9  = Color(0xFF696e77),
            step10 = Color(0xFF777b84),
            step11 = Color(0xFFb0b4ba),
            step12 = Color(0xFFedeef0),
        )
    }

    object Sage {
        val light = RadixScale(
            step1  = Color(0xFFfbfdfc),
            step2  = Color(0xFFf7f9f8),
            step3  = Color(0xFFeef1f0),
            step4  = Color(0xFFe6e9e8),
            step5  = Color(0xFFdfe2e0),
            step6  = Color(0xFFd7dad9),
            step7  = Color(0xFFcbcfcd),
            step8  = Color(0xFFb8bcba),
            step9  = Color(0xFF868e8b),
            step10 = Color(0xFF7c8481),
            step11 = Color(0xFF5f6563),
            step12 = Color(0xFF1a211e)
        )
        val dark = RadixScale(
            step1  = Color(0xFF101211),
            step2  = Color(0xFF171918),
            step3  = Color(0xFF202221),
            step4  = Color(0xFF272a29),
            step5  = Color(0xFF2e3130),
            step6  = Color(0xFF373b39),
            step7  = Color(0xFF444947),
            step8  = Color(0xFF5b6360),
            step9  = Color(0xFF63706b),
            step10 = Color(0xFF717d79),
            step11 = Color(0xFFadb5b2),
            step12 = Color(0xFFeceeed)
        )
    }

    object Olive {
        val light = RadixScale(
            step1  = Color(0xFFfcfdfc),
            step2  = Color(0xFFf8faf8),
            step3  = Color(0xFFeff1ef),
            step4  = Color(0xFFe7e9e7),
            step5  = Color(0xFFdfe2df),
            step6  = Color(0xFFd7dad7),
            step7  = Color(0xFFcbcecb),
            step8  = Color(0xFFb9bcb8),
            step9  = Color(0xFF898e87),
            step10 = Color(0xFF7f847d),
            step11 = Color(0xFF60655f),
            step12 = Color(0xFF1d211c)
        )
        val dark = RadixScale(
            step1  = Color(0xFF111210),
            step2  = Color(0xFF181917),
            step3  = Color(0xFF212220),
            step4  = Color(0xFF282a27) ,
            step5  = Color(0xFF2f312e),
            step6  = Color(0xFF383a36),
            step7  = Color(0xFF454843),
            step8  = Color(0xFF5c625b),
            step9  = Color(0xFF687066),
            step10 = Color(0xFF767d74),
            step11 = Color(0xFFafb5ad),
            step12 = Color(0xFFeceeec)
        )
    }

    object Sand {
        val light = RadixScale(
            step1  = Color(0xFFfdfdfc),
            step2  = Color(0xFFf9f9f8),
            step3  = Color(0xFFf1f0ef),
            step4  = Color(0xFFe9e8e6),
            step5  = Color(0xFFe2e1de),
            step6  = Color(0xFFdad9d6),
            step7  = Color(0xFFcfceca),
            step8  = Color(0xFFbcbbb5),
            step9  = Color(0xFF8d8d86),
            step10 = Color(0xFF82827c),
            step11 = Color(0xFF63635e),
            step12 = Color(0xFF21201c)
        )
        val dark = RadixScale(
            step1  = Color(0xFF111110),
            step2  = Color(0xFF191916),
            step3  = Color(0xFF22211e),
            step4  = Color(0xFF2a2925),
            step5  = Color(0xFF31302b),
            step6  = Color(0xFF3b3a35),
            step7  = Color(0xFF494841),
            step8  = Color(0xFF62605b),
            step9  = Color(0xFF6f6d66),
            step10 = Color(0xFF7c7b74),
            step11 = Color(0xFFb5b3ad),
            step12 = Color(0xFFeeeeec)
        )
    }

    object Gold {
        val light = RadixScale(
            step1  = Color(0xFFfdfdfc),
            step2  = Color(0xFFfaf9f2),
            step3  = Color(0xFFf2f0e7),
            step4  = Color(0xFFeae6d7),
            step5  = Color(0xFFe1dbc8),
            step6  = Color(0xFFd4cdb5),
            step7  = Color(0xFFc2b99a),
            step8  = Color(0xFFa9991b),
            step9  = Color(0xFF978365),
            step10 = Color(0xFF8c7a5e),
            step11 = Color(0xFF71624b),
            step12 = Color(0xFF3b3422)
        )
        val dark = RadixScale(
            step1  = Color(0xFF121211),
            step2  = Color(0xFF1b1a17),
            step3  = Color(0xFF24231f),
            step4  = Color(0xFF2d2b26),
            step5  = Color(0xFF35332d),
            step6  = Color(0xFF3e3c35),
            step7  = Color(0xFF504e45),
            step8  = Color(0xFF6b6757),
            step9  = Color(0xFF978365),
            step10 = Color(0xFFa39073),
            step11 = Color(0xFFcbb99a),
            step12 = Color(0xFFe8e2d9)
        )
    }

    object Bronze {
        val light = RadixScale(
            step1  = Color(0xFFfdfcfc),
            step2  = Color(0xFFfdf8f6),
            step3  = Color(0xFFf6edea),
            step4  = Color(0xFFede3df),
            step5  = Color(0xFFe3d9d3),
            step6  = Color(0xFFd8cdc6),
            step7  = Color(0xFFc8bdb4),
            step8  = Color(0xFFb1a49a),
            step9  = Color(0xFF9c8d84),
            step10 = Color(0xFF91827a),
            step11 = Color(0xFF6f6460),
            step12 = Color(0xFF282120)
        )
        val dark = RadixScale(
            step1  = Color(0xFF141110),
            step2  = Color(0xFF1c1917),
            step3  = Color(0xFF262220),
            step4  = Color(0xFF302a27),
            step5  = Color(0xFF3b3330),
            step6  = Color(0xFF463d39),
            step7  = Color(0xFF594f4a),
            step8  = Color(0xFF6f6259),
            step9  = Color(0xFF9c8d84),
            step10 = Color(0xFFa99991),
            step11 = Color(0xFFd4bdb6),
            step12 = Color(0xFFede0da)
        )
    }

    object Brown {
        val light = RadixScale(
            step1  = Color(0xFFfefdfc),
            step2  = Color(0xFFfcf9f6),
            step3  = Color(0xFFf6eee7),
            step4  = Color(0xFFf0e4d9),
            step5  = Color(0xFFebdacd),
            step6  = Color(0xFFe3cfc0),
            step7  = Color(0xFFd9c0ad),
            step8  = Color(0xFFcbaa91),
            step9  = Color(0xFFad7f58),
            step10 = Color(0xFFa07652),
            step11 = Color(0xFF815e46),
            step12 = Color(0xFF3e2712)
        )
        val dark = RadixScale(
            step1  = Color(0xFF12110f),
            step2  = Color(0xFF1c1916),
            step3  = Color(0xFF28211a),
            step4  = Color(0xFF322922),
            step5  = Color(0xFF3e3128),
            step6  = Color(0xFF4d3c2f),
            step7  = Color(0xFF614a39),
            step8  = Color(0xFF7c5f46),
            step9  = Color(0xFFad7f58),
            step10 = Color(0xFFb98c67),
            step11 = Color(0xFFdbb594),
            step12 = Color(0xFFf2e1ca)
        )
    }

    object Yellow {
        val light = RadixScale(
            step1  = Color(0xFFfdfdf9),
            step2  = Color(0xFFfffce8),
            step3  = Color(0xFFfffbd1),
            step4  = Color(0xFFfff8bb),
            step5  = Color(0xFFfef2a4),
            step6  = Color(0xFFf9e68c),
            step7  = Color(0xFFefd36c),
            step8  = Color(0xFFebbc00),
            step9  = Color(0xFFf5d90a),
            step10 = Color(0xFFf7ce00),
            step11 = Color(0xFF946800),
            step12 = Color(0xFF35290f)
        )
        val dark = RadixScale(
            step1  = Color(0xFF14120b),
            step2  = Color(0xFF1b180f),
            step3  = Color(0xFF2d2305),
            step4  = Color(0xFF362b00),
            step5  = Color(0xFF433500),
            step6  = Color(0xFF524202),
            step7  = Color(0xFF665417),
            step8  = Color(0xFF836a21),
            step9  = Color(0xFFf5d90a),
            step10 = Color(0xFFffef5c),
            step11 = Color(0xFFf6ef5b),
            step12 = Color(0xFFfffad1)
        )
    }

    object Amber {
        val light = RadixScale(
            step1  = Color(0xFFfefdfb),
            step2  = Color(0xFFfff9ed),
            step3  = Color(0xFFfff4d5),
            step4  = Color(0xFFffecbc),
            step5  = Color(0xFFffe3a2),
            step6  = Color(0xFFffd386),
            step7  = Color(0xFFf3ba63),
            step8  = Color(0xFFee9d2b),
            step9  = Color(0xFFffb224),
            step10 = Color(0xFFffa01c),
            step11 = Color(0xFFad5700),
            step12 = Color(0xFF4e2009)
        )
        val dark = RadixScale(
            step1  = Color(0xFF16120b),
            step2  = Color(0xFF1d180f),
            step3  = Color(0xFF302008),
            step4  = Color(0xFF3f2700),
            step5  = Color(0xFF4d3000),
            step6  = Color(0xFF5c3d05),
            step7  = Color(0xFF714f19),
            step8  = Color(0xFF8f6424),
            step9  = Color(0xFFffb224),
            step10 = Color(0xFFffcb47),
            step11 = Color(0xFFf1a10d),
            step12 = Color(0xFFfef3dd)
        )
    }

    object Orange {
        val light = RadixScale(
            step1  = Color(0xFFfefcfb),
            step2  = Color(0xFFfff7ed),
            step3  = Color(0xFFffefd6),
            step4  = Color(0xFFffdfb5),
            step5  = Color(0xFFffd19a),
            step6  = Color(0xFFffc182),
            step7  = Color(0xFFf5ae73),
            step8  = Color(0xFFec9455),
            step9  = Color(0xFFf76b15),
            step10 = Color(0xFFef5f00),
            step11 = Color(0xFFcc4e00),
            step12 = Color(0xFF582d1d)
        )
        val dark = RadixScale(
            step1  = Color(0xFF17120e),
            step2  = Color(0xFF1e160f),
            step3  = Color(0xFF331e0b),
            step4  = Color(0xFF462100),
            step5  = Color(0xFF562800),
            step6  = Color(0xFF66350c),
            step7  = Color(0xFF7e451d),
            step8  = Color(0xFFa35829),
            step9  = Color(0xFFf76b15),
            step10 = Color(0xFFff801f),
            step11 = Color(0xFFff8b3e),
            step12 = Color(0xFFfeedd5)
        )
    }

    object Tomato {
        val light = RadixScale(
            step1  = Color(0xFFfffcfc),
            step2  = Color(0xFFfff8f7),
            step3  = Color(0xFFfeebe7),
            step4  = Color(0xFFffddd6),
            step5  = Color(0xFFffcdc2),
            step6  = Color(0xFFfdbdaf),
            step7  = Color(0xFFf5a898),
            step8  = Color(0xFFec8e7b),
            step9  = Color(0xFFe54d2e),
            step10 = Color(0xFFdb4324),
            step11 = Color(0xFFca3214),
            step12 = Color(0xFF5c1a10)
        )
        val dark = RadixScale(
            step1  = Color(0xFF181111),
            step2  = Color(0xFF1f1513),
            step3  = Color(0xFF391714),
            step4  = Color(0xFF4e1511),
            step5  = Color(0xFF5e1c16),
            step6  = Color(0xFF722522),
            step7  = Color(0xFF8c3329),
            step8  = Color(0xFFb54739),
            step9  = Color(0xFFe54d2e),
            step10 = Color(0xFFec6142),
            step11 = Color(0xFFff977d),
            step12 = Color(0xFFfbd3cb)
        )
    }

    object Red {
        val light = RadixScale(
            step1  = Color(0xFFfffcfc),
            step2  = Color(0xFFfff7f7),
            step3  = Color(0xFFfeebec),
            step4  = Color(0xFFffdbdc),
            step5  = Color(0xFFffcdce),
            step6  = Color(0xFFfdbdbe),
            step7  = Color(0xFFf4a9aa),
            step8  = Color(0xFFeb8e90),
            step9  = Color(0xFFe5484d),
            step10 = Color(0xFFda3f44),
            step11 = Color(0xFFce2c31),
            step12 = Color(0xFF641723)
        )
        val dark = RadixScale(
            step1  = Color(0xFF191111),
            step2  = Color(0xFF201314),
            step3  = Color(0xFF3b1219),
            step4  = Color(0xFF500f1c),
            step5  = Color(0xFF611623),
            step6  = Color(0xFF72232d),
            step7  = Color(0xFF8c333a),
            step8  = Color(0xFFb54548),
            step9  = Color(0xFFe5484d),
            step10 = Color(0xFFec5d5e),
            step11 = Color(0xFFff9592),
            step12 = Color(0xFFffd1d9)
        )
    }

    object Ruby {
        val light = RadixScale(
            step1  = Color(0xFFfffcfd),
            step2  = Color(0xFFfff7f8),
            step3  = Color(0xFFfeeaed),
            step4  = Color(0xFFffdbe1),
            step5  = Color(0xFFffced6),
            step6  = Color(0xFFf8bfc8),
            step7  = Color(0xFFefacb8),
            step8  = Color(0xFFe592a3),
            step9  = Color(0xFFe54666),
            step10 = Color(0xFFda3b5a),
            step11 = Color(0xFFca244d),
            step12 = Color(0xFF64172b)
        )
        val dark = RadixScale(
            step1  = Color(0xFF191113),
            step2  = Color(0xFF200f14),
            step3  = Color(0xFF3b0f1f),
            step4  = Color(0xFF500f27),
            step5  = Color(0xFF601730),
            step6  = Color(0xFF72263b),
            step7  = Color(0xFF8c334b),
            step8  = Color(0xFFb34468),
            step9  = Color(0xFFe54666),
            step10 = Color(0xFFec5a72),
            step11 = Color(0xFFff949d),
            step12 = Color(0xFFffd1dc)
        )
    }

    object Crimson {
        val light = RadixScale(
            step1  = Color(0xFFfffcfd),
            step2  = Color(0xFFfef7f9),
            step3  = Color(0xFFffe9f0),
            step4  = Color(0xFFfedce8),
            step5  = Color(0xFFfacedd),
            step6  = Color(0xFFf3bed1),
            step7  = Color(0xFFe8abc0),
            step8  = Color(0xFFe093aa),
            step9  = Color(0xFFe93d82),
            step10 = Color(0xFFdf3278),
            step11 = Color(0xFFcb1d63),
            step12 = Color(0xFF621639)
        )
        val dark = RadixScale(
            step1  = Color(0xFF191114),
            step2  = Color(0xFF200f17),
            step3  = Color(0xFF3a102a),
            step4  = Color(0xFF4e1036),
            step5  = Color(0xFF5e1842),
            step6  = Color(0xFF6f2751),
            step7  = Color(0xFF883464),
            step8  = Color(0xFFb04478),
            step9  = Color(0xFFe93d82),
            step10 = Color(0xFFee518a),
            step11 = Color(0xFFff92ad),
            step12 = Color(0xFFfdd3e8)
        )
    }

    object Pink {
        val light = RadixScale(
            step1  = Color(0xFFfffcfe),
            step2  = Color(0xFFfef7fb),
            step3  = Color(0xFFfdeaf4),
            step4  = Color(0xFFfaddef),
            step5  = Color(0xFFf6cfe8),
            step6  = Color(0xFFefbfdf),
            step7  = Color(0xFFe7acd4),
            step8  = Color(0xFFdd93c2),
            step9  = Color(0xFFd6409f),
            step10 = Color(0xFFcf3897),
            step11 = Color(0xFFc2298a),
            step12 = Color(0xFF651249)
        )
        val dark = RadixScale(
            step1  = Color(0xFF191117),
            step2  = Color(0xFF21101c),
            step3  = Color(0xFF37122e),
            step4  = Color(0xFF4b143d),
            step5  = Color(0xFF591c47),
            step6  = Color(0xFF692955),
            step7  = Color(0xFF833869),
            step8  = Color(0xFFa84885),
            step9  = Color(0xFFd6409f),
            step10 = Color(0xFFde51a8),
            step11 = Color(0xFFff8dcc),
            step12 = Color(0xFFfdd1ea)
        )
    }

    object Plum {
        val light = RadixScale(
            step1  = Color(0xFFfefcff),
            step2  = Color(0xFFfdf7ff),
            step3  = Color(0xFFfbebff),
            step4  = Color(0xFFf7deff),
            step5  = Color(0xFFf2d1ff),
            step6  = Color(0xFFe9c2f9),
            step7  = Color(0xFFdeaef4),
            step8  = Color(0xFFcf91e8),
            step9  = Color(0xFFab4aba),
            step10 = Color(0xFFa144af),
            step11 = Color(0xFF953ea3),
            step12 = Color(0xFF53195d)
        )
        val dark = RadixScale(
            step1  = Color(0xFF181118),
            step2  = Color(0xFF201320),
            step3  = Color(0xFF351a35),
            step4  = Color(0xFF451d47),
            step5  = Color(0xFF532557),
            step6  = Color(0xFF633263),
            step7  = Color(0xFF7c4082),
            step8  = Color(0xFF9f55a6),
            step9  = Color(0xFFab4aba),
            step10 = Color(0xFFb658c4),
            step11 = Color(0xFFe796f3),
            step12 = Color(0xFFf4d4f4)
        )
    }

    object Purple {
        val light = RadixScale(
            step1  = Color(0xFFfefcfe),
            step2  = Color(0xFFfbf7fe),
            step3  = Color(0xFFf7edfe),
            step4  = Color(0xFFf2e2fc),
            step5  = Color(0xFFead5f9),
            step6  = Color(0xFFe0c4f4),
            step7  = Color(0xFFd1afec),
            step8  = Color(0xFFbe93e4),
            step9  = Color(0xFF8e4ec6),
            step10 = Color(0xFF8347b9),
            step11 = Color(0xFF7938b2),
            step12 = Color(0xFF402060)
        )
        val dark = RadixScale(
            step1  = Color(0xFF18111b),
            step2  = Color(0xFF1e1523),
            step3  = Color(0xFF301c3b),
            step4  = Color(0xFF3d224e),
            step5  = Color(0xFF48295c),
            step6  = Color(0xFF54346b),
            step7  = Color(0xFF664282),
            step8  = Color(0xFF8457aa),
            step9  = Color(0xFF8e4ec6),
            step10 = Color(0xFF9a5cd0),
            step11 = Color(0xFFd19dff),
            step12 = Color(0xFFecd9fa)
        )
    }

    object Violet {
        val light = RadixScale(
            step1  = Color(0xFFfdfcfe),
            step2  = Color(0xFFfaf8ff),
            step3  = Color(0xFFf4f0fe),
            step4  = Color(0xFFede9fe),
            step5  = Color(0xFFe4defc),
            step6  = Color(0xFFd7cff9),
            step7  = Color(0xFFc4b8f3),
            step8  = Color(0xFFaa99ec),
            step9  = Color(0xFF6e56cf),
            step10 = Color(0xFF654dc4),
            step11 = Color(0xFF6550b9),
            step12 = Color(0xFF2f265f)
        )
        val dark = RadixScale(
            step1  = Color(0xFF14121f),
            step2  = Color(0xFF1b1525),
            step3  = Color(0xFF291f43),
            step4  = Color(0xFF33255a),
            step5  = Color(0xFF3c2e69),
            step6  = Color(0xFF473876),
            step7  = Color(0xFF56468b),
            step8  = Color(0xFF6958ad),
            step9  = Color(0xFF6e56cf),
            step10 = Color(0xFF7d66d9),
            step11 = Color(0xFFbaa7ff),
            step12 = Color(0xFFe2dffe)
        )
    }

    object Iris {
        val light = RadixScale(
            step1  = Color(0xFFfdfcff),
            step2  = Color(0xFFf8f8ff),
            step3  = Color(0xFFf0f1fe),
            step4  = Color(0xFFe6e7fd),
            step5  = Color(0xFFdadcfb),
            step6  = Color(0xFFcbcef8),
            step7  = Color(0xFFb8bdf4),
            step8  = Color(0xFF9da3ee),
            step9  = Color(0xFF5b5bd6),
            step10 = Color(0xFF5151cd),
            step11 = Color(0xFF5753c6),
            step12 = Color(0xFF272962)
        )
        val dark = RadixScale(
            step1  = Color(0xFF13131e),
            step2  = Color(0xFF171625),
            step3  = Color(0xFF202248),
            step4  = Color(0xFF262a65),
            step5  = Color(0xFF303374),
            step6  = Color(0xFF3d3e82),
            step7  = Color(0xFF4a4d96),
            step8  = Color(0xFF5b60b5),
            step9  = Color(0xFF5b5bd6),
            step10 = Color(0xFF6e6ade),
            step11 = Color(0xFFb1aeff) ,
            step12 = Color(0xFFe0dffe)
        )
    }

    object Indigo {
        val light = RadixScale(
            step1  = Color(0xFFfdfdfe),
            step2  = Color(0xFFf7f9ff),
            step3  = Color(0xFFedf2fe),
            step4  = Color(0xFFe1eafd),
            step5  = Color(0xFFd2dffb),
            step6  = Color(0xFFc1d0f9),
            step7  = Color(0xFFabbdf5),
            step8  = Color(0xFF8da4ef),
            step9  = Color(0xFF3e63dd),
            step10 = Color(0xFF3a5ccc),
            step11 = Color(0xFF3451b2),
            step12 = Color(0xFF1f306e)
        )
        val dark = RadixScale(
            step1  = Color(0xFF11131f),
            step2  = Color(0xFF141726),
            step3  = Color(0xFF182449),
            step4  = Color(0xFF1d2e62),
            step5  = Color(0xFF253974),
            step6  = Color(0xFF304384),
            step7  = Color(0xFF3a549a),
            step8  = Color(0xFF4164c2),
            step9  = Color(0xFF3e63dd),
            step10 = Color(0xFF5472e4),
            step11 = Color(0xFF9eb1ff),
            step12 = Color(0xFFd6e1ff)
        )
    }

    object Blue {
        val light = RadixScale(
            step1  = Color(0xFFfbfdff),
            step2  = Color(0xFFf4faff),
            step3  = Color(0xFFe6f4fe),
            step4  = Color(0xFFd5efff),
            step5  = Color(0xFFc2e5ff),
            step6  = Color(0xFFacd8fc),
            step7  = Color(0xFF8ec8f6),
            step8  = Color(0xFF5eb1ef),
            step9  = Color(0xFF0090ff),
            step10 = Color(0xFF0588f0),
            step11 = Color(0xFF0d74ce),
            step12 = Color(0xFF113264)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0d1520),
            step2  = Color(0xFF111927),
            step3  = Color(0xFF0d2847),
            step4  = Color(0xFF003362),
            step5  = Color(0xFF004074),
            step6  = Color(0xFF104d87),
            step7  = Color(0xFF205d9e),
            step8  = Color(0xFF2870bd),
            step9  = Color(0xFF0090ff),
            step10 = Color(0xFF3b9eff),
            step11 = Color(0xFF70b8ff),
            step12 = Color(0xFFc2e6ff)
        )
    }

    object Cyan {
        val light = RadixScale(
            step1  = Color(0xFFfafdfe),
            step2  = Color(0xFFf2fafb),
            step3  = Color(0xFFdef7f9),
            step4  = Color(0xFFcaf1f6),
            step5  = Color(0xFFb5e9f0),
            step6  = Color(0xFF9ddde7),
            step7  = Color(0xFF7dcfdb),
            step8  = Color(0xFF3db9cf),
            step9  = Color(0xFF00a2c7),
            step10 = Color(0xFF0797b9),
            step11 = Color(0xFF107d98),
            step12 = Color(0xFF0d3c48)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0b161a),
            step2  = Color(0xFF101b20),
            step3  = Color(0xFF082c36),
            step4  = Color(0xFF003848),
            step5  = Color(0xFF004558),
            step6  = Color(0xFF045468),
            step7  = Color(0xFF12677e),
            step8  = Color(0xFF11809c),
            step9  = Color(0xFF00a2c7),
            step10 = Color(0xFF23afd0),
            step11 = Color(0xFF4ccce6),
            step12 = Color(0xFFb6ecf7)
        )
    }

    object Teal {
        val light = RadixScale(
            step1  = Color(0xFFfafefd),
            step2  = Color(0xFFf3fbf9),
            step3  = Color(0xFFe0f8f3),
            step4  = Color(0xFFccf3ea),
            step5  = Color(0xFFb8eae0),
            step6  = Color(0xFFa1ddd4),
            step7  = Color(0xFF83cdc5),
            step8  = Color(0xFF53b9b0),
            step9  = Color(0xFF12a594),
            step10 = Color(0xFF0d9b8a),
            step11 = Color(0xFF008573),
            step12 = Color(0xFF0d3d38)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0d1514),
            step2  = Color(0xFF111c1b),
            step3  = Color(0xFF0d2d2a),
            step4  = Color(0xFF023b37),
            step5  = Color(0xFF084843),
            step6  = Color(0xFF145750),
            step7  = Color(0xFF1c6961),
            step8  = Color(0xFF207e73),
            step9  = Color(0xFF12a594),
            step10 = Color(0xFF0eb39e),
            step11 = Color(0xFF0bd8b6),
            step12 = Color(0xFFadf0dd)
        )
    }

    object Jade {
        val light = RadixScale(
            step1  = Color(0xFFfbfefd),
            step2  = Color(0xFFf4fbf7),
            step3  = Color(0xFFe6f7ed),
            step4  = Color(0xFFd6f1e3),
            step5  = Color(0xFFc3e9d7),
            step6  = Color(0xFFacdec8),
            step7  = Color(0xFF8bceb5),
            step8  = Color(0xFF56ba9f),
            step9  = Color(0xFF29a383),
            step10 = Color(0xFF26997b),
            step11 = Color(0xFF208368),
            step12 = Color(0xFF1d3b31)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0d1512),
            step2  = Color(0xFF121c18),
            step3  = Color(0xFF0f2e22),
            step4  = Color(0xFF0b3b2c),
            step5  = Color(0xFF114837),
            step6  = Color(0xFF1b5745),
            step7  = Color(0xFF246854),
            step8  = Color(0xFF2a7e67),
            step9  = Color(0xFF29a383),
            step10 = Color(0xFF27b08b),
            step11 = Color(0xFF1fd8a4),
            step12 = Color(0xFFadf0d4)
        )
    }

    object Green {
        val light = RadixScale(
            step1  = Color(0xFFfbfefb),
            step2  = Color(0xFFf3fcf3),
            step3  = Color(0xFFe5f9e7),
            step4  = Color(0xFFd6f1da),
            step5  = Color(0xFFc4e8ca),
            step6  = Color(0xFFadddb9),
            step7  = Color(0xFF8ecea3),
            step8  = Color(0xFF5bb98c),
            step9  = Color(0xFF30a46c),
            step10 = Color(0xFF2b9a66),
            step11 = Color(0xFF218358),
            step12 = Color(0xFF193b2d)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0e1512),
            step2  = Color(0xFF121b17),
            step3  = Color(0xFF132d21),
            step4  = Color(0xFF113b29),
            step5  = Color(0xFF174933),
            step6  = Color(0xFF20573e),
            step7  = Color(0xFF28684a),
            step8  = Color(0xFF2f7c57),
            step9  = Color(0xFF30a46c),
            step10 = Color(0xFF33b074),
            step11 = Color(0xFF3dd68c),
            step12 = Color(0xFFb1f1cb)
        )
    }

    object Grass {
        val light = RadixScale(
            step1  = Color(0xFFfbfefb),
            step2  = Color(0xFFf5fbf5),
            step3  = Color(0xFFe9f6e9),
            step4  = Color(0xFFdaf1db),
            step5  = Color(0xFFc9e8ca),
            step6  = Color(0xFFb2ddb5),
            step7  = Color(0xFF94ce9a),
            step8  = Color(0xFF65ba74),
            step9  = Color(0xFF46a758),
            step10 = Color(0xFF3d9e4e),
            step11 = Color(0xFF297c3b),
            step12 = Color(0xFF1b311e)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0d1407),
            step2  = Color(0xFF11190b),
            step3  = Color(0xFF132b0e),
            step4  = Color(0xFF1d3a14),
            step5  = Color(0xFF25461b),
            step6  = Color(0xFF2d5423),
            step7  = Color(0xFF36642b),
            step8  = Color(0xFF3d7834),
            step9  = Color(0xFF46a758),
            step10 = Color(0xFF53b365),
            step11 = Color(0xFF71d083),
            step12 = Color(0xFFc2f0c2)
        )
    }

    object Lime {
        val light = RadixScale(
            step1  = Color(0xFFfcfdfa),
            step2  = Color(0xFFf8faf3),
            step3  = Color(0xFFeff5e0),
            step4  = Color(0xFFe5efcd),
            step5  = Color(0xFFdae8bb),
            step6  = Color(0xFFcde0a4),
            step7  = Color(0xFFb8d383),
            step8  = Color(0xFF9dc06b),
            step9  = Color(0xFFbde56c),
            step10 = Color(0xFFb3d94f),
            step11 = Color(0xFF5c7c10),
            step12 = Color(0xFF2c3a10)
        )
        val dark = RadixScale(
            step1  = Color(0xFF11130c),
            step2  = Color(0xFF151a10),
            step3  = Color(0xFF1f2917),
            step4  = Color(0xFF29371d),
            step5  = Color(0xFF334423),
            step6  = Color(0xFF3d522a),
            step7  = Color(0xFF496231),
            step8  = Color(0xFF577538),
            step9  = Color(0xFFbde56c),
            step10 = Color(0xFFd4f070),
            step11 = Color(0xFFbde56c),
            step12 = Color(0xFFe3f7ba)
        )
    }

    object Mint {
        val light = RadixScale(
            step1  = Color(0xFFf9fefd),
            step2  = Color(0xFFf2fbf9),
            step3  = Color(0xFFddf9f1),
            step4  = Color(0xFFc8f4e9),
            step5  = Color(0xFFb3ecde),
            step6  = Color(0xFF9ae3d1),
            step7  = Color(0xFF7dd5bf),
            step8  = Color(0xFF4cc4a9),
            step9  = Color(0xFF86ead4),
            step10 = Color(0xFF7de0cb),
            step11 = Color(0xFF027864),
            step12 = Color(0xFF16302b)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0e1515),
            step2  = Color(0xFF0f1b1b),
            step3  = Color(0xFF092c2b),
            step4  = Color(0xFF003a38),
            step5  = Color(0xFF004744),
            step6  = Color(0xFF105552),
            step7  = Color(0xFF1e6462),
            step8  = Color(0xFF277f7a),
            step9  = Color(0xFF86ead4),
            step10 = Color(0xFFa8f5e5),
            step11 = Color(0xFF58d5ba),
            step12 = Color(0xFFc4f5e1)
        )
    }

    object Sky {
        val light = RadixScale(
            step1  = Color(0xFFf9feff),
            step2  = Color(0xFFf1fafd),
            step3  = Color(0xFFe1f6fd),
            step4  = Color(0xFFd1f0fa),
            step5  = Color(0xFFbee7f5),
            step6  = Color(0xFFa9daed),
            step7  = Color(0xFF8dcae3),
            step8  = Color(0xFF60b3d7),
            step9  = Color(0xFF7ce2fe),
            step10 = Color(0xFF74daf8),
            step11 = Color(0xFF00749e),
            step12 = Color(0xFF1d3e56)
        )
        val dark = RadixScale(
            step1  = Color(0xFF0d1520),
            step2  = Color(0xFF111b27),
            step3  = Color(0xFF112840),
            step4  = Color(0xFF113555),
            step5  = Color(0xFF154467),
            step6  = Color(0xFF1b537b),
            step7  = Color(0xFF1f6692),
            step8  = Color(0xFF197cae),
            step9  = Color(0xFF7ce2fe),
            step10 = Color(0xFFa8eeff),
            step11 = Color(0xFF75c7f0),
            step12 = Color(0xFFc2f3ff)
        )
    }
}

@Immutable
data class RadixScale(
    val step1: Color,
    val step2: Color,
    val step3: Color,
    val step4: Color,
    val step5: Color,
    val step6: Color,
    val step7: Color,
    val step8: Color,
    val step9: Color,
    val step10: Color,
    val step11: Color,
    val step12: Color,
) {
    val steps = listOf(
        step1, step2, step3, step4, step5, step6,
        step7, step8, step9, step10, step11, step12
    )
}



