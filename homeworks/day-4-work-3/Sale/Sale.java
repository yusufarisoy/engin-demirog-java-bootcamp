package Sale;

import java.time.LocalDate;

public class Sale
{
    private final Long id;
    private final Long userId;//FK
    private final Long gameId;//FK
    private final LocalDate date;
    private Long campaignId;//FK, Nullable

    public Sale(Long id, Long userId, Long gameId, LocalDate date)
    {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.date = date;
    }

    public Sale(Long id, Long userId, Long gameId, LocalDate date, Long campaignId)
    {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.date = date;
        this.campaignId = campaignId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getCampaignId() {
        return campaignId;
    }
}
