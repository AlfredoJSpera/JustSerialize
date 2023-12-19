import java.io.*;

public class ObjectSerializer<T> {

	/**
	 * Serializes an object to a file.
	 * @param path The path to the file.
	 * @param object The object to be serialized. Must implement Serializable.
	 * @throws IOException
	 */
	public static <T extends Serializable> void serialize(String path, T object) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(object);
		oos.close();
	}

	/**
	 * Deserializes an object from a file.
	 * @param path The path to the file.
	 * @param targetClass The class of the object to be deserialized.
	 * @return The deserialized object.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T> T deserialize(String path, Class<T> targetClass) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		T object = targetClass.cast(ois.readObject());
		ois.close();
		return object;
	}

}
