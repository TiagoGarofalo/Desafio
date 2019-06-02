package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.controller.LivroController;
import model.vo.LivroVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaLivros extends JFrame {

	private JPanel contentPane;
	private JTable tbLivros;
	private JTextField tfEdicao;
	private JTextField tfAutor;
	private JTextField tfTitulo;
	LivroVO livro = new LivroVO();
	LivroController controller = new LivroController();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaLivros frame = new ListaLivros();
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
	public ListaLivros() {
		setTitle("Lista de Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultarLivros = new JLabel("Consultar livros");
		lblConsultarLivros.setBounds(254, 157, 92, 14);
		contentPane.add(lblConsultarLivros);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 230, 567, 2);
		contentPane.add(separator);
		
		JButton btConsultar = new JButton("Consultar");
		btConsultar.setBounds(450, 196, 127, 23);
		contentPane.add(btConsultar);
		
		tbLivros = new JTable();
		tbLivros.setBounds(0, 244, 587, 138);
		contentPane.add(tbLivros);
		
		JComboBox cbAutor = new JComboBox();
		cbAutor.setBounds(10, 199, 127, 20);
		contentPane.add(cbAutor);
		
		JComboBox cbTitulo = new JComboBox();
		cbTitulo.setBounds(147, 199, 130, 20);
		contentPane.add(cbTitulo);
		
		JComboBox cbEdicao = new JComboBox();
		cbEdicao.setBounds(287, 199, 127, 20);
		contentPane.add(cbEdicao);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 149, 567, 2);
		contentPane.add(separator_1);
		
		JLabel lblCadastrarLivros = new JLabel("Cadastrar Livros");
		lblCadastrarLivros.setBounds(243, 11, 92, 14);
		contentPane.add(lblCadastrarLivros);
		
		JLabel lblTitulo = new JLabel("Título :");
		lblTitulo.setBounds(10, 39, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor :");
		lblAutor.setBounds(10, 64, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEdicao = new JLabel("Edição:");
		lblEdicao.setBounds(10, 89, 46, 14);
		contentPane.add(lblEdicao);
		
		tfEdicao = new JTextField();
		tfEdicao.setColumns(10);
		tfEdicao.setBounds(66, 86, 269, 20);
		contentPane.add(tfEdicao);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(66, 61, 269, 20);
		contentPane.add(tfAutor);
		
		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(66, 36, 269, 20);
		contentPane.add(tfTitulo);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setNome(tfTitulo.getText());
				livro.setNome(tfAutor.getText());
				livro.setNome(tfEdicao.getText());
				controller.salvar(livro);
			}
		});
		btSalvar.setBounds(241, 117, 94, 23);
		contentPane.add(btSalvar);
		
		JLabel lblAutorCbBox = new JLabel("Autor");
		lblAutorCbBox.setBounds(13, 181, 46, 14);
		contentPane.add(lblAutorCbBox);
		
		JLabel lblTituloCbBox = new JLabel("Título");
		lblTituloCbBox.setBounds(149, 181, 46, 14);
		contentPane.add(lblTituloCbBox);
		
		JLabel lblEdicaoCbBox = new JLabel("Edição");
		lblEdicaoCbBox.setBounds(289, 182, 46, 14);
		contentPane.add(lblEdicaoCbBox);
	}
}
