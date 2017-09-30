# FundamentalsOfMobileProgramming

## Lesson1 

Java Fundamentals , OOP (Object oriented programming) and threads.

### 1. Crea un emulador

https://developer.android.com/studio/run/emulator.html

### 2. Crea un nuevo proyecto Android con Android Studio

https://codelabs.developers.google.com/codelabs/build-your-first-android-app/index.html?index=..%2F..%2Findex#0

### 3. Explora el entorno de trabajo (Android Studio)

https://developer.android.com/studio/intro/index.html

### 4. Revisa el proyecto base (BxTemplate)

Archivos de configuración gradle

build.gradle del proyecto
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 15
    targetSdkVersion = 25
    compileSdkVersion = 25
    buildToolsVersion = '25.0.2'
    constraintLayoutVersion='1.0.2'

    // App dependencies
    supportLibraryVersion = '25.3.1'
    junitVersion = '4.12'
}
```

build.gradle de la app
```
apply plugin: 'com.android.application'

android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion
    defaultConfig {
        applicationId "com.belatrix.fundamentals"
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })

    // App's dependencies
    compile "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support:support-v4:$rootProject.supportLibraryVersion"

    compile "com.android.support:cardview-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support:design:$rootProject.supportLibraryVersion"
    compile "com.android.support:recyclerview-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"

    // Dependencies for local unit tests
    testCompile "junit:junit:$rootProject.ext.junitVersion"
}
```

### 5. Recursos Android 

- Compilador Java online https://www.compilejava.net/

- Kotlin http://kotlinlang.org/docs/reference/

- Java 8 Features https://developer.android.com/guide/platform/j8-jack.html

- Emulador genymotions https://www.genymotion.com/

- Google github https://github.com/googlesamples/?query=android

- Canal oficial en Youtube de Android Developers https://www.youtube.com/user/androiddevelopers


### Referencias

- Página Oficial de Android https://developer.android.com/index.html

- Android Studio https://developer.android.com/studio/index.html
