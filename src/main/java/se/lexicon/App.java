package se.lexicon;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AppUser user = new AppUser("CasNil","test123",AppRole.ROLE_APP_ADMIN);
        System.out.println(user.getRole());
        user.setRole(AppRole.ROLE_APP_USER);
        System.out.println("-----------");
        System.out.println(user.getRole());
    }

}
