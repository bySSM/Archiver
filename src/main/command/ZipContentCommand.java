package main.command;

import main.ConsoleHelper;
import main.FileProperties;
import main.ZipFileManager;

import java.util.List;

// Команда просмотра содержимого архива
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Содержимое архива:");

        // Получаем список файлов архива
        List<FileProperties> fileProperties = zipFileManager.getFilesList();
        for (FileProperties file : fileProperties) {
            ConsoleHelper.writeMessage(file.toString());
        }

        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}