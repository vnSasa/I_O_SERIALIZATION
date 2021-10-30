package ua.yaremechko.i_o_serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Method {

	public static void serialize(File file, Serializable object) throws IOException, ClassNotFoundException {
		FileOutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(object);
		System.out.println(deserialize(file));
		oos.close();
	}

	public static Serializable deserialize(File file) throws IOException, ClassNotFoundException {
		FileInputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		Serializable object = (Serializable) ois.readObject();
		ois.close();
		is.close();

		return object;

	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		File file = new File("Employee.txt");
		Employee em = new Employee("Oleg", 1, 250);
		serialize(file, em);
	
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("Andrew", 2, 340));
		emp.add(new Employee("Solia", 3, 450));
		emp.add(new Employee("Kattie", 4, 210));
		emp.add(new Employee("Sania", 5, 360));
		serialize(file, (Serializable) emp);
	}

}
