package Patterns.behavorialCaching.database;

/**
 * Creates the database connection accroding the input parameter.
 */
public final class DbManagerFactory {
    /**
     * Private constructor.
     */
    private DbManagerFactory() {
    }

    /**
     * Init database.
     *
     * @param isMongo boolean
     * @return {@link DbManager}
     */
    public static DbManager initDb(final boolean isMongo) {
        if (isMongo) {
            return null;//no mongodb database config done yet --> refer repo
        }
        return new VirtualDb();
    }
}