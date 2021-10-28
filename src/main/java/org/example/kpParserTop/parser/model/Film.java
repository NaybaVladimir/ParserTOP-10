package org.example.kpParserTop.parser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String position;
    private String originalName;
    private String year;
    private String rating;
    private String numberOfPeopleWhoVoted;
    private Date date;

    public Film() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumberOfPeopleWhoVoted() {
        return numberOfPeopleWhoVoted;
    }

    public void setNumberOfPeopleWhoVoted(String numberOfPeopleWhoVoted) {
        this.numberOfPeopleWhoVoted = numberOfPeopleWhoVoted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film{" +
                "Id=" + Id +
                ", rating='" + rating + '\'' +
                ", originalName='" + originalName + '\'' +
                ", year='" + year + '\'' +
                ", numberOfPeopleWhoVoted='" + numberOfPeopleWhoVoted + '\'' +
                ", date=" + date +
                '}';
    }


}
