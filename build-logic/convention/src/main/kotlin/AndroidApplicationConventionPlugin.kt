import com.abdulkarim.jetpackcomposeplayground.configureGradleManagedDevices
import com.abdulkarim.jetpackcomposeplayground.configureKotlinAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                targetSdk()
                configureGradleManagedDevices(this)
            }

        }
    }
}

fun ApplicationExtension.targetSdk(){
    defaultConfig.targetSdk = 33
}