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
  /**
   * 
   * in Java generics, any type parameters used in the method NEED TO BE explicitly declared.
   * When you define a method with generics, you NEED TO declare all the type parameters that 
   * the method uses. This includes not only the return type but also any parameter types.
   */
  public <T, R> R dynamicMethod(T data, Function<T, R> transformer) { // its also can be --> public <R, T> R dynamicMethod(T data, Function<T, R> transformer) { (change position in generic at type return <T, R> become <R, T>)
    return transformer.apply(data);
  }

  public <J, W, S> S dynamicMethodNextVersion(J data, W input, Function<W, S> transformer) {

    return transformer.apply(input);

    // TO DO: dynamic

    // String forString = "";
    // Integer forNumber = 0;

    // if (data instanceof String) {
    //   forString += data;
    // }

    // if (input instanceof String) {
    //   forString = forString + " " + input;
    // }

    // if (data instanceof Integer) {
    //   forNumber = data;
    // }

    // if (input instanceof Integer) {
    //   forNumber = input;
    // }

    // if (forString != "") {
    //   return transformer.apply(forString);
    // } else {
    //   return "";
    // }

    // if (forNumber > 0) {
    //   return transformer.apply(forNumber);
    // } else {
    //   return 0;
    // }

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
    System.out.println("Transformed result1: " + result1); // Output: Transformed Data: 123

    String data2 = "hello";
    String result2 = demoTest.dynamicMethod(data2, String::toUpperCase);
    System.out.println("Transformed result2: " + result2); // Output: Transformed Data: HELLO

    // try String
    String data3 = "Hello ";
    String data4 = "Mars!";
    String result3 = demoTest.dynamicMethodNextVersion(data3, data4, String::toUpperCase);
    System.out.println("Transformed result3: " + result3);
  }
}
