package Server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import DTO.Example;

public class Sserver {
	OutputStream op = null;
	InputStream ip = null;
	
	Sserver(ServerSocket ssc) throws IOException {
		System.out.println("연결대기중");
		Socket sc = ssc.accept();
		System.out.println(sc.getInetAddress() + "/" + sc.getPort() + "연결됨!");

		Example ex = new Example();
		ex.setTitle("탈모르파티");
		ex.setSinger("김연자");
		ex.setGenre("트로트");
		ex.test.add("이것은");
		ex.test.add("실험용");
		ex.test.add("입니다.");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//객체 분해시 순서대로 byte를 재조립 해야 하므로 순서대로 분해하는 틀(객체를 클래스화하는걸 생각해보자)을 만들어줌
		
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		//ObjectOutputStream의 메소드를 사용할때 정해진 byte순서대로 하기위해 매개변수에  baos를 넣어줌 
		
		oos.writeObject(ex);
		//전송할 데이터를 Object형식으로 정해준 baos클래스의 writeObject매서드를 사용하여 byte로 쪼갬
		
		byte[] bowl = baos.toByteArray();
		//쪼개진 Object형식데이터를 baos의 순서대로 /byte[]그릇에 순차적으로 담음
		
		op = sc.getOutputStream();
		//해당하는 소켓으로 보낼 OutputStream생성
		
		op.write(bowl);
		//위에서 쪼개진  Object형식데이터 byte로 전송
		
		ip= sc.getInputStream();//클라이언트가 받을때까지 서버꺼지지 말라고 달아놓은것
		System.out.println("받았습니다.");
		
	}
}
