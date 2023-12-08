// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.8.2.1")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id ("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.android.library") version "8.1.4" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.20" apply false
}