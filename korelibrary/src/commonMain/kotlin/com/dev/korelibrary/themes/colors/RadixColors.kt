package com.dev.korelibrary.themes.colors

import androidx.compose.ui.graphics.Color

/**
 * Radix UI Color System
 * All color scales in one object  both Light and Dark mode.
 *
 * Each scale has 12 steps with consistent semantic meaning:
 *   1–2  : App / page backgrounds
 *   3–5  : Component backgrounds (default, hover, active)
 *   6–8  : Borders (subtle, normal, strong)
 *   9–10 : Solid fills (buttons, badges, tags)
 *  11–12 : Text & icons (low contrast, high contrast)
 *
 * Dark mode colors are NOT just inverted — they are independently
 * crafted to preserve the same semantic roles in dark environments.
 *
 * Source: https://www.radix-ui.com/colors
 */
object RadixColors {

    object White {
        val white = Color(0xFFffffff)

        // Alpha variants (white with decreasing opacity)
        val whiteA1  = Color(0x04ffffff)

        val whiteA2  = Color(0x09ffffff)
        val whiteA3  = Color(0x11ffffff)
        val whiteA4  = Color(0x1Affffff)
        val whiteA5  = Color(0x24ffffff)
        val whiteA6  = Color(0x30ffffff)
        val whiteA7  = Color(0x40ffffff)
        val whiteA8  = Color(0x5Dffffff)
        val whiteA9  = Color(0x73ffffff)
        val whiteA10 = Color(0x80ffffff)
        val whiteA11 = Color(0xB3ffffff)
        val whiteA12 = Color(0xEDffffff)
    }

    object Black {
        val black = Color(0xFF000000)

        // Alpha variants (black with decreasing opacity)
        val blackA1  = Color(0x04000000)
        val blackA2  = Color(0x09000000)
        val blackA3  = Color(0x11000000)
        val blackA4  = Color(0x1A000000)
        val blackA5  = Color(0x24000000)
        val blackA6  = Color(0x30000000)
        val blackA7  = Color(0x40000000)
        val blackA8  = Color(0x5D000000)
        val blackA9  = Color(0x73000000)
        val blackA10 = Color(0x80000000)
        val blackA11 = Color(0xB3000000)
        val blackA12 = Color(0xED000000)
    }

    // ─────────────────────────────────────────────────────────────
    // GRAY SCALES
    // ─────────────────────────────────────────────────────────────

    object Gray {
        object Light {
            val step1  = Color(0xFFfcfcfc)
            val step2  = Color(0xFFf9f9f9)
            val step3  = Color(0xFFf0f0f0)
            val step4  = Color(0xFFe8e8e8)
            val step5  = Color(0xFFe0e0e0)
            val step6  = Color(0xFFd9d9d9)
            val step7  = Color(0xFFcecece)
            val step8  = Color(0xFFbbbbbb)
            val step9  = Color(0xFF8d8d8d)
            val step10 = Color(0xFF838383)
            val step11 = Color(0xFF646464)
            val step12 = Color(0xFF202020)
        }
        object Dark {
            val step1  = Color(0xFF111111)
            val step2  = Color(0xFF191919)
            val step3  = Color(0xFF222222)
            val step4  = Color(0xFF2a2a2a)
            val step5  = Color(0xFF313131)
            val step6  = Color(0xFF3a3a3a)
            val step7  = Color(0xFF484848)
            val step8  = Color(0xFF606060)
            val step9  = Color(0xFF6e6e6e)
            val step10 = Color(0xFF7b7b7b)
            val step11 = Color(0xFFb4b4b4)
            val step12 = Color(0xFFeeeeee)
        }
    }

    object Mauve {
        object Light {
            val step1  = Color(0xFFfdfcfd)
            val step2  = Color(0xFFfaf9fb)
            val step3  = Color(0xFFf2eff3)
            val step4  = Color(0xFFeae7ec)
            val step5  = Color(0xFFe3dfe6)
            val step6  = Color(0xFFdbd8e0)
            val step7  = Color(0xFFd0cdd7)
            val step8  = Color(0xFFbcbac7)
            val step9  = Color(0xFF8e8c99)
            val step10 = Color(0xFF84828e)
            val step11 = Color(0xFF65636d)
            val step12 = Color(0xFF211f26)
        }
        object Dark {
            val step1  = Color(0xFF121113)
            val step2  = Color(0xFF1a191b)
            val step3  = Color(0xFF232225)
            val step4  = Color(0xFF2b292d)
            val step5  = Color(0xFF323035)
            val step6  = Color(0xFF3c393f)
            val step7  = Color(0xFF49474e)
            val step8  = Color(0xFF625f69)
            val step9  = Color(0xFF6f6d78)
            val step10 = Color(0xFF7c7a85)
            val step11 = Color(0xFFb5b2bc)
            val step12 = Color(0xFFeeeef0)
        }
    }

