package cc.indiesoft.academics;

public class AccountManager
{
    public static boolean isValid(String userName, String password)
    {
        if (userName.equals("test") && password.equals("123"))
        {
            return true;
        }
        return false;
    }
}
