package Patterns.behavorialCaching.database;


import Patterns.behavorialCaching.UserAccount;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of DatabaseManager.
 * implements base methods to work with MongoDb.
 */
@Slf4j
//public class MongoDb implements DbManager {
public class MongoDb  {
    private static final String DATABASE_NAME = "admin";
    private static final String MONGO_USER = "root";
    private static final String MONGO_PASSWORD = "rootpassword";

   /* private MongoClient client;
    private MongoDatabase db;

    void setDB(MongoDatabase db) {
        this.db = db;
    }

    *//**
     * Connect to Db. Check th connection
     *//*
    @Override
    public void connect() {
        MongoCredential mongoCredential = MongoCredential.createCredential(MONGO_USER,
                DATABASE_NAME,
                MONGO_PASSWORD.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
        client = new MongoClient(new ServerAddress(), mongoCredential, options);
        db = client.getDatabase(DATABASE_NAME);
    }

    @Override
    public void disconnect() {
        client.close();
    }

    *//**
     * Read data from DB.
     *
     * @param userId {@link String}
     * @return {@link UserAccount}
     *//*
    @Override
    public UserAccount readFromDb(final String userId) {
        var iterable = db
                .getCollection(CachingConstants.USER_ACCOUNT)
                .find(new Document(USER_ID, userId));
        if (iterable.first() == null) {
            return null;
        }
        Document doc = iterable.first();
        if (doc != null) {
            String userName = doc.getString(USER_NAME);
            String appInfo = doc.getString(ADD_INFO);
            return new UserAccount(userId, userName, appInfo);
        } else {
            return null;
        }
    }

    *//**
     * Write data to DB.
     *
     * @param userAccount {@link UserAccount}
     * @return {@link UserAccount}
     *//*
    @Override
    public UserAccount writeToDb(final UserAccount userAccount) {
        db.getCollection(USER_ACCOUNT).insertOne(
                new Document(USER_ID, userAccount.getUserId())
                        .append(USER_NAME, userAccount.getUserName())
                        .append(ADD_INFO, userAccount.getAdditionalInfo())
        );
        return userAccount;
    }

    *//**
     * Update DB.
     *
     * @param userAccount {@link UserAccount}
     * @return {@link UserAccount}
     *//*
    @Override
    public UserAccount updateDb(final UserAccount userAccount) {
        Document id = new Document(USER_ID, userAccount.getUserId());
        Document dataSet = new Document(USER_NAME, userAccount.getUserName())
                .append(ADD_INFO, userAccount.getAdditionalInfo());
        db.getCollection(CachingConstants.USER_ACCOUNT)
                .updateOne(id, new Document("$set", dataSet));
        return userAccount;
    }

    *//**
     * Update data if exists.
     *
     * @param userAccount {@link UserAccount}
     * @return {@link UserAccount}
     *//*
    @Override
    public UserAccount upsertDb(final UserAccount userAccount) {
        String userId = userAccount.getUserId();
        String userName = userAccount.getUserName();
        String additionalInfo = userAccount.getAdditionalInfo();
        db.getCollection(CachingConstants.USER_ACCOUNT).updateOne(
                new Document(USER_ID, userId),
                new Document("$set",
                        new Document(USER_ID, userId)
                                .append(USER_NAME, userName)
                                .append(ADD_INFO, additionalInfo)
                ),
                new UpdateOptions().upsert(true)
        );
        return userAccount;
    }
*/}