    object Slate {
        object Light {
            val step1  = Color(0xFFfcfcfd)
            val step2  = Color(0xFFf9f9fb)
            val step3  = Color(0xFFf0f0f3)
            val step4  = Color(0xFFe8e8ed)
            val step5  = Color(0xFFe0e1e6)
            val step6  = Color(0xFFd9d9e0)
            val step7  = Color(0xFFcdced6)
            val step8  = Color(0xFFb9bbc6)
            val step9  = Color(0xFF8b8d98)
            val step10 = Color(0xFF80838d)
            val step11 = Color(0xFF60646c)
            val step12 = Color(0xFF1c2024)
        }
        object Dark {
            val step1  = Color(0xFF111113)
            val step2  = Color(0xFF18191b)
            val step3  = Color(0xFF212225)
            val step4  = Color(0xFF272a2d)
            val step5  = Color(0xFF2e3135)
            val step6  = Color(0xFF363a3f)
            val step7  = Color(0xFF43484e)
            val step8  = Color(0xFF5a6169)
            val step9  = Color(0xFF696e77)
            val step10 = Color(0xFF777b84)
            val step11 = Color(0xFFb0b4ba)
            val step12 = Color(0xFFedeef0)
        }
    }

    object Sage {
        object Light {
            val step1  = Color(0xFFfbfdfc)
            val step2  = Color(0xFFf7f9f8)
            val step3  = Color(0xFFeef1f0)
            val step4  = Color(0xFFe6e9e8)
            val step5  = Color(0xFFdfe2e0)
            val step6  = Color(0xFFd7dad9)
            val step7  = Color(0xFFcbcfcd)
            val step8  = Color(0xFFb8bcba)
            val step9  = Color(0xFF868e8b)
            val step10 = Color(0xFF7c8481)
            val step11 = Color(0xFF5f6563)
            val step12 = Color(0xFF1a211e)
        }
        object Dark {
            val step1  = Color(0xFF101211)
            val step2  = Color(0xFF171918)
            val step3  = Color(0xFF202221)
            val step4  = Color(0xFF272a29)
            val step5  = Color(0xFF2e3130)
            val step6  = Color(0xFF373b39)
            val step7  = Color(0xFF444947)
            val step8  = Color(0xFF5b6360)
            val step9  = Color(0xFF63706b)
            val step10 = Color(0xFF717d79)
            val step11 = Color(0xFFadb5b2)
            val step12 = Color(0xFFeceeed)
        }
    }

    object Olive {
        object Light {
            val step1  = Color(0xFFfcfdfc)
            val step2  = Color(0xFFf8faf8)
            val step3  = Color(0xFFeff1ef)
            val step4  = Color(0xFFe7e9e7)
            val step5  = Color(0xFFdfe2df)
            val step6  = Color(0xFFd7dad7)
            val step7  = Color(0xFFcbcecb)
            val step8  = Color(0xFFb9bcb8)
            val step9  = Color(0xFF898e87)
            val step10 = Color(0xFF7f847d)
            val step11 = Color(0xFF60655f)
            val step12 = Color(0xFF1d211c)
        }
        object Dark {
            val step1  = Color(0xFF111210)
            val step2  = Color(0xFF181917)
            val step3  = Color(0xFF212220)
            val step4  = Color(0xFF282a27)
            val step5  = Color(0xFF2f312e)
            val step6  = Color(0xFF383a36)
            val step7  = Color(0xFF454843)
            val step8  = Color(0xFF5c625b)
            val step9  = Color(0xFF687066)
            val step10 = Color(0xFF767d74)
            val step11 = Color(0xFFafb5ad)
            val step12 = Color(0xFFeceeec)
        }
    }

    object Sand {
        object Light {
            val step1  = Color(0xFFfdfdfc)
            val step2  = Color(0xFFf9f9f8)
            val step3  = Color(0xFFf1f0ef)
            val step4  = Color(0xFFe9e8e6)
            val step5  = Color(0xFFe2e1de)
            val step6  = Color(0xFFdad9d6)
            val step7  = Color(0xFFcfceca)
            val step8  = Color(0xFFbcbbb5)
            val step9  = Color(0xFF8d8d86)
            val step10 = Color(0xFF82827c)
            val step11 = Color(0xFF63635e)
            val step12 = Color(0xFF21201c)
        }
        object Dark {
            val step1  = Color(0xFF111110)
            val step2  = Color(0xFF191916)
            val step3  = Color(0xFF22211e)
            val step4  = Color(0xFF2a2925)
            val step5  = Color(0xFF31302b)
            val step6  = Color(0xFF3b3a35)
            val step7  = Color(0xFF494841)
            val step8  = Color(0xFF62605b)
            val step9  = Color(0xFF6f6d66)
            val step10 = Color(0xFF7c7b74)
            val step11 = Color(0xFFb5b3ad)
            val step12 = Color(0xFFeeeeec)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // METAL / EARTH TONES
    // ─────────────────────────────────────────────────────────────

