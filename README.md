# Coding Exercise
This project is a simple Jetpack Compose application that fetches and displays a list of items from an API. The items are grouped by `listId`, and within each group, they are sorted by `name`, and displayed with a clean UI.

## Prerequisites
- Android Studio Bumblebee or later.
- Minimum SDK version 21.
- Internet connection to fetch data from the API.

## Getting Started

### 1. Clone the Repository

```
git clone https://github.com/pranjalpc99/Coding-Exercise.git
cd Coding-Exercise
```

### 2. Update Dependencies
Open build.gradle.kts and add the following dependencies:
I am using the latest Version Catalogs for dependency versioning

```
dependencies {
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}
```

### 3. Update libs.version.toml
Ensure your libs.version.toml file has the correct versions:

```
[versions]
converterGson = "2.9.0"
lifecycleViewmodelCompose = "2.8.2"
retrofit = "2.9.0"

[libraries]
androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name ="lifecycle-viewmodel-compose", version.ref = "lifecycleViewmodelCompose" }
converter-gson = { group = "com.squareup.retrofit2", name = "converter-gson", version.ref = "converterGson" }
retrofit = {group = "com.squareup.retrofit2", name = "retrofit", version.ref = "retrofit"}
```

### 4. Add Internet Permission
Open AndroidManifest.xml and add the internet permission:

```
<uses-permission android:name="android.permission.INTERNET"/>
```

### 5. Build and Run the App
- Open the project in Android Studio.
- Sync the project with Gradle files.
- Connect your Android device or start an emulator.
- Click on the "Run" button or use the Shift + F10 shortcut to build and run the app.

## Project Structure
- MainActivity.kt: The main activity that sets up the Compose content.
- ItemViewModel.kt: The ViewModel that manages fetching and storing data.
- ApiService.kt and RetrofitInstance.kt: Retrofit setup for API calls.
- ItemListScreen.kt: Composable functions for displaying the list of items.
- Item.kt: Data class representing the item.
- ListItem.kt: Composable function for displaying individual items.

## License
This project is licensed under the MIT License.
