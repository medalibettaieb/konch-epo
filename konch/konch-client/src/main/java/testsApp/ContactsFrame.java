package testsApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import services.ContactServicesRemote;

public class ContactsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Context context;
	private ContactServicesRemote contactServicesRemote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactsFrame frame = new ContactsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactsFrame() {
		try {
			context = new InitialContext();
			contactServicesRemote = (ContactServicesRemote) context
					.lookup("konch-ear/konch-ejb/ContactServices!services.ContactServicesRemote");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblName = new JLabel("name");
		JTextArea textArea = new JTextArea();
		textField = new JTextField();
		textField.setColumns(10);

		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contactServicesRemote.addContact(textField.getText());
				textField.setText("");
			}
		});

		JButton btnList = new JButton("list");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				List<String> strings = contactServicesRemote.findAllContacts();
				for (String s : strings) {
					textArea.setText(textArea.getText() + "\n" + s);
				}

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(50).addComponent(lblName).addGap(44)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnAdd)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnList).addComponent(textField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addGap(40)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(43)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblName)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(33).addComponent(btnAdd).addGap(18).addComponent(btnList))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(72).addComponent(textArea,
								GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(75, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