    object Gold {
        object Light {
            val step1  = Color(0xFFfdfdfc)
            val step2  = Color(0xFFfaf9f2)
            val step3  = Color(0xFFf2f0e7)
            val step4  = Color(0xFFeae6d7)
            val step5  = Color(0xFFe1dbc8)
            val step6  = Color(0xFFd4cdb5)
            val step7  = Color(0xFFc2b99a)
            val step8  = Color(0xFFa9991b)
            val step9  = Color(0xFF978365)
            val step10 = Color(0xFF8c7a5e)
            val step11 = Color(0xFF71624b)
            val step12 = Color(0xFF3b3422)
        }
        object Dark {
            val step1  = Color(0xFF121211)
            val step2  = Color(0xFF1b1a17)
            val step3  = Color(0xFF24231f)
            val step4  = Color(0xFF2d2b26)
            val step5  = Color(0xFF35332d)
            val step6  = Color(0xFF3e3c35)
            val step7  = Color(0xFF504e45)
            val step8  = Color(0xFF6b6757)
            val step9  = Color(0xFF978365)
            val step10 = Color(0xFFa39073)
            val step11 = Color(0xFFcbb99a)
            val step12 = Color(0xFFe8e2d9)
        }
    }

    object Bronze {
        object Light {
            val step1  = Color(0xFFfdfcfc)
            val step2  = Color(0xFFfdf8f6)
            val step3  = Color(0xFFf6edea)
            val step4  = Color(0xFFede3df)
            val step5  = Color(0xFFe3d9d3)
            val step6  = Color(0xFFd8cdc6)
            val step7  = Color(0xFFc8bdb4)
            val step8  = Color(0xFFb1a49a)
            val step9  = Color(0xFF9c8d84)
            val step10 = Color(0xFF91827a)
            val step11 = Color(0xFF6f6460)
            val step12 = Color(0xFF282120)
        }
        object Dark {
            val step1  = Color(0xFF141110)
            val step2  = Color(0xFF1c1917)
            val step3  = Color(0xFF262220)
            val step4  = Color(0xFF302a27)
            val step5  = Color(0xFF3b3330)
            val step6  = Color(0xFF463d39)
            val step7  = Color(0xFF594f4a)
            val step8  = Color(0xFF6f6259)
            val step9  = Color(0xFF9c8d84)
            val step10 = Color(0xFFa99991)
            val step11 = Color(0xFFd4bdb6)
            val step12 = Color(0xFFede0da)
        }
    }

    object Brown {
        object Light {
            val step1  = Color(0xFFfefdfc)
            val step2  = Color(0xFFfcf9f6)
            val step3  = Color(0xFFf6eee7)
            val step4  = Color(0xFFf0e4d9)
            val step5  = Color(0xFFebdacd)
            val step6  = Color(0xFFe3cfc0)
            val step7  = Color(0xFFd9c0ad)
            val step8  = Color(0xFFcbaa91)
            val step9  = Color(0xFFad7f58)
            val step10 = Color(0xFFa07652)
            val step11 = Color(0xFF815e46)
            val step12 = Color(0xFF3e2712)
        }
        object Dark {
            val step1  = Color(0xFF12110f)
            val step2  = Color(0xFF1c1916)
            val step3  = Color(0xFF28211a)
            val step4  = Color(0xFF322922)
            val step5  = Color(0xFF3e3128)
            val step6  = Color(0xFF4d3c2f)
            val step7  = Color(0xFF614a39)
            val step8  = Color(0xFF7c5f46)
            val step9  = Color(0xFFad7f58)
            val step10 = Color(0xFFb98c67)
            val step11 = Color(0xFFdbb594)
            val step12 = Color(0xFFf2e1ca)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // WARM TONES
    // ─────────────────────────────────────────────────────────────

    object Yellow {
        object Light {
            val step1  = Color(0xFFfdfdf9)
            val step2  = Color(0xFFfffce8)
            val step3  = Color(0xFFfffbd1)
            val step4  = Color(0xFFfff8bb)
            val step5  = Color(0xFFfef2a4)
            val step6  = Color(0xFFf9e68c)
            val step7  = Color(0xFFefd36c)
            val step8  = Color(0xFFebbc00)
            val step9  = Color(0xFFf5d90a)
            val step10 = Color(0xFFf7ce00)
            val step11 = Color(0xFF946800)
            val step12 = Color(0xFF35290f)
        }
        object Dark {
            val step1  = Color(0xFF14120b)
            val step2  = Color(0xFF1b180f)
            val step3  = Color(0xFF2d2305)
            val step4  = Color(0xFF362b00)
            val step5  = Color(0xFF433500)
            val step6  = Color(0xFF524202)
            val step7  = Color(0xFF665417)
            val step8  = Color(0xFF836a21)
            val step9  = Color(0xFFf5d90a)
            val step10 = Color(0xFFffef5c)
            val step11 = Color(0xFFf6ef5b)
            val step12 = Color(0xFFfffad1)
        }
    }

