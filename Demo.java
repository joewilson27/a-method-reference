import java.util.function.Function;

/**
 * So here we are going to learn a little bit more about Method Reference
 */

public class Demo {
  
  // method reference 1
  public <R> R processString(String input, Function<String, R> transformer) {
    return transformer.apply(input);
  }

  // method reference 2
  public <T, R> R dynamicMethod(T data, Function<T, R> transformer) {
    return transformer.apply(data);
  }

  public static void main(String[] args) {
    
    Demo demoTest = new Demo();

    // method reference 1
    // Example usage: transforming a string to uppercase
    String resultUpperCase = demoTest.processString("hello", String::toUpperCase);
    System.out.println("Uppercase Result: " + resultUpperCase); // Output: Uppercase Result: HELLO

    // Example usage: transforming a string to its length
    Integer resultLength = demoTest.processString("hello", String::length);
    System.out.println("Length Result: " + resultLength); // Output: Length Result: 5

    // Example usage: converting a string to lowercase and then appending
    // using Lambda Expression --> str -> str.toLowerCase() it is the same as String::toLowerCase
    String resultAppendLambda = demoTest.processString("HELLO", str -> str.toLowerCase() + " world!");
    System.out.println("Append Result (w/ Lambda Expression): " + resultAppendLambda); // Output: Append Result (w/ Lambda Expression): hello world!

    String resultAppend = demoTest.processString("HELLO", String::toLowerCase);
    System.out.println("Cannot Append without Lambda Result: " + resultAppend); // Output: Cannot Append without Lambda Result: hello
  
  
    // method reference 2
    String data1 = "123";
    Integer result1 = demoTest.dynamicMethod(data1, Integer::valueOf);
    System.out.println("Transformed Data1: " + result1); // Output: Transformed Data: 123

    String data2 = "hello";
    String result2 = demoTest.dynamicMethod(data2, String::toUpperCase);
    System.out.println("Transformed Data2: " + result2); // Output: Transformed Data: HELLO
  }
}
