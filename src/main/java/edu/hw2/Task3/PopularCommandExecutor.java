package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.ConnectionManager;
import edu.hw2.Task3.Exceptions.ConnectionException;

public final class PopularCommandExecutor {

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        Integer checkForSuccessConnect = 0;
        for (int i = 0; i < maxAttempts; i++) {
            try {
                manager.getConnection().execute(command);
            } catch (ConnectionException e) {
                checkForSuccessConnect++;
                if (checkForSuccessConnect == maxAttempts) {
                    throw new ConnectionException("The upper limit of attempts has been reached", e.getCause());
                }
            }
        }
        manager.getConnection().close();
    }

}
