package Sale;

import java.time.LocalDate;
import java.util.ArrayList;

public class Campaign
{
    private final Long id;
    private String name;
    private String description;
    private double discount;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Game> gamesIncluded;

    public Campaign(Long id, String name, String description, double discount, LocalDate startDate, LocalDate endDate, ArrayList<Game> games)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.gamesIncluded = games;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Game> getGamesIncluded() {
        return gamesIncluded;
    }

    public void setGamesIncluded(ArrayList<Game> gamesIncluded) {
        this.gamesIncluded = gamesIncluded;
    }
}
