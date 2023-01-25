package main;

import main.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Чтобы не создавать объект класса нужной команды каждый раз,
 * его нужно где-то хранить. Создадим для этих целей класс CommandExecutor
 */

public class CommandExecutor {
    // Хранилище команд
    // ALL_KNOWN_COMMANDS_MAP - ОТОБРАЖЕНИЕ ВСЕХ ИЗВЕСТНЫХ КОМАНД
    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();

    // Добавляем все известные команды в хранилище
    static {
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CREATE, new ZipCreateCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.ADD, new ZipAddCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.REMOVE, new ZipRemoveCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXTRACT, new ZipExtractCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CONTENT, new ZipContentCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {
    }

    // Вызываем метод execute() у той переменной operation
    public static void execute(Operation operation) throws Exception {
        ALL_KNOWN_COMMANDS_MAP.get(operation).execute();
    }
}
