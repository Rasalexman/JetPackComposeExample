package config

object Libs {
    object Core {
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    }

    object Common {
        //--- GSOn
        const val gson = "com.google.code.gson:gson:${Versions.gson}"

        //--- LEAK DETECTOR
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"

        //----- DI
        const val kodigen = "com.github.Rasalexman.KODI:kodigen:${Versions.kodi}"

        const val kotpref = "com.chibatching.kotpref:kotpref:${Versions.kotPref}"
        const val kotprefSupport = "com.chibatching.kotpref:livedata-support:${Versions.kotPref}"

        const val sresult = "com.github.Rasalexman.SResult:sresult:${Versions.sresult}"
        const val sresultpresentation = "com.github.Rasalexman.SResult:sresultpresentation:${Versions.sresult}"
    }

    object Tests {
        const val junit = "junit:junit:${Versions.junit}"
        const val runner = "com.android.support.test:runner:${Versions.runner}"
        const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    }

}