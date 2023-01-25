package main.command;

import main.ConsoleHelper;
import main.ZipFileManager;
import main.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

// Команда распаковки архива
public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            // Формируем директорию, используя полный путь
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            // Создаем архив по заданному пользователем пути
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Архив был распакован.");

        } catch (WrongZipFileException e) {
            ConsoleHelper.writeMessage("Архив не существует.");
        }
    }
}
