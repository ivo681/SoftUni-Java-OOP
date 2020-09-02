package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Field[] declaredFields = RichSoilLand.class.getDeclaredFields();
		String input = reader.readLine();
		while (!input.matches("HARVEST")){
			if (input.matches("public")){
				Arrays.stream(declaredFields).filter(field -> field.getModifiers() == Modifier.PUBLIC).
						forEach(field -> System.out.println("public " + field.getType().getSimpleName() + " " + field.getName()));
			} else if (input.matches("private")){
				Arrays.stream(declaredFields).filter(field -> field.getModifiers() == Modifier.PRIVATE).
						forEach(field -> System.out.println("private " + field.getType().getSimpleName() + " " + field.getName()));
			} else if (input.matches("protected")){
				Arrays.stream(declaredFields).filter(field -> field.getModifiers() == Modifier.PROTECTED).
						forEach(field -> System.out.println("protected " + field.getType().getSimpleName() + " " + field.getName()));
			} else {
				Arrays.stream(declaredFields).
						forEach(field -> System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName()));

			}
			input = reader.readLine();
		}

	}
}
