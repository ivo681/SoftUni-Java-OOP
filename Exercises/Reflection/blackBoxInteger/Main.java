package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BlackBoxInt blackBoxInt;

        try {
            Constructor<?> ctor = BlackBoxInt.class.getDeclaredConstructor();
            ctor.setAccessible(true);
            Object obj = ctor.newInstance();
            assert obj instanceof BlackBoxInt;
            blackBoxInt = (BlackBoxInt)obj;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        Map<String, Method> methodsbyName = Arrays.stream(blackBoxInt.getClass().getDeclaredMethods()).
                peek(m -> m.setAccessible(true))
                .collect(Collectors.toMap(m -> m.getName(), method -> method));

        Field value = BlackBoxInt.class.getDeclaredField("innerValue");
        value.setAccessible(true);
        String input = reader.readLine();
        while (!input.matches("END")){
            String [] tokens = input.split("_");
            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            Method method = methodsbyName.get(command);
            method.invoke(blackBoxInt, param);
            input = reader.readLine();
            System.out.println((int)value.get(blackBoxInt));
        }

    }
}
