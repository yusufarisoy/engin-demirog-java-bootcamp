package core.concretes;

import Google.GoogleAuthenticationManager;
import core.abstracts.AuthenticationService;

public class GoogleAuthenticationManagerAdapter implements AuthenticationService
{
    @Override
    public void register()
    {
        GoogleAuthenticationManager googleAuthenticationManager = new GoogleAuthenticationManager();
        googleAuthenticationManager.registerWithGoogleAccount();
    }
}
