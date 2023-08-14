import com.abdulkarim.jetpackcomposeplayground.configureKotlinAndroid
import com.abdulkarim.jetpackcomposeplayground.libs
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project){
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension>{
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
            }

            configurations.configureEach {
                resolutionStrategy {
                    force(libs.findLibrary("junit4").get())
                    force("org.objenesis:objenesis:2.6")
                }
            }

            dependencies {
                add("implementation",libs.findLibrary("androidx.core.ktx").get())
                add("implementation",libs.findLibrary("androidx-lifecycle-runtime").get())
                add("implementation",libs.findLibrary("androidx-compose-activity").get())
                add("implementation",libs.findLibrary("androidx-compose-ui").get())
                add("implementation",libs.findLibrary("androidx-compose-ui-graphics").get())
                add("implementation",libs.findLibrary("androidx-compose-ui-tooling-preview").get())
                add("implementation",libs.findLibrary("androidx-compose-material3").get())

                add("testImplementation",libs.findLibrary("junit4").get())
                add("androidTestImplementation",libs.findLibrary("androidx-junit").get())
                add("androidTestImplementation",libs.findLibrary("androidx-espresso-core").get())
                add("androidTestImplementation",libs.findLibrary("androidx-compose-ui-test-junit4").get())
                add("debugImplementation",libs.findLibrary("androidx-compose-ui-tooling").get())
                add("debugImplementation",libs.findLibrary("androidx-compose-ui-test-manifest").get())

            }

        }
    }
}