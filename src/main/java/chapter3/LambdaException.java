package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Lambda 与异常
 * <p>
 *     任何函数式接口都不允许抛出受检异常（checked exception）。
 *     如果你需要 Lambda 表达式来抛出异常，有两种办法：
 *     定义一个自己的函数式接口，并声明受检异常，或者把 Lambda 包在一个 try/catch 块中。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class LambdaException {

    public static void main(String[] args) {
        FileProcessor fileProcessor = (BufferedReader br) -> br.readLine();

        Function<BufferedReader, String> f = (BufferedReader br) -> {
            // 2，把 Lambda 包在一个 try/catch 块中
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        };
    }

    /**
     * 1，定义一个自己的函数式接口，并声明受检异常
     */
    @FunctionalInterface
    public interface FileProcessor {

        String process(BufferedReader br) throws IOException;
    }
}
