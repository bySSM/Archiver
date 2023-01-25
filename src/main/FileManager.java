package main;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * класс FileManager для получения списка всех файлов в какой-то папке
 */

public class FileManager {
    // Корневой путь директории, файлы которой нас интересуют
    private Path rootPath;

    // список относительных путей файлов внутри rootPath
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    /**
     *  метод, который будет складывать в переменную класса fileList все файлы,
     *  обнаруженные внутри переданного пути path, вызывая сам себя для всех объектов,
     *  в обнаруженных директориях
     */
    private void collectFileList(Path path) throws IOException {
        // Проверить, если переданный путь path является обычным файлом
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }

        // Если переданный путь path, является директорией
        if (Files.isDirectory(path)) {
            // Рекурсивно проходимся по всему содержимому директории.
            // Получаем директорию файла с помощью метода Files.newDirectoryStream(path)
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path file : directoryStream) {
                    collectFileList(file);
                }
            }
        }
    }
}
