package application;

//import helpers.Initialize;
import service.QRCodeService;

public class Run {
	public static void main(String[] args) {
		//Initialize.start();
		new QRCodeService().fFrame(12, "remotebash-9022142288376442819L");
	}
}