    object Amber {
        object Light {
            val step1  = Color(0xFFfefdfb)
            val step2  = Color(0xFFfff9ed)
            val step3  = Color(0xFFfff4d5)
            val step4  = Color(0xFFffecbc)
            val step5  = Color(0xFFffe3a2)
            val step6  = Color(0xFFffd386)
            val step7  = Color(0xFFf3ba63)
            val step8  = Color(0xFFee9d2b)
            val step9  = Color(0xFFffb224)
            val step10 = Color(0xFFffa01c)
            val step11 = Color(0xFFad5700)
            val step12 = Color(0xFF4e2009)
        }
        object Dark {
            val step1  = Color(0xFF16120b)
            val step2  = Color(0xFF1d180f)
            val step3  = Color(0xFF302008)
            val step4  = Color(0xFF3f2700)
            val step5  = Color(0xFF4d3000)
            val step6  = Color(0xFF5c3d05)
            val step7  = Color(0xFF714f19)
            val step8  = Color(0xFF8f6424)
            val step9  = Color(0xFFffb224)
            val step10 = Color(0xFFffcb47)
            val step11 = Color(0xFFf1a10d)
            val step12 = Color(0xFFfef3dd)
        }
    }

    object Orange {
        object Light {
            val step1  = Color(0xFFfefcfb)
            val step2  = Color(0xFFfff7ed)
            val step3  = Color(0xFFffefd6)
            val step4  = Color(0xFFffdfb5)
            val step5  = Color(0xFFffd19a)
            val step6  = Color(0xFFffc182)
            val step7  = Color(0xFFf5ae73)
            val step8  = Color(0xFFec9455)
            val step9  = Color(0xFFf76b15)
            val step10 = Color(0xFFef5f00)
            val step11 = Color(0xFFcc4e00)
            val step12 = Color(0xFF582d1d)
        }
        object Dark {
            val step1  = Color(0xFF17120e)
            val step2  = Color(0xFF1e160f)
            val step3  = Color(0xFF331e0b)
            val step4  = Color(0xFF462100)
            val step5  = Color(0xFF562800)
            val step6  = Color(0xFF66350c)
            val step7  = Color(0xFF7e451d)
            val step8  = Color(0xFFa35829)
            val step9  = Color(0xFFf76b15)
            val step10 = Color(0xFFff801f)
            val step11 = Color(0xFFff8b3e)
            val step12 = Color(0xFFfeedd5)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // RED / PINK FAMILY
    // ─────────────────────────────────────────────────────────────

    object Tomato {
        object Light {
            val step1  = Color(0xFFfffcfc)
            val step2  = Color(0xFFfff8f7)
            val step3  = Color(0xFFfeebe7)
            val step4  = Color(0xFFffddd6)
            val step5  = Color(0xFFffcdc2)
            val step6  = Color(0xFFfdbdaf)
            val step7  = Color(0xFFf5a898)
            val step8  = Color(0xFFec8e7b)
            val step9  = Color(0xFFe54d2e)
            val step10 = Color(0xFFdb4324)
            val step11 = Color(0xFFca3214)
            val step12 = Color(0xFF5c1a10)
        }
        object Dark {
            val step1  = Color(0xFF181111)
            val step2  = Color(0xFF1f1513)
            val step3  = Color(0xFF391714)
            val step4  = Color(0xFF4e1511)
            val step5  = Color(0xFF5e1c16)
            val step6  = Color(0xFF722522)
            val step7  = Color(0xFF8c3329)
            val step8  = Color(0xFFb54739)
            val step9  = Color(0xFFe54d2e)
            val step10 = Color(0xFFec6142)
            val step11 = Color(0xFFff977d)
            val step12 = Color(0xFFfbd3cb)
        }
    }

    object Red {
        object Light {
            val step1  = Color(0xFFfffcfc)
            val step2  = Color(0xFFfff7f7)
            val step3  = Color(0xFFfeebec)
            val step4  = Color(0xFFffdbdc)
            val step5  = Color(0xFFffcdce)
            val step6  = Color(0xFFfdbdbe)
            val step7  = Color(0xFFf4a9aa)
            val step8  = Color(0xFFeb8e90)
            val step9  = Color(0xFFe5484d)
            val step10 = Color(0xFFda3f44)
            val step11 = Color(0xFFce2c31)
            val step12 = Color(0xFF641723)
        }
        object Dark {
            val step1  = Color(0xFF191111)
            val step2  = Color(0xFF201314)
            val step3  = Color(0xFF3b1219)
            val step4  = Color(0xFF500f1c)
            val step5  = Color(0xFF611623)
            val step6  = Color(0xFF72232d)
            val step7  = Color(0xFF8c333a)
            val step8  = Color(0xFFb54548)
            val step9  = Color(0xFFe5484d)
            val step10 = Color(0xFFec5d5e)
            val step11 = Color(0xFFff9592)
            val step12 = Color(0xFFffd1d9)
        }
    }

    object Ruby {
        object Light {
            val step1  = Color(0xFFfffcfd)
            val step2  = Color(0xFFfff7f8)
            val step3  = Color(0xFFfeeaed)
            val step4  = Color(0xFFffdbe1)
            val step5  = Color(0xFFffced6)
            val step6  = Color(0xFFf8bfc8)
            val step7  = Color(0xFFefacb8)
            val step8  = Color(0xFFe592a3)
            val step9  = Color(0xFFe54666)
            val step10 = Color(0xFFda3b5a)
            val step11 = Color(0xFFca244d)
            val step12 = Color(0xFF64172b)
        }
        object Dark {
            val step1  = Color(0xFF191113)
            val step2  = Color(0xFF200f14)
            val step3  = Color(0xFF3b0f1f)
            val step4  = Color(0xFF500f27)
            val step5  = Color(0xFF601730)
            val step6  = Color(0xFF72263b)
            val step7  = Color(0xFF8c334b)
            val step8  = Color(0xFFb34468)
            val step9  = Color(0xFFe54666)
            val step10 = Color(0xFFec5a72)
            val step11 = Color(0xFFff949d)
            val step12 = Color(0xFFffd1dc)
        }
    }

