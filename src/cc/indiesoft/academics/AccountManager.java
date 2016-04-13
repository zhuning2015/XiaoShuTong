package cc.indiesoft.academics;

import java.util.HashMap;

public class AccountManager
{
    private static HashMap<String,String> accounts = new HashMap<String,String>();

    public static boolean isValid(String userName, String password)
    {
        if (accounts.containsKey(userName))
        {
            if (accounts.get(userName).equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public static void addAccount(String userName, String password)
    {
        accounts.put(userName, password);
    }

    public static boolean contains(String userName)
    {
        return accounts.containsKey(userName);
    }
}
