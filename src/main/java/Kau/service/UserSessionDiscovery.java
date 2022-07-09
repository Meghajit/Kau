package Kau.service;

import java.util.UUID;

public class UserSessionDiscovery {
    public static String findSessionServer(UUID userUUID) {
        /* do IO operation on ETCD and find instance to which userUUID is connected
         * if not found, return null */
        return null;
    }
}
