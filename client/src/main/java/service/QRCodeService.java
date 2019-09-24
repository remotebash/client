package service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import qrcode.main.QRCodeService;

//new QRCodeService().fFrame(12,"9203840298439");

public class QRCodeService extends JFrame {
	private static final long serialVersionUID = 9022142288376442819L;

	JFrame frame = new JFrame();
	JLabel qrcode = new JLabel();

	public void fFrame(Integer id, String serial) {

		frame.setSize(500, 500);
		frame.setTitle("QRCode do computador N° " + id);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setVisible(true);

		qrcode.setText("Serial do QRCode: " + serial);
		qrcode.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(qrcode);
	}
}
