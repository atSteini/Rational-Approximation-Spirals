package primes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.apple.dnssd.TXTRecord;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Frame extends JFrame {
	private JPanel contentPane;
	private static JPanel panel;
	private final ButtonGroup buttonGroup;
	static JComboBox cmbxPalette;
	static JComboBox cmbxNumbers;
	InputListener refreshAction;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() {
		this.buttonGroup = new ButtonGroup();
		this.refreshAction = new InputListener();
		
		setDefaultCloseOperation(3);
		setBounds(100, 100, 600, 750);
		setMinimumSize(new Dimension(540, 500));
		setTitle("Rational Approximation Spirals");

		getLookAndFeel();

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Frame.handleInput();

				panel.repaint();
			}
		});
		this.contentPane = new JPanel();
		this.contentPane.setBackground(var.bg);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);

		panel = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();

		cmbxPalette = new JComboBox(var.comboColors);
		cmbxPalette.setSelectedIndex(var.selectedPalette);
		cmbxPalette.addActionListener(this.refreshAction);

		cmbxPalette.setToolTipText("Color Palette for Particles");

		JLabel lblColorPalette = new JLabel("Color Palette");
		lblColorPalette.setForeground(Color.WHITE);
		lblColorPalette.setBackground(Color.WHITE);

		JLabel lblPossibleNumbers = new JLabel("Possible Numbers");
		lblPossibleNumbers.setForeground(Color.WHITE);

		cmbxNumbers = new JComboBox(var.comboNumbers);
		cmbxNumbers.setSelectedIndex(var.selectedNumber);
		cmbxNumbers.addActionListener(this.refreshAction);

		cmbxNumbers.setToolTipText("Number Palette for Particles");

		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblColorPalette)
					.addGap(18)
					.addComponent(cmbxPalette, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblPossibleNumbers)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbxNumbers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(215, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColorPalette)
						.addComponent(cmbxPalette, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPossibleNumbers)
						.addComponent(cmbxNumbers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
		);

		this.contentPane.setLayout(gl_contentPane);

		handleInput();
	}

	public static void handleInput() {
		var.particle = null;
		var.particlesInit = false;

		var.selectedNumber = cmbxNumbers.getSelectedIndex();
		var.selectedPalette = cmbxPalette.getSelectedIndex();

		panel.repaint();
	}

	static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	void getLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
