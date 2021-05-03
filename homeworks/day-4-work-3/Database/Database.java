package Database;

import Sale.Campaign;
import Sale.Game;
import Sale.Sale;
import User.User;

import java.util.HashMap;

public abstract class Database
{
    //A fake class to represent the database
    //Consider we have real data stored in it!
    public HashMap<Long, User> users = new HashMap<>();//Users table
    public HashMap<Long, Game> games = new HashMap<>();//Games table
    public HashMap<Long, Campaign> campaigns = new HashMap<>();//Campaigns
    public HashMap<Long, Sale> sales = new HashMap<>();//Sale.Sale table

    //USERS
    public void insertToUsers(User user)
    {
        this.users.put(user.getId(), user);
        System.out.println("Insert User.User default!");
    }

    public void updateUser(User user)
    {
        this.users.replace(user.getId(), user);
        System.out.println("Update User.User default!");
    }

    public void deleteFromUsers(Long id)
    {
        this.users.remove(id);
        System.out.println("Delete User.User default!");
    }

    //GAMES
    public void insertToGames(Game game)
    {
        this.games.put(game.getId(), game);
        System.out.println("Insert Sale.Game default!");
    }

    public void updateGame(Game game)
    {
        this.games.replace(game.getId(), game);
        System.out.println("Update Sale.Game default!");
    }

    public void deleteFromGames(Long id)
    {
        this.games.remove(id);
        System.out.println("Delete Sale.Game default!");
    }

    //CAMPAIGNS
    public void insertToCampaigns(Campaign campaign)
    {
        this.campaigns.put(campaign.getId(), campaign);
        System.out.println("Insert Sale.Campaign default!");
    }

    public void updateCampaign(Campaign campaign)
    {
        this.campaigns.replace(campaign.getId(), campaign);
        System.out.println("Update Sale.Campaign default!");
    }

    public void deleteFromCampaigns(Long id)
    {
        this.campaigns.remove(id);
        System.out.println("Delete Sale.Campaign default!");
    }

    public Long isGameFromCampaign(Game game)
    {
        for(Campaign campaign : this.campaigns.values())
        {
            if(campaign.getGamesIncluded().contains(game))
                return campaign.getId();
        }

        return null;
    }

    //SALES
    public void insertToSales(Sale sale)
    {
        this.sales.put(sale.getId(), sale);
        System.out.println("Insert Sale.Sale default!");
    }

    public void updateSale(Sale sale)
    {
        this.sales.replace(sale.getId(), sale);
        System.out.println("Update Sale.Sale default!");
    }

    public void deleteFromSales(Long id)
    {
        this.sales.remove(id);
        System.out.println("Delete Sale.Sale default!");
    }
}
