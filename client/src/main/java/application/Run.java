package application;

// import helpers.Initialize;
import service.QRCodeService;

public class Run {
	public static void main(String[] args) {
		// Initialize.start();
		new QRCodeService().fFrame(12, "9203840298439");
	}
}
