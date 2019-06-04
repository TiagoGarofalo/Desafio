package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.LivroController;
import model.vo.LivroVO;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

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
		
		JButton btConsulta1 = new JButton("1º caso");
		btConsulta1.setBounds(10, 198, 127, 23);
		contentPane.add(btConsulta1);
		
		tbLivros = new JTable();
		tbLivros.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Titulo", "Autor", "Edi\u00E7\u00E3o"},
			},
			new String[] {
				"ID", "Titulo", "Autor", "Edi\u00E7\u00E3o"
			}
		));
		tbLivros.getColumnModel().getColumn(1).setPreferredWidth(214);
		tbLivros.getColumnModel().getColumn(2).setPreferredWidth(214);
		tbLivros.getColumnModel().getColumn(3).setPreferredWidth(109);
		tbLivros.setBounds(0, 244, 587, 138);
		contentPane.add(tbLivros);
		
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
				livro.setTitulo(tfTitulo.getText());
				livro.setAutor(tfAutor.getText());
				livro.setEdicao(tfEdicao.getText());
				controller.salvar(livro);
			}
		});
		btSalvar.setBounds(241, 117, 94, 23);
		contentPane.add(btSalvar);
		
		JButton btConsulta2 = new JButton("2º caso");
		btConsulta2.setBounds(147, 198, 127, 23);
		contentPane.add(btConsulta2);
		
		JButton btConsulta3 = new JButton("2º caso");
		btConsulta3.setBounds(284, 198, 127, 23);
		contentPane.add(btConsulta3);
	}
	protected void atualizarTabelaSimulacoes(List<LivroVO> livros) {
		// Limpa a tabela
		Object[][] header = new Object[][] {new String[] { "ID", "Titulo", "Autor", "Edição" }};
		String[] registros = new String[] { "ID", "Titulo", "Autor", "Edição" };
		
		tbLivros.setModel(new DefaultTableModel(header,
				registros));

		DefaultTableModel modelo = (DefaultTableModel) tbLivros.getModel();

		for (LivroVO livro : livros) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do livro
			// na ORDEM do cabeçalho da tabela
			
			Object[] novaLinha = new Object[] { livro.getIdLivro(), livro.getTitulo(), livro.getAutor(), livro.getEdicao() };
			modelo.addRow(novaLinha);
		}

	}
}