    object Crimson {
        object Light {
            val step1  = Color(0xFFfffcfd)
            val step2  = Color(0xFFfef7f9)
            val step3  = Color(0xFFffe9f0)
            val step4  = Color(0xFFfedce8)
            val step5  = Color(0xFFfacedd)
            val step6  = Color(0xFFf3bed1)
            val step7  = Color(0xFFe8abc0)
            val step8  = Color(0xFFe093aa)
            val step9  = Color(0xFFe93d82)
            val step10 = Color(0xFFdf3278)
            val step11 = Color(0xFFcb1d63)
            val step12 = Color(0xFF621639)
        }
        object Dark {
            val step1  = Color(0xFF191114)
            val step2  = Color(0xFF200f17)
            val step3  = Color(0xFF3a102a)
            val step4  = Color(0xFF4e1036)
            val step5  = Color(0xFF5e1842)
            val step6  = Color(0xFF6f2751)
            val step7  = Color(0xFF883464)
            val step8  = Color(0xFFb04478)
            val step9  = Color(0xFFe93d82)
            val step10 = Color(0xFFee518a)
            val step11 = Color(0xFFff92ad)
            val step12 = Color(0xFFfdd3e8)
        }
    }

    object Pink {
        object Light {
            val step1  = Color(0xFFfffcfe)
            val step2  = Color(0xFFfef7fb)
            val step3  = Color(0xFFfdeaf4)
            val step4  = Color(0xFFfaddef)
            val step5  = Color(0xFFf6cfe8)
            val step6  = Color(0xFFefbfdf)
            val step7  = Color(0xFFe7acd4)
            val step8  = Color(0xFFdd93c2)
            val step9  = Color(0xFFd6409f)
            val step10 = Color(0xFFcf3897)
            val step11 = Color(0xFFc2298a)
            val step12 = Color(0xFF651249)
        }
        object Dark {
            val step1  = Color(0xFF191117)
            val step2  = Color(0xFF21101c)
            val step3  = Color(0xFF37122e)
            val step4  = Color(0xFF4b143d)
            val step5  = Color(0xFF591c47)
            val step6  = Color(0xFF692955)
            val step7  = Color(0xFF833869)
            val step8  = Color(0xFFa84885)
            val step9  = Color(0xFFd6409f)
            val step10 = Color(0xFFde51a8)
            val step11 = Color(0xFFff8dcc)
            val step12 = Color(0xFFfdd1ea)
        }
    }

    object Plum {
        object Light {
            val step1  = Color(0xFFfefcff)
            val step2  = Color(0xFFfdf7ff)
            val step3  = Color(0xFFfbebff)
            val step4  = Color(0xFFf7deff)
            val step5  = Color(0xFFf2d1ff)
            val step6  = Color(0xFFe9c2f9)
            val step7  = Color(0xFFdeaef4)
            val step8  = Color(0xFFcf91e8)
            val step9  = Color(0xFFab4aba)
            val step10 = Color(0xFFa144af)
            val step11 = Color(0xFF953ea3)
            val step12 = Color(0xFF53195d)
        }
        object Dark {
            val step1  = Color(0xFF181118)
            val step2  = Color(0xFF201320)
            val step3  = Color(0xFF351a35)
            val step4  = Color(0xFF451d47)
            val step5  = Color(0xFF532557)
            val step6  = Color(0xFF633263)
            val step7  = Color(0xFF7c4082)
            val step8  = Color(0xFF9f55a6)
            val step9  = Color(0xFFab4aba)
            val step10 = Color(0xFFb658c4)
            val step11 = Color(0xFFe796f3)
            val step12 = Color(0xFFf4d4f4)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // PURPLE / VIOLET FAMILY
    // ─────────────────────────────────────────────────────────────

    object Purple {
        object Light {
            val step1  = Color(0xFFfefcfe)
            val step2  = Color(0xFFfbf7fe)
            val step3  = Color(0xFFf7edfe)
            val step4  = Color(0xFFf2e2fc)
            val step5  = Color(0xFFead5f9)
            val step6  = Color(0xFFe0c4f4)
            val step7  = Color(0xFFd1afec)
            val step8  = Color(0xFFbe93e4)
            val step9  = Color(0xFF8e4ec6)
            val step10 = Color(0xFF8347b9)
            val step11 = Color(0xFF7938b2)
            val step12 = Color(0xFF402060)
        }
        object Dark {
            val step1  = Color(0xFF18111b)
            val step2  = Color(0xFF1e1523)
            val step3  = Color(0xFF301c3b)
            val step4  = Color(0xFF3d224e)
            val step5  = Color(0xFF48295c)
            val step6  = Color(0xFF54346b)
            val step7  = Color(0xFF664282)
            val step8  = Color(0xFF8457aa)
            val step9  = Color(0xFF8e4ec6)
            val step10 = Color(0xFF9a5cd0)
            val step11 = Color(0xFFd19dff)
            val step12 = Color(0xFFecd9fa)
        }
    }

