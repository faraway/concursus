package com.opencredo.concursus.domain.commands.dispatching;

import com.opencredo.concursus.domain.commands.Command;
import com.opencredo.concursus.domain.commands.CommandResult;
import com.opencredo.concursus.domain.time.TimeUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Slf4jCommandLog implements CommandLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jCommandLog.class);

    @Override
    public Command logCommand(Command command) {
        Command processedCommand = command.processed(TimeUUID.timeBased());
        LOGGER.info("Received command {}", processedCommand);
        return processedCommand;
    }

    @Override
    public void logCommandResult(CommandResult commandResult) {
         LOGGER.info("Command completed {}", commandResult);
    }
}