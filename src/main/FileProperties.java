package main;

/**
 * Класс, который будет отвечать за свойства каждого файла в архиве.
 * Свойства - это набор, состоящий из: имя файла, размер файла до и после сжатия, метод сжатия
 */

public class FileProperties {

    private String name; // имя
    private long size; // размер в байтах
    private long compressedSize; // размер после сжатия в байтах
    private int compressionMethod; // метод сжатия

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    // Метод, который будет считать степень сжатия
    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        // Строим красивую строку из свойств
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        if (size > 0) {
            builder.append("\t");
            builder.append(size / 1024);
            builder.append(" Kb (");
            builder.append(compressedSize / 1024);
            builder.append(" Kb) сжатие: ");
            builder.append(getCompressionRatio());
            builder.append("%");
        }

        return builder.toString();
    }
}
