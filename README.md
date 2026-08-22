# Culture UI

Culture UI is a product-neutral Compose Multiplatform design-system library. It provides raw, reusable tokens, theme contracts, and components that applications can adopt and override without introducing product-specific decisions into the library.

## Modules

```text
:core:systemdesign  Shared tokens, themes, and components
:catalog            Shared component catalog and platform entry points
:androidApp         Android catalog launcher
iosApp/             Xcode catalog application
```

The shared modules currently target Android, iOS device and simulator, desktop/JVM, and Wasm.

## Toolchain

- Java 26
- Gradle 9.7.1
- Kotlin 2.4.10
- Compose Multiplatform 1.11.1
- Android Gradle Plugin 9.1.1
- Android compile SDK 36, minimum SDK 24
- Xcode with an installed iOS simulator runtime

The Gradle wrapper is committed, so a separate Gradle installation is unnecessary.

## Architecture

### Tokens

The `tokens` package contains primitive and semantic values:

- colors and `CultureColorScheme`
- typography
- spacing
- sizes
- shapes
- elevation

Components consume semantic roles such as `primary`, `surface`, and `error`; they do not reference application or product colors.

### Theme

`CultureTheme` supplies tokens through Compose composition locals. Its neutral defaults can be used directly or overridden by a consuming application:

```kotlin
CultureTheme(
    colors = CultureLightColors.copy(
        primary = ProductPrimary,
        onPrimary = ProductOnPrimary,
    ),
) {
    ProductApp()
}
```

### Components

Components are built from Compose UI and Foundation primitives without Material or Material 3 styling. Material Icons Core is used only as a vector source.

Current components include:

- `CultureText`
- `CultureIcon`
- `CultureButton`
- `CultureCard`
- `CultureTextField`

## Desktop catalog

Run the desktop catalog from the repository root:

```shell
./gradlew :catalog:run
```

## Android catalog

Start an Android emulator or connect a device, then run:

```shell
./gradlew :androidApp:installDebug
```

Android Studio can also run the `androidApp` configuration directly.

To launch the installed application manually:

```shell
adb shell am start \
  -n culture.catalog.android/culture.catalog.CatalogActivity
```

The generated APK is located at:

```text
androidApp/build/outputs/apk/debug/androidApp-debug.apk
```

The launcher lives in `:androidApp`. `CatalogActivity` lives in `catalog/src/androidMain` and renders the shared catalog.

### Android troubleshooting

#### `androidx.startup.InitializationProvider` is missing

If the application crashes before opening with:

```text
ClassNotFoundException: androidx.startup.InitializationProvider
```

the APK may contain merged AndroidX resources and manifest entries while reusing an incomplete external DEX cache. Force every Android packaging task to run again without the build cache:

```shell
./gradlew :androidApp:assembleDebug \
  --rerun-tasks \
  --no-build-cache \
  --no-daemon
```

Remove the previous installation and install the newly generated APK:

```shell
adb uninstall culture.catalog.android
adb install androidApp/build/outputs/apk/debug/androidApp-debug.apk
```

#### A class is defined multiple times

If generated output contains a duplicate such as `CatalogKt 2.class`, clean all participating modules before rebuilding:

```shell
./gradlew \
  :androidApp:clean \
  :catalog:clean \
  :core:systemdesign:clean \
  :androidApp:assembleDebug
```

There should be only one source file for the class. Files inside `build/` are generated and must not be committed or synchronized.

## iOS catalog

The runnable Xcode application is committed at:

```text
iosApp/CultureCatalog/CultureCatalog.xcodeproj
```

Open it in Xcode:

```shell
open iosApp/CultureCatalog/CultureCatalog.xcodeproj
```

Then:

1. Select the `CultureCatalog` scheme.
2. Select an iPhone simulator.
3. Press `Cmd+R`.

The Xcode target contains a Run Script build phase that invokes:

```shell
./gradlew :catalog:embedAndSignAppleFrameworkForXcode
```

This builds the correct device or simulator framework, embeds it in the application, and signs it when required. No manual Gradle command is needed before a normal Xcode run.

The Kotlin framework module is named `CultureCatalogKit` to avoid colliding with the Swift application module. The SwiftUI wrapper imports it and presents:

```swift
CatalogViewControllerKt.CatalogViewController()
```

The app's `Info.plist` enables `CADisableMinimumFrameDurationOnPhone`, which Compose requires for iOS rendering.

### Manual iOS framework builds

Build a debug framework for an Apple Silicon simulator:

```shell
./gradlew :catalog:linkDebugFrameworkIosSimulatorArm64
```

Build for a physical iOS device:

```shell
./gradlew :catalog:linkDebugFrameworkIosArm64
```

The simulator framework is generated at:

```text
catalog/build/bin/iosSimulatorArm64/debugFramework/CultureCatalogKit.framework
```

### iOS troubleshooting

If Xcode cannot import `CultureCatalogKit` or appears to use an older Kotlin framework:

1. Select **Product → Clean Build Folder** in Xcode.
2. Run `./gradlew clean` from the repository root.
3. Build again with `Cmd+R`.

Verify that the target has:

```text
User Script Sandboxing = No
```

and this framework search path for both Debug and Release:

```text
$(SRCROOT)/../../catalog/build/xcode-frameworks/$(CONFIGURATION)/$(SDK_NAME)
```

## Validation

Compile the shared catalog for all currently runnable development targets:

```shell
./gradlew \
  :catalog:compileKotlinDesktop \
  :catalog:compileAndroidMain \
  :catalog:compileKotlinIosSimulatorArm64
```

## Design principles

1. Keep the library product-neutral.
2. Components consume semantic tokens rather than raw product values.
3. Applications override the theme contract instead of forking components.
4. Interactive controls meet a minimum 48 dp touch target.
5. Platform-specific code remains limited to behavior that cannot live in `commonMain`.