    object Violet {
        object Light {
            val step1  = Color(0xFFfdfcfe)
            val step2  = Color(0xFFfaf8ff)
            val step3  = Color(0xFFf4f0fe)
            val step4  = Color(0xFFede9fe)
            val step5  = Color(0xFFe4defc)
            val step6  = Color(0xFFd7cff9)
            val step7  = Color(0xFFc4b8f3)
            val step8  = Color(0xFFaa99ec)
            val step9  = Color(0xFF6e56cf)
            val step10 = Color(0xFF654dc4)
            val step11 = Color(0xFF6550b9)
            val step12 = Color(0xFF2f265f)
        }
        object Dark {
            val step1  = Color(0xFF14121f)
            val step2  = Color(0xFF1b1525)
            val step3  = Color(0xFF291f43)
            val step4  = Color(0xFF33255a)
            val step5  = Color(0xFF3c2e69)
            val step6  = Color(0xFF473876)
            val step7  = Color(0xFF56468b)
            val step8  = Color(0xFF6958ad)
            val step9  = Color(0xFF6e56cf)
            val step10 = Color(0xFF7d66d9)
            val step11 = Color(0xFFbaa7ff)
            val step12 = Color(0xFFe2dffe)
        }
    }

    object Iris {
        object Light {
            val step1  = Color(0xFFfdfcff)
            val step2  = Color(0xFFf8f8ff)
            val step3  = Color(0xFFf0f1fe)
            val step4  = Color(0xFFe6e7fd)
            val step5  = Color(0xFFdadcfb)
            val step6  = Color(0xFFcbcef8)
            val step7  = Color(0xFFb8bdf4)
            val step8  = Color(0xFF9da3ee)
            val step9  = Color(0xFF5b5bd6)
            val step10 = Color(0xFF5151cd)
            val step11 = Color(0xFF5753c6)
            val step12 = Color(0xFF272962)
        }
        object Dark {
            val step1  = Color(0xFF13131e)
            val step2  = Color(0xFF171625)
            val step3  = Color(0xFF202248)
            val step4  = Color(0xFF262a65)
            val step5  = Color(0xFF303374)
            val step6  = Color(0xFF3d3e82)
            val step7  = Color(0xFF4a4d96)
            val step8  = Color(0xFF5b60b5)
            val step9  = Color(0xFF5b5bd6)
            val step10 = Color(0xFF6e6ade)
            val step11 = Color(0xFFb1aeff)
            val step12 = Color(0xFFe0dffe)
        }
    }

    object Indigo {
        object Light {
            val step1  = Color(0xFFfdfdfe)
            val step2  = Color(0xFFf7f9ff)
            val step3  = Color(0xFFedf2fe)
            val step4  = Color(0xFFe1eafd)
            val step5  = Color(0xFFd2dffb)
            val step6  = Color(0xFFc1d0f9)
            val step7  = Color(0xFFabbdf5)
            val step8  = Color(0xFF8da4ef)
            val step9  = Color(0xFF3e63dd)
            val step10 = Color(0xFF3a5ccc)
            val step11 = Color(0xFF3451b2)
            val step12 = Color(0xFF1f306e)
        }
        object Dark {
            val step1  = Color(0xFF11131f)
            val step2  = Color(0xFF141726)
            val step3  = Color(0xFF182449)
            val step4  = Color(0xFF1d2e62)
            val step5  = Color(0xFF253974)
            val step6  = Color(0xFF304384)
            val step7  = Color(0xFF3a549a)
            val step8  = Color(0xFF4164c2)
            val step9  = Color(0xFF3e63dd)
            val step10 = Color(0xFF5472e4)
            val step11 = Color(0xFF9eb1ff)
            val step12 = Color(0xFFd6e1ff)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // BLUE FAMILY
    // ─────────────────────────────────────────────────────────────

    object Blue {
        object Light {
            val step1  = Color(0xFFfbfdff)
            val step2  = Color(0xFFf4faff)
            val step3  = Color(0xFFe6f4fe)
            val step4  = Color(0xFFd5efff)
            val step5  = Color(0xFFc2e5ff)
            val step6  = Color(0xFFacd8fc)
            val step7  = Color(0xFF8ec8f6)
            val step8  = Color(0xFF5eb1ef)
            val step9  = Color(0xFF0090ff)
            val step10 = Color(0xFF0588f0)
            val step11 = Color(0xFF0d74ce)
            val step12 = Color(0xFF113264)
        }
        object Dark {
            val step1  = Color(0xFF0d1520)
            val step2  = Color(0xFF111927)
            val step3  = Color(0xFF0d2847)
            val step4  = Color(0xFF003362)
            val step5  = Color(0xFF004074)
            val step6  = Color(0xFF104d87)
            val step7  = Color(0xFF205d9e)
            val step8  = Color(0xFF2870bd)
            val step9  = Color(0xFF0090ff)
            val step10 = Color(0xFF3b9eff)
            val step11 = Color(0xFF70b8ff)
            val step12 = Color(0xFFc2e6ff)
        }
    }

