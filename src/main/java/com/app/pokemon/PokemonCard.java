package com.app.pokemon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.app.pokemon.pojos.KeyAbilitiesPOJO;
import com.app.pokemon.pojos.KeyMovesPOJO;
import com.app.pokemon.pojos.PokemonDetailPOJO;
import com.app.pokemon.pojos.StatsPOJO;
import com.app.pokemon.pojos.TypeMetadataPOJO;

/**
 * UI for displaying pokemon details on a card
 * 
 * @author John R + Mark GW
 *
 */
@SuppressWarnings("serial")
public class PokemonCard extends JPanel {
	private static final ImageIcon DEFAULT_POKEMON_IMAGE = new ImageIcon(
			new ImageIcon(PokemonCard.class.getResource("/images/unknown-pokemon.png")).getImage()
					.getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	private static final Color POKEDEX_INNER_CLASSIC = Color.LIGHT_GRAY;

	/**
	 * formats string of pokemon types for the pokemon
	 * 
	 * @param pokemon pojo that contains all the details on the pokemon
	 * @return formatted string of the pokemon's type/s
	 */
	private static String getTypes(PokemonDetailPOJO pokemon) {
		StringBuilder typeSb = new StringBuilder().append("\n  ");

		for (TypeMetadataPOJO typeMetadata : pokemon.getTypes()) {
			typeSb.append(typeMetadata.getType().getName() + "\n  ");
		}

		return typeSb.toString();
	}

	/**
	 * formats string of abilities for the pokemon
	 * 
	 * @param pokemon pojo that contains all the details on the pokemon
	 * @return formatted string of pokemon's abilities
	 */
	private static String getAbilities(PokemonDetailPOJO pokemon) {
		StringBuilder abilitiesSb = new StringBuilder().append("\n  ");

		for (KeyAbilitiesPOJO keyAbilities : pokemon.getAbilities()) {
			abilitiesSb.append(keyAbilities.getAbility().getName() + "\n  ");
		}

		return abilitiesSb.toString();
	}

	/**
	 * formats string of the pokemon's moves
	 * 
	 * @param pokemon pojo that contains all the details on the pokemon
	 * @return formatted string of pokemon's moves
	 */
	private static String getMoves(PokemonDetailPOJO pokemon) {
		StringBuilder movesSb = new StringBuilder().append("\n  ");

		for (KeyMovesPOJO keyMoves : pokemon.getMoves()) {
			movesSb.append(keyMoves.getMove().getName() + "\n  ");
		}

		return movesSb.toString();
	}

	/**
	 * formats string of pokemon's stats
	 * 
	 * @param pokemon pojo that contains all the details on the pokemon
	 * @return formatted string of pokemon's stats
	 */
	private static String getStats(PokemonDetailPOJO pokemon) {
		StringBuilder statsSb = new StringBuilder().append("\n  ");

		for (StatsPOJO stats : pokemon.getStats()) {
			statsSb.append(stats.getStat().getName() + " (" + stats.getBase_stat() + ")" + "\n  ");
		}

		return statsSb.toString();
	}

	/**
	 * formats string of all the details on a pokemon
	 * 
	 * @param pokemon pojo that contains all the details on the pokemon
	 * @return formatted string of pokemon details
	 */
	public static String getPokemonDetails(PokemonDetailPOJO pokemon) {
		return String.format("Height: %sin %n%nWeight: %slbs %n%nStats: %s %nTypes: %s %nAbilities: %s %nMoves: %s %n",
				pokemon.getHeight(), pokemon.getWeight(), getStats(pokemon), getTypes(pokemon), getAbilities(pokemon),
				getMoves(pokemon)).toString();
	}

	/**
	 * Creates the pokemon card with pokemon details
	 * 
	 * @throws IOException
	 */
	PokemonCard(PokemonDetailPOJO pokemon) throws IOException {
		setOpaque(false);
		JPanel frame = new JPanel();
		frame.setLayout(null);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setBackground(POKEDEX_INNER_CLASSIC);
		frame.setVisible(true);

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, -50, 600, 250);
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		if (pokemon.getSprites().getFront_default() != null) {
			URL url = new URL(pokemon.getSprites().getFront_default());
			Image pokemonImage = ImageIO.read(url);
			imageLabel.setIcon(new ImageIcon(pokemonImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		} else {
			imageLabel.setIcon(DEFAULT_POKEMON_IMAGE);
		}

		JTextField pokemonName = new JTextField(
				pokemon.getName().substring(0, 1).toUpperCase() + pokemon.getName().substring(1));
		pokemonName.setHorizontalAlignment(JTextField.CENTER);
		pokemonName.setOpaque(false);
		pokemonName.setBackground(POKEDEX_INNER_CLASSIC);
		pokemonName.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
		pokemonName.setEditable(false);
		pokemonName.setBounds(0, 150, 600, 30);

		JTextArea pokemonDetails = new JTextArea();
		pokemonDetails.setOpaque(true);
		pokemonDetails.setEditable(false);
		pokemonDetails.setLineWrap(true);
		pokemonDetails.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		pokemonDetails.setBackground(POKEDEX_INNER_CLASSIC);
		String formattedPokemonDetails = getPokemonDetails(pokemon);
		pokemonDetails.setText(formattedPokemonDetails);
		pokemonDetails.setCaretPosition(0);

		JScrollPane jsp = new JScrollPane(pokemonDetails, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(0, 200, 600, 350);

		frame.add(imageLabel);
		frame.add(pokemonName);
		frame.add(jsp);
		add(frame);
	}
}
