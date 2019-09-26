package service;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import java.awt.Color;

public class QRCodeService extends JFrame {
	private static final long serialVersionUID = 9022142288376442819L;

	JFrame frame = new JFrame();
	Image codeQrImage = null;

	public void fFrame(Integer id, String serial) {

		frame.setSize(500, 500);
		frame.setTitle("QRCode do computador N° " + id);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);

		BarcodeQRCode bcQRCode = new BarcodeQRCode(serial, 500, 500, null);

		JLabel qrcode = new JLabel(bcQRCode.toString());
		qrcode.setSize(10, 10);
		qrcode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frame.add(qrcode);

		frame.setVisible(true);

	}
}
