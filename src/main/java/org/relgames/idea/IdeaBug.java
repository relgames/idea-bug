package org.relgames.idea;

import akka.japi.pf.ReceiveBuilder;
import akka.persistence.AbstractPersistentActor;
import java.util.UUID;

/**
 * @author opoleshuk
 */
public class IdeaBug extends AbstractPersistentActor {
    @Override
    public Receive createReceiveRecover() {
        return createReceive();
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
            .match(UUID.class, id -> sender().tell("test", self()))
            .build();
    }

    @Override
    public String persistenceId() {
        return "test";
    }
}
