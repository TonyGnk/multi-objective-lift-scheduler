plugins {
    alias(libs.plugins.cls.jvm.library)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.kotlinx.datetime)
}
