/*
 *    Copyright 2021 Plank
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

@file:Suppress("DSL_SCOPE_VIOLATION")

import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.detekt)
}

group = "org.plank"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

allprojects {
  apply(plugin = "org.jetbrains.kotlin.multiplatform")
  apply<DetektPlugin>()

  group = "org.plank.llvm4k"
  version = "1.0-SNAPSHOT"

  repositories {
    mavenCentral()
  }
}

configure<DetektExtension> {
  buildUponDefaultConfig = true
  allRules = false

  config = files("${rootProject.projectDir}/config/detekt.yml")
  baseline = file("${rootProject.projectDir}/config/baseline.xml")
}

configure<KotlinMultiplatformExtension> {
  explicitApi()

//  jvm {
//    withJava()
//    compilations.all {
//      kotlinOptions.jvmTarget = "17"
//    }
//    testRuns["test"].executionTask.configure {
//      useJUnitPlatform()
//    }
//  }
//
//  js(BOTH) {
//    nodejs()
//  }

  val hostOs = System.getProperty("os.name")
  val isMingwX64 = hostOs.startsWith("Windows")
  val nativeTarget = when {
    hostOs == "Mac OS X" -> macosX64("native")
    hostOs == "Linux" -> linuxX64("native")
    isMingwX64 -> mingwX64("native")
    else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
  }

  nativeTarget.apply {
    val main by compilations.getting
    val llvm by main.cinterops.creating

    binaries {
      executable {
        entryPoint = "org.plank.llvm4k.main"
      }
    }
  }

  sourceSets {
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
      }
    }
  }
}
