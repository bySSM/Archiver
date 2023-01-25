package main.exception;

/**
 * Исключение PathIsNotFoundException будем кидать, если не сможем найти путь,
 * в который нужно распаковать архив, или путь к файлу, который хотим запаковать,
 * или любой другой путь.
 **/
public class PathIsNotFoundException extends Exception {
}
