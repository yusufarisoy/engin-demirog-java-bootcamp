import Database.*;
import Log.*;
import Sale.*;
import User.*;
import Verification.EdevletVerificationService;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Database db = new MySqlDatabase();

        UserManager userManager = new UserManager(db, new Logger[] { new DatabaseLogger() }, new EdevletVerificationService());
        User user = userManager.create(1L, "ysfgkmn", "123", "85935113451", "Yusuf Gökmen", "Arısoy", LocalDate.of(2000, 1, 1));
        userManager.update(user, "ysfgokmen", "12345", "85935113451", "Yusuf Gökmen", "Arısoy", LocalDate.of(2000, 1, 1));

        //Games
        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game(1L, 150, "Dishonered" , 0));
        games.add(new Game(2L, 200, "GTA V" , 0));
        games.add(new Game(3L, 250, "Cyberpunk 2077" , 0));
        games.add(new Game(4L, 250, "Red Dead Redemption 2" , 0));

        //***** SALES *****
        SalesManager salesManager = new SalesManager(db, new Logger[] { new DatabaseLogger() });

        //Sale.Campaign
        ArrayList<Game> campaignGames = new ArrayList<>();
        campaignGames.add(games.get(0));
        campaignGames.add(games.get(3));
        Campaign campaign = salesManager.makeCampaign(1L, "Rockstar Sale.Sale", "Rockstar games are on sale!!", 15, LocalDate.now(), LocalDate.of(2021, 5, 15), campaignGames);
        salesManager.updateCampaign(campaign, "Rockstar Sale.Sale", "Rockstar games are on crazy sale up to 30% !! Also campaign period extended !!", 30, LocalDate.of(2021, 5, 20), campaignGames);

        salesManager.sell(user, games.get(3));

        salesManager.removeCampaign(campaign);

        //Discount
        salesManager.makeDiscount(games.get(1), 10);

        salesManager.sell(user, games.get(1));

        salesManager.removeDiscount(games.get(1));

        //Delete user
        userManager.delete(user);
    }
}