    object Cyan {
        object Light {
            val step1  = Color(0xFFfafdfe)
            val step2  = Color(0xFFf2fafb)
            val step3  = Color(0xFFdef7f9)
            val step4  = Color(0xFFcaf1f6)
            val step5  = Color(0xFFb5e9f0)
            val step6  = Color(0xFF9ddde7)
            val step7  = Color(0xFF7dcfdb)
            val step8  = Color(0xFF3db9cf)
            val step9  = Color(0xFF00a2c7)
            val step10 = Color(0xFF0797b9)
            val step11 = Color(0xFF107d98)
            val step12 = Color(0xFF0d3c48)
        }
        object Dark {
            val step1  = Color(0xFF0b161a)
            val step2  = Color(0xFF101b20)
            val step3  = Color(0xFF082c36)
            val step4  = Color(0xFF003848)
            val step5  = Color(0xFF004558)
            val step6  = Color(0xFF045468)
            val step7  = Color(0xFF12677e)
            val step8  = Color(0xFF11809c)
            val step9  = Color(0xFF00a2c7)
            val step10 = Color(0xFF23afd0)
            val step11 = Color(0xFF4ccce6)
            val step12 = Color(0xFFb6ecf7)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // TEAL / GREEN FAMILY
    // ─────────────────────────────────────────────────────────────

    object Teal {
        object Light {
            val step1  = Color(0xFFfafefd)
            val step2  = Color(0xFFf3fbf9)
            val step3  = Color(0xFFe0f8f3)
            val step4  = Color(0xFFccf3ea)
            val step5  = Color(0xFFb8eae0)
            val step6  = Color(0xFFa1ddd4)
            val step7  = Color(0xFF83cdc5)
            val step8  = Color(0xFF53b9b0)
            val step9  = Color(0xFF12a594)
            val step10 = Color(0xFF0d9b8a)
            val step11 = Color(0xFF008573)
            val step12 = Color(0xFF0d3d38)
        }
        object Dark {
            val step1  = Color(0xFF0d1514)
            val step2  = Color(0xFF111c1b)
            val step3  = Color(0xFF0d2d2a)
            val step4  = Color(0xFF023b37)
            val step5  = Color(0xFF084843)
            val step6  = Color(0xFF145750)
            val step7  = Color(0xFF1c6961)
            val step8  = Color(0xFF207e73)
            val step9  = Color(0xFF12a594)
            val step10 = Color(0xFF0eb39e)
            val step11 = Color(0xFF0bd8b6)
            val step12 = Color(0xFFadf0dd)
        }
    }

    object Jade {
        object Light {
            val step1  = Color(0xFFfbfefd)
            val step2  = Color(0xFFf4fbf7)
            val step3  = Color(0xFFe6f7ed)
            val step4  = Color(0xFFd6f1e3)
            val step5  = Color(0xFFc3e9d7)
            val step6  = Color(0xFFacdec8)
            val step7  = Color(0xFF8bceb5)
            val step8  = Color(0xFF56ba9f)
            val step9  = Color(0xFF29a383)
            val step10 = Color(0xFF26997b)
            val step11 = Color(0xFF208368)
            val step12 = Color(0xFF1d3b31)
        }
        object Dark {
            val step1  = Color(0xFF0d1512)
            val step2  = Color(0xFF121c18)
            val step3  = Color(0xFF0f2e22)
            val step4  = Color(0xFF0b3b2c)
            val step5  = Color(0xFF114837)
            val step6  = Color(0xFF1b5745)
            val step7  = Color(0xFF246854)
            val step8  = Color(0xFF2a7e67)
            val step9  = Color(0xFF29a383)
            val step10 = Color(0xFF27b08b)
            val step11 = Color(0xFF1fd8a4)
            val step12 = Color(0xFFadf0d4)
        }
    }

    object Green {
        object Light {
            val step1  = Color(0xFFfbfefb)
            val step2  = Color(0xFFf3fcf3)
            val step3  = Color(0xFFe5f9e7)
            val step4  = Color(0xFFd6f1da)
            val step5  = Color(0xFFc4e8ca)
            val step6  = Color(0xFFadddb9)
            val step7  = Color(0xFF8ecea3)
            val step8  = Color(0xFF5bb98c)
            val step9  = Color(0xFF30a46c)
            val step10 = Color(0xFF2b9a66)
            val step11 = Color(0xFF218358)
            val step12 = Color(0xFF193b2d)
        }
        object Dark {
            val step1  = Color(0xFF0e1512)
            val step2  = Color(0xFF121b17)
            val step3  = Color(0xFF132d21)
            val step4  = Color(0xFF113b29)
            val step5  = Color(0xFF174933)
            val step6  = Color(0xFF20573e)
            val step7  = Color(0xFF28684a)
            val step8  = Color(0xFF2f7c57)
            val step9  = Color(0xFF30a46c)
            val step10 = Color(0xFF33b074)
            val step11 = Color(0xFF3dd68c)
            val step12 = Color(0xFFb1f1cb)
        }
    }

