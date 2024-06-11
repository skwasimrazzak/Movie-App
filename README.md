# Movie App

This repository contains an Android Movie App built using Java, following the MVVM (Model-View-ViewModel) architecture. The app uses Retrofit to make network requests to The Movie Database (TMDB) REST API to fetch popular movies and display them in a RecyclerView.

## Features

- Fetches and displays popular movies from TMDB API.
- MVVM architecture for a clean separation of concerns.
- Retrofit for network requests.
- LiveData for observable data.
- RecyclerView for displaying movie list.

## Project Structure

The project is organized into the following folders:

- **model**
  - `Movie.java`: Defines the schema of the movie data, extends `BaseObservable` for data binding, and includes methods for loading movie poster images.
  - `MovieRepository.java`: Abstracts data source details and provides a central source of movie data using Retrofit.
  - `Results.java`: Defines the schema for API results, similar to the movie schema.
- **serviceapi**
  - `MovieApiService.java`: Defines the API endpoints using Retrofit annotations.
  - `RetrofitInstance.java`: Sets up Retrofit and provides an instance for accessing the API.
- **view**
  - `MovieAdapter.java`: Manages the RecyclerView, binds data to views, and defines the ViewHolder.
- **viewmodel**
  - `MainActivityViewModel.java`: Extends `AndroidViewModel`, uses `MovieRepository` to fetch movie data, and provides LiveData for the view.
- **MainActivity.java**: The main activity that sets up the ViewModel, RecyclerView, and handles UI interactions.

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/skwasimrazzak/movie-app.git
   cd movie-app
   ```

2. **Open the project in Android Studio**:
   Open Android Studio, select "Open an existing project," and navigate to the cloned directory.

3. **Add TMDB API key**:
    - Obtain an API key from [The Movie Database](https://www.themoviedb.org/documentation/api).
    - Add your API key in `RetrofitInstance.java` or pass it dynamically when making API calls.

4. **Build and Run**:
   Build the project and run it on an Android device or emulator.

## Detailed Class Descriptions

### Model

#### Movie.java

- **Purpose**: Defines the schema for movie data.
- **Fields**:
    - `@SerializedName("id") private int id;`
    - `@SerializedName("original_title") private String originalTitle;`
    - `@SerializedName("overview") private String overview;`
    - `@SerializedName("poster_path") private String posterPath;`
    - `@SerializedName("release_date") private String releaseDate;`
    - `@SerializedName("title") private String title;`
    - `@SerializedName("vote_average") private double voteAverage;`
- **Methods**:
    - Getters and setters for each field.
    - `loadImage(String posterPath)`: Retrieves the poster image.

#### MovieRepository.java

- **Purpose**: Centralizes data source management.
- **Methods**:
    - `getMutableLiveData()`: Retrieves movie data from the API using Retrofit.
    - Handles API call situations and manages request queue.

#### Results.java

- **Purpose**: Defines the schema for API response results.
- **Fields**:
    - `@SerializedName("page") private int page;`
    - `@SerializedName("total_pages") private int totalPages;`
    - `@SerializedName("total_results") private int totalResults;`
    - `@SerializedName("results") private List<Movie> results;`

### Service API

#### MovieApiService.java

- **Purpose**: Defines API endpoints using Retrofit.
- **Endpoints**:
    - `@GET("movie/popular") Call<Results> getPopularMovie(@Query("api_key") String apiKey);`

#### RetrofitInstance.java

- **Purpose**: Sets up Retrofit.
- **Methods**:
    - `getRetrofitInstance()`: Returns a configured Retrofit instance.

### View

#### MovieAdapter.java

- **Purpose**: Binds movie data to RecyclerView.
- **Methods**:
    - `MovieAdapter(Context context, ArrayList<Movie> movieArrayList)`: Constructor.
    - `onCreateViewHolder(@NonNull ViewGroup parent, int viewType)`: Inflates item layout.
    - `onBindViewHolder(@NonNull MovieViewHolder holder, int position)`: Binds data to view.
    - `getItemCount()`: Returns item count.
- **Inner Class**:
    - `MovieViewHolder extends RecyclerView.ViewHolder`: Holds item view.

### ViewModel

#### MainActivityViewModel.java

- **Purpose**: Provides movie data to the view.
- **Fields**:
    - `MovieRepository movieRepository;`
- **Methods**:
    - `getAllMovies()`: Returns LiveData of movie list.

### MainActivity.java

- **Purpose**: Connects ViewModel and view components, handles UI interactions.
- **Methods**:
    - `onCreate(Bundle savedInstanceState)`: Initializes ViewModel and RecyclerView, sets up listeners, fetches and displays movies.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

---

Feel free to update this README with any additional information or instructions specific to your project.
