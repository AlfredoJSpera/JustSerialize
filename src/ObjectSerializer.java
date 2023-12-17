import java.io.*;

public class ObjectSerializer {
	public static void serialize(Object obj, String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}

	public static Object deserialize(String path) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object object = ois.readObject();
		ois.close();
		return object;
	}
}
