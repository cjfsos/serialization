package Client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import DTO.Example;

public class TestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sc = new Socket("10.0.0.97", 9999);
		byte[] reBuffer = new byte[1024];
		InputStream reMsg = sc.getInputStream();
		reMsg.read(reBuffer);
		System.out.println(reBuffer+"         바이트형태");
		ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);
		System.out.println(bais+"      ArrayInput");
		ObjectInputStream ois = new ObjectInputStream(bais);
		System.out.println(ois+"       ObjectInput");
		try {
			Object o = ois.readObject();
			System.out.println(o+"        객체형변환");
			Example ex = (Example) o;
			System.out.println(ex+"      받은 객체");
			System.out.println(ex.getTitle());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}