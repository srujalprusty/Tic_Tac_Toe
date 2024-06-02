

# Tic Tac Toe Game

This repository contains a simple yet engaging Tic Tac Toe game built using Kotlin, Jetpack Compose, and the MVVM (Model-View-ViewModel) architecture. The project demonstrates modern Android development practices and serves as a great example of using Jetpack Compose for creating a dynamic and responsive UI.

## Features

- **Single-Player and Two-Player Modes**: Play against a friend or challenge yourself against a basic AI.
- **Clean and Modern UI**: Utilizes Jetpack Compose for a smooth and interactive user experience.
- **MVVM Architecture**: Ensures a clean separation of concerns, making the codebase more maintainable and testable.
- **State Management**: Uses ViewModel and LiveData for managing UI-related data in a lifecycle-conscious way.
- **Animations**: Subtle animations to enhance the user experience.

## Screenshots


## Technologies Used

- **Kotlin**: The programming language used for Android development.
- **Jetpack Compose**: The modern toolkit for building native Android UIs.
- **MVVM Architecture**: Ensures separation of concerns and a scalable codebase.
- **LiveData**: For reactive state management and updating the UI based on changes in data.
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.

## Getting Started

### Prerequisites

- Android Studio Arctic Fox (2020.3.1) or later.
- Gradle 7.0 or later.
- An Android device or emulator running Android 5.0 (Lollipop) or later.

### Installation

1. Clone the repository:

```bash

```

2. Open the project in Android Studio.

3. Build and run the project on your Android device or emulator.

## How to Play

1. Launch the app.
2. Choose between Single-Player or Two-Player mode.
3. In Two-Player mode, Player 1 (X) and Player 2 (O) take turns to place their marks on the 3x3 grid.
4. In Single-Player mode, play against a basic AI.
5. The first player to align three marks horizontally, vertically, or diagonally wins the game.

## Architecture Overview

- **Model**: Contains the data classes and business logic of the game.
- **View**: Composed of Jetpack Compose UI elements that render the game state.
- **ViewModel**: Acts as a bridge between the Model and View, managing the game state and handling user inputs.

## Contributing

Contributions are welcome! If you find a bug or have an idea for an enhancement, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to personalize this description with additional details, such as specific design choices or challenges you faced during development.
