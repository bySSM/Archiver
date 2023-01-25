package main.command;

import main.ConsoleHelper;
import main.ZipFileManager;
import main.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

// Команда добавления файла в архив
public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Добавление нового файла в архив.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя файла для добавления:");
            // Формируем директорию, используя полный путь
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            // Добавляем файл в архив по заданному пользователем пути
            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Добавление в архив завершено.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не был найден.");
        }
    }
}
