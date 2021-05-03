package Sale;

import Database.Database;
import Log.Logger;
import User.User;
import java.time.LocalDate;
import java.util.ArrayList;
import Utils.Utils;

public class SalesManager
{
    private final Database db;
    private final Logger[] loggers;

    public SalesManager(Database database, Logger[] loggers)
    {
        this.db = database;
        this.loggers = loggers;
    }

    public void sell(User user, Game game)
    {
        try
        {
            Long campaignId = db.isGameFromCampaign(game);
            Sale sale;

            if(campaignId == null)
                sale = new Sale(1L, user.getId(), game.getId(), LocalDate.now());
            else
                sale = new Sale(1L, user.getId(), game.getId(), LocalDate.now(), campaignId);
            db.insertToSales(sale);

            Utils.runLoggers(loggers, user, "buy the game with id " + game.getId(), LocalDate.now());
        }
        catch(Exception ex) {
            Utils.logErrors(loggers, "Exception on buy", LocalDate.now());
        }
    }

    public void makeDiscount(Game game, double discount)
    {
        game.setDiscount(discount);
        db.updateGame(game);
    }

    public void removeDiscount(Game game)
    {
        game.setDiscount(0);
        db.updateGame(game);
    }

    public Campaign makeCampaign(Long id, String name, String description, double discount, LocalDate startDate, LocalDate endDate, ArrayList<Game> games)
    {
        try
        {
            Campaign campaign = new Campaign(id, name, description, discount, startDate, endDate, games);
            db.insertToCampaigns(campaign);

            for(Game game : games) {
                game.setDiscount(discount);
            }
            return campaign;
        }
        catch(Exception ex)
        {
            Utils.logErrors(loggers, "Exception on campaign create", LocalDate.now());
            return null;
        }
    }

    public void updateCampaign(Campaign campaign, String name, String description, double discount, LocalDate endDate, ArrayList<Game> games)
    {
        try
        {
            campaign.setName(name);
            campaign.setDescription(description);
            campaign.setDiscount(discount);
            campaign.setEndDate(endDate);
            campaign.setGamesIncluded(games);

            db.updateCampaign(campaign);
        }
        catch(Exception ex) {
            Utils.logErrors(loggers, "Exception on campaign update", LocalDate.now());
        }
    }

    public void removeCampaign(Campaign campaign)
    {
        try {
            db.deleteFromCampaigns(campaign.getId());
        }
        catch(Exception ex) {
            Utils.logErrors(loggers, "Exception on campaign delete", LocalDate.now());
        }
    }
}
