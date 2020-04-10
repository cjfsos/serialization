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
		// byte타입으로 받을 그릇 생성
		
		InputStream reMsg = sc.getInputStream();
		// 소켓을 통해 받을 InputStream생성
		
		reMsg.read(reBuffer);
		// byte 그릇으로 전송된 Data를 읽어옴
		
		ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);
		// 해당 byte를 정해진 순서대로 조립하기 위함
		
		ObjectInputStream ois = new ObjectInputStream(bais);
		// bais의 순서대로 오브젝트 타입으로 byte를 재조립
		
		try {
			Object o = ois.readObject();
			// 정해진 순서대로 재조립된 byte를 Object객체로 형 변환
			
			Example ex = (Example) o;
			// Object인 o를 직렬화전의
			//원래의 객체 형태인 Example타입으로 재조직
			
			System.out.println(ex.getTitle());
			System.out.println(ex.getSinger());
			System.out.println(ex.getGenre());
			for(int i = 0; i < ex.test.size() ;i++) {
				System.out.println(ex.test.get(i));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}