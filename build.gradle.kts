plugins {
    alias(libs.plugins.clp.jvm.library)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.guava)
}
