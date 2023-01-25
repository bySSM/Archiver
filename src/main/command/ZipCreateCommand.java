package main.command;

import main.ConsoleHelper;
import main.ZipFileManager;
import main.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

// Команда создания архива (упаковки файлов в архив)
public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации:");
            // Формируем директорию, используя полный путь
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            // Создаем архив по заданному пользователем пути
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage("Архив создан.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}