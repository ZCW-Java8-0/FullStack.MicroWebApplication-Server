package com.nyce.tube.domain.enumeration;

/**
 * The Categories enumeration.
 */
public enum Categories {
    ARTSCRAFTS("ArtsCrafts"),
    FASHIONBEAUTY("FashionBeauty"),
    FOOD("Food"),
    GAMING("Gaming"),
    KIDS("Kids"),
    LEARNING("Learning"),
    MOVIESTV("MoviesShows"),
    MUSIC("Music"),
    NEWS("News"),
    PEOPLEBLOGS("PeopleBlogs"),
    PETSANIMALS("PetsAnimals"),
    SCITECH("ScienceTechnology"),
    SPORTS("Sports"),
    TRAVEL("Travel");

    private final String value;

    Categories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
