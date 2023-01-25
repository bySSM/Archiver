package main.command;

import main.ConsoleHelper;
import main.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

// Команда удаления файла из архива
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите полный путь файла в архиве:");
        // Формируем директорию, используя полный путь
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        // Удаляем файл из архива по заданному пользователем пути
        zipFileManager.removeFile(sourcePath);

        ConsoleHelper.writeMessage("Удаление из архива завершено.");
    }
}
