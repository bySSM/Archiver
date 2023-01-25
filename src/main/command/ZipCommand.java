package main.command;

import main.ConsoleHelper;
import main.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива");

        // Формируем директорию, используя полный путь
        Path zipPath = Paths.get(ConsoleHelper.readString());

        // Создаем объект ZipFileManager, передав в конструктор полученный путь
        ZipFileManager zipFileManager = new ZipFileManager(zipPath);

        return zipFileManager;
    }
}