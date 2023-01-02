package Patterns.behavorialCaching.database;

import Patterns.behavorialCaching.UserAccount;

// handles reading and writing of UserAccount objects to/from database.
public interface DbManager {
    void connect();
    void disconnect();

    UserAccount readFromDb(String userId);
    UserAccount writeToDb(UserAccount userAccount);
    UserAccount updateDb(UserAccount userAccount);
    UserAccount upsertDb(UserAccount userAccount);
}
