package Database;

import Sale.Campaign;
import Sale.Game;
import Sale.Sale;
import User.User;

public class MySqlDatabase extends Database
{
    @Override
    public void insertToUsers(User user)
    {
        this.users.put(user.getId(), user);
        System.out.println("Insert User.User to MySql Database.Database");
    }

    @Override
    public void updateUser(User user)
    {
        this.users.replace(user.getId(), user);
        System.out.println("Update User.User in MySql Database.Database!");
    }

    @Override
    public void deleteFromUsers(Long id)
    {
        this.users.remove(id);
        System.out.println("Delete User.User from MySql Database.Database!");
    }

    //Games
    @Override
    public void insertToGames(Game game)
    {
        this.games.put(game.getId(), game);
        System.out.println("Insert Sale.Game to MySql Database.Database");
    }

    @Override
    public void updateGame(Game game)
    {
        this.games.replace(game.getId(), game);
        System.out.println("Update Sale.Game in MySql Database.Database!");
    }

    @Override
    public void deleteFromGames(Long id)
    {
        this.games.remove(id);
        System.out.println("Delete Sale.Game from MySql Database.Database!");
    }

    //CAMPAIGNS
    @Override
    public void insertToCampaigns(Campaign campaign)
    {
        this.campaigns.put(campaign.getId(), campaign);
        System.out.println("Insert Sale.Campaign to MySql Database.Database");
    }

    @Override
    public void updateCampaign(Campaign campaign)
    {
        this.campaigns.replace(campaign.getId(), campaign);
        System.out.println("Update Sale.Campaign in MySql Database.Database!");
    }

    @Override
    public void deleteFromCampaigns(Long id)
    {
        this.campaigns.remove(id);
        System.out.println("Delete Sale.Campaign from MySql Database.Database!");
    }

    @Override
    public Long isGameFromCampaign(Game game)
    {
        for(Campaign campaign : this.campaigns.values())
        {
            if(campaign.getGamesIncluded().contains(game))
                return campaign.getId();
        }

        return null;
    }

    //Sales
    @Override
    public void insertToSales(Sale sale)
    {
        this.sales.put(sale.getId(), sale);
        System.out.println("Insert Sale.Sale to MySql Database.Database");
    }

    @Override
    public void updateSale(Sale sale)
    {
        this.sales.replace(sale.getId(), sale);
        System.out.println("Update Sale.Sale in MySql Database.Database!");
    }

    @Override
    public void deleteFromSales(Long id)
    {
        this.sales.remove(id);
        System.out.println("Delete Sale.Sale from MySql Database.Database!");
    }
}
