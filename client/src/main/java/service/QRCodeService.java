package service;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modal.GenerateQRCode;
import java.awt.Color;
import java.awt.FlowLayout;

public class QRCodeService extends JFrame {
	private static final long serialVersionUID = 9022142288376442819L;

	JFrame frame = new JFrame();
	JDialog jdialog = new JDialog(frame, true);

	public void fFrame(Integer id, String serial) {
		new GenerateQRCode(serial);

		frame.setSize(500, 500);
		frame.setTitle("QRCode do computador N° " + id);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);

		ImageIcon icon = new ImageIcon("src/imgs/qrcode.png");
		JLabel qrcode = new JLabel(icon);
		qrcode.setSize(10, 10);
		qrcode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frame.add(qrcode);

		jdialog.setSize(300, 300);
		jdialog.setLayout(new FlowLayout());
		jdialog.setLocationRelativeTo(null);
		jdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jdialog.getContentPane().setBackground(Color.white);

		frame.setVisible(true);

	}
}
