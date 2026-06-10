package com.dev.kore.shared

import com.dev.kore.shared.Platform
import platform.UIKit.UIDevice

class IOSPlatform: Platform {

    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}



