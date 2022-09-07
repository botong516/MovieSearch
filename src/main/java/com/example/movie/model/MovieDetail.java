package com.example.movie.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieDetail {
    private String id;
    private String title;
    private String originalTitle;
    private String fullTitle;
    private String type;
    private String year;
    private String image;
    private Date releaseDate;
    private String runtimeMins;
    private String runtimeStr;
    private String plot;
    private String plotLocal;
    private boolean plotLocalIsRtl;
    private String awards;
    private String directors;
    private List<DirectorList> directorList;
    private String writers;
    private List<WriterList> writerList;
    private String stars;
    private List<StarList> starList;
    private List<ActorList> actorList;
    private String fullCast;
    private String genres;
    private List<GenreList> genreList;
    private String companies;
    private List<CompanyList> companyList;
    private String countries;
    private List<CountryList> countryList;
    private String languages;
    private List<LanguageList> languageList;
    private String contentRating;
    private String imDbRating;
    private String imDbRatingVotes;
    private String metacriticRating;
    private String ratings;
    private String wikipedia;
    private String posters;
    private String images;
    private String trailer;
    private BoxOffice boxOffice;
    private String tagline;
    private String keywords;
    private List<String> keywordList;
    private List<Similars> similars;
    private String tvSeriesInfo;
    private String tvEpisodeInfo;
    private String errorMessage;
}
@Data
class DirectorList {
    private String id;
    private String name;
}

@Data
class WriterList {
    private String id;
    private String name;

}
@Data
class StarList {
    private String id;
    private String name;
}

@Data
class ActorList {
    private String id;
    private String image;
    private String name;
    private String asCharacter;

}
@Data
class GenreList {
    private String key;
    private String value;

}
@Data
class CompanyList {
    private String id;
    private String name;
}
@Data
class CountryList {
    private String key;
    private String value;
}

@Data
class LanguageList {
    private String key;
    private String value;
}
@Data
class Similars {
    private String id;
    private String title;
    private String image;
    private String imDbRating;

}
@Data
class BoxOffice {
    private String budget;
    private String openingWeekendUSA;
    private String grossUSA;
    private String cumulativeWorldwideGross;

}