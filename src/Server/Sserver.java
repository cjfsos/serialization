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

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(ex);
		byte[] bowl = baos.toByteArray();
		op = sc.getOutputStream();
		op.write(bowl);
		
		ip= sc.getInputStream();
		System.out.println("받았습니다.");
		
	}
}
