package com.app.pokemon;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import com.app.pokemon.pojos.PokemonDetailPOJO;
import com.app.pokemon.pojos.PokemonPOJO;
import com.app.pokemon.pojos.PokemonTypePOJO;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;

/**
 * Entry point class for starting the pokemon app
 * 
 * @author Mark GW + John R
 *
 */
public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JButton selectedPokemonType;
	private static PokemonTypeColors pokemonTypeColors = new PokemonTypeColors();

	/**
	 * gets the current selected pokemon type button
	 * 
	 * @return selected pokemon type button
	 */
	private static JButton getSelectedPokemonType() {
		return selectedPokemonType;
	}

	/**
	 * updates selected pokemon type
	 * 
	 * @param selectedPokemonType
	 */
	private static void setSelectedPokemonType(JButton selectedPokemonType) {
		Main.selectedPokemonType = selectedPokemonType;
	}

	/**
	 * updates which pokemon type is currently selected
	 * 
	 * @param selectedPokemonType
	 */
	public static void updateSelectedPokemonType(JButton selectedPokemonType) {
		String pokemonType = selectedPokemonType.getText().toLowerCase();

		String darkFont = "bugelectricgrassiceunknowngroundfairyfirepsychic";

		JButton previousSelectedPokemonType = getSelectedPokemonType();
		if (previousSelectedPokemonType != null) {
			previousSelectedPokemonType.setBackground(Color.BLACK);
			previousSelectedPokemonType.setForeground(Color.WHITE);
		}

		Color color = Color.LIGHT_GRAY;
		if (pokemonTypeColors.containsPokemonType(pokemonType)) {
			color = pokemonTypeColors.getPokemonTypeColor(pokemonType);
		}
		selectedPokemonType.setBackground(color);
		if (darkFont.contains(pokemonType)) {
			selectedPokemonType.setForeground(Color.BLACK);
		}

		setSelectedPokemonType(selectedPokemonType);
	}

	/**
	 * create and add pokemon type button to pokemon type container
	 * 
	 * @param pokemonType
	 * @param panel
	 * @param pokemonContainer
	 * @param sg
	 * @param graph
	 */
	public static void createPokemonTypeButton(String pokemonType, JPanel panel, final JPanel pokemonContainer,
			final PokemonAppSymbolGraph sg, final Graph graph) {
		JButton pokemonTypeButton = new JButton(pokemonType.substring(0, 1).toUpperCase() + pokemonType.substring(1));
		pokemonTypeButton.setBorderPainted(false);
		pokemonTypeButton.setOpaque(true);
		pokemonTypeButton.setBackground(Color.BLACK);
		pokemonTypeButton.setForeground(Color.WHITE);
		pokemonTypeButton.setFont(new Font("Constantia", Font.PLAIN, 20));
		String filePath = "/images/pt-" + pokemonType + ".png";
		pokemonTypeButton.setIcon(new ImageIcon(new ImageIcon(Main.class.getResource(filePath)).getImage()
				.getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
		pokemonTypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pokemonContainer.removeAll();
				JButton button = (JButton) e.getSource();
				updateSelectedPokemonType(button);
				String source = button.getText().toLowerCase();
				for (Integer pokemon : graph.adj(sg.indexOf(source))) {
					createPokemonButton(pokemonContainer, sg.nameOf(pokemon), sg);
				}
				pokemonContainer.repaint();
				pokemonContainer.revalidate();
			}
		});
		panel.add(pokemonTypeButton);
	}

	/**
	 * create and add pokemon button to pokemon container
	 * 
	 * @param panel
	 * @param pokemonName
	 * @param sg
	 */
	public static void createPokemonButton(JPanel panel, String pokemonName, final PokemonAppSymbolGraph sg) {
		JButton pokemonButton = new JButton(pokemonName);
		pokemonButton.setFont(new Font("Constantia", Font.PLAIN, 20));
		pokemonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				String source = button.getText();

				try {
					PokemonDetailPOJO pokemon = PokeApiHttpClient.getPokemonDetails(sg.getUrl(source));
					JPanel pokemonCard = new PokemonCard(pokemon);
					JOptionPane.showMessageDialog(null, pokemonCard, "Pokemon Details", JOptionPane.PLAIN_MESSAGE);
				} catch (IOException exc) {
					exc.printStackTrace();
				} catch (InterruptedException exc) {
					exc.printStackTrace();
				}
			}
		});
		panel.add(pokemonButton);
	}

	/**
	 * Create the ui root frame
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public Main(PokemonAppSymbolGraph sg) throws IOException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Color pokedex = new Color(206, 34, 17);
		UIManager.put("OptionPane.background", pokedex);
		UIManager.put("Panel.background", pokedex);

		// loading an image from a file
		final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		final java.net.URL imageResource = Main.class.getClassLoader().getResource("images/pokeball.png");
		final Image image = defaultToolkit.getImage(imageResource);

		// this is new since JDK 9
		final Taskbar taskbar = Taskbar.getTaskbar();

		try {
			// set icon for mac os (and other systems which do support this method)
			taskbar.setIconImage(image);
		} catch (final UnsupportedOperationException e) {
			System.out.println("The os does not support: 'taskbar.setIconImage'");
		} catch (final SecurityException e) {
			System.out.println("There was a security exception for: 'taskbar.setIconImage'");
		}

		// set icon for windows os (and other systems which do support this method)
		setIconImage(image);

		setBounds(0, 0, 1400, 800);
		setTitle("Pokemon App");
		setLocationRelativeTo(null);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel pokemonTypeContainer = new JPanel();
		pokemonTypeContainer.setLayout(new GridLayout(3, 0, 5, 5));
		pokemonTypeContainer.setBackground(Color.BLACK);

		JPanel pokemonContainer = new JPanel();
		pokemonContainer.setLayout(new GridLayout(0, 4, 0, 0));
		pokemonContainer.setBackground(Color.BLACK);

		PokemonTypePOJO[] pokemonTypes = PokeApiHttpClient.getAllPokemonTypes();
		Graph pokemonGraph = sg.graph();
		for (PokemonTypePOJO pokemonType : pokemonTypes) {
			createPokemonTypeButton(pokemonType.getName(), pokemonTypeContainer, pokemonContainer, sg, pokemonGraph);
		}

		PokemonPOJO[] allPokemon = PokeApiHttpClient.getAllPokemon();
		for (PokemonPOJO pokemon : allPokemon) {
			createPokemonButton(pokemonContainer, pokemon.getName(), sg);
		}

		JScrollPane jsp = new JScrollPane(pokemonContainer, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.getVerticalScrollBar().setUnitIncrement(16);

		contentPane.add(pokemonTypeContainer);
		contentPane.add(jsp);
	}

	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Fetching required resources...");
		int BILLION = 1000000000;

		long start = System.nanoTime();
		final PokemonAppSymbolGraph sg = new PokemonAppSymbolGraph();
		double elapsedTime = System.nanoTime() - start;
		StdOut.printf("Backend build time: %.2fs %n", elapsedTime / BILLION);

		System.out.println("Initializing App UI...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(sg);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}