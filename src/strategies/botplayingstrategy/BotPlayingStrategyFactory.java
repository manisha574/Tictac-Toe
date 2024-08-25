package strategies.botplayingstrategy;

import models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        // TODO: Add other bot playing strategy (if-else)
        return new EasyBotPlayingStrategy();
    }
}