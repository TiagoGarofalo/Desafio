package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.LivroController;
import model.vo.LivroVO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListaLivros extends JFrame {

	private JPanel contentPane;
	private JTable tbLivros;
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
	List<LivroVO> livrosConsultados = new ArrayList<LivroVO>();
	LivroController controlador = new LivroController();

	public ListaLivros() {
		setTitle("Lista de Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConsultarLivros = new JLabel("Consultar livros");
		lblConsultarLivros.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarLivros.setBounds(277, 11, 157, 14);
		contentPane.add(lblConsultarLivros);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 664, 3);
		contentPane.add(separator);

		JButton btConsulta1 = new JButton("Consulta 1º caso");
		btConsulta1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btConsulta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// realiza consulta por titulo de livro em ordem crescente
				String consulta = "1";

				try {
					livrosConsultados = controlador.listarLivros(consulta);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				if (livrosConsultados != null) {
					atualizarTabelaSimulacoes(livrosConsultados);
				}
			}
		});
		btConsulta1.setBounds(10, 50, 114, 23);
		contentPane.add(btConsulta1);

		tbLivros = new JTable();
		tbLivros.setModel(new DefaultTableModel(new Object[][] { { "ID", "Titulo", "Autor", "Edi\u00E7\u00E3o" }, },
				new String[] { "ID", "Titulo", "Autor", "Edi\u00E7\u00E3o" }));
		tbLivros.getColumnModel().getColumn(0).setPreferredWidth(42);
		tbLivros.getColumnModel().getColumn(1).setPreferredWidth(214);
		tbLivros.getColumnModel().getColumn(2).setPreferredWidth(214);
		tbLivros.getColumnModel().getColumn(3).setPreferredWidth(109);
		tbLivros.setBounds(10, 98, 664, 273);
		contentPane.add(tbLivros);

		JButton btConsulta2 = new JButton("Consulta 2º caso");
		btConsulta2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btConsulta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// realiza consulta por autor em ordem crescente e titulo de livro em ordem
				// decrescente
				String consulta = "2";

				try {
					livrosConsultados = controlador.listarLivros(consulta);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				if (livrosConsultados != null) {
					atualizarTabelaSimulacoes(livrosConsultados);
				}
			}
		});
		btConsulta2.setBounds(137, 50, 114, 23);
		contentPane.add(btConsulta2);

		JButton btConsulta3 = new JButton("Consulta 3º caso");
		btConsulta3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btConsulta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// realiza consulta por ano de edicao em ordem decrescente, autor em ordem
				// decrescente e titulo de livro em ordem crescente
				String consulta = "3";

				try {
					livrosConsultados = controlador.listarLivros(consulta);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				if (livrosConsultados != null) {
					atualizarTabelaSimulacoes(livrosConsultados);
				}
			}
		});
		btConsulta3.setBounds(265, 50, 127, 23);
		contentPane.add(btConsulta3);

		JButton btConsultaNull = new JButton("Consulta Null");
		btConsultaNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// realiza consulta com erro e mostra mensagem de erro
				String consulta = "4";

				try {
					livrosConsultados = controlador.listarLivros(consulta);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro na consulta", JOptionPane.ERROR_MESSAGE);

				}

				if (livrosConsultados != null) {
					atualizarTabelaSimulacoes(livrosConsultados);
				}

			}
		});
		btConsultaNull.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btConsultaNull.setBounds(407, 50, 127, 23);
		contentPane.add(btConsultaNull);

		JButton btConsultaVazio = new JButton("Consulta Vazio");
		btConsultaVazio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// atualiza a tabela e a deixa sem dados para serem exibidos
				List<LivroVO> consultaVazia = new ArrayList<LivroVO>();
				atualizarTabelaSimulacoes(consultaVazia);
			}
		});
		btConsultaVazio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btConsultaVazio.setBounds(547, 50, 127, 23);
		contentPane.add(btConsultaVazio);
	}

	protected void atualizarTabelaSimulacoes(List<LivroVO> livros) {

		Object[][] header = new Object[][] { new String[] { "ID", "Titulo", "Autor", "Edição" } };
		String[] registros = new String[] { "ID", "Titulo", "Autor", "Edição" };

		tbLivros.setModel(new DefaultTableModel(header, registros));

		DefaultTableModel modelo = (DefaultTableModel) tbLivros.getModel();

		for (LivroVO livro : livros) {
			// Cria uma nova linha na tabela
			// Preenche a linha com os atributos do livro
			// na ORDEM do cabeçalho da tabela

			Object[] novaLinha = new Object[] { livro.getIdLivro(), livro.getTitulo(), livro.getAutor(),
					livro.getEdicao() };
			modelo.addRow(novaLinha);
		}

	}
}