    object Grass {
        object Light {
            val step1  = Color(0xFFfbfefb)
            val step2  = Color(0xFFf5fbf5)
            val step3  = Color(0xFFe9f6e9)
            val step4  = Color(0xFFdaf1db)
            val step5  = Color(0xFFc9e8ca)
            val step6  = Color(0xFFb2ddb5)
            val step7  = Color(0xFF94ce9a)
            val step8  = Color(0xFF65ba74)
            val step9  = Color(0xFF46a758)
            val step10 = Color(0xFF3d9e4e)
            val step11 = Color(0xFF297c3b)
            val step12 = Color(0xFF1b311e)
        }
        object Dark {
            val step1  = Color(0xFF0d1407)
            val step2  = Color(0xFF11190b)
            val step3  = Color(0xFF132b0e)
            val step4  = Color(0xFF1d3a14)
            val step5  = Color(0xFF25461b)
            val step6  = Color(0xFF2d5423)
            val step7  = Color(0xFF36642b)
            val step8  = Color(0xFF3d7834)
            val step9  = Color(0xFF46a758)
            val step10 = Color(0xFF53b365)
            val step11 = Color(0xFF71d083)
            val step12 = Color(0xFFc2f0c2)
        }
    }

    // ─────────────────────────────────────────────────────────────
    // LIME / MINT / SKY
    // ─────────────────────────────────────────────────────────────

    object Lime {
        object Light {
            val step1  = Color(0xFFfcfdfa)
            val step2  = Color(0xFFf8faf3)
            val step3  = Color(0xFFeff5e0)
            val step4  = Color(0xFFe5efcd)
            val step5  = Color(0xFFdae8bb)
            val step6  = Color(0xFFcde0a4)
            val step7  = Color(0xFFb8d383)
            val step8  = Color(0xFF9dc06b)
            val step9  = Color(0xFFbde56c)
            val step10 = Color(0xFFb3d94f)
            val step11 = Color(0xFF5c7c10)
            val step12 = Color(0xFF2c3a10)
        }
        object Dark {
            val step1  = Color(0xFF11130c)
            val step2  = Color(0xFF151a10)
            val step3  = Color(0xFF1f2917)
            val step4  = Color(0xFF29371d)
            val step5  = Color(0xFF334423)
            val step6  = Color(0xFF3d522a)
            val step7  = Color(0xFF496231)
            val step8  = Color(0xFF577538)
            val step9  = Color(0xFFbde56c)
            val step10 = Color(0xFFd4f070)
            val step11 = Color(0xFFbde56c)
            val step12 = Color(0xFFe3f7ba)
        }
    }

    object Mint {
        object Light {
            val step1  = Color(0xFFf9fefd)
            val step2  = Color(0xFFf2fbf9)
            val step3  = Color(0xFFddf9f1)
            val step4  = Color(0xFFc8f4e9)
            val step5  = Color(0xFFb3ecde)
            val step6  = Color(0xFF9ae3d1)
            val step7  = Color(0xFF7dd5bf)
            val step8  = Color(0xFF4cc4a9)
            val step9  = Color(0xFF86ead4)
            val step10 = Color(0xFF7de0cb)
            val step11 = Color(0xFF027864)
            val step12 = Color(0xFF16302b)
        }
        object Dark {
            val step1  = Color(0xFF0e1515)
            val step2  = Color(0xFF0f1b1b)
            val step3  = Color(0xFF092c2b)
            val step4  = Color(0xFF003a38)
            val step5  = Color(0xFF004744)
            val step6  = Color(0xFF105552)
            val step7  = Color(0xFF1e6462)
            val step8  = Color(0xFF277f7a)
            val step9  = Color(0xFF86ead4)
            val step10 = Color(0xFFa8f5e5)
            val step11 = Color(0xFF58d5ba)
            val step12 = Color(0xFFc4f5e1)
        }
    }

    object Sky {
        object Light {
            val step1  = Color(0xFFf9feff)
            val step2  = Color(0xFFf1fafd)
            val step3  = Color(0xFFe1f6fd)
            val step4  = Color(0xFFd1f0fa)
            val step5  = Color(0xFFbee7f5)
            val step6  = Color(0xFFa9daed)
            val step7  = Color(0xFF8dcae3)
            val step8  = Color(0xFF60b3d7)
            val step9  = Color(0xFF7ce2fe)
            val step10 = Color(0xFF74daf8)
            val step11 = Color(0xFF00749e)
            val step12 = Color(0xFF1d3e56)
        }
        object Dark {
            val step1  = Color(0xFF0d1520)
            val step2  = Color(0xFF111b27)
            val step3  = Color(0xFF112840)
            val step4  = Color(0xFF113555)
            val step5  = Color(0xFF154467)
            val step6  = Color(0xFF1b537b)
            val step7  = Color(0xFF1f6692)
            val step8  = Color(0xFF197cae)
            val step9  = Color(0xFF7ce2fe)
            val step10 = Color(0xFFa8eeff)
            val step11 = Color(0xFF75c7f0)
            val step12 = Color(0xFFc2f3ff)
        }
    }
}