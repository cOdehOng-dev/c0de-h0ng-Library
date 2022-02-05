# c0de-h0ng-Library

## Description
```
유용한 Base, Util 클래스 또는 CustomView를 편하게 사용하기 위해 만든 모듈 라이브러리
```

## How to use
- Step 1.Add the JitPack repository to your build file

Arctic Fox less than version (project level build.gradle)
```kotlin
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
Arctic Fox more than version (settings.gradle)
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

- Step 2. Add the dependency
```kotlin
dependencies {
   implementation 'com.github.cOdehOng-dev:c0de-h0ng-library:$version' //current version: 0.0.1
}
```

## Function
+ PrettyLogging
  + HttpLoggingInterceptor.Logger을 Custom하여 Log에 pretty하게 출력되게 하는 기능

## CustomView
- Comming Soon
