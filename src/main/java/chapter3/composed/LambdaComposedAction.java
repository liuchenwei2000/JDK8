package chapter3.composed;

import java.util.function.Function;

/**
 * 函数复合的实际用途
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class LambdaComposedAction {

    public static class Letter{

        public static String addHeader(String text){
            return "From Raoul, Mario and Alan: " + text;
        }

        public static String addFooter(String text){
            return text + " Kind regards";
        }

        public static String checkSpelling(String text){
            return text.replaceAll("labda", "lambda");
        }
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        // 可以通过复合这些工具方法来创建各种转型流水线，比如创建一个流水线：先加上抬头，然后进行拼写检查，最后加上一个落款，
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        // 第二个流水线可能只加抬头、落款，而不做拼写检查
        Function<String, String> transformationPipeline2 = addHeader.andThen(Letter::addFooter);
    }
}
